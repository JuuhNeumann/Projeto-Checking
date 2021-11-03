package vavatur.visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import model.entities.Bilhete;
import vavatur.banco.BancoQuery;
import javax.swing.JSeparator;
import javax.swing.UIManager;

public class InformacoesBilhete extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JLabel lblOrigem;
	private JLabel lblDestino;
	private JLabel lblEmbarque;
	private JLabel lblPartida;
	private JLabel lblHora;
	private JEditorPane editorPaneNome;
	private JEditorPane editorPaneCpf;
	private JEditorPane editorPaneOrigem;
	private JEditorPane editorPaneDestino;
	private JEditorPane editorPaneEmbarque;
	private JEditorPane editorPanePartida;
	private JLabel lblAssento;
	private JSeparator separator;


	// Construtor
	public InformacoesBilhete(BancoQuery banco, Bilhete bilhetin) {
		Cadastro c = new Cadastro(this, banco, bilhetin);
		SelecionarAssento a = new SelecionarAssento(banco, bilhetin);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(InformacoesBilhete.class.getResource("/imagens/terceiroIcon.png")));
		String formatter =  String.valueOf(bilhetin.getAssento());
		
	
		setResizable(false);
		setTitle("Bilhete");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 420);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblHora = new JLabel(horaRelogio());
		lblHora.setForeground(new Color(128, 0, 0));
		lblHora.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setBounds(146, 0, 98, 33);
		contentPane.add(lblHora);

		JEditorPane dtrpnCima = new JEditorPane();
		dtrpnCima.setForeground(new Color(255, 255, 255));
		dtrpnCima.setEditable(false);
		dtrpnCima.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		dtrpnCima.setFont(new Font("Times New Roman", Font.BOLD, 14));
		dtrpnCima.setText("                                  BUS TICKET");
		dtrpnCima.setBackground(new Color(128, 0, 0));
		dtrpnCima.setBounds(0, 33, 349, 23);
		contentPane.add(dtrpnCima);

		JEditorPane dtrpnBaixo = new JEditorPane();
		dtrpnBaixo.setEditable(false);
		dtrpnBaixo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		dtrpnBaixo.setFont(new Font("Times New Roman", Font.BOLD, 13));
		dtrpnBaixo.setBackground(new Color(128, 0, 0));
		dtrpnBaixo.setBounds(0, 363, 349, 20);
		contentPane.add(dtrpnBaixo);
		
		separator = new JSeparator();
		separator.setForeground(new Color(128, 0, 0));
		separator.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		separator.setBackground(new Color(128, 0, 0));
		separator.setBounds(0, 255, 349, 2);
		contentPane.add(separator);

		lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNome.setBounds(20, 67, 71, 20);
		contentPane.add(lblNome);

		lblCpf = new JLabel("Cpf: ");
		lblCpf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCpf.setBounds(190, 67, 71, 19);
		contentPane.add(lblCpf);

		JButton btnAtualizarDados = new JButton("Atualizar dados pessoais");
		btnAtualizarDados.setIcon(new ImageIcon(InformacoesBilhete.class.getResource("/imagens/atualizar.png")));
		btnAtualizarDados.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnAtualizarDados.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnAtualizarDados.setBounds(84, 222, 177, 23);

		// Adiciona ação ao botão "Atualizar dados pessoais"
		btnAtualizarDados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.setLocationRelativeTo(null);
				c.setVisible(true);
				dispose();
			}
		});

		contentPane.add(btnAtualizarDados);

		JLabel lblCodigoBarras = new JLabel("");
		lblCodigoBarras.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblCodigoBarras.setIcon(new ImageIcon(InformacoesBilhete.class.getResource("/imagens/barrasCodigo.png")));
		lblCodigoBarras.setBounds(10, 312, 329, 40);
		contentPane.add(lblCodigoBarras);

		JLabel lblRelogio = new JLabel("");
		lblRelogio.setIcon(new ImageIcon(InformacoesBilhete.class.getResource("/imagens/relogio.png")));
		lblRelogio.setBounds(124, 0, 36, 33);
		contentPane.add(lblRelogio);

		JEditorPane editorPaneRelogio = new JEditorPane();
		editorPaneRelogio.setEditable(false);
		editorPaneRelogio.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		editorPaneRelogio.setBackground(new Color(255, 255, 153));
		editorPaneRelogio.setBounds(0, 0, 349, 33);
		contentPane.add(editorPaneRelogio);

		lblOrigem = new JLabel("Origem: ");
		lblOrigem.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblOrigem.setBounds(20, 117, 54, 20);
		contentPane.add(lblOrigem);

		lblDestino = new JLabel("Destino: ");
		lblDestino.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDestino.setBounds(190, 116, 54, 23);
		contentPane.add(lblDestino);

		lblEmbarque = new JLabel("Embarque: ");
		lblEmbarque.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEmbarque.setBounds(20, 170, 71, 23);
		contentPane.add(lblEmbarque);

		lblPartida = new JLabel("Partida:  ");
		lblPartida.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPartida.setBounds(190, 170, 54, 23);
		contentPane.add(lblPartida);

		JButton btnProximo = new JButton("Próximo");
		btnProximo.setHorizontalTextPosition(SwingConstants.LEFT);
		btnProximo.setIcon(new ImageIcon(InformacoesBilhete.class.getResource("/imagens/proximo.png")));
		btnProximo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnProximo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnProximo.setBounds(109, 268, 118, 33);
		
		// Adiciona ação ao botão "Próximo"	
		btnProximo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnProximo.setVisible(true);
				a.setLocationRelativeTo(null); 
				a.setVisible(true);
				dispose();
			}
		});
		
		contentPane.add(btnProximo);

		
		// Chamada das funções que pega informações do banco
		String nomezinho = bilhetin.getPassageiro().getNome();
		String cpfzinho = bilhetin.getPassageiro().getCpf();
		String origenzinha = bilhetin.getLinha().getOrigem();
		String destininho = bilhetin.getLinha().getDestino();
		String hr_embarquezinho = bilhetin.getLinha().getHoraEmbarque();
		String hr_partidinha = bilhetin.getLinha().getHoraPartida();
		
		editorPaneNome = new JEditorPane();
		editorPaneNome.setEditable(false);
		editorPaneNome.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		editorPaneNome.setBounds(20, 86, 140, 23);
		editorPaneNome.setText(nomezinho);
		contentPane.add(editorPaneNome);

		editorPaneCpf = new JEditorPane();
		editorPaneCpf.setEditable(false);
		editorPaneCpf.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		editorPaneCpf.setBounds(190, 86, 140, 23);
		editorPaneCpf.setText(cpfzinho);
		contentPane.add(editorPaneCpf);

		editorPaneOrigem = new JEditorPane();
		editorPaneOrigem.setEditable(false);
		editorPaneOrigem.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		editorPaneOrigem.setBounds(20, 136, 140, 23);
		editorPaneOrigem.setText(origenzinha);
		contentPane.add(editorPaneOrigem);

		editorPaneDestino = new JEditorPane();
		editorPaneDestino.setEditable(false);
		editorPaneDestino.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		editorPaneDestino.setBounds(190, 136, 140, 23);
		editorPaneDestino.setText(destininho);
		contentPane.add(editorPaneDestino);

		editorPaneEmbarque = new JEditorPane();
		editorPaneEmbarque.setEditable(false);
		editorPaneEmbarque.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		editorPaneEmbarque.setBounds(20, 188, 140, 23);
		editorPaneEmbarque.setText(hr_embarquezinho);
		contentPane.add(editorPaneEmbarque);

		editorPanePartida = new JEditorPane();
		editorPanePartida.setEditable(false);
		editorPanePartida.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		editorPanePartida.setBounds(190, 188, 140, 23);
		editorPanePartida.setText(hr_partidinha);
		contentPane.add(editorPanePartida);
		
		lblAssento = new JLabel("");
		lblAssento.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAssento.setHorizontalAlignment(SwingConstants.LEFT);
		lblAssento.setVisible(false);
		lblAssento.setIcon(new ImageIcon(InformacoesBilhete.class.getResource("/imagens/assentoMarcado.png")));
		lblAssento.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblAssento.setBounds(10, 268, 192, 33);
		contentPane.add(lblAssento);
		
		JButton btnApagar = new JButton("Remover assento");
		btnApagar.setIcon(new ImageIcon(InformacoesBilhete.class.getResource("/imagens/remover.png")));
		btnApagar.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnApagar.setVisible(false);
		btnApagar.setBounds(190, 273, 149, 23);
		
		// Adiciona ação ao botão "Remover assento"
		btnApagar.addActionListener(new ActionListener() {
		@Override
			public void actionPerformed(ActionEvent e) {
				banco.apagarAssento(bilhetin);
				JOptionPane.showMessageDialog(null, "Assento removido! ",
						"Sucess", JOptionPane.INFORMATION_MESSAGE);
				LocalizadorCodigo lc = new LocalizadorCodigo(banco);
				lc.setVisible(true);
				lc.setLocationRelativeTo(null);
				dispose();
			}
		});
		
		contentPane.add(btnApagar);
		
		// Verifica se passageiro já tem um assento
		if(banco.verificaAssento(bilhetin)) {
			if(bilhetin.getAssento() != 0 && bilhetin.getAssento() <=30 && bilhetin.getAssento() != null) {
			lblAssento.setText("Assento já marcado: " + formatter);
			lblAssento.setVisible(true);
			btnProximo.setVisible(false);
			btnApagar.setVisible(true);
			
			}	
		}
	}

	// Método para deixar a hora do relógio dinâmico
	public String horaRelogio() {
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
		String horaFormatada = formatterHora.format(agora);
		return horaFormatada;
	}
}
