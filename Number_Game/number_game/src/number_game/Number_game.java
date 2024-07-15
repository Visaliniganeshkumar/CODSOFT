/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number_game;

/**
 *
 * @author visal
 */
import java.util.Scanner;
import java.util.Random;

public class Number_game {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        
        boolean playAgain = true;
        
        while (playAgain) {
            play(scan, random);
            
            System.out.print("\nDo you want to play again? (yes/no): ");
            String Choice = scan.next().toLowerCase();
            
            if (Choice!="yes") {
                playAgain = false;
            }
        }
        
        System.out.println("Thank you!!");
    }

    // Method to play the number guessing game
    public static void play(Scanner scan, Random random) {
        int number;
        int user_input = 0;
        number = random.nextInt(100) + 1;
        int attempts = 0;
        System.out.println("Guess a number between 1 and 100.");
        System.out.print(number);

        while (attempts < 3) {
            System.out.print("\nEnter your guess: ");
            user_input = scan.nextInt();
            attempts++;

            if (user_input == number) {
                System.out.println("\n You have guessed the correct number.");
                points(attempts);
                break;
            } else {
                diff(user_input, number);
            }
        }

        if (user_input != number) {
            System.out.println("\nSorry, you did not guess the number."+"\n"+" Therefore,The random number is " + number);
            System.out.println("Better luck next time!!");
        } 
         System.out.println("No of attempts " + attempts ); 
    }

    // Method to print points based on the attempt number
    public static void points(int attempts) {
        int points = 0;
        switch (attempts) {
            case 1:
                points = 30;
                break;
            case 2:
                points = 20;
                break;
            case 3:
                points = 10;
                break;
            default:
                break;
        }
        System.out.println("Points earned: " + points);
    }

    // Method to print distance hint based on the user's guess
    public static void diff(int user_guess, int actual_number) {
        int difference = Math.abs(user_guess - actual_number);

        if (difference == 0) {
            System.out.println(" You've guessed the correct number.");
        } else if (difference <= 5) {
            System.out.println("Very Near!");
        } else if (difference <= 10) {
            System.out.println("Near!");
        } else if (difference <= 20) {
            System.out.println("Far!");
        } else {
            System.out.println("Very far!");
        }
    }
}


