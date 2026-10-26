package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * Program entry point.
     */
    public static void main() {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */

        List<Integer> al = new ArrayList<>();

        for (int i = 1000; i<2000; i++){
            al.add(i);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */

        List<Integer> ll = new LinkedList<>();

        ll.addAll(al);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */

        var temp = al.get(0);
        al.set(0, al.get(al.size() -1 ));
        al.set(al.size() - 1, temp);


        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        IO.print("ArrayLIst: [ ");
        for (Integer i: al) {
            IO.print(i + " ");
        }
        IO.println("];");

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */

        long arrListTime = System.nanoTime();

        for (int i = 0; i<100000; i++) {
            al.addFirst(i);
        }

        arrListTime = System.nanoTime() - arrListTime;


        long linListTime = System.nanoTime();

        for (int i = 0; i<100000; i++) {
            ll.addFirst(i);
        }

        linListTime = System.nanoTime() - linListTime;


        IO.println("Insert in Array List Time: " + arrListTime + "ns");
        IO.println("Insert in Linked List Time: " + linListTime + "ns");


        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */

        arrListTime = System.nanoTime();

        for (int i = 0; i<1000; i++) {
            al.get(al.size()/2);
        }

        arrListTime = System.nanoTime() - arrListTime;


        linListTime = System.nanoTime();

        for (int i = 0; i<1000; i++) {
            al.get(al.size()/2);
        }

        linListTime = System.nanoTime() - linListTime;


        IO.println("Read from Array List Time: " + arrListTime + " ns");
        IO.println("Read from Linked List Time: " + linListTime + " ns");

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        Map<String, Long> m = new HashMap<>();
        m.put("Africa", 1110635000l);
        m.put("Americas", 972005000l);
        m.put("Antartica", 0l);
        m.put("Asia", 4298723000l);
        m.put("Europe", 742452000l);
        m.put("Oceania", 38304000l);
        /*
         * 8) Compute the population of the world
         */

        long worldPop  = 0l;

        for (String s: m.keySet()) {
            worldPop += m.get(s);
        }

        IO.println("Total world population: " + worldPop);
    }
}
