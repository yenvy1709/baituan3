package nguyencuutinh.lap2_3.Controller;
import nguyencuutinh.lap2_3.entity.Book;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import  org.springframework.web.bind.annotation.*;
import java.util.*;
@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private List<Book> books;
    @GetMapping
    public String listBooks(Model model){
        model.addAttribute("books",books);
        model.addAttribute("title","Book List");
        return  "book/list";
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
        Optional<Book> editBook = books.stream().filter(book -> book.getId() == id).findFirst();

        if(editBook.isPresent()){
            model.addAttribute("book", editBook.get());
            return "book/edit";
        }else{
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editBook(@ModelAttribute("book") Book updatedBook){
//        books.stream()
//                .filter(book ->book.getId()== updatedBook.getId())
//                .findFirst().ifPresent(book->book.set(books.indexOf(book),updatedBook));
        Optional<Book> editBook = books.stream()
                .filter(val -> val.getId() == updatedBook.getId()).findFirst();
        if(editBook.isPresent()){
            books.set(books.indexOf(editBook.get()), updatedBook);
        }else{
            return "not-found";
        }
        return "redirect:/books";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        books.removeIf(book -> book.getId() == id);
        return "redirect:/books";
    }
}
