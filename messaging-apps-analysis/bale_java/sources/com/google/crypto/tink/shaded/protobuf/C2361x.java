package com.google.crypto.tink.shaded.protobuf;

import ir.nasim.EB7;
import ir.nasim.InterfaceC3685Bx3;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.crypto.tink.shaded.protobuf.x, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2361x extends AbstractC2341c implements InterfaceC3685Bx3, RandomAccess {
    private static final C2361x c;
    public static final InterfaceC3685Bx3 d;
    private final List b;

    static {
        C2361x c2361x = new C2361x();
        c = c2361x;
        c2361x.s();
        d = c2361x;
    }

    public C2361x() {
        this(10);
    }

    private static String i(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof AbstractC2345g ? ((AbstractC2345g) obj).b0() : AbstractC2360w.i((byte[]) obj);
    }

    @Override // ir.nasim.InterfaceC3685Bx3
    public void E1(AbstractC2345g abstractC2345g) {
        f();
        this.b.add(abstractC2345g);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2341c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2341c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        f();
        this.b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2341c, java.util.AbstractList, java.util.Collection, java.util.List
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

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2341c, java.util.AbstractList, java.util.Collection, java.util.List
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
        if (obj instanceof AbstractC2345g) {
            AbstractC2345g abstractC2345g = (AbstractC2345g) obj;
            String strB0 = abstractC2345g.b0();
            if (abstractC2345g.N()) {
                this.b.set(i, strB0);
            }
            return strB0;
        }
        byte[] bArr = (byte[]) obj;
        String strI = AbstractC2360w.i(bArr);
        if (AbstractC2360w.g(bArr)) {
            this.b.set(i, strI);
        }
        return strI;
    }

    @Override // ir.nasim.InterfaceC3685Bx3
    public List n() {
        return Collections.unmodifiableList(this.b);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2360w.d
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public C2361x b(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.b);
        return new C2361x(arrayList);
    }

    @Override // ir.nasim.InterfaceC3685Bx3
    public InterfaceC3685Bx3 p() {
        return u() ? new EB7(this) : this;
    }

    @Override // ir.nasim.InterfaceC3685Bx3
    public Object q(int i) {
        return this.b.get(i);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2341c, java.util.AbstractList, java.util.List
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public String remove(int i) {
        f();
        Object objRemove = this.b.remove(i);
        ((AbstractList) this).modCount++;
        return i(objRemove);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2341c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2341c, java.util.AbstractCollection, java.util.Collection, java.util.List
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

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2341c, com.google.crypto.tink.shaded.protobuf.AbstractC2360w.d
    public /* bridge */ /* synthetic */ boolean u() {
        return super.u();
    }

    public C2361x(int i) {
        this(new ArrayList(i));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2341c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2341c, java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection collection) {
        f();
        if (collection instanceof InterfaceC3685Bx3) {
            collection = ((InterfaceC3685Bx3) collection).n();
        }
        boolean zAddAll = this.b.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2341c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    private C2361x(ArrayList arrayList) {
        this.b = arrayList;
    }
}
