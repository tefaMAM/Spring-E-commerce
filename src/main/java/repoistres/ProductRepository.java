package repoistres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Entitys.Product;

import java.util.List;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Create
    public void insertProduct(String name, int price, String color) {
        String sql = "INSERT INTO product VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, name, price, color);
    }

    // Delete Product
    public void deleteProduct(int id) {
        String sql = "DELETE FROM product WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // Update Product
    public void updateProduct(int id, String name, int price, String color) {
        String sql = "UPDATE product SET name = ?, price = ?, color = ? WHERE id = ?";
        jdbcTemplate.update(sql, name, price, color, id);
    }

    // Get All Products
    public List<Product> getAllProducts() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
            new Product(rs.getInt("id"),rs.getString("name"), rs.getInt("price"), rs.getString("color")));
    }

    public Product getProduct(int id) {
        String sql = "SELECT * FROM product WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
            new Product(
                rs.getInt("id"),         // Mapping 'id' column
                rs.getString("name"),     // Mapping 'name' column
                rs.getInt("price"),       // Mapping 'price' column
                rs.getString("color")    // Mapping 'colour' column
            )
        );
    }
    }

