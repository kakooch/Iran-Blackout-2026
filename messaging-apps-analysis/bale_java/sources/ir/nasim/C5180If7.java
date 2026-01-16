package ir.nasim;

/* renamed from: ir.nasim.If7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C5180If7 extends AbstractC15752k67 {
    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        this.c = Boolean.valueOf((iE & 1) != 0);
        if ((this.b & 8) != 0) {
            this.f = Boolean.valueOf(t1.a(z));
        }
        if ((this.b & 2) != 0) {
            this.d = U67.d(t1, t1.e(z), z);
        }
        if ((this.b & 4) != 0) {
            this.e = U67.d(t1, t1.e(z), z);
        }
    }
}
