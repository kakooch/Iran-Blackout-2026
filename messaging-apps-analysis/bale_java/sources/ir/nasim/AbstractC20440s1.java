package ir.nasim;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.s1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC20440s1 extends AbstractMap implements Map, InterfaceC20297rm3 {
    protected AbstractC20440s1() {
    }

    public abstract Set b();

    public abstract /* bridge */ Set c();

    public abstract /* bridge */ int d();

    public abstract /* bridge */ Collection e();

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set entrySet() {
        return b();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set keySet() {
        return c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return d();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection values() {
        return e();
    }
}
