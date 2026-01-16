package ir.nasim;

/* loaded from: classes7.dex */
public class M67 extends C67 {
    @Override // ir.nasim.C67, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.e = iE;
        this.g = (iE & 1) != 0;
        this.h = (iE & 2) != 0;
        this.j = (iE & 4) != 0;
        this.t = (iE & 16) != 0;
        this.p = (iE & 32) != 0;
        this.u = (iE & 128) != 0;
        this.q = (iE & 256) != 0;
        this.v = (iE & 512) != 0;
        this.w = (iE & 2048) != 0;
        this.b = t1.e(z);
        this.r = t1.f(z);
        this.c = t1.g(z);
        if ((this.e & 64) != 0) {
            this.x = t1.g(z);
        }
        this.m = AbstractC16333l57.d(t1, t1.e(z), z);
        this.d = t1.e(z);
        this.o = t1.e(z);
        if ((this.e & 512) != 0) {
            t1.g(z);
        }
    }
}
