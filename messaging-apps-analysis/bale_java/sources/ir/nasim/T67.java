package ir.nasim;

/* loaded from: classes7.dex */
public class T67 extends AbstractC15742k57 {
    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        h(t1, z, true);
    }

    public void h(T1 t1, boolean z, boolean z2) {
        int iE = t1.e(z);
        this.e = iE;
        this.g = (iE & 1) != 0;
        this.h = (iE & 2) != 0;
        this.j = (iE & 4) != 0;
        this.i = (iE & 32) != 0;
        this.C = (8388608 & iE) != 0;
        this.D = (16777216 & iE) != 0;
        this.G = (iE & 33554432) != 0;
        this.b = t1.f(z);
        this.c = t1.g(z);
        this.m = AbstractC16333l57.e(t1, t1.e(z), z, z2);
        this.n = t1.e(z);
        this.d = t1.e(z);
        this.o = t1.e(z);
        if ((this.e & 64) != 0) {
            this.O = AbstractC22951w57.d(t1, t1.e(z), z);
        }
        if ((this.e & 16384) != 0) {
            this.L = U67.d(t1, t1.e(z), z);
        }
        if ((this.e & 262144) != 0) {
            this.N = V67.d(t1, t1.e(z), z);
        }
    }
}
