package by.home.game;

public class Game {

	private Player player;
	private boolean status;

	public Game() {
		setPlayer(new Player());
		setStatus(true);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int isCityExist(String city) {
		int index = -1;
		for (int i = 0; i < player.getCitiesList().size(); i++) {
			if (city.equalsIgnoreCase(player.getCitiesList().get(i))) {
				index = i;
				System.out.println("Окей, я знаю такой город " + city);
			}
		}
		return index;
	}

	public int findCity(Character lastChar) {
		int index = -1;
		String lastCharStr = "" + lastChar;
		String firstCharStr;
		for (int i = 0; i < player.getCitiesList().size(); i++) {
			firstCharStr = "" + player.getCitiesList().get(i).charAt(0);
			if (firstCharStr.equalsIgnoreCase(lastCharStr)) {
				index = i;
			}
		}
		return index;
	}

	public int isCityExist(String city, String lastChar) {
		int index = -1;
		String firstCharStr;
		for (int i = 0; i < player.getCitiesList().size(); i++) {
			firstCharStr = "" + player.getCitiesList().get(i).charAt(0);
			if ((city.equalsIgnoreCase(player.getCitiesList().get(i))) && (firstCharStr.equalsIgnoreCase(lastChar))) {
				index = i;
				System.out.println("Окей, я знаю такой город " + city);
			}
		}
		return index;
	}
}
