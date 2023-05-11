 package com.lcbrasil.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcbrasil.dslist.dto.GameListDTO;
import com.lcbrasil.dslist.dto.GameMinDTO;
import com.lcbrasil.dslist.services.GameListService;
import com.lcbrasil.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")  // mapear os recursosm que nesse caso sao so games. o "/games" é a configuração onde sera respondido
public class GameListController {

	@Autowired   // injetou um service nbo controller
	private GameListService gameListService;  
	
	@Autowired   // injetou um service nbo controller
	private GameService gameService;  
	
	
	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAll();
		return result;
	
	}
	
	@GetMapping (value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId){
		List<GameMinDTO> result = gameService.findByList(listId);
		return result;
	}
	
}
