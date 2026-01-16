package ir.nasim;

/* renamed from: ir.nasim.Za7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C9231Za7 extends M57 {
    public int F;
    public byte[] G;
    public C3518Be7 H;
    public String I;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.F = iE;
        this.s = (iE & 4) != 0;
        this.t = (iE & 8) != 0;
        this.u = t1.g(z);
        this.w = t1.f(z);
        this.G = t1.c(z);
        if ((this.F & 1) != 0) {
            this.H = C3518Be7.d(t1, t1.e(z), z);
        }
        if ((this.F & 2) != 0) {
            this.I = t1.g(z);
        }
    }
}
