package repoistres;

import java.util.List;
import java.sql.Date; // Or java.time.LocalDate depending on your schema
import java.time.LocalDate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import Entitys.Order;

@Repository
public class OrderRepository {
    
    private final JdbcTemplate jdbcTemplate;

    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Create order
    public void createOrder(String name, Date date) {
        String sql = "INSERT INTO orders (customer_name, order_date) VALUES (?, ?)";
        jdbcTemplate.update(sql, name, date);
    }

    // Delete order by ID
    public void deleteOrder(int id) {
        String sql = "DELETE FROM orders WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // Update order
    public void updateOrder(int id, String name, LocalDate date) {
        String sql = "UPDATE orders SET customer_name = ?, order_date = ? WHERE id = ?";
        jdbcTemplate.update(sql, name, date, id);
    }

    // Get all orders
    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, (rs, rowNum) -> 
            new Order(rs.getInt("id"),rs.getString("customer_name"), rs.getDate("order_date"))
        );
    }

    // Get order by ID
    public Order getOrderById(int id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> 
            new Order( rs.getInt("id"),rs.getString("customer_name"), rs.getDate("order_date"))
        );
    }
}
