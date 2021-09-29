package br.senai.sp.jandira.imc.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.senai.sp.jandira.imc.model.Biometria;
import br.senai.sp.jandira.imc.model.Usuario;

public interface BiometriaRepository extends JpaRepository<Biometria, Long> {
	
	List<Biometria> findByUsuario(Usuario usuario);
	
	@Query("select b from Biometria b where b.usuario.id = ?1")
	List<Biometria> findLastPeso(Long id);

}
