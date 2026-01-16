package ir.nasim;

/* loaded from: classes7.dex */
public class N77 extends AbstractC18697p57 {
    public static int s = -745541182;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.e = iE;
        this.g = (iE & 1) != 0;
        this.h = (iE & 2) != 0;
        this.r = (iE & 8) != 0;
        this.d = t1.d(z);
        this.j = t1.e(z);
        this.k = t1.e(z);
        if ((this.e & 4) != 0) {
            this.q = t1.e(z);
        }
    }

    @Override // ir.nasim.AbstractC12724f57
    public void c(T1 t1) {
        t1.m(s);
        int i = this.g ? this.e | 1 : this.e & (-2);
        this.e = i;
        int i2 = this.h ? i | 2 : i & (-3);
        this.e = i2;
        int i3 = this.r ? i2 | 8 : i2 & (-9);
        this.e = i3;
        t1.m(i3);
        t1.l(this.d);
        t1.m(this.j);
        t1.m(this.k);
        if ((this.e & 4) != 0) {
            t1.m(this.q);
        }
    }
}
