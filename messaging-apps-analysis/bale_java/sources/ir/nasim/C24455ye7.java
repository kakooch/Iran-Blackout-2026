package ir.nasim;

/* renamed from: ir.nasim.ye7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C24455ye7 extends AbstractC12724f57 {
    public static int k = 878078826;
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public AbstractC16343l67 h;
    public int i;
    public int j;

    public static C24455ye7 d(T1 t1, int i, boolean z) {
        if (k != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_pageTableCell", Integer.valueOf(i)));
            }
            return null;
        }
        C24455ye7 c24455ye7 = new C24455ye7();
        c24455ye7.b(t1, z);
        return c24455ye7;
    }

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        this.c = (iE & 1) != 0;
        this.d = (iE & 8) != 0;
        this.e = (iE & 16) != 0;
        this.f = (iE & 32) != 0;
        this.g = (iE & 64) != 0;
        if ((iE & 128) != 0) {
            this.h = AbstractC16343l67.d(t1, t1.e(z), z);
        }
        if ((this.b & 2) != 0) {
            this.i = t1.e(z);
        }
        if ((this.b & 4) != 0) {
            this.j = t1.e(z);
        }
    }
}
