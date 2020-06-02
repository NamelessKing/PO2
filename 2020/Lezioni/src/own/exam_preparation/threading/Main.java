package own.exam_preparation.threading;

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