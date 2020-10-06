
package uaslp.enginering.labs.list;

import uaslp.enginering.labs.list.model.Lists;
import uaslp.enginering.labs.list.model.Object;


public class Node<T>  {
    private Object element;
    private Node<T> previous;
    private Node<T> next;


    public Node(java.lang.Object element) {
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Object getElement() {
        return element;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public Node<T> getPrevious() {
        return previous;
    }


    public void setNext(Node<T> next){
        this.next=next;
    }

    public Node<T> getNext(){
        return next;
    }

}
