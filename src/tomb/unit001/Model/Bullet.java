package tomb.unit001.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 29/10/2013 Time: 12:37
 */
public class Bullet extends MoveableEntity
{
  public static float SPEED = 8;
  public Bullet( final float SPEED, final float rotation, final Vector2 position, final Vector2 velocity,
                 final float width, final float height )
  {
    super( SPEED, rotation, position, width, height );
    this.velocity = velocity;
  }

  public void update(Ship ship)
  {
    position.add( velocity.tmp().mul(  Gdx.graphics.getDeltaTime() * SPEED ));
    rotation = velocity.angle() -90;
  super.update( ship );
  }


}
