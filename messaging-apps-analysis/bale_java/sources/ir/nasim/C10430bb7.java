package ir.nasim;

/* renamed from: ir.nasim.bb7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C10430bb7 extends M57 {
    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.o = iE;
        this.A = (iE & 4) != 0;
        this.p = t1.f(z);
        if ((this.o & 1) != 0) {
            this.q = AbstractC10120b67.d(t1, t1.e(z), z);
        }
        if ((this.o & 2) != 0) {
            this.r = t1.e(z);
        }
    }
}
