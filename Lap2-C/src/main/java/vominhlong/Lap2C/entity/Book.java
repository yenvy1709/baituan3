package vominhlong.Lap2C.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data


public class Book {
    private Long id;
    private String title;
    private String author;
    private double price;
    private String category;

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", category=" + category + "]";
    }
}
