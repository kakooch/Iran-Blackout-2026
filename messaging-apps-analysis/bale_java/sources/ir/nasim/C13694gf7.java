package ir.nasim;

/* renamed from: ir.nasim.gf7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C13694gf7 extends AbstractC12724f57 {
    public static int g = 997055186;
    public int b;
    public boolean c;
    public boolean d;
    public byte[] e;
    public int f;

    public static C13694gf7 d(T1 t1, int i, boolean z) {
        if (g != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_pollAnswerVoters", Integer.valueOf(i)));
            }
            return null;
        }
        C13694gf7 c13694gf7 = new C13694gf7();
        c13694gf7.b(t1, z);
        return c13694gf7;
    }

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        this.c = (iE & 1) != 0;
        this.d = (iE & 2) != 0;
        this.e = t1.c(z);
        this.f = t1.e(z);
    }
}
