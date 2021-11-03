package vavatur.visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import model.entities.Bilhete;
import vavatur.banco.BancoQuery;
import vavatur.visual.suporte.MarcacaoPainel;
import vavatur.visual.suporte.Situacao;

public class SelecionarAssento extends JFrame{

	private static final long serialVersionUID = 1L;
	JLabel lblSelecioneAssento;
	
	
	//Construtor
	public SelecionarAssento( BancoQuery banco, Bilhete b) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SelecionarAssento.class.getResource("/imagens/assento.png")));
		setTitle("Marcação de assento");
		setResizable(false);
		RealizarChecking rc = new RealizarChecking(banco);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 556);
		JPanel contentPane = new MarcacaoPainel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panelFundoAzul = new Panel();
		panelFundoAzul.setLayout(null);
		panelFundoAzul.setBackground(new Color(176, 224, 230));
		panelFundoAzul.setBounds(10, 27, 152, 197);
		contentPane.add(panelFundoAzul);
		
		JLabel lblOcupado = new JLabel("Ocupado");
		lblOcupado.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblOcupado.setBounds(46, 118, 67, 25);
		panelFundoAzul.add(lblOcupado);
		
		JLabel lblSelecioneAssento = new JLabel("Selecione um assento");
		lblSelecioneAssento.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSelecioneAssento.setBounds(10, 11, 208, 14);
		panelFundoAzul.add(lblSelecioneAssento);
		
		JLabel lblSelecionado = new JLabel("Selecionado");
		lblSelecionado.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblSelecionado.setBounds(42, 81, 92, 25);
		panelFundoAzul.add(lblSelecionado);
		
		JLabel lblLivre = new JLabel("Livre");
		lblLivre.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblLivre.setBounds(46, 48, 46, 23);
		panelFundoAzul.add(lblLivre);
		
		JPanel panelQuadradoVerde = new JPanel();
		panelQuadradoVerde.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQuadradoVerde.setBounds(10, 46, 26, 25);
		panelFundoAzul.add(panelQuadradoVerde);
		panelQuadradoVerde.setBackground(Color.GREEN);
		
		JPanel panelQuadradoVermelho = new JPanel();
		panelQuadradoVermelho.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQuadradoVermelho.setBounds(10, 118, 26, 25);
		panelFundoAzul.add(panelQuadradoVermelho);
		panelQuadradoVermelho.setBackground(Color.RED);
		
		JPanel panelQuadradoVerdeEscuro = new JPanel();
		panelQuadradoVerdeEscuro.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelQuadradoVerdeEscuro.setBackground(new Color(0, 100, 0));
		panelQuadradoVerdeEscuro.setBounds(10, 82, 26, 25);
		panelFundoAzul.add(panelQuadradoVerdeEscuro);
		
		
		// Muda o texto do painel para "Assento ? selecionado"
		JPanel panel = new MarcacaoPainel();
		panel.setSize(201, 434);
		panel.setLocation(185, 72);
		((MarcacaoPainel) panel).addListener((x) ->{
			lblSelecioneAssento.setText("Assento " + (x + 1) + " selecionado!");
		});
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setIcon(new ImageIcon(SelecionarAssento.class.getResource("/imagens/confirmar.png")));
		btnConfirmar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnConfirmar.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnConfirmar.setBounds(10, 158, 130, 23);
		
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((MarcacaoPainel) panel).setAssento(Situacao.OCUPADO,  ((MarcacaoPainel) panel).getAssentoSelecionado()+1);
				JOptionPane.showMessageDialog(null, "Assento marcado com sucesso! Checking realizado!");

				banco.marcarAssento(((MarcacaoPainel) panel).getAssentoSelecionado()+1, b.getCodigo());
				rc.setVisible(true);
				rc.setLocationRelativeTo(null);
				dispose();
			}
		});
		
		panelFundoAzul.add(btnConfirmar);
		
		contentPane.add(panel);
		banco.AssentosOcupados(b);
		((MarcacaoPainel) panel).setAssento(Situacao.OCUPADO, banco.AssentosOcupados(b));
		
		JLabel lblFundo = new JLabel("");
		lblFundo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblFundo.setIcon(new ImageIcon(SelecionarAssento.class.getResource("/imagens/busFundo.png")));
		lblFundo.setBounds(0, 0, 434, 517);
		contentPane.add(lblFundo);
	}
}
