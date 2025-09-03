import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int rounds = 5;
        int maxTurns = 4;
        int totalScore = 0;

        System.out.println("🎯 Welcome to the Number Guessing Game!");
        System.out.println("You have " + rounds + " rounds, and " + maxTurns + " guesses per round.");
        System.out.println("Range: 1 to 20\n");

        for (int round = 1; round <= rounds; round++) {
            int secret = random.nextInt(20) + 1; // random number between 1-20
            boolean guessedCorrectly = false;
            System.out.println("----- Round " + round + " -----");

            for (int turn = 1; turn <= maxTurns; turn++) {
                System.out.print("Turn " + turn + " - Enter your guess: ");
                int guess = scanner.nextInt();

                if (guess == secret) {
                    System.out.println("✅ Correct! You got it in " + turn + " turns.");
                    // Score: higher if guessed earlier
                    int score = (maxTurns - turn + 1) * 10;
                    totalScore += score;
                    System.out.println("You earned " + score + " points this round.\n");
                    guessedCorrectly = true;
                    break;
                } else if (guess < secret) {
                    System.out.println("Too low! 📉");
                } else {
                    System.out.println("Too high! 📈");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Out of turns! The number was: " + secret + "\n");
            }
        }

        System.out.println("===== Game Over =====");
        System.out.println("Your final score: " + totalScore + " / " + (rounds * maxTurns * 10));
        scanner.close();
    }
}
