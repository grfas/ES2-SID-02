package Auditor;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class Aud_Gestao extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aud_Gestao frame = new Aud_Gestao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Aud_Gestao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 434);
		contentPane = new JPanel();
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
	}
}
