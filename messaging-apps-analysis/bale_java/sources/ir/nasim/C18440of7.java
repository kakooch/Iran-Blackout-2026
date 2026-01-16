package ir.nasim;

/* renamed from: ir.nasim.of7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C18440of7 extends AbstractC12724f57 {
    public static int h = 512535275;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    public static C18440of7 d(T1 t1, int i, boolean z) {
        if (h != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_postAddress", Integer.valueOf(i)));
            }
            return null;
        }
        C18440of7 c18440of7 = new C18440of7();
        c18440of7.b(t1, z);
        return c18440of7;
    }

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = t1.g(z);
        this.c = t1.g(z);
        this.d = t1.g(z);
        this.e = t1.g(z);
        this.f = t1.g(z);
        this.g = t1.g(z);
    }
}
