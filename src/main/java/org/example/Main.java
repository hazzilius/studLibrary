package org.example;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Main extends Operations {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<Book> listOfBooks = new ArrayList<>();
        File saveFile = new File("books.json");
        if (saveFile.exists()) {
            listOfBooks = getBooksFromJson();
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
                    case 1:
                        //Добавить книгу
                        System.out.println("ДОБАВЛЕНИЕ КНИГИ\n");
                        System.out.print("Название: ");
                        scanner.nextLine();
                        String title = scanner.nextLine();
                        System.out.print("Автор: ");
                        String author = scanner.nextLine();
                        System.out.print("Издательство: ");
                        String publisher = scanner.nextLine();
                        System.out.print("Год издания книги: ");
                        int year = scanner.nextInt();
                        System.out.print("Раздел библиотеки: ");
                        scanner.nextLine();
                        String section = scanner.nextLine();
                        Book book = new Book(author, title, publisher, year, section);

                        listOfBooks.add(book);
                        try {
                            saveBooksInJson(listOfBooks);
                        } catch (JsonProcessingException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        //Удалить книгу
                        break;
                    case 3:
                        //Поиск по книгам
                        break;
                    default:
                        System.out.println("Неправильный ввод!");
                        break;
                }
                System.out.println("---------------------------------------");
            }
        }
    }
}