package br.developer.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.developer.java.repository.ClientesRepository;
import br.developer.java.repository.ProdutosRepository;
import br.developer.java.repository.VendasRepository;

@Controller // Indica que esta classe é um controlador do Spring MVC
@RequestMapping("/index") // Todas as rotas dentro deste controlador começarão com "/index"
public class IndexController {

	// Declaração dos repositórios
	VendasRepository repository;
	ClientesRepository clientes;
	ProdutosRepository produtos;

	@GetMapping("/") // Mapeia requisições GET para "/"
	public String index() {
		return "/index.html"; // Retorna o nome do template Thymeleaf para a página principal (index.html)
	}
}
