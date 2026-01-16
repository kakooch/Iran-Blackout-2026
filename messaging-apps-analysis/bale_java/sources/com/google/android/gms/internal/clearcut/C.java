package com.google.android.gms.internal.clearcut;

import ir.nasim.Gn8;
import ir.nasim.Hl8;
import ir.nasim.InterfaceC25120zl8;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public final class C extends AbstractC2073b implements Hl8, RandomAccess {
    private static final C c;
    private static final Hl8 d;
    private final List b;

    static {
        C c2 = new C();
        c = c2;
        c2.H();
        d = c2;
    }

    public C() {
        this(10);
    }

    private static String h(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof AbstractC2081f ? ((AbstractC2081f) obj).P() : B.h((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2073b, ir.nasim.InterfaceC25120zl8
    public final /* bridge */ /* synthetic */ boolean G() {
        return super.G();
    }

    @Override // ir.nasim.Hl8
    public final Hl8 O1() {
        return G() ? new Gn8(this) : this;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        f();
        this.b.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2073b, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        f();
        if (collection instanceof Hl8) {
            collection = ((Hl8) collection).d1();
        }
        boolean zAddAll = this.b.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2073b, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        f();
        this.b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // ir.nasim.Hl8
    public final List d1() {
        return Collections.unmodifiableList(this.b);
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2073b, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.b.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof AbstractC2081f) {
            AbstractC2081f abstractC2081f = (AbstractC2081f) obj;
            String strP = abstractC2081f.P();
            if (abstractC2081f.C()) {
                this.b.set(i, strP);
            }
            return strP;
        }
        byte[] bArr = (byte[]) obj;
        String strH = B.h(bArr);
        if (B.g(bArr)) {
            this.b.set(i, strH);
        }
        return strH;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2073b, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // ir.nasim.Hl8
    public final Object q(int i) {
        return this.b.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        f();
        Object objRemove = this.b.remove(i);
        ((AbstractList) this).modCount++;
        return h(objRemove);
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2073b, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2073b, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        f();
        return h(this.b.set(i, (String) obj));
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
        return new C(arrayList);
    }

    public C(int i) {
        this(new ArrayList(i));
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2073b, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2073b, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    private C(ArrayList arrayList) {
        this.b = arrayList;
    }
}
