/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mark_calculation;

/**
 *
 * @author visal
 */
import java.util.*;
public class Mark_calculation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i;
        float sum=0,avg;
        // Define the number of subjects
        System.out.print("Enter the number of subjects: ");
        int n = scan.nextInt();
        scan.nextLine();  // Consume the newline

        // Initialize the arrays
        String[] subjects = new String[n];
        float[] marks = new float[n];

        // Get input for the subjects and corresponding marks
        for ( i = 0; i < n; i++) {
            System.out.print("Enter the name of subject " + (i + 1) + ": ");
            subjects[i] = scan.nextLine();
            
            System.out.print("Enter the marks for " + subjects[i] + ": ");
            marks[i] = scan.nextInt();
            scan.nextLine();  // Consume the newline
        }
        for(i=0;i<n;i++)
        {
            sum=sum+marks[i];
         }
        avg=sum/n;
        
        System.out.println("\tSUBJECTS\t MARKS");
        for ( i = 0; i < n; i++) {
            System.out.println("\t"+subjects[i] + "\t\t " + marks[i]);
        }
        System.out.print("\nTOTAL:"+sum);
         System.out.print("\nAVERAGE Percentage:"+avg+"%");
         System.out.print("\nGRADE:");
         if(avg>=50){
             if(avg>=90&&avg<=100)
                 System.out.print("O");
             else if(avg>=80&&avg<90)
                 System.out.print("A+");
              else if(avg>=70&&avg<80)
                 System.out.print("A"); 
              else if(avg>=60&&avg<70)
                 System.out.print("B");
              else if(avg>=50&&avg<60)
                 System.out.print("C");
              }
         else
             System.out.print("\nNEED MORE ATTENTION!!\n BETTER LUCK  NEXT TIME!!");
    }
}

