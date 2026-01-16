package ir.nasim;

/* renamed from: ir.nasim.i77, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C14569i77 extends T67 {
    @Override // ir.nasim.T67, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.e = iE;
        this.g = (iE & 1) != 0;
        this.h = (iE & 2) != 0;
        this.j = (iE & 4) != 0;
        this.i = (iE & 32) != 0;
        this.b = t1.e(z);
        this.c = t1.g(z);
        this.m = AbstractC16333l57.d(t1, t1.e(z), z);
        this.n = t1.e(z);
        this.d = t1.e(z);
        this.o = t1.e(z);
        if ((this.e & 64) != 0) {
            this.O = AbstractC22951w57.d(t1, t1.e(z), z);
        }
    }
}
