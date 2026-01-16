package ir.nasim.tgwidgets.editor.ui.Components.Paint;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.opengl.GLES20;
import ir.nasim.AbstractC18273oN7;
import ir.nasim.C18871pO5;
import ir.nasim.X05;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: classes7.dex */
public abstract class g {
    private static RectF a(C18871pO5 c18871pO5) {
        char c;
        float f;
        int i = 0;
        RectF rectF = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        int iC = c18871pO5.c();
        if (iC <= 0) {
            return rectF;
        }
        int i2 = iC - 1;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(((iC * 4) + (i2 * 2)) * 20);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.position(0);
        c18871pO5.h(0);
        int i3 = 0;
        int i4 = 0;
        while (i3 < iC) {
            float fE = c18871pO5.e();
            float fE2 = c18871pO5.e();
            float fE3 = c18871pO5.e();
            float fE4 = c18871pO5.e();
            float fE5 = c18871pO5.e();
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
            AbstractC18273oN7.b(rectF2);
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

    private static void b(f fVar, f fVar2, C18871pO5 c18871pO5) {
        int i;
        boolean z;
        double dB = fVar.b(fVar2);
        f fVarE = fVar2.e(fVar);
        f fVar3 = new f(1.0d, 1.0d, 0.0d);
        float fAtan2 = Math.abs(c18871pO5.d) > 0.0f ? c18871pO5.d : (float) Math.atan2(fVarE.b, fVarE.a);
        float f = (float) ((((c18871pO5.a * fVar2.c) * c18871pO5.e) * 1.0d) / c18871pO5.f);
        double dMax = Math.max(1.0f, c18871pO5.b * f);
        if (dB > 0.0d) {
            fVar3 = fVarE.c(1.0d / dB);
        }
        f fVar4 = fVar3;
        float fMin = Math.min(1.0f, c18871pO5.c * 1.15f);
        boolean z2 = fVar.d;
        boolean z3 = fVar2.d;
        int iCeil = (int) Math.ceil((dB - c18871pO5.g) / dMax);
        int iC = c18871pO5.c();
        c18871pO5.b(iCeil);
        c18871pO5.h(iC);
        f fVarA = fVar.a(fVar4.c(c18871pO5.g));
        int i2 = 1;
        double d = c18871pO5.g;
        boolean zA = true;
        while (true) {
            if (d > dB) {
                i = i2;
                z = z3;
                break;
            }
            i = i2;
            z = z3;
            zA = c18871pO5.a(fVarA.f(), f, fAtan2, z2 ? fMin : c18871pO5.c, -1);
            if (!zA) {
                break;
            }
            fVarA = fVarA.a(fVar4.c(dMax));
            d += dMax;
            z2 = false;
            i2 = i;
            z3 = z;
        }
        if (zA && z) {
            c18871pO5.b(i);
            c18871pO5.a(fVar2.f(), f, fAtan2, fMin, -1);
        }
        c18871pO5.g = d - dB;
    }

    private static void c(f fVar, C18871pO5 c18871pO5) {
        float f = ((c18871pO5.a * c18871pO5.e) * 1.0f) / c18871pO5.f;
        PointF pointFF = fVar.f();
        float f2 = Math.abs(c18871pO5.d) > 0.0f ? c18871pO5.d : 0.0f;
        float f3 = c18871pO5.c;
        c18871pO5.d();
        c18871pO5.b(1);
        c18871pO5.a(pointFF, f, f2, f3, 0);
    }

    public static RectF d(X05 x05, C18871pO5 c18871pO5, boolean z) {
        c18871pO5.a = x05.a();
        c18871pO5.b = x05.b().j();
        c18871pO5.c = z ? 1.0f : x05.b().a();
        c18871pO5.d = x05.b().b();
        c18871pO5.e = x05.b().g();
        int iD = x05.d();
        if (iD == 0) {
            return null;
        }
        int i = 0;
        if (iD == 1) {
            c(x05.e()[0], c18871pO5);
        } else {
            f[] fVarArrE = x05.e();
            c18871pO5.d();
            while (i < fVarArrE.length - 1) {
                f fVar = fVarArrE[i];
                i++;
                b(fVar, fVarArrE[i], c18871pO5);
            }
        }
        x05.a = c18871pO5.g;
        return a(c18871pO5);
    }
}
