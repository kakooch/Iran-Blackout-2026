package ir.nasim;

/* renamed from: ir.nasim.l97, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C16373l97 extends C57 {
    public String z;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.f = iE;
        this.y = (iE & 2) != 0;
        this.z = t1.g(z);
        if ((this.f & 1) != 0) {
            this.g = t1.e(z);
        }
    }
}
