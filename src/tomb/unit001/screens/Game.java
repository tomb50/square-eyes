package tomb.unit001.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import tomb.unit001.Unit001;
import tomb.unit001.view.World;
import tomb.unit001.view.WorldRenderer;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 17/10/2013 Time: 15:14
 */
public class Game implements Screen
{
  Unit001 game;
  World world;
  WorldRenderer renderer;

  public Game( final Unit001 game )
  {
    this.game = game;
    world = new World( game );
    renderer = new WorldRenderer( world );
  }

  @Override
  public void render( final float delta )
  {

    Gdx.gl.glClearColor( 0,0,0,1 );
    Gdx.gl.glClear( GL10.GL_COLOR_BUFFER_BIT );

    world.update();
  renderer.render();
  }

  @Override
  public void resize( final int width, final int height )
  {

  }

  @Override
  public void show()
  {

  }

  @Override
  public void hide()
  {
   dispose();

  }

  @Override
  public void pause()
  {

  }

  @Override
  public void resume()
  {

  }

  @Override
  public void dispose()
  {
    world.dispose();
    renderer.dispose();

  }
}
