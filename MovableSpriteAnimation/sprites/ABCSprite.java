import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ABCSprite implements DisplayableSprite, MovableSprite {

	Image image = null;
	
	public ABCSprite() {
		super();

		if (image == null) {
			try {
				image = ImageIO.read(new File("res/abc/ABC-sprite.png"));
			}
			catch (IOException e) {
				System.out.println(e.toString());
			}		
		}		
	}
	
}
