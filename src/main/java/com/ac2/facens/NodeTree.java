package com.ac2.facens;

class NodeTree {
    int key;
    NodeTree left, right;

    public NodeTree(int item) {
        key = item;
        left = right = null;
    }
}