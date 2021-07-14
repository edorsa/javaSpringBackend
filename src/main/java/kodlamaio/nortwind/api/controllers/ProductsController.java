package kodlamaio.nortwind.api.controllers;

import java.util.List;

import kodlamaio.nortwind.core.utilities.results.DataResult;
import kodlamaio.nortwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import kodlamaio.nortwind.core.utilities.results.Result;
import kodlamaio.nortwind.business.abstracts.ProductService;
import kodlamaio.nortwind.entities.concretes.Product;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController {
	
	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		
		return this.productService.getAll();
	}
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){

		return this.productService.getProductWithCategoryDetails();
	}
	@PostMapping("/add")
	public Result add(@RequestBody  Product product){

		return this.productService.add(product);
	}

	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		//buradaki requestparam git yapılan isteğin parametrelerine bak. içinde product name diye bir şey olcak onu oku
		//atamasını ona göre yap
		return this.productService.getByProductName(productName);
	}
	@GetMapping("/getByProductNameAndCategory_CategoryId")
	public DataResult <Product> getByProductNameAndCategory_CategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){

		return  this.productService.getByProductNameAndCategory_CategoryId(productName,categoryId);
	}
	@GetMapping("/getByProductNameOrCategory_CategoryId")
	public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId")int categoryId){

		return this.productService.getByProductNameOrCategory_CategoryId(productName,categoryId);
	}
	@GetMapping("/getByProductNameContains")
	public DataResult <List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
	}
	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getAll(int pageNo,int pageSize){

		return this.productService.getAll(pageNo,pageSize);
	}
	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllSorted() {
		return this.productService.getAllSorted();
	}
	
}
