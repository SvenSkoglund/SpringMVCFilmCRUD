package com.skilldistillery.film.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.film.data.DatabaseAccessor;
import com.skilldistillery.film.data.DatabaseAccessorObject;
import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		// app.test();
		app.launch();
	}

	private void test() {
		Film film = db.getFilmById(1);
		System.out.println(film);
	}

	private void launch() {
		Scanner input = new Scanner(System.in);
		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		boolean displayMenu = true;
		while (displayMenu) {
			System.out.println("Enter 1 to look up an film by ID: ");
			System.out.println("Enter 2 to look up an film by keyword: ");
			System.out.println("Enter 3 to add a film: ");
			System.out.println("Press any other key to Quit:");
			int key = input.nextInt();
			switch (key) {
			case 1:
				System.out.println("Enter a film ID: ");
				int filmId = input.nextInt();
				Film film = db.getFilmById(filmId);
				if (film == null) {
					System.out.println("That ID is not found\n");
					break;
				}
				displayFilmInfo(film);
				System.out.println("");
				displaySubMenu(input, film);

				break;

			case 2:
				System.out.println("Enter a keyword: ");
				String keyword = input.next();
				List<Film> films = db.getFilmByKeyword(keyword);
				if (films.size() == 0) {
					System.out.println("Nothing matches the keyword entered \n");
					break;
				}
				for (Film film1 : films) {

					displayFilmInfo(film1);
					System.out.println("");
					if (displaySubMenu(input, film1)) {
						break;
					}

				}
				break;
			case 3:
				System.out.println("Enter film tile:");
				String title = input.next();
				System.out.println("Enter film description:");
				String description = input.next();
				System.out.println("Enter film release year:");
				int releaseYear = input.nextInt();
				System.out.println("Enter film rental duration:");
				int rentalDuration = input.nextInt();
				System.out.println("Enter film rental rate:");
				double rentalRate = input.nextDouble();
				System.out.println("Enter film length:");
				int length = input.nextInt();
				System.out.println("Enter film replacement cost:");
				double replacementCost = input.nextDouble();
				System.out.println("Enter film rating:");
				String rating = input.next();
				System.out.println("Enter film's special features:");
				String specialFeatures = input.next();
				Film filmToAdd = new Film(0, title, description, releaseYear, 1, rentalDuration, rentalRate, length, replacementCost, rating, specialFeatures);
				if(db.addFilm(filmToAdd) != null) {
					System.out.println("Film added successfully");
				}
				else {
					System.out.println("Not able to add film");
				}
				System.out.println("");
				break;
				
			default:
				System.out.println("Goodbye");
				displayMenu = false;
				break;
			}
		}
	}

	public void displayFilmInfo(Film film) {

		System.out.println("Film title: " + film.getTitle());
		System.out.println("Year film released: " + film.getReleaseYear());
		System.out.println("Film rating: " + film.getRating());
		System.out.println("Description: " + film.getDescription());
		System.out.println(db.getFilmsLanguage(film.getLanguageId()));
		List<Actor> cast = film.getCast();
		System.out.println("Cast:");
		for (Actor actor : cast) {
			System.out.println(actor.getFirstName() + " " + actor.getLastName());

		}
	}

	public boolean displaySubMenu(Scanner input, Film film) {
		System.out.println("Enter 1 to see more infortmation about this film:");
		System.out.println("Enter 2 to return to the main menu: ");
		System.out.println("Enter 3 to delete this film: ");
		int menu = input.nextInt();
		switch (menu) {
		case 1:
			System.out.println("Film title: " + film.getTitle());
			System.out.println("Year film released: " + film.getReleaseYear());
			System.out.println("Film rating: " + film.getRating());
			System.out.println("Description: " + film.getDescription());
			System.out.println(db.getFilmsLanguage(film.getLanguageId()));
			List<Actor> cast = film.getCast();
			System.out.println("Cast:");
			for (Actor actor : cast) {
				System.out.println(actor.getFirstName() + " " + actor.getLastName());
			}
			System.out.println("Rental duration: " + film.getRentalDuration());
			System.out.println("Rental rate: " + film.getRentalRate());
			System.out.println("Film length: " + film.getLength());
			System.out.println("Replacement cost: " + film.getReplacementCost());
			System.out.println("Special features: " + film.getSpecialFeatures());
			System.out.println("");
			return false;
		case 2:
			return true;
		case 3:
			db.deleteFilm(film);
			System.out.println("");
			return true;

		default:
			return false;

		}

	}

}
