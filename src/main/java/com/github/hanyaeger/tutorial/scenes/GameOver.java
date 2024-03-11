package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.App;
import com.github.hanyaeger.tutorial.entities.buttons.PlayAgainButton;
import com.github.hanyaeger.tutorial.entities.buttons.QuitButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOver extends StaticScene {

    private App app;
    public GameOver(App app) {
        this.app = app;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/pop.mp3");
        setBackgroundImage("backgrounds/background2.jpg");
    }

    @Override
    public void setupEntities() {
        var gameOverText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2 - 50),
                "Game Over");
        gameOverText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameOverText.setFill(Color.WHITE);
        gameOverText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(gameOverText);

        var playAgainButton = new PlayAgainButton(
                new Coordinate2D(getWidth() / 2 - 75, getHeight() / 2), app
        );
        addEntity(playAgainButton);

        var quitButton = new QuitButton(
                new Coordinate2D(getWidth() / 2 - 75, getHeight() / 2 + 50), app
        );
        addEntity(quitButton);
    }
}
