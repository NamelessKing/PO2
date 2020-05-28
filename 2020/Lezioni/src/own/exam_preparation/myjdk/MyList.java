package own.exam_preparation.myjdk;


public interface MyList<E> extends MyCollection<E> {
    void add(int index, E element);
    E get(int index) throws OutOfBoundsException;;
    boolean	remove(int index);

    //Collection methods
//    boolean add(E element);
//    int size();
//    boolean	isEmpty();
//    boolean	contains(E element);
//    boolean	remove(E element);
//    void clear();
}
