package ir.nasim;

/* renamed from: ir.nasim.Be7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C3518Be7 extends AbstractC12724f57 {
    public static int g = -1868808300;
    public int b;
    public String c;
    public String d;
    public String e;
    public C18440of7 f;

    public static C3518Be7 d(T1 t1, int i, boolean z) {
        if (g != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_paymentRequestedInfo", Integer.valueOf(i)));
            }
            return null;
        }
        C3518Be7 c3518Be7 = new C3518Be7();
        c3518Be7.b(t1, z);
        return c3518Be7;
    }

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        if ((iE & 1) != 0) {
            this.c = t1.g(z);
        }
        if ((this.b & 2) != 0) {
            this.d = t1.g(z);
        }
        if ((this.b & 4) != 0) {
            this.e = t1.g(z);
        }
        if ((this.b & 8) != 0) {
            this.f = C18440of7.d(t1, t1.e(z), z);
        }
    }
}
