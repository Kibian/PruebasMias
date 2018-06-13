package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import src.Cliente;
import src.DatabaseManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAplicacinDeEntrega;
	private JButton btnIniciarSesin;
	private JButton btnRegistrarse;
	private JLabel label;
	private JPanel panelInicio;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel;
	private JPanel panelRegistro;
	private JPanel panel_1;
	private JLabel label_1;
	private JLabel lblRegistro;
	private JLabel label_2;
	private JPanel panelNombre;
	private JLabel lblNombre;
	private JTextField textField;
	private JPanel panel_2;
	private JLabel lblContrasea;
	private JTextField textField_1;
	private JPanel panel_5;
	private JLabel label_4;
	private JTextField textField_2;
	private JPanel panel_6;
	private JLabel lblApellidos;
	private JTextField textField_3;
	private JPanel panel_7;
	private JLabel lblDireccin;
	private JTextField textField_4;
	private JPanel panel_8;
	private JLabel lblProvincia;
	private JComboBox<String> comboBox;
	private JLabel label_3;
	private JPanel panel_9;
	private JLabel label_5;
	private JLabel label_6;
	private JPanel panel_10;
	private JButton btnRegistrarse_1;
	private JPanel panelLogin;
	private JPanel panel_11;
	private JLabel label_7;
	private JLabel label_8;
	private JPanel panel_12;
	private JLabel lblInicioDeSesin;
	private JPanel panelLoginUser;
	private JLabel lblDni;
	private JTextField textField_5;
	private JPanel panel_13;
	private JPanel panelLoginPw;
	private JLabel lblContrasea_1;
	private JTextField textField_6;
	private JPanel panel_14;
	private JButton btnEntrarLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPanelInicio(), "panelInicio");
		contentPane.add(getPanelRegistro(), "panelRegistro");
		contentPane.add(getPanelLogin(), "panelLogin");
	}
	private JLabel getLblAplicacinDeEntrega() {
		if (lblAplicacinDeEntrega == null) {
			lblAplicacinDeEntrega = new JLabel("Aplicaci\u00F3n de entrega de env\u00EDos");
			lblAplicacinDeEntrega.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		}
		return lblAplicacinDeEntrega;
	}
	private JButton getBtnIniciarSesin() {
		if (btnIniciarSesin == null) {
			btnIniciarSesin = new JButton("Iniciar Sesi\u00F3n");
			btnIniciarSesin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelLogin");
				}
			});
		}
		return btnIniciarSesin;
	}
	private JButton getBtnRegistrarse() {
		if (btnRegistrarse == null) {
			btnRegistrarse = new JButton("Registrarse");
			btnRegistrarse.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelRegistro");
				}
			});
		}
		return btnRegistrarse;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel(new ImageIcon("/IMG/CartelInicial.png"));
			label = new JLabel();
		}
		return label;
	}
	private JPanel getPanelInicio() {
		if (panelInicio == null) {
			panelInicio = new JPanel();
			panelInicio.setLayout(new BorderLayout(0, 0));
			panelInicio.add(getPanel_3(), BorderLayout.SOUTH);
			panelInicio.add(getPanel_4());
		}
		return panelInicio;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(new BorderLayout(0, 0));
			panel_3.add(getLblAplicacinDeEntrega(), BorderLayout.CENTER);
			panel_3.add(getPanel_5(), BorderLayout.EAST);
		}
		return panel_3;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setLayout(new BorderLayout(0, 0));
			panel_4.add(getLabel(), BorderLayout.NORTH);
		}
		return panel_4;
	}
	private JPanel getPanel_5() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(0, 2, 4, 0));
			panel.add(getBtnIniciarSesin());
			panel.add(getBtnRegistrarse());
		}
		return panel;
	}
	private JPanel getPanelRegistro() {
		if (panelRegistro == null) {
			panelRegistro = new JPanel();
			panelRegistro.setLayout(new GridLayout(0, 3, 0, 0));
			panelRegistro.add(getLabel_1());
			panelRegistro.add(getPanel_1());
		}
		return panelRegistro;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridLayout(10, 0, 0, 0));
			panel_1.add(getLblRegistro());
			panel_1.add(getLabel_2());
			panel_1.add(getPanelNombre());
			panel_1.add(getPanel_2());
			panel_1.add(getPanel_5_1());
			panel_1.add(getPanel_6());
			panel_1.add(getPanel_7());
			panel_1.add(getPanel_8());
			panel_1.add(getLabel_3_1());
			panel_1.add(getPanel_9());
		}
		return panel_1;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("");
		}
		return label_1;
	}
	private JLabel getLblRegistro() {
		if (lblRegistro == null) {
			lblRegistro = new JLabel("Registro");
			lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
			lblRegistro.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		}
		return lblRegistro;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("");
		}
		return label_2;
	}
	private JPanel getPanelNombre() {
		if (panelNombre == null) {
			panelNombre = new JPanel();
			panelNombre.setLayout(null);
			panelNombre.add(getLblNombre());
			panelNombre.add(getTextField());
		}
		return panelNombre;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("DNI: ");
			lblNombre.setBounds(10, 15, 159, 22);
		}
		return lblNombre;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(89, 15, 220, 22);
			textField.setColumns(10);
		}
		return textField;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.add(getLblContrasea());
			panel_2.add(getTextField_1());
		}
		return panel_2;
	}
	private JLabel getLblContrasea() {
		if (lblContrasea == null) {
			lblContrasea = new JLabel("Contrase\u00F1a: ");
			lblContrasea.setBounds(10, 15, 159, 22);
		}
		return lblContrasea;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JPasswordField();
			textField_1.setColumns(10);
			textField_1.setBounds(89, 15, 220, 22);
		}
		return textField_1;
	}
	private JPanel getPanel_5_1() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setLayout(null);
			panel_5.add(getLabel_4());
			panel_5.add(getTextField_2());
		}
		return panel_5;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("Nombre: ");
			label_4.setBounds(10, 15, 159, 22);
		}
		return label_4;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(89, 15, 220, 22);
		}
		return textField_2;
	}
	private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.setLayout(null);
			panel_6.add(getLblApellidos());
			panel_6.add(getTextField_3());
		}
		return panel_6;
	}
	private JLabel getLblApellidos() {
		if (lblApellidos == null) {
			lblApellidos = new JLabel("Apellidos: ");
			lblApellidos.setBounds(10, 15, 159, 22);
		}
		return lblApellidos;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(89, 15, 220, 22);
		}
		return textField_3;
	}
	private JPanel getPanel_7() {
		if (panel_7 == null) {
			panel_7 = new JPanel();
			panel_7.setLayout(null);
			panel_7.add(getLblDireccin());
			panel_7.add(getTextField_4());
		}
		return panel_7;
	}
	private JLabel getLblDireccin() {
		if (lblDireccin == null) {
			lblDireccin = new JLabel("Direcci\u00F3n: ");
			lblDireccin.setBounds(10, 15, 159, 22);
		}
		return lblDireccin;
	}
	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(89, 15, 220, 22);
		}
		return textField_4;
	}
	private JPanel getPanel_8() {
		if (panel_8 == null) {
			panel_8 = new JPanel();
			panel_8.setLayout(null);
			panel_8.add(getLblProvincia());
			panel_8.add(getComboBox());
		}
		return panel_8;
	}
	private JLabel getLblProvincia() {
		if (lblProvincia == null) {
			lblProvincia = new JLabel("Provincia: ");
			lblProvincia.setBounds(10, 15, 159, 22);
		}
		return lblProvincia;
	}
	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<String>();
			comboBox.setBounds(89, 16, 220, 20);
			comboBox.addItem("Álava");
			comboBox.addItem("Albacete");
			comboBox.addItem("Alicante");
			comboBox.addItem("Almería");
			comboBox.addItem("Asturias");
			comboBox.addItem("Avila");
			comboBox.addItem("Badajoz");
			comboBox.addItem("Barcelona");
			comboBox.addItem("Burgos");
			comboBox.addItem("Cáceres");
			comboBox.addItem("Cádiz");
			comboBox.addItem("Cantabria");
			comboBox.addItem("Castellón");
			comboBox.addItem("Ciudad Real");
			comboBox.addItem("Córdoba");
			comboBox.addItem("Cuenca");
			comboBox.addItem("Gerona (Girona)");
			comboBox.addItem("Granada");
			comboBox.addItem("Guadalajara");
			comboBox.addItem("Guipúzcoa");
			comboBox.addItem("Huelva");
			comboBox.addItem("Huesca");
			comboBox.addItem("Islas Baleares");
			comboBox.addItem("Jaén");
			comboBox.addItem("La Coruña");
			comboBox.addItem("La Rioja");
			comboBox.addItem("Las Palmas");
			comboBox.addItem("León");
			comboBox.addItem("Lérida");
			comboBox.addItem("Lugo");
			comboBox.addItem("Madrid");
			comboBox.addItem("Málaga");
			comboBox.addItem("Murcia");
			comboBox.addItem("Navarra");
			comboBox.addItem("Orense");
			comboBox.addItem("Palencia");
			comboBox.addItem("Pontevedra");
			comboBox.addItem("Salamanca");
			comboBox.addItem("Segovia");
			comboBox.addItem("Sevilla");
			comboBox.addItem("Soria");
			comboBox.addItem("Tarragona");
			comboBox.addItem("Tenerife");
			comboBox.addItem("Teruel");
			comboBox.addItem("Toledo");
			comboBox.addItem("Valencia");
			comboBox.addItem("Valladolid");
			comboBox.addItem("Vizcaya");
			comboBox.addItem("Zamora");
			comboBox.addItem("Zaragoza");
		}
		return comboBox;
	}
	private JLabel getLabel_3_1() {
		if (label_3 == null) {
			label_3 = new JLabel("");
		}
		return label_3;
	}
	private JPanel getPanel_9() {
		if (panel_9 == null) {
			panel_9 = new JPanel();
			panel_9.setLayout(new GridLayout(0, 3, 0, 0));
			panel_9.add(getLabel_5());
			panel_9.add(getPanel_10());
			panel_9.add(getLabel_6());
		}
		return panel_9;
	}
	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("");
		}
		return label_5;
	}
	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("");
		}
		return label_6;
	}
	private JPanel getPanel_10() {
		if (panel_10 == null) {
			panel_10 = new JPanel();
			panel_10.add(getBtnRegistrarse_1());
		}
		return panel_10;
	}
	private JButton getBtnRegistrarse_1() {
		if (btnRegistrarse_1 == null) {
			btnRegistrarse_1 = new JButton("Registrarse");
			btnRegistrarse_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String dniUsuario = textField.getText();
					String contrasenna = textField_1.getText();
					String direccion = textField_4.getText();
					boolean capitalLetter = false;
					boolean minimalLetter = false;
					boolean number = false;
					for(char ch : contrasenna.toCharArray()) {
						if(Character.isUpperCase(ch)) {
							capitalLetter = true;
						}
						if(Character.isLowerCase(ch)) {
							minimalLetter = true;
						}
						if(Character.isDigit(ch)) {
							number = true;
						}
					}
					if(dniUsuario.length()!=9)  {
						JOptionPane.showMessageDialog(null,
								"La longitud del DNI debe ser de 9 caracteres.");
					}
					else if(Character.isLetter(dniUsuario.charAt(8))==false) {
						JOptionPane.showMessageDialog(null,
								"El DNI debe contener una letra.");
					}
					else if(contrasenna.length()<5) {
						JOptionPane.showMessageDialog(null,
								"La contraseña debe de tener longitud 5 o más.");
					}
					else if(!capitalLetter && !minimalLetter && !number) {
						JOptionPane.showMessageDialog(null,
								"La contraseña debe poseer como mínimo una letra mayúscula, minúscula y un número.");
					}
					else if(direccion.length()<2) {
						JOptionPane.showMessageDialog(null,
								"La dirección debe de ser válida.");
					}
					else {
						char letraMayuscula = (dniUsuario.substring(8).toUpperCase()).charAt(0);
						boolean letraFinal = false;
						int size = dniUsuario.length();
						int contador = 0;
						int contadorNumeros = 0;
						for(char ch : dniUsuario.toCharArray()) {
							contador++;
							if(size!=contador) {
								if(Character.isDigit(ch)) {
									contadorNumeros++;
								}
							}
							else {
								if(ch == letraMayuscula)
									letraFinal = true;
							}
						}
						System.out.println(contadorNumeros + " " + letraFinal);
						if(contadorNumeros!=8 && !letraFinal) {
							JOptionPane.showMessageDialog(null,
									"La estructura del DNI es incorrecta, deben ser 8 números y letra mayuscula al final.");
						}
						else {
							try {
								boolean yaExiste = DatabaseManager.existeClientePorDNI(dniUsuario);
								if(yaExiste) {
									JOptionPane.showMessageDialog(null,
											"Ya existe un usuario con ese DNI.");
								}
								else {
									DatabaseManager.registroCliente(dniUsuario, textField_2.getText(), textField_3.getText(), contrasenna, direccion, comboBox.getSelectedItem().toString());
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			});
		}
		return btnRegistrarse_1;
	}
	private JPanel getPanelLogin() {
		if (panelLogin == null) {
			panelLogin = new JPanel();
			panelLogin.setLayout(new GridLayout(0, 3, 0, 0));
			panelLogin.add(getLabel_7());
			panelLogin.add(getPanel_11());
		}
		return panelLogin;
	}
	private JPanel getPanel_11() {
		if (panel_11 == null) {
			panel_11 = new JPanel();
			panel_11.setLayout(new GridLayout(3, 0, 0, -400));
			panel_11.add(getLabel_8());
			panel_11.add(getPanel_12());
			panel_11.add(getPanel_13());
		}
		return panel_11;
	}
	private JLabel getLabel_7() {
		if (label_7 == null) {
			label_7 = new JLabel("");
		}
		return label_7;
	}
	private JLabel getLabel_8() {
		if (label_8 == null) {
			label_8 = new JLabel("");
		}
		return label_8;
	}
	private JPanel getPanel_12() {
		if (panel_12 == null) {
			panel_12 = new JPanel();
			panel_12.setLayout(new GridLayout(4, 0, 0, 0));
			panel_12.add(getLblInicioDeSesin());
			panel_12.add(getPanelLoginUser());
			panel_12.add(getPanelLoginPw());
			panel_12.add(getPanel_14());
		}
		return panel_12;
	}
	private JLabel getLblInicioDeSesin() {
		if (lblInicioDeSesin == null) {
			lblInicioDeSesin = new JLabel("Inicio de sesi\u00F3n:");
			lblInicioDeSesin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		}
		return lblInicioDeSesin;
	}
	private JPanel getPanelLoginUser() {
		if (panelLoginUser == null) {
			panelLoginUser = new JPanel();
			panelLoginUser.setLayout(null);
			panelLoginUser.add(getLblDni());
			panelLoginUser.add(getTextField_5());
		}
		return panelLoginUser;
	}
	private JLabel getLblDni() {
		if (lblDni == null) {
			lblDni = new JLabel("DNI:");
			lblDni.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
			lblDni.setBounds(10, 47, 68, 30);
		}
		return lblDni;
	}
	private JTextField getTextField_5() {
		if (textField_5 == null) {
			textField_5 = new JTextField();
			textField_5.setBounds(143, 47, 166, 30);
			textField_5.setColumns(10);
		}
		return textField_5;
	}
	private JPanel getPanel_13() {
		if (panel_13 == null) {
			panel_13 = new JPanel();
		}
		return panel_13;
	}
	private JPanel getPanelLoginPw() {
		if (panelLoginPw == null) {
			panelLoginPw = new JPanel();
			panelLoginPw.setLayout(null);
			panelLoginPw.add(getLblContrasea_1());
			panelLoginPw.add(getTextField_6());
		}
		return panelLoginPw;
	}
	private JLabel getLblContrasea_1() {
		if (lblContrasea_1 == null) {
			lblContrasea_1 = new JLabel("Contrase\u00F1a:");
			lblContrasea_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
			lblContrasea_1.setBounds(10, 38, 123, 36);
		}
		return lblContrasea_1;
	}
	private JTextField getTextField_6() {
		if (textField_6 == null) {
			textField_6 = new JTextField();
			textField_6.setBounds(143, 44, 166, 30);
			textField_6.setColumns(10);
		}
		return textField_6;
	}
	private JPanel getPanel_14() {
		if (panel_14 == null) {
			panel_14 = new JPanel();
			panel_14.setLayout(null);
			panel_14.add(getBtnEntrarLogin());
		}
		return panel_14;
	}
	private JButton getBtnEntrarLogin() {
		if (btnEntrarLogin == null) {
			btnEntrarLogin = new JButton("Entrar");
			btnEntrarLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Cliente c = DatabaseManager.checkLogin(textField_5.getText(), textField_6.getText());
						if(c==null) {
							JOptionPane.showMessageDialog(null,
									"El usuario no existe o es incorrecto.");
							textField_5.setText("");
							textField_6.setText("");
						}
						else {
							//abre el panel de inicio
						}
					} catch (SQLException e1) {

						e1.printStackTrace();
					}
				}
			});
			btnEntrarLogin.setBounds(106, 40, 106, 32);
		}
		return btnEntrarLogin;
	}
}
