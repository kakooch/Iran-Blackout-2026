package ir.nasim;

/* renamed from: ir.nasim.ac7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C9820ac7 extends C9006Yb7 {
    @Override // ir.nasim.C9006Yb7, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        if ((iE & 1) != 0) {
            C4937He7 c4937He7 = new C4937He7();
            this.d = c4937He7;
            c4937He7.b = t1.e(z);
        }
        if ((this.b & 32) != 0) {
            this.e = t1.g(z);
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
        if ((this.b & 16) != 0) {
            this.i = Z57.d(t1, t1.e(z), z);
        }
        if ((this.b & 16) != 0) {
            this.j = t1.e(z);
        }
        if ((this.b & 64) != 0) {
            this.k = t1.g(z);
        }
    }
}
