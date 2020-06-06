package com.psu.java.console;

import org.w3c.dom.ls.LSOutput;

import java.io.Console;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //-----------Консольный ввод вывод------------
        OutputStream os = System.out;
        //Так как outStream является абстракцией, общим описанием поведения потоков вывода
        //то мы не можем использовать перегруженные методы объекта system.out напрямую
        os.write("sample.sample\n".getBytes());
        //Но если использовать такую конструкцию, то будет доступ к методу println
        System.out.println("sample.sample\n");
        String userInteraction;
        //Сканнер сканирует переданный ему при создании поток и взаимодействует с ним
        //также сканнер может сканировать отдельно взятые строки
        Scanner scanner = new Scanner(System.in);
        //Таким образом мы можем вернуть строку которую введет пользователь.
        //Так же модно вернуть и целочисленное значение, число с запятой и т.д. просто выбрав нужный метод
        System.out.println("Введите строку: ");
        userInteraction = scanner.nextLine();
        System.out.println(userInteraction);
        double userDouble;
        System.out.println("Введите число с плавающей запятой");
        userDouble = scanner.nextDouble();
        System.out.println(userDouble);
    }
}
