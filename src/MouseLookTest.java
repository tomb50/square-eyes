import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 28/09/2013 Time: 15:31
 */
public class MouseLookTest extends AppletGame implements KeyListener, MouseMotionListener
{

  private Image bg;
  private Robot robot;
  private Point mouse;
  private Point centre;
  private Point image;
  private boolean centering;

  public void init()
  {
    super.init();
    mouse = new Point();
    centre = new Point();
    image = new Point();
    centering = false;

    try
    {
      robot = new Robot();
      recenterMouse();
      mouse.x = centre.x;
      mouse.y = centre.y;
    }
    catch ( Exception e )
    {
    }

    gameWindow.addMouseMotionListener( this );
    gameWindow.addKeyListener( this );
    bg = new ImageIcon( "/Users/tombeadman/Downloads/MH3U_NA_Boxart.jpg" ).getImage().getScaledInstance( gameWindow.getWidth(),
                                                                                              gameWindow.getHeight(),
                                                                                              Image.SCALE_DEFAULT );
  }

  public synchronized void draw( Graphics2D g )
  {
    int w = gameWindow.getWidth();
    int h = gameWindow.getHeight();

    image.x %= w;
    image.y %= h;
    if ( image.x < 0 ) image.x += w;
    if ( image.y < 0 ) image.y += h;

    g.drawImage( bg, image.x, image.y, null );
    g.drawImage( bg, image.x - w, image.y, null );
    g.drawImage( bg, image.x, image.y - h, null );
    g.drawImage( bg, image.x - w, image.y - h, null );
  }

  private synchronized void recenterMouse()
  {
    if ( robot != null && gameWindow.isShowing() )
    {
      centre.x = gameWindow.getWidth() / 2;
      centre.y = gameWindow.getHeight() / 2;
      SwingUtilities.convertPointToScreen( centre, gameWindow );
      centering = true;
      robot.mouseMove( centre.x, centre.y );
    }
  }

  @Override
  public void keyTyped( final KeyEvent e )
  {
    e.consume();
  }

  @Override
  public void keyPressed( final KeyEvent e )
  {
    int keyCode = e.getKeyCode();
    if ( keyCode == KeyEvent.VK_ESCAPE )
    {
      stop();
    }
    else
    {
      e.consume();
    }
  }

  @Override
  public void keyReleased( final KeyEvent e )
  {

    e.consume();
  }

  @Override
  public void mouseDragged( final MouseEvent e )
  {
    mouseMoved( e );
  }

  @Override
  public void mouseMoved( final MouseEvent e )
  {
    if ( centering && centre.x == e.getX() && centre.y == e.getY() )
    {
      centering = false;
    }
    else
    {
      int dx = e.getX() - mouse.x;
      int dy = e.getY() - mouse.y;
      image.x += dx;
      image.y += dy;
      recenterMouse();
    }
    mouse.x = e.getX();
    mouse.y = e.getY();
  }
}
