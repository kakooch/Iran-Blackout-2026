package ir.nasim;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.Ww2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC8649Ww2 extends AbstractC8935Xw2 implements Map {
    protected AbstractC8649Ww2() {
    }

    protected abstract Map c();

    @Override // java.util.Map
    public void clear() {
        c().clear();
    }

    public boolean containsKey(Object obj) {
        return c().containsKey(obj);
    }

    protected boolean d(Object obj) {
        return AbstractC17096mO3.b(this, obj);
    }

    protected boolean e(Object obj) {
        return AbstractC17096mO3.c(this, obj);
    }

    public Set entrySet() {
        return c().entrySet();
    }

    protected int f() {
        return AbstractC3895Cu6.d(entrySet());
    }

    public Object get(Object obj) {
        return c().get(obj);
    }

    public boolean isEmpty() {
        return c().isEmpty();
    }

    public Set keySet() {
        return c().keySet();
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        return c().put(obj, obj2);
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        c().putAll(map);
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return c().remove(obj);
    }

    public int size() {
        return c().size();
    }

    @Override // java.util.Map
    public Collection values() {
        return c().values();
    }
}
