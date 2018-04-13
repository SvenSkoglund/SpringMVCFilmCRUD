package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.DatabaseAccessorObject;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	DatabaseAccessorObject dao;
	

	@RequestMapping(path="addFilm.do", method=RequestMethod.GET)
	public ModelAndView addFilm(Film film) {
		ModelAndView mv = new ModelAndView();
		dao.addFilm(film);
		mv.setViewName("/result.jsp");
		mv.addObject("film", dao.getFilmById(film.getId()));
		return mv;
	}
	

	@RequestMapping(path="deleteFilm.do", method=RequestMethod.GET)
	public ModelAndView deleteFilm(Film film) {
		ModelAndView mv = new ModelAndView();
		dao.deleteFilm(film);
		mv.setViewName("/delete.jsp");
		mv.addObject("film", dao.getFilmById(film.getId()));
		return mv;
	}
	
	@RequestMapping(path="editFilm.do", method=RequestMethod.GET)
	public ModelAndView editFilm(Film film) {
		ModelAndView mv = new ModelAndView();
		dao.editFilm(film);
		mv.setViewName("/result.jsp");
		mv.addObject("film", dao.getFilmById(film.getId()));
		return mv;
	}
	
	public void setDao(DatabaseAccessorObject dao) {
		this.dao = dao;
	}

}
