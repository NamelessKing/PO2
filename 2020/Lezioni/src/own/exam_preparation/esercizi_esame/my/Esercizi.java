package own.exam_preparation.esercizi_esame.my;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Esercizi {

}



class Federica_Singleton_4_14_45{


    public static class Cane{

        private static Cane cane;
        private String nome = "";

        private Cane(String nome) {
            for (int i = 0; i < 5; i++) {
                this.nome = this.nome.concat(nome);
            }
        }

        public static Cane getInstance(String s){
            if(cane == null) {
                cane = new Cane(s);
            }
            return cane;
        }

        public String getNome() {
            return nome;
        }
    }

    public static class Main{
        public static void main(String[] args) {
            Cane c1 = Cane.getInstance("ciao");
            System.out.println(c1.getNome());

            int i = 5;

            Function<Integer, Integer> f = new Function<Integer, Integer>() {
                @Override
                public Integer apply(Integer integer) {
                    return integer + i;
                }
            };

            Consumer<Cane> consumer = new Consumer<Cane>() {
                @Override
                public void accept(Cane cane) {
                    System.out.println( cane.getNome());
                }
            };

            Consumer<Cane> consumer2 =
                    cane -> System.out.println( cane.getNome());


        }
    }

}

class Matteo_4_15_12{

    public static class Pair<K, V> {
        K k;
        V v;

        public Pair(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    public static <K,V> Iterator<Pair<K,V>> createMapIterator(Map<K,V> map){
        Iterator<Map.Entry<K,V>> it = map.entrySet().iterator();

        return new Iterator<Pair<K, V>>() {
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public Pair<K, V> next() {
                Map.Entry<K,V> entry = it.next();

                return new Pair<>(entry.getKey(),entry.getValue());
            }
        };
    }
}


class Hernet_Serani_4_15_28{

    public static void main(String[] args) {
        List<Integer> sharedList = new ArrayList<>();

        Random random = new Random();

        List<Thread> threadList = new ArrayList<>();


        //System.out.println("ciaooo");

        for (int i = 0; i < 1 ; i++) {

            Thread consumer = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        synchronized (sharedList) {
                            try {
                                if(!sharedList.isEmpty()) {
                                    int removedItem = sharedList.remove(0);
                                    System.out.println("Consumer :"+removedItem);
                                }
                                Thread.sleep(200);
                            } catch (InterruptedException e) {

                                e.printStackTrace();

                            }

                        }
                    }
                }
            });

            consumer.start();
            threadList.add(consumer);
        }


        for (int i = 0; i < 1 ; i++) {
            Thread produced = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        synchronized (sharedList) {

                            try {
                                int elem = random.nextInt(5);
                                sharedList.add(elem);
                                System.out.println(String.format("Producer : %s",sharedList));

                                Thread.sleep(300);
                            } catch (InterruptedException e) {

                                e.printStackTrace();

                            }
                        }
                    }
                }
            });

            produced.start();
            threadList.add(produced);
        }

        for (Thread t:
             threadList) {

            try {
                t.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }

    }
}

class Nicola_Contran_4_15_52{


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


class Nicolo_3_14_39{


    public static <A> void f(Collection<A> collection, Supplier<A> supplier,int i){
        for (int j = 0; j < i; j++) {
            collection.add(supplier.get());
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> iterable = new ArrayList<>();

        f(iterable,() -> 5,5);
    }
}

























