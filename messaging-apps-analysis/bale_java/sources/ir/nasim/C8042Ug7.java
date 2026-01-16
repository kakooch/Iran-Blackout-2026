package ir.nasim;

/* renamed from: ir.nasim.Ug7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C8042Ug7 extends C6857Pg7 {
    public static int o = -136770336;

    @Override // ir.nasim.C6857Pg7, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        this.c = (iE & 1) != 0;
        this.d = (iE & 2) != 0;
        this.f = t1.f(z);
        this.g = t1.f(z);
        this.h = t1.g(z);
        this.i = t1.g(z);
        if ((this.b & 4) != 0) {
            this.j = AbstractC18106o57.d(t1, t1.e(z), z);
        }
        this.m = t1.e(z);
    }

    @Override // ir.nasim.C6857Pg7, ir.nasim.AbstractC12724f57
    public void c(T1 t1) {
        t1.m(o);
        int i = this.c ? this.b | 1 : this.b & (-2);
        this.b = i;
        int i2 = this.d ? i | 2 : i & (-3);
        this.b = i2;
        t1.m(i2);
        t1.n(this.f);
        t1.n(this.g);
        t1.o(this.h);
        t1.o(this.i);
        if ((this.b & 4) != 0) {
            this.j.c(t1);
        }
        t1.m(this.m);
    }
}
