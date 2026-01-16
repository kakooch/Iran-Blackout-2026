package com.google.android.gms.internal.measurement;

import ir.nasim.C20953ss8;
import ir.nasim.InterfaceC20943sr8;
import ir.nasim.InterfaceC23996xr8;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public final class S0 extends AbstractC2139p0 implements RandomAccess, InterfaceC23996xr8 {
    private static final S0 c;
    public static final InterfaceC23996xr8 d;
    private final List b;

    static {
        S0 s0 = new S0(10);
        c = s0;
        s0.c();
        d = s0;
    }

    public S0(int i) {
        this.b = new ArrayList(i);
    }

    private static String i(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof A0 ? ((A0) obj).Q(R0.b) : R0.g((byte[]) obj);
    }

    @Override // ir.nasim.InterfaceC20943sr8
    public final /* bridge */ /* synthetic */ InterfaceC20943sr8 K(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.b);
        return new S0(arrayList);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        f();
        this.b.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC2139p0, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        f();
        if (collection instanceof InterfaceC23996xr8) {
            collection = ((InterfaceC23996xr8) collection).k();
        }
        boolean zAddAll = this.b.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC2139p0, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        f();
        this.b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // ir.nasim.InterfaceC23996xr8
    public final InterfaceC23996xr8 g() {
        return e() ? new C20953ss8(this) : this;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final String get(int i) {
        Object obj = this.b.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof A0) {
            A0 a0 = (A0) obj;
            String strQ = a0.Q(R0.b);
            if (a0.F()) {
                this.b.set(i, strQ);
            }
            return strQ;
        }
        byte[] bArr = (byte[]) obj;
        String strG = R0.g(bArr);
        if (R0.h(bArr)) {
            this.b.set(i, strG);
        }
        return strG;
    }

    @Override // ir.nasim.InterfaceC23996xr8
    public final List k() {
        return Collections.unmodifiableList(this.b);
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC2139p0, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        f();
        Object objRemove = this.b.remove(i);
        ((AbstractList) this).modCount++;
        return i(objRemove);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        f();
        return i(this.b.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b.size();
    }

    @Override // ir.nasim.InterfaceC23996xr8
    public final void w1(A0 a0) {
        f();
        this.b.add(a0);
        ((AbstractList) this).modCount++;
    }

    @Override // ir.nasim.InterfaceC23996xr8
    public final Object y(int i) {
        return this.b.get(i);
    }

    private S0(ArrayList arrayList) {
        this.b = arrayList;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC2139p0, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
