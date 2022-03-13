import org.jbox2d.common.Vec2;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.World;

public class Enemy extends DynamicBody implements CollisionListener{
	private static final float size = 0.9f;
    private static final Shape enemyShape = new BoxShape(size,size);
   
    private int TIMER_CHANGEMENT = 100;
    private int timer = 0;

    private boolean sideMovement = false;
    
	public Enemy(World w) {
		super(w,enemyShape);
		this.addImage(new BodyImage("resources/enemy.png",1.8f));
		this.addCollisionListener(this);
	}
	
	public void eventStep() {
		timer++;
		if (timer>=TIMER_CHANGEMENT) {
			timer=0;
			sideMovement=!sideMovement;
		}

		if (!sideMovement) {
			this.setLinearVelocity(new Vec2(5,0));
		}
		else {
			this.setLinearVelocity(new Vec2(-5,0));
		}
	}
    
	public void attacked() {
		this.destroy();	
	}
	
	@Override
	public void collide(CollisionEvent e) {
		if (e.getOtherBody().getClass().getName().equals(Player.class.getName())) {
			Player p =  (Player)e.getOtherBody();
			if (e.getNormal().x==-1) {
				float vx = (p.getLinearVelocity().x);
				this.applyImpulse(new Vec2(-vx*5,0));
				p.applyImpulse(new Vec2(150,100));
				p.health-=1;
			}
			else if (e.getNormal().x==1) {
				float vx = (p.getLinearVelocity().x);
				this.applyImpulse(new Vec2(-vx*5,0));
				p.applyImpulse(new Vec2(-150,100));
				p.health-=1;
			}
			else if (e.getNormal().y == 1){			
				this.destroy();
				p.applyImpulse(new Vec2(0,150));;
			}
			else {
				p.applyImpulse(new Vec2(0,150));
			
			}

		}
	}

}
