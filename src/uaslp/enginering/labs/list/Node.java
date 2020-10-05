
package uaslp.enginering.labs.list;

import uaslp.enginering.labs.list.model.Object;


public class Node<T> {
    private Object element;
    private Node previous;
    private Node next;


    public Node(java.lang.Object element) {
        this.element = this.element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Object getElement() {
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

}
