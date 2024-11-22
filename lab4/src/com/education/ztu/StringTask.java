package com.education.ztu;

public class StringTask {
    public static void run() {
        String inputString = "I learn Java!!!";

        char lastChar = getLastCharacter(inputString);
        System.out.println("Last character: " + lastChar);

        boolean endsWithExclamation = inputString.endsWith("!!!");
        System.out.println("Ends with \"!!!\": " + endsWithExclamation);

        boolean startsWithILearn = inputString.startsWith("I learn ");
        System.out.println("Starts with \"I learn \": " + startsWithILearn);

        boolean containsJava = inputString.contains("Java");
        System.out.println("Contains \"Java\": " + containsJava);

        int positionOfJava = inputString.indexOf("Java");
        System.out.println("Position of \"Java\": " + positionOfJava);

        String replacedString = inputString.replace('a', 'o');
        System.out.println("String after replacing 'a' with 'o': " + replacedString);

        String upperCaseString = inputString.toUpperCase();
        System.out.println("Upper case: " + upperCaseString);

        String lowerCaseString = inputString.toLowerCase();
        System.out.println("Lower case: " + lowerCaseString);

        String substringJava = extractSubstring(inputString, "Java");
        System.out.println("Substring \"Java\": " + substringJava);
    }

    private static char getLastCharacter(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("String cannot be null or empty");
        }
        return input.charAt(input.length() - 1);
    }

    private static String extractSubstring(String input, String substring) {
        int startIndex = input.indexOf(substring);
        if (startIndex == -1) {
            return "Substring not found";
        }
        return input.substring(startIndex, startIndex + substring.length());
    }
}
