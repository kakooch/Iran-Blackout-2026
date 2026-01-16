package ir.nasim;

/* renamed from: ir.nasim.q57, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC19288q57 extends AbstractC12724f57 {
    public static AbstractC19288q57 d(T1 t1, int i, boolean z) {
        AbstractC19288q57 c9546a87 = i != -1835310691 ? i != -97474361 ? i != 769727150 ? null : new C9546a87() : new C10140b87() : new Z77();
        if (c9546a87 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in EmojiStatus", Integer.valueOf(i)));
        }
        if (c9546a87 != null) {
            c9546a87.b(t1, z);
        }
        return c9546a87;
    }
}
