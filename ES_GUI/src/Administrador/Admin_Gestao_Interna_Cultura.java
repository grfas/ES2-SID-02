package Administrador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Investigador.Cultura;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class Admin_Gestao_Interna_Cultura extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Administrador admin;
	private DefaultListModel<String> lista = new DefaultListModel<String>();
	JList<String> list = new JList<String>(lista);

	public void run() {
		try {
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Admin_Gestao_Interna_Cultura(Administrador admin) {
		this.setAdmin(admin);
		for (Cultura v : admin.culturas()) {
			lista.addElement(Integer.toString(v.getId_cultura()) + "-" + v.getNome_cultura() + "-"
					+ v.getDescricao_cultura() + "-" + Integer.toString(v.getUsername()));
		}
		if (lista.isEmpty()) {
			lista.addElement("Nada a apresentar");
		}
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIdCultura = new JLabel("ID Cultura");
		lblIdCultura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdCultura.setBounds(65, 37, 81, 14);
		contentPane.add(lblIdCultura);

		JLabel lblNome = new JLabel("Nome ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(75, 57, 46, 14);
		contentPane.add(lblNome);

		textField = new JTextField();
		textField.setBounds(155, 31, 157, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(155, 56, 157, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnCriarCultura = new JButton("Criar Cultura");
		btnCriarCultura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCriarCultura.setBounds(344, 89, 115, 23);
		contentPane.add(btnCriarCultura);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(49, 134, 365, 237);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(list);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisar.setBounds(344, 30, 115, 41);
		contentPane.add(btnPesquisar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(49, 382, 89, 23);
		contentPane.add(btnEditar);

		JButton btnApagar = new JButton("Apagar");
		btnApagar.setBounds(325, 403, 89, 23);
		contentPane.add(btnApagar);

		btnEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!list.isSelectionEmpty()) {
					String entrada = list.getSelectedValue();
					if (!entrada.equals("Nada a apresentar")) {
						String[] partida = entrada.split("-");
						int i = Integer.parseInt(partida[0]);
						String nome = partida[1];
						String descricao = partida[2];
						int responsavel = Integer.parseInt(partida[3]);
						Admin_Gestao_Interna_Cultura_Editar agice = new Admin_Gestao_Interna_Cultura_Editar(i, nome,
								descricao, responsavel, admin);
						agice.run();
					}
				}
			}
		});

		btnCriarCultura.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Admin_Gestao_Interna_Cultura_Criar agice = new Admin_Gestao_Interna_Cultura_Criar(admin);
				agice.run();

			}
		});

		btnApagar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!list.isSelectionEmpty()) {
					String entrada = list.getSelectedValue();
					if (!entrada.equals("Nada a apresentar")) {
						String[] partida = entrada.split(" ");
						int i = Integer.parseInt(partida[0]);
						String query = "DELETE FROM medicoes WHERE id_cultura = " + i;
						String query1 = "DELETE FROM variaveis_medidas WHERE id_cultura = " + i;
						String query2 = "DELETE FROM cultura WHERE id_cultura = " + i;
						admin.executaUpdate(query);
						admin.executaUpdate(query1);
						admin.executaUpdate(query2);
					}
				}
			}
		});

		btnPesquisar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Cultura> culturas = new ArrayList<Cultura>();
				if (textField.getText().isEmpty() && !textField_1.getText().isEmpty()) {
					culturas = admin.pesquisaNomeCultura(textField_1.getText());				}
				else if (textField_1.getText().isEmpty() && !textField.getText().isEmpty()) {		
					culturas = admin.pesquisaIdCultura(Integer.parseInt(textField.getText()));
				}
				else if (!textField_1.getText().isEmpty() && !textField.getText().isEmpty()) {
					culturas = admin.pesquisaNomeIdCultura(textField.getText(), textField_1.getText());
				} else {
					culturas = admin.culturas();
				}
				lista.clear();
				for (Cultura v : culturas) {
					lista.addElement(Integer.toString(v.getId_cultura()) + "-" + v.getNome_cultura() + "-"
							+ v.getDescricao_cultura() + "-" + Integer.toString(v.getUsername()));
				}
			}
		});
	}

	public Administrador getAdmin() {
		return admin;
	}

	public void setAdmin(Administrador admin) {
		this.admin = admin;
	}
}
