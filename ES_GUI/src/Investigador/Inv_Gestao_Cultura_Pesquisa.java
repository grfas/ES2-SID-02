package Investigador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Inv_Gestao_Cultura_Pesquisa extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<String> listaMedicoes;
	private Investigador inv;
	private String c;
	private String v;

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
	public Inv_Gestao_Cultura_Pesquisa(Investigador inv, DefaultListModel<String> listaMedicoes, String c, String v) {
		this.inv = inv;
		if (v.equals("   ")) {
			this.v = "Nenhuma Variável Selecionada";
		} else {
			this.v = v;
		}
		if (c.equals("   ")) {
			this.c = "Nenhuma Cultura Selecionada";
		} else {
			this.c = c;
		}
		this.listaMedicoes = listaMedicoes;
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCultura = new JLabel("Cultura");
		lblCultura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCultura.setBounds(77, 46, 46, 14);
		contentPane.add(lblCultura);

		JLabel lblnomecultura = new JLabel(this.c);
		lblnomecultura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnomecultura.setBounds(180, 42, 111, 23);
		contentPane.add(lblnomecultura);

		JLabel lblVariavel = new JLabel("Variavel");
		lblVariavel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVariavel.setBounds(77, 93, 46, 14);
		contentPane.add(lblVariavel);

		JLabel lblnomevariavel = new JLabel(this.v);
		lblnomevariavel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnomevariavel.setBounds(180, 89, 111, 23);
		contentPane.add(lblnomevariavel);

		JList<String> list = new JList<String>(listaMedicoes);
		list.setBounds(62, 145, 375, 224);
		contentPane.add(list);

		JLabel lblMedicoes = new JLabel("Medicoes :");
		lblMedicoes.setBounds(62, 129, 61, 14);
		contentPane.add(lblMedicoes);

		JButton btnApagar = new JButton("Apagar");
		btnApagar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnApagar.setBounds(43, 380, 89, 23);
		contentPane.add(btnApagar);

		btnApagar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inv.apagaMedicao(list.getSelectedIndex());
				listaMedicoes.clear();
				atualizaListaMedicoes();
			}
		});

	}

	private void atualizaListaMedicoes() {
		for (Medicoes val : inv.lista) {
			listaMedicoes.addElement(Integer.toString(val.getNumero_medicao()) + "    " + val.getData().toString()
					+ "    " + Integer.toString(val.getValor_medicao()) + "    " + Integer.toString(val.getId_cultura())
					+ "    " + Integer.toString(val.getId_variavel()));

		}
	}

}
