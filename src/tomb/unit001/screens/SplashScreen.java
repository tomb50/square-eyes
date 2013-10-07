package tomb.unit001.screens;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenEquation;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.org.apache.bcel.internal.generic.FDIV;
import tomb.unit001.SpriteTween;
import tomb.unit001.Unit001;


/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 03/10/2013 Time: 17:34
 */
public class SplashScreen implements Screen
{
  Texture splashTexture;
  Sprite splashSprite;
  SpriteBatch spriteBatch;
  Unit001 game;
  TweenManager manager;

  public SplashScreen(Unit001 game)
  {
    this.game = game;
  }


  @Override
  public void render( final float delta )
  {
    Gdx.gl.glClearColor( 0,0,0,1 );
    Gdx.gl.glClear( GL10.GL_COLOR_BUFFER_BIT );
    //Gdx.app.log( Unit001.LOG, "rendering");
    manager.update( delta );

    spriteBatch.begin();
    splashSprite.draw( spriteBatch );
    spriteBatch.end();

  }

  @Override
  public void resize( final int width, final int height )
  {

  }

  @Override
  public void show()
  {
    splashTexture = new Texture( "assets/data/splashscreen.png" );
    splashTexture.setFilter( Texture.TextureFilter.Linear, Texture.TextureFilter.Linear );

    splashSprite = new Sprite( splashTexture );
    splashSprite.setColor( 1,1,1,0 );


    spriteBatch = new SpriteBatch(  );



    Tween.registerAccessor( Sprite.class, new SpriteTween() );

    manager = new TweenManager();

    Tween.to(splashSprite,SpriteTween.ALPHA,3f).target( 1 ).ease( TweenEquations.easeInOutQuad ).start(manager);



  }

  @Override
  public void hide()
  {

  }

  @Override
  public void pause()
  {

  }

  @Override
  public void resume()
  {

  }

  @Override
  public void dispose()
  {

  }
}
