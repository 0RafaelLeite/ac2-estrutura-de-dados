package com.ac2.facens.utils.tree;

import com.ac2.facens.model.StudentModel;

class NodeTree {
    long key;
    StudentModel student;
    NodeTree left, right;

    public NodeTree(StudentModel value) {
        key = value.getId();
        student = value;
        left = right = null;
    }
}