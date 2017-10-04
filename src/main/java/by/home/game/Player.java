package by.home.game;

import java.util.ArrayList;

public class Player {

	private ArrayList<String> citiesList;

	public Player() {
		citiesList = new ArrayList<String>();
		citiesList.add("Minsk");
		citiesList.add("Kiev");
		citiesList.add("Vileyka");
		citiesList.add("Astana");
		citiesList.add("Sydney");
		citiesList.add("Toronto");
		citiesList.add("Brest");
		citiesList.add("Praga");
		citiesList.add("Oslo");
		citiesList.add("Afiny");
		citiesList.add("Vermont");
		citiesList.add("Melbourn");
		citiesList.add("Berlin");
		citiesList.add("Nesvizh");
		citiesList.add("Gudauri");
		citiesList.add("Cairo");
		citiesList.add("Istanbul");
		citiesList.add("Madrid");
		citiesList.add("Dubai");
		citiesList.add("Las_Vegas");
		citiesList.add("Ohio");
		
	}

	@Override
	public String toString() {
		return "Список городов: " + citiesList;
	}

	public ArrayList<String> getCitiesList() {
		return citiesList;
	}

	public void setCitiesList(ArrayList<String> citiesList) {
		this.citiesList = citiesList;
	}
}
