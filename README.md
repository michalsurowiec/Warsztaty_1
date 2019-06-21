# Warsztaty z pierwszego tygodnia zajęć w CodersLab
Warsztaty te obejmowały wykonanie pięciu zadań:
1. Gra w zgadywanie liczby,
2. Symulator lotto,
3. Gra w zgadywanie liczby przez komputer,
4. Kostka do gry,
5. Wyszukiwarka najpopularniejszych słów.

## Gra w zgadywanie liczby
Ta gra polega na odgadnięciu liczby wylosowanej przez komputer z zakresu od 1 do 100. Komputer nam podpowiada w trakcie instrukcjami, czy nasza liczba jest za mała czy za duża.

## Symulator lotto
W tym symulatorze komputer losuje nam 6 liczb z zakresu od 1 do 49. Mamy wytypować 6 liczb, które mają mieścić się w tym zakresie i się nie powtarzać. Po wytypowaniu liczb komputer zbierze je, posortuje i porówna z wylosowanymi liczbami, zwracając nam odpowiedź ile liczb udało się trafić. Za wygraną uznaje się trafienie co najmniej 3 liczb.

## Gra w zgadywanie liczby przez komputer
Tym razem to my typujemy liczbę, a komputer ma na celu odgadnięcie liczby. Pomagamy mu przez pisanie instrukcji `za dużo` lub `za mało`. Jeżeli komputer odgadnie naszą liczbę, należy wpisać `zgadłeś`. Przy tej grze należy pamiętać, że komputer całkowicie polega na nas, także łatwo jest go oszukać i odwieźć go od celu.

## Kostka do gry
Jest to symulator kostki do gry, w którym możemy rzucać pewną ilość razów pewnym rodzajem kostki z ewentualnym dodatkiem pewnych atrybutów. W celu poprawnego działania symulatora wykorzystuje się schemat `xDy+z`, który się wpisuje do konsoli. Oznacza to:
* x - ilosć rzutów kostką,
* y - typ kostki (dopuszczalne w grze są kostki z 3, 4, 6, 8, 10, 12, 20 lub 100 ścianami),
* z - dodatkowy atrybut do wyniku całkowitego; dzięki niemu można dodawać lub odejmować od wyniku całkowitego.
Schemat nie jest sztywny. Akceptuje również brak x (uznaje wtedy, że wykonywany jest 1 rzut), a także można pominąć wpisywanie atrybutu (wtedy nie wpisujemy znaku działania i z).
Po sprawdzeniu poprawności wpisanej przez nas wartości, program rzuca kostką zgodnie z podanymi przez nas instrukcjami i zwraca wynik całkowity.

## Wyszukiwarka najpopularniejszych słów
Ten program na podstawie słów zapisanych w pliku `popular_words.txt` jest w stanie przefiltrować zawartość tytułów wybranej przez nas strony i zwrócić nam zbiór tych słów w pliku `filtered_popular_words.txt`. Pozwala to na ich późniejsze wykorzystanie w działaniach statystycznych.
Trzeba zwrócić uwagę, że w celu odpowiedniego działania programu trzeba w kodzie wprowadzić interesującą nas stronę, a także znacznik html z jego klasą, pozwalająca skupić się programowi na konkretnym spektrum tekstu znajdującym się na stronie (w założeniu będącym tytułami artykułów).
