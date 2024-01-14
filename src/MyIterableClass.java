import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyIterableClass <T> implements Iterable<T>{
    private T[] array ;

    public MyIterableClass(T[] array) {
        this.array = array;
    }


    public static void main(String[] args) {

        System.out.println("------------String--------------");

        String[] array = {"Apple", "Banana", "Cherry"};
        MyIterableClass<String> myIterableClass = new MyIterableClass<String>(array);

        for (String s : myIterableClass) {
            System.out.println(s);
        }

        System.out.println("------------Integer---------------");

        Integer[] longArray ={1,26,9,5,6,4};
        MyIterableClass<Integer> longIterable = new MyIterableClass<>(longArray);
        for (Integer x: longIterable) {
            System.out.println(x);
        }

        System.out.println("------------using iterating----------");
        Iterator<Integer> iterator = longIterable.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public void initalize(T[] array){
        this.array = array;
    }

    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>) Arrays.asList(array).iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }
}
