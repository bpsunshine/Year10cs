package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.io.InputStream;
import java.io.*;
import sun.audio.*;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JButton;


public class MyCanvas extends Canvas implements KeyListener{ 
	
	// global variables - accessible in all methods
	Goodguy link = new Goodguy(200,360,130,130,"files/Phil.png",0);
	Image background = Toolkit.getDefaultToolkit().getImage("files/paper.png");	
	//Background gamewin = new Background (0,0,1440,900, "files/YouWin.pdf");
	LinkedList badguys = new LinkedList();
	LinkedList knives = new LinkedList();
	boolean GameOver = false;
	boolean winscreen =false;
	boolean win = false;
	int kills = 0;
	int numberprojectiles = 0;
	
	public MyCanvas() {
		this.setSize(1920,1080); // set same size as MyScreen
		this.addKeyListener(this); //add the listener to canvas
		Random rand = new Random ();
		int winwidth = this.getWidth();
		int winheight = this.getHeight();
		for (int i = 0; i < 15; i++ ) {
			Badguy bg = new Badguy (rand.nextInt(1200), rand.nextInt(winheight), 50,50, "files/IB.png");
			Rectangle r = new Rectangle (100,100,30,30);
			if (r.contains(link.getxCoord(), link.getyCoord())) {
				System.out.println("badguy on top of Phil");
				continue;
			}
			badguys.add(bg);
		}
		
		//if (bg.xCoord <= 0) {
			//gameover = true;
		//  
		
		TimerTask repeatedTask = new TimerTask() {

	        public void run() {

	            for(int i = 0; i < badguys.size(); i++) {// draw bad guys

	                Badguy bg = (Badguy) badguys.get(i);

	                bg.setxCoord(bg.getxCoord() - 4);

	            }

	            repaint();

	        }

	    };

	    Timer timer = new Timer("Timer");

	     

	    long delay  = 100L;

	    long period = 100L;

	    timer.scheduleAtFixedRate(repeatedTask, delay, period);
	
	}

	@Override
	public void paint(Graphics g) {
		
		g.drawImage(background,0,0, this);
		g.drawImage(link.getImg(), link.getxCoord(), link.getyCoord(), link.getWidth(), link.getHeight(), this);
	
		
		
		
		for(int i = 0; i < badguys.size();i++) {//draw bad guys
			Badguy bg =(Badguy) badguys.get(i);
			g.drawImage(bg.getImg(), bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight(), this);
			Rectangle r = new Rectangle(bg.getxCoord(),bg.getyCoord(),bg.getWidth(),bg.getHeight());

			for(int j = 0; j < knives.size(); j++) {
				Projectile k = (Projectile) knives.get(j);
					
				if (k.getxCoord() >this.getWidth()) { knives.remove(k); }
				
				if (k.facing == 0) {
					k.setxCoord((float) (k.getxCoord() + 0.1));
				} else {
					k.setxCoord((float) (k.getxCoord() - 0.1));
				}
				
				g.drawImage(k.getImg(), (int) k.getxCoord(), k.getyCoord(), k.getWidth(), k.getHeight(), this);
			
				Rectangle kr = new Rectangle((int) k.getxCoord(),k.getyCoord(),k.getWidth(),k.getHeight());
				if (kr.intersects(r)) {
					badguys.remove(i);
					knives.remove(j);
				}
				repaint();
			}
			
		}
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == 32) {
			//playIt("files/ping");
			if (link.facing == 0) {
				Projectile knife = new Projectile(link.getxCoord(), link.getyCoord(), 50, 50,"files/ChainsawRight.png",0);
				knives.add(knife);
			} else {
				Projectile knife = new Projectile(link.getxCoord(), link.getyCoord(), 50, 50,"files/Chainsawleft.png", 1);
				knives.add(knife);
			}
			
		}
		playIt("/files/Thats_a_lot_of_damage.wav");
		System.out.println(e);
		link.moveIt(e.getKeyCode(), this.getWidth(), this.getHeight());
		Rectangle gg_r = new Rectangle(link.getxCoord(), link.getyCoord(),link.getWidth(), link.getHeight());
		
		
		for (int i = 0; i< badguys.size(); i++) {
			Badguy bg = (Badguy) badguys.get(i);
			Rectangle r = new Rectangle(bg.getxCoord(),bg.getyCoord(),bg.getWidth(),bg.getHeight());
			if(r.intersects(gg_r)) {
				
				//g.drawImage(background2,480,336, this);
				System.out.println("get rekt libtard");
				badguys.remove(i);
				playIt("files/what up stream.wav");
				Sound.sound3.play();
							
			}
		}
		repaint();
	}
	

public void playIt (String filename) {

		

		try { 
			InputStream in = new FileInputStream(filename);
			AudioStream as = new AudioStream(in);
			AudioPlayer.player.start(as);
		}  catch (IOException e) {
				System.out.println(e);
		}
	}



	public void keyTyped(KeyEvent e) {
		repaint();
	}
		
	
	@Override
	public void keyReleased(KeyEvent e) {
	
	}




	public static void add(JButton button) {
		// TODO Auto-generated method stub
		
	}
}
