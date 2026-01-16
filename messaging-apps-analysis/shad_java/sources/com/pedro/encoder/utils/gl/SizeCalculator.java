package com.pedro.encoder.utils.gl;

import android.graphics.PointF;
import android.opengl.GLES20;
import android.opengl.Matrix;

/* loaded from: classes3.dex */
public class SizeCalculator {
    public static void calculateViewPort(boolean z, int i, int i2, int i3, int i4, int i5) {
        if (!z) {
            GLES20.glViewport(0, 0, i2, i3);
            return;
        }
        if (i2 > i3) {
            if (i == 0) {
                int i6 = (i4 * i3) / i5;
                GLES20.glViewport((i2 - i6) / 2, 0, i6, i3);
                return;
            } else {
                int i7 = (i5 * i2) / i4;
                GLES20.glViewport(0, -((i7 - i2) / 2), i2, i7);
                return;
            }
        }
        if (i == 0) {
            int i8 = (i5 * i2) / i4;
            GLES20.glViewport(0, (i3 - i8) / 2, i2, i8);
        } else {
            int i9 = (i4 * i3) / i5;
            GLES20.glViewport(-((i9 - i2) / 2), 0, i9, i3);
        }
    }

    public static void updateMatrix(int i, int i2, int i3, boolean z, boolean z2, float[] fArr) {
        Matrix.setIdentityM(fArr, 0);
        PointF scale = getScale(i, i2, i3, z2, z);
        Matrix.scaleM(fArr, 0, scale.x, scale.y, 1.0f);
        if (!z && !z2) {
            i += 90;
        }
        Matrix.rotateM(fArr, 0, i, 0.0f, 0.0f, -1.0f);
    }

    private static PointF getScale(int i, int i2, int i3, boolean z, boolean z2) {
        float f;
        float f2 = 1.0f;
        if (z2) {
            f = 1.0f;
        } else if (!z || i == 0 || i == 180) {
            if (!z && i != 90 && i != 270) {
                float f3 = i3;
                float f4 = i2;
                f2 = (f3 * (f3 / f4)) / f4;
            }
            f = 1.0f;
        } else {
            float f5 = i2;
            float f6 = i3;
            f = (f5 * (f5 / f6)) / f6;
        }
        return new PointF(f2, f);
    }
}
