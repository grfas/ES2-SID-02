package Auditor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import login.User;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Aud_Gestao extends JFrame implements Runnable {

	private Auditor auditor;

	private JPanel contentPane;

	public void run() {
		try {
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Aud_Gestao(Auditor aud) {
		this.auditor = aud;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 434);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSid = new JButton("SID");
		btnSid.setBounds(147, 110, 107, 37);
		contentPane.add(btnSid);

		JButton btnSidAuditor = new JButton("SID Auditor");
		btnSidAuditor.setBounds(147, 215, 107, 37);
		contentPane.add(btnSidAuditor);

		JLabel lblSelecioneABase = new JLabel("Selecione a Base de Dados");
		lblSelecioneABase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelecioneABase.setBounds(108, 40, 179, 23);
		contentPane.add(lblSelecioneABase);

		btnSid.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Aud_Gestao_SID gestaoAud = new Aud_Gestao_SID(aud);
				gestaoAud.run();

			}
		});

		btnSidAuditor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Aud_Gestao_SID_Auditor gestaoAud = new Aud_Gestao_SID_Auditor(aud);
				gestaoAud.run();
			}
		});
	}
}
