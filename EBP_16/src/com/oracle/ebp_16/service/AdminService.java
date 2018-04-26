package com.oracle.ebp_16.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.oracle.ebp_16.dao.AdminMapper;
import com.oracle.ebp_16.domain.Admin;
import com.oracle.ebp_16.domain.User;
import com.oracle.ebp_16.exception.AdminException;

@Service
@Scope
@Resource
public class AdminService{

	 @Resource
	 private AdminMapper adminMapper;
	 
	 //��ȡ�����û�
	 public List<User> getAllUsers(){
		 return adminMapper.getAllUsers();
	 }
	 
	 //����ʱ���ѯ�û�
	 public List<User> getUserByTime(String begin,String end){
		 return adminMapper.getUserByTime(begin, end);
	 }
	 //���ݹؼ��ֻ�ȡ�û�
	 public List<User> getUserByKeys(User user){
		 return adminMapper.getUserByKeys(user);
	 }
	 
	 //����uid���user
	 public User getUserByUid(String uid){
		 System.out.println("����uid��"+uid+"��ѯuser");
		 return adminMapper.getUserByUid(uid);
	 }
	 
	 //�޸��û�״̬
	 public int changeUserStatus(String uid,String status){
		 System.out.println("This is adminService:  uid is"+uid+"   status is "+status);
		 return adminMapper.changeStatus(uid, status);
	 }
	 
	 //�����û�����ȡadminuser
	 public Admin getByName (String username) throws AdminException{
		 return adminMapper.selectByName(username);
	 }
}
