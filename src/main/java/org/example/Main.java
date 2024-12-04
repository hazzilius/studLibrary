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
        File saveFile = new File("books.txt");
        if (saveFile.exists()) {
            try {
                listOfBooks = getBooksFromJson();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            //Меню
            System.out.print("""
                1) Добавить книгу
                2) Удалить книгу
                3) Просмотр картотеки
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
                        saveChanges(listOfBooks);
                        break;
                    case 2:
                        //Удалить книгу
                        System.out.println("УДАЛЕНИЕ КНИГИ\n");
                        System.out.print("Введите номер книги: ");
                        int deleteIndex = scanner.nextInt();
                        try {
                            System.out.println(listOfBooks.get(deleteIndex));
                            System.out.println("Вы действительно хотите удалить книгу?(y/n)");
                            scanner.nextLine();
                            String answer = scanner.nextLine();
                            switch (answer) {
                                case "Y":
                                case "y":
                                    listOfBooks.remove(deleteIndex);
                                    saveChanges(listOfBooks);
                                    break;
                                case "N":
                                case "n":
                                    break;
                                default:
                                    System.out.println("Неправильный ввод!");
                                    break;
                            }
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Такой книги нет!");
                        }
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

    static void saveChanges (List<Book> listOfBooks){
        try {
            saveBooksInJson(listOfBooks);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
    }
}