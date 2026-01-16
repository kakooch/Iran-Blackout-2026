package ir.nasim;

/* renamed from: ir.nasim.Th7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C7815Th7 extends AbstractC23315wi7 {
    public static int l = -528465642;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = t1.f(z);
        int iE = t1.e(z);
        this.c = iE;
        this.e = (iE & 2) != 0;
        this.g = (iE & 16) != 0;
        if ((iE & 4) != 0) {
            this.k = AbstractC23905xi7.d(t1, t1.e(z), z);
        }
    }

    @Override // ir.nasim.AbstractC12724f57
    public void c(T1 t1) {
        t1.m(l);
        t1.n(this.b);
        int i = this.e ? this.c | 2 : this.c & (-3);
        this.c = i;
        int i2 = this.g ? i | 16 : i & (-17);
        this.c = i2;
        t1.m(i2);
        if ((this.c & 4) != 0) {
            this.k.c(t1);
        }
    }
}
