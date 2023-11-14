package br.developer.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.developer.java.entity.Produtos;
import br.developer.java.repository.ProdutosRepository;

@Controller // Indica que esta classe é um controlador do Spring MVC
@RequestMapping("/produtos") // Todas as rotas dentro deste controlador começarão com "/produtos"
public class ProdutosController {

	@Autowired // Injeção de dependência - ProdutosRepository será automaticamente instanciado
	private ProdutosRepository repository;

	@GetMapping("/cadastrar") // Mapeia requisições GET para "/produtos/cadastrar"
	public String cadastrar(@ModelAttribute("produto") Produtos produto) {
		return "/produtos/cadastro"; // Retorna o nome do template Thymeleaf para a página de cadastro de produtos
	}

	@GetMapping("/listar") // Mapeia requisições GET para "/produtos/listar"
	public String listar(ModelMap model) {
		model.addAttribute("produtos", repository.findAll()); // Adiciona uma lista de produtos ao modelo
		return "/produtos/listar"; // Retorna o nome do template Thymeleaf para a página de listagem de produtos
	}

	@PostMapping("/salvar") // Mapeia requisições POST para "/produtos/salvar"
	public String salvar(@ModelAttribute("produto") Produtos produto, RedirectAttributes attr) {
		repository.save(produto); // Salva um novo produto usando o repositório
		attr.addFlashAttribute("success", "Produto adicionado com sucesso"); // Adiciona um atributo de flash para
																				// redirecionamento
		return "redirect:/produtos/cadastrar"; // Redireciona para a página de cadastro após salvar o produto
	}
}
