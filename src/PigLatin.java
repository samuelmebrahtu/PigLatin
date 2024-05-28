import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class PigLatin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to be translated into Pig Latin >> ");
        String input = scanner.nextLine();
        scanner.close();
        System.out.println(pigLatin(input));
    }

    public static String pigLatin(String input) {
        String[] words = input.split(" ");
        List<String> translated = new ArrayList<>();
        List<String> vowels = Arrays.asList("a","e","i","o","u");
        for (String word: words) {
            if (vowels.contains(Character.toString(word.charAt(0)))) {
                translated.add(word+"way");
            }
            else {
                int i = 0;
                List<String> consonants = new ArrayList<>();
                while (!vowels.contains(Character.toString(word.charAt(0)))) {
                    consonants.add(Character.toString(word.charAt(i)));
                    word = word.substring(i+1);
                }
                word = word + String.join("", consonants) + "ay";
                translated.add(word);
            }
        }
        return String.join(" ", translated);
    }
}
