package ir.nasim;

import java.util.Map;

/* renamed from: ir.nasim.k1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC15694k1 extends AbstractC21043t1 {
    public abstract boolean C(Map.Entry entry);

    public abstract /* bridge */ boolean E(Map.Entry entry);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return j((Map.Entry) obj);
        }
        return false;
    }

    public final boolean j(Map.Entry entry) {
        AbstractC13042fc3.i(entry, "element");
        return C(entry);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            return E((Map.Entry) obj);
        }
        return false;
    }
}
