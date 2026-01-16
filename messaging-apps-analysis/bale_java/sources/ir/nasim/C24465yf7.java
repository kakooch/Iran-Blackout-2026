package ir.nasim;

/* renamed from: ir.nasim.yf7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C24465yf7 extends AbstractC14559i67 {
    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        boolean z2 = (iE & 1) != 0;
        this.d = z2;
        if (z2) {
            this.c = t1.e(z);
        }
        this.e = AbstractC13961h67.d(t1, t1.e(z), z);
        this.f = t1.e(z);
    }
}
