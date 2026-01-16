package ir.nasim;

import android.opengl.EGLSurface;

/* renamed from: ir.nasim.sT, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C20701sT extends HN4 {
    private final EGLSurface a;
    private final int b;
    private final int c;

    C20701sT(EGLSurface eGLSurface, int i, int i2) {
        if (eGLSurface == null) {
            throw new NullPointerException("Null eglSurface");
        }
        this.a = eGLSurface;
        this.b = i;
        this.c = i2;
    }

    @Override // ir.nasim.HN4
    public EGLSurface a() {
        return this.a;
    }

    @Override // ir.nasim.HN4
    public int b() {
        return this.c;
    }

    @Override // ir.nasim.HN4
    public int c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HN4)) {
            return false;
        }
        HN4 hn4 = (HN4) obj;
        return this.a.equals(hn4.a()) && this.b == hn4.c() && this.c == hn4.b();
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c;
    }

    public String toString() {
        return "OutputSurface{eglSurface=" + this.a + ", width=" + this.b + ", height=" + this.c + "}";
    }
}
