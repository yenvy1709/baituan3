package Book.DoanThiYenVy.repository;
import Book.DoanThiYenVy.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface IBookRepository extends JpaRepository<Book, Long>{

}
