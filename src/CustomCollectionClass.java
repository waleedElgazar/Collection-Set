import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CustomCollectionClass<T> implements Collection<T> {

    // todo i did that to save time to implement method to increase the size and relocate the array
    private ArrayList<T> arr = new ArrayList();
    private int size;
    private int indx = 0;

    public static void main(String[] args) {
        CustomCollectionClass<String> customStringCollection = new CustomCollectionClass();
        System.out.println(customStringCollection.size);

        customStringCollection.add("waleed");
        customStringCollection.add("Reda");

        System.out.println(customStringCollection.size);

        Iterator<String> iterator = customStringCollection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return !(indx >= size);
            }

            @Override
            public Object next() {
                return arr.get(indx++);
            }
        };
    }

    @Override
    public boolean add(T o) {
        size++;
        return arr.add(o);
    }


    @Override
    public Object[] toArray(IntFunction generator) {
        return Collection.super.toArray(generator);
    }

    @Override
    public boolean removeIf(Predicate filter) {
        return Collection.super.removeIf(filter);
    }

    @Override
    public Spliterator spliterator() {
        return Collection.super.spliterator();
    }

    @Override
    public Stream stream() {
        return Collection.super.stream();
    }

    @Override
    public Stream parallelStream() {
        return Collection.super.parallelStream();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }


}
