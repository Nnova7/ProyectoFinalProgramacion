package Math;

public class Vector2D {
    private double x, y;

    public Vector2D(double x, double y) {
        this.x=x;
        this.y=y;
    }//constructor

    public Vector2D() {
        x=0;
        y=0;
    }//constructor

    /// //////////////////////
    public Vector2D(Vector2D v) {
        this.x = v.x;
        this.y = v.y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getMagnitude() {
        return Math.sqrt(x*x + y*y);
    }

    public Vector2D setDirection(double angle) {
        double magnitude = getMagnitude();
        return new Vector2D(magnitude*Math.cos(angle), magnitude*Math.sin(angle));
    }
    public Vector2D add(Vector2D v) {
        return new Vector2D(x+v.getX(), y+v.getY());
    }

    public Vector2D scale(double value) {
        return new Vector2D(x*value, y*value);
    }

    public Vector2D limit(double aux){
        if(getMagnitude()>aux){
            return this.normalize().scale(aux);
        }
        return this;
    }

    public double getAngle(){
        return Math.asin(y/getMagnitude());
    }

    public Vector2D normalize() {
        double magnitude = getMagnitude();
        return new Vector2D(x/magnitude, y/magnitude);
    }

    public Vector2D substract(Vector2D v) {
        return new Vector2D(x-v.getX(), y-v.getY());
    }
}//vector2D class
