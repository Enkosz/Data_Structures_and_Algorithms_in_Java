package com.base.chapter3.circularlylinkedlist;

import com.base.chapter3.singlylinkedlist.LinkedList;
import com.base.chapter3.singlylinkedlist.Node;

public class CircularlyLinkedList<T> {
    private Node<T> tail;
    private int size;

    public CircularlyLinkedList() {
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T last() {
        if (isEmpty()) return null;

        return tail.getData();
    }

    public void rotate() {
        if (tail != null)
            tail = tail.getNext();
    }

    public void addFirst(T item) {
        if (isEmpty()) {
            tail = new Node<>(item);
            tail.setNext(tail);
        } else {
            Node<T> newNode = new Node<>(item, tail.getNext());

            tail.setNext(newNode);
        }

        size++;
    }

    public void addLast(T item) {
        if (isEmpty()) {
            tail = new Node<>(item);
            tail.setNext(tail);
        } else {
            Node<T> newNode = new Node<>(item, tail.getNext());

            tail.setNext(newNode);
            tail = newNode;
        }

        size++;
    }

    public T removeFirst() {
        if (isEmpty()) return null;

        Node<T> head = tail.getNext();

        if (head == tail) tail = null;
        else tail.setNext(head.getNext());

        size--;

        return head.getData();
    }

    public static void main(String[] args) {
        CircularlyLinkedList<Integer> linkedList = new CircularlyLinkedList<>();

        linkedList.addFirst(5);
        linkedList.addFirst(4);
        linkedList.addFirst(3);
        linkedList.addFirst(2);
        linkedList.addFirst(1);

        linkedList.addLast(6);

        System.out.println(linkedList.removeFirst());
    }
}
