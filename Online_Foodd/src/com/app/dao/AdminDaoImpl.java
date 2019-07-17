package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Customer;
import com.app.pojos.Employee;
import com.app.pojos.Order1;
import com.app.pojos.Product;
import com.app.pojos.Restaurant;

@Repository
@Transactional
public class AdminDaoImpl implements IAdminDao {
	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Customer> listCustomer() {
    String jpql="select c from Customer c where role=:";
		
	return sf.getCurrentSession().createQuery(jpql, Customer.class).getResultList();
	}

	@Override
	public List<Employee> listEmployee() {
		 String jpql="select e from Employee e";
			
			return sf.getCurrentSession().createQuery(jpql, Employee.class).getResultList();
	}

	@Override
	public List<Order1> listOrder() {
		String jpql="select o from Order1 o";
		
		return sf.getCurrentSession().createQuery(jpql, Order1.class).getResultList();
	}

	@Override
	public List<Product> listProduct() {
       String jpql="select p from Product p";
		
		return sf.getCurrentSession().createQuery(jpql, Product.class).getResultList();
	}

	@Override
	public List<Restaurant> listRestaurant() {
		 String jpql="select r from Restaurant r";
			
			return sf.getCurrentSession().createQuery(jpql,Restaurant.class).getResultList();
	}

	@Override
	public String registerEmployee(Employee e) {
		sf.getCurrentSession().persist(e);
		return "Employee registration successful with ID" + e.getId();
	}

	@Override
	public String addEmployee(Employee e) {
		sf.getCurrentSession().save(e);
		return "Employee added with ID "+e.getId();
	}

	@Override
	public String deleteEmployee(int id) {
		String jpql ="select e from Employee e where e.id=:id";
		Session hs=sf.getCurrentSession();
		Employee e=sf.getCurrentSession().createQuery(jpql, Employee.class).setParameter("id", id).getSingleResult();
		hs.delete(e);
		return "movie deleted with ID="+e.getId();
	}

	@Override
	public String registerCustomer(Customer c) {
		sf.getCurrentSession().persist(c);
		return "Customer registration successful with ID" + c.getId();
	}

	@Override
	public String addCustomer(Customer c) {
		sf.getCurrentSession().save(c);
		return "Customer added with ID "+c.getId();
	}

	@Override
	public String deleteCustomer(int id) {
		String jpql ="select e from Employee e where e.id=:id";
		Session hs=sf.getCurrentSession();
		Employee e=sf.getCurrentSession().createQuery(jpql, Employee.class).setParameter("id", id).getSingleResult();
		hs.delete(e);
		return "Customer deleted with ID="+e.getId();
	}

	@Override
	public String addProduct(Product p) {
		sf.getCurrentSession().save(p);
		return "Employee added with ID "+p.getId();
	}

	@Override
	public String deleteProduct(int id) {
		String jpql ="select p from Product p where p.id=:id";
		Session hs=sf.getCurrentSession();
		Product p=sf.getCurrentSession().createQuery(jpql, Product.class).setParameter("id", id).getSingleResult();
		hs.delete(p);
		return "Product deleted with ID="+p.getId();
	}

	@Override
	public Product updateProduct(Product p) {
		sf.getCurrentSession().update(p);
		return p;
	}

	@Override
	public Product getProductDetails(int id) {
		return sf.getCurrentSession().get(Product.class, id);
	}

	@Override
	public String addRestaurant(Restaurant r) {
		sf.getCurrentSession().save(r);
		return "Restaurant added with ID "+r.getRestaurantId();
	}

	@Override
	public String deleteRestaurant(int id) {
		String jpql ="select r from Restaurantr where r.id=:id";
		Session hs=sf.getCurrentSession();
		Restaurant r=sf.getCurrentSession().createQuery(jpql, Restaurant.class).setParameter("id", id).getSingleResult();
		hs.delete(r);
		return "Restaurant deleted with ID="+r.getRestaurantId();
	}

	@Override
	public Restaurant updateRestaurant(Restaurant r) {
		sf.getCurrentSession().update(r);
		return r;
	}

	@Override
	public Restaurant getRestaurantDetails(int id) {
		return sf.getCurrentSession().get(Restaurant.class, id);
	}

	@Override
	public Order1 getOrderDetails(int id) {
		return sf.getCurrentSession().get(Order1.class, id);
		
	}

	@Override
	public Employee getEmployeeDetails(int id) {
		return sf.getCurrentSession().get(Employee.class, id);
	}

	@Override
	public Customer getCustomerDetails(int id) {
		return sf.getCurrentSession().get(Customer.class, id);
	}

	@Override
	public Employee updateEmployeeDetails(Employee e) {
		sf.getCurrentSession().update(e);
		return e;
	}

	@Override
	public Customer updateCustomerDetails(Customer c) {
		sf.getCurrentSession().update(c);
		return c;
	}

}
