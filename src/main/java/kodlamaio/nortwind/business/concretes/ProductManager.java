package kodlamaio.nortwind.business.concretes;


import java.util.List;

import com.sun.net.httpserver.Authenticator;
import kodlamaio.nortwind.core.utilities.results.DataResult;
import kodlamaio.nortwind.core.utilities.results.Result;
import kodlamaio.nortwind.core.utilities.results.SuccesResult;
import kodlamaio.nortwind.core.utilities.results.SuccessDataResult;
import kodlamaio.nortwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.nortwind.business.abstracts.ProductService;
import kodlamaio.nortwind.dataAccess.abstracts.ProductDao;
import kodlamaio.nortwind.entities.concretes.Product;

@Service
public class ProductManager implements ProductService{

	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>>getAll() {
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"data Listelendi");

	}

	@Override
	public DataResult<List<Product>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"productName");
		return new SuccessDataResult<List<Product>>
				(this.productDao.findAll(sort),"Başarılı");
	}

	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		Pageable pageable= PageRequest.of(pageNo-1,pageSize);
		return  new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
		//pageableın dönüş tipi dataresult olmadığı için get content kullandık.
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccesResult("ürün eklendi");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>(this.productDao.getByProductName(productName),"data Listelendi");

	}

	@Override
	public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
		return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"data Listelendi");

	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"data Listelendi");

	}

	@Override
	public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByCategoryIn(categories),"data Listelendi");

	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName),"data Listelendi");

	}

	@Override
	public DataResult<List<Product>> getByProductNameStartingWith(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartingWith(productName),"data Listelendi");

	}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName,categoryId),"data Listelendi");

	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {

		return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(),"data listelendi");
	}

}
