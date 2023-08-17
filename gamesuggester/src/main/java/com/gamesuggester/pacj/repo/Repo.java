package com.gamesuggester.pacj.repo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gamesuggester.pacj.entity.Game;
import com.gamesuggester.pacj.serv.Serv;

@Repository
public interface Repo extends JpaRepository<Game, Integer> {

	

	
	
	//String tid="mult";
	@Query(value="select * from Game u where u.type =:type AND u.mothdlg =:mothdlg AND u.age =:age ;", nativeQuery=true)
	List<Game> getUserFullNameById(@Param("type") String type ,@Param("mothdlg") String mothdlg,@Param("age") String age);
	
	@Query(value="select * from Game u where u.id =:id ;", nativeQuery=true)
	List<Game> findrandom(@Param("id") int id);
}