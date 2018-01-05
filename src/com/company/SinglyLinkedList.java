package com.company;

public class SinglyLinkedList {
    Node head;
    Node tail;

    public SinglyLinkedList(Node head) { this.head = head; }

    public static class Node {
        public String value;
        public Node pointer = null;

        public Node(String value) {
            this.value = value;
        }
    }

    public void push(Node node) {
        if (head.pointer == null) {
            head.pointer = node;
        } else {
            Node next = head.pointer;
            while (next.pointer != null) {
                next = next.pointer;
            }
            next.pointer = node;
        }
        tail = node;
    }

    //if current has a pointer
    //1. create temp 'next' node to reverse later, which is the current node's pointer
    //      Node next = current.pointer
    //2. After storing current pointer, reverse by making its pointer the previous node
    //      current.pointer = previous node
    //3. Previous node now transformed to the current node
    //   now alter the previous node variable to be the current node
    //        previous = current
    //4. Repeat process with the temp 'next' variable stored at first
    //          current = next
    public Node reverse() {
        if (head.pointer == null) {
            return head;
        }
        tail = head;
        Node current = head;
        Node next;
        Node previous = null;
        while (current.pointer != null) {
            next = current.pointer;
            current.pointer = previous;
            previous = current;
            current = next;
        }
        head = current;
        return head;
    }

    public void printValues() {
        Node current = head;
        while (current.pointer != null) {
            System.out.println(current.value);
            current = current.pointer;
        }
        System.out.println(current.value);
    }
}
