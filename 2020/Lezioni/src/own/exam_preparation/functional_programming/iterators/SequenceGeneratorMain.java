package own.exam_preparation.functional_programming.iterators;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class SequenceGeneratorMain {
    public static void main(String[] args) {

        System.out.println("PAIR GENERATOR");
        SequenceGenerator<Integer> pairGenerator = new SequenceGenerator<>(integer -> integer + 2,0,10);
        for (int elem : pairGenerator) {
            System.out.println(elem);
        }

        /***/
        // da correggere
        System.out.println("FACTORIAL GENERATOR");
        SequenceGenerator<Integer> factorialGenerator = new SequenceGenerator<>(integer -> integer * (integer - 1),10,10);
        for (int elem : factorialGenerator) {
            System.out.println(elem);
        }


    }
}
interface Supplier<T>{
    T supply(T t);
}
class SequenceGenerator<T> implements Iterable<T>{



    public Supplier<T> supplier;
    public T initialValue;
    public int timesToGenerate;

    public SequenceGenerator(Supplier<T> supplier,T initialValue,int timesToGenerate) {
        this.supplier = supplier;
        this.timesToGenerate = timesToGenerate;
        this.initialValue = initialValue;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @NotNull
    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            T t = initialValue;
            @Override
            public boolean hasNext() {
                return timesToGenerate >= 0;
            }

            @Override
            public T next() {
                T toReturn = t;
                t = supplier.supply(t);
                timesToGenerate--;
                return toReturn;
            }
        };
    }
}
