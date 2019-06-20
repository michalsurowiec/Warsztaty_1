package michalsurowiec.HelpComputerGuessNumber;

import java.util.Scanner;

public class HelpComputerGuessNumber {

    public static void main(String[] args) {
        System.out.println("Pomyśl liczbę od 0 do 1000, a ja zgadnę ją w 10 próbach z twoją pomocą! \n" +
                "Po wpisaniu liczby używaj tych trzech odpowiedzi: 'zgadłeś', 'za dużo' lub 'za mało'. Miłej zabawy!");

        //Sprawdzenie, czy wprowadzona liczba jest poprawna i spełnia warunki.
        int numberToGuess = 0;
        boolean lackOfNumber = true;
        System.out.println("Wprowadź liczbę całkowitą.");
        while (lackOfNumber) {
            Scanner console = new Scanner(System.in);
            if (console.hasNextInt()) {
                numberToGuess = console.nextInt();
                if (numberToGuess >= 0 && numberToGuess <= 1000) {
                    lackOfNumber = false;
                } else {
                    System.out.println("Wprowadziłeś złą liczbę! Wpisz liczbę z przedziału od 0 do 1000.");
                }
            } else {
                System.out.println("Źle! Wprowadź liczbę całkowitą!");
            }
        }

        int max = 1000;
        int min = 0;
        for (int i = 1; i <=10; i++) {
            Scanner consoleAnswer = new Scanner(System.in);
            int guess = (max - min)/2 + min;
            System.out.println("Zgaduję: " + guess);
            System.out.println("Zgadłem?");
            String answer = consoleAnswer.nextLine();
            if (answer.equals("zgadłeś")) {
                System.out.println("Wygrałem!");
                System.out.println("Zrobiłem to w " + i + " podejść!");
                break;
            } else if (answer.equals("za dużo")) {
                max = guess;
            } else if (answer.equals("za mało")) {
                min = guess;
            } else {
                System.out.println("Nie oszukuj!");
                i--;
            }
        }
    }
}
