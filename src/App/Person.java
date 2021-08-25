package App;

public abstract class Person {

	private String F_name;
	private String L_name;
	private String Email_address;
	private int age;
	private String password;
	private String gender;
	private long id=0;
	
	public String getF_name() {
		return F_name;
	}

	public void setF_name(String f_name) {
		F_name = f_name;
	}

	public String getL_name() {
		return L_name;
	}

	public void setL_name(String l_name) {
		L_name = l_name;
	}

	public String getEmail_address() {
		return Email_address;
	}

	public void setEmail_address(String email_address) {
		Email_address = email_address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	private String profilePicture;
	
//	@Override
//	public String toString() {
//		return  F_name + " " + L_name ;
//	}
	
}
