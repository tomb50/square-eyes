package tomb.rough.game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 22/09/2013 Time: 21:51
 */
public class ScreenManager
{
  private GraphicsDevice vc;

  public ScreenManager()
  {
    GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
    vc = e.getDefaultScreenDevice();
  }

  public DisplayMode[] getCompatibleDisplayModes()
  {
    return vc.getDisplayModes();
  }

  public DisplayMode findFirstCompatibleMode( DisplayMode[] modes )
  {
    DisplayMode[] goodModes = vc.getDisplayModes();
    for ( int x = 0; x < modes.length; x++ )
    {
      for ( int y = 0; y < goodModes.length; y++ )
      {
        if ( displayModesMatch( modes[x], goodModes[y] ) )
        {
          return modes[x];
        }
      }
    }
    return null; // shouldn't happen
  }

  private boolean displayModesMatch( final DisplayMode mode1, final DisplayMode mode2 )
  {
    if ( mode1.getWidth() != mode2.getWidth() || mode1.getHeight() != mode2.getHeight() )
    {
      return false;
    }
    if ( mode1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI &&
      mode2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && mode1.getBitDepth() != mode2.getBitDepth() )
    {
      return false;
    }
    if ( mode1.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN &&
      mode2.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && mode1.getRefreshRate() != mode2.getRefreshRate() )
    {
      return false;
    }
    return true;
  }

  public DisplayMode getCurrentDisplayMode()
  {
    return vc.getDisplayMode();
  }


  public void setFullScreen( DisplayMode dm )
  {
    JFrame f = new JFrame();
    f.setUndecorated( true );
    f.setIgnoreRepaint( true );
    f.setResizable( false );
    vc.setFullScreenWindow( f );


    if ( dm != null && vc.isDisplayChangeSupported() )
    {
      try
      {
        vc.setDisplayMode( dm );
      }
      catch ( Exception e )
      {
        //do nothing
      }
    }
    f.createBufferStrategy( 2 );
  }

  public Graphics2D getGraphics()
  {
    Window w = vc.getFullScreenWindow();
    if(w !=null)
    {
      BufferStrategy s = w.getBufferStrategy();
      return (Graphics2D)s.getDrawGraphics();
    }else{return null;}
  }

  public void update()
  {
    Window w = vc.getFullScreenWindow();
    if(w != null)
    {
      BufferStrategy s = w.getBufferStrategy();
      if(!s.contentsLost()){s.show();}
    }
  }

  public Window getFullScreenWindow() {
    return vc.getFullScreenWindow();
  }

  public int getWidth()
  {
    Window w = vc.getFullScreenWindow();
    if(w !=null) return w.getWidth();
    else return 0;
  }

  public int getHeight()
  {
    Window w = vc.getFullScreenWindow();
    if(w !=null) return w.getHeight();
    else return 0;
  }

 public void restoreScreen()  {
   Window w = vc.getFullScreenWindow();
   if(w!=null)
   {
     w.dispose();
   }
   vc.setFullScreenWindow( null );
 }

  public BufferedImage createCompatibleImage(int w, int h, int t)
  {
    Window gameWindow = vc.getFullScreenWindow();
    if( gameWindow !=null)
    {
      GraphicsConfiguration gc = gameWindow.getGraphicsConfiguration();
      return gc.createCompatibleImage( w,h,t );
    }
    return null;
  }
}
