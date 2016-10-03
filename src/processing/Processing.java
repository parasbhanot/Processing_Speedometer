package processing;

/**
 * Created by parasbhanot on 5/7/2015.
 */


import processing.core.*;

public class Processing extends PApplet {


    float x1;
    float y1;

    float x=300f; // centre x
    float y=200f; // centre y

    float r=100f; // radius

    int innerRadius =65; // text radius
    int textCounter =80; // text counter

void setup(){

    size(600, 400);
    background(0xFAFAF0); // solarised background
    strokeWeight(2); // at-least 2 but atmost 3
    stroke(127); // grey color
    noFill(); // it must be in in no fill mode
    ellipse(x, y, 200, 200); // height = width =200px
    strokeWeight(2); // define stroke weigth of markers

    for (int i = 0; i <240 ; i+=30) {

        stroke(127);
        //has to use radian function otherwise for-loop variable "i" will not work
        x1=x+r*(cos(radians(30 + i)));
        y1=y-r*(sin(radians(30+i)));
        line(x, y, x1, y1);

    }

    noStroke(); // stroke must be removed
    fill(250, 250, 240); // fill must be background color
    ellipse(x, y, 160, 160); // it will hide the marker lines and align text
    pushMatrix(); // current coordinate system must be saved
    translate(x,y); // it must be called before rotate with centre
    rotate(-PI/3);
    fill(127); // it must be called to set fill of pointer7
    triangle(0,10,0,-10,-70,0);
    ellipse(0,0,20,20); // it must be drawn after triangle
    popMatrix(); // previous coordinate system must be restored

    for (int i = 0; i <240 ; i+=30) {

        x1 = x + innerRadius * (cos(radians(30+i)));
        y1=y- innerRadius *(sin(radians(30+i)));
        stroke(127);
        fill(0, 0, 220);
        //point(x1, y1); // debug text and angle purposes
        textAlign(CENTER,CENTER); // this must be called as mentioned
        text(textCounter,x1,y1);
        textCounter -=10;
    }
}
void referenceLines() {

    stroke(220,0,0,80);
    line(300, 200, 200, 200); // left
    line(300, 200, 400, 200); // right
    line(300,200,300,100); // up
    line(300,200,300,300); //down
    strokeWeight(10);
    point(300,200); // centre point
    noLoop();
}


public void draw(){
    //System.out.println("mouseX = " + mouseX+" mouseY ="+ mouseY);
}

public static void main(String[] args) {

    PApplet.main(new String[]{processing.Processing.class.getName()});
    }

}
