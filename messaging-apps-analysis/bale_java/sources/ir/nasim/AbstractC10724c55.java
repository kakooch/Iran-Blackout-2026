package ir.nasim;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.c55, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC10724c55 extends AbstractC20440s1 implements Map, InterfaceC20297rm3 {
    private C9514a55 a;
    private C10537bm4 b = new C10537bm4();
    private C12637ew7 c;
    private Object d;
    private int e;
    private int f;

    public AbstractC10724c55(C9514a55 c9514a55) {
        this.a = c9514a55;
        this.c = this.a.o();
        this.f = this.a.size();
    }

    @Override // ir.nasim.AbstractC20440s1
    public Set b() {
        return new C12131e55(this);
    }

    @Override // ir.nasim.AbstractC20440s1
    public Set c() {
        return new C13358g55(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        C12637ew7 c12637ew7A = C12637ew7.e.a();
        AbstractC13042fc3.g(c12637ew7A, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        this.c = c12637ew7A;
        n(0);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.c.k(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    @Override // ir.nasim.AbstractC20440s1
    public int d() {
        return this.f;
    }

    @Override // ir.nasim.AbstractC20440s1
    public Collection e() {
        return new C14547i55(this);
    }

    public abstract C9514a55 f();

    public final int g() {
        return this.e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        return this.c.o(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    public final C12637ew7 h() {
        return this.c;
    }

    public final C10537bm4 i() {
        return this.b;
    }

    public final void j(int i) {
        this.e = i;
    }

    public final void k(Object obj) {
        this.d = obj;
    }

    protected final void l(C10537bm4 c10537bm4) {
        this.b = c10537bm4;
    }

    public void n(int i) {
        this.f = i;
        this.e++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        this.d = null;
        this.c = this.c.D(obj != null ? obj.hashCode() : 0, obj, obj2, 0, this);
        return this.d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map map) {
        C9514a55 c9514a55F = map instanceof C9514a55 ? (C9514a55) map : null;
        if (c9514a55F == null) {
            AbstractC10724c55 abstractC10724c55 = map instanceof AbstractC10724c55 ? (AbstractC10724c55) map : null;
            c9514a55F = abstractC10724c55 != null ? abstractC10724c55.f() : null;
        }
        if (c9514a55F == null) {
            super.putAll(map);
            return;
        }
        VH1 vh1 = new VH1(0, 1, null);
        int size = size();
        C12637ew7 c12637ew7 = this.c;
        C12637ew7 c12637ew7O = c9514a55F.o();
        AbstractC13042fc3.g(c12637ew7O, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        this.c = c12637ew7.E(c12637ew7O, 0, vh1, this);
        int size2 = (c9514a55F.size() + size) - vh1.a();
        if (size != size2) {
            n(size2);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        this.d = null;
        C12637ew7 c12637ew7G = this.c.G(obj != null ? obj.hashCode() : 0, obj, 0, this);
        if (c12637ew7G == null) {
            c12637ew7G = C12637ew7.e.a();
            AbstractC13042fc3.g(c12637ew7G, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        }
        this.c = c12637ew7G;
        return this.d;
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        int size = size();
        C12637ew7 c12637ew7H = this.c.H(obj != null ? obj.hashCode() : 0, obj, obj2, 0, this);
        if (c12637ew7H == null) {
            c12637ew7H = C12637ew7.e.a();
            AbstractC13042fc3.g(c12637ew7H, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        }
        this.c = c12637ew7H;
        return size != size();
    }
}
