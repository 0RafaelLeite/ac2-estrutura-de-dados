package com.ac2.facens;

public class BinaryTree {
    NodeTree root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private NodeTree insertRec(NodeTree root, int key) {
        if (root == null) {
            root = new NodeTree(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(NodeTree root, int key) {
        if (root == null) {
            return false;
        }

        if (key == root.key) {
            return true;
        }
        if(key < root.key )
        {
            return searchRec(root.left, key);
        }
        else{
            return searchRec(root.right, key);
        }
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(NodeTree root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }
}
