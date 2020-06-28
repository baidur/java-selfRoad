package com.example.demo.list;

import java.util.Objects;

public class Node<E> {

    private Node<E> prod;
    private E item;
    private Node<E> next;

    public Node() {
    }

    public Node(Node<E> prod, E item, Node<E> next) {
        this.prod = prod;
        this.item = item;
        this.next = next;
    }

    public Node<E> getProd() {
        return prod;
    }

    public void setProd(Node<E> prod) {
        this.prod = prod;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(prod, node.prod) &&
                Objects.equals(item, node.item) &&
                Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prod, item, next);
    }

    @Override
    public String toString() {
        return "Node{" +

                ", item=" + item +

                '}';
    }
}
