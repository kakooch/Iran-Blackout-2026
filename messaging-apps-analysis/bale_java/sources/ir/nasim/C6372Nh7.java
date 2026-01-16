package ir.nasim;

/* renamed from: ir.nasim.Nh7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C6372Nh7 extends C5432Jh7 {
    public static int k = -399391402;

    @Override // ir.nasim.C5432Jh7, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = t1.e(z);
        this.c = t1.g(z);
        this.d = AbstractC20488s57.d(t1, t1.e(z), z);
        this.e = t1.e(z);
        this.f = t1.e(z);
        this.g = t1.e(z);
        if ((this.b & 1) != 0) {
            this.h = t1.d(z);
        }
    }

    @Override // ir.nasim.C5432Jh7, ir.nasim.AbstractC12724f57
    public void c(T1 t1) {
        t1.m(k);
        t1.m(this.b);
        t1.o(this.c);
        this.d.c(t1);
        t1.m(this.e);
        t1.m(this.f);
        t1.m(this.g);
        if ((this.b & 1) != 0) {
            t1.l(this.h);
        }
    }
}
