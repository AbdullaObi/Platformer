import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Resources {
	public static Image background;
	public static Image heart;
	public static Image coin;
	
	public static void loadResources() {
		/*
		 * This function download all the image files used in the game in the functions GameView.paintBackground and GameView.paintForeground
		 */
		try {
			background = ImageIO.read(new File("resources/background.png"));
			heart = ImageIO.read(new File("resources/heart.png"));
			coin = ImageIO.read(new File("resources/coin.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
