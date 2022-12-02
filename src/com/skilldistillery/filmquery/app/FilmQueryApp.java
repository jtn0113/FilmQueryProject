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
    app.test();
//    app.launch();
  }

  private void test() {
    Film film = db.findFilmById(17);
    Actor actor = db.findActorById(6);
    List<Actor> actors = db.findActorsByFilmId(3);
//    System.out.println(film);
    System.out.println(actor);

  }

  private void launch() {
    Scanner input = new Scanner(System.in);
    
    startUserInterface(input);
    
    input.close();
  }

  private void startUserInterface(Scanner input) {
    System.out.println("1.) Look up film by its ID");
    System.out.println("2.) Look up a film by a search keyword");
    System.out.println("3.) Exit");
    
    int selection = input.nextInt();
    
    
  }

  // some method would have code like :
  // if (! findfilmsbyactorid(someactoris).isempty {...} else sout no films for that unemployed actor
}
