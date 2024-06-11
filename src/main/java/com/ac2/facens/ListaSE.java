package com.ac2.facens;

public class ListaSE {
    private Node head; // Cabeça da lista

    public ListaSE() {
        this.head = null;
    }

    public void insert(int data) {
        // Insere um nó no início da lista.
        Node new_node = new Node(data);
        new_node.next = this.head;
        this.head = new_node;
    }

    public boolean remove(int data) {
        // Remove um nó da lista pelo valor.
        Node current = this.head;
        Node prev = null;
        while (current != null) {
            if (current.value == data) {
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

    public void display() {
        // Exibe os elementos da lista.
        Node current = this.head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("None");
    }
}