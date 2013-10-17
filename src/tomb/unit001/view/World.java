package tomb.unit001.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import tomb.unit001.model.Ship;
import tomb.unit001.Unit001;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 17/10/2013 Time: 15:49
 */
public class World
{
  Unit001 game;
  Ship ship;

  public World( final Unit001 game )
  {
    this.game = game;
    ship = new Ship( new Vector2( Gdx.graphics.getWidth() /2, Gdx.graphics.getHeight()/2 ),1,1,0,5f );

  }

  public Ship getShip()
  {
    return ship;
  }

  public void update()
  {
    ship.update();

  }

  public void dispose()
  {

}
}
