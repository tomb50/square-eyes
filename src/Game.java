import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 23/09/2013 Time: 19:27
 */
public abstract class Game
{
  protected Image bg;
  protected Animation a;
  protected Sprite sprite;
  protected boolean running;

  protected abstract void start();

  protected abstract void updateContent();

  protected abstract Graphics getGraphics();


  protected void run()
  {
    try
    {
      init();
      gameLoop();
    }
    catch ( Exception ignored )
    {
    }

    loadImages();
    gameLoop();
  }

  protected abstract void init();


  public void stop()
  {
    running = false;
  }

  protected void loadImages()
  {
    bg = new ImageIcon( "/Users/tombeadman/Downloads/red.png" ).getImage();

    a = new Animation();
    a.addScene( new ImageIcon( "/Users/tombeadman/Downloads/Numbers-1-filled-icon.png" ).getImage(), 250 );
    a.addScene( new ImageIcon( "/Users/tombeadman/Downloads/Numbers-2-filled-icon.png" ).getImage(), 500 );
    a.addScene( new ImageIcon( "/Users/tombeadman/Downloads/Numbers-3-filled-icon.png" ).getImage(), 750 );
    a.addScene( new ImageIcon( "/Users/tombeadman/Downloads/Numbers-4-filled-icon.png" ).getImage(), 1000 );

    sprite = new Sprite( a );
    sprite.setVx( 0.3f );
    sprite.setVy( 0.3f );
  }


  protected void gameLoop()
  {

    long startingTime = System.currentTimeMillis();
    long cumTime = startingTime;
    while ( running )
    {
      long timePassed = System.currentTimeMillis() - cumTime;
      cumTime += timePassed;
      updateSprite( timePassed );

      Graphics2D graphics = (Graphics2D) getGraphics();
      draw( graphics );
      graphics.dispose();
      updateContent();

      try
      {
        Thread.sleep( 20 );
      }
      catch ( Exception ignored )
      {
      }

    }
    System.exit( 0 );

  }


  protected void draw( final Graphics g )
  {
    g.drawImage( bg, 0, 0, null );
    g.drawImage( sprite.getImage(), Math.round( sprite.getX() ), Math.round( sprite.getY() ), null );
  }


  protected void updateSprite( final long timePassed )
  {
    if ( sprite.getX() < 0 )
    {
      sprite.setVx( Math.abs( sprite.getVx() ) );
    }
    else if ( sprite.getX() + sprite.getWidth() > getGameWidth() )
    {
      sprite.setVx( -Math.abs( sprite.getVx() ) );
    }


    if ( sprite.getY() < 0 )
    {
      sprite.setVy( Math.abs( sprite.getVy() ) );
    }
    else if ( sprite.getY() + sprite.getHeight() > getGameHeight() )
    {
      sprite.setVy( -Math.abs( sprite.getVy() ) );
    }
  }

  protected abstract int getGameWidth();

  protected abstract int getGameHeight();

  public void update(long timePassed)
  {

  }

  public abstract void draw(Graphics2D graphics2D);
}
