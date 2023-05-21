package Book.DoanThiYenVy.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Book> books;
}
