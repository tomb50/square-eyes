package tomb.unit001.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import tomb.unit001.model.Follower;
import tomb.unit001.model.Ship;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 17/10/2013 Time: 16:10
 */
public class WorldRenderer

{
  SpriteBatch batch;
  OrthographicCamera cam;
  World world;
  Texture shipTexture, followerTexture;
  Ship ship;
  float width, height;
  ShapeRenderer shapeRenderer;
  Follower follower;

  public WorldRenderer( final World world )
  {
    this.world = world;
    follower = world.getFollower();

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
    followerTexture = new Texture("assets/data/follower.png");
    followerTexture.setFilter( Texture.TextureFilter.Linear, Texture.TextureFilter.Linear  );
    shapeRenderer = new ShapeRenderer(  );

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
    batch.draw( shipTexture, ship.getPosition().x, ship.getPosition().y, ship.getWidth() / 2, ship.getHieght() / 2,
                ship.getWidth(), ship.getHieght(), 1, 1,
                ship.getRotation(), 0, 0, shipTexture.getWidth(), shipTexture.getHeight(), false, false );
    batch.draw( followerTexture, follower.getPosition().x, follower.getPosition().y, follower.getWidth() / 2,
                follower.getHieght() / 2,
                follower.getWidth(), follower.getHieght(), 1, 1,
                follower.getRotation(), 0, 0, followerTexture.getWidth(), followerTexture.getHeight(), false, false );
    batch.end();

    shapeRenderer.setProjectionMatrix( cam.combined );

    //Ship and enemy hitboxes
    shapeRenderer.begin( ShapeRenderer.ShapeType.Rectangle );
    shapeRenderer.setColor( Color.CYAN );
    shapeRenderer.rect( ship.getBounds().x, ship.getBounds().y, ship.getBounds().width, ship.getBounds().height );
    shapeRenderer.setColor( Color.RED );
    shapeRenderer.rect( follower.getBounds().x, follower.getBounds().y, follower.getBounds().width, follower.getBounds().height );


    shapeRenderer.end();
  }

  public void dispose()
  {
    batch.dispose();
    shipTexture.dispose();
    shapeRenderer.dispose();
  }
}
