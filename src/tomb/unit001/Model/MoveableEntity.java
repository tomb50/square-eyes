package tomb.unit001.model;

import com.badlogic.gdx.math.Vector2;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 17/10/2013 Time: 15:32
 */
public abstract class MoveableEntity extends Entity
{

  protected MoveableEntity( final float SPEED, final float rotation, final Vector2 position, float width, float height )
  {
    super( position, width, height );
    this.SPEED = SPEED;
    this.rotation = rotation;
    velocity = new Vector2( 0,0 );
  }

  protected Vector2 velocity;
  protected float SPEED;
  protected float rotation;

  abstract void advance( float delta );

  public Vector2 getVelocity()
  {
    return velocity;
  }

  public void setVelocity( final Vector2 velocity )
  {
    this.velocity = velocity;
  }

  public float getRotation()
  {
    return rotation;
  }

  public void setRotation( final float rotation )
  {
    this.rotation = rotation;
  }

  public void update( final Ship ship )
  {
    bounds.x = position.x;
    bounds.y = position.y;
  }
}
