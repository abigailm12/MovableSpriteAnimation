import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class APMSprite implements DisplayableSprite, MovableSprite {

	Image image = null;
	
	double centerX = 0;
	double centerY = 0;
	
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
		double height = getHeight();
		return height;
	}

	public double getWidth() {
		double width = getWidth();
		return width;
	}
	
	public double getMinX() {
		return centerX - (getWidth() / 2);
	}

	public double getMaxX() {
		return centerX + (getWidth() / 2);
	}

	public double getMinY() {
		return centerY - (getHeight() / 2);
	}

	public double getMaxY() {
		return centerY - (getHeight() / 2);
	}

	public void moveX(double pixelsPerSecond) {
		
	}

	public void moveY(double pixelsPerSecond) {
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	public double getCenterX() {
		return centerX;
	}

	public double getCenterY() {
		return centerY;
	}

	@Override
	public boolean getDispose() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(Universe universe, KeyboardInput keyboard, long actual_delta_time) {
		// TODO Auto-generated method stub
		
	}
	
}
