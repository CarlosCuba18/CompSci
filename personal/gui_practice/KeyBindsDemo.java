/*
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.Desktop.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionEvent;
*/
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;


public class KeyBindsDemo{
	JFrame frame;
	JLabel label;

	Action upAction; //action is a data type
	Action downAction;
	Action leftAction;
	Action rightAction;


	KeyBindsDemo(){
		frame = new JFrame("KeyBinding Demo");
		frame.setTitle("Drag And Drop Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,1000);
		frame.setLayout(null);

		label = new JLabel();
		label.setBackground(Color.blue);
		label.setBounds(100,100,100,100);
		label.setOpaque(true);
		

		upAction = new UpAction();
		downAction = new DownAction();
		leftAction = new LeftAction();
		rightAction = new RightAction();

		/*
		component.getInputMap().put(KeyStroke keyStroke (can be 'char'), Object MapKey);
		component.getActionMap().put(Object Mapkey (same as above) , action);
		*/

		label.getInputMap().put(KeyStroke.getKeyStroke("UP"),"upAction");
		label.getActionMap().put("upAction",upAction);

		label.getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"downAction");
		label.getActionMap().put("downAction",downAction);

		label.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"leftAction");
		label.getActionMap().put("leftAction",leftAction);

		label.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"),"rightAction");
		label.getActionMap().put("rightAction",rightAction);


		frame.add(label);
		frame.setVisible(true);
	}

	public class UpAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e){
			label.setLocation(label.getX(),label.getY()-10);
		}
	}//end up
	public class LeftAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e){
			label.setLocation(label.getX()-10,label.getY());
		}
	}//end left 
	public class DownAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e){
			label.setLocation(label.getX(),label.getY()+10);
		}
	}//end down
	public class RightAction extends AbstractAction{

		@Override
		public void actionPerformed(ActionEvent e){
			label.setLocation(label.getX()+10,label.getY());
		}
	}// end right
}