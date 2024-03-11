package com.github.hanyaeger.tutorial.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.tutorial.App;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PlayAgainButton
        extends TextEntity
        implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private App app;

    public PlayAgainButton(Coordinate2D initialLocation, App app) {
        super(initialLocation, "Play Again");
        setFill(Color.PURPLE);
        setFont(Font.font("Play Again", FontWeight.BOLD, 30));
        this.app = app;
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        app.setActiveScene(1);
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.VIOLET);
        setCursor(Cursor.HAND);
        System.out.println("Muis geinitieerd");
    }

    @Override
    public void onMouseExited(){
        setFill(Color.PURPLE);
        setCursor(Cursor.HAND);
        System.out.println("Muis geinitieerd");
    }

}
