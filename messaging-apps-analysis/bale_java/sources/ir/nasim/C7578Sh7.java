package ir.nasim;

/* renamed from: ir.nasim.Sh7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C7578Sh7 extends AbstractC23315wi7 {
    public static int l = -1539849235;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = t1.f(z);
        int iE = t1.e(z);
        this.c = iE;
        this.d = (iE & 1) != 0;
        this.e = (iE & 2) != 0;
        this.f = (iE & 8) != 0;
        this.g = (iE & 16) != 0;
        this.h = t1.f(z);
        this.i = t1.g(z);
        this.j = AbstractC18106o57.d(t1, t1.e(z), z);
        if ((this.c & 4) != 0) {
            this.k = AbstractC23905xi7.d(t1, t1.e(z), z);
        }
    }

    @Override // ir.nasim.AbstractC12724f57
    public void c(T1 t1) {
        t1.m(l);
        t1.n(this.b);
        int i = this.d ? this.c | 1 : this.c & (-2);
        this.c = i;
        int i2 = this.e ? i | 2 : i & (-3);
        this.c = i2;
        int i3 = this.f ? i2 | 8 : i2 & (-9);
        this.c = i3;
        int i4 = this.g ? i3 | 16 : i3 & (-17);
        this.c = i4;
        t1.m(i4);
        t1.n(this.h);
        t1.o(this.i);
        this.j.c(t1);
        if ((this.c & 4) != 0) {
            this.k.c(t1);
        }
    }
}
