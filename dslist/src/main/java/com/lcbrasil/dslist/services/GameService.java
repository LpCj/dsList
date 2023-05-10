package com.lcbrasil.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lcbrasil.dslist.dto.GameDTO;
import com.lcbrasil.dslist.dto.GameMinDTO;
import com.lcbrasil.dslist.entities.Game;
import com.lcbrasil.dslist.repositories.GameRepository;


@Component
public class GameService {
	
	@Autowired// injetar  a instancia. ele esta puxanodu um instancia do repository
	private GameRepository gameRepository;
	
	// como boa pratica reomenda-se colcoar em todo service, que é o @TRansactional
	
	@Transactional (readOnly = true)  // cuidado que o import dela nao é do jakarta como foi todos até aqui
	public GameDTO findById (Long GameId) {
		Game result = gameRepository.findById(GameId).get();
		//no coando acima da para fazer um tratamento de exceção pois oi gameId pode ser invalido
		GameDTO dto = new GameDTO (result);
		return dto;
	}
	
	@Transactional (readOnly = true)  // cuidado que o import dela nao é do jakarta como foi todos até aqui
	public List<GameMinDTO>  findAll(){
		// agora que chmei o repository eu vo fazr uma pesquisa no banco de dados
		var result = gameRepository.findAll();// o var é a mesma coisa que List<Games>
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO (x)).toList();
		return dto;
		
	}
	
	
}// fim do s GameService {
