package j$.util;

import j$.util.u;
import java.util.SortedSet;

/* JADX INFO: Add missing generic type declarations: [E] */
/* loaded from: classes2.dex */
class t<E> extends u.i<E> {
    final /* synthetic */ SortedSet f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    t(SortedSet sortedSet, java.util.Collection collection, int i) {
        super(collection, i);
        this.f = sortedSet;
    }

    @Override // j$.util.u.i, j$.util.Spliterator
    public java.util.Comparator getComparator() {
        return this.f.comparator();
    }
}
