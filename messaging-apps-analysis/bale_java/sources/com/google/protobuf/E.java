package com.google.protobuf;

import ir.nasim.FB7;
import ir.nasim.InterfaceC3919Cx3;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class E extends AbstractC2379c implements InterfaceC3919Cx3, RandomAccess {
    private static final E c;
    public static final InterfaceC3919Cx3 d;
    private final List b;

    static {
        E e = new E();
        c = e;
        e.s();
        d = e;
    }

    public E() {
        this(10);
    }

    private static String i(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof AbstractC2383g ? ((AbstractC2383g) obj).f0() : B.j((byte[]) obj);
    }

    @Override // ir.nasim.InterfaceC3919Cx3
    public void X(AbstractC2383g abstractC2383g) {
        f();
        this.b.add(abstractC2383g);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        f();
        this.b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void add(int i, String str) {
        f();
        this.b.add(i, str);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public String get(int i) {
        Object obj = this.b.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof AbstractC2383g) {
            AbstractC2383g abstractC2383g = (AbstractC2383g) obj;
            String strF0 = abstractC2383g.f0();
            if (abstractC2383g.Q()) {
                this.b.set(i, strF0);
            }
            return strF0;
        }
        byte[] bArr = (byte[]) obj;
        String strJ = B.j(bArr);
        if (B.g(bArr)) {
            this.b.set(i, strJ);
        }
        return strJ;
    }

    @Override // ir.nasim.InterfaceC3919Cx3
    public List n() {
        return Collections.unmodifiableList(this.b);
    }

    @Override // com.google.protobuf.B.j, com.google.protobuf.B.g
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public E b(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.b);
        return new E(arrayList);
    }

    @Override // ir.nasim.InterfaceC3919Cx3
    public InterfaceC3919Cx3 p() {
        return u() ? new FB7(this) : this;
    }

    @Override // ir.nasim.InterfaceC3919Cx3
    public Object q(int i) {
        return this.b.get(i);
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractList, java.util.List
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public String remove(int i) {
        f();
        Object objRemove = this.b.remove(i);
        ((AbstractList) this).modCount++;
        return i(objRemove);
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.b.size();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public String set(int i, String str) {
        f();
        return i(this.b.set(i, str));
    }

    @Override // com.google.protobuf.AbstractC2379c, com.google.protobuf.B.j
    public /* bridge */ /* synthetic */ boolean u() {
        return super.u();
    }

    public E(int i) {
        this(new ArrayList(i));
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection collection) {
        f();
        if (collection instanceof InterfaceC3919Cx3) {
            collection = ((InterfaceC3919Cx3) collection).n();
        }
        boolean zAddAll = this.b.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.protobuf.AbstractC2379c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    private E(ArrayList arrayList) {
        this.b = arrayList;
    }
}
