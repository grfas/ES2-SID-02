package Investigador;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Inv_Gestao_Cultura extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Investigador inv;

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
	public Inv_Gestao_Cultura(Investigador inv) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("   ");
		for (Cultura c : inv.culturas) {
			comboBox.addItem(Integer.toString(c.getId_cultura()));
		}

		comboBox.setBounds(64, 34, 70, 26);
		contentPane.add(comboBox);

		JLabel lblCultura = new JLabel("Cultura");
		lblCultura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCultura.setBounds(179, 32, 90, 26);
		contentPane.add(lblCultura);

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.addItem("   ");
		ArrayList<String> variaveisPossiveis = new ArrayList<>();
		for (Medicoes m : inv.lista) {
			if (!variaveisPossiveis.contains(Integer.toString(m.getId_variavel()))) {
				variaveisPossiveis.add(Integer.toString(m.getId_variavel()));
				comboBox_1.addItem(Integer.toString(m.getId_variavel()));
			}

		}
		comboBox_1.setBounds(64, 92, 70, 26);
		contentPane.add(comboBox_1);

		JLabel lblVariavel = new JLabel("Variavel");
		lblVariavel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVariavel.setBounds(179, 93, 70, 20);
		contentPane.add(lblVariavel);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisar.setBounds(309, 88, 97, 31);
		contentPane.add(btnPesquisar);

		textField = new JTextField();
		textField.setBounds(215, 222, 136, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblMedicao = new JLabel("Medicao");
		lblMedicao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMedicao.setBounds(94, 223, 97, 20);
		contentPane.add(lblMedicao);

		textField_1 = new JTextField();
		textField_1.setBounds(215, 273, 136, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(94, 279, 57, 20);
		contentPane.add(lblData);

		JLabel lblaammddHhmmss = new JLabel("(AA-MM-DD HH:MM:SS)");
		lblaammddHhmmss.setBounds(215, 304, 136, 14);
		contentPane.add(lblaammddHhmmss);

		JButton btnInserir = new JButton("Inserir");
		btnInserir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInserir.setBounds(94, 355, 89, 23);
		contentPane.add(btnInserir);

		btnPesquisar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String c = (String) comboBox.getSelectedItem();
				String v = (String) comboBox_1.getSelectedItem();
				DefaultListModel<String> model = new DefaultListModel<>();
				
				if (v.equals("   ") && !c.equals("   ")) {
					for (String val : inv.procuraIdCultura(c))
						model.addElement(val);
					Inv_Gestao_Cultura_Pesquisa igcp = new Inv_Gestao_Cultura_Pesquisa(inv, model, c, v);
					igcp.run();

				}
				else if (c.equals("   ") && !v.equals("   ")) {
					for (String val : inv.procuraVariavel(v))
						model.addElement(val);
					Inv_Gestao_Cultura_Pesquisa igcp = new Inv_Gestao_Cultura_Pesquisa(inv, model, c, v);
					igcp.run();
				}

				else if (!c.equals("   ") && !v.equals("   ")) {
					for (String val : inv.procura(c, v))
						model.addElement(val);
					Inv_Gestao_Cultura_Pesquisa igcp = new Inv_Gestao_Cultura_Pesquisa(inv, model, c, v);
					igcp.run();
				}

				else {
					JOptionPane.showMessageDialog(new JFrame(), "Nenhum valor selecionado");
				}

			}
		});
		
		btnInserir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {		
				try {
					int c = Integer.parseInt((String) comboBox.getSelectedItem());
					int v = Integer.parseInt(JOptionPane.showInputDialog("Qual a variavel?"));
					int valor = Integer.parseInt(textField.getText());
					String tempo = textField_1.getText();
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
					Date date = format.parse(tempo);					
					inv.insereMedicao(new Medicoes(0, date, valor, c, v));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});


	}

}
