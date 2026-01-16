package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.measurement.a1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2104a1 extends LinkedHashMap {
    private static final C2104a1 b;
    private boolean a;

    static {
        C2104a1 c2104a1 = new C2104a1();
        b = c2104a1;
        c2104a1.a = false;
    }

    private C2104a1() {
        this.a = true;
    }

    public static C2104a1 b() {
        return b;
    }

    private static int k(Object obj) {
        return obj instanceof byte[] ? R0.b((byte[]) obj) : obj.hashCode();
    }

    private final void l() {
        if (!this.a) {
            throw new UnsupportedOperationException();
        }
    }

    public final C2104a1 c() {
        return isEmpty() ? new C2104a1() : new C2104a1(this);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        l();
        super.clear();
    }

    public final void d() {
        this.a = false;
    }

    public final void e(C2104a1 c2104a1) {
        l();
        if (c2104a1.isEmpty()) {
            return;
        }
        putAll(c2104a1);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this == map) {
            return true;
        }
        if (size() != map.size()) {
            return false;
        }
        Iterator it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            Object value = entry.getValue();
            Object obj2 = map.get(entry.getKey());
            if (!(((value instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) value, (byte[]) obj2) : value.equals(obj2))) {
                return false;
            }
        }
        return true;
    }

    public final boolean f() {
        return this.a;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        Iterator it = entrySet().iterator();
        int iK = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            iK += k(entry.getValue()) ^ k(entry.getKey());
        }
        return iK;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        l();
        R0.e(obj);
        R0.e(obj2);
        return super.put(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        l();
        for (Object obj : map.keySet()) {
            R0.e(obj);
            R0.e(map.get(obj));
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        l();
        return super.remove(obj);
    }

    private C2104a1(Map map) {
        super(map);
        this.a = true;
    }
}
