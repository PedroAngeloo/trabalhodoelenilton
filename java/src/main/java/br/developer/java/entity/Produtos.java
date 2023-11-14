package br.developer.java.entity;

import javax.persistence.*;

@Entity // Indica que a classe é uma entidade JPA
@Table(name = "produtos") // Especifica o nome da tabela no banco de dados
public class Produtos {

	@Id // Indica o campo que representa a chave primária da tabela
	@Column(name = "id") // Especifica o nome da coluna no banco de dados
	@GeneratedValue // Indica que o valor para esta coluna será gerado automaticamente
	public Long id; // Identificador único para cada produto

	@Column(name = "nome", nullable = false) // Define o campo "nome" na tabela de produtos, não permitindo valores
												// nulos
	private String nome; // Nome do produto

	@Column(name = "valor", nullable = false) // Define o campo "valor" na tabela de produtos, não permitindo valores
												// nulos
	private double valor; // Valor do produto

	// Getters e Setters para cada atributo da classe Produtos

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
