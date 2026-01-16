package ir.nasim;

/* renamed from: ir.nasim.wc7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C23255wc7 extends Q57 {
    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.d = iE;
        this.J = (iE & 8) != 0;
        if ((iE & 1) != 0) {
            this.f = AbstractC10736c67.d(t1, t1.e(z), z);
        } else {
            this.f = new C7083Qe7();
        }
        if ((this.d & 4) != 0) {
            this.F = t1.e(z);
        }
    }
}
