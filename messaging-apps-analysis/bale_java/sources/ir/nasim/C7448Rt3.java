package ir.nasim;

import android.graphics.Matrix;

/* renamed from: ir.nasim.Rt3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7448Rt3 {
    private final InterfaceC14603iB2 a;
    private Matrix b;
    private boolean e;
    private boolean f;
    private float[] c = AV3.c(null, 1, null);
    private float[] d = AV3.c(null, 1, null);
    private boolean g = true;
    private boolean h = true;

    public C7448Rt3(InterfaceC14603iB2 interfaceC14603iB2) {
        this.a = interfaceC14603iB2;
    }

    public final float[] a(Object obj) {
        float[] fArr = this.d;
        if (this.f) {
            this.g = AbstractC13670gd3.a(b(obj), fArr);
            this.f = false;
        }
        if (this.g) {
            return fArr;
        }
        return null;
    }

    public final float[] b(Object obj) {
        float[] fArr = this.c;
        if (!this.e) {
            return fArr;
        }
        Matrix matrix = this.b;
        if (matrix == null) {
            matrix = new Matrix();
            this.b = matrix;
        }
        this.a.invoke(obj, matrix);
        AbstractC5964Lp.b(fArr, matrix);
        this.e = false;
        this.h = EV3.a(fArr);
        return fArr;
    }

    public final void c() {
        this.e = true;
        this.f = true;
    }

    public final void d(Object obj, C6908Pm4 c6908Pm4) {
        float[] fArrB = b(obj);
        if (this.h) {
            return;
        }
        AV3.g(fArrB, c6908Pm4);
    }

    public final long e(Object obj, long j) {
        return !this.h ? AV3.f(b(obj), j) : j;
    }

    public final void f(Object obj, C6908Pm4 c6908Pm4) {
        float[] fArrA = a(obj);
        if (fArrA == null) {
            c6908Pm4.g(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            if (this.h) {
                return;
            }
            AV3.g(fArrA, c6908Pm4);
        }
    }

    public final long g(Object obj, long j) {
        float[] fArrA = a(obj);
        return fArrA == null ? ZG4.b.a() : !this.h ? AV3.f(fArrA, j) : j;
    }

    public final void h() {
        this.e = false;
        this.f = false;
        this.h = true;
        this.g = true;
        AV3.h(this.c);
        AV3.h(this.d);
    }
}
