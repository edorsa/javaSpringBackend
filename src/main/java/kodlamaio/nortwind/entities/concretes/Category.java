package kodlamaio.nortwind.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name="categories")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})//iç içe döngü olmasın diye
public class Category {
    @Id
    @Column(name="category_id")
    private int categoryId;
    @Column(name="category_name")
    private String categoryName;
    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
