package ir.nasim;

/* loaded from: classes7.dex */
public class Z87 extends AbstractC12724f57 {
    public static int d = -659913713;
    public long b;
    public long c;

    public static Z87 d(T1 t1, int i, boolean z) {
        if (d != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_inputGroupCall", Integer.valueOf(i)));
            }
            return null;
        }
        Z87 z87 = new Z87();
        z87.b(t1, z);
        return z87;
    }

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = t1.f(z);
        this.c = t1.f(z);
    }
}
