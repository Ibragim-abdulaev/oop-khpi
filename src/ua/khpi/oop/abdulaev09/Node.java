package ua.khpi.oop.abdulaev09;

import java.io.Serializable;

public class Node<T> implements Serializable {
    public T element;
    public Node<T> next;

    private static final long serialVersionUID = -1143293932421725348L;

    public Node() {

    }

    public Node(T element) {
        super();
        this.element = element;
    }
}
