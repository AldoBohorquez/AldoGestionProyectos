package mx.ulsa.controlador;

public class Usuario {
	private String useername;
	private String password;
	private String email;
	
	public Usuario()
	{
		
	}
	
	public Usuario(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getUseername() {
		return useername;
	}
	public void setUseername(String useername) {
		this.useername = useername;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isValido()
	{
		return "admin".equals(useername) && "1234".equals(password);
	}
	
	public boolean isValidoEmail()
	{
		return "dominio@gmail.com".equals(email) && "1234".equals(password);
	}
}
