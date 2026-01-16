package ir.nasim;

/* renamed from: ir.nasim.oa7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C18390oa7 extends AbstractC12724f57 {
    public static int f = -1361650766;
    public int b;
    public double c;
    public double d;
    public double e;

    public static C18390oa7 d(T1 t1, int i, boolean z) {
        if (f != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_maskCoords", Integer.valueOf(i)));
            }
            return null;
        }
        C18390oa7 c18390oa7 = new C18390oa7();
        c18390oa7.b(t1, z);
        return c18390oa7;
    }

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = t1.e(z);
        this.c = t1.d(z);
        this.d = t1.d(z);
        this.e = t1.d(z);
    }

    @Override // ir.nasim.AbstractC12724f57
    public void c(T1 t1) {
        t1.m(f);
        t1.m(this.b);
        t1.l(this.c);
        t1.l(this.d);
        t1.l(this.e);
    }
}
