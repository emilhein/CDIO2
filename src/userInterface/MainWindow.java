package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
//import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JTextPane;
import javax.swing.JList;
import java.awt.Scrollbar;
import java.awt.TextArea;
import javax.swing.JScrollPane;
import java.awt.Button;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import java.math.BigDecimal;

import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class MainWindow {

	private JFrame frame;
	private JTextField leftTextField;
	private JTextField bruttoField;
	private JTextField upperTextField;

	private double brutto = 0;
	private double tara = 0;

	public MainWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 445, 243);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		JButton btnTare = new JButton("Tare");
		
		// this field does not show the "real" weight on the physical weight
		bruttoField = new JTextField();
		bruttoField.setHorizontalAlignment(SwingConstants.RIGHT);
		bruttoField.setForeground(new Color(0, 0, 0));
		bruttoField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bruttoField.setEditable(false);
		bruttoField.setText("0.000");
		bruttoField.setColumns(10);
		
		JButton BruttoUp = new JButton("");
		BruttoUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {				
				
				
//				float brutto = Float.parseFloat(bruttoField.getText());
//				brutto = (float) (brutto + 0.1);
//				brutto = b
//				bruttoField.setText(brutto + "");
			}
		});
		BruttoUp.setIcon(new ImageIcon(MainWindow.class.getResource("/javax/swing/plaf/metal/icons/sortUp.png")));
		BruttoUp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton BruttoDown = new JButton("");
		BruttoDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				BigDecimal decimal = new BigDecimal(bruttoField.getText());
				bruttoField.setText("" + decimal.add(new BigDecimal(-0.1)));
//				float brutto = Float.parseFloat(bruttoField.getText());
//				brutto = (float) (brutto - 0.1);
//				bruttoField.setText(brutto + "");
			}
		});
		BruttoDown.setIcon(new ImageIcon(MainWindow.class.getResource("/javax/swing/plaf/metal/icons/sortDown.png")));
		
		JPanel panel_1 = new JPanel();
		
		JLabel bruttoLabel = new JLabel("Kg (bruttolast)");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(BruttoUp)
								.addComponent(BruttoDown))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bruttoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bruttoLabel)
							.addGap(60)
							.addComponent(btnTare))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(bruttoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnTare)
								.addComponent(bruttoLabel)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(BruttoUp)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(BruttoDown)))
					.addGap(22))
		);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		// has to follow the (bruttolast) field
		upperTextField = new JTextField();
		upperTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_upperTextField = new GridBagConstraints();
		gbc_upperTextField.gridwidth = 2;
		gbc_upperTextField.gridheight = 2;
		gbc_upperTextField.insets = new Insets(0, 0, 5, 5);
		gbc_upperTextField.fill = GridBagConstraints.BOTH;
		gbc_upperTextField.gridx = 0;
		gbc_upperTextField.gridy = 0;
		panel_1.add(upperTextField, gbc_upperTextField);
		upperTextField.setColumns(10);
		
		leftTextField = new JTextField();
		GridBagConstraints gbc_leftTextField = new GridBagConstraints();
		gbc_leftTextField.fill = GridBagConstraints.BOTH;
		gbc_leftTextField.insets = new Insets(0, 0, 0, 5);
		gbc_leftTextField.gridx = 0;
		gbc_leftTextField.gridy = 2;
		panel_1.add(leftTextField, gbc_leftTextField);
		leftTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		leftTextField.setColumns(10);
		
		JFormattedTextField rightTextField = new JFormattedTextField();
		GridBagConstraints gbc_rightTextField = new GridBagConstraints();
		gbc_rightTextField.fill = GridBagConstraints.BOTH;
		gbc_rightTextField.gridx = 1;
		gbc_rightTextField.gridy = 2;
		panel_1.add(rightTextField, gbc_rightTextField);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {59, 39, 59};
		gbl_panel.rowHeights = new int[] {23, 23, 23, 23};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				leftTextField.setText(leftTextField.getText() + "1");
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("2");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				leftTextField.setText(leftTextField.getText() + "2");
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 0;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton button = new JButton("3");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				leftTextField.setText(leftTextField.getText() + "3");
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.NORTH;
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 2;
		gbc_button.gridy = 0;
		panel.add(button, gbc_button);
		
		JButton button_1 = new JButton("4");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				leftTextField.setText(leftTextField.getText() + "4");
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.anchor = GridBagConstraints.NORTH;
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 0;
		gbc_button_1.gridy = 1;
		panel.add(button_1, gbc_button_1);
		
		JButton button_2 = new JButton("5");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				leftTextField.setText(leftTextField.getText() + "5");

			}
		});
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 1;
		gbc_button_2.gridy = 1;
		panel.add(button_2, gbc_button_2);
		
		JButton button_3 = new JButton("6");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				leftTextField.setText(leftTextField.getText() + "6");

			}
		});
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.anchor = GridBagConstraints.NORTH;
		gbc_button_3.insets = new Insets(0, 0, 5, 0);
		gbc_button_3.gridx = 2;
		gbc_button_3.gridy = 1;
		panel.add(button_3, gbc_button_3);
		
		JButton button_4 = new JButton("7");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				leftTextField.setText(leftTextField.getText() + "7");

			}
		});
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.anchor = GridBagConstraints.NORTH;
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 0;
		gbc_button_4.gridy = 2;
		panel.add(button_4, gbc_button_4);
		
		JButton button_5 = new JButton("8");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				leftTextField.setText(leftTextField.getText() + "8");

			}
		});
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.anchor = GridBagConstraints.NORTHWEST;
		gbc_button_5.insets = new Insets(0, 0, 5, 5);
		gbc_button_5.gridx = 1;
		gbc_button_5.gridy = 2;
		panel.add(button_5, gbc_button_5);
		
		JButton button_6 = new JButton("9");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				leftTextField.setText(leftTextField.getText() + "9");

			}
		});
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.anchor = GridBagConstraints.NORTH;
		gbc_button_6.insets = new Insets(0, 0, 5, 0);
		gbc_button_6.gridx = 2;
		gbc_button_6.gridy = 2;
		panel.add(button_6, gbc_button_6);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				leftTextField.setText("");
			}
		});
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnClear.insets = new Insets(0, 0, 5, 5);
		gbc_btnClear.gridx = 0;
		gbc_btnClear.gridy = 3;
		panel.add(btnClear, gbc_btnClear);
		
		JButton button_7 = new JButton("0");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				leftTextField.setText(leftTextField.getText() + "0");

			}
		});
		GridBagConstraints gbc_button_7 = new GridBagConstraints();
		gbc_button_7.anchor = GridBagConstraints.NORTHWEST;
		gbc_button_7.insets = new Insets(0, 0, 5, 5);
		gbc_button_7.gridx = 1;
		gbc_button_7.gridy = 3;
		panel.add(button_7, gbc_button_7);
		
		JButton btnEnter = new JButton("Enter");
		GridBagConstraints gbc_btnEnter = new GridBagConstraints();
		gbc_btnEnter.insets = new Insets(0, 0, 5, 0);
		gbc_btnEnter.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnEnter.gridx = 2;
		gbc_btnEnter.gridy = 3;
		panel.add(btnEnter, gbc_btnEnter);
		frame.getContentPane().setLayout(groupLayout);
	}

	public void show() {
		MainWindow window = new MainWindow();
		window.frame.setVisible(true);
	}
	
	public double getBrutto() {
		return brutto;
	}
	public void setBrutto(double brutto) {
		this.brutto = brutto;
	}
	public double getNetto() {
		return brutto - tara;
	}
	public void setNetto(double netto) {
		this.brutto = netto + tara;
	}
	public double getTara() {
		return tara;
	}
	public void setTara(double tara) {
		this.tara = tara;
	}
	public void display(String message) {
		//# TODO: Vis meddelse på displayet.
	}
	public void clearDisplay() {
		//# TODO: Fjern meddelsen fra displayet og vend tilbage til visning af netto vægt.
	}
	public String prompt(String firstMessage, String secondMessage, String thirdMessage) {
		return ""; //# TODO: Vis tre meddelser på displayet og retuner den indtastede værdi.
	}
	
}
