package codsoft;

import java.util.Random;
import java.util.Scanner;

public class Task_1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int numberOfAttempts = 5; 
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int targetNumber = getRandomNumber(minRange, maxRange);
            System.out.println("\nI've generated a number between " + minRange + " and " + maxRange);

            int currentAttempts = 0;
            boolean guessedCorrectly = false;

            while (currentAttempts < numberOfAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low Try again.");
                } else {
                    System.out.println("Too high Try again.");
                }

                currentAttempts++;
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've run out of attempts. The correct number was: " + targetNumber);
            } else {
                score++;
            }

            System.out.print("Do you want to play again? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("Game Over. Your total score is:" + score);
        scanner.close();
    }

    private static int getRandomNumber(int min, int max) {
        return min+(int) (Math.random()*((max - min) + 1));
    }
}
