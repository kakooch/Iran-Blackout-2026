package ir.nasim;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.eO3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C12305eO3 implements InterfaceC11662dO3 {
    private final Map a;
    private final UA2 b;

    public C12305eO3(Map map, UA2 ua2) {
        AbstractC13042fc3.i(map, "map");
        AbstractC13042fc3.i(ua2, "default");
        this.a = map;
        this.b = ua2;
    }

    @Override // ir.nasim.InterfaceC11662dO3
    public Object D(Object obj) {
        Map map = getMap();
        Object obj2 = map.get(obj);
        return (obj2 != null || map.containsKey(obj)) ? obj2 : this.b.invoke(obj);
    }

    public Set b() {
        return getMap().entrySet();
    }

    public Set c() {
        return getMap().keySet();
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return getMap().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return getMap().containsValue(obj);
    }

    public int d() {
        return getMap().size();
    }

    public Collection e() {
        return getMap().values();
    }

    @Override // java.util.Map
    public final /* bridge */ Set entrySet() {
        return b();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return getMap().equals(obj);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return getMap().get(obj);
    }

    @Override // ir.nasim.InterfaceC11662dO3
    public Map getMap() {
        return this.a;
    }

    @Override // java.util.Map
    public int hashCode() {
        return getMap().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return getMap().isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set keySet() {
        return c();
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
    public Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return d();
    }

    public String toString() {
        return getMap().toString();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return e();
    }
}
