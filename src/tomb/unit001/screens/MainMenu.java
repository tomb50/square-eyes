package tomb.unit001.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import tomb.unit001.Unit001;

import static com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import static com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 07/10/2013 Time: 17:27
 */
public class MainMenu implements Screen
{
  Unit001 game;
  Stage stage;
  BitmapFont blackFont;
  BitmapFont whiteFont;
  TextureAtlas atlas;
  Skin skin;
  SpriteBatch batch;
  TextButton button;
  Label label;

  public MainMenu( final Unit001 game )
  {
    this.game = game;
  }

  @Override
  public void render( final float delta )
  {
    Gdx.gl.glClearColor( 0, 0, 0, 1 );
    Gdx.gl.glClear( GL10.GL_COLOR_BUFFER_BIT );

    stage.act( delta );

    batch.begin();
    stage.draw();
    whiteFont.draw( batch, "Unit001", Gdx.graphics.getWidth() / 2 - 15, Gdx.graphics.getHeight() / 2 - 15 );
    batch.end();
  }

  @Override
  public void resize( final int width, final int height )
  {
    if ( stage == null ) stage = new Stage( width, height, true );
    stage.clear();

    Gdx.input.setInputProcessor( stage );
    TextButtonStyle style = new TextButtonStyle();
    style.up = skin.getDrawable( "buttonnormal" );
    style.down = skin.getDrawable( "buttonpressed" );
    style.font = blackFont;

    button = new TextButton( "Press me!", style );
    button.setWidth( 400 );
    button.setHeight( 100 );
    button.setX( ( Gdx.graphics.getWidth() - button.getWidth() ) / 2 );
    button.setY( ( Gdx.graphics.getHeight() - button.getHeight() ) / 2 );

    button.addListener( new InputListener()
    {
      public void touchUp( InputEvent event, float x, float y, int pointer, int button )
      {
        System.out.println( "Main menu button pressed: up" );
        game.setScreen( new Game( game ) );
      }

      public boolean touchDown( InputEvent event, float x, float y, int pointer, int button )
      {
        System.out.println( "Main menu button pressed down!" );
        return true;
      }
    } );

    LabelStyle labelStyle = new LabelStyle( whiteFont, Color.WHITE );
    label = new Label( "Unit001", labelStyle );
    label.setX( 0 );
    label.setY( Gdx.graphics.getHeight() / 2 + 100 );
    label.setWidth( width );
    label.setAlignment( Align.center );


    stage.addActor( button );
    stage.addActor( label );
  }

  @Override
  public void show()
  {
    batch = new SpriteBatch();

    atlas = new TextureAtlas( "assets/data/button.pack" );
    skin = new Skin();
    skin.addRegions( atlas );
    whiteFont = new BitmapFont( Gdx.files.internal( "assets/data/whitefont.fnt" ), false );
    blackFont = new BitmapFont( Gdx.files.internal( "assets/data/font.fnt" ), false );
  }

  @Override
  public void hide()
  {
    dispose();
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
    batch.dispose();
    skin.dispose();
    atlas.dispose();
    whiteFont.dispose();
    blackFont.dispose();
    stage.dispose();
  }
}
