package view;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class LoginTest extends Mockito{
	Login loginContoller;

	@Before
	public void setUp() throws Exception {
		loginContoller = new Login();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void doPost() {
		HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        //request.getSession(false);
        when(request.getParameter("userName")).thenReturn("geetika");
        when(request.getParameter("userPassword")).thenReturn("geetika");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("RecruiterHome.jsp")).thenReturn(requestDispatcher);
        try {
        	//loginContoller.doPost(request, response);
			verify(requestDispatcher).forward(request,response);
			
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
        
        verify(request, atLeast(1)).getParameter("userName");
	}
	
	
	@Test
	public void testDoPostWrongUserName() {
		HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
        //request.getSession(false);
        when(request.getParameter("userName")).thenReturn("geetika");
        when(request.getParameter("userPassword")).thenReturn("geetika");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("Login.jsp")).thenReturn(requestDispatcher);
        try {
        	//loginContoller.doPost(request, response);
			verify(requestDispatcher).forward(request,response);
			
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
        
        verify(request, atLeast(1)).getParameter("userName");
	}

}