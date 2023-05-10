 package com.lcbrasil.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcbrasil.dslist.dto.GameDTO;
import com.lcbrasil.dslist.dto.GameMinDTO;
import com.lcbrasil.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")  // mapear os recursosm que nesse caso sao so games. o "/games" é a configuração onde sera respondido
public class GameController {

	@Autowired   // injetou um service nbo controller
	private GameService gameService;  
	
	@GetMapping(value = "/{id}")  // porque se vc ver no Postman temos a busca por http://localhost:8080/games/1
	public GameDTO findById(@PathVariable Long id){
		GameDTO result = gameService.findById(id);
		return result;	
	}
	
	@GetMapping
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.findAll();
		return result;
		
	}
	
}
