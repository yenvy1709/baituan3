package nguyencuutinh.lap2_3.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public List<Book>getBooks(){
        List<Book> books = new ArrayList<>();
        Book book1 = new Book();
        book1.setId((1L));
        book1.setTitle("Lap trinh Web Spring MVC");
        book1.setAuthor("Anh Nguyén");
        book1.setPrice(10.99);
        book1.setCategory("Cong nghe thong tin");
        books.add(book1) ;

        Book book2 = new Book();
        book2.setId((1L));
        book2.setTitle("Lap trinh ung dung Spring");
        book2.setAuthor("Huy Cuong");
        book2.setPrice(12.99);
        book2.setCategory("Cong nghe thong tin");
        books.add(book2) ;

        Book book3 = new Book();
        book3.setId((1L));
        book3.setTitle("Lap trinh Web Spring MVC");
        book3.setAuthor("Xuan Nhan");
        book3.setPrice(10.99);
        book3.setCategory("Cong nghe thong tin");
        books.add(book3) ;

        Book book4 = new Book();
        book4.setId((1L));
        book4.setTitle("Lap trinh Web Java");
        book4.setAuthor("Dang khoa");
        book4.setPrice(15.99);
        book4.setCategory("Cong nghe thong tin");
        books.add(book4) ;

        return books;
    }
}
