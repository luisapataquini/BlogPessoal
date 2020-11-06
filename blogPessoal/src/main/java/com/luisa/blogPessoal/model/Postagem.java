package com.luisa.blogPessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity // identidade do JPA hibernate - para o banco de dados
@Table(name = "postagem") // nome da tabela
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // chave primária
	private long id;

	@NotNull
	@Size(min = 5, max = 100) // tamanho
	private String titulo;

	@NotNull
	@Size(min = 10, max = 500) // tamanho
	private String texto;

	@Temporal(TemporalType.TIMESTAMP) // indica para o JPA hibernate que estamos trabalhando com tempo
	private Date data = new java.sql.Date(System.currentTimeMillis());

	@ManyToOne // para cada postagem eu tenho um tema
	@JsonIgnoreProperties("postagem") // ignorar o atributo postagens na tabela tema
	private Tema tema;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

}
