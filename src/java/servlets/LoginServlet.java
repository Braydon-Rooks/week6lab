/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import userService.User;
import userService.UserService;

/**
 *
 * @author 671978
 */
public class LoginServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String cookieName = "userCookie";
         HttpSession session = request.getSession();
        
        if(request.getParameter("action") != null)
        {
           
             String loggedOutUser = (String) session.getAttribute("loggedInUser");
             request.setAttribute("loggedOut",loggedOutUser + " has logged out");
            session.invalidate();
            
             for(Cookie cookie: cookies)
            {
                 if (cookieName.equals(cookie.getName()))
                    request.setAttribute("oldUser",cookie.getValue());
                 
            }
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            
        } 
        else if(session.getAttribute("loggedInUser")!=null)
        {
            response.sendRedirect("Home");
        }
        else if(cookies!= null)
        {
            for(Cookie cookie: cookies)
            {
                 if (cookieName.equals(cookie.getName()))
                    request.setAttribute("oldUser",cookie.getValue());
                 getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
       
        }
         else
        {
          getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserService userServ = new UserService();
        String user=request.getParameter("user");
        String pass = request.getParameter("password");
        String[] remember = request.getParameterValues("remember");
        
        Cookie cookie= new Cookie("userCookie",user);
        
        
        if(user==null||user.isEmpty()||pass==null||pass.isEmpty())
        {
            request.setAttribute("notFull", "Please Fill Both Fields");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        if(userServ.login(user,pass) != null)
        {
            User newUser = new User(user,null);
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser",newUser.getUserName());
            
            if(remember !=null)
            {
                
                cookie.setMaxAge(60*60*24);
                cookie.setPath("/");
                response.addCookie(cookie);
            
            }
            else
            {
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
           
            response.sendRedirect("Home");
            
        }
        else
        {
            request.setAttribute("incorrectLogin", "Incorrect Username or Password");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        
      
    }


}
