package own.exam_preparation.threading;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        MyThread myThread = new MyThread();
        myThread.start();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Main = " + i);
                Thread.sleep(300);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }



    }
}

class MyThread extends Thread{
    @Override
    public void run() {

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("MyThread = " + i);
                Thread.sleep(100);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class ConsumerProducer{

    public static class Consumer extends Thread{
        @Override
        public void run() {
        }
    }

    public static class Producer extends Thread{
        @Override
        public void run() {
        }
    }

    public static void main(String[] args) throws InterruptedException {

        List<Integer> integers = new ArrayList<>();

        Consumer c = new Consumer();
        Producer p = new Producer();

        c.start();
        p.start();

        c.join();
        p.join();
    }
}