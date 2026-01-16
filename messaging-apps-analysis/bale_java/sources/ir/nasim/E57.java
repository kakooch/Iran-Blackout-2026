package ir.nasim;

/* loaded from: classes7.dex */
public abstract class E57 extends AbstractC12724f57 {
    public long b;
    public long c;
    public byte[] d;

    public static E57 d(T1 t1, int i, boolean z) {
        E57 d97 = i != 483901197 ? i != 1001634122 ? null : new D97() : new E97();
        if (d97 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in InputPhoto", Integer.valueOf(i)));
        }
        if (d97 != null) {
            d97.b(t1, z);
        }
        return d97;
    }
}
