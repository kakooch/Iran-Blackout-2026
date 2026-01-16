package ir.nasim;

/* renamed from: ir.nasim.ff7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C13103ff7 extends AbstractC12724f57 {
    public static int d = 1823064809;
    public String b;
    public byte[] c;

    public static C13103ff7 d(T1 t1, int i, boolean z) {
        if (d != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_pollAnswer", Integer.valueOf(i)));
            }
            return null;
        }
        C13103ff7 c13103ff7 = new C13103ff7();
        c13103ff7.b(t1, z);
        return c13103ff7;
    }

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = t1.g(z);
        this.c = t1.c(z);
    }
}
