package model.entities;

import java.util.Objects;

public class Bilhete {

	private String codigo;
	private Integer assento;
	private String horaMarcacaoAssento;
	private Passageiro passageiro;
	private Linha linha;
	
	
	public Bilhete() {
	}
	
	public Bilhete(String codigo, Integer assento, Passageiro passageiro, Linha linha, String horaMarcacaoAssento) {
		this.codigo = codigo;
		this.assento = assento;
		this.horaMarcacaoAssento = horaMarcacaoAssento;
		this.passageiro = passageiro;
		this.linha = linha;
	}
	
	public Bilhete(String codigo, Integer assento, Passageiro passageiro, Linha linha) {
		this.codigo = codigo;
		this.assento = assento;
		this.passageiro = passageiro;
		this.linha = linha;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Integer getAssento() {
		return assento;
	}
	
	public void setAssento(Integer assento) {
		this.assento = assento;
	}
	
	public String getHoraMarcacaoAssento() {
		return horaMarcacaoAssento;
	}
	
	public void setHoraMarcacaoAssento(String horaMarcacaoAssento) {
		this.horaMarcacaoAssento = horaMarcacaoAssento;
	}
	
	public Passageiro getPassageiro() {
		return passageiro;
	}
	
	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}
	
	public Linha getLinha() {
		return linha;
	}
	
	public void setLinha(Linha linha) {
		this.linha = linha;
	}
	
	@Override
	public String toString() {
		return "Bilhete [codigo=" + codigo + ", assento=" + assento + ", horaMarcacaoAssento=" + horaMarcacaoAssento
				+ ", passageiro=" + passageiro + ", linha=" + linha + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bilhete other = (Bilhete) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
}
