package tomb.unit001.model;

import com.badlogic.gdx.math.Vector2;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 17/10/2013 Time: 15:44
 */
public abstract class Enemy extends MoveableEntity
{
  protected Enemy( final float SPEED, final float rotation, final Vector2 position,
                   final float width, final float height )
  {
    super( SPEED, rotation, position, width, height );
  }

  public abstract void advance(float delta, Ship ship);
}
