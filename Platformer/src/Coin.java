import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;
public class Coin extends StaticBody implements CollisionListener {

	private static final Shape shapeCoin = new BoxShape(0.2f,0.2f);		//Shape of the coin
	
	public Coin(World w) {

		super(w, shapeCoin);
		this.addImage(new BodyImage("resources/coin.png",1f));
		this.addCollisionListener(this);
	}

	@Override
	public void collide(CollisionEvent e) {
		if (e.getOtherBody().getClass().getName().equals(Player.class.getName())) {
			((GameWorld)e.getOtherBody().getWorld()).score++;
			this.destroy();
		}
		
	}
}
