package own.exam_preparation.esercizi_esame;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;


public class Esame2 {
}

class Venerba_Mirco_14_50{


    public static void main(String[] args) {

        final int i = 5;
        Function<Integer, Integer> f = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + i;
            }
        };
    }
}

class Matteo_15_12{
//    public static <K,V> Iterator<Pair<K,V>> createMapIterator(Map<K,V> map){
//        Iterator<Map.Entry<K,V>>
//    }
}

class Hernet_Serani_15_28{

    public static void main(String[] args) {
        List<Integer>  integers = new ArrayList<>();
        Random random = new Random();


        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (integers){

                }
            }
        });

    }
}


class Nicola_Contran_15_52{


    public static Integer fib (int n){
        if (n < 2)
            return 1;
        else
            return fib(n-1) + fib(n - 2);
    }
//    public static void main(String[] args) {
//        Supplier<Integer>
//    }
}

class Giulio_16_06{

}

class Elisabetta_jarova_16_40{
    //iteratore che genera numeri random
}

class Tommaso_serafin_16_53{

}

class Esmir_17_04{


    public static <A> Iterator<A> filter(Iterator<A> aIterator, Predicate<A> predicate){
        return new Iterator<A>() {
            @Override
            public boolean hasNext() {
                return aIterator.hasNext();
            }

            @Override
            public A next() {
                A a = aIterator.next();

                if(predicate.test(a))
                    return a;
                else
                    return next();

            }
        };
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        for (int i = -5; i <= 5 ; i++) {
            list.add(i);
        }

        Iterator<Integer> integerIterator =  filter(list.iterator(),(x) -> x >- 10 );

        while (integerIterator.hasNext()){
            System.out.println((integerIterator.next()));
        }



    }
}


class Vittorio_Marino_17_47{


    public static <A> Collection<A> filer (Collection<A> aCollection, Predicate<A> predicate){
        Collection<A> collection = new ArrayList<>();

        for (A a : aCollection){
            if(predicate.test(a))
                collection.add(a);
        }

        return collection;
    }

    public static void main(String[] args) {

    }
}




class Sebastiano_18_15{

    public interface Shape{

    }

    public static class Rectangle implements Shape{
        double length;
        double height;

        public Rectangle(double length, double height) {
            this.length = length;
            this.height = height;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Rectangle)) return false;
            Rectangle rectangle = (Rectangle) o;
            return Double.compare(rectangle.length, length) == 0 &&
                    Double.compare(rectangle.height, height) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(length, height);
        }
    }

//    public static class Square extends Rectangle{}
//
//    public static class Circle implements Shape{}

}





















