package tomb.unit001.model;

import com.badlogic.gdx.math.Vector2;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 17/10/2013 Time: 15:45
 */
public class Ship extends MoveableEntity
{
  public Ship( Vector2 position, float width, float height, float rotation, float SPEED)
  {
    super(SPEED,rotation,position,width,height);
  }

  @Override
  void advance( final float delta )
  {

  }

  @Override
  public void update()
  {

  }
}
