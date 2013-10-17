package tomb.unit001;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import tomb.unit001.screens.SplashScreen;

public class Unit001 extends Game implements ApplicationListener
{
  public static final String VERSION = "0.1";
  public static final String LOG = "Unit001";

  @Override
  public void create()
  {
    setScreen( new SplashScreen( this ) );
  }

  @Override
  public void resize( final int width, final int height )
  {
    super.resize( width, height );
  }

  @Override
  public void render()
  {
    super.render();
  }

  @Override
  public void pause()
  {
    super.pause();
  }

  @Override
  public void resume()
  {
    super.resume();
  }

  @Override
  public void dispose()
  {
    super.dispose();
  }
}