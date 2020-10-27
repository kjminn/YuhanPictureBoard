package week09;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class SimplePictureBoard extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
	
	JMenuItem mRed = new JMenuItem("빨강");
	JMenuItem mBlue = new JMenuItem("파랑");
	JMenuItem mYellow = new JMenuItem("노랑");
	JMenuItem mGreen = new JMenuItem("초록");
	JMenuItem mBlack = new JMenuItem("검정");
	JMenuItem mRect = new JMenuItem("직사각형");
	JMenuItem mOval = new JMenuItem("원 또는 타원");
	JMenuItem mLine = new JMenuItem("선그리기");
	
	int shape = 0; // 1: 직사각형, 2: 원, 3: 선  
	public static final int RECT = 1;
	public static final int OVAL = 2;
	public static final int LINE = 3;
	
	Color color = Color.BLACK;
	
	int startX, startY, endX, endY;
	
	public SimplePictureBoard() {
		setTitle("간단 그림판");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JMenuBar bar = new JMenuBar();
		JMenu menuColor = new JMenu("색상");
		JMenu menuPoly = new JMenu("도형변경");
		
		menuColor.add(mRed);
		menuColor.add(mBlue);
		menuColor.add(mYellow);
		menuColor.add(mGreen);
		menuColor.add(mBlack);
		
		menuPoly.add(mRect);
		menuPoly.add(mOval);
		menuPoly.add(mLine);
		
		bar.add(menuColor);
		bar.add(menuPoly);
		setJMenuBar(bar);
		
		mRed.addActionListener(this);
		mBlue.addActionListener(this);
		mYellow.addActionListener(this);
		mGreen.addActionListener(this);
		mBlack.addActionListener(this);
		
		mRect.addActionListener(this);
		mOval.addActionListener(this);
		mLine.addActionListener(this);
		
		MyCanvas canvas = new MyCanvas();
		add(canvas, "Center");
		
		canvas.addMouseListener(this);
		canvas.addMouseMotionListener(this);
		
		setBounds(1000, 200, 600, 500);
		setVisible(true);
	}
	
	class MyCanvas extends JPanel{
		@Override
		public void paint(Graphics g) {
			super.paint(g);   
						
			g.setColor(color);
			
			switch (shape) {
			case RECT:
				g.drawRect(startX, startY, endX - startX , endY - startY);
				break;
			case OVAL:
				g.drawOval(startX, startY, endX - startX , endY - startY);
				break;
			case LINE:
				g.drawLine(startX, startY, endX , endY);
				break;
			}
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object eMenu = e.getSource();
		if(eMenu == mRect) {
			shape = RECT;
		}else if(eMenu == mOval) {
			shape = OVAL;
		}else if(eMenu == mLine) {
			shape = LINE;
		}else if(eMenu == mRed) {
			color = Color.RED;
		}else if(eMenu == mBlue) {
			color = Color.BLUE;
		}else if(eMenu == mYellow) {
			color = Color.YELLOW;
		}else if(eMenu == mGreen) {
			color = Color.GREEN;
		}else if(eMenu == mBlack) {
			color = Color.BLACK;
		}
		
		repaint();
	}

	public static void main(String[] args) {
		new SimplePictureBoard();

	}

	@Override
	public void mouseClicked(MouseEvent e) {		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		startX = e.getX();
		startY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {	
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		endX = e.getX();
		endY = e.getY();
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
