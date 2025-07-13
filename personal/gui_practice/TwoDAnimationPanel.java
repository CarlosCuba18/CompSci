import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TwoDAnimationPanel extends JPanel implements ActionListener{

	final int PANEL_WIDTH = 500;
	final int PANEL_HEIGHT = 500;
	Image one;
	Image background;
	Timer timer;
	int xVelocity = 2; //change path by changing these velocitys
	int yVelocity = 1;
	int x = 0;
	int y = 0;

	TwoDAnimationPanel(){
		this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
		this.setBackground(Color.blue);
		one = new ImageIcon("one.png").getImage();
		background = new ImageIcon("hourglass.png").getImage();
		timer = new Timer(10,this); //(int for delay in ms, action listener)
		timer.start();
	}

	public void paint(Graphics g){
		super.paint(g);
		Graphics2D graphic = (Graphics2D) g;
		graphic.drawImage(background,0,0,null);
		graphic.drawImage(one,x,y,null);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if(x >= PANEL_WIDTH-one.getWidth(null) || x<0){
			xVelocity *= -1;
		}
			x = x + xVelocity;
		if(y >= PANEL_HEIGHT-one.getHeight(null) || y<0){
			yVelocity *= -1;
		}
			y = y + yVelocity;
		repaint();

	}
}