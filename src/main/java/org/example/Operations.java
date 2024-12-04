package org.example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.InputMismatchException;
import java.util.List;
import java.io.*;
import java.util.Scanner;

public class Operations{
    //Десереализация списка книг из JSON
    public static List<Book> getBooksFromJson() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File("books.txt"), new TypeReference<>() {});
    }

    //Сериализация списка книг в JSON и запись в файл
    public static void saveChanges(List<Book> books) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(books);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        try (FileWriter fw = new FileWriter("books.txt", false)){
            fw.write(json);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void addBook(List<Book> listOfBooks){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Название: ");
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
        System.out.println("Добавлено!");
    }


    public static void printBooks(List<Book> listOfBooks){
        if (!listOfBooks.isEmpty()){
            int count = 1;
            for (Book book : listOfBooks){
                System.out.println("Книга " + count + "\n" + book);
                count++;
            }
        } else {
            System.out.println("Нет книг!");
        }
    }

    public static void printBooks(List<Book> listOfBooks, SearchOptions searchOption, String searchRequest){
        if (!listOfBooks.isEmpty() && !searchRequest.isEmpty()){
            int count = 1;
            String result = "";
            try {
                for (Book book : listOfBooks){
                    switch (searchOption){
                        case AUTHOR:
                            if (book.getAuthor().contains(searchRequest)){
                                result += "Книга " + count + "\n" + book + "\n";
                                count++;
                            }
                            break;
                        case TITLE:
                            if (book.getTitle().contains(searchRequest)){
                                result += "Книга " + count + "\n" + book + "\n";
                                count++;
                            }
                            break;
                        case PUBLISHER:
                            if (book.getPublisher().contains(searchRequest)){
                                result += "Книга " + count + "\n" + book + "\n";
                                count++;
                            }
                            break;
                        case YEAR:
                            if (book.getYear() == Integer.parseInt(searchRequest)){
                                result += "Книга " + count + "\n" + book + "\n";
                                count++;
                            }
                            break;
                        case SECTION:
                            if (book.getSection().contains(searchRequest)){
                                result += "Книга " + count + "\n" + book + "\n";
                                count++;
                            }
                            break;
                    }
                }
            } catch (NumberFormatException e){
                System.out.println("Неправильный ввод!");
            }
            if (result.isEmpty()){
                result = "Ничего не найдено!\n";
            }
            System.out.print(result);
        } else {
            System.out.println("Нет книг!");
        }
    }
}
