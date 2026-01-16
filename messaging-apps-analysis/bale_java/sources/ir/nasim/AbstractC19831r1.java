package ir.nasim;

import java.util.AbstractList;
import java.util.List;

/* renamed from: ir.nasim.r1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC19831r1 extends AbstractList implements List, InterfaceC19688qm3 {
    protected AbstractC19831r1() {
    }

    public abstract int f();

    public abstract Object j(int i);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i) {
        return j(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return f();
    }
}
