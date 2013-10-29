package tomb.unit001.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import tomb.unit001.Unit001;
import tomb.unit001.model.Follower;
import tomb.unit001.model.Ship;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 17/10/2013 Time: 15:49
 */
public class World
{
  Unit001 game;
  Ship ship;

  public Follower getFollower()
  {
    return follower;
  }

  Follower follower;

  public World( final Unit001 game )
  {
    this.game = game;
    ship = new Ship( new Vector2( 5, 5), 1, 1, 0, 5f );
    follower = new Follower(5f,0,new Vector2( 10,10 ),1,1);
    Gdx.input.setInputProcessor( new InputHandler( this ) );
  }

  public Ship getShip()
  {
    return ship;
  }

  public void update()
  {
    ship.update();
    follower.update( ship );

    if(ship.getBounds().overlaps(follower.getBounds() ))
    {
      Gdx.app.log( Unit001.LOG,"Hit" );
    }
  }

  public void dispose()
  {

  }
}
