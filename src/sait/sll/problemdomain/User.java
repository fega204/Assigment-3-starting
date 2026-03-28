package sait.sll.problemdomain;
import java.io.Serializable;

//User class created by Ayden
public class User implements Serializable {
	
    private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String email;
	private transient String password;

	public User(int id, String name, String email, String password) {
		
        this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	
    }

	public int getId() {
		return this.id;
	}

   	public String getName() {
		return this.name;
	} 

	public String getEmail() {
		return this.email;
	}	
    
	public String getPassword() {
		return this.password;
	}

    public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isCorrectPassword(String password) {
		if (this.password == null) {
			return password == null;
		}

		return this.password.equals(password);
	}

	@Override
	public boolean equals(Object input) {
		if (this == input) {
			return true;
		}

		if (input == null || this.getClass() != input.getClass()) {
			return false;
		}

		User other = (User) input;

		if (this.id != other.id) {
			return false;
		}

		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}

		if (this.email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!this.email.equals(other.email)) {
			return false;
		}

		if (this.password == null) {
			return other.password == null;
		}

		return this.password.equals(other.password);
	}
}
