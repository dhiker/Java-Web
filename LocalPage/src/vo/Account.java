package vo;

public class Account {
	private String id="", pw="";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "Account_id=" + id + ", pw=" + pw;
	}
	
}
