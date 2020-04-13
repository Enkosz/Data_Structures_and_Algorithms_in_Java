package com.base.chapter3.doublylinkedlist;

public class DoublyLinkedList<T> {
    private static class Node<T> {
        private T item;
        private Node<T> next;
        private Node<T> prev;

        public Node(T item) {
            this.item = item;
            this.next = null;
            this.prev = null;
        }

        public Node(T item, Node<T> next, Node<T> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }

    private Node<T> header;
    private Node<T> trailer;
    private int size;

    public DoublyLinkedList() {
        this.header = new Node<>(null, null ,null);
        this.trailer = new Node<>(null, null, header);

        this.header.setNext(trailer);
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T first() {
        if (isEmpty()) return null;

        return this.header.getNext().getItem();
    }

    public T last() {
        if (isEmpty()) return null;

        return this.trailer.getPrev().getItem();
    }

    public void addFirst(T item) {
        addBetween(item, this.header.getNext(), this.header);
    }

    public void addLast(T item) {
        addBetween(item, this.trailer.getPrev(), this.trailer);
    }

    public T removeFirst() {
        if (isEmpty()) return null;

        return remove(header.getNext());
    }

    public T removeLast() {
        if (isEmpty()) return null;

        return remove(trailer.getPrev());
    }

    private void addBetween(T item, Node<T> successor, Node<T> predecessor) {
        Node<T> newNode = new Node<>(item, successor, predecessor);

        successor.setPrev(newNode);
        predecessor.setNext(newNode);
        size++;
    }

    private T remove(Node<T> node) {
        Node<T> predecessor = node.getPrev();
        Node<T> successor = node.getNext();

        predecessor.setNext(successor);
        successor.setPrev(predecessor);

        size--;

        return node.getItem();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

        doublyLinkedList.addFirst(5);
        doublyLinkedList.addFirst(4);
        doublyLinkedList.addFirst(3);
        doublyLinkedList.addFirst(2);
        doublyLinkedList.addFirst(1);

        doublyLinkedList.addLast(6);

        System.out.println(doublyLinkedList.removeFirst());
    }
}
