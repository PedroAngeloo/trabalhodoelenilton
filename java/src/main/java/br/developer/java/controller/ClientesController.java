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

@Controller
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	private ClientesRepository repository;

	@GetMapping("/cadastrar")
	public String cadastrar(@ModelAttribute("cliente") Clientes cliente) {
		return "/clientes/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("clientes", repository.findAll());
		return "/clientes/listar";
	}

	@PostMapping("/salvar")
	public String salvar(@ModelAttribute("cliente") Clientes cliente, RedirectAttributes attr) {
		repository.save(cliente);
		attr.addFlashAttribute("success", "Cliente adicionado com sucesso");
		return "redirect:/clientes/cadastrar";
	}

	@GetMapping("/clientes/editar/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
		// Logic to retrieve client data by ID and pass it to the model
		// ...
		return "edit-client"; // Assuming "edit-client" is the Thymeleaf template for editing clients
	}

}
