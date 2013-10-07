package tomb.unit001;

import aurelienribon.tweenengine.TweenAccessor;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 03/10/2013 Time: 20:55
 */
public class SpriteTween implements TweenAccessor<Sprite>
{

  public static final int ALPHA = 1;
  @Override
  public int getValues( final Sprite target, final int tweenType, float[] floats )
  {
    switch ( tweenType )
    {
      case ALPHA: floats[0] = target.getColor().a;
        return 1;
      default: return 0;
    }



  }

  @Override
  public void setValues( final Sprite target, final int tweenType, final float[] floats )
  {
    switch(tweenType){
      case ALPHA :   target.setColor(1,1,1,floats[0]);
        break;
    }

  }
}
