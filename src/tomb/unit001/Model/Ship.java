package tomb.unit001.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 17/10/2013 Time: 15:45
 */
public class Ship extends MoveableEntity
{
  public Ship( Vector2 position, float width, float height, float rotation, float SPEED )
  {
    super( SPEED, rotation, position, width, height );
  }




  public void update( )
  {
    position.add( velocity.tmp().mul(  Gdx.graphics.getDeltaTime() * SPEED ));
    if(velocity.x !=0 || velocity.y != 0)
    rotation = velocity.angle()-90;

    bounds.x = position.x;
    bounds.y = position.y;

  }
}
