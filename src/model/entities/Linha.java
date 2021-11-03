package model.entities;

import java.util.Objects;

public class Linha {

	private int id;
	private String origem;
	private String destino;
	private String horaEmbarque;
	private String horaPartida;
	
	
	public Linha() {
	}
	
	public Linha(int id, String origem, String destino) {
		this.id = id;
		this.origem = origem;
		this.destino = destino;
	}
	

	public Linha(int id, String origem, String destino, String hr_embarquezinho, String hr_partidinha) {
		this.id = id;
		this.origem = origem;
		this.destino = destino;
		this.horaEmbarque = hr_embarquezinho;
		this.horaPartida = hr_partidinha;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getOrigem() {
		return origem;
	}
	
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	
	public String getDestino() {
		return destino;
	}
	
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	public String getHoraEmbarque() {
		return horaEmbarque;
	}
	
	public void setHoraEmbarque(String horaEmbarque) {
		this.horaEmbarque = horaEmbarque;
	}
	
	public String getHoraPartida() {
		return horaPartida;
	}
	
	public void setHoraPartida(String horaPartida) {
		this.horaPartida = horaPartida;
	}
	
	@Override
	public String toString() {
		return "Linha [id=" + id + ", origem=" + origem + ", destino=" + destino + ", horaEmbarque=" + horaEmbarque
				+ ", horaPartida=" + horaPartida + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Linha other = (Linha) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
