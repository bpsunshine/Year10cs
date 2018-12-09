package game;

import java.awt.Image;
import java.awt.Toolkit;

public class Projectile {
	private float xCoord = 0;
	private int yCoord = 0;
	private int height = 2;
	private int width = 2;
	private Image img;
	public int facing = 0; // 0 is right
		
		/**
		 * Goodguy default constructor
		 */
		public Projectile() {
			setxCoord(10);
			setyCoord(10);
			setWidth(50);
			setHeight(50);
			setImg("files/ChainsawRight.png");
		}
		
	
		public Projectile(int x, int y, int w, int h, String imgpath) {
			setxCoord(x);
			setyCoord(y);
			setWidth(w);
			setHeight(h);
			setImg(imgpath);
		}
	
		public Projectile(int x, int y, int w, int h, String imgpath, int facing) {
			setxCoord(x);
			setyCoord(y);
			setWidth(w);
			setHeight(h);
			setImg(imgpath);
			this.facing = facing;
		}
		
		

		public void setImg(String imgpath) {
			this.img = Toolkit.getDefaultToolkit().getImage(imgpath);
		}

		public float getxCoord() {
			return this.xCoord;
		}

		public void setxCoord(float xCoord) {

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