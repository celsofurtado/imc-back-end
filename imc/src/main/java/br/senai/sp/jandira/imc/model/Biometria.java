package br.senai.sp.jandira.imc.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_biometria")
public class Biometria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double peso;
	
	@Column(name = "nivel_atividade")
	@Enumerated(EnumType.STRING)
	private NivelAtividade nivelAtividade = NivelAtividade.NENHUMA;
	
	@Column(name = "data_pesagem")
	private LocalDate dataPesagem = LocalDate.now();
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public NivelAtividade getNivelAtividade() {
		return nivelAtividade;
	}

	public void setNivelAtividade(NivelAtividade nivelAtividade) {
		this.nivelAtividade = nivelAtividade;
	}

	public LocalDate getDataPesagem() {
		return dataPesagem;
	}

	public void setDataPesagem(LocalDate dataPesagem) {
		this.dataPesagem = dataPesagem;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
