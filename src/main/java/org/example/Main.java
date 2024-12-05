package org.example;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main extends Operations {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<Book> listOfBooks = new ArrayList<>();

        //Получение данных из файла (при наличии)
        File saveFile = new File("books.txt");
        if (saveFile.exists()) {
            try {
                listOfBooks = getBooksFromJson();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.print("""
                    __    ________  ____  ___    ______  __        ___ ____\s
                   / /   /  _/ __ )/ __ \\/   |  / __ \\ \\/ /  _   _<  // __ \\
                  / /    / // __  / /_/ / /| | / /_/ /\\  /  | | / / // / / /
                 / /____/ // /_/ / _, _/ ___ |/ _, _/ / /   | |/ / // /_/ /\s
                /_____/___/_____/_/ |_/_/  |_/_/ |_| /_/    |___/_(_)____/ \s
                ---------------------------------------\s
                """);
        while (true) {
            //Меню
            System.out.print("""
                  1) Добавить книгу
                  2) Удалить книгу
                  3) Просмотр картотеки
                  4) Выход из программы
               """);
            System.out.print("Выберите действие: ");
            try {
                int option = scanner.nextInt();
                if (option == 4) {
                    //Выход из программы
                    break;
                } else {
                    System.out.println("---------------------------------------");
                    switch (option) {
                        case 1:
                            //Добавить книгу
                            System.out.println("ДОБАВЛЕНИЕ КНИГИ\n");
                            addBook(listOfBooks);
                            break;
                        case 2:
                            //Удалить книгу
                            System.out.println("УДАЛЕНИЕ КНИГИ\n\nСписок книг:");
                            removeBook(listOfBooks);
                            break;
                        case 3:
                            //Просмотр картотеки
                            System.out.print("""
                                       1) Поиск
                                       2) Список книг
                                    """);
                            System.out.print("Выберите действие: ");
                            int viewOption = scanner.nextInt();
                            System.out.println("---------------------------------------");
                            switch (viewOption){
                                case 1:
                                    //Поиск по картотеке
                                    System.out.print("""
                                    Поиск по:
                                       1) Автору
                                       2) Названию
                                       3) Издательству
                                       4) Году
                                       5) Разделу
                                    """);
                                    System.out.print("Выберите параметр: ");
                                    int searchParameter = scanner.nextInt();
                                    System.out.print("Запрос: ");
                                    scanner.nextLine();
                                    String searchRequest = scanner.nextLine();
                                    System.out.print("\n");
                                    switch (searchParameter){
                                        case 1:
                                            printBooks(listOfBooks, SearchOptions.AUTHOR, searchRequest);
                                            break;
                                        case 2:
                                            printBooks(listOfBooks, SearchOptions.TITLE, searchRequest);
                                            break;
                                        case 3:
                                            printBooks(listOfBooks, SearchOptions.PUBLISHER, searchRequest);
                                            break;
                                        case 4:
                                            printBooks(listOfBooks, SearchOptions.YEAR, searchRequest);
                                            break;
                                        case 5:
                                            printBooks(listOfBooks, SearchOptions.SECTION, searchRequest);
                                            break;
                                        default:
                                            System.out.println("Неправильный ввод!");
                                            break;
                                    }
                                    break;
                                case 2:
                                    //Вывод списка книг
                                    System.out.println("ВСЕ КНИГИ\n");
                                    printBooks(listOfBooks);
                                    break;
                                    default:
                                        System.out.println("Неправильный ввод!");
                                        break;
                            }
                            break;
                        default:
                            System.out.println("Неправильный ввод!");
                            break;
                    }
                    System.out.println("---------------------------------------");
                }
            } catch (InputMismatchException e){
                System.out.println("---------------------------------------\nНеправильный ввод!\n---------------------------------------");
                scanner.nextLine();
            }
        }
    }
}