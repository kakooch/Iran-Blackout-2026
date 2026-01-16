package ir.nasim;

/* renamed from: ir.nasim.y57, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC24131y57 extends AbstractC12724f57 {
    public long b;
    public long c;
    public byte[] d;

    public static AbstractC24131y57 d(T1 t1, int i, boolean z) {
        AbstractC24131y57 r87 = i != 448771445 ? i != 1928391342 ? null : new R87() : new Q87();
        if (r87 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in InputDocument", Integer.valueOf(i)));
        }
        if (r87 != null) {
            r87.b(t1, z);
        }
        return r87;
    }
}
