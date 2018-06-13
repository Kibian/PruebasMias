package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import src.Cliente;
import src.DatabaseManager;
import src.Envio;
import src.MyTableModel;
import src.Oficina;
import src.Transportista;
import src.Vehiculo;

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
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	
	private Cliente clienteActual;
	private List<Envio> enviosCreados;
	MyTableModel modelEnviosEnviados;
	private Transportista transportistaActual;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAplicacinDeEntrega;
	private JButton btnIniciarSesin;
	private JButton btnRegistrarse;
	private JLabel label;
	private JPanel panelInicioEntrada;
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
	private JLabel lblCampoNo;
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
	private JPanel panelInicioUser;
	private JPanel panel_15;
	private JLabel lblOpcionesDeUsuario;
	private JPanel panel_16;
	private JLabel label_10;
	private JButton btnCrearUnEnvo;
	private JPanel panel_17;
	private JLabel label_11;
	private JPanel panel_18;
	private JLabel label_12;
	private JPanel panel_19;
	private JLabel label_13;
	private JButton btnConsultarEnvos;
	private JPanel panel_20;
	private JLabel label_14;
	private JPanel panel_21;
	private JButton btnListaAlmacenes;
	private JPanel panel_22;
	private JLabel label_16;
	private JPanel panel_23;
	private JLabel label_17;
	private JButton btnDesconectar;
	private JPanel panel_24;
	private JPanel panel_25;
	private JLabel lblNewLabel;
	private JPanel panel_26;
	private JPanel panel_27;
	private JPanel panel_28;
	private JLabel lblBienvenido;
	private JLabel label_9;
	private JPanel panelCrearEnvío;
	private JLabel label_3;
	private JPanel panel_29;
	private JLabel lblCrearEnvo;
	private JLabel label_18;
	private JPanel panel_30;
	private JLabel lblDniReceptor;
	private JTextField textField_7;
	private JPanel panel_35;
	private JPanel panel_36;
	private JLabel label_26;
	private JPanel panel_37;
	private JButton btnConfirmar;
	private JLabel label_27;
	private JRadioButton rdbtnRecogidaADomicilio;
	private JRadioButton rdbtnEnvoADomicilio;
	private JPanel panelConsultaEnvios;
	private JPanel panelLista;
	private JPanel panelInfo;
	private JLabel label_15;
	private JLabel label_19;
	private JLabel label_20;
	private JLabel label_21;
	private JPanel panel_31;
	private JLabel lblListaDeEnvos;
	private JPanel panel_32;
	private JButton btnModificar;
	private JButton btnActualizar;
	private JTable table;
	private JLabel lblListado;
	private JPanel panel_33;
	private JRadioButton rdbtnADomicilio;
	private JRadioButton rdbtnEnAlmacnU;
	private JPanel panelInicioTransportista;

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
		contentPane.add(getPanelInicioEntrada(), "panelInicio");
		contentPane.add(getPanelRegistro(), "panelRegistro");
		contentPane.add(getPanelLogin(), "panelLogin");
		contentPane.add(getPanelInicioUser(), "panelInicioUser");
		contentPane.add(getPanelCrearEnvío(), "panelCrearEnvio");
		contentPane.add(getPanelConsultaEnvios(), "panelConsultaEnvios");
		contentPane.add(getPanelInicioTransportista(), "panelInicioTransportista");
	}
	private JLabel getLblAplicacinDeEntrega() {
		if (lblAplicacinDeEntrega == null) {
			lblAplicacinDeEntrega = new JLabel("Aplicaci\u00F3n de env\u00EDos");
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
	private JPanel getPanelInicioEntrada() {
		if (panelInicioEntrada == null) {
			panelInicioEntrada = new JPanel();
			panelInicioEntrada.setLayout(new BorderLayout(0, 0));
			panelInicioEntrada.add(getPanel_3(), BorderLayout.SOUTH);
			panelInicioEntrada.add(getPanel_4());
		}
		return panelInicioEntrada;
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
			lblApellidos = new JLabel("Apellidos(*): ");
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
			comboBox.addItem("Girona");
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
		if (lblCampoNo == null) {
			lblCampoNo = new JLabel("   (*): campo no obligatorio");
			lblCampoNo.setVerticalAlignment(SwingConstants.BOTTOM);
		}
		return lblCampoNo;
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
					else if(textField_2.getText().length()<1) {
						JOptionPane.showMessageDialog(null,
								"Debe introducir al menos el nombre.");
					}
					else if(Character.isLetter(dniUsuario.charAt(8))==false) {
						JOptionPane.showMessageDialog(null,
								"El DNI debe contener una letra al final.");
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
									
									clienteActual = DatabaseManager.checkLoginCliente(dniUsuario, contrasenna);
									
									CardLayout card = (CardLayout) contentPane.getLayout();
									card.show(contentPane, "panelInicioUser");
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
			textField_6 = new JPasswordField();
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
						clienteActual = DatabaseManager.checkLoginCliente(textField_5.getText(), textField_6.getText());
						transportistaActual = DatabaseManager.checkLoginTransportista(textField_5.getText(), textField_6.getText());
						if(clienteActual!=null) {
							//abre el panel de inicio
							CardLayout card = (CardLayout) contentPane.getLayout();
							card.show(contentPane, "panelInicioUser");
						}
						else if(transportistaActual!=null) {
							CardLayout card = (CardLayout) contentPane.getLayout();
							card.show(contentPane, "panelInicioTransportista");
						}
						else {
							JOptionPane.showMessageDialog(null,
									"El usuario no existe o es incorrecto.");
							textField_5.setText("");
							textField_6.setText("");
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
	private JPanel getPanelInicioUser() {
		if (panelInicioUser == null) {
			panelInicioUser = new JPanel();
			panelInicioUser.setLayout(new BorderLayout(0, 0));
			panelInicioUser.add(getPanel_15(), BorderLayout.EAST);
			panelInicioUser.add(getPanel_28(), BorderLayout.CENTER);
		}
		return panelInicioUser;
	}
	private JPanel getPanel_15() {
		if (panel_15 == null) {
			panel_15 = new JPanel();
			panel_15.setLayout(new GridLayout(7, 0, 0, 0));
			panel_15.add(getLblOpcionesDeUsuario());
			panel_15.add(getPanel_16());
			panel_15.add(getPanel_18());
			panel_15.add(getPanel_20());
			panel_15.add(getPanel_24());
			panel_15.add(getPanel_25());
			panel_15.add(getPanel_22());
		}
		return panel_15;
	}
	private JLabel getLblOpcionesDeUsuario() {
		if (lblOpcionesDeUsuario == null) {
			lblOpcionesDeUsuario = new JLabel("Opciones de usuario:                   ");
			lblOpcionesDeUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		}
		return lblOpcionesDeUsuario;
	}
	private JPanel getPanel_16() {
		if (panel_16 == null) {
			panel_16 = new JPanel();
			panel_16.setBackground(Color.WHITE);
			panel_16.setLayout(new GridLayout(3, 0, 0, 0));
			panel_16.add(getLabel_10());
			panel_16.add(getPanel_17());
		}
		return panel_16;
	}
	private JLabel getLabel_10() {
		if (label_10 == null) {
			label_10 = new JLabel("");
			label_10.setBackground(Color.WHITE);
		}
		return label_10;
	}
	private JButton getBtnCrearUnEnvo() {
		if (btnCrearUnEnvo == null) {
			btnCrearUnEnvo = new JButton("Crear un env\u00EDo");
			btnCrearUnEnvo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelLogin");
				}
			});
		}
		return btnCrearUnEnvo;
	}
	private JPanel getPanel_17() {
		if (panel_17 == null) {
			panel_17 = new JPanel();
			panel_17.setBackground(Color.WHITE);
			panel_17.setLayout(new GridLayout(0, 3, 0, 0));
			panel_17.add(getLabel_11());
			panel_17.add(getBtnCrearUnEnvo());
		}
		return panel_17;
	}
	private JLabel getLabel_11() {
		if (label_11 == null) {
			label_11 = new JLabel("");
			label_11.setForeground(Color.WHITE);
			label_11.setBackground(Color.WHITE);
		}
		return label_11;
	}
	private JPanel getPanel_18() {
		if (panel_18 == null) {
			panel_18 = new JPanel();
			panel_18.setBackground(Color.WHITE);
			panel_18.setLayout(new GridLayout(3, 0, 0, 0));
			panel_18.add(getLabel_12());
			panel_18.add(getPanel_19());
		}
		return panel_18;
	}
	private JLabel getLabel_12() {
		if (label_12 == null) {
			label_12 = new JLabel("");
			label_12.setBackground(Color.WHITE);
		}
		return label_12;
	}
	private JPanel getPanel_19() {
		if (panel_19 == null) {
			panel_19 = new JPanel();
			panel_19.setBackground(Color.WHITE);
			panel_19.setLayout(new GridLayout(0, 3, 0, 0));
			panel_19.add(getLabel_13());
			panel_19.add(getBtnConsultarEnvos());
		}
		return panel_19;
	}
	private JLabel getLabel_13() {
		if (label_13 == null) {
			label_13 = new JLabel("");
			label_13.setForeground(Color.WHITE);
			label_13.setBackground(Color.WHITE);
		}
		return label_13;
	}
	private JButton getBtnConsultarEnvos() {
		if (btnConsultarEnvos == null) {
			btnConsultarEnvos = new JButton("Consultar env\u00EDos");
			btnConsultarEnvos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelConsultaEnvios");
				}
			});
		}
		return btnConsultarEnvos;
	}
	private JPanel getPanel_20() {
		if (panel_20 == null) {
			panel_20 = new JPanel();
			panel_20.setBackground(Color.WHITE);
			panel_20.setLayout(new GridLayout(3, 0, 0, 0));
			panel_20.add(getLabel_14());
			panel_20.add(getPanel_21());
		}
		return panel_20;
	}
	private JLabel getLabel_14() {
		if (label_14 == null) {
			label_14 = new JLabel("");
			label_14.setBackground(Color.WHITE);
		}
		return label_14;
	}
	private JPanel getPanel_21() {
		if (panel_21 == null) {
			panel_21 = new JPanel();
			panel_21.setLayout(new GridLayout(0, 3, 0, 0));
			panel_21.add(getPanel_26());
			panel_21.add(getBtnListaAlmacenes());
			panel_21.add(getPanel_27());
		}
		return panel_21;
	}
	private JButton getBtnListaAlmacenes() {
		if (btnListaAlmacenes == null) {
			btnListaAlmacenes = new JButton("Lista almacenes");
		}
		return btnListaAlmacenes;
	}
	private JPanel getPanel_22() {
		if (panel_22 == null) {
			panel_22 = new JPanel();
			panel_22.setBackground(Color.WHITE);
			panel_22.setLayout(new GridLayout(3, 0, 0, 0));
			panel_22.add(getLabel_16());
			panel_22.add(getPanel_23());
		}
		return panel_22;
	}
	private JLabel getLabel_16() {
		if (label_16 == null) {
			label_16 = new JLabel("");
			label_16.setBackground(Color.WHITE);
		}
		return label_16;
	}
	private JPanel getPanel_23() {
		if (panel_23 == null) {
			panel_23 = new JPanel();
			panel_23.setBackground(Color.WHITE);
			panel_23.setLayout(new GridLayout(0, 3, 0, 0));
			panel_23.add(getLabel_17());
			panel_23.add(getLblNewLabel());
			panel_23.add(getBtnDesconectar());
		}
		return panel_23;
	}
	private JLabel getLabel_17() {
		if (label_17 == null) {
			label_17 = new JLabel("");
			label_17.setForeground(Color.WHITE);
			label_17.setBackground(Color.WHITE);
		}
		return label_17;
	}
	private JButton getBtnDesconectar() {
		if (btnDesconectar == null) {
			btnDesconectar = new JButton("Desconectar");
			btnDesconectar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelInicio");
					clienteActual = null;
				}
			});
		}
		return btnDesconectar;
	}
	private JPanel getPanel_24() {
		if (panel_24 == null) {
			panel_24 = new JPanel();
			panel_24.setBackground(Color.WHITE);
		}
		return panel_24;
	}
	private JPanel getPanel_25() {
		if (panel_25 == null) {
			panel_25 = new JPanel();
			panel_25.setBackground(Color.WHITE);
		}
		return panel_25;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
		}
		return lblNewLabel;
	}
	private JPanel getPanel_26() {
		if (panel_26 == null) {
			panel_26 = new JPanel();
			panel_26.setBackground(Color.WHITE);
		}
		return panel_26;
	}
	private JPanel getPanel_27() {
		if (panel_27 == null) {
			panel_27 = new JPanel();
			panel_27.setBackground(Color.WHITE);
		}
		return panel_27;
	}
	private JPanel getPanel_28() {
		if (panel_28 == null) {
			panel_28 = new JPanel();
			panel_28.setLayout(new BorderLayout(0, 0));
			panel_28.add(getLabel_9_1(), BorderLayout.NORTH);
			panel_28.add(getLabel_9_2(), BorderLayout.CENTER);
		}
		return panel_28;
	}
	private JLabel getLabel_9_1() {
		if (lblBienvenido == null) {
			if(clienteActual != null) {
				lblBienvenido = new JLabel("Bienvenido " + clienteActual.getNombre());
			}
			else {
				lblBienvenido = new JLabel("Bienvenido");
			}
			lblBienvenido.setFont(new Font("Tahoma", Font.ITALIC, 18));
		}
		return lblBienvenido;
	}
	private JLabel getLabel_9_2() {
		if (label_9 == null) {
			label_9 = new JLabel("");
		}
		return label_9;
	}
	private JPanel getPanelCrearEnvío() {
		if (panelCrearEnvío == null) {
			panelCrearEnvío = new JPanel();
			panelCrearEnvío.setLayout(new GridLayout(0, 3, 0, 0));
			panelCrearEnvío.add(getLabel_3());
			panelCrearEnvío.add(getPanel_29());
		}
		return panelCrearEnvío;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("");
		}
		return label_3;
	}
	private JPanel getPanel_29() {
		if (panel_29 == null) {
			panel_29 = new JPanel();
			panel_29.setLayout(new GridLayout(10, 0, 0, 0));
			panel_29.add(getLblCrearEnvo());
			panel_29.add(getLabel_18());
			panel_29.add(getPanel_30());
			panel_29.add(getPanel_35());
			panel_29.add(getPanel_36());
		}
		return panel_29;
	}
	private JLabel getLblCrearEnvo() {
		if (lblCrearEnvo == null) {
			lblCrearEnvo = new JLabel("Crear env\u00EDo");
			lblCrearEnvo.setHorizontalAlignment(SwingConstants.CENTER);
			lblCrearEnvo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		}
		return lblCrearEnvo;
	}
	private JLabel getLabel_18() {
		if (label_18 == null) {
			label_18 = new JLabel("");
		}
		return label_18;
	}
	private JPanel getPanel_30() {
		if (panel_30 == null) {
			panel_30 = new JPanel();
			panel_30.setLayout(null);
			panel_30.add(getLblDniReceptor());
			panel_30.add(getTextField_7());
		}
		return panel_30;
	}
	private JLabel getLblDniReceptor() {
		if (lblDniReceptor == null) {
			lblDniReceptor = new JLabel("DNI destinatario: ");
			lblDniReceptor.setBounds(10, 15, 159, 22);
		}
		return lblDniReceptor;
	}
	private JTextField getTextField_7() {
		if (textField_7 == null) {
			textField_7 = new JTextField();
			textField_7.setColumns(10);
			textField_7.setBounds(106, 15, 203, 22);
		}
		return textField_7;
	}
	private JPanel getPanel_35() {
		if (panel_35 == null) {
			panel_35 = new JPanel();
			panel_35.setLayout(null);
			panel_35.add(getRdbtnRecogidaADomicilio());
			panel_35.add(getRdbtnEnvoADomicilio());
		}
		return panel_35;
	}
	private JPanel getPanel_36() {
		if (panel_36 == null) {
			panel_36 = new JPanel();
			panel_36.setLayout(new GridLayout(0, 3, 0, 0));
			panel_36.add(getLabel_26());
			panel_36.add(getPanel_37());
			panel_36.add(getLabel_27());
		}
		return panel_36;
	}
	private JLabel getLabel_26() {
		if (label_26 == null) {
			label_26 = new JLabel("");
		}
		return label_26;
	}
	private JPanel getPanel_37() {
		if (panel_37 == null) {
			panel_37 = new JPanel();
			panel_37.add(getBtnConfirmar());
		}
		return panel_37;
	}
	private JButton getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String dniIntroducido = textField_7.getText();
					try {
						boolean existe = DatabaseManager.existeClientePorDNI(dniIntroducido);
						if(!existe) {
							JOptionPane.showMessageDialog(null,
									"El destinatario no existe o es incorrecto.");
						}
						else {
							Cliente receptor = DatabaseManager.getCliente(dniIntroducido);
							//QUEDA ASIGNAR AL TRANSPORTISTA Y VEHICULO, Y PONER EL LUGAR DE ENVIO (OFICINA O DOMICILIO DEPENDE DEL RADIOBUTTON) 
							Envio envio = null;
							List<Transportista> t = DatabaseManager.getTransportistas();
							List<Vehiculo> v = DatabaseManager.getVehiculos();
							int posRandomDos = ThreadLocalRandom.current().nextInt(0, t.size());
							Transportista trans = t.get(posRandomDos);
							int posRandomTres = ThreadLocalRandom.current().nextInt(0, v.size());
							Vehiculo veh = v.get(posRandomTres);
							if(rdbtnEnvoADomicilio.isSelected()) {
								envio = new Envio(rdbtnRecogidaADomicilio.isSelected(), rdbtnEnvoADomicilio.isSelected(), dniIntroducido, clienteActual.getDni(),
										trans.getDNI(), veh.getMatricula(), receptor.getProvincia(), clienteActual.getProvincia(), receptor.getDireccion(), "ESPERA-ENVIO");
								envio.calculaPrecio();
								DatabaseManager.registraEnvio(envio);
							}
							
							else {
								List<Oficina> x = DatabaseManager.getOficinasByProvincia(receptor.getProvincia());
								int posRandom = ThreadLocalRandom.current().nextInt(0, x.size());
								Oficina oficinaSeleccionada = x.get(posRandom);
								envio = new Envio(rdbtnRecogidaADomicilio.isSelected(), rdbtnEnvoADomicilio.isSelected(), dniIntroducido, clienteActual.getDni(),
										trans.getDNI(), veh.getMatricula(), receptor.getProvincia(), clienteActual.getProvincia(), "Oficina-"+oficinaSeleccionada.getNombre()+"-"+
												oficinaSeleccionada.getProvinciaLocalizacion(), "ESPERA-ENVIO");
								envio.calculaPrecio();
								DatabaseManager.registraEnvio(envio);
							}
							JOptionPane.showMessageDialog(null,
									"Se ha creado el envío correctamente.");
							CardLayout card = (CardLayout) contentPane.getLayout();
							card.show(contentPane, "panelInicioUser");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return btnConfirmar;
	}
	private JLabel getLabel_27() {
		if (label_27 == null) {
			label_27 = new JLabel("");
		}
		return label_27;
	}
	private JRadioButton getRdbtnRecogidaADomicilio() {
		if (rdbtnRecogidaADomicilio == null) {
			rdbtnRecogidaADomicilio = new JRadioButton("Recogida a domicilio");
			rdbtnRecogidaADomicilio.setFont(new Font("Tahoma", Font.BOLD, 11));
			rdbtnRecogidaADomicilio.setBounds(6, 7, 148, 17);
		}
		return rdbtnRecogidaADomicilio;
	}
	private JRadioButton getRdbtnEnvoADomicilio() {
		if (rdbtnEnvoADomicilio == null) {
			rdbtnEnvoADomicilio = new JRadioButton("Env\u00EDo a domicilio");
			rdbtnEnvoADomicilio.setFont(new Font("Tahoma", Font.BOLD, 11));
			rdbtnEnvoADomicilio.setBounds(6, 29, 148, 17);
		}
		return rdbtnEnvoADomicilio;
	}
	private JPanel getPanelConsultaEnvios() {
		if (panelConsultaEnvios == null) {
			panelConsultaEnvios = new JPanel();
			panelConsultaEnvios.setLayout(new BorderLayout(0, 0));
			panelConsultaEnvios.add(getPanelLista(), BorderLayout.CENTER);
			panelConsultaEnvios.add(getPanelInfo(), BorderLayout.EAST);
		}
		return panelConsultaEnvios;
	}
	private JPanel getPanelLista() {
		if (panelLista == null) {
			panelLista = new JPanel();
			panelLista.setLayout(new BorderLayout(0, 0));
			panelLista.add(getTable());
			panelLista.add(getLblListado(), BorderLayout.NORTH);
		}
		return panelLista;
	}
	private JPanel getPanelInfo() {
		if (panelInfo == null) {
			panelInfo = new JPanel();
			panelInfo.setLayout(new GridLayout(9, 0, 0, 0));
			panelInfo.add(getLabel_15());
			panelInfo.add(getLabel_19());
			panelInfo.add(getLabel_20());
			panelInfo.add(getLabel_21());
			panelInfo.add(getPanel_31());
			panelInfo.add(getPanel_33());
		}
		return panelInfo;
	}
	private JLabel getLabel_15() {
		if (label_15 == null) {
			label_15 = new JLabel("");
		}
		return label_15;
	}
	private JPanel getPanel_31() {
		if (panel_31 == null) {
			panel_31 = new JPanel();
			panel_31.setLayout(new GridLayout(2, 0, 0, 0));
			panel_31.add(getLblListaDeEnvos());
			panel_31.add(getPanel_32());
		}
		return panel_31;
	}
	private JLabel getLblListaDeEnvos() {
		if (lblListaDeEnvos == null) {
			lblListaDeEnvos = new JLabel("Lista de env\u00EDos creados");
			lblListaDeEnvos.setHorizontalAlignment(SwingConstants.CENTER);
			lblListaDeEnvos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		}
		return lblListaDeEnvos;
	}
	private JPanel getPanel_32() {
		if (panel_32 == null) {
			panel_32 = new JPanel();
			panel_32.setLayout(new GridLayout(0, 2, 0, 0));
			panel_32.add(getBtnModificar());
			panel_32.add(getBtnActualizar());
		}
		return panel_32;
	}
	private JLabel getLabel_19() {
		if (label_19 == null) {
			label_19 = new JLabel("");
		}
		return label_19;
	}
	private JLabel getLabel_20() {
		if (label_20 == null) {
			label_20 = new JLabel("");
		}
		return label_20;
	}
	private JLabel getLabel_21() {
		if (label_21 == null) {
			label_21 = new JLabel("");
		}
		return label_21;
	}
	private JButton getBtnActualizar() {
		if (btnActualizar == null) {
			btnActualizar = new JButton("Actualizar");
			btnActualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						actualizarModel();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return btnActualizar;
	}
	private JButton getBtnModificar() {
		if (btnModificar == null) {
			btnModificar = new JButton("Modificar direcci\u00F3n entrega");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int x = table.getSelectedRow();
					if(x==-1) {
						JOptionPane.showMessageDialog(null,
								"Ha de seleccionar uno de los envíos de la tabla.");
					}
					else {
						if(!rdbtnADomicilio.isSelected() && !rdbtnEnAlmacnU.isSelected()) {
							JOptionPane.showMessageDialog(null,
									"Debe seleccionar el tipo de modificación de entrega.");
						}
						else {
							try {
								String dniReceptor = (String) modelEnviosEnviados.getValueAt(x, 3);
								Cliente cReceptor= DatabaseManager.getCliente(dniReceptor);
								if(rdbtnADomicilio.isSelected()) {		
									//MODIFICA ENTREGA DEL ENVIO
									DatabaseManager.modifyEnvioById("Si", cReceptor.getDireccion(), (Integer) modelEnviosEnviados.getValueAt(x, 1));
									//MODIFICA EL PRECIO
									Envio en = DatabaseManager.getEnvioById((Integer) modelEnviosEnviados.getValueAt(x, 1));
									Double precioNuevo = en.calculaPrecio();
									DatabaseManager.updatePrecioEnvio((Integer) modelEnviosEnviados.getValueAt(x, 1), precioNuevo);
								}
								else {
									List<Oficina> lista = DatabaseManager.getOficinasByProvincia(cReceptor.getProvincia());
									if(lista.size()==0) {
										JOptionPane.showMessageDialog(null,
												"No existen oficinas en la provincia del receptor.");
									}
									else {
										//MODIFICA ENTREGA DEL ENVIO
										int posRandom = ThreadLocalRandom.current().nextInt(0, lista.size());
										Oficina oficinaSeleccionada = lista.get(posRandom);
										DatabaseManager.modifyEnvioById("No", "Oficina-"+oficinaSeleccionada.getNombre()+"-"+
										oficinaSeleccionada.getProvinciaLocalizacion(), (Integer) modelEnviosEnviados.getValueAt(x, 1));
										//MODIFICA EL PRECIO
										Envio en = DatabaseManager.getEnvioById((Integer) modelEnviosEnviados.getValueAt(x, 1));
										Double precioNuevo = en.calculaPrecio();
										DatabaseManager.updatePrecioEnvio((Integer) modelEnviosEnviados.getValueAt(x, 1), precioNuevo);
									}
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
			});
		}
		return btnModificar;
	}
	private JTable getTable() {
		if (table == null) {
			modelEnviosEnviados = new MyTableModel();
			modelEnviosEnviados.addColumn("Id");
			modelEnviosEnviados.addColumn("Destino");
			modelEnviosEnviados.addColumn("Receptor");
			modelEnviosEnviados.addColumn("Estado");
			modelEnviosEnviados.addColumn("Precio");
			String[] x = {"Id", "Destino", "DNI Receptor", "Estado", "Precio"};
			modelEnviosEnviados.addRow(x);
			table = new JTable(modelEnviosEnviados);
		}
		return table;
	}
	
	private void addToModel(MyTableModel model, List<String[]> datos) {
		for (String[] dato : datos) {
			model.addRow(dato);
		}
	}

	private void removeModelContent(MyTableModel model) {
		if (model.getRowCount() > 0)
			for (int i = model.getRowCount() - 1; i >= 0; i--)
				model.removeRow(i);
	}
	
	private void actualizarModel() throws SQLException {
		removeModelContent(modelEnviosEnviados);
		String[] x = {"Id", "Destino", "DNI Receptor", "Estado", "Precio"};
		modelEnviosEnviados.addRow(x);
		addToModel(modelEnviosEnviados, DatabaseManager.getEnviosEmisor(clienteActual.getDni()));
	}
	
	private JLabel getLblListado() {
		if (lblListado == null) {
			lblListado = new JLabel("Listado:");
			lblListado.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		}
		return lblListado;
	}
	private JPanel getPanel_33() {
		if (panel_33 == null) {
			panel_33 = new JPanel();
			panel_33.setLayout(new GridLayout(2, 0, 0, 0));
			panel_33.add(getRdbtnADomicilio());
			panel_33.add(getRdbtnEnAlmacnU());
		}
		return panel_33;
	}
	private JRadioButton getRdbtnADomicilio() {
		if (rdbtnADomicilio == null) {
			rdbtnADomicilio = new JRadioButton("A domicilio");
			rdbtnADomicilio.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(rdbtnADomicilio.isSelected()) {
						rdbtnEnAlmacnU.setSelected(false);
					}
				}
			});
		}
		return rdbtnADomicilio;
	}
	private JRadioButton getRdbtnEnAlmacnU() {
		if (rdbtnEnAlmacnU == null) {
			rdbtnEnAlmacnU = new JRadioButton("En almac\u00E9n u oficina");
			rdbtnEnAlmacnU.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(rdbtnEnAlmacnU.isSelected()) {
						rdbtnADomicilio.setSelected(false);
					}
				}
			});
		}
		return rdbtnEnAlmacnU;
	}
	private JPanel getPanelInicioTransportista() {
		if (panelInicioTransportista == null) {
			panelInicioTransportista = new JPanel();
		}
		return panelInicioTransportista;
	}
}
