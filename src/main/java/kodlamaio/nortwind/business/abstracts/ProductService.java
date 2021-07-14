package kodlamaio.nortwind.business.abstracts;

import java.util.List;

import kodlamaio.nortwind.core.utilities.results.DataResult;
import kodlamaio.nortwind.core.utilities.results.Result;
import kodlamaio.nortwind.entities.concretes.Product;
import kodlamaio.nortwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.Query;

public interface ProductService {

	DataResult<List<Product>> getAll();
	DataResult<List<Product>> getAllSorted();
	DataResult<List<Product>> getAll(int pageNo,int pageSize);
	Result add(Product product);

	DataResult <Product> getByProductName(String productName);

	DataResult <Product> getByProductNameAndCategory_CategoryId(String productName,int categoryId);
	DataResult <List<Product>> getByProductNameOrCategory_CategoryId(String productName,int categoryId);
	DataResult <List<Product>> getByCategoryIn(List<Integer> categories);
	DataResult <List<Product>> getByProductNameContains(String productName);
	DataResult <List<Product>> getByProductNameStartingWith(String productName);
	DataResult <List<Product>> getByNameAndCategory(String productName,int categoryId);
	DataResult <List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}
