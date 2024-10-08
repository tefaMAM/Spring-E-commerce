package com.mostafa.ecommerce.ecommerce_app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Entitys.Product;
import Services.OrderServices;
import Services.ProductService;
import configs.DB_Config;
import repoistres.OrderRepository;

@SpringBootApplication(scanBasePackages = {"Controller", "Services","repoistres"})
public class EcommerceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceAppApplication.class, args);
//		try(var context=new AnnotationConfigApplicationContext()){
//			context.scan("configs");
//			context.refresh();
//			ProductService bean = context.getBean(ProductService.class);
//			OrderServices bean2 = context.getBean(OrderServices.class);
//////			bean.createProduct( "shambo",120 , "red");
////		    System.out.println(bean.getAllProduct());
////		    bean.update(1, null, 40, null);
////		    System.out.println(bean.getAllProduct());
////		    bean.deleteProduct(1);
//
//			
//		}
	}

}
