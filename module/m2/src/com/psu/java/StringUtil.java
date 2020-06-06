package com.psu.java;

public class StringUtil {

    public static void notifyIfHasPalindrome(String text) {
        String[] wordInString = text.split(" ");
        for (String s : wordInString) { // цикл типа foreach для последовательной итерации элементов коллекции
            String tempString = reverseString(s);
            if (s.equals(tempString)) {
                System.out.println(String.format("Найден палиндром: %s в строке \"%s\"", tempString, text));
            }
        }
    }

    private static String reverseString(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        return stringBuilder.reverse().toString();
    }
}
