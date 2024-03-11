package com.github.hanyaeger.tutorial.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.tutorial.Empty;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class QuitButton
        extends TextEntity
        implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private Empty empty;

    public QuitButton(Coordinate2D initialLocation, Empty empty) {
        super(initialLocation, "QUIT");
        setFill(Color.RED);
        setFont(Font.font("QUIT", FontWeight.BOLD, 30));
        this.empty = empty;
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        empty.quit();
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.DARKRED);
        setCursor(Cursor.HAND);
        System.out.println("Muis geinitieerd");
    }

    @Override
    public void onMouseExited(){
        setFill(Color.RED);
        setCursor(Cursor.HAND);
        System.out.println("Muis geinitieerd");
    }

}
