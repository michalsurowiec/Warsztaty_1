package michalsurowiec.workshops.michalsurowiec.workshops;

import java.util.Scanner;
//wersja 0.2.0
public class LottoSimulator {

// Do zrobienia - przerobić metodę numbersInput, aby była zdolna do przyjęcia wpisów z konsoli, ale też liczb losowych.
    public static void main(String[] args) {
        System.out.println("Cześć! Zapraszam do Symulatora Lotto! Zasady są proste: wpisz liczbę od 1 do 49 i zatwierdź. \nPo zebraniu 6 liczb wylosujemy dla ciebie liczby i porównamy. Kupon od 3 liczb w górę wygrywa! \nJeżeli chcesz opuścić grę, wpisz quit i zatwierdź. \nMiłej zabawy!");

        int[] userCoupon = numbersInput();

        tableSorter(userCoupon);

        // modul losowania - losowanie 6 liczb w zakresie 1-49, sortowanie rosnaco i wyswietlenie na konsoli

        // modul przetwarzania - porownania zebranych odpowiedzi z wylosowanymi i zwrocenie wyniku

        // modul komunikacyjny - zwrocenie odpowiedniej informacji o rezultacie

        // modul escape - pozwala na opuszczenie gry
    }

    // Metoda służy do pobrania od usera liczb, sprawdzenia ich poprawności i stworzenia z nich tabeli.
    static int[] numbersInput() {
        Scanner console = new Scanner(System.in);
        int[] numbersTable = new int [6];
        for (int i = 0; i < 6;) {
            System.out.println("\nWpisz liczbę");
            if (console.hasNextInt()) {
                int temp = console.nextInt();
                if (temp > 0 && temp < 50) {
                    int error = 0;
                    for (int j = 0; j < i; j++) {
                        if (temp == numbersTable[j]) {
                            error++;
                        }
                    }
                    if (error == 0) {
                        numbersTable[i] = temp;
                        i++;
                    } else {
                        System.out.println("Źle! Wpisałeś tą samą liczbę co poprzednio. Wszystkie muszą być różne. Wpisz poprawną liczbę.");
                    }
                } else {
                    System.out.println("Źle! Wpisałeś liczbę spoza zakresu od 1 do 49. Wpisz liczbę w tym zakresie!");
                }
            } else {
                System.out.println("Źle! Nie wpisałeś liczby całkowitej. Wpisz liczbę.");
                String trashBin = console.nextLine();
            }
        }
        return numbersTable;
    }

    //metoda do sortowania tabeli
    static void tableSorter(int[] tableToSort) {
        for (int i = 0; i < tableToSort.length; i++) {
            for (int j = 0; j < tableToSort.length; j++) {
                if (tableToSort[i] < tableToSort[j]) {
                    int temp = tableToSort[j];
                    tableToSort[j] = tableToSort[i];
                    tableToSort[i] = temp;
                }
            }
        }
    }
}
