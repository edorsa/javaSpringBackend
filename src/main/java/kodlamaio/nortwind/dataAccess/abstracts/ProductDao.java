package kodlamaio.nortwind.dataAccess.abstracts;

import kodlamaio.nortwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.nortwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer>{

    Product getByProductName(String productName);

    Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);
    List<Product> getByProductNameOrCategory_CategoryId(String productName,int categoryId);
    List<Product> getByCategoryIn(List<Integer> categories);
    List<Product> getByProductNameContains(String productName);
    List<Product> getByProductNameStartingWith(String productName);

    //sorguları kendin mi yazmak istiyotrsun ozaman isimlendirme kuralına uymadan aşağıdaki gibi yap
    @Query("FROM Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName,int categoryId);
    //burada =: olan şey alttaki fonksiyon parametreleri
    //ayrıca burada Product dediğimiz bizim kendi sınıfmız burda veri tabanı isimlerini uunutup
    // kendi classlarınmızdaki isimlendirmeyi yapıyoruz. o gerisini hallediyor
    @Query("Select  new kodlamaio.nortwind.entities.dtos.ProductWithCategoryDto(p.id,p.productName,c.categoryName) From Category c Inner JOin c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();
    //select p.productId,p.productName, c.categoryName  from Category c inner join Product p
    //on c.categoryId = p.categoryId
}
