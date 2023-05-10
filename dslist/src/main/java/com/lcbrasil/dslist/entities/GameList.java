package com.lcbrasil.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity // faz esse comando, chamado de annotation,  para que o objeto gerado possa ser gravado em um banco de dados
//esse annotation vai configurar a classe java abaixo para que ela seja equivalente a uam tabela do banco relacional

@Table(name="tb_game_list")   //esse annotation customiza o nome da tabela do banco
public class GameList {
	
	@Id  // faz com que ele seja o primary key (PK)
	@GeneratedValue (strategy = GenerationType.IDENTITY)  // faz com que o porprio sistam gere os id em sequencia
	private Long id;
	private String name;
	
	public GameList() {
		
	}

	public GameList(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		GameList other = (GameList) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}// fim do public class GameList {
