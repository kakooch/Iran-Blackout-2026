package ir.nasim;

/* loaded from: classes7.dex */
public class F77 extends AbstractC18697p57 {
    public static int u = -48981863;
    public boolean s;
    public boolean t;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.e = iE;
        this.s = (iE & 1) != 0;
        this.t = (iE & 2) != 0;
        this.b = t1.g(z);
        this.c = F57.d(t1, t1.e(z), z);
    }

    @Override // ir.nasim.AbstractC12724f57
    public void c(T1 t1) {
        t1.m(u);
        int i = this.s ? this.e | 1 : this.e & (-2);
        this.e = i;
        int i2 = this.t ? i | 2 : i & (-3);
        this.e = i2;
        t1.m(i2);
        t1.o(this.b);
        this.c.c(t1);
    }
}
