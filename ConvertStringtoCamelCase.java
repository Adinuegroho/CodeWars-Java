/*
Complete the method/function so that it converts dash/underscore delimited words into camel casing.
The first word within the output should be capitalized only if the original word was capitalized
(known as Upper Camel Case, also often referred to as Pascal case).
The next words should be always capitalized.

Examples
"the-stealth-warrior" gets converted to "theStealthWarrior"

"The_Stealth_Warrior" gets converted to "TheStealthWarrior"

"The_Stealth-Warrior" gets converted to "TheStealthWarrior"
*/

import java.util.Arrays;

public class ConvertStringtoCamelCase {

    /* first */
    static String toCamelCase(String s) {
        String[] words = s.split("[-_]");
        StringBuilder camelCase = new StringBuilder(words[0]);

        for (int i = 1; i < words.length; i++) {
            camelCase.append(words[i].substring(0, 1).toUpperCase())
                    .append(words[i].substring(1));
        }

        return camelCase.toString();
    }

    /* second */
    static String toCamelCaseSecond(String str){
        String[] words = str.split("[-_]");
        return Arrays.stream(words, 1, words.length)
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .reduce(words[0], String::concat);
    }

    public static void main(String[] args) {
        String testInput = "the-stealth-warrior";
        String testInput2 = "The_Stealth_Warrior";
        String testInput3 = "The_Stealth-Warrior";

        System.out.println(toCamelCase(testInput));
        System.out.println(toCamelCase(testInput2));
        System.out.println(toCamelCase(testInput3));

        System.out.println(toCamelCaseSecond(testInput));
        System.out.println(toCamelCaseSecond(testInput2));
        System.out.println(toCamelCaseSecond(testInput3));
    }

}
