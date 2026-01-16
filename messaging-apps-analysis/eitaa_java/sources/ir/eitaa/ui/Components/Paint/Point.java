package ir.eitaa.ui.Components.Paint;

import android.graphics.PointF;

/* loaded from: classes3.dex */
public class Point {
    public boolean edge;
    public double x;
    public double y;
    public double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        return this.x == point.x && this.y == point.y && this.z == point.z;
    }

    Point multiplySum(Point point, double scalar) {
        return new Point((this.x + point.x) * scalar, (this.y + point.y) * scalar, (this.z + point.z) * scalar);
    }

    Point add(Point point) {
        return new Point(this.x + point.x, this.y + point.y, this.z + point.z);
    }

    Point substract(Point point) {
        return new Point(this.x - point.x, this.y - point.y, this.z - point.z);
    }

    Point multiplyByScalar(double scalar) {
        return new Point(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    float getDistanceTo(Point point) {
        return (float) Math.sqrt(Math.pow(this.x - point.x, 2.0d) + Math.pow(this.y - point.y, 2.0d) + Math.pow(this.z - point.z, 2.0d));
    }

    PointF toPointF() {
        return new PointF((float) this.x, (float) this.y);
    }
}
