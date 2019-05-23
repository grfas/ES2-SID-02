package Administrador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Investigador.Cultura;
import Investigador.Medicoes;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

@SuppressWarnings("serial")
public class Admin_Gestao_Culturas_Medicoes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Administrador admin;

	public void run() {
		try {
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Admin_Gestao_Culturas_Medicoes(Administrador admin) {
		this.admin = admin;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCultura = new JLabel("Cultura");
		lblCultura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCultura.setBounds(78, 45, 66, 25);
		contentPane.add(lblCultura);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("   ");
		for (Cultura c : admin.culturas()) {
			comboBox.addItem(Integer.toString(c.getId_cultura()));
		}

		comboBox.setBounds(185, 45, 96, 29);
		contentPane.add(comboBox);

		JLabel lblVariavel = new JLabel("Variavel");
		lblVariavel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVariavel.setBounds(78, 81, 66, 25);
		contentPane.add(lblVariavel);

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.addItem("   ");
		ArrayList<String> variaveisPossiveis = new ArrayList<>();
		for (Variavel m : admin.variaveis()) {
			if (!variaveisPossiveis.contains(Integer.toString(m.getId_variavel()))) {
				variaveisPossiveis.add(Integer.toString(m.getId_variavel()));
				comboBox_1.addItem(Integer.toString(m.getId_variavel()));
			}

		}
		comboBox_1.setBounds(185, 85, 96, 29);
		contentPane.add(comboBox_1);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisar.setBounds(348, 59, 96, 31);
		contentPane.add(btnPesquisar);

		JLabel lblMedicao = new JLabel("Medicao");
		lblMedicao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMedicao.setBounds(61, 222, 66, 25);
		contentPane.add(lblMedicao);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(61, 253, 160, 31);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(299, 227, 46, 14);
		contentPane.add(lblData);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(299, 253, 160, 31);
		contentPane.add(textField_1);

		JButton btnInserir = new JButton("Inserir");
		btnInserir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInserir.setBounds(199, 312, 112, 31);
		contentPane.add(btnInserir);

		JLabel lblaammddHhmmss = new JLabel("(AAAA-MM-DD HH:MM:SS)");
		lblaammddHhmmss.setBounds(299, 287, 145, 14);
		contentPane.add(lblaammddHhmmss);

		btnInserir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int c = Integer.parseInt((String) comboBox.getSelectedItem());
					int v = Integer.parseInt((String) comboBox_1.getSelectedItem());
					;
					int valor = Integer.parseInt(textField.getText());
					String tempo = textField_1.getText();
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
					Date date = format.parse(tempo);
					admin.insereMedicao(new Medicoes(0, date, valor, c, v));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnPesquisar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String c = (String) comboBox.getSelectedItem();
				String v = (String) comboBox_1.getSelectedItem();
				DefaultListModel<String> model = new DefaultListModel<>();

				if (v.equals("   ") && !c.equals("   ")) {
					for (String val : admin.procuraIdCultura(c))
						model.addElement(val);
					Admin_Gestao_Culturas_Medicoes_Editar igcp = new Admin_Gestao_Culturas_Medicoes_Editar(admin, model, c, v);
					igcp.run();

				} else if (c.equals("   ") && !v.equals("   ")) {
					for (String val : admin.procuraVariavel(v))
						model.addElement(val);
					Admin_Gestao_Culturas_Medicoes_Editar igcp = new Admin_Gestao_Culturas_Medicoes_Editar(admin, model, c, v);
					igcp.run();
				}

				else if (!c.equals("   ") && !v.equals("   ")) {
					for (String val : admin.procura(c, v))
						model.addElement(val);
					Admin_Gestao_Culturas_Medicoes_Editar igcp = new Admin_Gestao_Culturas_Medicoes_Editar(admin, model, c, v);
					igcp.run();
				}

				else {
					JOptionPane.showMessageDialog(new JFrame(), "Nenhum valor selecionado");
				}

			}
		});

	}
}
