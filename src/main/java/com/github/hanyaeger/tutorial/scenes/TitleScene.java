package com.github.hanyaeger.tutorial.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.App;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import com.github.hanyaeger.tutorial.entities.buttons.StartButton;

public class TitleScene extends StaticScene {

    private App app;

    public TitleScene(App app) {
        this.app = app;
    }

    @Override
    public void setupScene(){
        setBackgroundAudio("audio/ocean.mp3");
        setBackgroundImage("backgrounds/background1.jpg");
    }
    @Override
    public void setupEntities() {
        var waterwoldText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Waterwereld");
        waterwoldText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        waterwoldText.setFill(Color.WHITE);
        waterwoldText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(waterwoldText);

        var StartButton = new StartButton(new Coordinate2D(300, 500), app);
        addEntity(StartButton);
    }
}
