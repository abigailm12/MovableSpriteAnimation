import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class APMSprite implements DisplayableSprite, MovableSprite {

	private static Image image0 = null;
	private static Image images[] = null;
	private long elapsedTime = 0;
	private double centerX = 0;
	private double centerY = 0;
	private double deltaX = 0;
	private double deltaY = 0;
	private double height = 50;
	private double width = 50;
	private double velocityX = 0;
	private double velocityY = 0;
	private int direction = 1; //1 = left; 2 = right
	
	public APMSprite() {
		super();

		if (image0 == null) {
			try {				
				images = new Image[9];
				for (int i = 0; i < 9; i++) {
					String path = String.format("res/apm/bumblebee_%d/bee_%d-%d.png", direction, direction, i);
					images[i] = ImageIO.read(new File(path));
				}
			}
			catch (IOException e) {
				System.out.println(e.toString());
			}	
		}
		
	}
	
	public String getDirection(int x) {
		String direction = "left";
		if (x == 1) {
			direction = "left";
		} else if (x == 2) {
			direction = "right";				
		} else if (x == 3) {
			direction = "right";
		}
		
		return direction;
	}

	public void setCenterX(double centerX) {
		this.centerX = centerX;	
	}

	public void setCenterY(double centerY) {
		this.centerY = centerY;	
	}
	
	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
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
		
		if (deltaX < 0) {
			this.direction = 2;
		} else if (deltaX > 0) {
			this.direction = 1;
		}
		
		long frame = elapsedTime / 250;
		int phase = (int) (frame % 2);
		int index = direction * 2 + phase;
		
		return images[index];
		
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
		
		elapsedTime += actual_delta_time;
		

	}	
	
}
