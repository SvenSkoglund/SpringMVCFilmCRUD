package com.skilldistillery.film.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.DatabaseAccessorObject;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	DatabaseAccessorObject dao;

	@RequestMapping(path = "addFilm.do", method = RequestMethod.GET)
	public ModelAndView addFilm(String title, String description, int releaseYear, int languageId, int rentalDuration,
			double rentalRate, int length, double replacementCost, String rating) {
		Film film = new Film(title, description, releaseYear, languageId, rentalDuration, rentalRate, length,
				replacementCost, rating);
		ModelAndView mv = new ModelAndView();
		film = dao.addFilm(film);
		mv.setViewName("WEB-INF/views/result.jsp");
		mv.addObject("film", film);
		return mv;
	}

	@RequestMapping(path = "deleteFilm.do", method = RequestMethod.GET)
	public ModelAndView deleteFilm(int filmId) { 
		ModelAndView mv = new ModelAndView();
		Film film = dao.getFilmById(filmId);
		mv.setViewName("WEB-INF/views/deletedResult.jsp");
		mv.addObject("film", film);
		boolean ifDeleted = dao.deleteFilm(film);
		mv.addObject("ifDeleted", ifDeleted);
		return mv;
	} 

	@RequestMapping(path = "editFilm.do", method = RequestMethod.GET)
	public ModelAndView editFilm(String title, String description, int releaseYear, int languageId, int rentalDuration,
			double rentalRate, int length, double replacementCost, String rating) {
		Film film = new Film(title, description, releaseYear, languageId, rentalDuration, rentalRate, length,
				replacementCost, rating);
		ModelAndView mv = new ModelAndView();
		dao.editFilm(film);
		mv.setViewName("WEB-INF/views/result.jsp");
		mv.addObject("film", dao.getFilmById(film.getId()));
		return mv;
	}

	@RequestMapping(path = "filmById.do", method = RequestMethod.GET)
	public ModelAndView findFilmById(int filmID) {
		ModelAndView mv = new ModelAndView();
		Film film = dao.getFilmById(filmID);
		mv.setViewName("WEB-INF/views/result.jsp");
		mv.addObject("film", film);
		return mv;
	}

	@RequestMapping(path = "filmByKeyword.do", method = RequestMethod.GET)
	public ModelAndView findFilmByKeyword(@RequestParam("keyword") String keyword) {
		ModelAndView mv = new ModelAndView();
		List<Film> films = dao.getFilmByKeyword(keyword);

		mv.addObject("films", films);
		mv.setViewName("WEB-INF/views/resultKeyword.jsp");
		return mv;
	}

	public void setDao(DatabaseAccessorObject dao) {
		this.dao = dao;
	}

}
