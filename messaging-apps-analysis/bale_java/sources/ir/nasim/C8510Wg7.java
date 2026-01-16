package ir.nasim;

/* renamed from: ir.nasim.Wg7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C8510Wg7 extends C6857Pg7 {
    public static int o = -402474788;

    @Override // ir.nasim.C6857Pg7, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        this.c = (iE & 1) != 0;
        this.d = (iE & 2) != 0;
        this.e = (iE & 32) != 0;
        this.f = t1.f(z);
        this.g = t1.f(z);
        this.h = t1.g(z);
        this.i = t1.g(z);
        if ((this.b & 4) != 0) {
            this.j = AbstractC18106o57.d(t1, t1.e(z), z);
        }
        if ((this.b & 8) != 0) {
            this.k.add(AbstractC19061pi7.d(t1, t1.e(z), z));
        }
        if ((this.b & 16) != 0) {
            this.m = t1.e(z);
        }
    }

    @Override // ir.nasim.C6857Pg7, ir.nasim.AbstractC12724f57
    public void c(T1 t1) {
        t1.m(o);
        int i = this.c ? this.b | 1 : this.b & (-2);
        this.b = i;
        int i2 = this.d ? i | 2 : i & (-3);
        this.b = i2;
        int i3 = this.e ? i2 | 32 : i2 & (-33);
        this.b = i3;
        t1.m(i3);
        t1.n(this.f);
        t1.n(this.g);
        t1.o(this.h);
        t1.o(this.i);
        if ((this.b & 4) != 0) {
            this.j.c(t1);
        }
        if ((this.b & 8) != 0) {
            ((AbstractC19061pi7) this.k.get(0)).c(t1);
        }
        if ((this.b & 16) != 0) {
            t1.m(this.m);
        }
    }
}
