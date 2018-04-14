package com.skilldistillery.film.controllers;

import java.util.List;

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
	@RequestMapping(path="filmById.do", method=RequestMethod.GET)
	public ModelAndView findFilmById(int filmID) {
		ModelAndView mv = new ModelAndView();
		Film film = dao.getFilmById(filmID);
		mv.setViewName("WEB-INF/result.jsp");
		mv.addObject("film", film);
		return mv;
	}
	@RequestMapping(path="filmByKeyword.do", method=RequestMethod.GET)
	public ModelAndView findFilmByKeyword(String keyword) {
		ModelAndView mv = new ModelAndView();
		List<Film> films = dao.getFilmByKeyword(keyword);
		mv.setViewName("WEB-INF/result.jsp");
		for (Film film : films) {
			mv.addObject("film", dao.getFilmById(film.getId()));
		}
		return mv;
	}
	
	public void setDao(DatabaseAccessorObject dao) {
		this.dao = dao;
	}

}
