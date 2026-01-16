package ir.nasim;

/* renamed from: ir.nasim.ae7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C9840ae7 extends W57 {
    public int e;
    public long f;
    public C18430oe7 g;
    public String h;
    public long i;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.e = t1.e(z);
        this.f = t1.f(z);
        this.g = C18430oe7.d(t1, t1.e(z), z);
        if ((this.e & 1) != 0) {
            this.h = t1.g(z);
        }
        if ((this.e & 1) != 0) {
            this.i = t1.f(z);
        }
    }
}
