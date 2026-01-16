package ir.resaneh1.iptv.helper;

import android.graphics.RectF;

/* loaded from: classes3.dex */
public class StoryUtils {
    static boolean onSegment(MyPoint myPoint, MyPoint myPoint2, MyPoint myPoint3) {
        return myPoint2.x <= Math.max(myPoint.x, myPoint3.x) && myPoint2.x >= Math.min(myPoint.x, myPoint3.x) && myPoint2.y <= Math.max(myPoint.y, myPoint3.y) && myPoint2.y >= Math.min(myPoint.y, myPoint3.y);
    }

    static int orientation(MyPoint myPoint, MyPoint myPoint2, MyPoint myPoint3) {
        float f = myPoint2.y;
        float f2 = f - myPoint.y;
        float f3 = myPoint3.x;
        float f4 = myPoint2.x;
        float f5 = (f2 * (f3 - f4)) - ((f4 - myPoint.x) * (myPoint3.y - f));
        if (f5 == 0.0f) {
            return 0;
        }
        return f5 > 0.0f ? 1 : 2;
    }

    static boolean doIntersect(MyPoint myPoint, MyPoint myPoint2, MyPoint myPoint3, MyPoint myPoint4) {
        int iOrientation = orientation(myPoint, myPoint2, myPoint3);
        int iOrientation2 = orientation(myPoint, myPoint2, myPoint4);
        int iOrientation3 = orientation(myPoint3, myPoint4, myPoint);
        int iOrientation4 = orientation(myPoint3, myPoint4, myPoint2);
        if (iOrientation != iOrientation2 && iOrientation3 != iOrientation4) {
            return true;
        }
        if (iOrientation == 0 && onSegment(myPoint, myPoint3, myPoint2)) {
            return true;
        }
        if (iOrientation2 == 0 && onSegment(myPoint, myPoint4, myPoint2)) {
            return true;
        }
        if (iOrientation3 == 0 && onSegment(myPoint3, myPoint, myPoint4)) {
            return true;
        }
        return iOrientation4 == 0 && onSegment(myPoint3, myPoint2, myPoint4);
    }

    public static boolean isLineAndRectIntersects(RectF rectF, MyPoint myPoint, MyPoint myPoint2) {
        float f = rectF.top;
        float f2 = rectF.left;
        float f3 = rectF.bottom;
        float f4 = rectF.right;
        if (doIntersect(myPoint, myPoint2, new MyPoint(f2, f), new MyPoint(f4, f3))) {
            return true;
        }
        return doIntersect(myPoint, myPoint2, new MyPoint(f2, f3), new MyPoint(f4, f));
    }

    public static class MyPoint {
        public float x;
        public float y;

        public MyPoint(int i, float f, float f2) {
            this.x = f;
            this.y = f2;
        }

        public MyPoint(float f, float f2) {
            this.x = f;
            this.y = f2;
        }
    }
}
