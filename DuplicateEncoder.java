import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.stream.Collectors;

// The goal of this exercise is to convert a string to a new string where each character in
// the new string is "(" if that character appears only once in the original string, or ")"
// if that character appears more than once in the original string. Ignore capitalization
// when determining if a character is a duplicate.

public class DuplicateEncoder {
    public static String encode(String word) {
        // Convert the original string to lowercase
        String lowercaseWord = word.toLowerCase();
        StringBuilder result = new StringBuilder();

        // Create a HashMap to store character frequencies
        HashMap<Character, Integer> charFreq = new HashMap<>();

        // Count the occurrences of each character
        for (char c : lowercaseWord.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }

        // Append '(' if the character appears only once, ')' otherwise
        for (char c : lowercaseWord.toCharArray()) {
            if (charFreq.get(c) == 1) {
                result.append('(');
            } else {
                result.append(')');
            }
        }

        return result.toString();
    }

    public static String encode2(String word) {
        word = word.toLowerCase();
        String result = "";
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            result += word.lastIndexOf(c) == word.indexOf(c) ? "(" : ")";
        }
        return result;
    }

    public static String encode3(String word) {
        return word.toLowerCase()
                .chars()
                .mapToObj(i -> String.valueOf((char)i))
                .map(i -> word.toLowerCase().indexOf(i) == word.toLowerCase().lastIndexOf(i) ? "(" : ")")
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        // Test the method with a sample string
        String testString = "aaa";
        String testString2 = "abc";
        String testString3 = "abb";
        String testString4 = "aba";
        System.out.println(encode(testString));
        System.out.println(encode2(testString2));
        System.out.println(encode3(testString3));
        System.out.println(encode3(testString4));
    }
}
