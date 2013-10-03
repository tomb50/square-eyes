package tomb.rough.tests;

import tomb.rough.game.AppletAbstractGame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 28/09/2013 Time: 12:28
 */
public class KeyTestApplet extends AppletAbstractGame implements KeyListener
{

  private String mess = null;
  public void init()
  {
    super.init();
    gameWindow.setFocusTraversalKeysEnabled( false );
    gameWindow.addKeyListener( this );
    mess = "press escape to exit";

  }

  public synchronized void draw( final Graphics2D graphics2D )
  {
   graphics2D.setColor( gameWindow.getBackground() );
   graphics2D.fillRect( 0,0,getGameWidth(),getGameHeight() );
    graphics2D.setColor( gameWindow.getForeground() );
    graphics2D.drawString( mess,100,100 );
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
    if(keyCode == KeyEvent.VK_ESCAPE){
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
}
