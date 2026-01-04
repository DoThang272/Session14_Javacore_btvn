package kha1;

import java.util.Scanner;

public class PrimeNumberCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;

        while (true) {
            try {
                System.out.print("Enter an integer number: ");
                number = scanner.nextInt();

                // Check invalid number (<= 0)
                if (number <= 0) {
                    System.out.println("Error: The number must be greater than 0.");
                    continue;
                }

                // Check prime number
                boolean isPrime = true;

                if (number == 1) {
                    isPrime = false;
                } else {
                    for (int i = 2; i <= Math.sqrt(number); i++) {
                        if (number % i == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                }

                // Output result
                if (isPrime) {
                    System.out.println(number + " is a prime number.");
                } else {
                    System.out.println(number + " is NOT a prime number.");
                }

                break; // exit loop after valid input

            } catch (Exception e) {
                System.out.println("Error: Please enter a valid integer number.");
                scanner.nextLine(); // clear invalid input
            }
        }

        scanner.close();
    }
}
