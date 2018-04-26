package com.oracle.ebp_16.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.ebp_16.domain.Admin;

public class LoginFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//�ж��û��Ƿ��Ѿ���¼
		HttpServletRequest hRequest = (HttpServletRequest)request;
		HttpSession session = hRequest.getSession();
		Admin admin =(Admin)session.getAttribute("session_admin");
		String queryUrl=((HttpServletRequest) request).getServletPath();
		ServletContext appliaction = request.getServletContext();
		appliaction.setAttribute("url", queryUrl);

		if(admin==null){//session��û�иö���˵��û��¼
			//���û�����ȥ���ʵ�¼
			String loginUri = hRequest.getContextPath() + "/adminlogin.jsp";
			((HttpServletResponse) response).sendRedirect(loginUri);
		}else{
			chain.doFilter(hRequest,response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}
