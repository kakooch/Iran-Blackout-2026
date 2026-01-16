package ir.nasim;

/* renamed from: ir.nasim.oe7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C18430oe7 extends AbstractC12724f57 {
    public static int d = 1869903447;
    public AbstractC16343l67 b;
    public AbstractC16343l67 c;

    public static C18430oe7 d(T1 t1, int i, boolean z) {
        if (d != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_pageCaption", Integer.valueOf(i)));
            }
            return null;
        }
        C18430oe7 c18430oe7 = new C18430oe7();
        c18430oe7.b(t1, z);
        return c18430oe7;
    }

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = AbstractC16343l67.d(t1, t1.e(z), z);
        this.c = AbstractC16343l67.d(t1, t1.e(z), z);
    }
}
