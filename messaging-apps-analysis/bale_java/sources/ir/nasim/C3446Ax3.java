package ir.nasim;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: ir.nasim.Ax3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C3446Ax3 extends AbstractList implements RandomAccess, InterfaceC4153Dx3 {
    public static final InterfaceC4153Dx3 b = new C3446Ax3().p();
    private final List a;

    public C3446Ax3() {
        this.a = new ArrayList();
    }

    private static kotlin.reflect.jvm.internal.impl.protobuf.d h(Object obj) {
        return obj instanceof kotlin.reflect.jvm.internal.impl.protobuf.d ? (kotlin.reflect.jvm.internal.impl.protobuf.d) obj : obj instanceof String ? kotlin.reflect.jvm.internal.impl.protobuf.d.r((String) obj) : kotlin.reflect.jvm.internal.impl.protobuf.d.j((byte[]) obj);
    }

    private static String i(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof kotlin.reflect.jvm.internal.impl.protobuf.d ? ((kotlin.reflect.jvm.internal.impl.protobuf.d) obj).L() : kotlin.reflect.jvm.internal.impl.protobuf.i.b((byte[]) obj);
    }

    @Override // ir.nasim.InterfaceC4153Dx3
    public kotlin.reflect.jvm.internal.impl.protobuf.d F0(int i) {
        Object obj = this.a.get(i);
        kotlin.reflect.jvm.internal.impl.protobuf.d dVarH = h(obj);
        if (dVarH != obj) {
            this.a.set(i, dVarH);
        }
        return dVarH;
    }

    @Override // ir.nasim.InterfaceC4153Dx3
    public void L0(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
        this.a.add(dVar);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.a.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void add(int i, String str) {
        this.a.add(i, str);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public String get(int i) {
        Object obj = this.a.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof kotlin.reflect.jvm.internal.impl.protobuf.d) {
            kotlin.reflect.jvm.internal.impl.protobuf.d dVar = (kotlin.reflect.jvm.internal.impl.protobuf.d) obj;
            String strL = dVar.L();
            if (dVar.A()) {
                this.a.set(i, strL);
            }
            return strL;
        }
        byte[] bArr = (byte[]) obj;
        String strB = kotlin.reflect.jvm.internal.impl.protobuf.i.b(bArr);
        if (kotlin.reflect.jvm.internal.impl.protobuf.i.a(bArr)) {
            this.a.set(i, strB);
        }
        return strB;
    }

    @Override // ir.nasim.InterfaceC4153Dx3
    public List n() {
        return Collections.unmodifiableList(this.a);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public String remove(int i) {
        Object objRemove = this.a.remove(i);
        ((AbstractList) this).modCount++;
        return i(objRemove);
    }

    @Override // ir.nasim.InterfaceC4153Dx3
    public InterfaceC4153Dx3 p() {
        return new GB7(this);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public String set(int i, String str) {
        return i(this.a.set(i, str));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.a.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection collection) {
        if (collection instanceof InterfaceC4153Dx3) {
            collection = ((InterfaceC4153Dx3) collection).n();
        }
        boolean zAddAll = this.a.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    public C3446Ax3(InterfaceC4153Dx3 interfaceC4153Dx3) {
        this.a = new ArrayList(interfaceC4153Dx3.size());
        addAll(interfaceC4153Dx3);
    }
}
