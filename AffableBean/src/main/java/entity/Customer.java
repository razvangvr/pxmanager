package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String address;

	@Column(name="cc_number")
	private String ccNumber;

	@Column(name="city_region")
	private String cityRegion;

	private String email;

	private String name;

	private String phone;

	//bi-directional many-to-one association to CustomerOrder
	@OneToMany(mappedBy="customer")
	private List<CustomerOrder> customerOrders;

	public Customer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCcNumber() {
		return this.ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getCityRegion() {
		return this.cityRegion;
	}

	public void setCityRegion(String cityRegion) {
		this.cityRegion = cityRegion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<CustomerOrder> getCustomerOrders() {
		return this.customerOrders;
	}

	public void setCustomerOrders(List<CustomerOrder> customerOrders) {
		this.customerOrders = customerOrders;
	}

	public CustomerOrder addCustomerOrder(CustomerOrder customerOrder) {
		getCustomerOrders().add(customerOrder);
		customerOrder.setCustomer(this);

		return customerOrder;
	}

	public CustomerOrder removeCustomerOrder(CustomerOrder customerOrder) {
		getCustomerOrders().remove(customerOrder);
		customerOrder.setCustomer(null);

		return customerOrder;
	}

}