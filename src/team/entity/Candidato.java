package team.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import team.persistence.VotoDao;
import team.persistence.VotoDaoImpl;

@Entity
public class Candidato implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private String sigla;
	private String descricao;
	@Column(columnDefinition="mediumblob")
	private byte[] foto;
	@Transient
	private long votos;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getsigla() {
		return sigla;
	}
	public void setsigla(String sigla) {
		this.sigla = sigla;
	}
	
	public String getdescricao() {
		return descricao;
	}
	public void setdescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public long getVotos() {
		VotoDao vdao = new VotoDaoImpl();
		votos = vdao.contaVotos(this);
		return votos;
	}
	
}
