package com.ac2.facens.utils.tree;

import com.ac2.facens.model.StudentModel;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<StudentModel> search(long key) {
        return searchRec(root, key);
    }

    private Optional<StudentModel> searchRec(NodeTree root, long key) {
        if (root == null) {
            return Optional.empty();
        }

        if (key == root.key) {
            return Optional.of(root.student);
        }
        if (key < root.key) {
            return searchRec(root.left, key);
        } else {
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

    public void reorganize() {
        List<NodeTree> nodes = new ArrayList<>();
        storeInorderRec(root, nodes);
        root = buildTree(nodes, 0, nodes.size() - 1);
    }

    private void storeInorderRec(NodeTree node, List<NodeTree> nodes) {
        if (node == null) {
            return;
        }
        storeInorderRec(node.left, nodes);
        nodes.add(node);
        storeInorderRec(node.right, nodes);
    }

    private NodeTree buildTree(List<NodeTree> nodes, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        NodeTree node = nodes.get(mid);

        node.left = buildTree(nodes, start, mid - 1);
        node.right = buildTree(nodes, mid + 1, end);

        return node;
    }

    public void delete(long key) {
        root = deleteRec(root, key);
    }

    private NodeTree deleteRec(NodeTree root, long key) {
        if (root == null) {
            return null;
        }

        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.key = minValue(root.right);

            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    private long minValue(NodeTree root) {
        long minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    public List<StudentModel> getAllStudents() {
        List<StudentModel> students = new ArrayList<>();
        getAllStudentsRec(root, students);
        return students;
    }

    private void getAllStudentsRec(NodeTree root, List<StudentModel> students) {
        if (root != null) {
            getAllStudentsRec(root.left, students);
            students.add(root.student);
            getAllStudentsRec(root.right, students);
        }
    }
}
