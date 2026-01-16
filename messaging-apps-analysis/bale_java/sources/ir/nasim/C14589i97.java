package ir.nasim;

/* renamed from: ir.nasim.i97, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C14589i97 extends C57 {
    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.f = iE;
        this.t = (iE & 1) != 0;
        this.h = B57.d(t1, t1.e(z), z);
        if ((this.f & 4) != 0) {
            this.p = t1.e(z);
        }
        if ((this.f & 2) != 0) {
            this.q = t1.e(z);
        }
        if ((this.f & 8) != 0) {
            this.x = t1.e(z);
        }
    }
}
