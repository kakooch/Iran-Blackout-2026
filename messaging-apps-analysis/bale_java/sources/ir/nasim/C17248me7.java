package ir.nasim;

/* renamed from: ir.nasim.me7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C17248me7 extends W57 {
    public int e;
    public boolean f;
    public boolean g;
    public long h;
    public C18430oe7 i;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.e = iE;
        this.f = (iE & 1) != 0;
        this.g = (iE & 2) != 0;
        this.h = t1.f(z);
        this.i = C18430oe7.d(t1, t1.e(z), z);
    }
}
