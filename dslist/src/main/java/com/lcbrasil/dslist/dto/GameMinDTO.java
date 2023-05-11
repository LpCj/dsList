package com.lcbrasil.dslist.dto;

import com.lcbrasil.dslist.entities.Game;
import com.lcbrasil.dslist.projections.GameMinProjection;

public class GameMinDTO {
	// nao precisa do column aqui pois o DTO nao fica mapeado como o banco de dado
	private Long id;
	private String title;
		// nao precisa do column aqui pois o DTO nao fica mapeado como o banco de dado 
	private Integer year;
	private String imgUrl;
	
	// nao precisa do column aqui pois o DTO nao fica mapeado como o banco de dado
	private String shortDescription;

	public GameMinDTO () {
		
	}

	//agora ele fara um GameMinDTO copiando os dados do classe entidade
	// e como faz? ao inves de ficar como esta abaixo
	/*public GameMinDTO(Long id, String title, Integer year, String imgUrl, String shortDescription) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.imgUrl = imgUrl;
		this.shortDescription = shortDescription;
	}*/
	
	//fica assim
	public GameMinDTO(GameMinProjection projection) {
		id = projection.getId();
		title = projection.getTitle();
		year = projection.getYear();
		imgUrl = projection.getImgUrl();
		shortDescription = projection.getShortDescription();// nao precisa dos thi. pois nao tem mais ambiugudade
	}

	public GameMinDTO(Game entity) {
		id = entity.getId();
		title = entity.getTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getShortDescription();// nao precisa dos thi. pois nao tem mais ambiugudade
	}
	
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}
	
	
	

}// fim do public class GameMinDTO {
