package ir.nasim;

/* renamed from: ir.nasim.Yh7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C9060Yh7 extends C7578Sh7 {
    public static int m = -263220756;

    @Override // ir.nasim.C7578Sh7, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = t1.f(z);
        int iE = t1.e(z);
        this.c = iE;
        this.d = (iE & 1) != 0;
        this.e = (iE & 2) != 0;
        this.h = t1.f(z);
        this.i = t1.g(z);
        this.j = AbstractC18106o57.d(t1, t1.e(z), z);
    }

    @Override // ir.nasim.C7578Sh7, ir.nasim.AbstractC12724f57
    public void c(T1 t1) {
        t1.m(m);
        t1.n(this.b);
        int i = this.d ? this.c | 1 : this.c & (-2);
        this.c = i;
        int i2 = this.e ? i | 2 : i & (-3);
        this.c = i2;
        t1.m(i2);
        t1.n(this.h);
        t1.o(this.i);
        this.j.c(t1);
    }
}
