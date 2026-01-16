package ir.nasim;

/* renamed from: ir.nasim.Eh7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C4247Eh7 extends C8776Xg7 {
    @Override // ir.nasim.C8776Xg7, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.j = iE;
        this.l = (iE & 1024) != 0;
        this.m = (iE & 2048) != 0;
        this.n = (iE & 4096) != 0;
        this.o = (iE & 8192) != 0;
        this.p = (iE & 16384) != 0;
        this.q = (32768 & iE) != 0;
        this.r = (65536 & iE) != 0;
        this.t = (131072 & iE) != 0;
        this.u = (iE & 262144) != 0;
        this.v = (1048576 & iE) != 0;
        this.w = (iE & 2097152) != 0;
        this.b = t1.e(z);
        if ((this.j & 1) != 0) {
            this.f = t1.f(z);
        }
        if ((this.j & 2) != 0) {
            this.c = t1.g(z);
        }
        if ((this.j & 4) != 0) {
            this.d = t1.g(z);
        }
        if ((this.j & 8) != 0) {
            this.e = t1.g(z);
        }
        if ((this.j & 16) != 0) {
            this.g = t1.g(z);
        }
        if ((this.j & 32) != 0) {
            this.h = AbstractC20852si7.d(t1, t1.e(z), z);
        }
        if ((this.j & 64) != 0) {
            this.i = AbstractC21539ti7.d(t1, t1.e(z), z);
        }
        if ((this.j & 16384) != 0) {
            this.F = t1.e(z);
        }
        if ((this.j & 262144) != 0) {
            t1.g(z);
        }
        if ((this.j & 524288) != 0) {
            this.G = t1.g(z);
        }
    }
}
