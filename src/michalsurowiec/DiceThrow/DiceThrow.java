package michalsurowiec.DiceThrow;

import java.util.Random;
import java.util.Scanner;

public class DiceThrow {

    public static void main(String[] args) {
        System.out.println("Wprowadź atrybuty rzutu kostką zgodnie ze schematem 'xDy+z', gdzie:\n" +
                "x - liczba rzutów\n" +
                "y - rodzaj kostki (dostępne rodzaje: 3, 4, 6, 8, 10, 12, 20, 100)\n" +
                "+z - dodatkowe modyfikatory rzutu (można wprowadzić działanie odejmowania) (można pominąć wpisywanie atrybutu z)");

        Scanner scanner = new Scanner(System.in);
        String dice = scanner.next();
        //W kolejnych etapach będzie rewidowane, czy poprawnie wpisano w konsoli tekst na podstawie poniższego booleana.
        boolean properInput = true;

        //Formuła do uzyskania atrybutu X
        StringBuilder xAttribute = new StringBuilder();
        int x = 1;
        int positionY = 0;
        for (int i = 0; i < dice.length(); i++) {
            if (Character.isDigit(dice.charAt(i))) {
                xAttribute.append(dice.charAt(i));
            } else if (dice.charAt(i) == 'D') {
                String xText = xAttribute.toString();
                positionY = i + 1;
                if (xText.length() != 0) {
                    x = Integer.parseInt(xText);
                }
                break;
            } else {
                properInput = false;
            }
        }

        //Szukam atrybutu Y. Jeżeli popełniono wcześniej błąd, cały blok nie zostanie dopuszczony do działania.
        int y = 0;
        int positionZ = dice.length();
        if (properInput) {
            StringBuilder yAttribute = new StringBuilder();
            for (int i = positionY; i < dice.length(); i++) {
                if (Character.isDigit(dice.charAt(i))) {
                    yAttribute.append(dice.charAt(i));
                } else if (dice.charAt(i) == '+' || dice.charAt(i) == '-') {
                    positionZ = i;
                    break;
                } else {
                    properInput = false;
                }
            }
            String yText = yAttribute.toString();
            if (yText.length() > 0) {
                y = Integer.parseInt(yAttribute.toString());
            }

            //Sprawdzam, czy kostka o ilości ścian Y istnieje. Jeżeli nie, zostanie zapisane, że znaleziono błąd
            int[] diceTable = {3, 4, 6, 8, 10, 12, 20, 100};
            for (int i = 0; i < diceTable.length; i++) {
                if (y == diceTable[i]) {
                    properInput = true;
                    break;
                } else {
                    properInput = false;
                }
            }
        }

        //Szukam atrybutu Z. Jeżeli popełniono wcześniej błąd, cały blok nie zostanie dopuszczony do działania.
        int z = 0;
        if(properInput) {
            StringBuilder zAttribute = new StringBuilder();
            for (int i = positionZ; i < dice.length(); i++) {
                if (Character.isDigit(dice.charAt(i)) || (dice.charAt(i) == '-' && i == positionZ) || (dice.charAt(i) == '+' && i == positionZ)) {
                    zAttribute.append(dice.charAt(i));
                } else {
                    properInput = false;
                    break;
                }
            }
            String zText = zAttribute.toString();
            if (zText.length() > 1) {
                z = Integer.parseInt(zText);
            } else if (positionZ != dice.length()) {
                properInput = false;
            }
        }

        //Jeżeli wszystko jest poprawne, wykonuje się rzut kostką według instrukcji podanych przez użytkownika
        int result = 0;
        if (properInput) {
            Random rng = new Random();
            for (int i = 0; i < x; i++) {
                result += rng.nextInt(y) + 1;
            }
            result += z;
            System.out.println("Wynik rzutu kością: " + result);
        } else {
            System.out.println("Niepoprawnie wpisałeś rzut kostką! Wpisz poprawnie według schematu!");
        }

    }

}
