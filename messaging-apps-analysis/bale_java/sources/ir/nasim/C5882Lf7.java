package ir.nasim;

/* renamed from: ir.nasim.Lf7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C5882Lf7 extends AbstractC12724f57 {
    public static int e = -797791052;
    public String b;
    public String c;
    public String d;

    public static C5882Lf7 d(T1 t1, int i, boolean z) {
        if (e != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_restrictionReason", Integer.valueOf(i)));
            }
            return null;
        }
        C5882Lf7 c5882Lf7 = new C5882Lf7();
        c5882Lf7.b(t1, z);
        return c5882Lf7;
    }

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = t1.g(z);
        this.c = t1.g(z);
        this.d = t1.g(z);
    }
}
