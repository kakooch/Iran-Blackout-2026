package ir.nasim;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* renamed from: ir.nasim.bd3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C10446bd3 {
    private final D26 a;
    private final Set b;

    public C10446bd3(D26 d26) {
        AbstractC13042fc3.i(d26, "database");
        this.a = d26;
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        AbstractC13042fc3.h(setNewSetFromMap, "newSetFromMap(IdentityHashMap())");
        this.b = setNewSetFromMap;
    }
}
