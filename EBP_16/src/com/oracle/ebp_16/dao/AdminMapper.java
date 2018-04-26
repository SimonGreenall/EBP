package com.oracle.ebp_16.dao;

import java.util.List;

import com.oracle.ebp_16.domain.Admin;
import com.oracle.ebp_16.domain.User;

public interface AdminMapper {
	//�����û�����ȡadminuser  
	//���ڹ���Ա��¼
	public Admin selectByName(String username);
	//����uid�õ��û�
	public User getUserByUid(String uid);
	//�ı��û�״̬
	public int changeStatus(String uid,String status);
	//���ݹؼ��ֶβ�ѯ�û�
	public List<User> getUserByTime(String begin,String end);
	public List<User> getUserByKeys(User user);
	//��ѯ�����û�
	public List<User> getAllUsers();
}
