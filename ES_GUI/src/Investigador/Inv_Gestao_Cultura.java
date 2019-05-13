package Investigador;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

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
		
		JComboBox comboBox = new JComboBox();
		for(Cultura c : inv.culturas) {
			comboBox.addItem(Integer.toString(c.getId_cultura()));
		}
		
		comboBox.setBounds(64, 34, 70, 26);
		contentPane.add(comboBox);
		
		JLabel lblCultura = new JLabel("Cultura");
		lblCultura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCultura.setBounds(179, 32, 90, 26);
		contentPane.add(lblCultura);
		
		JComboBox comboBox_1 = new JComboBox();
		ArrayList<String> variaveisPossiveis = new ArrayList<>(); 
		for(Medicoes m : inv.lista) {
			if(!variaveisPossiveis.contains(Integer.toString(m.getId_variavel()))){
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

	}

}
