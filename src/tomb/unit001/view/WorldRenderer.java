package tomb.unit001.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tomb.unit001.model.Ship;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 17/10/2013 Time: 16:10
 */
public class WorldRenderer

{
  SpriteBatch batch;
  OrthographicCamera cam;
  World world;
  Texture shipTexture;
  Ship ship;

  public WorldRenderer( final World world )
  {
      this.world = world;
    batch = new SpriteBatch(  );
    cam = new OrthographicCamera(  );
    shipTexture = new Texture( "assets/data/ship.png" );
  }

  public void render()
  {
    ship = world.getShip();
    batch.begin();
    batch.draw( shipTexture, ship.getPosition().x, ship.getPosition().y );
    batch.end();
  }

  public void dispose()
  {
    batch.dispose();
    shipTexture.dispose();
  }


}
