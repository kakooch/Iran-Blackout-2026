package ir.nasim;

import java.util.Map;

/* renamed from: ir.nasim.j1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC15103j1 extends AbstractC21043t1 {
    public abstract boolean C(Map.Entry entry);

    public final boolean E(Map.Entry entry) {
        if ((entry instanceof Object ? entry : null) instanceof Map.Entry) {
            return F(entry);
        }
        return false;
    }

    public abstract boolean F(Map.Entry entry);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return j((Map.Entry) obj);
        }
        return false;
    }

    public final boolean j(Map.Entry entry) {
        if ((entry instanceof Object ? entry : null) instanceof Map.Entry) {
            return C(entry);
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            return E((Map.Entry) obj);
        }
        return false;
    }
}
