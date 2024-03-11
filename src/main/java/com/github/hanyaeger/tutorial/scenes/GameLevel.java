package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.Empty;
import com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.entities.Swordfish;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.nio.channels.spi.AbstractInterruptibleChannel;

public class GameLevel extends DynamicScene {
    private Empty empty;

    public GameLevel(Empty empty) {
        this.empty = empty;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/waterworld.mp3");
        setBackgroundImage("backgrounds/background2.jpg");
    }

    @Override
    public void setupEntities() {
        // add swordfish
        var swordFish = new Swordfish(
                new Coordinate2D(200, 200)
        );
        addEntity(swordFish);

        // add hanny
        var hanny = new Hanny(
                new Coordinate2D(0,0), new HealthText(new Coordinate2D(0, getWidth() / 2)),
                empty
        );
        addEntity(hanny);

        // add health
        var health = new HealthText(
                new Coordinate2D(getWidth() / 2, 20)
        );
        addEntity(health);
    }
}
