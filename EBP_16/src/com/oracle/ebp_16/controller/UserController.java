package com.oracle.ebp_16.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.ebp_16.dao.UserMapper;
import com.oracle.ebp_16.domain.LoginBean;
import com.oracle.ebp_16.domain.RegisterBean;
import com.oracle.ebp_16.domain.User;
import com.oracle.ebp_16.service.UserService;
import com.oracle.ebp_16.util.Md5;

@Controller
public class UserController {
	@Resource
	private UserService userSvc;
	@Resource
	private UserMapper UserMapper;

	@RequestMapping(value = "/vpiregister.action", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute("registerBean") RegisterBean rb, Errors errors) {
		if (errors.hasFieldErrors())
			//return "user/register";
			return "vpiregister";
		if (!rb.getPassword().equals(rb.getConpassword())) {
			errors.rejectValue("conPassword", "empty.registerBean.conPassword", "���������������һ��");
			return "vpiregister";
		}
		try {
			if (userSvc.login(rb.getUsername())!=null) {
				errors.rejectValue("username", "empty.registerBean.username", "�������û���");
				//return "user/register";
				return "vpiregister";
			}
		} catch (Exception e1) {
			errors.reject("", "ע���쳣");
			//return "user/register";
			return "vpiregister";
		}
		try {
			System.out.println("ִ��ע��-----");
			userSvc.register(rb);
		} catch (Exception e) {
			errors.reject("", "ע���쳣");
			//return "user/register";
			return "vpiregister";
		}
		return "redirect:/vpilogin.jsp";
	}

	@RequestMapping(value = "/vpilogin.action", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("loginBean") LoginBean lb, Errors errors, HttpSession session) {
		if(errors.hasFieldErrors())return "vpilogin";
		User user=null;
		try {
			user=userSvc.login(lb.getUsername());
			System.out.println();
			if(user==null || !user.getPassword().equals(lb.getPassword())){
				System.out.println("user"+user+","+(user.getPassword().equals(Md5.GetMD5Code(lb.getPassword()))));
				System.out.println();
				errors.reject("","�û������������");
				return "vpilogin";
			}
			session.setAttribute("user", user);
			System.out.println("��¼�ɹ�=====");
			return "redirect:/index.jsp";
		} catch (Exception e) {
			System.out.println("�û������������");
			errors.reject("", "srroy,��¼�쳣");
			return "vpilogin";
		}
	}

	//�û���ֵ
	@RequestMapping(value="my/topUpAccount")
	@ResponseBody
	public String topUpAcount(HttpSession session,
			@RequestParam("topAccount") String topAcount) throws UnsupportedEncodingException{
		User user = (User)session.getAttribute("user");
		int result = 0;
		result = userSvc.topUpAcount(user.getUsername(), Double.parseDouble(topAcount));
		System.out.println();
		if (result == 1) {
			user.setBalance(user.getBalance()+Double.parseDouble(topAcount));
			session.setAttribute("user", user);
			//mav.setViewName("user/TopUpSucc");
			System.out.println("UserController:topUpAcount:true");
			return user.getBalance()+"";
		}else {
			//mav.setViewName("user/TopUpAccount");
			System.out.println("UserController:topUpAcount:false");
			return result+"";
		}
	}

	//�û��ǳ�
	@RequestMapping(value="/my/logout.action")
	public String logout(HttpSession session){
		try {
			User user = (User) session.getAttribute("user");
			if(user == null){
				System.out.println("�û�δ��¼   �����˳���¼");
				return "redirect:/index.jsp";
			}
			System.out.println(user);
			session.setAttribute("user",null);
			session.setAttribute("orders", null);
			User user2 = (User) session.getAttribute("user");
			System.out.println(user2);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�û��ǳ�ʧ��");
		}
		return "redirect:/index.jsp";
	}

	//�޸��û���Ϣ
	@RequestMapping(value="/my/updateUser.action")
	public String updateUser(HttpSession session,User user){
		System.out.println("����ĸ�������Ϊ"+user);
		try {
			int rowAffact = userSvc.updateUser(user);
			System.out.println();
			System.out.println("��ʱ������"+user.getPassword());
			User user2 = UserMapper.getUserById(user.getUid()+"");
			System.out.println();
			System.out.println("һ��"+rowAffact +"����Ӱ��");
			session.setAttribute("user", user2);
			System.out.println("���ظ��º�����ݣ�  "+user2);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�޸��û���Ϣ����");
		}
		System.out.println();
		return "redirect:/my/myinfo.jsp";
	}
}

