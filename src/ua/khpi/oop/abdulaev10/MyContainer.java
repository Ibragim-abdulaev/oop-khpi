package ua.khpi.oop.abdulaev10;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import ua.khpi.oop.abdulaev07.Challanger;


public class MyContainer<T> implements Iterable<T>, Serializable {
    private static final long serialVersionUID = 1487028470983100792L;

    public Node<T> head;
    private int size;

    public MyContainer() {
        super();
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

    public void sort (Comparator<T> comp, int order) {
        Object[] array = this.toArray();
        Object temp;
        boolean check;

        if (order == 1) {
            do {
                check = false;
                for(int i = 0; size - 1 > i; i++) {
                    if(comp.compare((T)array[i],(T)array[i+1]) == 1) {
                        temp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = temp;
                        check = true;
                    }
                }
            } while (check == true);
        }
        else {
            do {
                check = false;
                for(int i = 0; size - 1 > i; i++) {
                    if(comp.compare((T)array[i],(T)array[i+1]) == -1) {
                        temp = array[i+1];
                        array[i+1] = array[i];
                        array[i] = temp;
                        check = true;
                    }
                }
            } while (check == true);
        }

        this.clear();
        for(Object obj : array) {
            this.add((T)obj);
        }
    }
}

class idComparator implements Comparator<Challanger>{
    @Override
    public int compare(Challanger o1, Challanger o2) {
        if(o1.getRegistrationNum() > o2.getRegistrationNum())
            return 1;
        else if (o1.getRegistrationNum() < o2.getRegistrationNum())
            return -1;
        else
            return 0;
    }
}

class workExperienceComparator implements Comparator<Challanger>{
    @Override
    public int compare(Challanger o1, Challanger o2) {
        if(o1.getWorkExperience().getExperience() > o2.getWorkExperience().getExperience())
            return 1;
        else if (o1.getWorkExperience().getExperience() < o2.getWorkExperience().getExperience())
            return -1;
        else
            return 0;
    }
}

class minSalazyComparator implements Comparator<Challanger>{
    @Override
    public int compare(Challanger o1, Challanger o2) {
        if(o1.getDemandsToWork().getMinSalary() > o2.getDemandsToWork().getMinSalary())
            return 1;
        else if (o1.getDemandsToWork().getMinSalary() < o2.getDemandsToWork().getMinSalary())
            return -1;
        else
            return 0;
    }

}
