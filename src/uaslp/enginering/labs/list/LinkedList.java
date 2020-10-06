package uaslp.enginering.labs.list;


import uaslp.enginering.labs.list.model.Lists;
import uaslp.enginering.labs.list.model.Object;

import java.util.Objects;


public class LinkedList<T> extends Lists<T> {
    private Node<T> front;
    private Node<T> tail;
    private int size;

    public enum InsertPosition {
        BEFORE,
        AFTER
    }

    public class Iterator {
        public Node<T> currentNode;

        public Iterator() {
            this.currentNode = front;
        }

        public boolean hasNext() {
            return currentNode != null;
        }

        public Object next() {

            if(currentNode == null){
                return null;
            }

            Object currentObject = currentNode.getElement();

            currentNode = currentNode.getNext();

            return currentObject;
        }
    }

    public Node<T> getFront() {
        return front;
    }

    public void setFront(Node<T> front) {
        this.front = front;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    @Override
    public void add(java.lang.Object element) {
        Node<T> newNode = new Node<T>(element);

        if (size == 0) {
            front = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }

        size++;
    }

   

    public void delete(int index) {

        if (index < 0 || index >= size) {
            return;
        }


        Node<T> currentNode = front;

        for (int counter = 0; counter < index && counter < size; counter++) {
            currentNode = currentNode.getNext();
        }

        if (currentNode == front && currentNode == tail) {
            front = null;
            tail = null;
        } else if (currentNode == front) {
            front = currentNode.getNext();
            front.setPrevious(null);
        } else if (currentNode == tail) {
            tail = currentNode.getPrevious();
            tail.setNext(null);
        } else {
            currentNode.getPrevious().setNext(currentNode.getNext());
            currentNode.getNext().setPrevious(currentNode.getPrevious());
        }
        size--;
    }

    public Iterator getIterator() {
        return new Iterator();
    }

    public int size() {
        return size;
    }

    public Object getAt(int index) {
        Node<T> currentNode = front;

        for (int counter = 0; counter < index && counter < size; counter++) {
            currentNode = currentNode.getNext();
        }

        return currentNode != null ? currentNode.getElement() : null;
    }

    @Override
    public void insert(java.lang.Object reference, java.lang.Object newElement, Lists.InsertPosition position) {
        if (size == 0) {
            return;
        }

        Node<T> currentNode = front;

        while (!Objects.equals(currentNode.getElement(), reference)) {
            currentNode = currentNode.getNext();
        }

        if (currentNode == null) {
            return;
        }

        Node<T> newNode = new Node<T>(newElement);

        if (Lists.InsertPosition.BEFORE.equals(position)) {
            Node<T> previous = currentNode.getPrevious();
            newNode.setNext(currentNode);
            newNode.setPrevious(previous);
            currentNode.setPrevious(newNode);
            if (front == currentNode) {
                front = newNode;
            } else {
                previous.setNext(newNode);
            }
        } else {
            Node<T> next = currentNode.getNext();
            newNode.setPrevious(currentNode);
            newNode.setNext(next);
            currentNode.setNext(newNode);
            if (tail == currentNode) {
                tail = newNode;
            } else {
                next.setPrevious(newNode);
            }
        }

        size++;
    }

}