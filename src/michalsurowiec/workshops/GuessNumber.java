package michalsurowiec.workshops;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {



    public static void main(String[] args) {
        Random rng = new Random();
        int numberToGuess = rng.nextInt();
        Scanner console = new Scanner(System.in);
        boolean accomplishment = false;

        System.out.println("Cześć! Zapraszam do gry w zgadywanie liczby. \nZasady są proste: spróbuj zgadnąć, jaka liczba została wylosowana od 1 do 100. \nPowodzenia!\n");

        while (accomplishment) {
            boolean correctness = true;
            System.out.println("Twoja liczba to:");
            console.nextInt();
            try {
                int answer = console.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Źle! Miałeś wprowadzić liczbę całkowitą! :(");
                correctness = false;
            }
            int answer = console.nextInt();
            if (correctness) {
                if (answer == numberToGuess) {
                    accomplishment = true;
                    System.out.println("Brawo! Odgadłeś liczbę! To było właśnie " + numberToGuess + " . \nDzięki, że zagrałeś!");
                } else if (answer > numberToGuess) {
                    System.out.println("Za duża liczba! Spróbuj mniejszą");
                } else  if (answer < numberToGuess) {
                    System.out.println("Za mała liczba! Spróbuj większą");
                }
            }
        }
    }
}
