package ir.nasim;

/* renamed from: ir.nasim.Gh7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C4730Gh7 extends AbstractC12724f57 {
    public static int f = -1274595769;
    public int b;
    public boolean c;
    public boolean d;
    public String e;

    public static C4730Gh7 d(T1 t1, int i, boolean z) {
        if (f != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_username", Integer.valueOf(i)));
            }
            return null;
        }
        C4730Gh7 c4730Gh7 = new C4730Gh7();
        c4730Gh7.b(t1, z);
        return c4730Gh7;
    }

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        this.c = (iE & 1) != 0;
        this.d = (iE & 2) != 0;
        this.e = t1.g(z);
    }
}
