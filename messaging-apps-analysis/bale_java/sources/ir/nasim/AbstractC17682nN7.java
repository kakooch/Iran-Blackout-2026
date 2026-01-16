package ir.nasim;

import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLUtils;

/* renamed from: ir.nasim.nN7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC17682nN7 {
    public static void a() {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError != 0) {
            C19406qI3.a("Paint", GLUtils.getEGLErrorString(iGlGetError), new Object[0]);
        }
    }

    public static void b(RectF rectF) {
        rectF.left = (int) Math.floor(rectF.left);
        rectF.top = (int) Math.floor(rectF.top);
        rectF.right = (int) Math.ceil(rectF.right);
        rectF.bottom = (int) Math.ceil(rectF.bottom);
    }
}
