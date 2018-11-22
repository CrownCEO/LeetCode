package RejectSampling;

import java.util.Random;

/**
 *
 * Given the radius and x-y positions of the center of a circle, write a function randPoint which generates a uniform random point in the circle.

 Note:

 input and output values are in floating-point.
 radius and x-y position of the center of the circle is passed into the class constructor.
 a point on the circumference of the circle is considered to be in the circle.
 randPoint returns a size 2 array containing x-position and y-position of the random point, in that order.
 *
 * @author Mr.Bao
 * @create 2018-10-11-21:27
 * @since 1.0.0
 */
public class No478GenerateRandomPointinaCircle {

    double radius,x,y;

    public No478GenerateRandomPointinaCircle(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x = x_center;
        this.y = y_center;
    }

    public double[] randPoint() {
        double x1 = this.x - radius;
        double y1 = this.y + radius;
        double x2 = this.x + radius;
        double y2 = this.y - radius;


        double[] result = new double[2];

        while(true){
            double x = Math.random() * (x2 - x1) + x1;
            double y = Math.random() * (y1 - y2) + y2;
            if( this.radius *this.radius>=Math.pow(x - this.x,2) + Math.pow(y - this.y,2)){
                result[0] = x;
                result[1] = y;

                return result;
            }
        }


    }
}
