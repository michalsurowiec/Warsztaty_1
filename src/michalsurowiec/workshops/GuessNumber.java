package michalsurowiec.workshops;

import java.util.Random;
import java.util.Scanner;


public class GuessNumber {



    public static void main(String[] args) {
        Random rng = new Random();
        int numberToGuess = rng.nextInt(100) + 1;
        Scanner console = new Scanner(System.in);
        boolean accomplishment = false;

        System.out.println("Cześć! Zapraszam do gry w zgadywanie liczby. \nZasady są proste: spróbuj zgadnąć, jaka liczba została wylosowana od 1 do 100. \nPowodzenia!\n");

        while (!accomplishment) {
            System.out.println("Twoja liczba to:");

            if (console.hasNextInt()) {
                int answer = console.nextInt();
                    if (answer == numberToGuess) {
                        accomplishment = true;
                        System.out.println("Brawo! Odgadłeś liczbę! To było właśnie " + numberToGuess + " . \nDzięki, że zagrałeś!");
                    } else if (answer > numberToGuess) {
                        System.out.println("Za duża liczba! Spróbuj mniejszą");
                    } else if (answer < numberToGuess) {
                        System.out.println("Za mała liczba! Spróbuj większą");
                    }
            } else {
                System.out.println("Źle! Miałeś wprowadzić liczbę całkowitą! :(");
                String trashBin = console.nextLine();
            }
        }
    }
}
