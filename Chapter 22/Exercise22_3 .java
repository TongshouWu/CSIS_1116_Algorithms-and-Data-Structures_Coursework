import java.util.Scanner;
//Author: Tongshou Wu
//Date:04/29/2021
public class Exercise22_3 {
	
	    public static void main(String[] args) {
	    	 		int I = -1;//index
	    	 		int A = 0;//count
	    			Scanner sc = new Scanner(System.in);
	                System.out.println("Enter a string s1: ");
	                String s1 = sc.nextLine();
	                System.out.println("Enter a string s2: ");
	                String s2 = sc.nextLine();
	                for(int i = 0; i < s1.length(); i++) {                    // O(logN)
	                    if(s1.charAt(i) == s2.charAt(0) && A == 0) {          
	                        I = i;
	                        A++;
	                    }
	                    else if (s1.charAt(i) == s2.charAt(A)) {
	                        A++;
	                    }
	                    else {
	                        A = 0;
	                        I = -1;
	                    }
	                    if (A == s2.length()) {
	                        break;
	                    }
	                }
	            if (I >= 0){
	                System.out.println("Match at index " + I);
	            }
	            else {
	                System.out.println("Error");
	            }
	        }
	}

