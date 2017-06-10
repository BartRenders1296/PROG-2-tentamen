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

    public void move() {
        System.out.println("asdf");
    }

    public double randomRelX(){
        return new Random().nextInt(100);
    }

    public double randomRelY(){
        return new Random().nextInt(50) + 51;
    }

    public TreeSize getSize() {
        return size;
    }

    public void setSize() {
        if(getRelY() >= 50 && getRelY() < 60){
            this.size = TreeSize.S;
        } else if(getRelY() >= 60 && getRelY() < 70){
            this.size = TreeSize.M;
        } else if(getRelY() >= 70 && getRelY() < 80){
            this.size = TreeSize.L;
        } else if(getRelY() >= 80 && getRelY() < 90){
            this.size = TreeSize.XL;
        } else if(getRelY() >= 90 && getRelY() <= 100){
            this.size = TreeSize.XXL;
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
}
