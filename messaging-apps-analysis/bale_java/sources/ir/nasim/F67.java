package ir.nasim;

/* loaded from: classes7.dex */
public class F67 extends AbstractC15742k57 {
    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.e = iE;
        this.p = (iE & 32) != 0;
        this.q = (iE & 256) != 0;
        this.b = t1.f(z);
        this.r = t1.f(z);
        this.c = t1.g(z);
        if ((this.e & 65536) != 0) {
            this.s = t1.e(z);
        }
    }
}
