package ir.nasim;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

/* renamed from: ir.nasim.fO3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C12914fO3 implements Map, InterfaceC17915nm3 {
    private final AbstractC21411tc6 a;
    private B92 b;
    private C4798Gp3 c;
    private EQ7 d;

    public C12914fO3(AbstractC21411tc6 abstractC21411tc6) {
        AbstractC13042fc3.i(abstractC21411tc6, "parent");
        this.a = abstractC21411tc6;
    }

    public Set b() {
        B92 b92 = this.b;
        if (b92 != null) {
            return b92;
        }
        B92 b922 = new B92(this.a);
        this.b = b922;
        return b922;
    }

    public Set c() {
        C4798Gp3 c4798Gp3 = this.c;
        if (c4798Gp3 != null) {
            return c4798Gp3;
        }
        C4798Gp3 c4798Gp32 = new C4798Gp3(this.a);
        this.c = c4798Gp32;
        return c4798Gp32;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public Object compute(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public Object computeIfAbsent(Object obj, Function function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public Object computeIfPresent(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.a.c(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.a.d(obj);
    }

    public int d() {
        return this.a.e;
    }

    public Collection e() {
        EQ7 eq7 = this.d;
        if (eq7 != null) {
            return eq7;
        }
        EQ7 eq72 = new EQ7(this.a);
        this.d = eq72;
        return eq72;
    }

    @Override // java.util.Map
    public final /* bridge */ Set entrySet() {
        return b();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return AbstractC13042fc3.d(this.a, ((C12914fO3) obj).a);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.a.e(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.a.h();
    }

    @Override // java.util.Map
    public final /* bridge */ Set keySet() {
        return c();
    }

    @Override // java.util.Map
    public Object merge(Object obj, Object obj2, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public Object putIfAbsent(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public Object replace(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return d();
    }

    public String toString() {
        return this.a.toString();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return e();
    }

    @Override // java.util.Map
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean replace(Object obj, Object obj2, Object obj3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
