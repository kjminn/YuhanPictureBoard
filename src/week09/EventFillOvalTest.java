package week09;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class EventFillOvalTest extends JFrame implements ItemListener {
	Color color = Color.BLACK;
	JRadioButton radioRed, radioBlue, radioYellow;
	
	public EventFillOvalTest() {
		setTitle("라디오버튼으로 타원 색상변경하기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel radioPan = new JPanel();
		ButtonGroup group = new ButtonGroup();
		radioRed = new JRadioButton("RED");
		radioBlue = new JRadioButton("BLUE");
		radioYellow = new JRadioButton("YELLOW");
		radioRed.addItemListener(this);
		radioBlue.addItemListener(this);
		radioYellow.addItemListener(this);
		group.add(radioRed);
		group.add(radioBlue);
		group.add(radioYellow);
		radioPan.add(radioRed);
		radioPan.add(radioBlue);
		radioPan.add(radioYellow);
		MyCanvas canvas = new MyCanvas();
		add(radioPan, "North");
		add(canvas, "Center");
		setBounds(1000, 200, 600, 500);
		setVisible(true);
	}
	
	class MyCanvas extends JPanel{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(color);
			g.fillOval(150, 100, 300, 200);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(radioRed.isSelected()) {
			color = Color.RED;
		}else if(radioBlue.isSelected()) {
			color = Color.BLUE;
		}else {
			color = Color.YELLOW;
		}
		repaint();
	}

	public static void main(String[] args) {
		new EventFillOvalTest();

	}

}
