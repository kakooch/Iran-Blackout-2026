package ir.nasim;

/* renamed from: ir.nasim.bc7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C10440bc7 extends C9006Yb7 {
    @Override // ir.nasim.C9006Yb7, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        if ((iE & 1) != 0) {
            C3752Ce7 c3752Ce7 = new C3752Ce7();
            this.d = c3752Ce7;
            c3752Ce7.b = t1.e(z);
        }
        this.f = t1.e(z);
        if ((this.b & 2) != 0) {
            C3752Ce7 c3752Ce72 = new C3752Ce7();
            this.d = c3752Ce72;
            c3752Ce72.d = t1.e(z);
        }
        if ((this.b & 4) != 0) {
            this.g = t1.e(z);
        }
    }
}
