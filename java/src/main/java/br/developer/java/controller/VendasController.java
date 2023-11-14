package br.developer.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.developer.java.entity.Clientes;
import br.developer.java.entity.Produtos;
import br.developer.java.entity.Vendas;
import br.developer.java.repository.ClientesRepository;
import br.developer.java.repository.ProdutosRepository;
import br.developer.java.repository.VendasRepository;

@Controller // Indica que esta classe é um controlador do Spring MVC
@RequestMapping("/vendas") // Todas as rotas dentro deste controlador começarão com "/vendas"
public class VendasController {

	// Injeção de dependências dos repositórios
	@Autowired
	private ProdutosRepository produtos;

	@Autowired
	private VendasRepository repository;

	@Autowired
	private ClientesRepository clientes;

	@GetMapping("/cadastrar") // Mapeia requisições GET para "/vendas/cadastrar"
	public String cadastrar(@ModelAttribute("venda") Vendas venda) {
		return "vendas/cadastro"; // Retorna o nome do template Thymeleaf para a página de cadastro de vendas
	}

	@GetMapping("/listar") // Mapeia requisições GET para "/vendas/listar"
	public String mostrarListaVendas(ModelMap model) {
		model.addAttribute("vendas", repository.findAll()); // Adiciona uma lista de vendas ao modelo
		return "vendas/listar"; // Retorna o nome do template Thymeleaf para a página de listagem de vendas
	}

	@PostMapping("/salvar") // Mapeia requisições POST para "/vendas/salvar"
	public String salvar(@ModelAttribute("venda") Vendas venda, RedirectAttributes attr) {
		repository.save(venda); // Salva uma nova venda usando o repositório VendasRepository
		attr.addFlashAttribute("success", "Venda adicionada com sucesso"); // Adiciona um atributo de flash para
																			// redirecionamento
		return "redirect:cadastrar"; // Redireciona para a página de cadastro após salvar a venda
	}

	@ModelAttribute("clientes")
	public List<Clientes> getClientes() {
		return clientes.findAll(); // Obtém uma lista de todos os clientes e adiciona ao modelo
	}

	@ModelAttribute("produtos")
	public List<Produtos> getProdutos() {
		return produtos.findAll(); // Obtém uma lista de todos os produtos e adiciona ao modelo
	}
}
