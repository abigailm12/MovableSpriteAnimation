import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class APMSprite implements DisplayableSprite, MovableSprite {

	Image image = null;
	double centerX = 0;
	double centerY = 0;
	double height = 50;
	double width = 50;
	double velocityX = 0;
	double velocityY = 0;
	
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
		centerX = centerX + pixelsPerSecond / 60;
	}

	public void moveY(double pixelsPerSecond) {
		centerY = centerY + pixelsPerSecond / 60;
	}

	public void stop() {
	
	}

	public Image getImage() {
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
		
	}	
	
}
