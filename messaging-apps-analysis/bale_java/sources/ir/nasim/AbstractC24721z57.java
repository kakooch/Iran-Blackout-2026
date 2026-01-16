package ir.nasim;

/* renamed from: ir.nasim.z57, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC24721z57 extends AbstractC12724f57 {
    public long b;
    public int c;
    public String d;
    public String e;

    public static AbstractC24721z57 d(T1 t1, int i, boolean z) {
        AbstractC24721z57 t87 = i != -181407105 ? i != -95482955 ? null : new T87() : new S87();
        if (t87 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in InputFile", Integer.valueOf(i)));
        }
        if (t87 != null) {
            t87.b(t1, z);
        }
        return t87;
    }
}
