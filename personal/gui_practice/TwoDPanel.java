import javax.swing.*;
import java.awt.*;

public class TwoDPanel extends JPanel{

	TwoDPanel(){
		this.setPreferredSize(new Dimension(600,600));
	}
	public void paint(Graphics g){ //called automatically when component is created ie: JFrame
		Graphics2D g2D = (Graphics2D) g;

		g2D.setPaint(Color.blue);
		g2D.setStroke(new BasicStroke(5));
		g2D.drawLine(0,0,600,600); //(startX,StartY,endX,endY)

		g2D.setPaint(Color.pink);
		g2D.drawRect(0,0,100,200); //(x,y,width,height)
		g2D.fillRect(0,0,100,200);
		//newer additons cover up older ones, like how here line is below rectange

	}
}//end of class