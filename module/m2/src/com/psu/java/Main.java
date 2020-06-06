package com.psu.java;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int count;
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.print("Введите количество строк: ");
        count = Integer.parseInt(scanner.nextLine());
        String[] strings = new String[count];

        for (int i = 0; i < count; i++) {
            System.out.print(String.format("Введите строку %d : ", i + 1));
            strings[i] = scanner.nextLine(); // заполняем массив строк
        }

        for (String s : strings) {
            StringUtil.notifyIfHasPalindrome(s); //информируем пользователя о найденных палиндромах
        }
    }
}