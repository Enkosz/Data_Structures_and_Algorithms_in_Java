package com.base.chapter3.singlylinkedlist;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T first() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        return head.getData();
    }

    public T last() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        return tail.getData();
    }

    public void addFirst(T item) {
        if (isEmpty()) {
            head = new Node<T>(item, tail);
            tail = head;
        } else {
            Node<T> newNode = new Node<>(item, head);

            head = newNode;
        }

        size++;
    }

    public void addLast(T item) {
        if (isEmpty()) {
            head = new Node<T>(item, tail);
            tail = head;
        } else {
            Node<T> newNode = new Node<>(item);
            tail.setNext(newNode);
            tail = newNode;
        }

        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        Node<T> returnNode = head;

        head = head.getNext();
        size--;

        return returnNode.getData();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addFirst(5);
        linkedList.addFirst(4);
        linkedList.addFirst(3);
        linkedList.addFirst(2);
        linkedList.addFirst(1);

        linkedList.addLast(6);

        System.out.println(linkedList.removeFirst());
    }
}
