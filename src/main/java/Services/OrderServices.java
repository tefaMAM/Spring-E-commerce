package Services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Entitys.Order;
import repoistres.OrderRepository;
@Service
@Transactional
public class OrderServices {
	private final OrderRepository orderrepoistry;
	public OrderServices(OrderRepository orderrepoistry) {
		super();
		this.orderrepoistry = orderrepoistry;
	}
	  public void createOrder(String name, Date date){
		  this.orderrepoistry.createOrder(name, date);
		  
	  }
	   public void deleteOrder(int id) {
		   this.orderrepoistry.deleteOrder(id);
	   }
	   public void updateOrder(int id, String name, Date date) {
		   updateOrder(id, name, date);
	   }
	   public List<Order> getAllOrders(){
		   return this.orderrepoistry.getAllOrders();
	    }
	   public Order getOrderById(int id) {
	    	return this.orderrepoistry.getOrderById(id);
	    }
		
}
