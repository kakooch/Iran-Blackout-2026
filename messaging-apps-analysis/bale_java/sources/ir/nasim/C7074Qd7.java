package ir.nasim;

/* renamed from: ir.nasim.Qd7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C7074Qd7 extends C6336Nd7 {
    public int n;
    public boolean o;
    public boolean p;
    public String q;
    public String r;
    public int s;
    public int t;
    public AbstractC16343l67 u;

    @Override // ir.nasim.C6336Nd7, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.n = iE;
        this.o = (iE & 1) != 0;
        this.p = (iE & 8) != 0;
        if ((iE & 2) != 0) {
            this.q = t1.g(z);
        }
        if ((this.n & 4) != 0) {
            this.r = t1.g(z);
        }
        this.s = t1.e(z);
        this.t = t1.e(z);
        this.u = AbstractC16343l67.d(t1, t1.e(z), z);
    }
}
