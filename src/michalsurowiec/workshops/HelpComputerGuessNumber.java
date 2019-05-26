package michalsurowiec.workshops;

import java.util.Scanner;

public class HelpComputerGuessNumber {

    public static void main(String[] args) {
        System.out.println("Pomyśl liczbę od 1 do 1000, a ja zgadnę ją w 10 próbach!");
        Scanner console = new Scanner(System.in);
        int numberToGuess = 0;
        
        while (numberToGuess == 0)
        if (console.hasNextInt()) {
            numberToGuess = console.nextInt();
            if (!(numberToGuess >= 1 && numberToGuess <= 1000)) {
                numberToGuess = 0;
                System.out.println("Wprowadziłeś złą liczbę! Wpisz liczbę z przedziału od 1 do 1000.");
            }
        } else {
            System.out.println("Źle! Wprowadź liczbę całkowitą!");
            String trashBin = console.nextLine();
        }




    }
}
