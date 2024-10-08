package Services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Entitys.Product;
import repoistres.ProductRepository;

@Service
@Transactional
public class ProductService {
private final ProductRepository ps;

public ProductService(ProductRepository ps) {
	super();
	this.ps = ps;
}

public void createProduct(String name,int price,String color) {
	this.ps.insertProduct(name, price, color);
}

public void deleteProduct(int id) {
	this.ps.deleteProduct(id);
}
public void update(int id, String name, int price, String color){
	this.ps.updateProduct(id, name, price, color);
}

public List<Product> getAllProduct()
{
	return this.ps.getAllProducts();
}
public Product getProduct(int id) {
	return this.ps.getProduct(id);
}
}
