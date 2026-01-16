package ir.nasim;

/* renamed from: ir.nasim.Vb7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C8231Vb7 extends O57 {
    public int b;
    public int c;
    public int d;
    public AbstractC11500d67 e;
    public int f;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        if ((iE & 1) != 0) {
            this.c = t1.e(z);
        }
        if ((this.b & 1) != 0) {
            this.d = t1.e(z);
        }
        if ((this.b & 2) != 0) {
            this.e = AbstractC11500d67.d(0L, 0L, 0L, t1, t1.e(z), z);
        }
        if ((this.b & 4) != 0) {
            this.f = t1.e(z);
        }
    }
}
