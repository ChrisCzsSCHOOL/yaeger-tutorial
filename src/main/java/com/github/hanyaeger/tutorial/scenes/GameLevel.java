package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.tutorial.App;
import com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.entities.Swordfish;
import com.github.hanyaeger.tutorial.entities.text.HealthText;

public class GameLevel
        extends DynamicScene {
    private App app;

    public GameLevel(App app) {
        this.app = app;
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

        // add health
        var health = new HealthText(
                new Coordinate2D(getWidth() / 2 - 50, 20)
        );
        addEntity(health);

        // add hanny
        var hanny = new Hanny(
                new Coordinate2D(0,0), health,
                app
        );
        addEntity(hanny);


    }
}
