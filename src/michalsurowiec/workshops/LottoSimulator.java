package michalsurowiec.workshops;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LottoSimulator {

    public static void main(String[] args) {
        System.out.println("Cześć! Zapraszam do Symulatora Lotto! Zasady są proste: wpisz liczbę od 1 do 49 i zatwierdź. \nPo zebraniu 6 liczb wylosujemy dla ciebie liczby i porównamy. Kupon od 3 liczb w górę wygrywa! \nMiłej zabawy!");

        int[] userCoupon = numbersInput();

        tableSorter(userCoupon);

        int[] numbersToGuess = RNG();

        tableSorter(numbersToGuess);

        lotteryChecker(userCoupon, numbersToGuess);

        System.out.println("Dzięki za grę, do następnego!");

    }

    // Metoda służy do pobrania od usera liczb, sprawdzenia ich poprawności i stworzenia z nich tabeli.
    static int[] numbersInput() {
        Scanner console = new Scanner(System.in);
        int[] numbersTable = new int [6];
        for (int i = 0; i < 6;) {
            System.out.println("\nWpisz liczbę");
            //Tu jest pobierana liczba od usera i automatycznie sprawdzana. Jeżeli przejdzie test, jest zapisywana w zmiennej dla dalszego przetworzenia.
            if (console.hasNextInt()) {
                int temp = console.nextInt();
                //Tu sprawdzane jest, czy liczba miesci sie w zaproponowanych granicach.
                if (temp > 0 && temp < 50) {
                    //tu sprawdzane jest, czy liczba się powtórzyła wcześniej. Składa się z pętli, która sprawdza wzystkie liczby, oraz z if,
                    //który sprawdza rezultat fora i realizuje odpowiednie działanie.
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
                //To służy do czyszczenia z konsoli ze wszystkiego, co zostało wpisane, na podstawie założenia, że skoro to nie jest liczbą, to na pewno tego nie potrzebujemy.
                String trashBin = console.nextLine();
            }
        }
        return numbersTable;
    }

    //metoda do sortowania tabeli. Użyto Bubble Sort
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

    // modul losowania - losowanie 6 liczb w zakresie 1-49
    static int[] RNG() {
        int[] numbersTable = new int [6];
        Random lotteryNumbers = new Random();
        for (int i = 0; i < 6;) {
                int temp = lotteryNumbers.nextInt(49) + 1;
                    int error = 0;
                    for (int j = 0; j < i; j++) {
                        if (temp == numbersTable[j]) {
                            error++;
                        }
                    }
                    if (error == 0) {
                        numbersTable[i] = temp;
                        i++;
                    }
                }
        return numbersTable;
    }
// moduł porównawczy - porównuje tabele i zwraca odpowiedni rezultat.
    static void lotteryChecker(int[] userTable, int[] lotteryTable) {
        int correctNumbersCount = 0;
        System.out.println("Twoje liczby: " + Arrays.toString(userTable));
        System.out.println("Wylosowane liczby: " + Arrays.toString(lotteryTable));
        for (int i = 0; i < userTable.length; i++) {
            for (int j = 0; j < lotteryTable.length; j++) {
                if (userTable[i] == lotteryTable[j]) {
                    correctNumbersCount++;
                }
            }
        }
        if (correctNumbersCount >= 3) {
            System.out.println("Brawo! Trafiłeś " + correctNumbersCount + "! Szczęście ci dopisuje! ;)");
        } else {
            System.out.println("Ojej, nie udało ci się :( Trafiłeś " + correctNumbersCount + " liczb. Może spróbuj jeszcze raz?");
        }
    }

}
