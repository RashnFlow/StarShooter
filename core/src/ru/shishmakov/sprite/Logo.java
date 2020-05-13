package ru.shishmakov.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.shishmakov.base.Sprite;
import ru.shishmakov.math.Rect;

public class Logo extends Sprite {

    private static final float SPEED_LEN = 0.1F;

    private Vector2 touch;
    private Vector2 speed;
    private Vector2 common;

    public Logo(Texture region) {
        super(new TextureRegion(region));
        touch = new Vector2();
        speed = new Vector2();
        common = new Vector2();
    }

    @Override
    public void update(float delta) {
        common.set(touch);
        if (common.sub(pos).len() > SPEED_LEN) pos.add(speed);
        else {
            pos.set(touch);
            speed.setZero();
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.3f);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch = touch;
        speed.set(touch.sub(pos)).setLength(SPEED_LEN);
        return false;
    }
}
