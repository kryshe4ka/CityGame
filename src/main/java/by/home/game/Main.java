package by.home.game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Инициализируем начальные парметры и игру
		Scanner in = new Scanner(System.in);
		String city = "";
		Game game = newGame();
		// Выводим список доступных городов. Дополнить можно в классе Player
		System.out.println(game.getPlayer());
		String lastCharStr = ""; // Игру начинает юзер с любой буквы
		while (game.isStatus()) {
			System.out.println("Введите город (pass - если не знаешь, exit - для выхода):");
			city = in.next(); //вводим город с клавиатуры
			if (city.equalsIgnoreCase("exit")) {
				System.out.println("Вы завершили игру!");
				game.setStatus(false);
			} else if (city.equalsIgnoreCase("pass")) {
				System.out.println("Ну ты тупица! Игра закончена.");
				game.setStatus(false);
			} else {
				int index; //инициализируем индекс, равный позиции города в списке, -1 при отсутствии в списке
				if (lastCharStr == "") {
					index = game.isCityExist(city); //при старте игры проверяем, есть ли город в списке и возвращаем позицию
				} else {
					index = game.isCityExist(city, lastCharStr); //проверяем наличие города в списке и равенство первой буквы необходимой
				}
				if (index == -1) {
					System.out.println("Чувак, ты ввел неверный город, введи другой или проваливай! (pass/exit)"); //если город не найден или неверная первая буква
				} else {
					Character lastChar = getLastChar(city); //сохраняем последнюю букву введенного города
					game.getPlayer().getCitiesList().remove(index); //удаляем город из списка, чтобы исключить повторения
					int indexFindCity = game.findCity(lastChar); //ищем город на заданную букву
					if (indexFindCity == -1) {
						System.out.println("Молодец, ты победил!"); //если не находим, то завершаем игру
						game.setStatus(false);
					} else {
						lastCharStr = "" + getLastChar(game.getPlayer().getCitiesList().get(indexFindCity));
						System.out.println("Я нашел город " + game.getPlayer().getCitiesList().get(indexFindCity)
								+ ", тебе на " + lastCharStr);
						game.getPlayer().getCitiesList().remove(indexFindCity);
					}
				}
			}
		}
	}

	public static Game newGame() {
		return new Game();
	}

	/**
	 * Получение первой буквы для сравнения
	 * 
	 * @param city
	 *            - город для выбора первой буквы
	 * @return первая буква
	 */
	public static Character getFirstChar(String city) {
		return city.charAt(0);
	}

	/**
	 * Получение последней буквы для сравнения
	 * 
	 * @param city
	 *            - город для выбора последней буквы
	 * @return последняя буква
	 */
	public static Character getLastChar(String city) {
		int pos = city.length() - 1;
		char lastChar = city.toUpperCase().charAt(pos);
		if (city.toUpperCase().charAt(pos) == 'Й') {
			return 'И';
		} else if (lastChar == 'Ь' || lastChar == 'Ы' || lastChar == 'Ъ') {
			pos--;
		}
		return city.toUpperCase().charAt(pos);
	}

}
