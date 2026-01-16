package ir.nasim;

/* renamed from: ir.nasim.lc7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C16637lc7 extends C16046kc7 {
    @Override // ir.nasim.C16046kc7, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.d = iE;
        this.H = (iE & 8) != 0;
        this.J = (iE & 16) != 0;
        if ((iE & 1) != 0) {
            this.s = AbstractC18106o57.d(t1, t1.e(z), z);
        } else {
            this.s = new Q77();
        }
        if ((this.d & 4) != 0) {
            this.F = t1.e(z);
        }
    }
}
