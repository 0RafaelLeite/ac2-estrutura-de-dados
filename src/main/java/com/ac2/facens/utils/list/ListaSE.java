package com.ac2.facens.utils.list;

import com.ac2.facens.model.SubjectModel;

public class ListaSE {
    Node head; // Cabeça da lista
    SubjectModel subjectList;

    public ListaSE() {
        this.head = null;
    }

    public void insert(SubjectModel data) {
        // Insere um nó no início da lista.
        Node new_node = new Node(data);
        new_node.next = this.head;
        this.head = new_node;
    }

    public void insert(long id) {
        //subjectList
    }

    public boolean remove(long id) {
        // Remove um nó da lista pelo valor.
        Node current = this.head;
        Node prev = null;
        while (current != null) {
            if (current.value == id) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    this.head = current.next;
                }
                return true; // Dado encontrado e removido
            }
            prev = current;
            current = current.next;
        }
        return false; // Dado não encontrado
    }

    public int size(){
        int count = 0;
        Node current = this.head;
        while (current != null) {
            count+=1;
            current = current.next;
        }
        return count;
    }

    public void display() {
        // Exibe os elementos da lista.
        Node current = this.head;
        while (current != null) {
            System.out.print(current.subject + " -> ");
            current = current.next;
        }
        System.out.println("None");
    }
}