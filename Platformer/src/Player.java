import org.jbox2d.common.Vec2;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.World;

public class Player extends DynamicBody implements CollisionListener{
	public static final int RIGHT = 0;
	public static final int LEFT = 1;
	public static final int UP = 2;
	public static final int NO_DIRECTION = -1;

	private static final float size_w = 1f;
	private static final float size_h = 1f;
    private static final Shape playerShape = new BoxShape(size_w,size_h);
   
    private boolean jump = false;
    public int health = 3;
    
    public Player(World world){
        super(world, playerShape);
        this.addImage(new BodyImage("resources/character.png",2f));
        this.addCollisionListener(this);
    }

    
    public void move(int direction) {
    	switch(direction) {
    	case RIGHT:
    		this.setLinearVelocity(new Vec2(15,this.getLinearVelocity().y));
    		break;
    	case LEFT:
    		this.setLinearVelocity(new Vec2(-15,this.getLinearVelocity().y));
    		break;
    	case UP:
    		if (jump && this.getLinearVelocity().y<=1) {	
    			this.applyImpulse(new Vec2(0,150));
    			jump=false;
    		}
    		break;    	

    	case NO_DIRECTION:						
    		this.setLinearVelocity(new Vec2(0f,this.getLinearVelocity().y));
    		break;
    	}
    }
    
	@Override
	public void collide(CollisionEvent e) {
		// TODO Auto-generated method stub
		if (e.getNormal().y==-1) {
			jump=true;
		}
	}

	
}
