/*
Author: Tongshou Wu
Date: 04/29/2021

Description: example of sorting
*/
import java.util.Comparator;

public class Exercise23_03  {
    public static void main(String[] args) {
        Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        quickSort(list);
        for (int i = 0; i < list.length; i++) {
          System.out.print(list[i] + " ");
        }
        System.out.println();
        Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
                         new Circle(5), new Circle(6), new Circle(1), new Circle(2),
                         new Circle(3), new Circle(14), new Circle(12)};
        quickSort(list1, new GeometricObjectComparator());
        for (int i = 0; i < list1.length; i++) {
          System.out.println(list1[i] + " ");
        }
    }
    public static <E extends Comparable<E>> void quickSort(E[] list) {
        quickSort(list, 0, list.length - 1);
    }
     public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
        if (list.length > 1) {
            quickSort(list, 0, list.length - 1, comparator);
        }
    }
    public static <E extends Comparable<E>> void quickSort(E[] list, int first, int last) {
        if (last > first) {
            int pivotPosition = position(list, first, last);
            quickSort(list, first, pivotPosition - 1);
            quickSort(list, pivotPosition + 1, last);
        }
    }
    public static <E> void quickSort(E[] list, int first, int last, Comparator<? super E> comparator) {
        if (last > first) {
            int pivotPosition = position(list, first, last, comparator);
            quickSort(list, first, pivotPosition - 1, comparator);
            quickSort(list, pivotPosition + 1, last, comparator);
        }
    }
    public static <E> int position(E[] list, int first, int last, Comparator<? super E> comparator) {
        E pivotstuff = list[first];
        int lowest = first + 1;
        int highest = last;
        while (highest > lowest) {
            while (lowest <= highest && comparator.compare(list[lowest], pivotstuff) <= 0) {
                lowest++;
            }
            while (lowest <= highest && comparator.compare(list[highest], pivotstuff) > 0) {
                highest--;
            }
            if (highest > lowest) {
                E temp = list[highest];
                list[highest] = list[lowest];
                list[lowest] = temp;
            }
        }
        while (highest > first && comparator.compare(list[highest], pivotstuff) >= 0) {
            highest--;
        }
        if (comparator.compare(pivotstuff, list[highest]) > 0) {
            list[first] = list[highest];
            list[highest] = pivotstuff;
            return highest;
        }
        else {
            return first;
        }
    }
    public static <E extends Comparable<E>> int position(E[] list, int first, int last) {
        E pivot = list[first];
        int low = first + 1;
        int high = last;
        while (high > low) {
            while (low <= high && list[low].compareTo(pivot) <= 0) {
               low++;
            }
            while (low <= high && list[high].compareTo(pivot) > 0) {
                high--; 
            }
            if (high > low) {
             
                E temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
        while (high > first && list[high].compareTo(pivot) >= 0) {
            high--;
        }
        
        if (pivot.compareTo(list[high]) > 0) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else {
            return first;
        }
    }
}
