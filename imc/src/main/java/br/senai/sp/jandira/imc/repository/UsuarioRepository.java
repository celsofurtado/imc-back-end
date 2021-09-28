package br.senai.sp.jandira.imc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senai.sp.jandira.imc.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
