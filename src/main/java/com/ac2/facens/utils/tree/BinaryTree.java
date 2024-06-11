package com.ac2.facens.utils.tree;

import com.ac2.facens.model.StudentModel;
import org.springframework.stereotype.Component;

@Component
public class BinaryTree {
    NodeTree root;

    public BinaryTree() {
        root = null;
    }

    public void insert(StudentModel student) {
        root = insertRec(root, student);
    }

    private NodeTree insertRec(NodeTree root, StudentModel student) {
        if (root == null) {
            root = new NodeTree(student);
            return root;
        }

        if (student.getId() < root.key) {
            root.left = insertRec(root.left, student);
        } else if (student.getId() > root.key) {
            root.right = insertRec(root.right, student);
        }

        return root;
    }

    public boolean search(long key) {
        return searchRec(root, key);
    }

    private boolean searchRec(NodeTree root, long key) {
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
