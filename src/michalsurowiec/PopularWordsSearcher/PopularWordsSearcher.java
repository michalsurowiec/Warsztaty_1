package michalsurowiec.PopularWordsSearcher;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PopularWordsSearcher {

    public static void main(String[] args) {
        Connection connect = Jsoup.connect("https://www.gazeta.pl/0,0.html");
        try {
            Document document = connect.get();
            Elements links = document.select("span");
            PrintWriter printWriter = new PrintWriter("/home/michal/Pulpit/Warsztaty/Warsztaty_1/src/michalsurowiec/PopularWordsSearcher/filtered_popular_words.txt");
            for (Element elem : links) {
                //przygotowanie tytułu
                String title = elem.text();
                String titleOne = title.replaceAll(",", "");
                String titleTwo = titleOne.replaceAll("\\.", "");
                String titleThree = titleTwo.replaceAll("\\?", "");
                String titleFour = titleThree.replaceAll("!", "");
                String titleFive = titleFour.replaceAll("\"", "");
                String titleFinal = titleFive.toLowerCase();

                String[] titleTable = titleFinal.split(" ");
                for (String splitedTitle : titleTable) {
                    File file = new File("/home/michal/Pulpit/Warsztaty/Warsztaty_1/src/michalsurowiec/PopularWordsSearcher/popular_words.txt");
                    Scanner scannerPopularWords = new Scanner(file);
                    while (scannerPopularWords.hasNext()) {
                        if (splitedTitle.equals(scannerPopularWords.next())) {
                            printWriter.println(splitedTitle);
                        }
                    }
                }
            }
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
