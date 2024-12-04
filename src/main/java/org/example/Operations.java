package org.example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.io.*;

public class Operations{
    public static List<Book> getBooksFromJson() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        List<Book> books = objectMapper.readValue(new File("books.txt"), new TypeReference<>() {});
        return books;
    }

    public static void saveBooksInJson(List<Book> books) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(books);
        try (FileWriter fw = new FileWriter("books.txt", false)){
            fw.write(json);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
