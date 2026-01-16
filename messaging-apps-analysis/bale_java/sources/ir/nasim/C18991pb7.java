package ir.nasim;

/* renamed from: ir.nasim.pb7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C18991pb7 extends M57 {
    public long F;
    public boolean G;
    public boolean H;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.o = iE;
        if ((iE & 1) != 0) {
            this.b = t1.g(z);
        }
        if ((this.o & 2) != 0) {
            this.F = t1.f(z);
        }
        if ((this.o & 4) != 0) {
            this.G = t1.a(z);
        }
        if ((this.o & 8) != 0) {
            this.H = t1.a(z);
        }
    }
}
