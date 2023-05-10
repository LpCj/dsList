package com.lcbrasil.dslist.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity // faz esse comando, chamado de annotation,  para que o objeto gerado possa ser gravado em um banco de dados
//esse annotation vai configurar a classe java abaixo para que ela seja equivalente a uam tabela do banco relacional

@Table(name="tb_belonging")   //esse annotation customiza o nome da tabela do banco
public class Belonging {

	@EmbeddedId // esse anotation fecha com o embeded da classe BelongingPK
	private BelongingPK id = new BelongingPK(); // instancia para nao deixar ele nulo
	
	private Integer position;
	
	public Belonging () {
		
	}

	//public Belonging(BelongingPK id, Integer position) {   ele estava assim mas (depois estrudar o porque) nao e bom ele receber o BelongingPK id
	public Belonging(Game game, GameList list, Integer position) {
		id.setGame(game);
		id.setList(list);
		// os dois acima serao consumidos no BelongingPK porque ele esta relacionado e ele contem , ele espera receber justamente game e list
		this.position = position;
	}

	public BelongingPK getId() {
		return id;
	}

	public void setId(BelongingPK id) {
		this.id = id;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Belonging other = (Belonging) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}// fimdo public class Belonging {
