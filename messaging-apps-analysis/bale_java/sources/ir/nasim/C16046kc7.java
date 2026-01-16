package ir.nasim;

/* renamed from: ir.nasim.kc7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C16046kc7 extends Q57 {
    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.d = iE;
        this.H = (iE & 8) != 0;
        this.J = (iE & 16) != 0;
        if ((iE & 1) != 0) {
            this.s = AbstractC18106o57.d(t1, t1.e(z), z);
        }
        if ((this.d & 32) != 0) {
            this.t = AbstractC18106o57.d(t1, t1.e(z), z);
        }
        if ((this.d & 4) != 0) {
            this.F = t1.e(z);
        }
    }
}
