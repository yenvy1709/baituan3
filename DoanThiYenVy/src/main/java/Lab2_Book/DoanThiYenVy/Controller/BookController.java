package Lab2_Book.DoanThiYenVy.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import Lab2_Book.DoanThiYenVy.enity.Book;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private List<Book> books;

    @GetMapping
    public String listbooks(Model model)
    {
        model.addAttribute("books",books);
        model.addAttribute("title","Book List");
        return "book/list";
    }
    @GetMapping("/add")
    public  String addBookForm(Model model){
        model.addAttribute("book", new Book());
        return "book/add";
    }
    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") Book book){
        books.add(book);
        return "redirect:/books";
    }
    @GetMapping("/edit/{id}")
    public String editFormBook(@PathVariable("id") Long id, Model model){
        Optional<Book> editBook = books.stream().
                filter(val -> val.getId() == id).
                findFirst();
        if(editBook.isPresent()){
            model.addAttribute("book", editBook.get());
            return "book/edit";
        }else{
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editBook(@ModelAttribute("book") Book updatedBook){
        books.stream().filter(book -> book.getId()== updatedBook.getId())
                .findFirst()
                .ifPresent(book->books.set(books.indexOf(book), updatedBook));
        return "redirect:/books";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        books.removeIf(books -> books.getId().equals(id));
        return  "redirect:/books";
    }
}
