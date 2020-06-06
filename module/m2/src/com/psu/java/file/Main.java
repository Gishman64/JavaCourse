package com.psu.java.file;

import java.io.*;

public class Main {
    private final static String FILE_PATH = "src\\com\\psu\\java\\file\\sample.txt";

    public static void main(String[] args) throws IOException {
        //-------------Запись данных в файл----------------
        String textToWrite = "This is simple non-formatted text to put in file.\n";
        String formatTextToWrite = "This is simple formatted text to put in file:\n" +
                "example double value: %.3f;\n" +
                "example int value: %05d;\n" +
                "example string value: %s;\n\n";
        //Пример работы с потоковым ввводом/выводом в файл
        File sample = new File(FILE_PATH); //Создание представления файла
        if (!sample.exists()) {
            sample.createNewFile(); //создание файла, если не существует.
        }
        FileOutputStream writer = new FileOutputStream(sample, true);
        writer.write(textToWrite.getBytes());
        writer.write(String.format
                (
                        formatTextToWrite,
                        0.21D,
                        43,
                        textToWrite
                )
                .getBytes());
        writer.close();
        /*
         * Ещё один простой способ записи текстовых данный файл - это использование
         * объекта класса FileWriter. Из названия сразу же вытекает и его функционал.
         * По сути этот класс является оберткой над потоковым вводом/выводом в файл,
         * который мы использовали выше, но имеет расширенный функционал.
         */

        FileWriter writer1 = new FileWriter(sample);
        writer1.write(textToWrite);
        writer1.write(String.format
                (
                        formatTextToWrite,
                        0.21D,
                        43,
                        textToWrite
                ));
        writer1.close();

        //-----------------Чтение данных из файла------------------
        FileReader reader = new FileReader(sample);
        FileInputStream inputStreamReader = new FileInputStream(sample);
        System.out.println(new String(inputStreamReader.readAllBytes()));
        char[] bufferToRead = new char[10];
        reader.read(bufferToRead);
        System.out.println(bufferToRead);
        reader.close();
        inputStreamReader.close();
    }
}
