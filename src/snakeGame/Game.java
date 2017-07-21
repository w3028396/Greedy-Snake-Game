package snakeGame;
import snakeGame.snake;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.*;

public class Game extends JFrame implements Runnable{
	int Win_width = 500;
	int Win_Height = 500;
	int f_x,f_y;
	private Image dbImage;
	private Graphics dbg;
	snake snake;
	Random random = new Random();
	Rectangle startButton = new Rectangle(150,100,100,150);
	Rectangle quitButton = new Rectangle(150,150,100,150);
	public void run(){
		try{
			while(true){
				
				if (snake.get_head().get_x() == f_x & snake.get_head().get_y() == f_y)
				{
					snake.eat();
					createFood();
				}
				move();
				Thread.sleep(snake.speed);
			}
		}
		catch(Exception e){
			System.out.println("Error");
		}
	}
	public void move(){
		//snake.change_dir(4);
		snake.move(snake.head_dir);
		//snake.move(4);
	}
	Game()
	{
		//initialize
		addKeyListener(new AL());
		setSize(Win_width,Win_Height);
		setBackground(Color.black);
		setTitle("Gray snake");
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		snake = new snake();
		createFood();
		
	}
	public void createFood(){		
		f_x = 1+ random.nextInt(43);
		f_y = 1+random.nextInt(41);
		f_x= f_x*11+6;
		f_y= f_y*11+36;
		System.out.println("x:"+f_x+"y:"+f_y);
	}
	public class  AL extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			int keyCode = e.getKeyCode();
			if(keyCode == e.VK_LEFT){
				snake.change_dir(1);
			}
			if(keyCode == e.VK_RIGHT){
				snake.change_dir(2);
			}
			if(keyCode == e.VK_UP){
				snake.change_dir(3);
			}
			if(keyCode == e.VK_DOWN){
				snake.change_dir(4);
			}
		}
		public void keyReleased(KeyEvent e){
			
		}
		
	}
	public void paint(Graphics g)
	{
		dbImage = createImage(getWidth(),getHeight());
		dbg = dbImage.getGraphics();
		paintcomponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}
	public void paintcomponent(Graphics g){
		g.setColor(Color.RED);
		g.fillOval(f_x,f_y,11,11);
		g.setColor(Color.GRAY);
		Node temp=snake.snake_body.get_head();
		while (temp!=null)
		{
			g.fillOval(temp.get_x(),temp.get_y(),11,11);
			temp = temp.get_next();
		}
		
		repaint();
	}
	public class MouseHandler extends MouseAdapter{
		public void mouseMoved(MouseEvent e){
			
		}
		public void mousePressed(MouseEvent e){
			int mx = e.getX();
			int my = e.getY();
			if(mx > startButton.x && mx < startButton.x+startButton.width){
				
			}
		}
		
	}
	public void startGame(){
		
	}
	public static void main(String[] args)
	{
		Game gm = new Game();
		
		Thread t1 = new Thread(gm);
		t1.start();
	}
}
