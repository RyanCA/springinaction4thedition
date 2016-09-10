package pland.com.springaction4thedition.data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Email;

public class Spitter {

	
	
	/**
	 * {firstName.size} and other more in curly braces refer to messages in ValidationMessages.properties
     * Actually Spitter.java and ValidationMessages.properties are mutual referred
	 */
	
	private Long id;
	
	@NotNull
	@Size(min=4, max=30, message="{firstName.size}")
	private String firstName;
	
	@NotNull
	@Size(min=5, max=30, message="{lastName.size}")
	private String lastName;
	
	@NotNull
	@Size(min=5, max=12, message="{username.size}")
	private String username;
	
	@NotNull
	@Size(min=5, max=25, message="{password.size}")
	private String password;
	
	//@NotNull
	@Email(message="{email.valid}")
	private String email;
	
	public Spitter(){
		super();
	}
	
	public Spitter( String username, String password, String firstName, 
			String lastName){
		this(0l, username, password, firstName, lastName);

	}
	
	public Spitter(Long id,  String username, String password, String firstName, 
			String lastName){
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	
	  @Override
	  public boolean equals(Object that) {
	    return EqualsBuilder.reflectionEquals(this, that, "id", "time");
	  }

	  @Override
	  public int hashCode() {
	    return HashCodeBuilder.reflectionHashCode(this, "id", "time");
	  }

}
