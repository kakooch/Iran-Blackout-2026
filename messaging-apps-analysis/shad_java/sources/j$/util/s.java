package j$.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;

/* loaded from: classes2.dex */
class s extends H {
    final /* synthetic */ SortedSet f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    s(SortedSet sortedSet, Collection collection, int i) {
        super(collection, i);
        this.f = sortedSet;
    }

    @Override // j$.util.H, j$.util.t
    public Comparator getComparator() {
        return this.f.comparator();
    }
}
