import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class APMSprite implements DisplayableSprite, MovableSprite {

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
	
	public APMSprite() {
		super();

		if (image == null) {
			try {
				image = ImageIO.read(new File("res/apm/astronaut.png"));
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
		return height;
	}

	public double getWidth() {
		return width;
	}	

	public void moveX(double pixelsPerSecond) {
		velocityX = pixelsPerSecond;
	}

	public void moveY(double pixelsPerSecond) {
		velocityY = pixelsPerSecond;
	}

	public void stop() {
	}

	public Image getImage() {
		
		if (deltaX > 0) {
			angle++;
		} else if (deltaX < 0) {
			angle--;
		} else if (deltaY > 0) {
			angle++;
		}  else if (deltaY < 0) {
			angle--;
		}
		
		return ImageRotator.rotate(image, angle);
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
