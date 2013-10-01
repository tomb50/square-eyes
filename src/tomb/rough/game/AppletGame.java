package tomb.rough.game;

import java.awt.*;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 23/09/2013 Time: 19:27
 */
public class AppletGame extends Game
{

  protected GameWindow gameWindow;


  protected Graphics getGraphics()
  {

    return gameWindow.getBufferStrategy().getDrawGraphics();
  }

  @Override
  protected void init()
  {

    gameWindow = new GameWindow();
    gameWindow.setFont( new Font( "Arial", Font.PLAIN, 20 ) );
    gameWindow.setBackground( Color.GREEN );
    gameWindow.setForeground( Color.WHITE );
    running = true;

  }



  @Override
  protected int getGameWidth()
  {
    return gameWindow.getWidth();
  }

  @Override
  protected int getGameHeight()
  {
    return gameWindow.getHeight();
  }

  @Override
  public void draw( final Graphics2D graphics2D )
  {

  }


  protected void start()
  {
    run();
  }


  protected void updateContent()
  {
    if ( !gameWindow.getBufferStrategy().contentsLost() ) gameWindow.getBufferStrategy().show();
  }
}