package com.cc.study.datastructure.btree;

/**
 * @author chenc
 * @create 2019-09-02 20:57
 **/
public class MyLinkedBinaryTree implements BinaryTree {

    private Node root;

    public MyLinkedBinaryTree() {
    }

    public MyLinkedBinaryTree(Node root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return this.getSize(root);
    }

    private int getSize(Node root) {
        if (root == null) {
            return 0;
        }

        int ls = this.getSize(root.leftChild);
        int rs = this.getSize(root.rightChild);

        return ls + rs + 1;
    }

    @Override
    public int getHeight() {
        return this.getHight(root);
    }

    private int getHight(Node root) {
        if (root == null) {
            return 0;
        }
        // 1.获取左子树高度
        int nl = this.getHight(root.leftChild);

        // 2.获得右子树高度
        int nr = this.getHight(root.rightChild);

        // 3.取得左,右中较大的那个
        return nl > nr ? nl+1 : nr+1;
    }

    @Override
    public Node findKey(int value) {
        return null;
    }

    @Override
    public void preOrderTraverse() {
        if (root == null) {
            return;
        }
        // 1.找到树根
        System.out.print(root.value + " ");

        // 2.遍历左子树
        BinaryTree leftTree = new MyLinkedBinaryTree(root.leftChild);
        leftTree.preOrderTraverse();

        // 3.遍历右子树
        BinaryTree rightTree = new MyLinkedBinaryTree(root.rightChild);
        rightTree.preOrderTraverse();

    }

    @Override
    public void inOrderTraverse() {
        if (root == null) {
            return;
        }

        // 1.遍历左子树
        BinaryTree leftTree = new MyLinkedBinaryTree(root.leftChild);
        leftTree.inOrderTraverse();

        // 2.获得根节点
        System.out.print(root.value + "  ");

        // 3.遍历右子树
        BinaryTree rightTree = new MyLinkedBinaryTree(root.rightChild);
        rightTree.inOrderTraverse();

    }

    @Override
    public void postOrderTraverse() {
        if (root == null) {
            return;
        }

        // 1.遍历左子树
        BinaryTree leftTree = new MyLinkedBinaryTree(root.leftChild);
        leftTree.postOrderTraverse();

        // 2.遍历右子树
        BinaryTree rightTree = new MyLinkedBinaryTree(root.rightChild);
        rightTree.postOrderTraverse();

        // 3.获得根节点
        System.out.print(root.value + "  ");
    }

    @Override
    public void postOrderTraverse(Node node) {

    }

    @Override
    public void inOrderByStack() {

    }

    @Override
    public void preOrderByStack() {

    }

    @Override
    public void postOrderByStack() {

    }

    @Override
    public void levelOrderByStack() {

    }
}
