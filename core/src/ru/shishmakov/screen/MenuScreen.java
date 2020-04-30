package ru.shishmakov.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.shishmakov.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;

    private Vector2 position;
    private Vector2 touch;
    private Vector2 speed;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        position = new Vector2();
        touch = new Vector2();
        speed = new Vector2();
    }


    @Override
    public void render(float delta) {
        super.render(delta);
        speed.set(touch).nor();
        if (position.len() <= touch.len()) position.add(speed);
        batch.begin();
        batch.draw(img, position.x, position.y);
        batch.end();
    }

    @Override
    public void dispose() {
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        return super.touchDown(screenX, screenY, pointer, button);
    }

}
