import javax.swing.*;
import java.awt.*;

public class TwoDPanel extends JPanel{

	Image image;
	TwoDPanel(){
		this.setPreferredSize(new Dimension(600,600));
	}
	public void paint(Graphics g){ //called automatically when component is created ie: JFrame
		Graphics2D g2D = (Graphics2D) g;
		image = new ImageIcon("croc.png").getImage();
		g2D.drawImage(image,100,100,null); //(image, x,y, image observer)

		g2D.setPaint(Color.blue);
		//g2D.setStroke(new BasicStroke(5));
		/*
		g2D.drawLine(0,0,600,600); //(startX,StartY,endX,endY)

		g2D.setPaint(Color.pink);
		g2D.drawRect(0,0,100,200); //(x,y,width,height)
		g2D.fillRect(0,0,100,200);
		//newer additons cover up older ones, like how here line is below rectange
		
		g2D.drawOval(0,0,100,100);//(x,y,width,height)
		g2D.fillOval(0,0,100,100);
		*/

		
		//pokeball hehe
		g2D.setPaint(Color.red);
		g2D.drawArc(0,0,100,100,0,180);// (x,y,width,height,start angle,arc angle)
		g2D.fillArc(0,0,100,100,0,180);
		g2D.setPaint(Color.white);
		g2D.fillArc(0,0,100,100,180,180);
		g2D.setStroke(new BasicStroke(5));
		g2D.setPaint(Color.black);
		g2D.drawLine(0,50,100,50);
		

		/*
		int[] xPoints = {150,250,350};
		int[] yPoints = {300,150,300};
		g2D.setPaint(Color.yellow);
		g2D.drawPolygon(xPoints,yPoints,3); //(xPnts[],yPnts[],num of verticies on shape)
		g2D.fillPolygon(xPoints,yPoints,3);
		*/

		/*
		g2D.setFont(new Font("Ink Free",Font.BOLD,25));
		g2D.drawString("You are a winner",50,50); //uses bottom left as reference pnt, so if 0,0 its off screen
		*/
	}
}//end of class