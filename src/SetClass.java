import java.util.*;

public class SetClass {
    public static void main(String[] args) {

        HashSet defaultCapacity = new HashSet(); // default capacity 16 and it will be increased by .75
        HashSet customizedLoadFactor = new HashSet(100, .98f);// initialized capacity 100 and it will be increased by .98
        HashSet customizedCapacity = new HashSet(100);// initialized capacity 100 and it will be increased by .98
        HashSet<Integer> a = new HashSet(defaultCapacity); //initialize the hashset with the elements from the passed collection

        a.addAll(Arrays.asList(new Integer[]{11, 3, 21, 4, 8, 9, 0}));
//        System.out.println(a);
        Iterator<Integer> iterator = a.iterator();
        System.out.println("Printing A hashSet");
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        HashSet<Integer> b = new HashSet<Integer>();
        System.out.println("Printing P hashSet");

        for (Integer x: b) {
            System.out.print(x+ " ");
        }

        b.addAll(Arrays.asList(new Integer[]{1, 3, 7, 5, 4, 0, 7, 5}));

        // To find union
        HashSet<Integer> union = new HashSet<Integer>(a);
        union.addAll(b);
        System.out.print("Union of the two Set");
        System.out.println(union);

        // To find intersection
        HashSet<Integer> intersection = new HashSet<Integer>(a);
        intersection.retainAll(b);
        System.out.print("Intersection of the two Set");
        System.out.println(intersection);

        // To find the symmetric difference
        HashSet<Integer> difference = new HashSet<Integer>(a);
        difference.removeAll(b);
        System.out.print("Difference of the two Set");
        System.out.println(difference);
        System.out.println("HashSet Clone : " + difference.clone());



        Spliterator<Integer> spliterator = difference.spliterator();
        spliterator.forEachRemaining(System.out::println);


        //what will happen in the below code?
//        b.add(12,2)

    }
}
