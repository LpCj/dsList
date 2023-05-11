package com.lcbrasil.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lcbrasil.dslist.entities.Game;
import com.lcbrasil.dslist.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long>{
	// o annotaiton abaixo é necessario para poder habilitar a consulta ao SQL
	@Query(nativeQuery = true, value = """  
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	// só que o resultado do query acima resulta em uma interface que no springtools é conhecido como projection 
	// e épor isso que fazemoso cara abaiuxo o "GameMinProjection"
	List<GameMinProjection> searchByList(Long listId);

}// fim do public interface GameRepository {
