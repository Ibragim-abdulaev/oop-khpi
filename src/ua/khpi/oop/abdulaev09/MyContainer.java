package ua.khpi.oop.abdulaev09;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyContainer<T> implements Iterable<T>, Serializable {
    private static final long serialVersionUID = 707932790294563395L;

    public Node<T> head;
    private int size;

    public MyContainer() {
        super();
        this.setSize(0);
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public T getElement(int id) {
        if(id < 0 || id > size) {
            System.out.println("Error! Wrong ID.");
            return null;
        }
        Node<T> temp = head;
        for(int i = 0; id > i; i++)	{
            temp = temp.next;
        }
        return temp.element;
    }

    public void add(T element) {
        Node<T> tmp = new Node<T>();

        if(head == null) {
            head = new Node<T>(element);
        }
        else {
            tmp = head;
            while(tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new Node<T>(element);
        }
        size++;
    }

    public boolean delete(int id) {
        Node<T> tmp = head;

        if(head != null) {
            if(id == 0) {
                head = head.next;
            }
            else {
                for(int i = 0; id-1 > i; i++) {
                    tmp= tmp.next;
                }
                if(tmp.next != null) {
                    tmp.next = tmp.next.next;
                }
                else
                    tmp.next = null;
                size--;
            }
            return true;
        }
        else {
            System.out.println("Container is empty!");
            return false;
        }
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        for(int i = 0; size > i; i++) {
            array[i] = getElement(i);
        }
        return array;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for(T element : this) {
            str.append(element + "\n");
        }
        return str.toString();
    }

    public boolean isEmpty() {
        if(size == 0)
            return true;
        else
            return false;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>(){
            int index = 0;
            boolean check = false;

            @Override
            public boolean hasNext() {
                return size > index;
            }

            @Override
            public T next() {
                if(index != size) {
                    check = true;
                    return getElement(index++);
                }
                else
                    throw new NoSuchElementException();
            }

            @Override
            public void remove() {
                if(check) {
                    MyContainer.this.delete(index - 1);
                    check = false;
                }
            }

        };
    }
}