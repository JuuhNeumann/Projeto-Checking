package vavatur.visual.suporte;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;


public class MarcacaoPainel extends JPanel{

	private static final long serialVersionUID = 1L;
	private Situacao situacao;
	private List<JButton> ljb = new ArrayList<>();
	private Integer assentoSelecionado = null;
	private List<ObservadoresDeMudanca> listeners = new ArrayList<>();
	
	// Adiciona uma lista de observadores
	public void addListener(ObservadoresDeMudanca listener) {
		this.listeners.add(listener);
	}
	
	// Remove uma lista de observadores
	public void removeListener(ObservadoresDeMudanca listener) {
		this.listeners.remove(listener);
	}
	
	
	private ActionListener aoclicar = (e) -> {
		if(this.situacao != Situacao.OCUPADO && this.assentoSelecionado != null){
			this.setAssento(Situacao.LIVRE, (assentoSelecionado+1));	
		}
		if(this.situacao == Situacao.OCUPADO && this.assentoSelecionado != null) {
			this.setAssento(Situacao.LIVRE, (assentoSelecionado+1));	
		}
		
		this.assentoSelecionado = ljb.indexOf(e.getSource());
		this.setAssento(Situacao.SELECIONADO, (this.assentoSelecionado+1));
		
		for(ObservadoresDeMudanca x : this.listeners) {
			x.mudanca(this.assentoSelecionado);
		}
	};
	
	// Pega um assento selecionado
	public Integer getAssentoSelecionado() {
		return this.assentoSelecionado;
	}
	
	
	// Construtor
	public MarcacaoPainel() {
		setBounds(15, 93, 249, 413);
		for(int i=0 ;i<30; i++) {
			JButton bn = new JButton("" +(i+1));
			bn.setFont(new Font("Arial", Font.BOLD, 8));
			bn.addActionListener(aoclicar);
			add(bn);
			ljb.add(bn);
			setAssento(Situacao.LIVRE, (i+1));
		}
		setLayout(new GridLayout(0, 4, 10, 10));
	}
	
	//Troca a situação e cor do assento a partir de um inteiro
	public void setAssento(Situacao situacao, Integer i) {
		JButton b = ljb.get(i - 1);
		if(situacao == Situacao.OCUPADO) {
			b.setBackground(Color.RED);
			b.setEnabled(false);
			this.situacao = situacao;
			
		}else if(situacao == Situacao.LIVRE) {
			b.setBackground(Color.GREEN);
			b.setEnabled(true);
		}else if(situacao == Situacao.SELECIONADO) {
			b.setBackground(new Color(0,100,0));
		}
	}
	
	//Troca a situação e cor do assento a partir de uma lista de inteiros
	public void setAssento(Situacao situacao, List<Integer> j) {
		for(Integer i : j) {
			JButton b = ljb.get(i - 1);
			if(situacao == Situacao.OCUPADO) {
				b.setBackground(Color.RED);
				b.setEnabled(false);
				this.situacao = situacao;
			
			}else if(situacao == Situacao.LIVRE) {
				b.setBackground(Color.GREEN);
				b.setEnabled(true);
			}else if(situacao == Situacao.SELECIONADO) {
				b.setBackground(new Color(0,100,0));
			}
		}
	}

}