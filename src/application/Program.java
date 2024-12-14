package application;

import java.time.LocalDateTime;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Department department = new Department(1, "Books");
		Seller seller = new Seller(1, "Roger", "roger@gmail.com", LocalDateTime.now(), 3500.00, department);
		

	}

}
