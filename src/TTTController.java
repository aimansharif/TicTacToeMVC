import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TTTController implements ActionListener{
	private TTTModel model;
	private TTTView view;
	private int x;
	private int y;
	
	public TTTController(TTTModel model, TTTView view, int x, int y) {
		this.model = model;
		this.view = view;
		this.x = x;
		this.y = y;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		model.takeTurn(x, y);
		
		System.out.println("Button pressed");
	}
}
