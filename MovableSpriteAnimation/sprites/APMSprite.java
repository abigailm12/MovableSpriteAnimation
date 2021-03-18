import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class APMSprite implements DisplayableSprite, MovableSprite {

	private static Image image0 = null;
	private static Image image1 = null;
	private static Image image2 = null;
	private static Image image3 = null;
	private static Image image = null;
	private double centerX = 0;
	private double centerY = 0;
	private double deltaX = 0;
	private double deltaY = 0;
	private double height = 50;
	private double width = 50;
	private double velocityX = 0;
	private double velocityY = 0;
	private int angle = 90;
	private boolean spinForward = true;
	private int direction = 0; //0 = down; 1 = left; 2 = up; 3 = right 
	
	public APMSprite() {
		super();

		if (image0 == null) {
			try {
				image0 = ImageIO.read(new File("res/apm/sprite/sprite0.jpg"));
				image1 = ImageIO.read(new File("res/apm/sprite/sprite1.jpg"));
				image2 = ImageIO.read(new File("res/apm/sprite/sprite2.jpg"));
				image3 = ImageIO.read(new File("res/apm/sprite/sprite3.jpg"));
			}
			catch (IOException e) {
				System.out.println(e.toString());
			}	
		}
		
	}

	public void setCenterX(double centerX) {
		this.centerX = centerX;	
	}

	public void setCenterY(double centerY) {
		this.centerY = centerY;	
	}
	
	public double getHeight() {
		//return height;
		return image0.getHeight(null);
	}

	public double getWidth() {
		//return width;
		return image0.getWidth(null);
	}	

	public void moveX(double pixelsPerSecond) {
		this.velocityX = pixelsPerSecond;
	}

	public void moveY(double pixelsPerSecond) {
		this.velocityY = pixelsPerSecond;
	}

	public void stop() {
		this.velocityX = 0;
		this.velocityY = 0;
	}

	public Image getImage() {
		
		/* spinning astronaut
		if (deltaX > 0) {
			spinForward = true;
		} else if (deltaX < 0) {
			spinForward = false;
		}
		
		if (spinForward == true) {
			angle++;
		} else {
			angle--;
		}*/
		if (velocityX < 0) {
			direction = 1;
		} else if (velocityX > 0){
			direction = 3;
		} else if (velocityY > 0) {
			direction = 0;
		} else if (velocityY < 0) {
			direction = 2;
		}
		
		if (direction == 1) {
			image = image1;
		} else if (direction == 0) {
			image = image0;
		} else if (direction == 2) {
			image = image2;
		} else if (direction == 3) {
			image = image3;
		}
		
		//return ImageRotator.rotate(image, angle);
		return image;
		
	}

	public boolean getVisible() {
		return true;
	}

	public double getMinX() {
		return centerX - (width / 2);
	}

	public double getMaxX() {
		return centerX + (width / 2);
	}

	public double getMinY() {
		return centerY - (height / 2);
	}

	public double getMaxY() {
		return centerY + (height / 2);
	}

	public double getCenterX() {
		return centerX;
	}

	public double getCenterY() {
		return centerY;
	}

	public boolean getDispose() {
		return false;
	}

	public void update(Universe universe, KeyboardInput keyboard, long actual_delta_time) {
		deltaX = velocityX * actual_delta_time * 0.001;
		deltaY = velocityY * actual_delta_time * 0.001;
		centerX += deltaX;
		centerY += deltaY;
	}	
	
}
