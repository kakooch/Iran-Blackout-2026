package ir.nasim;

/* loaded from: classes7.dex */
public class C77 extends AbstractC18697p57 {
    public static int s = -1739392570;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.e = iE;
        this.o = (iE & 1024) != 0;
        this.d = t1.e(z);
        if ((this.e & 1) != 0) {
            this.m = t1.g(z);
        }
        if ((this.e & 2) != 0) {
            this.n = t1.g(z);
        }
        if ((this.e & 4) != 0) {
            this.p = t1.c(z);
        }
    }

    @Override // ir.nasim.AbstractC12724f57
    public void c(T1 t1) {
        t1.m(s);
        int i = this.o ? this.e | 1024 : this.e & (-1025);
        this.e = i;
        t1.m(i);
        t1.m((int) this.d);
        if ((this.e & 1) != 0) {
            t1.o(this.m);
        }
        if ((this.e & 2) != 0) {
            t1.o(this.n);
        }
        if ((this.e & 4) != 0) {
            t1.k(this.p);
        }
    }
}
