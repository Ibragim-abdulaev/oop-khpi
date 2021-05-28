package ua.khpi.oop.abdulaev13;

import ua.khpi.oop.abdulaev07.Challanger;
import ua.khpi.oop.abdulaev10.MyContainer;

public class MyThread implements Runnable {
    private MyContainer<Challanger> container;
    private boolean isActive;
    Thread thread;

    public MyThread(MyContainer<Challanger> container2, String name){
        container = container2;
        isActive = true;
        thread = new Thread(this, name);
    }

    void disable() {
        isActive = false;
    }

    @Override
    public void run() {
        int count = count();

        System.out.println(Thread.currentThread().getName() + ": " + count);
        System.out.println(Thread.currentThread().getName() + " finished");
    }

    public int count() {
        int count = 0;
        int minSalary = 0;
        for(Challanger i : container) {
            if(isActive) {
                minSalary = i.getDemandsToWork().getMinSalary();
                if(minSalary > 10000) {
                    count++;
                }
            }
            else {
                break;
            }
        }
        return count;
    }
}