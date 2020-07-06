package hashing;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class ads {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(obj.readLine());
        StringBuilder output = new StringBuilder();
        while(T-->0){
            int Q = Integer.parseInt(obj.readLine());
            int current=0;
            ArrayList<Integer> listOfPowers = new ArrayList<Integer>();
            int size = 0;
            char queryType=' ';
            int value=0;
            for(int i=0 ; i<Q ; i++){
                {
                    String query[] = obj.readLine().split(" ");
                    queryType = query[0].charAt(0);
                    value = Integer.parseInt(query[1]);
                }
                
                // switch(queryType){
                //     case 'A': listOfPowers.add(value);
                //         size++;
                //         break;
                //     case 'I': for(int j=0;j<size;j++){
                //         current=listOfPwers.get(j);
                //         current+=value;
                //         listOfPwers.set(j , current);
                //     }
                //         break;
                //     case 'D': for(int j=0;j<size;j++){
                //         current=listOfPowers.get(j);
                //         current-=value;
                //         listOfPowers.set(j , current);
                        
                //     }
                //         break;
                //     case 'P': Collections.sort(listOfPowers);
                //     current = listOfPowers.get(size-current+1);
                //     output.append(current).append("\n");
                //     break;
                // }
                
                if(queryType=='A'){
                    listOfPowers.add(value);
                    size++;
                } else if(queryType=='I'){
                    for(int j=0;j<size;j++){
                         current = listOfPowers.get(j);
                        current+=value;
                        listOfPowers.set(j ,current);
                    }
                } else if(queryType=='D'){
                    for(int j=0; j<size ; j++){
                         current = listOfPowers.get(j);
                        current-=value;
                        listOfPowers.set(j , current);
                    }
                } else if(queryType=='P'){
                    Collections.sort(listOfPowers);
                     current = listOfPowers.get(size-current+1);
                     System.out.println(current);
                    output.append(current).append("\n");
                }
            }
        }
        // System.out.println("Hi, " + name + ".");
        System.out.println(output);
    }
}
