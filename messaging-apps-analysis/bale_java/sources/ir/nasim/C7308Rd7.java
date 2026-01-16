package ir.nasim;

/* renamed from: ir.nasim.Rd7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C7308Rd7 extends C6336Nd7 {
    @Override // ir.nasim.C6336Nd7, ir.nasim.AbstractC12724f57
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
        this.k = t1.e(z);
        this.l = t1.e(z);
        C18430oe7 c18430oe7 = new C18430oe7();
        this.m = c18430oe7;
        c18430oe7.b = AbstractC16343l67.d(t1, t1.e(z), z);
        this.m.c = new C4004Dg7();
    }
}
