package uaslp.enginering.labs.list;

public class Node  {
    private Student element;
    private Node previous;
    private Node next;


    public Node(Student element) {
        this.element = element;
    }

    public void setElement(Student element) {
        this.element = element;
    }

    public Student getElement() {
        return element;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getPrevious() {
        return previous;
    }


    public void setNext(Node next){
        this.next=next;
    }

    public Node getNext(){
        return next;
    }

    public Student getStudent() {
        return element;
    }
}
