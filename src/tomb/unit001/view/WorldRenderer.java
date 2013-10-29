package tomb.unit001.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
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
  float width, height;

  public WorldRenderer( final World world )
  {
    this.world = world;

    width =  Gdx.graphics.getWidth() / 40;
    height =  Gdx.graphics.getHeight() / 40;
    batch = new SpriteBatch();
    cam = new OrthographicCamera();
    cam.setToOrtho( false, width, height );
    cam.update();

    batch = new SpriteBatch(  );
    batch.setProjectionMatrix( cam.combined );



    shipTexture = new Texture( "assets/data/ship.png" );
    shipTexture.setFilter( Texture.TextureFilter.Linear, Texture.TextureFilter.Linear );
  }

  public void render()
  {
    Gdx.gl.glClearColor( 0, 0, 0, 1 );
    Gdx.gl.glClear( GL10.GL_COLOR_BUFFER_BIT );

    ship = world.getShip();
    cam.position.set( ship.getPosition().x, ship.getPosition().y,0 );
    cam.update();
    batch.setProjectionMatrix( cam.combined );
    batch.begin();
    batch.draw( shipTexture, ship.getPosition().x, ship.getPosition().y, 0, 0, ship.getWidth(), ship.getHieght(), 1, 1,
                ship.getRotation(), 0, 0, shipTexture.getWidth(), shipTexture.getHeight(), false, false );
    batch.end();
  }

  public void dispose()
  {
    batch.dispose();
    shipTexture.dispose();
  }
}
