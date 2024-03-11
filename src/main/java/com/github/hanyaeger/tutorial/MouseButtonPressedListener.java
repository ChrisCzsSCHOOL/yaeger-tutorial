package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;

public interface MouseButtonPressedListener {

    void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D);
}
