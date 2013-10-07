package tomb.unit001.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import tomb.unit001.Unit001;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 07/10/2013 Time: 17:27
 */
public class MainMenu implements Screen
{
  public MainMenu( final Unit001 game )
  {

  }

  @Override
  public void render( final float delta )
  {
   Gdx.gl.glClearColor( 1,1,1,1 );
    Gdx.gl.glClear( GL10.GL_COLOR_BUFFER_BIT );
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

  }
}
