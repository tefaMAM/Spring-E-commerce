package Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Entitys.Order;
import Services.OrderServices;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderServices orderService;

    public OrderController(OrderServices orderService) {
        this.orderService = orderService;
    }

    // 1. CREATE: Add a new order (POST)
    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        orderService.createOrder(order.getCustomer_name(), order.getDate());
        return ResponseEntity.ok("Order created successfully");
    }

    // 2. READ: Get all orders (GET)
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    // 3. READ: Get an order by ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        Order order = orderService.getOrderById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 4. UPDATE: Update an existing order by ID (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable int id, @RequestBody Order order) {
        orderService.updateOrder(id,order.getCustomer_name(), order.getDate());
        return ResponseEntity.ok("Order deleted successfully");

    }

    // 5. DELETE: Delete an order by ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable int id) {
         orderService.deleteOrder(id);
            return ResponseEntity.ok("Order deleted successfully");
        
    }
}
