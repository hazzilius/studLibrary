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
            try {
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
                            System.out.println("УДАЛЕНИЕ КНИГИ\n\nСписок книг:");
                            if (!listOfBooks.isEmpty()) {
                                int bookCount = 1;
                                for (Book book1 : listOfBooks) {
                                    System.out.println("\t" + bookCount + ". " + book1.getTitle() + ", " + book1.getAuthor() + " " + book1.getYear());
                                    bookCount++;
                                }
                                System.out.print("Номер удаляемой книги (0 для отмены): ");
                                int deleteIndex = (scanner.nextInt()) - 1;
                                if (deleteIndex != -1) {
                                    try {
                                        System.out.println("\n" + listOfBooks.get(deleteIndex));
                                        System.out.println("Вы действительно хотите удалить книгу?(y/n)");
                                        scanner.nextLine();
                                        String answer = scanner.nextLine();
                                        switch (answer) {
                                            case "Y":
                                            case "y":
                                                listOfBooks.remove(deleteIndex);
                                                saveChanges(listOfBooks);
                                                System.out.println("Удалено!");
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
                                }
                            } else {
                                System.out.println("Нет книг!");
                            }
                            break;
                        case 3:
                            //Просмотр картотеки

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