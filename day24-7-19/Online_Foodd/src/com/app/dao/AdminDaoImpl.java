package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



import com.app.pojos.Customer;

import com.app.pojos.Order1;
import com.app.pojos.OrderDetails;
import com.app.pojos.Product;

import com.app.pojos.Restaurant;

@Repository
@Transactional
public class AdminDaoImpl implements IAdminDao {
	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Customer> listCustomer() {
    String jpql="select c from Customer c ";
		
	return sf.getCurrentSession().createQuery(jpql, Customer.class).getResultList();
	}

	

	/*@Override
	public String registerEmployee(Employee e) {
		sf.getCurrentSession().persist(e);
		return "Employee registration successful with ID" + e.getId();
	}
*/
	

	

	/*@Override
	public String registerCustomer(Customer c) {
		sf.getCurrentSession().persist(c);
		return "Customer registration successful with ID" + c.getId();
	}
*/
	/*@Override
	public String addCustomer(Customer c) {
		sf.getCurrentSession().save(c);
		return "Customer added with ID "+c.getId();
	}*/

	@Override
	public String deleteCustomer(int id) {
		String jpql ="select c from Customer c where c.id=:id";
		Session hs=sf.getCurrentSession();
		Customer e=sf.getCurrentSession().createQuery(jpql, Customer.class).setParameter("id", id).getSingleResult();
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
	public String addRestaurant(Restaurant r) {
		sf.getCurrentSession().save(r);
		return "Restaurant added with ID "+r.getRestaurantId();
	}

	@Override
	public String deleteRestaurant(int id) {
		String jpql ="select r from Restaurant where r.restaurantId=:id";
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
	public List<Product> listProduct() {
		   String jpql="select p from Product p";
			
			return sf.getCurrentSession().createQuery(jpql, Product.class).getResultList();
	}



	@Override
	public Product getProductDetails(int id) {
		return sf.getCurrentSession().get(Product.class, id);
	}



	@Override
	public List<Restaurant> listRestaurant() {
		 String jpql="select r from Restaurant r";
			
			return sf.getCurrentSession().createQuery(jpql,Restaurant.class).getResultList();
	}



	@Override
	public Restaurant getRestaurantDetails(int id) {
		return sf.getCurrentSession().get(Restaurant.class, id);
	}



	@Override
	public Order1 CustomerEntryFromOrders(Customer c) {
		System.out.println("inside Customer Entry from Oreder1 in dao");
		System.out.println("getting customer entry from database");
		String jpql="select order from  Order1 order where customerId=:cusId";
		return(sf.getCurrentSession().createQuery(jpql,Order1.class).setParameter("cusId",c).getSingleResult()); 
	}



	@Override
	public List<OrderDetails> getCart(Order1 orderInTable) {
		System.out.println("inside get cart method of login dao and order in table = "+orderInTable.getId());
		System.out.println("getting all cart objects of particular user :"+orderInTable.getId());
		String jpql="select o from OrderDetails o where o.oid.id=:ordtl";
		List<OrderDetails> dispOD=sf.getCurrentSession().createQuery(jpql,OrderDetails.class).setParameter("ordtl", orderInTable.getId()).getResultList();
		return dispOD;
	}

	

	@Override
	public Order1 checkCusExisting(Customer c) {
		System.out.println("inside check Cus existing method of dao");
		String jpql="select o from Order1 o where customerId=:cusId";
		Order1 o;
		try{
			o=sf.getCurrentSession().createQuery(jpql,Order1.class).setParameter("cusId", c).getSingleResult();
		}
		catch(Exception e)
		{
			return null;
		}
		return o;
	}



	@Override
	public Product getSelectedProduct(int cartProductId) {
		System.out.println("inside get selected product of service");
		System.out.println("getting product object");
		String jpql ="select p from Product p where p.id=:prodId";
		return (sf.getCurrentSession().createQuery(jpql,Product.class).setParameter("prodId", cartProductId).getSingleResult());
	}



	@Override
	public void addOrder(Order1 o) {
		System.out.println("inside add order1 method of login dao");
		// return(sf.getCurrentSession().persist(o))s;
		 sf.getCurrentSession().save(o);
		
	}



	@Override
	public void addOrderDetails(OrderDetails od) {
		System.out.println("adding order1 details entry in database");
		sf.getCurrentSession().save(od);
	}



	@Override
	public Product getSingleProduct(int pid) {
		return sf.getCurrentSession().get(Product.class, pid);
	}


	}

	

	
	/*@Override
	public Customer getCustomerDetails(int id) {
		return sf.getCurrentSession().get(Customer.class, id);
	}*/

/*
	@Override
	public Customer updateCustomerDetails(Customer c) {
		sf.getCurrentSession().update(c);
		return c;
	}*/


