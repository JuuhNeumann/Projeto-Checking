package vavatur.visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import model.entities.Bilhete;
import vavatur.banco.BancoQuery;

public class LocalizadorCodigo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textCodigoLocalizador;

	// Construtor
	public LocalizadorCodigo(BancoQuery banco) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LocalizadorCodigo.class.getResource("/imagens/segundoIcon.png")));
		setFont(new Font("Times New Roman", Font.PLAIN, 13));
		setBackground(Color.WHITE);

		setResizable(false);
		setTitle("Localizador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 274, 233);
		getContentPane().setLayout(null);
		
		textCodigoLocalizador = new JTextField();
		textCodigoLocalizador.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textCodigoLocalizador.setColumns(10);
		textCodigoLocalizador.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textCodigoLocalizador.setBounds(171, 11, 66, 20);
		
		// Adiciona ação no texto "Localizador de Código"
		// Puxa do banco o código do bilhete
		textCodigoLocalizador.addActionListener((e) -> {
			String valor = textCodigoLocalizador.getText();
			Bilhete bilhetin = banco.buscaBilhete(valor);
			if (bilhetin != null) {
				JOptionPane.showMessageDialog(null, "Bilhete localizado! ",
						"Sucess", JOptionPane.INFORMATION_MESSAGE);
				InformacoesBilhete bilhete = new InformacoesBilhete(banco, bilhetin);
				bilhete.setLocationRelativeTo(null);
				bilhete.setVisible(true);
				dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Bilhete não localizado, por favor insira um código válido! ",
						"ERROR(404)", JOptionPane.ERROR_MESSAGE);
				setVisible(false);
				RealizarChecking rc = new RealizarChecking(banco);
				rc.setLocationRelativeTo(null);
				rc.setVisible(true);
				dispose();			
			}
		});
		
		getContentPane().add(textCodigoLocalizador);

		JLabel lblLocalizaCodigo = new JLabel("  Insira o código localizador: ");
		lblLocalizaCodigo.setBackground(new Color(51, 0, 102));
		lblLocalizaCodigo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblLocalizaCodigo.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblLocalizaCodigo.setForeground(new Color(255, 204, 102));
		lblLocalizaCodigo.setHorizontalAlignment(SwingConstants.LEFT);
		lblLocalizaCodigo.setBounds(10, 7, 239, 29);
		getContentPane().add(lblLocalizaCodigo);

		JLabel lblFundo = new JLabel("");
		lblFundo.setBackground(new Color(51, 0, 102));
		lblFundo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblFundo.setIcon(new ImageIcon(LocalizadorCodigo.class.getResource("/imagens/segundoFundo.png")));
		lblFundo.setBounds(0, -14, 258, 216);
		getContentPane().add(lblFundo);
	}
}
