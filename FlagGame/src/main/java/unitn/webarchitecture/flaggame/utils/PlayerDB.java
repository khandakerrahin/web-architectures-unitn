package unitn.webarchitecture.flaggame.utils;

import java.io.Serializable;
import java.util.Map;

import unitn.webarchitecture.flaggame.resources.Player;

public class PlayerDB implements Serializable {

	private static final long serialVersionUID = 1L;
	public Map <String,Player> players;
	
	PlayerDB() {
	};

	PlayerDB(Map <String, Player> players) {
		this.players = players;
	}

    public void setPlayerDB(Map <String, Player> players) {
        this.players = players;
    }

	public Map <String, Player> getPlayerDB() {
		return players;
	}
	
	public boolean checkUser(String username) {
		return players.containsKey(username);
	}
	
	public Player getPlayerDetails(String username) {
		return players.get(username);
	}
}
