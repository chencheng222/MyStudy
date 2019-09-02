package com.cc.study.datastructure.btree;

/**
 * 二叉树结构
 *
 * @author Administrator
 */
public interface BinaryTree {
    /**
     * 是否空树
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 树节点数量
     *
     * @return
     */
    int size();

    /**
     * 树高度
     *
     * @return
     */
    int getHeight();

    /**
     * 查询指定值得节点
     *
     * @param value
     * @return
     */
    Node findKey(int value);

    /**
     * 前序遍历递归DLR
     */
    void preOrderTraverse();

    /**
     * 中序遍历递归LDR
     */
    void inOrderTraverse();

    /**
     * 后序遍历递归
     */
    void postOrderTraverse();

    /**
     * 后序遍历递归操作
     * @param node 树根
     */
    void postOrderTraverse(Node node);

    /**
     * 中序遍历非递归操作
     */
    void inOrderByStack();

    /**
     * 前序遍历非递归操作
     */
    void preOrderByStack();

    /**
     * 后序遍历非递归操作
     */
    void postOrderByStack();

    /**
     * 按照层次遍历二叉树
     */
    void levelOrderByStack();
}


