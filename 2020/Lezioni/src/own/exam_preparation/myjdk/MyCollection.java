package own.exam_preparation.myjdk;

public interface MyCollection<E> extends MyIterable<E> {
    void add(E element);
    int size();
    boolean	isEmpty();
    boolean	contains(E element);
    boolean	remove(E element);
    void clear();

    //MyIterable methods
    //MyIterator<E> iterator();
}
