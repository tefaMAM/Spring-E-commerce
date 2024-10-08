package Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Entitys.Product;
import Services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 1. CREATE: Add a new product (POST)
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        productService.createProduct(product.getName(), product.getPrice(), product.getColor());
        return ResponseEntity.ok("Product created successfully");
    }

    // 2. READ: Get all products (GET)
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProduct();
        return ResponseEntity.ok(products);
    }

    // 3. READ: Get a product by ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = productService.getProduct(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 4. UPDATE: Update an existing product by ID (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product product) {
         productService.update(id, product.getName(), product.getPrice(), product.getColor()); 
            return ResponseEntity.ok("Product updated successfully");
    }

    // 5. DELETE: Delete a product by ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
       productService.deleteProduct(id);
            return ResponseEntity.ok("Product deleted successfully");
        }
    
}
