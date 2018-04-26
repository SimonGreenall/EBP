package com.oracle.ebp_16.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class RegisterBean {
	//@NotBlank(message="�������û���")
	@Length(min=6,max=20,message="ӦΪ6-20λ")
	private String username;
	//@NotBlank(message="����������")
	@Length(min=6,max=20,message="ӦΪ6-20λ")
	private String password;
	@NotBlank(message="��ȷ������")
	private String conpassword;
	@NotBlank(message="����������")
	private String name;
	@NotEmpty(message="��ѡ���Ա�")
	private String gender;//0-Ů��1-��
	//@NotEmpty(message="����������")
//	@Range(min=18,max=200,message="��������ȷ�����䷶Χ")
	private int age;
	//@NotBlank(message="���������֤")
	@Length(min=18,max=18,message="IDΪ18λ")
	private String idCard;
	@NotBlank(message="������סַ")
	private String address;
	@Length(min=11,max=11,message="����Ϊ11λ")
	//@NotBlank(message="���������")
	private String telno;

	//@NotEmpty(message="������״̬")
	//private String status;//0-user,1-admin
	public RegisterBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConpassword() {
		return conpassword;
	}


	public void setConpassword(String conpassword) {
		this.conpassword = conpassword;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getIdCard() {
		return idCard;
	}


	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getTelno() {
		return telno;
	}


	public void setTelno(String telno) {
		this.telno = telno;
	}


	public RegisterBean(String username, String password, String conpassword, String name, String gender, int age,
			String idCard, String address, String telno) {
		super();
		this.username = username;
		this.password = password;
		this.conpassword = conpassword;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.idCard = idCard;
		this.address = address;
		this.telno = telno;
	}
}
