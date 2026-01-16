package ir.nasim;

/* loaded from: classes7.dex */
public abstract class X57 extends AbstractC12724f57 {
    public static X57 d(T1 t1, int i, boolean z) {
        X57 c20219re7 = i != -1188055347 ? i != 635466748 ? null : new C20219re7() : new C20812se7();
        if (c20219re7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in PageListItem", Integer.valueOf(i)));
        }
        if (c20219re7 != null) {
            c20219re7.b(t1, z);
        }
        return c20219re7;
    }
}
