package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
		app.launch();
	}

	private void test() {
		Film film = db.findFilmById(17);
		Actor actor = db.findActorById(6);
		System.out.println(film);
		System.out.println(actor);
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {

		boolean keepGoing = true;

		while (keepGoing) {
			switch (showMenu(input)) {
			case 1:
				byIdSelection(input);
				break;
			case 2:
				byKeywordSelection(input);
				break;
			case 3:
				System.out.println("Ciao!");
				keepGoing = false;
				break;
			default:
				System.out.println("Invalid Selection");
				break;
			}
		}
	}

	private int showMenu(Scanner input) {
		System.out.println("1.) Look up film by its ID");
		System.out.println("2.) Look up a film by a search keyword");
		System.out.println("3.) Exit");
		int selection = input.nextInt();
		return selection;
	}

	private void byIdSelection(Scanner input) {
		System.out.println("Enter ID of Film: ");
		Film film = db.findFilmById(input.nextInt());

		if (film == null) {
			System.out.println("No film found");
		} else {
			displayFilm(film);
		}
	}

	private void byKeywordSelection(Scanner input) {
		System.out.println("Enter Keyword to Search: ");
		List<Film> films = db.findFilmByKeyword(input.next());

		if (films.isEmpty()) {
			System.out.println("No films found");
		} else {
			for (Film film : films) {
				displayFilm(film);
			}
		}
	}

	private void displayFilm(Film film) {
		List<Actor> actors = film.getActors();
		System.out.println("TITLE: " + film.getTitle());
		System.out.println("YEAR: " + film.getReleaseYear());
		System.out.println("RATING: " + film.getRating());
		System.out.println("DESCRIPTION: " + film.getDescription());
		System.out.println("LANGUAGE: " + film.getLanguage());
		System.out.print("ACTORS: ");
		if (actors.isEmpty()) {
			System.out.print("No actors found");
		} else {
			for (Actor actor : actors) {
				System.out.print(actor.getFirstName() + " " + actor.getLastName());
				if (actors.indexOf(actor) == actors.size() - 1) {
					System.out.print(".\n");
				} else {
					System.out.print(", ");
				}
			}
		}
		System.out.println();
	}
}
