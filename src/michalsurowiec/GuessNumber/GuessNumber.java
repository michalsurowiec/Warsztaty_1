package michalsurowiec.GuessNumber;

import java.util.Random;
import java.util.Scanner;


public class GuessNumber {



    public static void main(String[] args) {
        Random rng = new Random();
        int numberToGuess = rng.nextInt(100) + 1;
        boolean accomplishment = false;

        System.out.println("Cześć! Zapraszam do gry w zgadywanie liczby. \nZasady są proste: spróbuj zgadnąć, jaka liczba została wylosowana od 1 do 100. \nPowodzenia!\n");

        int stepsQuantity = 0;
        while (!accomplishment) {
            Scanner console = new Scanner(System.in);
            stepsQuantity++;
            System.out.println("Twoja liczba to:");

            if (console.hasNextInt()) {
                int answer = console.nextInt();
                    if (answer == numberToGuess) {
                        accomplishment = true;
                        System.out.println("Brawo! Odgadłeś liczbę! To było właśnie " + numberToGuess + " ." +
                                "\nUdało ci się odgadnąć liczbę w " + stepsQuantity + " krokach!" +
                                "\nDzięki, że zagrałeś!");
                    } else if (answer > numberToGuess) {
                        System.out.println("Za duża liczba! Spróbuj mniejszą");
                    } else if (answer < numberToGuess) {
                        System.out.println("Za mała liczba! Spróbuj większą");
                    }
            } else {
                System.out.println("Źle! Miałeś wprowadzić liczbę całkowitą! :(");
            }
        }
    }
}
