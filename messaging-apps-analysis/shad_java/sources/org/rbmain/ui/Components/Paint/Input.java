package org.rbmain.ui.Components.Paint;

import android.graphics.Matrix;
import android.view.MotionEvent;
import java.util.Vector;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.Paint.Brush;

/* loaded from: classes5.dex */
public class Input {
    private boolean beganDrawing;
    private boolean clearBuffer;
    private boolean hasMoved;
    private Matrix invertMatrix;
    private boolean isFirst;
    private float lastAngle;
    private Point lastLocation;
    private double lastRemainder;
    private int pointsCount;
    private RenderView renderView;
    private Point[] points = new Point[3];
    private float[] tempPoint = new float[2];

    public Input(RenderView renderView) {
        this.renderView = renderView;
    }

    public void setMatrix(Matrix matrix) {
        Matrix matrix2 = new Matrix();
        this.invertMatrix = matrix2;
        matrix.invert(matrix2);
    }

    public void process(MotionEvent motionEvent, float f) {
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float height = this.renderView.getHeight() - motionEvent.getY();
        float[] fArr = this.tempPoint;
        fArr[0] = x;
        fArr[1] = height;
        this.invertMatrix.mapPoints(fArr);
        float[] fArr2 = this.tempPoint;
        Point point = new Point(fArr2[0], fArr2[1], 1.0d);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                if (!this.hasMoved) {
                    if (this.renderView.shouldDraw()) {
                        point.edge = true;
                        paintPath(new Path(point));
                    }
                    reset();
                } else if (this.pointsCount > 0) {
                    smoothenAndPaintPoints(true);
                    if (this.renderView.getCurrentBrush() instanceof Brush.Arrow) {
                        float currentWeight = this.renderView.getCurrentWeight() * 4.5f;
                        float f2 = this.lastAngle;
                        Point point2 = this.points[this.pointsCount - 1];
                        Point point3 = new Point(point2.x, point2.y, 0.800000011920929d);
                        double d = point2.x;
                        double d2 = f2;
                        Double.isNaN(d2);
                        double dCos = Math.cos(d2 - 2.356194490192345d);
                        double d3 = currentWeight;
                        Double.isNaN(d3);
                        double d4 = d + (dCos * d3);
                        double d5 = point2.y;
                        Double.isNaN(d2);
                        double dSin = Math.sin(d2 - 2.5132741228718345d);
                        Double.isNaN(d3);
                        Point point4 = new Point(d4, d5 + (dSin * d3), 1.0d);
                        point4.edge = true;
                        paintPath(new Path(new Point[]{point3, point4}));
                        double d6 = point2.x;
                        Double.isNaN(d2);
                        double dCos2 = Math.cos(2.356194490192345d + d2);
                        Double.isNaN(d3);
                        double d7 = d6 + (dCos2 * d3);
                        double d8 = point2.y;
                        Double.isNaN(d2);
                        double dSin2 = Math.sin(d2 + 2.5132741228718345d);
                        Double.isNaN(d3);
                        Point point5 = new Point(d7, d8 + (dSin2 * d3), 1.0d);
                        point5.edge = true;
                        paintPath(new Path(new Point[]{point3, point5}));
                    }
                }
                this.pointsCount = 0;
                this.renderView.getPainting().commitStroke(this.renderView.getCurrentColor());
                this.beganDrawing = false;
                this.renderView.onFinishedDrawing(this.hasMoved);
                return;
            }
            if (actionMasked != 2) {
                if (actionMasked != 3) {
                    return;
                }
                this.renderView.getPainting().clearStroke();
                this.pointsCount = 0;
                this.beganDrawing = false;
                return;
            }
        }
        if (!this.beganDrawing) {
            this.beganDrawing = true;
            this.hasMoved = false;
            this.isFirst = true;
            this.lastLocation = point;
            this.points[0] = point;
            this.pointsCount = 1;
            this.clearBuffer = true;
            return;
        }
        if (point.getDistanceTo(this.lastLocation) < AndroidUtilities.dp(5.0f) / f) {
            return;
        }
        if (!this.hasMoved) {
            this.renderView.onBeganDrawing();
            this.hasMoved = true;
        }
        Point[] pointArr = this.points;
        int i = this.pointsCount;
        pointArr[i] = point;
        int i2 = i + 1;
        this.pointsCount = i2;
        if (i2 == 3) {
            this.lastAngle = (float) Math.atan2(pointArr[2].y - pointArr[1].y, pointArr[2].x - pointArr[1].x);
            smoothenAndPaintPoints(false);
        }
        this.lastLocation = point;
    }

    private void reset() {
        this.pointsCount = 0;
    }

    private void smoothenAndPaintPoints(boolean z) {
        int i = this.pointsCount;
        if (i > 2) {
            Vector vector = new Vector();
            Point[] pointArr = this.points;
            Point point = pointArr[0];
            Point point2 = pointArr[1];
            Point point3 = pointArr[2];
            if (point3 == null || point2 == null || point == null) {
                return;
            }
            Point pointMultiplySum = point2.multiplySum(point, 0.5d);
            Point pointMultiplySum2 = point3.multiplySum(point2, 0.5d);
            int iMin = (int) Math.min(48.0d, Math.max(Math.floor(pointMultiplySum.getDistanceTo(pointMultiplySum2) / 1), 24.0d));
            float f = 0.0f;
            float f2 = 1.0f / iMin;
            for (int i2 = 0; i2 < iMin; i2++) {
                Point pointSmoothPoint = smoothPoint(pointMultiplySum, pointMultiplySum2, point2, f);
                if (this.isFirst) {
                    pointSmoothPoint.edge = true;
                    this.isFirst = false;
                }
                vector.add(pointSmoothPoint);
                f += f2;
            }
            if (z) {
                pointMultiplySum2.edge = true;
            }
            vector.add(pointMultiplySum2);
            Point[] pointArr2 = new Point[vector.size()];
            vector.toArray(pointArr2);
            paintPath(new Path(pointArr2));
            Point[] pointArr3 = this.points;
            System.arraycopy(pointArr3, 1, pointArr3, 0, 2);
            if (z) {
                this.pointsCount = 0;
                return;
            } else {
                this.pointsCount = 2;
                return;
            }
        }
        Point[] pointArr4 = new Point[i];
        System.arraycopy(this.points, 0, pointArr4, 0, i);
        paintPath(new Path(pointArr4));
    }

    private Point smoothPoint(Point point, Point point2, Point point3, float f) {
        float f2 = 1.0f - f;
        double dPow = Math.pow(f2, 2.0d);
        double d = f2 * 2.0f * f;
        double d2 = f * f;
        double d3 = point.x * dPow;
        double d4 = point3.x;
        Double.isNaN(d);
        double d5 = d3 + (d4 * d);
        double d6 = point2.x;
        Double.isNaN(d2);
        double d7 = point.y * dPow;
        double d8 = point3.y;
        Double.isNaN(d);
        double d9 = point2.y;
        Double.isNaN(d2);
        return new Point(d5 + (d6 * d2), d7 + (d8 * d) + (d9 * d2), 1.0d);
    }

    private void paintPath(final Path path) {
        path.setup(this.renderView.getCurrentColor(), this.renderView.getCurrentWeight(), this.renderView.getCurrentBrush());
        if (this.clearBuffer) {
            this.lastRemainder = 0.0d;
        }
        path.remainder = this.lastRemainder;
        this.renderView.getPainting().paintStroke(path, this.clearBuffer, new Runnable() { // from class: org.rbmain.ui.Components.Paint.Input$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$paintPath$1(path);
            }
        });
        this.clearBuffer = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$paintPath$0(Path path) {
        this.lastRemainder = path.remainder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$paintPath$1(final Path path) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.Paint.Input$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$paintPath$0(path);
            }
        });
    }
}
