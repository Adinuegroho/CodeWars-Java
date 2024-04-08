// Create a function that takes an integer as an argument and returns "Even" for even numbers or "Odd" for odd numbers.

public class EvenorOdd {
    public static String checkEvenOrOdd(int number) {
        if (number % 2 == 0) {
            return "Even";
        } else {
            return "Odd";
        }
    }

    public static String checkEvenOrOdd2(int number) {
        return (number % 2 == 0) ? "Even" : "Odd";
    }


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " is : " + checkEvenOrOdd(i));
            System.out.println(i + " is : " + checkEvenOrOdd2(i));
        }
    }
}
