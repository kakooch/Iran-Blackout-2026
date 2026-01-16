package ir.nasim;

/* renamed from: ir.nasim.uc7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C22069uc7 extends Q57 {
    public AbstractC24495yi7 N;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.d = iE;
        this.e = (iE & 2) != 0;
        this.D = (iE & 8) != 0;
        this.n = t1.g(z);
        this.j = t1.g(z);
        if ((this.d & 1) != 0) {
            this.N = AbstractC24495yi7.d(t1, t1.e(z), z);
        }
        if ((this.d & 4) != 0) {
            this.k = t1.e(z);
        }
        this.i = t1.g(z);
        this.l = t1.f(z);
        this.m = t1.g(z);
        if ((this.d & 16) != 0) {
            this.I = O57.d(t1, t1.e(z), z);
        }
    }
}
