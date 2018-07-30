package com.datastructure;

public class LinkedListNode {
    int nodeValue;
    LinkedListNode nextNode;

    // create empty node ( header node)
    public LinkedListNode() {
        this.nextNode = null;
    }

    // create node with value
    public LinkedListNode(int nodeValue) {
        this.nodeValue = nodeValue;
        this.nextNode = null;
    }

    public int getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(int nodeValue) {
        this.nodeValue = nodeValue;
    }

    public LinkedListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(LinkedListNode nextNode) {
        this.nextNode = nextNode;
    }
}
