package Auditor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class Aud_Gestao_SID_Auditor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Auditor auditor;
	private DefaultListModel<String> listaLogs = new DefaultListModel<>();

	/**
	 * Launch the application.
	 */

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
	public Aud_Gestao_SID_Auditor(Auditor aud) {
		this.auditor = aud;
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		textField = new JTextField();
		textField.setBounds(42, 49, 183, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisar.setBounds(267, 53, 122, 30);
		contentPane.add(btnPesquisar);
		JList list = new JList<String>(listaLogs);
		list.setBounds(42, 149, 377, 263);

		ArrayList<Log> listaTemp = aud.servidor2();
		for (Log l : listaTemp) {
			String s = l.getData().toString() + "  " + l.getHora() + "  " + l.getUsername() + "  " + l.getOperacao()
					+ "  " + l.getMensagem();
			listaLogs.addElement(s);
		}

		contentPane.add(list);

		JLabel lblBaseDeDados = new JLabel("Base de Dados : SID 2");
		lblBaseDeDados.setBounds(42, 11, 146, 23);
		contentPane.add(lblBaseDeDados);

		btnPesquisar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!listaLogs.isEmpty()) {
					listaLogs.clear();
				}
				if (!textField.getText().isEmpty()) {
					ArrayList<Log> logs = new ArrayList<Log>();
					try {
						logs = aud.procura(textField.getText(), false);
						for (Log l : logs) {
							String s = l.getData().toString() + "  " + l.getHora() + "  " + l.getUsername() + "  "
									+ l.getOperacao() + "  " + l.getMensagem();
							listaLogs.addElement(s);
						}
						logs.clear();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

	}
}
