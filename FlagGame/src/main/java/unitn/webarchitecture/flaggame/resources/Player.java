package unitn.webarchitecture.flaggame.resources;

import java.io.Serializable;

public class Player implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	private int score = 0;
	private boolean isAdmin = false;

	public Player(String name, String password, int score, boolean isAdmin) {
		this.name = name;
		this.score = score;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    
    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setScore(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
