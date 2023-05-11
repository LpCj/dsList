package com.lcbrasil.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lcbrasil.dslist.dto.GameListDTO;
import com.lcbrasil.dslist.entities.GameList;
import com.lcbrasil.dslist.repositories.GameListRepository;


@Component
public class GameListService {
	
	@Autowired// injetar  a instancia. ele esta puxanodu um instancia do repository
	private GameListRepository gameListRepository;
	
	// como boa pratica reomenda-se colcoar em todo service, que é o @TRansactional
	
		
	@Transactional (readOnly = true)  // cuidado que o import dela nao é do jakarta como foi todos até aqui
	public List<GameListDTO>  findAll(){
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x-> new GameListDTO(x)).toList();
		
	}
	
	
}// fim do s GameService {
