package ir.nasim;

/* renamed from: ir.nasim.nc7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C17819nc7 extends C16046kc7 {
    @Override // ir.nasim.C16046kc7, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.d = iE;
        if ((iE & 1) != 0) {
            this.s = AbstractC18106o57.d(t1, t1.e(z), z);
        } else {
            this.s = new Q77();
        }
        if ((this.d & 2) != 0) {
            this.u = t1.g(z);
        }
        if ((this.d & 4) != 0) {
            this.F = t1.e(z);
        }
    }
}
