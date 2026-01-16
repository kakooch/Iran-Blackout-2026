package ir.nasim;

/* renamed from: ir.nasim.cc7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C11030cc7 extends C9006Yb7 {
    @Override // ir.nasim.C9006Yb7, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        if ((iE & 1) != 0) {
            C4937He7 c4937He7 = new C4937He7();
            this.d = c4937He7;
            c4937He7.b = t1.e(z);
        }
        this.f = t1.e(z);
        if ((this.b & 2) != 0) {
            C3752Ce7 c3752Ce7 = new C3752Ce7();
            this.d = c3752Ce7;
            c3752Ce7.d = t1.e(z);
        }
        if ((this.b & 4) != 0) {
            this.g = t1.e(z);
        }
        if ((this.b & 8) != 0) {
            this.h = t1.g(z);
        }
    }
}
