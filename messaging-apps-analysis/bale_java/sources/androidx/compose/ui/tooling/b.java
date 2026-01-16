package androidx.compose.ui.tooling;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
final class b implements a {
    private final Set b = Collections.newSetFromMap(new WeakHashMap());

    @Override // androidx.compose.ui.tooling.a
    public Set a() {
        return this.b;
    }
}
