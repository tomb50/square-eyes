import sun.java2d.SunGraphics2D;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 23/09/2013 Time: 19:27
 */
public class AppletGame extends Game
{

  private GameWindow gameWindow;

  public AppletGame()
  {
    gameWindow = new GameWindow();
  }


  protected Graphics getGraphics()
  {

    return gameWindow.getBufferStrategy().getDrawGraphics();
  }


  protected void start()
  {

    run();
  }


  protected void update()
  {
    if ( !gameWindow.getBufferStrategy().contentsLost() ) gameWindow.getBufferStrategy().show();
  }
}