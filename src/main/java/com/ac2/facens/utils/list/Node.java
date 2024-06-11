package com.ac2.facens.utils.list;

import com.ac2.facens.model.SubjectModel;

public class Node {
    long value;
    Node next;
    Node prev;
    String subject;

    public Node(SubjectModel subject) {
        this.value = subject.getId();
        this.subject = subject.getName();
        this.next = null;
        this.prev = null;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}