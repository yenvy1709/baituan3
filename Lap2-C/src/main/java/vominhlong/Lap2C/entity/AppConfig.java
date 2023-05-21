package vominhlong.Lap2C.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();

        Book book1 = new Book();
        book1.setId(1L);
        book1.setTitle("Lập trình Web Spring");
        book1.setAuthor("Minh Long");
        book1.setPrice(15.4);
        book1.setCategory("Công nghệ thông tin");
        books.add(book1);

        Book book2 = new Book();
        book2.setId(2L);
        book2.setTitle("Lập trình Web");
        book2.setAuthor("Long Võ");
        book2.setPrice(40.4);
        book2.setCategory("Công nghệ thông tin");
        books.add(book2);

        Book book3 = new Book();
        book3.setId(3L);
        book3.setTitle("Lập trình mạng máy tính");
        book3.setAuthor("David Võ");
        book3.setPrice(20.4);
        book3.setCategory("Công nghệ thông tin");
        books.add(book3);

        Book book4 = new Book();
        book4.setId(4L);
        book4.setTitle("Lập trình bảo mật");
        book4.setAuthor("Milo");
        book4.setPrice(15.4);
        book4.setCategory("Công nghệ thông tin");
        books.add(book4);

        return books;
    }
}
