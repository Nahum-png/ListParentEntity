package uaslp.enginering.labs.list;

public class LinkedList {
    private Node front;
    private Node tail;
    private int count;

    public enum InsertPosition {
        BEFORE,
        AFTER
    }

    public class Iterator {
        public Node currentNode;

        public Iterator(){
            this.currentNode = front;
        }

        public Node method(Node node) {
            return node;
        }

        public boolean hasNext() {
            return currentNode != null;
        }

        public Student next() {
            if(currentNode ==null)
                return null;

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

        newNode.setStudent(student);

        if (count == 0) {
            front = newNode;
            tail = newNode;
        } else {
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
        }


        count++;

    }

    public void delete(Student student) {

    }

    public void delete(int index) {
        Node temporaryNode = front;

        if (count == 0) {
            return;
        }else if(index < 0 || index >= count){
            return;
        }


        if (front == tail) {
            front = null;
            tail = null;
        } else if (index == 0){
            front = front.getNext();
            front.setPrevious(null);
        }else if (index == count - 1){
            tail = tail.getPrevious();
            tail.setNext(null);
        }else{
            temporaryNode = front;
            for ( int i = 0; i != index ; i++ , temporaryNode = temporaryNode.getNext() );
            front.setNext(tail);
            tail.setPrevious(front);
            temporaryNode = null;
        }

        count--;
    }

    public Iterator getIterator() {
        return new Iterator();
    }

    public int size() {
        return count;
    }

    public Student getAt(int index) {
        Node iteratorNode = front;
        int countIterator = 0;
        while (countIterator < index && iteratorNode.getNext() != null) {
            iteratorNode = iteratorNode.getNext();
            countIterator++;
        }
        return iteratorNode.getStudent();
    }

    public void insert(Student reference, Student newStudent, InsertPosition insertPosition) {
        if(count==0)
            return;

        Node currentNode = front;

        while(!currentNode.getStudent().equals(reference)){
            currentNode = currentNode.getNext();
        }

        Node newNode = new Node(newStudent);

        if(InsertPosition.BEFORE.equals(insertPosition)){

            Node previous = currentNode.getPrevious();
            newNode.setNext(currentNode);
            newNode.setPrevious(previous);
            currentNode.setPrevious(newNode);

            if(front == currentNode){
                front=newNode;
            }else{
                previous.setNext(newNode);
            }

        }else{
            Node next =currentNode.getNext();
            newNode.setPrevious(currentNode);
            newNode.setNext(next);
            currentNode.setNext(newNode);

            if(tail == currentNode){
                tail = newNode;
            }else{
                next.setPrevious(newNode);
            }
        }

        count ++;

    }
}
