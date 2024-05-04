import javax.swing.*;
import java.awt.Color;

public class Circle {
    private int x;
    private int y;
    private int diameter;
    private Color color;

    public Circle(){
        this.color = Color.BLACK;
        this.diameter = 500;
    }

    public int getX(){
        return x;
    }
    public int getY() {
        return y;
    }
    public int getDiameter() {
        return diameter;
    }
    public Color getColor() {
        return color;
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setDiameter(int diameter){
        this.diameter = diameter;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public void changeTheLocation(){
        this.x = 1 + (int) (Math.random() * 1280);
        this.y = 1 + (int) (Math.random() * 720);
    }
    public void changeTheColor(){
        int r = (int)(Math.random() * 256);
        int g = (int)(Math.random() * 256);
        int b = (int)(Math.random() * 256);
        this.setColor(new Color(r,g,b));
    }

    public void changeDiameter(){
        this.diameter = 1 + (int) (Math.random() * 100);
    }
}
