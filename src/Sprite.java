import java.awt.*;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 25/09/2013 Time: 17:07
 */
public class Sprite
{

  private Animation a;

  public float getX()
  {
    return x;
  }

  public void setX( final float x )
  {
    this.x = x;
  }

  public float getY()
  {
    return y;
  }

  public void setY( final float y )
  {
    this.y = y;
  }

  public float getVx()
  {
    return vx;
  }

  public void setVx( final float vx )
  {
    this.vx = vx;
  }

  public float getVy()
  {
    return vy;
  }

  public void setVy( final float vy )
  {
    this.vy = vy;
  }

  private float x;
  private float y;
  private float vx;
  private float vy;

  public Sprite(Animation a)
  {
    this.a = a;
  }


  public void update(long timePassed)
  {
    x += vx * timePassed;
    y += vy * timePassed;
    a.update( timePassed );
  }

  public int getWidth()
  {
    return a.getImage().getWidth( null );
  }

  public int getHeight()
  {
    return a.getImage().getHeight( null );
  }

  public Image getImage()
  {
    return a.getImage();
  }

}
