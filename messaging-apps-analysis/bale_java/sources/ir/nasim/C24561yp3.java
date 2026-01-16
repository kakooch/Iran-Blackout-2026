package ir.nasim;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* renamed from: ir.nasim.yp3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C24561yp3 {
    private final C23677xK3 a;
    public final Object b;
    public Object c;
    public final Interpolator d;
    public final Interpolator e;
    public final Interpolator f;
    public final float g;
    public Float h;
    private float i;
    private float j;
    private int k;
    private int l;
    private float m;
    private float n;
    public PointF o;
    public PointF p;

    public C24561yp3(C23677xK3 c23677xK3, Object obj, Object obj2, Interpolator interpolator, float f, Float f2) {
        this.i = -3987645.8f;
        this.j = -3987645.8f;
        this.k = 784923401;
        this.l = 784923401;
        this.m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.a = c23677xK3;
        this.b = obj;
        this.c = obj2;
        this.d = interpolator;
        this.e = null;
        this.f = null;
        this.g = f;
        this.h = f2;
    }

    public boolean a(float f) {
        return f >= f() && f < c();
    }

    public C24561yp3 b(Object obj, Object obj2) {
        return new C24561yp3(obj, obj2);
    }

    public float c() {
        if (this.a == null) {
            return 1.0f;
        }
        if (this.n == Float.MIN_VALUE) {
            if (this.h == null) {
                this.n = 1.0f;
            } else {
                this.n = (float) (f() + ((this.h.floatValue() - this.g) / this.a.e()));
            }
        }
        return this.n;
    }

    public float d() {
        if (this.j == -3987645.8f) {
            this.j = ((Float) this.c).floatValue();
        }
        return this.j;
    }

    public int e() {
        if (this.l == 784923401) {
            this.l = ((Integer) this.c).intValue();
        }
        return this.l;
    }

    public float f() {
        C23677xK3 c23677xK3 = this.a;
        if (c23677xK3 == null) {
            return 0.0f;
        }
        if (this.m == Float.MIN_VALUE) {
            this.m = (this.g - c23677xK3.p()) / this.a.e();
        }
        return this.m;
    }

    public float g() {
        if (this.i == -3987645.8f) {
            this.i = ((Float) this.b).floatValue();
        }
        return this.i;
    }

    public int h() {
        if (this.k == 784923401) {
            this.k = ((Integer) this.b).intValue();
        }
        return this.k;
    }

    public boolean i() {
        return this.d == null && this.e == null && this.f == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.b + ", endValue=" + this.c + ", startFrame=" + this.g + ", endFrame=" + this.h + ", interpolator=" + this.d + '}';
    }

    public C24561yp3(C23677xK3 c23677xK3, Object obj, Object obj2, Interpolator interpolator, Interpolator interpolator2, float f, Float f2) {
        this.i = -3987645.8f;
        this.j = -3987645.8f;
        this.k = 784923401;
        this.l = 784923401;
        this.m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.a = c23677xK3;
        this.b = obj;
        this.c = obj2;
        this.d = null;
        this.e = interpolator;
        this.f = interpolator2;
        this.g = f;
        this.h = f2;
    }

    protected C24561yp3(C23677xK3 c23677xK3, Object obj, Object obj2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f, Float f2) {
        this.i = -3987645.8f;
        this.j = -3987645.8f;
        this.k = 784923401;
        this.l = 784923401;
        this.m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.a = c23677xK3;
        this.b = obj;
        this.c = obj2;
        this.d = interpolator;
        this.e = interpolator2;
        this.f = interpolator3;
        this.g = f;
        this.h = f2;
    }

    public C24561yp3(Object obj) {
        this.i = -3987645.8f;
        this.j = -3987645.8f;
        this.k = 784923401;
        this.l = 784923401;
        this.m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.a = null;
        this.b = obj;
        this.c = obj;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = Float.MIN_VALUE;
        this.h = Float.valueOf(Float.MAX_VALUE);
    }

    private C24561yp3(Object obj, Object obj2) {
        this.i = -3987645.8f;
        this.j = -3987645.8f;
        this.k = 784923401;
        this.l = 784923401;
        this.m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.a = null;
        this.b = obj;
        this.c = obj2;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = Float.MIN_VALUE;
        this.h = Float.valueOf(Float.MAX_VALUE);
    }
}
