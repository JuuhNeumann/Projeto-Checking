package model.entities;

import java.util.Objects;

public class Passageiro {

	private int id;
	private String cpf;
	private String nome;
	private String email;
	private String telefone;
	
	
	public Passageiro() {
	}
	
	public Passageiro(String nome) {
		this.nome = nome;
	}
	
	public Passageiro(int id, String nome, String cpf, String telefone, String email) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int i) {
		this.id = i;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public String toString() {
		return "Passageiro [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", telefone="
				+ telefone + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passageiro other = (Passageiro) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}
	
}
