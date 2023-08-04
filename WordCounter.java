import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter '1' to input text or '2' to provide a file: ");
        int choice = scanner.nextInt();

        String text;
        if (choice == 1) {
            System.out.println("Enter the text: ");
            scanner.nextLine(); 
            text = scanner.nextLine();
        } else if (choice == 2) {
            System.out.println("Enter the file path: ");
            scanner.nextLine(); 
            String filePath = scanner.nextLine();
            text = readFile(filePath);
            if (text == null) {
                System.out.println("Error reading the file.");
                scanner.close();
                return;
            }
        } else {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }
         
        int wordCount = countWords(text);
        System.out.println("Total words: " + wordCount);

        Map<String, Integer> wordFrequency = getWordFrequency(text);
        System.out.println("Unique words: " + wordFrequency.size());
        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            scanner.close();
        }
    }

    private static String readFile(String filePath) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static int countWords(String text) {
        String[] words = text.split("\\s+|\\p{Punct}");
        return words.length;
    }

    private static Map<String, Integer> getWordFrequency(String text) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        String[] words = text.split("\\s+|\\p{Punct}");
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        return wordFrequency;
    }
}
