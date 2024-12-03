package org.example;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Main extends Operations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> listOfBooks;
        File saveFile = new File("books.json");
        if (saveFile.exists()) {
            // Что то
        } else {
            listOfBooks = new ArrayList<>();
        }

        while (true) {
            //Меню
            System.out.print("""
                1) Добавить книгу
                2) Удалить книгу
                3) Поиск по книгам
                4) Выход из программы
               """);
            System.out.print("Выберите действие: ");
            int option = scanner.nextInt();
            if (option == 4) {
                break;
            } else {
                System.out.println("---------------------------------------");
                switch (option) {
                    default:
                        System.out.println("Неправильный ввод!");
                        break;
                }
                System.out.println("---------------------------------------");
            }
        }
    }
}