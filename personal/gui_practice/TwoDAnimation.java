import java.awt.*;
import javax.swing.*;

public class TwoDAnimation extends JFrame{

	TwoDAnimationPanel panel;
	TwoDAnimation(){
		panel = new TwoDAnimationPanel();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}