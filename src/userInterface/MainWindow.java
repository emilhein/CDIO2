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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;
	private JTextField leftTextField;
	private JTextField bruttoField;
	private JTextField upperTextField;

	private double tara = 0;
	private double netto = 0.000;
	private double brutto = getTara() + getNetto();
	private String command = "";
	

	public MainWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 445, 243);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		JButton btnTare = new JButton("Tara");
		btnTare.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setTara(getBrutto());
				setNetto(0);
				upperTextField.setText(getNetto() + " Kg");
			}
		});
		
		// this field does not show the "real" weight on the physical weight
		bruttoField = new JTextField();
		bruttoField.setHorizontalAlignment(SwingConstants.RIGHT);
		bruttoField.setForeground(new Color(0, 0, 0));
		bruttoField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bruttoField.setEditable(false);
		bruttoField.setText("" + getBrutto());
		bruttoField.setColumns(10);
		
		JButton BruttoUp = new JButton("");
		BruttoUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		BruttoUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {				
				setNetto(getNetto() +1);
				bruttoField.setText("" + getBrutto());
				upperTextField.setText(getNetto() + " Kg");
			}
		});
		BruttoUp.setIcon(new ImageIcon(MainWindow.class.getResource("/javax/swing/plaf/metal/icons/sortUp.png")));
		BruttoUp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton BruttoDown = new JButton("");
		BruttoDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setNetto(getNetto() -1);
				bruttoField.setText("" + getBrutto());
				upperTextField.setText(getNetto() + " Kg");
			}
		});
		BruttoDown.setIcon(new ImageIcon(MainWindow.class.getResource("/javax/swing/plaf/metal/icons/sortDown.png")));
		
		JPanel panel_1 = new JPanel();
		
		JLabel bruttoLabel = new JLabel("Kg Bruttov\u00E6gt");
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
		upperTextField.setEditable(false);
		upperTextField.setText(getNetto() + " Kg");
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
		leftTextField.setEditable(false);
		GridBagConstraints gbc_leftTextField = new GridBagConstraints();
		gbc_leftTextField.fill = GridBagConstraints.BOTH;
		gbc_leftTextField.insets = new Insets(0, 0, 0, 5);
		gbc_leftTextField.gridx = 0;
		gbc_leftTextField.gridy = 2;
		panel_1.add(leftTextField, gbc_leftTextField);
		leftTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leftTextField.setColumns(10);
		
		final JTextField rightTextField = new JTextField();
		rightTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		rightTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
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

// ===========================
// buttons begin
// ===========================
		
		JButton numButton1 = new JButton("1");
		numButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				rightTextField.setText(rightTextField.getText() + "1");
			}
		});
		GridBagConstraints gbc_numButton1 = new GridBagConstraints();
		gbc_numButton1.anchor = GridBagConstraints.NORTH;
		gbc_numButton1.insets = new Insets(0, 0, 5, 5);
		gbc_numButton1.gridx = 0;
		gbc_numButton1.gridy = 0;
		panel.add(numButton1, gbc_numButton1);
		
		JButton numButton2 = new JButton("2");
		numButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				rightTextField.setText(rightTextField.getText() + "2");
			}
		});
		GridBagConstraints gbc_numButton2 = new GridBagConstraints();
		gbc_numButton2.anchor = GridBagConstraints.NORTHWEST;
		gbc_numButton2.insets = new Insets(0, 0, 5, 5);
		gbc_numButton2.gridx = 1;
		gbc_numButton2.gridy = 0;
		panel.add(numButton2, gbc_numButton2);
		
		JButton numButton3 = new JButton("3");
		numButton3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				rightTextField.setText(rightTextField.getText() + "3");
			}
		});
		GridBagConstraints gbc_numButton3 = new GridBagConstraints();
		gbc_numButton3.anchor = GridBagConstraints.NORTH;
		gbc_numButton3.insets = new Insets(0, 0, 5, 0);
		gbc_numButton3.gridx = 2;
		gbc_numButton3.gridy = 0;
		panel.add(numButton3, gbc_numButton3);
		
		JButton numButton4 = new JButton("4");
		numButton4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				rightTextField.setText(rightTextField.getText() + "4");
			}
		});
		GridBagConstraints gbc_numButton4 = new GridBagConstraints();
		gbc_numButton4.anchor = GridBagConstraints.NORTH;
		gbc_numButton4.insets = new Insets(0, 0, 5, 5);
		gbc_numButton4.gridx = 0;
		gbc_numButton4.gridy = 1;
		panel.add(numButton4, gbc_numButton4);
		
		JButton numButton5 = new JButton("5");
		numButton5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				rightTextField.setText(rightTextField.getText() + "5");

			}
		});
		GridBagConstraints gbc_numButton5 = new GridBagConstraints();
		gbc_numButton5.anchor = GridBagConstraints.NORTHWEST;
		gbc_numButton5.insets = new Insets(0, 0, 5, 5);
		gbc_numButton5.gridx = 1;
		gbc_numButton5.gridy = 1;
		panel.add(numButton5, gbc_numButton5);
		
		JButton numButton6 = new JButton("6");
		numButton6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				rightTextField.setText(rightTextField.getText() + "6");

			}
		});
		GridBagConstraints gbc_numButton6 = new GridBagConstraints();
		gbc_numButton6.anchor = GridBagConstraints.NORTH;
		gbc_numButton6.insets = new Insets(0, 0, 5, 0);
		gbc_numButton6.gridx = 2;
		gbc_numButton6.gridy = 1;
		panel.add(numButton6, gbc_numButton6);
		
		JButton numButton7 = new JButton("7");
		numButton7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				rightTextField.setText(rightTextField.getText() + "7");

			}
		});
		GridBagConstraints gbc_numButton7 = new GridBagConstraints();
		gbc_numButton7.anchor = GridBagConstraints.NORTH;
		gbc_numButton7.insets = new Insets(0, 0, 5, 5);
		gbc_numButton7.gridx = 0;
		gbc_numButton7.gridy = 2;
		panel.add(numButton7, gbc_numButton7);
		
		JButton numButton8 = new JButton("8");
		numButton8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				rightTextField.setText(rightTextField.getText() + "8");

			}
		});
		GridBagConstraints gbc_numButton8 = new GridBagConstraints();
		gbc_numButton8.anchor = GridBagConstraints.NORTHWEST;
		gbc_numButton8.insets = new Insets(0, 0, 5, 5);
		gbc_numButton8.gridx = 1;
		gbc_numButton8.gridy = 2;
		panel.add(numButton8, gbc_numButton8);
		
		JButton numButton9 = new JButton("9");
		numButton9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				rightTextField.setText(rightTextField.getText() + "9");

			}
		});
		GridBagConstraints gbc_numButton9 = new GridBagConstraints();
		gbc_numButton9.anchor = GridBagConstraints.NORTH;
		gbc_numButton9.insets = new Insets(0, 0, 5, 0);
		gbc_numButton9.gridx = 2;
		gbc_numButton9.gridy = 2;
		panel.add(numButton9, gbc_numButton9);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setBrutto(0);
				setTara(0);
				setNetto(0);
				upperTextField.setText(getNetto() + " Kg");
				leftTextField.setText("");
				rightTextField.setText("");
				bruttoField.setText("" + getBrutto());
				
			}
		});
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnClear.insets = new Insets(0, 0, 5, 5);
		gbc_btnClear.gridx = 0;
		gbc_btnClear.gridy = 3;
		panel.add(btnClear, gbc_btnClear);
		
		JButton numButton0 = new JButton("0");
		numButton0.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				rightTextField.setText(rightTextField.getText() + "0");

			}
		});
		GridBagConstraints gbc_numButton0 = new GridBagConstraints();
		gbc_numButton0.anchor = GridBagConstraints.NORTHWEST;
		gbc_numButton0.insets = new Insets(0, 0, 5, 5);
		gbc_numButton0.gridx = 1;
		gbc_numButton0.gridy = 3;
		panel.add(numButton0, gbc_numButton0);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setCommand(rightTextField.getText());
				leftTextField.setText(getCommand());
				rightTextField.setText("");
			}
		});
		GridBagConstraints gbc_btnEnter = new GridBagConstraints();
		gbc_btnEnter.insets = new Insets(0, 0, 5, 0);
		gbc_btnEnter.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnEnter.gridx = 2;
		gbc_btnEnter.gridy = 3;
		panel.add(btnEnter, gbc_btnEnter);
		frame.getContentPane().setLayout(groupLayout);
	}
	
// ==========================
// buttons end
// ==========================

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
		this.netto = netto;
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
		leftTextField.setText(message);
	}
	public void clearDisplay() {
		//# TODO: Fjern meddelsen fra displayet og vend tilbage til visning af netto vægt.
		leftTextField.setText("");
	}
	public String getCommand(){
		return command;
	}
	public void setCommand(String command){
		this.command = command;
	}
	public String prompt(String firstMessage, String secondMessage, String thirdMessage) {
		leftTextField.setText(firstMessage + " " + secondMessage + " " + thirdMessage);
		return getCommand(); //# TODO: Vis tre meddelser på displayet og retuner den indtastede værdi.
	}
	
}
