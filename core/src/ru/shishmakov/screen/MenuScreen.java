package ru.shishmakov.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.shishmakov.base.BaseScreen;
import ru.shishmakov.math.Rect;
import ru.shishmakov.sprite.BackGround;
import ru.shishmakov.sprite.Logo;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Texture bg;

    private Vector2 position;

    private BackGround backGround;

    private Logo logo;


    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        img = new Texture("badlogic.jpg");
        position = new Vector2();
        backGround = new BackGround(bg);
        logo = new Logo(img);
    }

    @Override
    public void resize(Rect worldBounds) {
        backGround.resize(worldBounds);
        logo.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    @Override
    public void dispose() {
        bg.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        logo.touchDown(touch,pointer,button);
        return false;
    }
    private void update(float delta){
        logo.update(delta);
    }

    private void draw(){
        batch.begin();
        backGround.draw(batch);
        logo.draw(batch);
        batch.end();
    }


}
