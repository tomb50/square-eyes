package tomb.rough.game;

import java.awt.*;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 23/09/2013 Time: 19:27
 */
public class FullScreenAbstractGame extends AbstractGame
{

  private ScreenManager sm;

  public static final DisplayMode DISPLAY_MODES[] = {
    new DisplayMode( 800, 600, 32, 0 ),
    new DisplayMode( 800, 600, 24, 0 ),
    new DisplayMode( 800, 600, 16, 0 ),
    new DisplayMode( 640, 480, 32, 0 ),
    new DisplayMode( 640, 480, 24, 0 ),
    new DisplayMode( 640, 480, 16, 0 )
  };


  public void start()
  {
    sm = new ScreenManager();
    try
    {
      DisplayMode dm = sm.findFirstCompatibleMode( DISPLAY_MODES );
      sm.setFullScreen( dm );
      run();
    }
    finally
    {
      sm.restoreScreen();
    }
  }

  @Override
  protected void updateContent()
  {
    sm.update();
  }


  protected Graphics getGraphics()
  {
    return sm.getGraphics();
  }

  @Override
  protected void init()
  {
    sm = new ScreenManager();
    DisplayMode dm = sm.findFirstCompatibleMode( DISPLAY_MODES );
    sm.setFullScreen( dm );

    Window w = sm.getFullScreenWindow();
    w.setFont( new Font( "Arial", Font.PLAIN, 20 ) );
    w.setBackground( Color.GREEN );
    w.setForeground( Color.WHITE );
    running = true;
  }

  @Override
  protected int getGameWidth()
  {
    return sm.getWidth();
  }

  @Override
  protected int getGameHeight()
  {
    return sm.getHeight();
  }

  @Override
  public void draw( final Graphics2D graphics2D )
  {

  }
}

