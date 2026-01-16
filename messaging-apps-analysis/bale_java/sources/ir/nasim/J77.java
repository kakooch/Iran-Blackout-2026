package ir.nasim;

/* loaded from: classes7.dex */
public class J77 extends AbstractC18697p57 {
    public static int s = 1662637586;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.e = iE;
        this.l = (iE & 2) != 0;
        this.b = t1.g(z);
        this.c = F57.d(t1, t1.e(z), z);
        if ((this.e & 1) != 0) {
            this.f = C18390oa7.d(t1, t1.e(z), z);
        }
    }

    @Override // ir.nasim.AbstractC12724f57
    public void c(T1 t1) {
        t1.m(s);
        int i = this.l ? this.e | 2 : this.e & (-3);
        this.e = i;
        t1.m(i);
        t1.o(this.b);
        this.c.c(t1);
        if ((this.e & 1) != 0) {
            this.f.c(t1);
        }
    }
}
