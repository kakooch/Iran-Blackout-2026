package ir.nasim;

/* renamed from: ir.nasim.Sc7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C7533Sc7 extends U57 {
    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        this.c = (iE & 4) != 0;
        this.d = (iE & 8) != 0;
        this.e = t1.e(z);
        if ((this.b & 1) != 0) {
            this.f = Z57.d(t1, t1.e(z), z);
        }
        if ((this.b & 2) != 0) {
            this.g = t1.e(z);
        }
    }
}
