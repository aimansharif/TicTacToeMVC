import java.awt.GridLayout;
import java.awt.MenuBar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class TTTView extends JFrame implements TTTListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TTTModel model;
	private JPanel panel;
	private GridLayout gridLayout;
	private JButton button;
	private static final int SIZE = 3;
	private JButton [][] buttonArray;
	private JMenuBar menuBar;
	private JMenu menu;
	
	public TTTView() {
		super("TicTacToe");
		model = new TTTModel(this);
		model.addTTTListener(this);
		
		panel = new JPanel();
		buttonArray = new JButton[SIZE][SIZE];
		gridLayout = new GridLayout(SIZE, SIZE);
		menuBar = new JMenuBar();
		menu = new JMenu("Reset");
		
		panel.setLayout(gridLayout);
		menuBar.add(menu);
		
		for (int i = 0; i < buttonArray.length; i++) {
			for (int j = 0; j < buttonArray.length; j++) {
				button = new JButton();
				buttonArray[i][j] = button;
				TTTController buttonController = new TTTController(model, this, i, j);
				buttonArray[i][j].addActionListener(buttonController);
				panel.add(buttonArray[i][j]);
			}
		}
		
		this.add(menuBar);
		menuBar.setVisible(true);
		this.setJMenuBar(menuBar);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	public String getButtonText() {
		return this.button.getText();
	}
	
	@Override
	public void handleTTTEvent(TTTEvent e) {
		if (e.isPlayer1()) {
			buttonArray[e.getX()][e.getY()].setText("X");
		}
		else {
			buttonArray[e.getX()][e.getY()].setText("O");
		}
		
		if(e.getStatus().equals(TTTEnum.X_WON) || e.getStatus().equals(TTTEnum.O_WON)) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					buttonArray[i][j].setEnabled(false);
				}
			}
		}
	}
	
	public void setButtonText(String text) {
		button.setText(text);
	}
	
	public static void main(String args[]) {
		TTTView view = new TTTView();
		
	}
}
