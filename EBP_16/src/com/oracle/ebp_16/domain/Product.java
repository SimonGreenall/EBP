package com.oracle.ebp_16.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
@Component
public class Product {

	private Integer pid;
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@NotBlank(message="��������Ϊ��")
	@NotNull(message="��������Ϊ��")
	private String descs;
	@NotBlank(message="��Ʒ��������Ϊ��")
	@NotNull(message="��������Ϊ��")
	private String amount;
	@NotBlank(message="��������Ϊ��")
	@NotNull(message="��������Ϊ��")
	private String balance;
	@NotBlank(message="�۸���Ϊ��")
	@NotNull(message="�۸���Ϊ��")
	private String price;
	@NotBlank(message="״̬����Ϊ��")
	@NotNull(message="״̬����Ϊ��")
	private String status;
	private String src;
	
	public Product(Integer pid, String descs, String amount, String balance, String price, String status, String src) {
		super();
		this.pid = pid;
		this.descs = descs;
		this.amount = amount;
		this.balance = balance;
		this.price = price;
		this.status = status;
		this.src = src;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getDescs() {
		return descs;
	}
	public void setDescs(String descs) {
		this.descs = descs;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Product(String descs, String amount, String balance, String price,
			String status) {
		super();
		this.descs = descs;
		this.amount = amount;
		this.balance = balance;
		this.price = price;
		this.status = status;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product [descs=" + descs + ", amount=" + amount + ", balance="
				+ balance + ", price=" + price + ", status=" + status + "]";
	}
	
	
}

