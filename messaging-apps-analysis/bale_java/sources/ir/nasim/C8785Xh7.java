package ir.nasim;

/* renamed from: ir.nasim.Xh7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C8785Xh7 extends C8285Vh7 {
    public static int l = 84438264;

    @Override // ir.nasim.C8285Vh7, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        this.c = (iE & 2) != 0;
        this.d = (iE & 4) != 0;
        if ((iE & 1) != 0) {
            this.e = t1.e(z);
        }
        if ((this.b & 16) != 0) {
            this.f = t1.e(z);
        }
        if ((this.b & 8) != 0) {
            this.i = t1.e(z);
        }
        if ((this.b & 16) != 0) {
            this.j = t1.e(z);
        }
    }

    @Override // ir.nasim.C8285Vh7, ir.nasim.AbstractC12724f57
    public void c(T1 t1) {
        t1.m(l);
        int i = this.c ? this.b | 2 : this.b & (-3);
        this.b = i;
        int i2 = this.d ? i | 4 : i & (-5);
        this.b = i2;
        t1.m(i2);
        if ((this.b & 1) != 0) {
            t1.m(this.e);
        }
        if ((this.b & 16) != 0) {
            t1.m(this.f);
        }
        if ((this.b & 8) != 0) {
            t1.m(this.i);
        }
        if ((this.b & 16) != 0) {
            t1.m(this.j);
        }
    }
}
