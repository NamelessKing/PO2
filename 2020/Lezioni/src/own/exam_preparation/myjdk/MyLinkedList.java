package own.exam_preparation.myjdk;

public class MyLinkedList<E> implements MyList<E> {

    private class Node {
        public E data;
        public Node next;
        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;

    public MyLinkedList() {
        this.head = null;
    }

    @Override
    public void add(E element) {
        this.head = new Node(element,head);
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E get(int index) throws OutOfBoundsException {
        return null;
    }

    @Override
    public boolean remove(int index) {
        return false;
    }

    @Override
    public boolean remove(E element) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public MyIterator<E> iterator() {
        return null;
    }
}
