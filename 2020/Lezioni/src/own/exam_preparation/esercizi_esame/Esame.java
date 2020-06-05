package own.exam_preparation.esercizi_esame;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Esame {


//    public static class Cambio<T,S> extends ArrayList<T> {
//        Function<T,S> f;
//
//        public Cambio( Function<T, S> f) {
//            this.f = f;
//        }
//
//        @NotNull
//        @Override
//        public Iterator<S> iterator() {
//            Iterator<T> originalIterator = super.iterator();
//
//            return new Iterator<T>() {
//                @Override
//                public boolean hasNext() {
//                    return originalIterator.hasNext();
//                }
//
//                @Override
//                public S next() {
//                    return f.apply(originalIterator.next());
//                }
//            };
//        }
//
//    }

}

class Melania{
        public static class Cambio<T> extends ArrayList<T> {
        Function<T,T> f;

        public Cambio( Function<T, T> f) {
            this.f = f;
        }

        @Override
        public Iterator<T> iterator() {
            Iterator<T> originalIterator = super.iterator();

            return new Iterator<T>() {
                @Override
                public boolean hasNext() {
                    return originalIterator.hasNext();
                }

                @Override
                public T next() {
                    return f.apply(originalIterator.next());
                }
            };
        }
    }
}

class Elena_12_28{
     // fai un esempio di subsumpsion

    public static class Animale implements Comparable<Animale>{
        int peso;
        public void metodo(){

        }

        @Override
        public int compareTo(@NotNull Animale o) {
            return Integer.compare(this.peso,o.peso);
        }
    }

    public static class Cane extends Animale{
        @Override
        public void metodo() {
        }
    }

    public static class CanePiccolo extends Cane{
        @Override
        public void metodo() {
        }
    }

    public static class Gatto extends Animale{
        @Override
        public void metodo() {
        }
    }


    public static class Coppia<T extends Number,S>{
        private T primo;
        private S secondo;

        public Coppia(T primo, S secondo) {
            this.primo = primo;
            this.secondo = secondo;
        }

        public <X> void m (X x, List<? extends X> l){

        }
    }

    public static void main(String[] args) {

        Collections.sort(new ArrayList<Animale>(), new Comparator<Animale>() {
            @Override
            public int compare(Animale o1, Animale o2) {
                return 0;
            }
        });

        List<Animale> animales = new ArrayList<>(List.of(new Animale(), new Cane(), new CanePiccolo(), new Gatto()));

        Collections.sort(animales);

    }


}


class Daniele_12_52{

    public static class FiboIterable implements Iterable<Integer>{

        int length;
        public FiboIterable(int i) {
            length = i;
        }

        @NotNull
        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                private int cur = 1;
                private int prev = 1;
                private int sum = 0;
                @Override
                public boolean hasNext() {
                    return length > 0;
                }

                @Override
                public Integer next() {
                    if (sum == 0){
                        sum = prev + cur;
                        return 1;
                    }

                    sum = prev + cur;
                    prev = cur;
                    cur = sum;

                    length--;
                    return sum;
                }
            };
        }
    }

    public static void main(String[] args) {
        for (int n: new FiboIterable(20)) {
            System.out.println(n);
        }

        Consumer<Integer> consumer = new Consumer<Integer>(){
            @Override
            public void accept(Integer integer) {
                integer++;
            }
        };
    }
}

class Nicolo_14_39{


    public static <A> void supply (Collection<A> collection , Supplier<A> supplier, int n){
        for (int i = 0; i < n; ++i)
            collection.add(supplier.get());
    }

    public static void main(String[] args) {
        Collection<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }
        for (int i: integers) {
            System.out.println(i);
        }

        Iterator<Integer> integerIterator = integers.iterator();

        while (integerIterator.hasNext())
            System.out.println(integerIterator.next());
    }
}

class Lorenzo_14_55{

    public static class Animale implements Comparable<Animale>{
        private int peso;
        @Override
        public int compareTo(@NotNull Animale o) {
            return Integer.compare(this.peso,o.peso);
        }
    }

    public static class Cane extends Animale{
        private int eta;

        @Override
        public int compareTo(@NotNull Animale o) {
            if (o instanceof Cane){
                return Integer.compare(this.eta,((Cane) o).eta);
            }else{
                return super.compareTo(o);
            }
        }
    }

    public static void main(String[] args) {

    }
}


class Francesco_Camporese{

    public static class Animale implements Comparable<Animale>{
        private int peso;
        @Override
        public int compareTo(@NotNull Animale o) {
            return Integer.compare(this.peso,o.peso);
        }
    }

    public static class Cane extends Animale {
        private int eta;

        @Override
        public int compareTo(@NotNull Animale o) {
            if (o instanceof Cane){
                return Integer.compare(this.eta,((Cane) o).eta);
            }else{
                return super.compareTo(o);
            }
        }
    }

    public static void main(String[] args) {
        List<Cane> l = new ArrayList<>();
        Collections.sort(l);
    }
}



class Pietro_gianni_15_40{
    //dimostrazione race condition
    public static void main(String[] args) {

        final Integer[] i = {0};

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                i[0] = 0;
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

    }
}

//da guardare
class Gloria_Fiammengo_16_00{

    public static class SkipIterator<T> extends ArrayList<T>{

        private int skipper;
        public SkipIterator(int skipper) {
            this.skipper = skipper;
        }

        @NotNull
        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                private int lenght = size();

                private int currentPos = skipper;

                @Override
                public boolean hasNext() {
                    return currentPos < lenght;
                }

                @Override
                public T next() {
                    T elem = get(currentPos);
                    currentPos += skipper;
                    return elem;
                }
            };
        }
    }

    public static void main(String[] args) {

        SkipIterator<Integer> integers = new SkipIterator<>(2);
        for (int i = 0; i < 20; i++) {
            integers.add(i);
        }

        for (Integer i : integers)
            System.out.println(i);

        //type erasure
    }
}

class Thomas_Rossetto_16_30{

    public static class Consumer extends Thread{
        private Object mutex;
        private List<Integer> l;

        public Consumer(Object mutex, List<Integer> l) {
            this.mutex = mutex;
            this.l = l;
        }

        @Override
        public void run() {
            while (true){
                if(!l.isEmpty()){
                    System.out.println(l.get(0));
                    l.remove(0);
                }
            }
        }
    }

    public static class Producer extends Thread{
        private Object mutex;
        private List<Integer> l;

        public Producer(Object mutex, List<Integer> l) {
            this.mutex = mutex;
            this.l = l;
        }

        @Override
        public void run() {
            while (true){
                synchronized (mutex){
                    l.add(0);
                }
            }
        }
    }

    public static void main(String[] args) {
        Object mutex = new Object();
        List<Integer> l = new ArrayList<>();
        Thread consumer = new Consumer(mutex,l);
        Thread producer = new Producer(mutex,l);

        consumer.start();
        producer.start();
    }

}


class Giacomo_Rossin_17_00{

    public static <A, B> Iterator<B> mapIterator(Iterator<A> it, Function<? super A, ? extends B> f){
        return new Iterator<B>() {
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public B next() {
                return f.apply(it.next());
            }
        };
    }

}

class Francesco_Bruno_17_10{


    public static class Fibo implements Iterable<Integer>{

        private int n;
        public Fibo(int i) {
            n = i;
        }

        @NotNull
        @Override
        public Iterator<Integer> iterator() {
            return null;
        }
    }

    public static void main(String[] args) {
        for (int n :
                new Fibo(10)) {
            System.out.println(n);
        }
    }
}

class Pezzato_17_30{


    public static class MyFhread extends Thread{
        private int num;
        private int  f = 1;
        public MyFhread(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            for (int i = 1 ; i <= num; i++ ){
                f = f * i;
            }
            System.out.println(f);
        }
    }

    public static void main(String[] args) throws InterruptedException {


        List<MyFhread> fibos = new ArrayList<>();

        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            MyFhread fhread = new MyFhread(r.nextInt(10));
            fibos.add(fhread);
            fhread.start();
        }

        for (MyFhread t: fibos) {
            t.join();
            System.out.println(t.f);
        }
    }
}

class Alberto {
    //iteratore che va indietro

    public static class MyArrayList<T> extends ArrayList<T>{

        @NotNull
        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {

                private int size = size();
                @Override
                public boolean hasNext() {
                    return size > 0;
                }

                @Override
                public T next() {
                    T elem = get( size - 1);
                    size--;
                    return elem;
                }
            };
        }
    }

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            myArrayList.add(i);
        }

        for (int i: myArrayList) {
            System.out.println(i);
        }
    }

}

class Piva_18_30{

    public static class Pair<T>{
        T max;
        T min;

        public Pair(T max, T min) {
            this.max = max;
            this.min = min;
        }
    }

    public static <T> Pair<T> f(List<T> l, Comparator<T> comparator){
        Collections.sort(l,comparator);

        T min = l.get(0);
        T max = l.get(l.size() -1);
        return new Pair<>(max,min);
    }

    public static <T> Comparator<T> inverso (Comparator<T> comparator){
        return new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return -1 * comparator.compare(o1,o2);
            }
        };
    }

    public static void main(String[] args) {

    }
}

























