package ir.nasim;

/* renamed from: ir.nasim.Nd7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C6336Nd7 extends W57 {
    public int e;
    public boolean f;
    public boolean g;
    public String h;
    public String i;
    public long j;
    public int k;
    public int l;
    public C18430oe7 m;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.e = iE;
        this.f = (iE & 1) != 0;
        this.g = (iE & 8) != 0;
        if ((iE & 2) != 0) {
            this.h = t1.g(z);
        }
        if ((this.e & 4) != 0) {
            this.i = t1.g(z);
        }
        if ((this.e & 16) != 0) {
            this.j = t1.f(z);
        }
        if ((this.e & 32) != 0) {
            this.k = t1.e(z);
        }
        if ((this.e & 32) != 0) {
            this.l = t1.e(z);
        }
        this.m = C18430oe7.d(t1, t1.e(z), z);
    }
}
