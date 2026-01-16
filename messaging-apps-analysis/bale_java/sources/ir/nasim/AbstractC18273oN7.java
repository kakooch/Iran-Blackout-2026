package ir.nasim;

import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;

/* renamed from: ir.nasim.oN7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC18273oN7 {
    public static void a() {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError != 0) {
            Log.d("Paint", GLUtils.getEGLErrorString(iGlGetError));
        }
    }

    public static void b(RectF rectF) {
        rectF.left = (int) Math.floor(rectF.left);
        rectF.top = (int) Math.floor(rectF.top);
        rectF.right = (int) Math.ceil(rectF.right);
        rectF.bottom = (int) Math.ceil(rectF.bottom);
    }
}
