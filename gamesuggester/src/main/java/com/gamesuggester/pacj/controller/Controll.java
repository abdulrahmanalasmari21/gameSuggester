package com.gamesuggester.pacj.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gamesuggester.pacj.entity.Game;
import com.gamesuggester.pacj.entity.ImageUtil;
import com.gamesuggester.pacj.repo.Repo;
import com.gamesuggester.pacj.serv.Serv;

@Controller
@RequestMapping(value="/")

public class Controll {
	
	@Autowired
	public Repo repo;
	@Autowired
	public Serv s;
	
	String answersOfQuestion[]=new String[3];
	
	@RequestMapping(value={"/","/mainpage"})
	public String welcomepage() {
		
		return "/mainpage";
	}
	
	@GetMapping(value="/search")
	public ModelAndView Search(Model model ) {
		ModelAndView mov=new ModelAndView("Search");
		//List<Game> Games=repo.findAll();
		
		//model.addAttribute("imgUtil", new ImageUtil());
		//mov.addObject("Games",Games);
		return mov;
	}
	
	@GetMapping(value="/search/mult")
	public ModelAndView  frzmult(Model model,@RequestParam String type,String mothdlg,String age) {
	ModelAndView mov=new ModelAndView("Mult");
	
	List<Game> listobj=repo.getUserFullNameById(type,mothdlg,age);
	model.addAttribute("imgUtil", new ImageUtil());
	mov.addObject("multlist", listobj);
	
	return mov;
	}
	
	@GetMapping(value="/random")
	public ModelAndView randompage(Model model) {
		int id=1 + (int)(Math.random() * ((4 - 1) + 1));
		ModelAndView mov=new ModelAndView("Random");
		List<Game> Games=repo.findrandom(id);
		
		model.addAttribute("imgUtil", new ImageUtil());
		mov.addObject("Randomlist",Games);
		return mov;
	}
	
	@GetMapping(value="/random/randomagin")
	public String randomagin() {
		return "redirect:/random";
		
	}
	
	@RequestMapping(value="/pageaddnew")
	public String pagenew() {
		
		
		return "/Addnewgame";
		
	}
	
	@GetMapping(value="/AddnewGame")
	public String addnew(@RequestParam("name") String name,@RequestParam("type") String type ,@RequestParam("mothdlg") String mothdlg,@RequestParam("age") String age,@PathParam("pic") byte[] pic) {
		
		s.Addnew(name, type, mothdlg, age,pic);
		return "redirect:/mainpage";
		
	}
	
	

}
