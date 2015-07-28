/**
 * 
 */
package com.lmiky.simplelogin.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 说明
 * @author lmiky
 * @date 2015年7月28日 上午10:57:36
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = -7840534075732907267L;
	public static final String ENCODING = "UTF-8";

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			setEncoding(request, response);
			String loginName = request.getParameter("loginName");
			String password = request.getParameter("password");
			if(!"admin".equals(loginName)) {
				handlerError(request, response, "用户名错误!");
			} else if(!"admin".equals(password)) {
				handlerError(request, response, "密码错误!");
			} else {
				handlerSuccess(request, response, loginName);
			}
		} catch(Exception e) {
			handlerException(request, response, e);
		}
	}

	/**
	 * 设置编码
	 * @author lmiky
	 * @date 2015年7月28日 下午12:24:14
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException
	 */
	protected void setEncoding(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding(ENCODING);
		request.setCharacterEncoding(ENCODING);
	}
	
	/**
	 * 检查输入格式
	 * @author lmiky
	 * @date 2015年7月28日 下午12:15:21
	 * @param request
	 * @param response
	 * @param value
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	protected boolean checkValue(HttpServletRequest request, HttpServletResponse response, String value) throws ServletException, IOException {
		String regex = "[A-Za-z0-9]*";
		return value.matches(regex);
	}
	
	/**
	 * 处理异常
	 * @author lmiky
	 * @date 2015年7月28日 上午11:01:40
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void handlerException(HttpServletRequest request, HttpServletResponse response, Exception e) throws ServletException, IOException {
		e.printStackTrace();	//Logger 记录日志
		putErrorInfo(request, response, "系统错误!");
		RequestDispatcher dispatcher = request.getRequestDispatcher("./login.jsp");
		dispatcher .forward(request, response);
	}
	
	/**
	 * 处理错误
	 * @author lmiky
	 * @date 2015年7月28日 上午11:01:40
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void handlerError(HttpServletRequest request, HttpServletResponse response, String errorInfo) throws ServletException, IOException {
		putErrorInfo(request, response, errorInfo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("./login.jsp");
		dispatcher .forward(request, response);
	}
	
	/**
	 * 处理成功
	 * @author lmiky
	 * @date 2015年7月28日 上午11:46:54
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void handlerSuccess(HttpServletRequest request, HttpServletResponse response, String loginName) throws ServletException, IOException {
		request.getSession().setAttribute("loginName", loginName);
		response.sendRedirect("./index.jsp");
	}
	
	/**
	 * 设置错误信息
	 * @author lmiky
	 * @date 2015年7月28日 上午11:57:39
	 * @param request
	 * @param response
	 * @param erorInfo
	 * @throws ServletException
	 * @throws IOException
	 */
	private void putErrorInfo(HttpServletRequest request, HttpServletResponse response, String errorInfo) throws ServletException, IOException {
		request.setAttribute("errorInfo", errorInfo);
	}
	
}
