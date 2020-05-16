package exam.preparation.myjdk;

import it.unive.dais.po2.myjdk.MyLinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list= new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list.size());


    }


}
