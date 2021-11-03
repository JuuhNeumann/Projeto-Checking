package vavatur.visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import vavatur.banco.BancoQuery;

public class RealizarChecking extends JFrame {

	private static final long serialVersionUID = 1L;

	// Método para exibir a janela
	public void exibir() {
		setLocationRelativeTo(null);
		setVisible(true);
	}

	// Construtor
	public RealizarChecking(BancoQuery banco) {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(RealizarChecking.class.getResource("/imagens/primeiroIcon.png")));
		LocalizadorCodigo lg = new LocalizadorCodigo(banco);

		setResizable(false);
		setTitle("Checking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 240);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);

		JLabel lblB = new JLabel("BUS");
		lblB.setForeground(new Color(0, 0, 51));
		lblB.setHorizontalAlignment(SwingConstants.CENTER);
		lblB.setFont(new Font("MS Gothic", Font.BOLD, 13));
		lblB.setBounds(69, 95, 31, 34);
		getContentPane().add(lblB);

		JLabel lblVavatur = new JLabel("Vavatur");
		lblVavatur.setForeground(new Color(0, 0, 102));
		lblVavatur.setFont(new Font("Verdana", Font.BOLD, 9));
		lblVavatur.setHorizontalAlignment(SwingConstants.CENTER);
		lblVavatur.setBounds(170, 74, 46, 31);
		getContentPane().add(lblVavatur);

		JLabel lblRealizarCheck = new JLabel("Realizar Check In");
		lblRealizarCheck.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblRealizarCheck.setForeground(new Color(51, 0, 102));
		lblRealizarCheck.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblRealizarCheck.setHorizontalAlignment(SwingConstants.CENTER);
		lblRealizarCheck.setBounds(36, 11, 180, 52);

		// Adiciona ação na label "Realizar Check In"
		lblRealizarCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lg.setLocationRelativeTo(null);
				lg.setVisible(true);
				dispose();
			}
		});

		getContentPane().add(lblRealizarCheck);

		JLabel lblFundo = new JLabel("");
		lblFundo.setBackground(new Color(255, 182, 193));
		lblFundo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblFundo.setIcon(new ImageIcon(RealizarChecking.class.getResource("/imagens/primeiroFundo.png")));
		lblFundo.setBounds(0, 0, 254, 201);
		getContentPane().add(lblFundo);

	}

}