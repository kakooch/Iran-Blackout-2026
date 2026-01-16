package ir.nasim;

import java.util.AbstractSet;
import java.util.Set;

/* renamed from: ir.nasim.t1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC21043t1 extends AbstractSet implements Set, InterfaceC24531ym3 {
    protected AbstractC21043t1() {
    }

    public abstract int f();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return f();
    }
}
