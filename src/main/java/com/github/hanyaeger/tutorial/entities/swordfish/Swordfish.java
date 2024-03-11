package com.github.hanyaeger.tutorial.entities.swordfish;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.List;
import java.util.Random;

public class Swordfish
        extends DynamicCompositeEntity
        implements SceneBorderCrossingWatcher, Collider, Collided {

    protected Swordfish(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {
        var swordFishSprite = new SwordfishSprite(
                new Coordinate2D(200,200)
        );
        addEntity(swordFishSprite);

        var hitBox = new HitBox(
                new Coordinate2D(200, 200)
        );
        addEntity(hitBox);
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
