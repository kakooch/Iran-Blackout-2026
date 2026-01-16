package ir.nasim;

/* renamed from: ir.nasim.Bh7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C3545Bh7 extends AbstractC19652qi7 {
    @Override // ir.nasim.AbstractC12724f57
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
        this.w = (2097152 & iE) != 0;
        this.x = (8388608 & iE) != 0;
        this.y = (16777216 & iE) != 0;
        this.z = (33554432 & iE) != 0;
        this.A = (67108864 & iE) != 0;
        this.L = (134217728 & iE) != 0;
        this.B = (iE & 268435456) != 0;
        this.b = t1.f(z);
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
            int iE2 = t1.e(z);
            if (iE2 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE2)));
                }
                return;
            }
            int iE3 = t1.e(z);
            for (int i = 0; i < iE3; i++) {
                C5882Lf7 c5882Lf7D = C5882Lf7.d(t1, t1.e(z), z);
                if (c5882Lf7D == null) {
                    return;
                }
                this.K.add(c5882Lf7D);
            }
        }
        if ((this.j & 524288) != 0) {
            this.G = t1.g(z);
        }
        if ((this.j & 4194304) != 0) {
            this.H = t1.g(z);
        }
    }
}
