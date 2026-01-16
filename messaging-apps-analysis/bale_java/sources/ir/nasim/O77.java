package ir.nasim;

/* loaded from: classes7.dex */
public class O77 extends N77 {
    public static int t = 250621158;

    @Override // ir.nasim.N77, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.e = iE;
        this.g = (iE & 1) != 0;
        this.h = (iE & 2) != 0;
        this.d = t1.e(z);
        this.j = t1.e(z);
        this.k = t1.e(z);
    }

    @Override // ir.nasim.N77, ir.nasim.AbstractC12724f57
    public void c(T1 t1) {
        t1.m(t);
        int i = this.g ? this.e | 1 : this.e & (-2);
        this.e = i;
        int i2 = this.h ? i | 2 : i & (-3);
        this.e = i2;
        t1.m(i2);
        t1.m((int) this.d);
        t1.m(this.j);
        t1.m(this.k);
    }
}
