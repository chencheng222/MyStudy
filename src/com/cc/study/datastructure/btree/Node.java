package com.cc.study.datastructure.btree;

/**
 * @author chenc
 * @create 2019-08-29 22:52
 **/
public class Node {

    public Object value;

    public Node leftChild;

    public Node rightChild;

    public Node() {
    }

    public Node(Object value) {
        this.value = value;
    }

    public Node(Object value, Node leftChild, Node rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
