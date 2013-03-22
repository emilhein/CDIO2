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

public class MainWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextField txtKg;
	private JTextField txtbruttoLast;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 445, 243);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		JButton btnTare = new JButton("Tare");
		
		// this field does not show the "real" weight on the physical weight
		txtKg = new JTextField();
		txtKg.setText("0.000 Kg");
		txtKg.setColumns(10);
		
		txtbruttoLast = new JTextField();
		txtbruttoLast.setText("(Brutto last)");
		txtbruttoLast.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(MainWindow.class.getResource("/javax/swing/plaf/metal/icons/sortUp.png")));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(MainWindow.class.getResource("/javax/swing/plaf/metal/icons/sortDown.png")));
		
		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_2)
								.addComponent(btnNewButton_3))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtKg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtbruttoLast, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnTare)
							.addGap(122))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
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
								.addComponent(txtKg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtbruttoLast, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnTare)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(btnNewButton_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_3)))
					.addGap(22))
		);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridheight = 2;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 0;
		gbc_textField_2.gridy = 0;
		panel_1.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 2;
		panel_1.add(textField, gbc_textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
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
				textField.setText(textField.getText() + "1");
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
				textField.setText(textField.getText() + "2");
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
				textField.setText(textField.getText() + "3");
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
				textField.setText(textField.getText() + "4");
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
				textField.setText(textField.getText() + "5");

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
				textField.setText(textField.getText() + "6");

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
				textField.setText(textField.getText() + "7");

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
				textField.setText(textField.getText() + "8");

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
				textField.setText(textField.getText() + "9");

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
				textField.setText("");
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
				textField.setText(textField.getText() + "0");

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
}
