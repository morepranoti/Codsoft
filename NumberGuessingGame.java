import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
 
    	
		Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;

        System.out.println("Hello, welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;

            System.out.println("\nNew round started! Guess a number between 1 and 100.");

            while (true) {
                System.out.print("Please enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempts >= 5) {
                    System.out.println("You have reached the maximum number of attempts. The correct number was " + randomNumber + ".");
                    break;
                }
            }

            score += attempts;
            System.out.println("Score: " + score);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        System.out.println("\nThank you for playing the Number Guessing Game! Final score: " + score);
        scanner.close();
    }
}

