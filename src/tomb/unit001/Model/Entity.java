package tomb.unit001.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 17/10/2013 Time: 15:25
 */
public abstract class Entity
{


  protected Entity( final Vector2 position, final float width, final float hieght )
  {
    this.position = position;
    this.width = width;
    this.hieght = hieght;
    bounds = new Rectangle( position.x, position.y, width, hieght );
  }

  protected Vector2 position;
  protected float width;
  protected float hieght;
  protected Rectangle bounds;

  public Vector2 getPosition()
  {
    return position;
  }

  public void setPosition( final Vector2 position )
  {
    this.position = position;
  }

  public float getWidth()
  {
    return width;
  }

  public void setWidth( final float width )
  {
    this.width = width;
  }

  public float getHieght()
  {
    return hieght;
  }

  public void setHieght( final float hieght )
  {
    this.hieght = hieght;
  }


  Rectangle getBounds()
  {
    return bounds;
  }


  void setBounds( Rectangle bounds )
  {
    this.bounds = bounds;
  }
}
