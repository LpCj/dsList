 package com.lcbrasil.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcbrasil.dslist.dto.GameListDTO;
import com.lcbrasil.dslist.services.GameListService;

@RestController
@RequestMapping(value = "/lists")  // mapear os recursosm que nesse caso sao so games. o "/games" é a configuração onde sera respondido
public class GameListController {

	@Autowired   // injetou um service nbo controller
	private GameListService gameListService;  
	

	
	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAll();
		return result;
		
	}
	
}
