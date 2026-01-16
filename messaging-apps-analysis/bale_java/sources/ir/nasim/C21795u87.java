package ir.nasim;

/* renamed from: ir.nasim.u87, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C21795u87 extends AbstractC12724f57 {
    public static int j = -1107729093;
    public int b;
    public long c;
    public long d;
    public String e;
    public String f;
    public String g;
    public AbstractC10736c67 h;
    public AbstractC18106o57 i;

    public static C21795u87 d(T1 t1, int i, boolean z) {
        if (j != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_game", Integer.valueOf(i)));
            }
            return null;
        }
        C21795u87 c21795u87 = new C21795u87();
        c21795u87.b(t1, z);
        return c21795u87;
    }

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = t1.e(z);
        this.c = t1.f(z);
        this.d = t1.f(z);
        this.e = t1.g(z);
        this.f = t1.g(z);
        this.g = t1.g(z);
        this.h = AbstractC10736c67.d(t1, t1.e(z), z);
        if ((this.b & 1) != 0) {
            this.i = AbstractC18106o57.d(t1, t1.e(z), z);
        }
    }
}
