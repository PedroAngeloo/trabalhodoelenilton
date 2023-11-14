package br.developer.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.developer.java.entity.Clientes;
import br.developer.java.repository.ClientesRepository;

@Controller // Indica que esta classe é um controlador do Spring MVC
@RequestMapping("/clientes") // Todas as rotas dentro deste controlador começarão com "/clientes"
public class ClientesController {

	@Autowired // Injeção de dependência - ClientesRepository será automaticamente instanciado
	private ClientesRepository repository;

	@GetMapping("/cadastrar") // Mapeia requisições GET para "/clientes/cadastrar"
	public String cadastrar(@ModelAttribute("cliente") Clientes cliente) {
		return "/clientes/cadastro"; // Retorna o nome do template Thymeleaf para página de cadastro
	}

	@GetMapping("/listar") // Mapeia requisições GET para "/clientes/listar"
	public String listar(ModelMap model) {
		model.addAttribute("clientes", repository.findAll()); // Adiciona uma lista de clientes ao modelo
		return "/clientes/listar"; // Retorna o nome do template Thymeleaf para a página de listagem de clientes
	}

	@PostMapping("/salvar") // Mapeia requisições POST para "/clientes/salvar"
	public String salvar(@ModelAttribute("cliente") Clientes cliente, RedirectAttributes attr) {
		repository.save(cliente); // Salva um novo cliente usando o repositório
		attr.addFlashAttribute("success", "Cliente adicionado com sucesso"); // Adiciona um atributo de flash para
																				// redirecionamento
		return "redirect:/clientes/cadastrar"; // Redireciona para a página de cadastro após salvar o cliente
	}

	@GetMapping("/clientes/editar/{id}") // Mapeia requisições GET para "/clientes/clientes/editar/{id}"
	public String showEditForm(@PathVariable Long id, Model model) {
		// Lógica para recuperar os dados do cliente por ID e passá-los para o modelo
		// ...
		return "edit-client"; // Retorna o nome do template Thymeleaf para a página de edição de clientes
	}

}
