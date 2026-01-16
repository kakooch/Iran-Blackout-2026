package ir.nasim;

/* renamed from: ir.nasim.Uc7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C8006Uc7 extends L57 {
    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.i = iE;
        this.l = (iE & 2) != 0;
        this.j = (iE & 16) != 0;
        this.k = (iE & 32) != 0;
        this.u = (iE & 8192) != 0;
        this.v = (iE & 16384) != 0;
        this.x = (iE & 524288) != 0;
        this.b = t1.e(z);
        if ((this.i & 256) != 0) {
            this.c = Z57.d(t1, t1.e(z), z);
        }
        this.d = Z57.d(t1, t1.e(z), z);
        if ((this.i & 8) != 0) {
            this.C = U57.d(t1, t1.e(z), z);
        }
        this.e = t1.e(z);
        this.f = M57.d(t1, t1.e(z), z);
        if ((this.i & 33554432) != 0) {
            this.H = t1.e(z);
        }
    }
}
