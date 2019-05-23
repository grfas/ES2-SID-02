package Administrador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

@SuppressWarnings("serial")
public class Admin_Gestao_Interna_Cultura_Editar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblResponsavel;
	private JTextField textField_2;
	private JButton btnGuardar;
	private Administrador admin;
	private int i;
	private String nome;
	private String descricao;
	private int responsavel;

	public void run() {
		try {

			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Admin_Gestao_Interna_Cultura_Editar(int i, String nome, String descricao, int responsavel,
			Administrador admin) {
		this.i = i;
		this.nome = nome;
		this.descricao = descricao;
		this.responsavel = responsavel;
		setAdmin(admin);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeDaCultura = new JLabel("Nome da Cultura");
		lblNomeDaCultura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeDaCultura.setBounds(61, 44, 134, 24);
		contentPane.add(lblNomeDaCultura);

		textField = new JTextField();
		textField.setBounds(231, 44, 161, 24);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblDescricao = new JLabel("Descricao");
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescricao.setBounds(61, 85, 134, 24);
		contentPane.add(lblDescricao);

		textField_1 = new JTextField();
		textField_1.setBounds(231, 87, 161, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		lblResponsavel = new JLabel("Responsavel");
		lblResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResponsavel.setBounds(61, 125, 134, 24);
		contentPane.add(lblResponsavel);

		textField_2 = new JTextField();
		textField_2.setBounds(231, 129, 161, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuardar.setBounds(156, 256, 142, 43);
		contentPane.add(btnGuardar);

		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().isEmpty() && textField_1.getText().isEmpty()
						&& textField_2.getText().isEmpty()) {
					String query = "UPDATE `cultura` SET `nome_cultura`= '" + textField.getText() + "' WHERE id_cultura = " + i;
					admin.executaUpdate(query);
				}

				else if (!textField.getText().isEmpty() && textField_1.getText().isEmpty()
						&& !textField_2.getText().isEmpty()) {
					String query = "UPDATE `cultura` SET `nome_cultura`= '" + textField.getText() + "', `responsavel`= " + Integer.parseInt(textField_2.getText())
							+ " WHERE id_cultura = " + i;
					admin.executaUpdate(query);
				}

				else if (!textField.getText().isEmpty() && !textField_1.getText().isEmpty()
						&& textField_2.getText().isEmpty()) {
					String query = "UPDATE `cultura` SET `nome_cultura`= '" + textField.getText() + "', `descricao_cultura`= '"
							+ textField_1.getText() + "' WHERE id_cultura = " + i;
					admin.executaUpdate(query);
				}

				else if (!textField.getText().isEmpty() && !textField_1.getText().isEmpty()
						&& !textField_2.getText().isEmpty()) {
					String query = "UPDATE `cultura` SET `nome_cultura`= '" + textField.getText() + "', `responsavel`= " + Integer.parseInt(textField_2.getText())
							+ ", `descricao_cultura`= '" + descricao + "' WHERE id_cultura = " + i;
					admin.executaUpdate(query);
				}

				else if (textField.getText().isEmpty() && textField_1.getText().isEmpty()
						&& !textField_2.getText().isEmpty()) {
					String query = "UPDATE `cultura` SET `responsavel`= " + Integer.parseInt(textField_2.getText()) + " WHERE id_cultura = " + i;
					admin.executaUpdate(query);
				}

				else if (textField.getText().isEmpty() && !textField_1.getText().isEmpty()
						&& textField_2.getText().isEmpty()) {
					String query = "UPDATE `cultura` SET `descricao_cultura`= '" + textField_1.getText() + "' WHERE id_cultura = "
							+ i;
					admin.executaUpdate(query);
				}

				else if (textField.getText().isEmpty() && !textField_1.getText().isEmpty()
						&& !textField_2.getText().isEmpty()) {
					String query = "UPDATE `cultura` SET `descricao_cultura`= '" + textField_1.getText() + "', `responsavel`= "
							+ Integer.parseInt(textField_2.getText()) + " WHERE id_cultura = " + i;
					admin.executaUpdate(query);
				}

				else {
					String query = "SELECT * FROM cultura";
					admin.executaQuery(query);
				}

			}
		});

	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(int responsavel) {
		this.responsavel = responsavel;
	}

	public void setAdmin(Administrador admin) {
		this.admin = admin;
	}

}
