 package game;

import java.awt.Image;
import java.awt.Toolkit;


public class Goodguy {
	
	private int xCoord = 0;
	private int yCoord = 0;
	private int width = 10;
	private int height = 10;
	private Image img;
	public int facing = 0;

	public Goodguy(int x, int y, int w, int h, String imgpath) {
		setxCoord(x);
		setyCoord(y);
		setWidth(w);
		setHeight(h);
		setImg(imgpath);
	}
	
	public Goodguy(int x, int y, int w, int h, String imgpath, int facing) {
		setxCoord(x);
		setyCoord(y);
		setWidth(w);
		setHeight(h);
		setImg(imgpath);
		this.facing = facing;
	}
	
	public void moveIt(int direction, int w, int h) {
		int speed = 20;
		int x = getxCoord();
		int y = getyCoord();
		if (direction == 68) {
			x = x + speed;
			if (x > w ) { x = x - speed * 3; } 
			setxCoord(x);
			setImg("files/Phil.png");
			this.facing = 0;
		} else if (direction == 65) {
			if (x < 0) { x = x + speed*3;}
			x = x - speed;
			setxCoord(x);
			setImg("files/Phil2.png");
			  this.facing = 1;
			}
		  else if (direction == 87) { //going up
			  if (y < 0) { y = y + speed * 3; }
			  y = y - speed;
			  setyCoord(y);
			  }
		  else if (direction == 83) { //going down
			if (y > h -10) { y = y + speed * 3 ;}
			  y = y + speed;
			  setyCoord(y);
			  }
		}

	public void setImg(String imgpath) {
		this.img = Toolkit.getDefaultToolkit().getImage(imgpath);
	}

	public int getxCoord() {
		return this.xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return this.yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}
	
	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Image getImg() {
		return img;
	}
		
}