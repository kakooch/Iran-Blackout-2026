package ir.nasim;

import java.util.Comparator;
import java.util.TreeSet;

/* renamed from: ir.nasim.aw7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C10023aw7 extends TreeSet {
    public C10023aw7(Comparator comparator) {
        super(comparator);
    }

    public /* bridge */ int f() {
        return super.size();
    }

    @Override // java.util.TreeSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return f();
    }
}
