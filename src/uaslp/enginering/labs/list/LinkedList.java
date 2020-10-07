package uaslp.enginering.labs.list;


import uaslp.enginering.labs.list.model.Lists;

public class LinkedList extends Lists {
    private Node front;
    private Node tail;
    private int size;

    public enum InsertPosition {
        BEFORE,
        AFTER
    }

    public class Iterator {
        public Node currentNode;

        public Iterator() {
            this.currentNode = front;
        }

        public boolean hasNext() {
            return currentNode != null;
        }

        public Student next() {

            if(currentNode == null){
                return null;
            }

            Student currentStudent = currentNode.getStudent();

            currentNode = currentNode.getNext();

            return currentStudent;
        }
    }

    public Node getFront() {
        return front;
    }

    public void setFront(Node front) {
        this.front = front;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public void add(Student student) {
        Node newNode = new Node(student);

        if (size == 0) {
            front = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }

        size++;

    }

    @Override
    public void delete(int index) {

        if (index < 0 || index >= size) {
            return;
        }


        Node currentNode = front;

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

    public Student getAt(int index) {
        Node currentNode = front;

        for (int counter = 0; counter < index && counter < size; counter++) {
            currentNode = currentNode.getNext();
        }

        return currentNode != null ? currentNode.getStudent() : null;
    }

    @Override
    public void insert(Student reference,Student newStudent, Lists.InsertPosition InsertPosition) {

        if (size == 0) {
            return;
        }

        Node currentNode = front;

        while (!currentNode.getStudent().equals(reference)) {
            currentNode = currentNode.getNext();
        }

        if (currentNode == null) {
            return;
        }

        Node newNode = new Node(newStudent);

        if (InsertPosition.BEFORE.equals(InsertPosition)) {
            Node previous = currentNode.getPrevious();
            newNode.setNext(currentNode);
            newNode.setPrevious(previous);
            currentNode.setPrevious(newNode);
            if (front == currentNode) {
                front = newNode;
            } else {
                previous.setNext(newNode);
            }
        } else {
            Node next = currentNode.getNext();
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


