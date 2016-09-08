package Java;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Dmitry Tarashkevich on 23.05.2016.
 */
public class TextAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in,"UTF-8").useDelimiter("[^\\p{Digit}\\p{L}]+");
        System.out.println("Write text to be analyzed: ");

        Map<String, Integer> table = getWordsTable(scanner);
        printTopTenFrequent(table);
    }

    private static void printTopTenFrequent(Map<String, Integer> table) {
        table.entrySet().stream()// opening a stream
                .sorted(Comparator //sorting
                        .<Map.Entry<String,Integer>>comparingInt(Map.Entry::getValue) // ascending compare by NUMBER
                        .reversed() //descending
                        .thenComparing(Map.Entry::getKey)) //then comparing by WORD
                .limit(10) //first 10
                //.map(Map.Entry::getKey) // get only WORDS
                .forEach(System.out::println);
    }

    private static Map<String, Integer> getWordsTable(Scanner scanner) {
        Map<String,Integer> table = new HashMap<>();
        final int INITIAL_FREQUENCY = 1;
        scanner.forEachRemaining(word -> //give every word to CONSUMER
                table.merge(word.toLowerCase() // check word for presence a value(number of word's repetitions)
                , INITIAL_FREQUENCY // give 1 if key(word) hadn't value
                , (currentValue,newValue)-> currentValue + newValue)); // gives a frequency of different values for same keys
        return table;
    }
}
