package com.lcbrasil.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lcbrasil.dslist.dto.GameMinDTO;
import com.lcbrasil.dslist.entities.Game;
import com.lcbrasil.dslist.repositories.GameRepository;

@Component
public class GameService {
	
	@Autowired// injetar  a instancia. ele esta puxanodu um instancia do repository
	private GameRepository gameRepository;
	
	public List<GameMinDTO>  findAll(){
		// agora que chmei o repository eu vo fazr uma pesquisa no banco de dados
		var result = gameRepository.findAll();// o var é a mesma coisa que List<Games>
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO (x)).toList();
		return dto;
		
	}
	
	
}// fim do s GameService {
