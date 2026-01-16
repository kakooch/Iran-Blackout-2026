package ir.nasim;

/* renamed from: ir.nasim.Jf7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C5414Jf7 extends AbstractC15752k67 {
    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        this.h = Boolean.valueOf((iE & 32) != 0);
        this.c = Boolean.valueOf((this.b & 1) != 0);
        if ((this.b & 8) != 0) {
            this.f = Boolean.valueOf(t1.a(z));
        }
        if ((this.b & 16) != 0) {
            this.g = Boolean.valueOf(t1.a(z));
        }
        if ((this.b & 2) != 0) {
            this.d = U67.d(t1, t1.e(z), z);
        }
        if ((this.b & 4) != 0) {
            this.e = U67.d(t1, t1.e(z), z);
        }
    }
}
