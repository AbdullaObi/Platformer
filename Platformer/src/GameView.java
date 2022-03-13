import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import city.cs.engine.UserView;

public class GameView extends UserView {

	private static final long serialVersionUID = 1L;
	
	GameWorld w;
	Font fontGame = new Font("",Font.BOLD,20);
	
    public GameView(GameWorld world, int width, int height) {
  
        super(world, width, height);
        w=world;
    }

    @Override
    public void paintBackground(Graphics2D g) {
    	g.drawImage(Resources.background, 0,0,800,650,null);
    	for (int i = 0; i<w.player.health;i++) {
        	g.drawImage(Resources.heart, 10+35*i, 10, 20, 20, null);
    	}
    	g.drawImage(Resources.coin, 10, 40, 20,20, null);
    	g.setColor(Color.black);
    	g.setFont(fontGame);
    	g.drawString(String.valueOf(w.score*5), 40,57);
    }
    
  
}