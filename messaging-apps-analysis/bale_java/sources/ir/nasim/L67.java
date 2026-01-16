package ir.nasim;

/* loaded from: classes7.dex */
public class L67 extends C67 {
    @Override // ir.nasim.C67, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.e = iE;
        this.g = (iE & 1) != 0;
        this.j = (iE & 4) != 0;
        this.p = (iE & 32) != 0;
        this.u = (iE & 128) != 0;
        this.q = (iE & 256) != 0;
        this.v = (iE & 512) != 0;
        this.w = (iE & 2048) != 0;
        this.y = (iE & 4096) != 0;
        this.z = (524288 & iE) != 0;
        this.A = (1048576 & iE) != 0;
        this.k = (2097152 & iE) != 0;
        this.l = (4194304 & iE) != 0;
        this.C = (8388608 & iE) != 0;
        this.D = (16777216 & iE) != 0;
        this.E = (33554432 & iE) != 0;
        this.F = (67108864 & iE) != 0;
        this.G = (134217728 & iE) != 0;
        this.P = (268435456 & iE) != 0;
        this.Q = (536870912 & iE) != 0;
        this.H = (iE & 1073741824) != 0;
        this.b = t1.f(z);
        if ((this.e & 8192) != 0) {
            this.r = t1.f(z);
        }
        this.c = t1.g(z);
        if ((this.e & 64) != 0) {
            this.x = t1.g(z);
        }
        this.m = AbstractC16333l57.d(t1, t1.e(z), z);
        this.d = t1.e(z);
        if ((this.e & 512) != 0) {
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
                this.I.add(c5882Lf7D);
            }
        }
        if ((this.e & 16384) != 0) {
            this.L = U67.d(t1, t1.e(z), z);
        }
        if ((this.e & 32768) != 0) {
            this.M = V67.d(t1, t1.e(z), z);
        }
        if ((this.e & 262144) != 0) {
            this.N = V67.d(t1, t1.e(z), z);
        }
        if ((this.e & 131072) != 0) {
            this.n = t1.e(z);
        }
    }
}
