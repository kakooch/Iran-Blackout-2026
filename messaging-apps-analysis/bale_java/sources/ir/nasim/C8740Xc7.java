package ir.nasim;

/* renamed from: ir.nasim.Xc7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C8740Xc7 extends C8006Uc7 {
    @Override // ir.nasim.C8006Uc7, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.i = iE;
        this.m = (iE & 1) != 0;
        this.l = (iE & 2) != 0;
        this.j = (iE & 16) != 0;
        this.k = (iE & 32) != 0;
        this.u = (iE & 8192) != 0;
        this.v = (iE & 16384) != 0;
        this.b = t1.e(z);
        if ((this.i & 256) != 0) {
            C4937He7 c4937He7 = new C4937He7();
            this.c = c4937He7;
            c4937He7.b = t1.e(z);
        }
        Z57 z57D = Z57.d(t1, t1.e(z), z);
        this.d = z57D;
        if (this.c == null) {
            this.c = z57D;
        }
        this.e = t1.e(z);
        this.f = M57.d(t1, t1.e(z), z);
    }
}
