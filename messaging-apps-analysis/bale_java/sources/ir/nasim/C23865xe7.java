package ir.nasim;

/* renamed from: ir.nasim.xe7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C23865xe7 extends AbstractC12724f57 {
    public static int j = -1282352120;
    public int b;
    public String c;
    public long d;
    public String e;
    public String f;
    public long g;
    public String h;
    public int i;

    public static C23865xe7 d(T1 t1, int i, boolean z) {
        if (j != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_pageRelatedArticle", Integer.valueOf(i)));
            }
            return null;
        }
        C23865xe7 c23865xe7 = new C23865xe7();
        c23865xe7.b(t1, z);
        return c23865xe7;
    }

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = t1.e(z);
        this.c = t1.g(z);
        this.d = t1.f(z);
        if ((this.b & 1) != 0) {
            this.e = t1.g(z);
        }
        if ((this.b & 2) != 0) {
            this.f = t1.g(z);
        }
        if ((this.b & 4) != 0) {
            this.g = t1.f(z);
        }
        if ((this.b & 8) != 0) {
            this.h = t1.g(z);
        }
        if ((this.b & 16) != 0) {
            this.i = t1.e(z);
        }
    }
}
