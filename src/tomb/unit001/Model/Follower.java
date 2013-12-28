package tomb.unit001.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 29/10/2013 Time: 11:15
 */
public class Follower extends Enemy
{
  private final float ROTATION_SPEED = 500;

  public Follower( final float SPEED, final float rotation, final Vector2 position,
                   final float width, final float height )
  {
    super( SPEED, rotation, position, width, height );
  }


  @Override
  public void advance( final float delta, final Ship ship )
  {
    position.lerp( ship.getPosition(), delta );
    rotation += delta*ROTATION_SPEED;

    if(rotation>360) rotation -= 360;
    super.update( ship );

  }


}
