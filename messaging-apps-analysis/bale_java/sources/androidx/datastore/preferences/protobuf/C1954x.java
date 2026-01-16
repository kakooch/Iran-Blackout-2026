package androidx.datastore.preferences.protobuf;

import ir.nasim.HB7;
import ir.nasim.InterfaceC4387Ex3;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: androidx.datastore.preferences.protobuf.x, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1954x extends AbstractC1934c implements InterfaceC4387Ex3, RandomAccess {
    private static final C1954x c;
    public static final InterfaceC4387Ex3 d;
    private final List b;

    static {
        C1954x c1954x = new C1954x();
        c = c1954x;
        c1954x.s();
        d = c1954x;
    }

    public C1954x() {
        this(10);
    }

    private static String i(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof AbstractC1937f ? ((AbstractC1937f) obj).W() : AbstractC1952v.j((byte[]) obj);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1934c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1934c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        f();
        this.b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1934c, java.util.AbstractList, java.util.Collection, java.util.List
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

    @Override // ir.nasim.InterfaceC4387Ex3
    public void h1(AbstractC1937f abstractC1937f) {
        f();
        this.b.add(abstractC1937f);
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1934c, java.util.AbstractList, java.util.Collection, java.util.List
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
        if (obj instanceof AbstractC1937f) {
            AbstractC1937f abstractC1937f = (AbstractC1937f) obj;
            String strW = abstractC1937f.W();
            if (abstractC1937f.L()) {
                this.b.set(i, strW);
            }
            return strW;
        }
        byte[] bArr = (byte[]) obj;
        String strJ = AbstractC1952v.j(bArr);
        if (AbstractC1952v.g(bArr)) {
            this.b.set(i, strJ);
        }
        return strJ;
    }

    @Override // ir.nasim.InterfaceC4387Ex3
    public List n() {
        return Collections.unmodifiableList(this.b);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1952v.b
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public C1954x b(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.b);
        return new C1954x(arrayList);
    }

    @Override // ir.nasim.InterfaceC4387Ex3
    public InterfaceC4387Ex3 p() {
        return u() ? new HB7(this) : this;
    }

    @Override // ir.nasim.InterfaceC4387Ex3
    public Object q(int i) {
        return this.b.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public String remove(int i) {
        f();
        Object objRemove = this.b.remove(i);
        ((AbstractList) this).modCount++;
        return i(objRemove);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1934c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1934c, java.util.AbstractCollection, java.util.Collection, java.util.List
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

    @Override // androidx.datastore.preferences.protobuf.AbstractC1934c, androidx.datastore.preferences.protobuf.AbstractC1952v.b
    public /* bridge */ /* synthetic */ boolean u() {
        return super.u();
    }

    public C1954x(int i) {
        this(new ArrayList(i));
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1934c, java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection collection) {
        f();
        if (collection instanceof InterfaceC4387Ex3) {
            collection = ((InterfaceC4387Ex3) collection).n();
        }
        boolean zAddAll = this.b.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1934c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    private C1954x(ArrayList arrayList) {
        this.b = arrayList;
    }
}
