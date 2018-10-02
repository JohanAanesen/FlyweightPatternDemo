package Flyweight;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.HashMap;

public class CircleFactory {

    public static final HashMap<Color, Circle> colorHashMap = new HashMap<>(); //Hashmap holds previous Circles

    /**
     * Title: getCircle
     * Desc: Returns circle object
     * @param color Color of the circle
     * @return Circle
     */
    public static Circle getCircle(Color color){

        Circle circle = (Circle)colorHashMap.get(color); //Try and fetch circle with desired color

        if (circle == null){        //Circle with desired color does not exist
            circle = new Circle();  //Creates New Circle
            circle.setFill(color);  //Sets color

            colorHashMap.put(color, circle); //Adds the new Circle with the new color to the map
        }

        return circle;              //Return Circle
    }
}
