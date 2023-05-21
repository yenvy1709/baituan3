package vominhlong.Lap2C.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vominhlong.Lap2C.entity.AppConfig;
import vominhlong.Lap2C.entity.Book;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    private List<Book> books = new ArrayList<>();

    public BookController(AppConfig appConfig) {
        this.books = appConfig.getBooks();
    }
    @GetMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("books", books);
        model.addAttribute("title", "Book List");
        return "book/list";
    }

    @GetMapping("/books/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("title", "Add Book");
        return "book/add";
    }

    @PostMapping("/books/add")
    public String addBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        book.setId((long) (books.size() + 1));
        books.add(book);
        redirectAttributes.addFlashAttribute("message", "Book added successfully");
        return "redirect:/books";
    }

    @GetMapping("/books/edit/{id}")
    public String editBookForm(@PathVariable("id") Long id, Model model) {
        Book book = books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        model.addAttribute("book", book);
        model.addAttribute("title", "Edit Book");
        return "book/edit";
    }

    @PostMapping("/books/edit")
    public String editBook(@ModelAttribute("book") Book updatedBook, RedirectAttributes redirectAttributes) {
        books.stream()
                .filter(b -> b.getId().equals(updatedBook.getId()))
                .findFirst()
                .ifPresentOrElse(
                        book -> {
                            book.setTitle(updatedBook.getTitle());
                            book.setAuthor(updatedBook.getAuthor());
                            book.setPrice(updatedBook.getPrice());
                            book.setCategory(updatedBook.getCategory());
                            redirectAttributes.addFlashAttribute("message", "Book updated successfully");
                        },
                        () -> {
                            throw new IllegalArgumentException("Book not found");
                        }
                );

        return "redirect:/books";
    }
    @GetMapping ("/books/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        books.removeIf(book -> book.getId().equals(id));
        return "redirect:/books";
    }
}


