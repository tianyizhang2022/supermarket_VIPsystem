package maketsimulation;

import java.io.Serializable;

public class member implements Serializable{
	/*
	 * ���� ���� ���� ���� ����
	 */
	private String name;
	private int IDcard=0;
	private String password;
	private int score;
	private String rigistDate;
	private boolean Present;
	public member(){}
	
	
	public member(int iDcard, String password) {
		super();
		this.IDcard = iDcard;
		this.password = password;
	}


	public member(String name, int iDcard, String password, int score, String rigistDate) {
		super();
		this.name = name;
		
		this.IDcard = iDcard;
		this.password = password;
		this.score = score;
		this.rigistDate = rigistDate;
		this.Present = false;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIDcard() {
		return IDcard;
	}
	public void setIDcard(int iDcard) {
		this.IDcard = iDcard;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getRigistDate() {
		return rigistDate;
	}
	public void setRigistDate(String rigistDate) {
		this.rigistDate = rigistDate;
	}
	public boolean getPresent() {
		return Present;
	}
	public void setPresent() {
		this.Present = true;
	}

}
