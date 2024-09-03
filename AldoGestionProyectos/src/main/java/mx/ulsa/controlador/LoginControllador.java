package mx.ulsa.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class LoginControllador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LoginControllador() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	private void procesar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			String action = request.getPathInfo();
			System.out.println("action" + action);
			switch(action)
			{
			case "/ingresar" -> ingresar(request,response);
			case "/login" -> login(request,response);
			case "/logout" ->logout(request,response);
			default -> response.sendRedirect(request.getContextPath() + "/index.jsp");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("cerrar sesion");
		response.sendRedirect(request.getContextPath() + "/vista/login.jsp");

	}
	
	
	private void ingresar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(email + "  " +password);
		
		Usuario usuario = new Usuario(email,password);
		if(usuario.isValido() || usuario.isValidoEmail())
		{
			Cookie cookie = new Cookie("Correo",email);
			cookie.setMaxAge(120);//tiempo de vida de la cookie en el navegador
			response.addCookie(cookie);
			response.sendRedirect(request.getContextPath()+"/vista/privado/dashboard.jsp?email=" + email + "&opcionPanel=panel");
		} else
		{
			request.setAttribute("errorMessage", "Usuario o contraseña incorrecto");
			request.getRequestDispatcher("vista/login.jsp").forward(request, response);
		}
	}
	
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String email = "";
		Cookie[] cookies = request.getCookies();
		if(cookies!=null)
		{
			for(int i=0;i<cookies.length;i++)
			{
				Cookie cookie = cookies[i];
				if(cookie.getName().equals("correo"))
				{
					System.out.print("Correo cookie" + cookie.getValue());
					email = cookie.getValue();
				}
			}
		}
		response.sendRedirect(request.getContextPath() + "/vista/login.jsp?email="+email);
	}

}
