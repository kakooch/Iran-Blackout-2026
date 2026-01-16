package ir.eitaa.ui.Components.Paint;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.Landmark;
import ir.eitaa.ui.Components.Size;

/* loaded from: classes3.dex */
public class PhotoFace {
    private float angle;
    private ir.eitaa.ui.Components.Point chinPoint;
    private ir.eitaa.ui.Components.Point eyesCenterPoint;
    private float eyesDistance;
    private ir.eitaa.ui.Components.Point foreheadPoint;
    private ir.eitaa.ui.Components.Point mouthPoint;
    private float width;

    public PhotoFace(Face face, Bitmap sourceBitmap, Size targetSize, boolean sideward) {
        ir.eitaa.ui.Components.Point pointTransposePoint = null;
        ir.eitaa.ui.Components.Point pointTransposePoint2 = null;
        ir.eitaa.ui.Components.Point pointTransposePoint3 = null;
        ir.eitaa.ui.Components.Point pointTransposePoint4 = null;
        for (Landmark landmark : face.getLandmarks()) {
            PointF position = landmark.getPosition();
            int type = landmark.getType();
            if (type == 4) {
                pointTransposePoint = transposePoint(position, sourceBitmap, targetSize, sideward);
            } else if (type == 5) {
                pointTransposePoint3 = transposePoint(position, sourceBitmap, targetSize, sideward);
            } else if (type == 10) {
                pointTransposePoint2 = transposePoint(position, sourceBitmap, targetSize, sideward);
            } else if (type == 11) {
                pointTransposePoint4 = transposePoint(position, sourceBitmap, targetSize, sideward);
            }
        }
        if (pointTransposePoint != null && pointTransposePoint2 != null) {
            if (pointTransposePoint.x < pointTransposePoint2.x) {
                ir.eitaa.ui.Components.Point point = pointTransposePoint2;
                pointTransposePoint2 = pointTransposePoint;
                pointTransposePoint = point;
            }
            this.eyesCenterPoint = new ir.eitaa.ui.Components.Point((pointTransposePoint.x * 0.5f) + (pointTransposePoint2.x * 0.5f), (pointTransposePoint.y * 0.5f) + (pointTransposePoint2.y * 0.5f));
            this.eyesDistance = (float) Math.hypot(pointTransposePoint2.x - pointTransposePoint.x, pointTransposePoint2.y - pointTransposePoint.y);
            this.angle = (float) Math.toDegrees(Math.atan2(pointTransposePoint2.y - pointTransposePoint.y, pointTransposePoint2.x - pointTransposePoint.x) + 3.141592653589793d);
            float f = this.eyesDistance;
            this.width = 2.35f * f;
            float f2 = f * 0.8f;
            double radians = (float) Math.toRadians(r12 - 90.0f);
            this.foreheadPoint = new ir.eitaa.ui.Components.Point(this.eyesCenterPoint.x + (((float) Math.cos(radians)) * f2), this.eyesCenterPoint.y + (f2 * ((float) Math.sin(radians))));
        }
        if (pointTransposePoint3 == null || pointTransposePoint4 == null) {
            return;
        }
        if (pointTransposePoint3.x < pointTransposePoint4.x) {
            ir.eitaa.ui.Components.Point point2 = pointTransposePoint4;
            pointTransposePoint4 = pointTransposePoint3;
            pointTransposePoint3 = point2;
        }
        this.mouthPoint = new ir.eitaa.ui.Components.Point((pointTransposePoint3.x * 0.5f) + (pointTransposePoint4.x * 0.5f), (pointTransposePoint3.y * 0.5f) + (pointTransposePoint4.y * 0.5f));
        float f3 = this.eyesDistance * 0.7f;
        double radians2 = (float) Math.toRadians(this.angle + 90.0f);
        this.chinPoint = new ir.eitaa.ui.Components.Point(this.mouthPoint.x + (((float) Math.cos(radians2)) * f3), this.mouthPoint.y + (f3 * ((float) Math.sin(radians2))));
    }

    public boolean isSufficient() {
        return this.eyesCenterPoint != null;
    }

    private ir.eitaa.ui.Components.Point transposePoint(PointF point, Bitmap sourceBitmap, Size targetSize, boolean sideward) {
        return new ir.eitaa.ui.Components.Point((targetSize.width * point.x) / (sideward ? sourceBitmap.getHeight() : sourceBitmap.getWidth()), (targetSize.height * point.y) / (sideward ? sourceBitmap.getWidth() : sourceBitmap.getHeight()));
    }

    public ir.eitaa.ui.Components.Point getPointForAnchor(int anchor) {
        if (anchor == 0) {
            return this.foreheadPoint;
        }
        if (anchor == 1) {
            return this.eyesCenterPoint;
        }
        if (anchor == 2) {
            return this.mouthPoint;
        }
        if (anchor != 3) {
            return null;
        }
        return this.chinPoint;
    }

    public float getWidthForAnchor(int anchor) {
        if (anchor == 1) {
            return this.eyesDistance;
        }
        return this.width;
    }

    public float getAngle() {
        return this.angle;
    }
}
