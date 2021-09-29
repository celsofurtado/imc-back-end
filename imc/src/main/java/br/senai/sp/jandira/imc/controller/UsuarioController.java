package br.senai.sp.jandira.imc.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.senai.sp.jandira.imc.model.Usuario;
import br.senai.sp.jandira.imc.repository.UsuarioRepository;

@RestController
@RequestMapping("/imc/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<Usuario> listarTodos() {
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarPeloId(@PathVariable Long id) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(id);

		return usuario.isEmpty() 
				? ResponseEntity.notFound().build() 
				: ResponseEntity.ok(usuario.get());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		
		// Obter a uri do novo recurso criado
		URI uri = ServletUriComponentsBuilder
			.fromCurrentRequestUri()
			.path("/{codigo}")
			.buildAndExpand(usuarioSalvo.getId())
			.toUri();
		
		System.out.println(uri.toString());
		//response.setHeader("Location", uri.toString());
		
		return ResponseEntity.created(uri).body(usuarioSalvo);
	}

}
