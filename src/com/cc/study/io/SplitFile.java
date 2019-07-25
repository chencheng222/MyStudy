package com.cc.study.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件的分割操作
 *
 */
public class SplitFile {

    // 文件的路径
    private String filePath;
    // 文件名
    private String fileName;
    // 分割的块数
    private int blockNum;
    // 每块的大小
    private long blockSize;
    // 文件的大小
    private long length;
    // 分割的文件名
    private List<String> filePartNames;

    public SplitFile() {
        filePartNames = new ArrayList<String>();
    }

    public SplitFile(String filePath) {
        this(filePath, 1024);
    }

    public SplitFile(String filePath, long blockSize) {
        this();
        this.filePath = filePath;
        this.blockSize = blockSize;
        init();
    }

    /**
     * 初始化操作
     */
    private void init() {
        File src = null;
        if(filePath == null || !((src = new File(filePath)).exists())) {
            return;
        }

        if (src.isDirectory()) {
            return;
        }

        length = src.length();
        fileName = src.getName();
        if (length < blockSize) {
            blockSize = length;
        }

        blockNum = (int) Math.ceil(length * 1.0/blockSize);

    }

    private void initFilePartName(String destPath) {
        for (int i = 0; i < blockSize; i++) {
            this.filePartNames.add(destPath + "/" + fileName + ".part" + i);
        }
    }

    private void split(String destPath) {
        initFilePartName(destPath);

        // 起始位置
        long beginPos = 0;
        // 实际存储的大小
        long auactualBlockSize = this.blockSize;

        for (int i = 0; i < blockNum; i++) {
            if (i == blockNum - 1) {
                auactualBlockSize = this.length - beginPos;
            }
            this.splitDetail(i, beginPos, auactualBlockSize);
            beginPos += auactualBlockSize;
        }
    }

    private void splitDetail(int idx, long beginPos, long actualBlockSize) {
        // 1.创建源
        File srcFile = new File(this.filePath);
        File destFile = new File(this.filePartNames.get(idx));

        // 2.选择流
        RandomAccessFile raf = null;
        BufferedOutputStream bos = null;

        try {
            raf = new RandomAccessFile(srcFile, "r");
            bos = new BufferedOutputStream(new FileOutputStream(destFile));

            raf.seek(beginPos);
            // 文件拷贝操作
            byte[] flush = new byte[1024];
            int len = 0;
            while (-1 != (len = raf.read(flush))) {
                if (actualBlockSize >= len) {
                    bos.write(flush, 0, len);
                    actualBlockSize -= len;
                } else {
                    bos.write(flush, 0, (int) actualBlockSize);
                    break;
                }
            }
            bos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
                if (raf != null) {
                    raf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
