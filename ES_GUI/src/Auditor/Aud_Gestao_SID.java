package Auditor;

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

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class Aud_Gestao_SID extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Auditor aud;
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
	public Aud_Gestao_SID(Auditor aud) {
		this.setAud(aud);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setBackground(Color.LIGHT_GRAY);
	
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
		ArrayList<Log> listaTemp = aud.servidor1();
		for (Log l : listaTemp) {
			String s = l.getData().toString() + "  " + l.getHora() + "  " + l.getUsername() + "  " + l.getOperacao()
					+ "  " + l.getMensagem();
			listaLogs.addElement(s);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(42, 149, 377, 263);
		contentPane.add(scrollPane);
		
				JList<String> list = new JList<String>(listaLogs);
				scrollPane.setViewportView(list);

		JLabel lblBaseDeDados = new JLabel("Base de Dados : SID");
		lblBaseDeDados.setBounds(42, 11, 140, 14);
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
						logs = aud.procura(textField.getText(), true);
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

	public Auditor getAud() {
		return aud;
	}

	public void setAud(Auditor aud) {
		this.aud = aud;
	}
}
