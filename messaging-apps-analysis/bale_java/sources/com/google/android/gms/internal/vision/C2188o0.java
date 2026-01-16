package com.google.android.gms.internal.vision;

import ir.nasim.Tq8;
import ir.nasim.Tr8;
import ir.nasim.Yq8;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.vision.o0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2188o0 extends F implements Yq8, RandomAccess {
    private static final C2188o0 c;
    private static final Yq8 d;
    private final List b;

    static {
        C2188o0 c2188o0 = new C2188o0();
        c = c2188o0;
        c2188o0.c();
        d = c2188o0;
    }

    public C2188o0() {
        this(10);
    }

    private static String h(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof K ? ((K) obj).Q() : AbstractC2184m0.i((byte[]) obj);
    }

    @Override // ir.nasim.Yq8
    public final void A1(K k) {
        f();
        this.b.add(k);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        f();
        this.b.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.vision.F, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.vision.F, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        f();
        this.b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // ir.nasim.Yq8
    public final List d() {
        return Collections.unmodifiableList(this.b);
    }

    @Override // com.google.android.gms.internal.vision.F, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // ir.nasim.Yq8
    public final Yq8 g() {
        return zza() ? new Tr8(this) : this;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.b.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof K) {
            K k = (K) obj;
            String strQ = k.Q();
            if (k.e()) {
                this.b.set(i, strQ);
            }
            return strQ;
        }
        byte[] bArr = (byte[]) obj;
        String strI = AbstractC2184m0.i(bArr);
        if (AbstractC2184m0.h(bArr)) {
            this.b.set(i, strI);
        }
        return strI;
    }

    @Override // com.google.android.gms.internal.vision.F, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // ir.nasim.Yq8
    public final Object l(int i) {
        return this.b.get(i);
    }

    @Override // com.google.android.gms.internal.vision.F, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.vision.F, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.vision.F, java.util.AbstractCollection, java.util.Collection, java.util.List
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

    @Override // com.google.android.gms.internal.vision.F, ir.nasim.Tq8
    public final /* bridge */ /* synthetic */ boolean zza() {
        return super.zza();
    }

    public C2188o0(int i) {
        this(new ArrayList(i));
    }

    @Override // com.google.android.gms.internal.vision.F, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        f();
        if (collection instanceof Yq8) {
            collection = ((Yq8) collection).d();
        }
        boolean zAddAll = this.b.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.vision.F, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        f();
        Object objRemove = this.b.remove(i);
        ((AbstractList) this).modCount++;
        return h(objRemove);
    }

    @Override // ir.nasim.Tq8
    public final /* synthetic */ Tq8 zza(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.b);
        return new C2188o0(arrayList);
    }

    private C2188o0(ArrayList arrayList) {
        this.b = arrayList;
    }

    @Override // com.google.android.gms.internal.vision.F, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }
}
