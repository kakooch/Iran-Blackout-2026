package ir.nasim;

import android.opengl.EGLSurface;

/* loaded from: classes.dex */
public abstract class HN4 {
    public static HN4 d(EGLSurface eGLSurface, int i, int i2) {
        return new C20701sT(eGLSurface, i, i2);
    }

    public abstract EGLSurface a();

    public abstract int b();

    public abstract int c();
}
