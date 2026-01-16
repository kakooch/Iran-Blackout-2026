package ir.nasim;

/* loaded from: classes2.dex */
public class HN6 extends AbstractInterpolatorC13741gk4 {
    private IN6 a;
    private C19418qJ6 b;
    private GN6 c;

    public HN6() {
        IN6 in6 = new IN6();
        this.a = in6;
        this.c = in6;
    }

    @Override // ir.nasim.AbstractInterpolatorC13741gk4
    public float a() {
        return this.c.a();
    }

    public void b(float f, float f2, float f3, float f4, float f5, float f6) {
        IN6 in6 = this.a;
        this.c = in6;
        in6.d(f, f2, f3, f4, f5, f6);
    }

    public boolean c() {
        return this.c.b();
    }

    public void d(float f, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        if (this.b == null) {
            this.b = new C19418qJ6();
        }
        C19418qJ6 c19418qJ6 = this.b;
        this.c = c19418qJ6;
        c19418qJ6.d(f, f2, f3, f4, f5, f6, f7, i);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return this.c.getInterpolation(f);
    }
}
