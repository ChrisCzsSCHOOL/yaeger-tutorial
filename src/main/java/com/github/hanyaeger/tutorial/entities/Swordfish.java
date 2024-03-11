package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.List;
import java.util.Random;

public class Swordfish
        extends DynamicSpriteEntity
        implements SceneBorderCrossingWatcher, Collider, Collided {
    public Swordfish(Coordinate2D location) {
        super("sprites/swordfish.png", location);
        setMotion(10, 270d);
    }



    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        setAnchorLocationX(getSceneWidth());
        setAnchorLocationY(new Random().nextInt((int) getSceneHeight()- 81));
    }

    @Override
    public void onCollision(List<Collider> list) {

        System.out.println("Collided! Swordfish");

    }
}
