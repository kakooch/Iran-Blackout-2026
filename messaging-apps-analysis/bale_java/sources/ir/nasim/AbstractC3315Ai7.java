package ir.nasim;

/* renamed from: ir.nasim.Ai7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC3315Ai7 extends AbstractC12724f57 {
    public int b;

    public static AbstractC3315Ai7 d(T1 t1, int i, boolean z) {
        AbstractC3315Ai7 c12497ei7 = i != -1818605967 ? i != 1421174295 ? null : new C12497ei7() : new C11885di7();
        if (c12497ei7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in contacts_Contacts", Integer.valueOf(i)));
        }
        if (c12497ei7 != null) {
            c12497ei7.b(t1, z);
        }
        return c12497ei7;
    }
}
