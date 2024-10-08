package Entitys;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Order {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String customer_name;
private Date date;
public Order(int id, String customer_name, Date date) {
	super();
	this.id=id;
	this.customer_name = customer_name;
	this.date = date;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCustomer_name() {
	return customer_name;
}
public void setCustomer_name(String customer_name) {
	this.customer_name = customer_name;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
@Override
public String toString() {
	return "Order [id=" + id + ", customer_name=" + customer_name + ", date=" + date + "]";
}

}
