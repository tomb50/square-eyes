package tomb.unit001;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.FPSLogger;
import tomb.unit001.screens.GameScreen;
import tomb.unit001.screens.SplashScreen;

public class Unit001 extends Game implements ApplicationListener
{
  public static final String VERSION = "0.1";
  public static final String LOG = "Unit001";
  FPSLogger logger;

  @Override
  public void create()
  {
    logger = new FPSLogger();
    setScreen( new GameScreen( this ) );
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
    logger.log();
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