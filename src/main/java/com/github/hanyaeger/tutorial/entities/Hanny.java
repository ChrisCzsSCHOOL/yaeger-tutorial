package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.Empty;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class Hanny extends DynamicSpriteEntity implements KeyListener, SceneBorderCrossingWatcher, Newtonian, Collided, Collider {
    private Empty empty;
    private HealthText healthText;
    private int health = 1;

    public Hanny(Coordinate2D location, HealthText healthText, Empty empty) {
        super("sprites/hanny.png", location, new Size(20,40), 1, 2);

        this.healthText = healthText;
        healthText.setHealthText(health);

        setGravityConstant(0.005);
        setFrictionConstant(0.04);

        this.empty = empty;
    }
    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {
        if (set.contains(KeyCode.A)){
            setMotion(3, 270d);
            setCurrentFrameIndex(2);
        } else if (set.contains(KeyCode.D)){
            setMotion(3, 90d);
            setCurrentFrameIndex(1);
        } else if (set.contains(KeyCode.W)) {
            setMotion(3, 180d);
        } else if (set.contains(KeyCode.S)){
            setMotion(3, 0d);
        } else if (set.isEmpty()) {
            setSpeed(1);
        }
    }
    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setSpeed(0);

        switch (sceneBorder){
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }

    @Override
    public void onCollision(List<Collider> list) {
        System.out.println("Collision! Hanny");
        setAnchorLocation(
                new Coordinate2D(
                        new Random().nextInt( (int) (getSceneWidth() - getWidth())),
                        new Random().nextInt( (int) (getSceneHeight() - getHeight()))
                )
        );

        health--;
        healthText.setHealthText(health);
        if (health == 0 ){
            empty.setActiveScene(2);
        }
    }
}
