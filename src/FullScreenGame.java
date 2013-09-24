import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 23/09/2013 Time: 19:27
 */
public class FullScreenGame extends Game
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
    try{
      DisplayMode dm = sm.findFirstCompatibleMode( DISPLAY_MODES );
      sm.setFullScreen( dm );
      run();

    }finally{
      sm.restoreScreen();
    }
  }

  @Override
  protected void update()
  {
   sm.update();
  }



  protected Graphics getGraphics()
  {
    return sm.getGraphics();
  }




}
