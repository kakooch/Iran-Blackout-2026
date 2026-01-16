package ir.nasim;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: classes3.dex */
public abstract class NN5 {
    private static RectF a(C19462qO5 c19462qO5) {
        char c;
        float f;
        int i = 0;
        RectF rectF = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        int iC = c19462qO5.c();
        if (iC == 0) {
            return rectF;
        }
        int i2 = iC - 1;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(((iC * 4) + (i2 * 2)) * 20);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.position(0);
        c19462qO5.h(0);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iC) {
            float fE = c19462qO5.e();
            float fE2 = c19462qO5.e();
            float fE3 = c19462qO5.e();
            float fE4 = c19462qO5.e();
            float fE5 = c19462qO5.e();
            RectF rectF2 = new RectF(fE - fE3, fE2 - fE3, fE + fE3, fE2 + fE3);
            float f2 = rectF2.left;
            float f3 = rectF2.top;
            float f4 = rectF2.right;
            float f5 = rectF2.bottom;
            float[] fArr = new float[8];
            fArr[i] = f2;
            fArr[1] = f3;
            fArr[2] = f4;
            fArr[3] = f3;
            fArr[4] = f2;
            fArr[5] = f5;
            fArr[6] = f4;
            fArr[7] = f5;
            float fCenterX = rectF2.centerX();
            float fCenterY = rectF2.centerY();
            Matrix matrix = new Matrix();
            matrix.setRotate((float) Math.toDegrees(fE4), fCenterX, fCenterY);
            matrix.mapPoints(fArr);
            matrix.mapRect(rectF2);
            AbstractC17682nN7.b(rectF2);
            rectF.union(rectF2);
            if (i4 != 0) {
                floatBufferAsFloatBuffer.put(fArr[0]);
                c = 1;
                floatBufferAsFloatBuffer.put(fArr[1]);
                f = 0.0f;
                floatBufferAsFloatBuffer.put(0.0f);
                floatBufferAsFloatBuffer.put(0.0f);
                floatBufferAsFloatBuffer.put(fE5);
                i4++;
            } else {
                c = 1;
                f = 0.0f;
            }
            floatBufferAsFloatBuffer.put(fArr[0]);
            floatBufferAsFloatBuffer.put(fArr[c]);
            floatBufferAsFloatBuffer.put(f);
            floatBufferAsFloatBuffer.put(f);
            floatBufferAsFloatBuffer.put(fE5);
            floatBufferAsFloatBuffer.put(fArr[2]);
            floatBufferAsFloatBuffer.put(fArr[3]);
            floatBufferAsFloatBuffer.put(1.0f);
            floatBufferAsFloatBuffer.put(f);
            floatBufferAsFloatBuffer.put(fE5);
            floatBufferAsFloatBuffer.put(fArr[4]);
            floatBufferAsFloatBuffer.put(fArr[5]);
            floatBufferAsFloatBuffer.put(f);
            floatBufferAsFloatBuffer.put(1.0f);
            floatBufferAsFloatBuffer.put(fE5);
            floatBufferAsFloatBuffer.put(fArr[6]);
            floatBufferAsFloatBuffer.put(fArr[7]);
            floatBufferAsFloatBuffer.put(1.0f);
            floatBufferAsFloatBuffer.put(1.0f);
            floatBufferAsFloatBuffer.put(fE5);
            int i5 = i4 + 4;
            if (i3 != i2) {
                floatBufferAsFloatBuffer.put(fArr[6]);
                floatBufferAsFloatBuffer.put(fArr[7]);
                floatBufferAsFloatBuffer.put(1.0f);
                floatBufferAsFloatBuffer.put(1.0f);
                floatBufferAsFloatBuffer.put(fE5);
                i4 += 5;
            } else {
                i4 = i5;
            }
            i3++;
            i = 0;
        }
        floatBufferAsFloatBuffer.position(i);
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

    private static void b(C23293wg5 c23293wg5, C23293wg5 c23293wg52, C19462qO5 c19462qO5) {
        int i;
        boolean z;
        double dB = c23293wg5.b(c23293wg52);
        C23293wg5 c23293wg5E = c23293wg52.e(c23293wg5);
        C23293wg5 c23293wg53 = new C23293wg5(1.0d, 1.0d, 0.0d);
        float fAtan2 = Math.abs(c19462qO5.d) > 0.0f ? c19462qO5.d : (float) Math.atan2(c23293wg5E.b, c23293wg5E.a);
        float f = c19462qO5.a * c19462qO5.e;
        double dMax = Math.max(1.0f, c19462qO5.b * f);
        if (dB > 0.0d) {
            c23293wg53 = c23293wg5E.c(1.0d / dB);
        }
        C23293wg5 c23293wg54 = c23293wg53;
        float fMin = Math.min(1.0f, c19462qO5.c * 1.15f);
        boolean z2 = c23293wg5.d;
        boolean z3 = c23293wg52.d;
        int iCeil = (int) Math.ceil((dB - c19462qO5.f) / dMax);
        int iC = c19462qO5.c();
        c19462qO5.b(iCeil);
        c19462qO5.h(iC);
        C23293wg5 c23293wg5A = c23293wg5.a(c23293wg54.c(c19462qO5.f));
        int i2 = 1;
        double d = c19462qO5.f;
        boolean zA = true;
        while (true) {
            if (d > dB) {
                i = i2;
                z = z3;
                break;
            }
            i = i2;
            z = z3;
            zA = c19462qO5.a(c23293wg5A.f(), f, fAtan2, z2 ? fMin : c19462qO5.c, -1);
            if (!zA) {
                break;
            }
            c23293wg5A = c23293wg5A.a(c23293wg54.c(dMax));
            d += dMax;
            z2 = false;
            i2 = i;
            z3 = z;
        }
        if (zA && z) {
            c19462qO5.b(i);
            c19462qO5.a(c23293wg52.f(), f, fAtan2, fMin, -1);
        }
        c19462qO5.f = d - dB;
    }

    private static void c(C23293wg5 c23293wg5, C19462qO5 c19462qO5) {
        float f = c19462qO5.a * c19462qO5.e;
        PointF pointFF = c23293wg5.f();
        float f2 = Math.abs(c19462qO5.d) > 0.0f ? c19462qO5.d : 0.0f;
        float f3 = c19462qO5.c;
        c19462qO5.d();
        c19462qO5.b(1);
        c19462qO5.a(pointFF, f, f2, f3, 0);
    }

    public static RectF d(W05 w05, C19462qO5 c19462qO5) {
        c19462qO5.a = w05.a();
        c19462qO5.b = w05.b().e();
        c19462qO5.c = w05.b().a();
        c19462qO5.d = w05.b().c();
        c19462qO5.e = w05.b().b();
        int iD = w05.d();
        if (iD == 0) {
            return null;
        }
        int i = 0;
        if (iD == 1) {
            c(w05.e()[0], c19462qO5);
        } else {
            C23293wg5[] c23293wg5ArrE = w05.e();
            c19462qO5.d();
            while (i < c23293wg5ArrE.length - 1) {
                C23293wg5 c23293wg5 = c23293wg5ArrE[i];
                i++;
                b(c23293wg5, c23293wg5ArrE[i], c19462qO5);
            }
        }
        w05.a = c19462qO5.f;
        return a(c19462qO5);
    }
}
