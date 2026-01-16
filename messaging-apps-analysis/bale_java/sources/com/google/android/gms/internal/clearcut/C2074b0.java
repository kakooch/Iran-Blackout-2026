package com.google.android.gms.internal.clearcut;

import ir.nasim.InterfaceC25120zl8;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.clearcut.b0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2074b0 extends AbstractC2073b {
    private static final C2074b0 c;
    private final List b;

    static {
        C2074b0 c2074b0 = new C2074b0();
        c = c2074b0;
        c2074b0.H();
    }

    C2074b0() {
        this(new ArrayList(10));
    }

    public static C2074b0 h() {
        return c;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        f();
        this.b.add(i, obj);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.b.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        f();
        Object objRemove = this.b.remove(i);
        ((AbstractList) this).modCount++;
        return objRemove;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        f();
        Object obj2 = this.b.set(i, obj);
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b.size();
    }

    @Override // ir.nasim.InterfaceC25120zl8
    public final /* synthetic */ InterfaceC25120zl8 z0(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.b);
        return new C2074b0(arrayList);
    }

    private C2074b0(List list) {
        this.b = list;
    }
}
