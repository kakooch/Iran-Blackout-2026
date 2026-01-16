package ir.nasim;

/* renamed from: ir.nasim.ra7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C20163ra7 extends M57 {
    public boolean F;
    public String G;
    public AbstractC15151j57 H;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.o = iE;
        this.F = (iE & 2) != 0;
        if ((iE & 1) != 0) {
            this.G = t1.g(z);
        }
        if ((this.o & 4) != 0) {
            this.H = AbstractC15151j57.d(t1, t1.e(z), z);
        }
    }
}
