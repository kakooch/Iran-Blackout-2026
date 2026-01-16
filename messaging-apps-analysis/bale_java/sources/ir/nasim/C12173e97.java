package ir.nasim;

/* renamed from: ir.nasim.e97, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C12173e97 extends C57 {
    public String A;
    public AbstractC24131y57 z;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.f = iE;
        this.y = (iE & 4) != 0;
        this.z = AbstractC24131y57.d(t1, t1.e(z), z);
        if ((this.f & 1) != 0) {
            this.g = t1.e(z);
        }
        if ((this.f & 2) != 0) {
            this.A = t1.g(z);
        }
    }
}
