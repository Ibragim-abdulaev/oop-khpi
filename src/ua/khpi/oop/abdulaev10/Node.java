package ua.khpi.oop.abdulaev10;

import java.io.Serializable;

public class Node<T> implements Serializable {

    public T element;
    public Node<T> next;

    private static final long serialVersionUID = -7470918086342495897L;

    public Node() {

    }

    public Node(T element) {
        super();
        this.element = element;
    }
}
