package ir.nasim;

/* renamed from: ir.nasim.i67, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC14559i67 extends AbstractC12724f57 {
    public int b;
    public int c;
    public boolean d;
    public AbstractC13961h67 e;
    public int f;

    public static AbstractC14559i67 d(T1 t1, int i, boolean z) {
        C24465yf7 c24465yf7 = i != -1546531968 ? null : new C24465yf7();
        if (c24465yf7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in ReactionCount", Integer.valueOf(i)));
        }
        if (c24465yf7 != null) {
            c24465yf7.b(t1, z);
        }
        return c24465yf7;
    }
}
