import java.util.LinkedList;
import java.util.Scanner;
/*
Author: Tongshou Wu
Date: 04/29/2021
This program is an example that show maximum consecutive increasingly ordered substring 
*/

public class Exercise22_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();

        System.out.print("Enter a string: ");
        //abcabcdgabxy
        String ip = sc.nextLine();

        for (int i = 0; i < ip.length(); i++) {              // O (logN)
            if (list.size() > 1 && ip.charAt(i) <= list.getLast() && list.contains(ip.charAt(i)))
            {
                list.clear();
            }

            list.add(ip.charAt(i));
            
            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
        }
        System.out.print("Maximum consecutive substring is ");    // O(N)
        for (Character Char: max) {
            System.out.print(Char);
        }
        
    }
}
