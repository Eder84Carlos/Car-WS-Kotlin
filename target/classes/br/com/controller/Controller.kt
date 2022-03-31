package br.com.controller;

import org.springframework.beans.factory.annotation.Autowired
import br.com.repository.Repository
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.http.ResponseEntity
import br.com.model.Factories
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.util.UriComponentsBuilder
import org.springframework.util.ObjectUtils
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.validation.BindingResult

@Controller
@RequestMapping("/factories/")
class Controller(private val repository: Repository) {


	@GetMapping("/list")
	fun listar(model: Model): String? {
		val listarTodos: List<Factories> = repository.findAll()
		model.addAttribute("todosFactories", listarTodos)
		return "list"
	}

	@PostMapping("/create")
	fun salvar(factories: Factories, model: Model, binding: BindingResult): String {
		model.addAttribute(factories.name)
		model.addAttribute(factories.docName)
		model.addAttribute(factories.country_code)

		println(model.addAttribute(factories.name))
		println(model.addAttribute(factories.docName))

		println(model.addAttribute(factories.country_code))
		
		
		
		this.repository.save(factories)
		return "redirect:list";
	}

	@GetMapping(path = ["add"])
	fun addFactorieById(): String? {
		return "add-factories"
	}

	@GetMapping(path = ["edit/{id}"])
	fun editFactorieById(model: Model, @PathVariable("id") id: Long): String? {
		model.addAttribute("factories", repository.findById(id))
		return "edit-Factory";
	}

	@PostMapping(path = ["editFactorie"])
	fun editFactorie(@ModelAttribute factories: Factories): String? {
		repository.save(factories)
		return "redirect:/"
	}

	@GetMapping(path = ["delete/{id}"])
	fun deleteFactorie(@PathVariable("id") id: Long): String? {
		repository.deleteById(id)
		return "redirect:/";
	}
}