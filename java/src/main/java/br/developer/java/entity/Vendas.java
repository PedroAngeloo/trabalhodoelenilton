package br.developer.java.entity;

import java.util.*;

import javax.persistence.*;

@Entity // Indica que a classe é uma entidade JPA
@Table(name = "vendas") // Especifica o nome da tabela no banco de dados
public class Vendas {
	@Id // Indica o campo que representa a chave primária da tabela
	@Column(name = "id") // Especifica o nome da coluna no banco de dados
	@GeneratedValue // Indica que o valor para esta coluna será gerado automaticamente
	public Long id; // Identificador único para cada venda
	@ManyToOne // Relacionamento muitos-para-um com a entidade Produtos
	private Produtos produtos; // Produto vendido

	private String nome_produto; // Nome do produto (derivado do relacionamento com Produtos)

	@ManyToOne // Relacionamento muitos-para-um com a entidade Clientes
	private Clientes cliente; // Cliente que fez a compra

	private String nome_cliente; // Nome do cliente (derivado do relacionamento com Clientes)

	@Column(name = "quantidade") // Define a coluna "quantidade" na tabela vendas
	private int quantidade; // Quantidade de produtos vendidos

	@Column(name = "total") // Define a coluna "total" na tabela vendas
	private double total; // Valor total da venda

	// Getters e Setters para cada atributo da classe Vendas

	public Produtos getProduto() {
		return produtos;
	}

	public void setProduto(Produtos produtos) {
		this.produtos = produtos;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getTotal() {
		return total = quantidade * produtos.getValor();
	}

	public String getNome_produto() {
		return nome_produto = produtos.getNome();
	}

	public String getNome_cliente() {
		return nome_cliente = cliente.getNome();
	}

}
