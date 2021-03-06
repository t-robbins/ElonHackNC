package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import beans.User;
import database.Account;

/**
 * Servlet implementation class Controller 
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DataSource ds;
    private Map<String, String> actionMap = new HashMap<>();
    HttpSession session;
	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        // Build a Map of action parameters to pages

        actionMap.put("index", "/index.jsp");
        actionMap.put("login", "/login.jsp");
        actionMap.put("createaccount", "/createaccount.jsp");
        actionMap.put("userprofile", "/userprofile.jsp");
        actionMap.put("error", "/error.jsp");
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    @Override
    public void init(ServletConfig config) throws ServletException {


		try {
			InitialContext initContext = new InitialContext();

			Context env = (Context) initContext.lookup("java:comp/env/");

			ds = (DataSource) env.lookup("jdbc/elonhackdb");
	    	
		} catch (NamingException e) {
			e.printStackTrace();
			throw new ServletException();
		}
    	
    	
    	
    }

    private void doForward(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {
        // Get the action parameter
        String action = request.getParameter("action");

        // If the action parameter is null or the map doesn't contain
        // a page for this action, set the action to the home page
        if (action == null || !actionMap.containsKey(action))
            action = "error";

        // Forward to the requested page.
        request.getRequestDispatcher(actionMap.get(action)).forward(request,
            response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request,
     *      HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
                                                      IOException {
    	
    	String action = request.getParameter("action");    	
    	
    	if(action == null || !actionMap.containsKey(action)){
    		action = "error";
    	} else if(action.equals("userprofile")){
    		request.getRequestDispatcher("/userprofile.jsp").forward(request,
    	              response);
    	}
 
          // Forward to the requested page.
    	request.getRequestDispatcher(actionMap.get(action)).forward(request,
                response);
        
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request,
     *      HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                                                       throws ServletException,
                                                       IOException {
    	
    	
		String action = request.getParameter("action");

		Connection conn = null;

		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServletException();
		}

		if (action.equals("dologin")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			User user = new User(username, password);

			request.setAttribute("username", username);
			request.setAttribute("password", "");
			request.setAttribute("message", "");
			Account account = new Account(conn);

			try {
				if (account.login(username, password)) {
					
					session=request.getSession();
					
					user = account.getUser(username);
					session.setAttribute("user", user);
					
					request.getRequestDispatcher("/index.jsp").forward(
							request, response);
				} else {
					request.setAttribute("message",
							"email address or password not recognized");
					request.getRequestDispatcher("/login.jsp").forward(request,
							response);
				}
			} catch (SQLException e) {
				// Do something sensible here --> forward to error.jsp
				e.printStackTrace();
			}

		} else if (action.equals("createaccount")) {
		

			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String username = request.getParameter("username");
			String repeat = request.getParameter("repeat");

			request.setAttribute("email", email);

			if(!password.equals(repeat)){
				request.setAttribute("message", "Passwords do not match");
				request.getRequestDispatcher("/createaccount.jsp").forward(request,response);
			}
			else{
				User user = new User(username, email, password);
				Account account = new Account(conn);
				
				if(!user.validate()){
					//password or email have wrong format
					request.setAttribute("username", username);
					request.setAttribute("password", password);
					request.setAttribute("message", user.getMessage());
					request.getRequestDispatcher("/createaccount.jsp").forward(request,response);
				}
				else{
					try {
						if(account.emailExists(email)){
							//Account already exists with this email
							request.setAttribute("message", "An account with this email already exists");
							request.getRequestDispatcher("/createaccount.jsp").forward(request,response);
						}
						else if(account.usernameExists(username)){
							//Account already exists with this email
							request.setAttribute("message", "An account with this username already exists");
							request.getRequestDispatcher("/createaccount.jsp").forward(request,response);
						}
						else{
							account.create(username, email,password);
							request.getRequestDispatcher("/index.jsp").forward(request,response);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
<<<<<<< HEAD
		} else if(action.equals("userprofile")){
    		request.getRequestDispatcher("/userprofile.jsp").forward(request,
  	              response);
		} else {
			request.getRequestDispatcher("/error.jsp").forward(request,response);
=======
		}
		else {
			request.getRequestDispatcher(actionMap.get(action)).forward(request,
		            response);
>>>>>>> origin/master
		}

		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
