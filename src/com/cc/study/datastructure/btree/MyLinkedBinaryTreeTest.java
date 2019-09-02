package com.cc.study.datastructure.btree;

import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;

public class MyLinkedBinaryTreeTest {

    private BinaryTree binaryTree;

    @org.junit.Before
    public void setUp() throws Exception {
        // 创建一棵树
        /**
         *          1
         *        /   \
         *       4     2
         *       \    / \
         *       5   3   6
         *                \
         *                7
         */
        Node node5 = new Node(5, null, null);
        Node node4 = new Node(4, null, node5);

        Node node7 = new Node(7, null, null);
        Node node6 = new Node(6, null, node7);
        Node node3 = new Node(3, null, null);
        Node node2 = new Node(2, node3, node6);

        Node node1 = new Node(1, node4, node2);
        // 创建二叉树
        binaryTree = new MyLinkedBinaryTree(node1);

    }

    @org.junit.Test
    public void isEmpty() {
    }

    @org.junit.Test
    public void size() {
        Assert.assertThat(binaryTree.size(), is(7));
    }

    @org.junit.Test
    public void getHeight() {
        Assert.assertThat(binaryTree.getHeight(), is(4));
    }

    @org.junit.Test
    public void findKey() {
    }

    @org.junit.Test
    public void preOrderTraverse() {
        // 先序遍历 1 4 5 2 3 6 7
        binaryTree.preOrderTraverse();
    }

    @org.junit.Test
    public void inOrderTraverse() {
        // 中序遍历 4 5 1 3 2 6 7
        binaryTree.inOrderTraverse();
    }

    @org.junit.Test
    public void postOrderTraverse() {
        // 后序遍历 5 4 3 7 6 2 1
        binaryTree.postOrderTraverse();
    }

    @org.junit.Test
    public void postOrderTraverse1() {
    }

    @org.junit.Test
    public void inOrderByStack() {
    }

    @org.junit.Test
    public void preOrderByStack() {
    }

    @org.junit.Test
    public void postOrderByStack() {
    }

    @org.junit.Test
    public void levelOrderByStack() {
    }
}