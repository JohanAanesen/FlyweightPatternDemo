package Flyweight;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.HashMap;

public class CircleFactory {

    public static final HashMap<Color, Circle> colorHashMap = new HashMap<>();

    public static Circle getCircle(Color color){

        Circle circle = (Circle)colorHashMap.get(color);

        if (circle == null){
            circle = new Circle();
            circle.setFill(color);

            colorHashMap.put(color, circle);
        }

        return circle;
    }
}
