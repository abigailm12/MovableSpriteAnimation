import java.awt.Image; 
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class APMSprite implements DisplayableSprite, MovableSprite {

	private static final int FRAMES = 9;
	private static int framesPerSecond = 20;
	private static int millisecondsPerFrame = 1000 / framesPerSecond;
	private static Image[] imageLeft = null;
	private static Image[] imageRight = null;
	private long elapsedTime = 0;
	private double centerX = 0;
	private double centerY = 0;
	private double deltaX = 0;
	private double deltaY = 0;
	private double height = 50;
	private double width = 50;
	private double velocityX = 0;
	private double velocityY = 0;
	private int direction = 2; //1 = left; 2 = right
	private static int points = 0;
	
	public APMSprite() {
		super();

		if (imageLeft == null) {
			try {				
				imageLeft = new Image[FRAMES];
				for (int i = 0; i < FRAMES; i++) {
					String path = String.format("res/apm/bee_left-%d.png", i);
					imageLeft[i] = ImageIO.read(new File(path));
				}
				imageRight = new Image[FRAMES];
				for (int i = 0; i < FRAMES; i++) {
					String path = String.format("res/apm/bee_right-%d.png", i);
					imageRight[i] = ImageIO.read(new File(path));
				}
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
		Image output = null;
		long frame = elapsedTime / millisecondsPerFrame;
		int index = (int) frame % FRAMES;
				
		if (deltaX < 0) {
			this.direction = 1;
		} else if (deltaX > 0) {
			this.direction = 2;
		}
		
		if (direction == 1) {
			output = imageLeft[index];
		} else if (direction == 2) {
			output = imageRight[index];
		} 
		
		return output;
		
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
	
	public static int getPoints() {
		return points;
	}

	public void update(Universe universe, KeyboardInput keyboard, long actual_delta_time) {
		elapsedTime += actual_delta_time;
		
		deltaX = velocityX * actual_delta_time * 0.001;
		deltaY = velocityY * actual_delta_time * 0.001;		
		
		centerX += deltaX;
		centerY += deltaY;
	}	
		
}
