package ir.nasim;

import java.util.LinkedHashMap;
import java.util.Set;

/* renamed from: ir.nasim.oL3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C18251oL3 {
    private final LinkedHashMap a;

    public C18251oL3(int i, float f) {
        this.a = new LinkedHashMap(i, f, true);
    }

    public final Object a(Object obj) {
        AbstractC13042fc3.i(obj, "key");
        return this.a.get(obj);
    }

    public final Set b() {
        Set setEntrySet = this.a.entrySet();
        AbstractC13042fc3.h(setEntrySet, "<get-entries>(...)");
        return setEntrySet;
    }

    public final boolean c() {
        return this.a.isEmpty();
    }

    public final Object d(Object obj, Object obj2) {
        AbstractC13042fc3.i(obj, "key");
        AbstractC13042fc3.i(obj2, "value");
        return this.a.put(obj, obj2);
    }

    public final Object e(Object obj) {
        AbstractC13042fc3.i(obj, "key");
        return this.a.remove(obj);
    }
}
