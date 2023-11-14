package br.developer.java.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;
import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;

@Entity // Indica que a classe é uma entidade JPA
@Table(name = "clientes") // Especifica o nome da tabela no banco de dados
public class Clientes {

	@Id // Indica o campo que representa a chave primária da tabela
	@Column(name = "id") // Especifica o nome da coluna no banco de dados
	@GeneratedValue // Indica que o valor para esta coluna será gerado automaticamente
	private Long id; // Identificador único para cada cliente

	@Column(name = "nome", nullable = false) // Define o campo "nome" na tabela de clientes, não permitindo valores
												// nulos
	private String nome; // Nome do cliente

	@Column(name = "cpf", nullable = false) // Define o campo "cpf" na tabela de clientes, não permitindo valores nulos
	private String cpf; // Número de CPF do cliente

	@Column(name = "sexo", nullable = false) // Define o campo "sexo" na tabela de clientes, não permitindo valores
												// nulos
	private String sexo; // Sexo do cliente

	@Column(name = "data_de_nascimento") // Mapeia o campo "dataDeNascimento" na tabela de clientes
	private String dataDeNascimento; // Data de nascimento do cliente

	// Getters e Setters para cada atributo da classe Clientes

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSexo() {
		return sexo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
