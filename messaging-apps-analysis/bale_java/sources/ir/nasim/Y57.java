package ir.nasim;

/* loaded from: classes7.dex */
public abstract class Y57 extends AbstractC12724f57 {
    public static Y57 d(T1 t1, int i, boolean z) {
        Y57 c22089ue7 = i != -1730311882 ? i != 1577484359 ? null : new C22089ue7() : new C21432te7();
        if (c22089ue7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in PageListOrderedItem", Integer.valueOf(i)));
        }
        if (c22089ue7 != null) {
            c22089ue7.b(t1, z);
        }
        return c22089ue7;
    }
}
