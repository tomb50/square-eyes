package tomb.rough.tests;

import tomb.rough.game.AppletAbstractGame;

import java.awt.*;
import java.awt.event.*;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 28/09/2013 Time: 15:12
 */
public class AppletMouseTest extends AppletAbstractGame
  implements KeyListener, MouseMotionListener, MouseListener, MouseWheelListener
{

  private String mess = "";

  public void init()
  {
    super.init();
    gameWindow.addMouseListener( this );
    gameWindow.addMouseMotionListener( this );
    gameWindow.addMouseWheelListener( this );
    gameWindow.addKeyListener( this );
  }

  public synchronized void draw( Graphics2D g )
  {
    g.setColor( gameWindow.getBackground() );
    g.fillRect( 0, 0, gameWindow.getWidth(), gameWindow.getHeight() );
    g.setColor( gameWindow.getForeground() );
    g.drawString( mess, 100, 100 );
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
      mess = "Pressed: " + KeyEvent.getKeyText( keyCode );
      e.consume();
    }
  }

  @Override
  public void keyReleased( final KeyEvent e )
  {
    mess = "Released: " + KeyEvent.getKeyText( e.getKeyCode() );
    e.consume();
  }

  @Override
  public void mouseClicked( final MouseEvent e )
  {

  }

  @Override
  public void mousePressed( final MouseEvent e )
  {
    mess = "Mouse pressed";
  }

  @Override
  public void mouseReleased( final MouseEvent e )
  {
    mess = "mouse released";
  }

  @Override
  public void mouseEntered( final MouseEvent e )
  {

  }

  @Override
  public void mouseExited( final MouseEvent e )
  {

  }

  @Override
  public void mouseDragged( final MouseEvent e )
  {

  }

  @Override
  public void mouseMoved( final MouseEvent e )
  {
    mess = "mouse moved";
  }

  @Override
  public void mouseWheelMoved( final MouseWheelEvent e )
  {

  }
}
