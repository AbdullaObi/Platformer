import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;

import org.jbox2d.common.Vec2;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.CircleShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.World;

public class GameWorld extends World implements KeyListener, StepListener {
	public Player player;
	public Enemy enemy1;
	
	private static boolean key_left = false;
	private static boolean key_right = false;
	private static boolean key_up = false;
	int score;
	Vec2 startingPosition = new Vec2(-16,-8);
    public GameWorld(){

        super();
        this.setGravity(75f);			
        this.addStepListener(this);
        this.chargeLevel();
		player = new Player(this);
		player.setPosition(startingPosition);
		
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void chargeLevel() {
		Shape borderShape = new BoxShape(1f,60f);
		StaticBody border_left = new StaticBody(this,borderShape);
		border_left.setPosition(new Vec2(-21f,0f));
		StaticBody border_right = new StaticBody(this,borderShape);
		border_right.setPosition(new Vec2(21f,0f));
	
		  BoxShape shapeground = new BoxShape(20f, 7f);
	      StaticBody ground = new StaticBody(this, shapeground);
	      ground.setPosition(new Vec2(0f, -15f));
	      ground.addImage(new BodyImage("resources/ground.png",14f));
	      
	      Shape box1shape = new BoxShape(2f,2f);     
	      DynamicBody box1 = new DynamicBody(this,box1shape);	
	      box1.setFillColor(Color.gray.LIGHT_GRAY);
	      box1.setPosition(new Vec2(-7f,-8f));
	      box1.setGravityScale(7);
	      box1.addImage(new BodyImage("resources/box.png",4f));

		  BoxShape platform = new BoxShape(5f, 1f);
	      StaticBody plat = new StaticBody(this, platform);
	      plat.setPosition(new Vec2(2f, -2f));
	      plat.addImage(new BodyImage("resources/platform2.png",2f));
	      
	      Shape box3shape = new CircleShape(1f);
	     
	      DynamicBody box3 = new DynamicBody(this,box3shape);
	      box3.setPosition(new Vec2(2f,2f));
	      box3.setGravityScale(7);
	      box3.setFillColor(Color.cyan);
	      box3.setLineColor(Color.blue);
	      box3.addImage(new BodyImage("resources/wheel.png",2f));
	      
		  BoxShape platform2 = new BoxShape(5f, 1f);
	      StaticBody plat2 = new StaticBody(this, platform);
	      plat2.setPosition(new Vec2(-15f, 5f));
	      plat2.addImage(new BodyImage("resources/platform1.png",2f));
	      
		  BoxShape platform3 = new BoxShape(5f, 1f);
	      StaticBody plat3 = new StaticBody(this, platform3);
	      plat3.setPosition(new Vec2(18f, 5f));
	      plat3.addImage(new BodyImage("resources/platform3.png",2f));
	
		  BoxShape platform4 = new BoxShape(4f, 1f);
	      StaticBody plat4 = new StaticBody(this, platform4);
	      plat4.setPosition(new Vec2(2f, 8f));
	      plat4.addImage(new BodyImage("resources/platform4.png",2f));

	      Coin c1 = new Coin(this);
	      c1.setPosition(new Vec2(2f,10f));
	      Coin c2 = new Coin(this);
	      c2.setPosition(new Vec2(0f,-7f));
	      Coin c3= new Coin(this);
	      c3.setPosition(new Vec2(2f,-7f));
	      Coin c4= new Coin(this);
	      c4.setPosition(new Vec2(4f,-7f));
	
	      enemy1 = new Enemy(this);
	      enemy1.setPosition(new Vec2(8f,-9f));
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 37) {
			key_left=true;
		}
		if (e.getKeyCode() == 38) {
			key_up=true;
		}
		if (e.getKeyCode() == 39) {
			key_right=true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 37) {
			key_left=false;
		}
		if (e.getKeyCode() == 38) {
			key_up=false;
		}
		if (e.getKeyCode() == 39) {
			key_right=false;
		}
	
	}

	@Override
	public void postStep(StepEvent arg0) {
		if (key_left) {
			player.move(Player.LEFT);
		}
		if (key_right) {
			player.move(Player.RIGHT);
		}
		if (key_up) {
			player.move(Player.UP);
		}
		if (!key_left && !key_right) {
			player.move(Player.NO_DIRECTION);
		}
		enemy1.eventStep();

	}

	@Override
	public void preStep(StepEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}