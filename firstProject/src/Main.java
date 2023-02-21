import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;

    public static String calc(String userInput){
        char[] under_char = new char[10];

        for (int i = 0; i < userInput.length(); i++) {
            under_char[i] = userInput.charAt(i);
            if (under_char[i] == '+') {
                operation = '+';
            }
            if (under_char[i] == '-') {
                operation = '-';
            }
            if (under_char[i] == '*') {
                operation = '*';
            }
            if (under_char[i] == '/') {
                operation = '/';
            }
        }
        String under_charString = String.valueOf(under_char);
        String[] blacks = under_charString.split("[+-/*]");
        if (blacks.length > 2) {
            System.out.println("Wrong input. Too more operands!");
            System.exit(0);
        }

        boolean a = false, b = false;
        String stable00 = blacks[0];
        for(int i = 0; i < stable00.length(); i++) {
            if(Character.isDigit(stable00.charAt(i))) {
                a = true;
            }
        }
        String stable01 = blacks[1];
        for(int i = 0; i < stable01.length(); i++) {
            if(Character.isDigit(stable01.charAt(i))) {
                b = true;
            }
        }
        if(a && !b || !a && b){
            System.out.println("Wrong input. You should use only arabic or only roman numbers!");
            System.exit(0);
        }
        String string03 = stable01.trim();
        number1 = romanToNumber(stable00);
        number2 = romanToNumber(string03);

        if (number1 < 0 && number2 < 0) {
            result = 0;
        } else {
            if(number1 < 1 || number2 < 1 || number1 > 10 || number2 > 10){
                System.out.println("Wrong input. Out of range!");
                System.exit(0);
            }
            result = calculated(number1, number2, operation);
            String resultRoman = convertNumToRoman(result);
            System.out.println(resultRoman);
            System.exit(0);
        }

        number1 = Integer.parseInt(stable00);
        number2 = Integer.parseInt(string03);
        if(number1 < 1 || number2 < 1 || number1 > 10 || number2 > 10){
            System.out.println("Wrong input. Out of range!");
            System.exit(0);
        }
        result = calculated(number1, number2, operation);
        String result1 = Integer.toString(result);
        return result1;
    }
    public static void main (String[] args) {
        System.out.println("Input expression [2+2] or two roman numbers from I to X:[V+V] + Enter ");
        String userInput1 = scanner.nextLine();
        String userInput = userInput1.replaceAll(" ", "");

        String result = calc(userInput);
        System.out.println(result);
    }

    static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X","XI",
                "XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX", "XXI", "XXII", "XXIII",
                "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII",
                "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII",
                "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV",
                "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII",
                "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[numArabian];
    }


    static int romanToNumber (String roman) {
        try {
            switch (roman) {
                case "I":
                    return 1;
                case "II":
                    return 2;
                case "III":
                    return 3;
                case "IV":
                    return 4;
                case "V":
                    return 5;
                case "VI":
                    return 6;
                case "VII":
                    return 7;
                case "VIII":
                    return 8;
                case "IX":
                    return 9;
                case "X":
                    return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Wrong data format.");
        }
        return -1;
    }

    static int calculated (int number1, int number2, char operation) {
        int result = 0;
        switch (operation) {
            case '+' -> result = number1 + number2;
            case '-' -> result = number1 - number2;
            case '*' -> result = number1 * number2;
            case '/' -> {
                try {
                    result = number1 / number2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Only integer non-zero parameters allowed");

                }
            }
            default -> throw new IllegalArgumentException("Wrong operation.");
        }
        return result;
    }
}