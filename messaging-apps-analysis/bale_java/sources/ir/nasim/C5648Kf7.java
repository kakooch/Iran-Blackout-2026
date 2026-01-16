package ir.nasim;

/* renamed from: ir.nasim.Kf7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C5648Kf7 extends AbstractC15752k67 {
    public Boolean i;
    public Boolean j;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        if ((iE & 1) != 0) {
            this.i = Boolean.valueOf(t1.a(z));
        }
        if ((this.b & 2) != 0) {
            this.j = Boolean.valueOf(t1.a(z));
        }
    }
}
