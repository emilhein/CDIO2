package userInterface;
import javax.swing.JFrame;
public class MainWindow {

	private JFrame frame;

	public MainWindow() {
		//frame = new JFrame();
		frame = new MainFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
