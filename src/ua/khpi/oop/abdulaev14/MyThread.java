package ua.khpi.oop.abdulaev14;

import ua.khpi.oop.abdulaev07.Challanger;
import ua.khpi.oop.abdulaev10.MyContainer;

public class MyThread implements Runnable {
    private MyContainer<Challanger> container;
    private boolean isActive;
    private int time;
    Thread thread;

    MyThread(MyContainer<Challanger> container2, String name, int time){
        container = container2;
        isActive = true;
        this.time = time;
        thread = new Thread(this, name);
    }

    void disable() {
        isActive = false;
    }

    private long count() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.currentThread().sleep(500);
        int minSalary = 0;
        int count = 0;
        for(Challanger i : container) {
            if(isActive) {
                minSalary = i.getDemandsToWork().getMinSalary();
                if(minSalary > 10000) {
                    count++;
                }

            }
            else {
                System.out.println(Thread.currentThread().getName() + " was stopped.");
                return -1;
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + count);
        System.out.println(Thread.currentThread().getName() + " finished");
        return (System.currentTimeMillis() - begin);
    }

    @Override
    public void run() {
        long countTime = 0;
        long temp = 0;
        int count = 0;
        int minSalary = 0;

        for(int i = 0; time > i; i++) {
            try {
                temp = count();
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
            countTime += temp;
        }
        System.out.println("Time spent: " + countTime + " milliseconds");
    }
}