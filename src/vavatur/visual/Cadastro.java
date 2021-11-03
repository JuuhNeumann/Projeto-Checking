package vavatur.visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import model.entities.Bilhete;
import vavatur.banco.BancoQuery;

public class Cadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdDoPassageiro;
	private JLabel lblFundo;
	private JLabel lblNome;
	private JTextField textNome;
	private JTextField textCpf;
	private JTextField textEmail;
	private JTextField textTelefone;
	private JLabel lblTelefone;
	private JLabel lblCpf;
	private JLabel lblEmail;
	

	// Construtor
	public Cadastro(InformacoesBilhete bilhete, BancoQuery banco, Bilhete bilhetin) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cadastro.class.getResource("/imagens/quartoIcon.png")));
		setResizable(false);
		setTitle("Cadastro Passageiro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// Chamada das funções que pega informações do banco
		String nomezinho = bilhetin.getPassageiro().getNome();
		String cpfzinho = bilhetin.getPassageiro().getCpf();
		String telefonezinho = bilhetin.getPassageiro().getTelefone();
		String emailzinho = bilhetin.getPassageiro().getEmail();
		int idzinho = bilhetin.getPassageiro().getId();
		String gambiarra =  String.valueOf(idzinho);

		textTelefone = new JTextField();
		textTelefone.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textTelefone.setColumns(10);
		textTelefone.setBounds(20, 211, 141, 20);
		textTelefone.setText(telefonezinho);
		contentPane.add(textTelefone);

		lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTelefone.setBounds(20, 196, 56, 14);
		contentPane.add(lblTelefone);

		lblCpf = new JLabel("Cpf: ");
		lblCpf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCpf.setBounds(20, 94, 52, 17);
		contentPane.add(lblCpf);

		textEmail = new JTextField();
		textEmail.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textEmail.setColumns(10);
		textEmail.setBounds(20, 162, 141, 20);
		textEmail.setText(emailzinho);
		contentPane.add(textEmail);

		lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEmail.setBounds(20, 147, 47, 14);
		contentPane.add(lblEmail);

		textCpf = new JTextField();
		textCpf.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textCpf.setColumns(10);
		textCpf.setBounds(20, 112, 141, 20);
		textCpf.setText(cpfzinho);
		contentPane.add(textCpf);

		textNome = new JTextField();
		textNome.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textNome.setColumns(10);
		textNome.setBounds(20, 68, 141, 20);
		textNome.setText(nomezinho);
		contentPane.add(textNome);

		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNome.setBounds(20, 53, 47, 14);
		contentPane.add(lblNome);

		txtIdDoPassageiro = new JTextField();
		txtIdDoPassageiro.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtIdDoPassageiro.setFont(new Font("Times New Roman", Font.BOLD, 13));
		txtIdDoPassageiro.setEditable(false);
		txtIdDoPassageiro.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdDoPassageiro.setBackground(new Color(127, 255, 212));
		txtIdDoPassageiro.setBounds(0, 0, 454, 33);
		txtIdDoPassageiro.setText("ID PASSAGEIRO: " + gambiarra);
		contentPane.add(txtIdDoPassageiro);
		txtIdDoPassageiro.setColumns(10);

		JButton btnSalvarInformacoes = new JButton("Salvar informações");
		btnSalvarInformacoes.setIcon(new ImageIcon(Cadastro.class.getResource("/imagens/salvar.png")));
		btnSalvarInformacoes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnSalvarInformacoes.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnSalvarInformacoes.setBounds(207, 257, 183, 23);

		// Adiciona ação no botão "Salvar informações"
		btnSalvarInformacoes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				bilhetin.getPassageiro().setNome(textNome.getText());
				bilhetin.getPassageiro().setCpf(textCpf.getText());
				bilhetin.getPassageiro().setTelefone(textTelefone.getText());
				bilhetin.getPassageiro().setEmail(textEmail.getText());
				banco.attDados(bilhetin);
				
				JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso! ",
						"Sucess", JOptionPane.INFORMATION_MESSAGE);
				InformacoesBilhete ib = new InformacoesBilhete(banco, bilhetin);
				ib.setLocationRelativeTo(null); 
				ib.setVisible(true);
				dispose();
				
			}
		});

		contentPane.add(btnSalvarInformacoes);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(Cadastro.class.getResource("/imagens/anterior.png")));
		btnVoltar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnVoltar.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnVoltar.setBounds(58, 257, 105, 23);

		// Adiciona ação no botão "Voltar"
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bilhete.setVisible(true);
				dispose();
			}
		});

		contentPane.add(btnVoltar);

		lblFundo = new JLabel("");
		lblFundo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblFundo.setIcon(new ImageIcon(Cadastro.class.getResource("/imagens/terceiroFundo.png")));
		lblFundo.setBounds(0, -11, 454, 302);
		contentPane.add(lblFundo);

	}
}
