package tomb.unit001;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.FPSLogger;
import tomb.unit001.screens.GameScreen;
import tomb.unit001.screens.MainMenu;
import tomb.unit001.screens.SplashScreen;
import tomb.unit001.view.Unit001Audio;

public class Unit001 extends Game implements ApplicationListener
{
  public static final String VERSION = "0.1";
  public static final String LOG = "Unit001";
  FPSLogger logger;

  @Override
  public void create()
  {
    logger = new FPSLogger();
    Unit001Audio.playMusic( true );
    setScreen( new MainMenu( this ) );
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
    Unit001Audio.dispose();
  }
}