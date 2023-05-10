// essa classe foi criada para ser a chave primaria, quetem que ser so um argumento
//quando tiver a intereção do belonging con pedidos e produto 
//póis pedido tem uma PK e produto tem outra PK, por isso tiveso que criar essa classe aqui 
//fazendo referencia desses dois PK mas gerando ao sistema um so PK

package com.lcbrasil.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable  // faz-se necasario paar explicar ao sistema que essa classe represneta 2 campos  na classe Belonging que a 
//partir dessa relação vai rrepsentar so um PK 
public class BelongingPK {
	
	@ManyToOne  //porque no UML essa classe se relaciona com muitas
	@JoinColumn(name= "game_id")
	private Game game;
	
	@ManyToOne
	@JoinColumn(name= "list_id")
	private GameList list;
	
	public BelongingPK () {
		
	}

	public BelongingPK(Game game, GameList list) {
		this.game = game;
		this.list = list;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameList getList() {
		return list;
	}

	public void setList(GameList list) {
		this.list = list;
	}

	@Override
	public int hashCode() {
		return Objects.hash(game, list);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(game, other.game) && Objects.equals(list, other.list);
	}
	
	
	
	

}// fimdo public class BelongingPK {
