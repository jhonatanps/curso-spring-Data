package br.com.spring.data.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UsuarioSpringData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String login;
	
	private String senha;
	
	private String nome;
	
	private String email;
	
	private int idade;
	
	/* mapeamento do obj, onde um usuario a varios numero, orphanRemoval server para deletar pai e filho, fetch server para
	 * assim que alguma consulta for invocada ela caregara o telefone junto.
	 * */
	@OneToMany(mappedBy = "usuarioSpringData", orphanRemoval = true, fetch = FetchType.EAGER )
	private List<TelefoneSpringData> telefone;
	

	public List<TelefoneSpringData> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<TelefoneSpringData> telefone) {
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
}
