import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text (type 'exit' to finish):");

        Map<String, Integer> wordCounts = new HashMap<>();
        String inputLine;

        while (!(inputLine = scanner.nextLine()).equalsIgnoreCase("exit")) {
            processInput(inputLine, wordCounts);
            System.out.println("Enter more text or 'exit' to finish:");
        }

        scanner.close();
        printWordCounts(wordCounts);
    }

    public static void processInput(String input, Map<String, Integer> wordCounts) {
        String[] words = input.split("\\s+");
        for (String word : words) {
            word = word.toLowerCase().replaceAll("[^a-zA-Z0-9']", "");
            if (!word.isEmpty()) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }
    }

    public static void printWordCounts(Map<String, Integer> wordCounts) {
        TreeMap<String, Integer> sortedWordCounts = new TreeMap<>(wordCounts);
        sortedWordCounts.forEach((word, count) -> System.out.println(word + ": " + count));
    }
}
