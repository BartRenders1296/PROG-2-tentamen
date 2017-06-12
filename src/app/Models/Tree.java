package app.Models;

import app.Enums.TreeColor;
import app.Enums.TreeSize;
import app.Enums.TreeType;
import javafx.scene.paint.Color;

import java.util.Random;

/**
 * Created by Bart Renders on 10-6-2017.
 */
public class Tree {

    private TreeSize size;
    private TreeType type;
    private double relX;
    private double relY;
    private double speed;

    public void move() {
        this.relX = relX + speed;
        if(this.relX >= 100){
            this.relX = 0;
        }
    }

    public double randomRelX(){
        return new Random().nextInt(100);
    }

    public double randomRelY(){
        return new Random().nextInt(50) + 51;
    }

    public TreeSize getTreeSize() {
        return size;
    }

    public void setSize() {
        if(getRelY() >= 50 && getRelY() < 60){
            this.size = TreeSize.S;
            speed = 0.05;
        } else if(getRelY() >= 60 && getRelY() < 70){
            this.size = TreeSize.M;
            speed = 0.15;
        } else if(getRelY() >= 70 && getRelY() < 80){
            this.size = TreeSize.L;
            speed = 0.25;
        } else if(getRelY() >= 80 && getRelY() < 90){
            this.size = TreeSize.XL;
            speed = 0.35;
        } else if(getRelY() >= 90 && getRelY() <= 100){
            this.size = TreeSize.XXL;
            speed = 0.45;
        }
    }

    public TreeType getType() {
        return type;
    }

    public void setType(TreeType type) {
        this.type = type;
    }

    public double getRelX() {
        return relX;
    }

    public void setRelX(double relX) {
        this.relX = relX;
    }

    public double getRelY() {
        return relY;
    }

    public void setRelY(double relY) {
        this.relY = relY;
    }

    public Color getColor() {
        return TreeColor.getColor(type, size).getColor();
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
