package tomb.unit001.view;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import tomb.unit001.model.Bullet;
import tomb.unit001.model.Ship;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 29/10/2013 Time: 10:26
 */
public class InputHandler implements InputProcessor
{

  private final World world;
  final Ship ship;
  Vector3 touch = new Vector3(  );
  Vector2 vec2Touch = new Vector2();

  public InputHandler(World world)
  {
    this.world = world;
    ship =world.getShip();
  }
  @Override
  public boolean keyDown( final int keycode )
  {
    switch(keycode)
    {
      case Input.Keys.W:

        ship.getVelocity().y=1;
        break;
      case Input.Keys.A:
        ship.getVelocity().x=-1;
        break;
      case Input.Keys.S:
        ship.getVelocity().y=-1;
        break;
      case Input.Keys.D:
        ship.getVelocity().x=1;
        break;
    }
    return false;
  }

  @Override
  public boolean keyUp( final int keycode )
  {
    switch(keycode)
    {
      case Input.Keys.W:
        if(ship.getVelocity().y ==1)
        ship.getVelocity().y=0;
        break;
      case Input.Keys.A:
        if(ship.getVelocity().x == -1)
        ship.getVelocity().x=0;
        break;
      case Input.Keys.S:
        if(ship.getVelocity().y==-1)
        ship.getVelocity().y=0;
        break;
      case Input.Keys.D:
        if(ship.getVelocity().x==1)
        ship.getVelocity().x=0;
        break;
    }
    return false;
  }

  @Override
  public boolean keyTyped( final char character )
  {
    return false;
  }

  @Override
  public boolean touchDown( final int screenX, final int screenY, final int pointer, final int button )
  {
    touch.set( screenX,screenY,0 );
    world.getRenderer().getCamera().unproject( touch );
    vec2Touch.set( touch.x, touch.y );
    world.addBullet( new Bullet( Bullet.SPEED, 0, new Vector2( ship.getPosition().x, ship.getPosition().y ),
                                 new Vector2( vec2Touch.sub( ship.getPosition()  ) ) , .1f, 8/20f ));
    Unit001Audio.shoot();
    return true;
  }

  @Override
  public boolean touchUp( final int screenX, final int screenY, final int pointer, final int button )
  {
    return false;
  }

  @Override
  public boolean touchDragged( final int screenX, final int screenY, final int pointer )
  {
    return false;
  }

  @Override
  public boolean mouseMoved( final int screenX, final int screenY )
  {
    return false;
  }

  @Override
  public boolean scrolled( final int amount )
  {
    return false;
  }
}
