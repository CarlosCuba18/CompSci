import javax.swing.*;
import java.awt.*;

public class TwoDGraphics extends JFrame{
	TwoDPanel panel;
	
	TwoDGraphics(){
		panel = new TwoDPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.pack();
	}

	/*
	public void paint(Graphics g){ //called automatically when component is created ie: JFrame
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawLine(0,0,600,600); //(startX,StartY,endX,endY)
	}
	*/
}//end of class