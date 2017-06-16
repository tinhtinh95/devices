package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import entities.Account;
import library.LibStringMd5;

/**
 * Servlet implementation class LoginController
 */
//@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO acDAO=new AccountDAO();
		if(request.getParameter("submit")!=null){
			String username=request.getParameter("username");
			String password=LibStringMd5.LibMd5(request.getParameter("password"));
			Account AccountLogin=acDAO.checkLogin(username, password);
			HttpSession session=request.getSession();
			if(AccountLogin!=null){
				session.setAttribute("AccountLogin", AccountLogin);
				response.sendRedirect(request.getContextPath() + "/home");
				return;
			}else{
				response.sendRedirect(request.getContextPath() + "/login?msg=0");
				return;
			}
		}else{
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
