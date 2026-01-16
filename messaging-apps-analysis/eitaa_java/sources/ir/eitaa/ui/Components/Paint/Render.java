package ir.eitaa.ui.Components.Paint;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: classes3.dex */
public class Render {
    public static RectF RenderPath(Path path, RenderState state) {
        state.baseWeight = path.getBaseWeight();
        state.spacing = path.getBrush().getSpacing();
        state.alpha = path.getBrush().getAlpha();
        state.angle = path.getBrush().getAngle();
        state.scale = path.getBrush().getScale();
        int length = path.getLength();
        if (length == 0) {
            return null;
        }
        int i = 0;
        if (length == 1) {
            PaintStamp(path.getPoints()[0], state);
        } else {
            Point[] points = path.getPoints();
            state.prepare();
            while (i < points.length - 1) {
                Point point = points[i];
                i++;
                PaintSegment(point, points[i], state);
            }
        }
        path.remainder = state.remainder;
        return Draw(state);
    }

    private static void PaintSegment(Point lastPoint, Point point, RenderState state) {
        boolean z;
        int i;
        double distanceTo = lastPoint.getDistanceTo(point);
        Point pointSubstract = point.substract(lastPoint);
        Point point2 = new Point(1.0d, 1.0d, 0.0d);
        float fAtan2 = Math.abs(state.angle) > 0.0f ? state.angle : (float) Math.atan2(pointSubstract.y, pointSubstract.x);
        float f = ((state.baseWeight * state.scale) * 1.0f) / state.viewportScale;
        double dMax = Math.max(1.0f, state.spacing * f);
        if (distanceTo > 0.0d) {
            Double.isNaN(distanceTo);
            point2 = pointSubstract.multiplyByScalar(1.0d / distanceTo);
        }
        Point point3 = point2;
        float fMin = Math.min(1.0f, state.alpha * 1.15f);
        boolean z2 = lastPoint.edge;
        boolean z3 = point.edge;
        double d = state.remainder;
        Double.isNaN(distanceTo);
        Double.isNaN(dMax);
        int iCeil = (int) Math.ceil((distanceTo - d) / dMax);
        int count = state.getCount();
        state.appendValuesCount(iCeil);
        state.setPosition(count);
        Point pointAdd = lastPoint.add(point3.multiplyByScalar(state.remainder));
        double d2 = state.remainder;
        boolean zAddPoint = true;
        while (true) {
            if (d2 > distanceTo) {
                z = z3;
                i = 1;
                break;
            }
            i = 1;
            z = z3;
            zAddPoint = state.addPoint(pointAdd.toPointF(), f, fAtan2, z2 ? fMin : state.alpha, -1);
            if (!zAddPoint) {
                break;
            }
            pointAdd = pointAdd.add(point3.multiplyByScalar(dMax));
            z2 = false;
            Double.isNaN(dMax);
            d2 += dMax;
            z3 = z;
        }
        if (zAddPoint && z) {
            state.appendValuesCount(i);
            state.addPoint(point.toPointF(), f, fAtan2, fMin, -1);
        }
        Double.isNaN(distanceTo);
        state.remainder = d2 - distanceTo;
    }

    private static void PaintStamp(Point point, RenderState state) {
        float f = ((state.baseWeight * state.scale) * 1.0f) / state.viewportScale;
        PointF pointF = point.toPointF();
        float f2 = Math.abs(state.angle) > 0.0f ? state.angle : 0.0f;
        float f3 = state.alpha;
        state.prepare();
        state.appendValuesCount(1);
        state.addPoint(pointF, f, f2, f3, 0);
    }

    private static RectF Draw(RenderState state) {
        int i;
        float f;
        RectF rectF = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        int count = state.getCount();
        if (count == 0) {
            return rectF;
        }
        int i2 = count - 1;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(((count * 4) + (i2 * 2)) * 20);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        char c = 0;
        floatBufferAsFloatBuffer.position(0);
        state.setPosition(0);
        int i3 = 0;
        int i4 = 0;
        while (i3 < count) {
            float f2 = state.read();
            float f3 = state.read();
            float f4 = state.read();
            float f5 = state.read();
            float f6 = state.read();
            RectF rectF2 = new RectF(f2 - f4, f3 - f4, f2 + f4, f3 + f4);
            float[] fArr = new float[8];
            float f7 = rectF2.left;
            fArr[c] = f7;
            float f8 = rectF2.top;
            fArr[1] = f8;
            float f9 = rectF2.right;
            fArr[2] = f9;
            fArr[3] = f8;
            fArr[4] = f7;
            float f10 = rectF2.bottom;
            fArr[5] = f10;
            fArr[6] = f9;
            fArr[7] = f10;
            float fCenterX = rectF2.centerX();
            float fCenterY = rectF2.centerY();
            Matrix matrix = new Matrix();
            matrix.setRotate((float) Math.toDegrees(f5), fCenterX, fCenterY);
            matrix.mapPoints(fArr);
            matrix.mapRect(rectF2);
            Utils.RectFIntegral(rectF2);
            rectF.union(rectF2);
            if (i4 != 0) {
                floatBufferAsFloatBuffer.put(fArr[0]);
                i = 1;
                floatBufferAsFloatBuffer.put(fArr[1]);
                f = 0.0f;
                floatBufferAsFloatBuffer.put(0.0f);
                floatBufferAsFloatBuffer.put(0.0f);
                floatBufferAsFloatBuffer.put(f6);
                i4++;
            } else {
                i = 1;
                f = 0.0f;
            }
            floatBufferAsFloatBuffer.put(fArr[0]);
            floatBufferAsFloatBuffer.put(fArr[i]);
            floatBufferAsFloatBuffer.put(f);
            floatBufferAsFloatBuffer.put(f);
            floatBufferAsFloatBuffer.put(f6);
            floatBufferAsFloatBuffer.put(fArr[2]);
            floatBufferAsFloatBuffer.put(fArr[3]);
            floatBufferAsFloatBuffer.put(1.0f);
            floatBufferAsFloatBuffer.put(f);
            floatBufferAsFloatBuffer.put(f6);
            floatBufferAsFloatBuffer.put(fArr[4]);
            floatBufferAsFloatBuffer.put(fArr[5]);
            floatBufferAsFloatBuffer.put(f);
            floatBufferAsFloatBuffer.put(1.0f);
            floatBufferAsFloatBuffer.put(f6);
            floatBufferAsFloatBuffer.put(fArr[6]);
            floatBufferAsFloatBuffer.put(fArr[7]);
            floatBufferAsFloatBuffer.put(1.0f);
            floatBufferAsFloatBuffer.put(1.0f);
            floatBufferAsFloatBuffer.put(f6);
            i4 = i4 + i + i + i + i;
            if (i3 != i2) {
                floatBufferAsFloatBuffer.put(fArr[6]);
                floatBufferAsFloatBuffer.put(fArr[7]);
                floatBufferAsFloatBuffer.put(1.0f);
                floatBufferAsFloatBuffer.put(1.0f);
                floatBufferAsFloatBuffer.put(f6);
                i4++;
            }
            i3++;
            c = 0;
        }
        floatBufferAsFloatBuffer.position(0);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 20, (Buffer) floatBufferAsFloatBuffer.slice());
        GLES20.glEnableVertexAttribArray(0);
        floatBufferAsFloatBuffer.position(2);
        GLES20.glVertexAttribPointer(1, 2, 5126, true, 20, (Buffer) floatBufferAsFloatBuffer.slice());
        GLES20.glEnableVertexAttribArray(1);
        floatBufferAsFloatBuffer.position(4);
        GLES20.glVertexAttribPointer(2, 1, 5126, true, 20, (Buffer) floatBufferAsFloatBuffer.slice());
        GLES20.glEnableVertexAttribArray(2);
        GLES20.glDrawArrays(5, 0, i4);
        return rectF;
    }
}
