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

        var time1 = System.currentTimeMillis();
        MemoryUsage heapMemoryUsage1 = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        var mem1 = heapMemoryUsage1.getUsed();

        for (int i = 0; i < 100000; i++) {
            Color color = getRandColor();
            circles[i] = new Circle(); //Ny sirkel til hvert objekt

            circles[i].setFill(color);
            circles[i].setCenterX(rand.nextDouble()*600);
            circles[i].setCenterY(rand.nextDouble()*600);
            circles[i].setRadius(rand.nextDouble()*5);

            gc.strokeOval(circles[i].getCenterX(), circles[i].getCenterY(), circles[i].getRadius(), circles[i].getRadius());
            gc.setFill(circles[i].getFill());
            gc.fillOval(circles[i].getCenterX(), circles[i].getCenterY(), circles[i].getRadius(), circles[i].getRadius());
        }

        var time2 = System.currentTimeMillis();
        MemoryUsage heapMemoryUsage2 = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        var mem2 = heapMemoryUsage2.getUsed();

        System.out.println("Time: "+(time2-time1) + " ms");
        System.out.println("Memory: "+(mem2-mem1)/1000000 + " MB");
    }

    private Color getRandColor(){
        Random rand = new Random();
        switch (rand.nextInt(5)){
            case 0: return Color.RED;
            case 1: return Color.BLUE;
            case 2: return Color.YELLOW;
            case 3: return Color.GREEN;
            case 4: return Color.PINK;
        }

        return Color.RED;
    }

}
