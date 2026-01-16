package ir.nasim;

/* renamed from: ir.nasim.j57, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC15151j57 extends AbstractC12724f57 {
    public int b;
    public long c;
    public long d;
    public String e;
    public String f;
    public String g;
    public AbstractC10736c67 h;
    public AbstractC18106o57 i;
    public long j;

    public static AbstractC15151j57 d(T1 t1, int i, boolean z) {
        AbstractC15151j57 b67 = i != -1778593322 ? i != 1571189943 ? null : new B67() : new A67();
        if (b67 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in BotApp", Integer.valueOf(i)));
        }
        if (b67 != null) {
            b67.b(t1, z);
        }
        return b67;
    }
}
