import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Word Counter!");
        System.out.println("Enter '1' to input text or '2' to provide a file:");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String text = "";
        if (choice == 1) {
            System.out.println("Enter the text:");
            text = scanner.nextLine();
        } else if (choice == 2) {
            System.out.println("Enter the file path:");
            String filePath = scanner.nextLine();
            try {
                text = readFromFile(filePath);
            } catch (IOException e) {
                System.err.println("Error reading the file. Please check the file path.");
                return;
            }
        } else {
            System.err.println("Invalid choice. Please enter '1' or '2'.");
            return;
        }

        // Split the text into words using regex
        String[] words = text.split("[\\s\\p{Punct}]+");

        // Initialize a counter variable
        int wordCount = words.length;

        // Enhancements: Ignore common words (stop words) and provide word frequency
        Map<String, Integer> wordFrequency = new HashMap<>();
        String[] stopWords = {"the", "and", "is", "in", "to", "a", "of"};

        for (String word : words) {
            word = word.toLowerCase();
            if (!isStopWord(word, stopWords)) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        System.out.println("Total words: " + wordCount);
        System.out.println("Unique words: " + wordFrequency.size());

        // Display word frequency (optional)
        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static boolean isStopWord(String word, String[] stopWords) {
        for (String stopWord : stopWords) {
            if (word.equals(stopWord)) {
                return true;
            }
        }
        return false;
    }

    private static String readFromFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");
            }
        }
        return content.toString();
    }
}
