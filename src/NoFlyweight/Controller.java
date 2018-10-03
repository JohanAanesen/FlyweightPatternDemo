package NoFlyweight;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.util.Random;

public class Controller {

    private Circle[] circles = new Circle[100000];

    @FXML
    private Canvas canvas;

    @FXML
    void draw(MouseEvent event) {
        Random rand = new Random();
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Color[] colors = new Color[]{Color.MEDIUMVIOLETRED, Color.CORNFLOWERBLUE, Color.AQUA, Color.GREENYELLOW, Color.HOTPINK};

        //TIME AND MEMORY LOG START
        var time1 = System.currentTimeMillis();
        MemoryUsage heapMemoryUsage1 = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        var mem1 = heapMemoryUsage1.getUsed();

        for (int i = 0; i < 100000; i++) {
            Color color = colors[rand.nextInt(5)];  //Random Color

            circles[i] = new Circle();                      //New Circle
            circles[i].setFill(color);                      //Set color

            circles[i].setCenterX(rand.nextDouble()*600);   //Random location x
            circles[i].setCenterY(rand.nextDouble()*600);   //Random location y
            circles[i].setRadius(rand.nextDouble()*25);     //Random radius

            //DRAWING CIRCLE TO CANVAS
            gc.strokeOval(circles[i].getCenterX(), circles[i].getCenterY(), circles[i].getRadius(), circles[i].getRadius());
            gc.setFill(circles[i].getFill());
            gc.fillOval(circles[i].getCenterX(), circles[i].getCenterY(), circles[i].getRadius(), circles[i].getRadius());
        }

        //TIME AND MEMORY LOG END
        var time2 = System.currentTimeMillis();
        MemoryUsage heapMemoryUsage2 = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        var mem2 = heapMemoryUsage2.getUsed();

        //Printing results
        System.out.println("Time: "+(time2-time1) + " ms");
        System.out.println("Memory: "+(mem2-mem1)/1000000 + " MB");
    }

}
