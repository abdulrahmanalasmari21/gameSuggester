package com.gamesuggester.pacj.serv;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.gamesuggester.pacj.entity.Game;
import com.gamesuggester.pacj.entity.ImageUtil;
import com.gamesuggester.pacj.repo.Repo;

@Service
public class Serv  {
	@Autowired
	public Repo repo;
	
	
		
	
	public void Addnew( String name,String type , String mothdlg, String age,byte[] pic) {
		 //ImageUtil imageUtil =new ImageUtil();


		Game game=new Game();
		game.setName(name);
		game.setType(type);
		game.setMothdlg(mothdlg);
		game.setAge(age);
		game.setPic(pic);
		
		repo.save(game);
	}
	
	
}
