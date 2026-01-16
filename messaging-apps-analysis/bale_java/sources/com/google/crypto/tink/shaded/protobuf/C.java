package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.AbstractC2360w;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public final class C extends LinkedHashMap {
    private static final C b;
    private boolean a;

    static {
        C c = new C();
        b = c;
        c.p();
    }

    private C() {
        this.a = true;
    }

    static int b(Map map) {
        int iC = 0;
        for (Map.Entry entry : map.entrySet()) {
            iC += c(entry.getValue()) ^ c(entry.getKey());
        }
        return iC;
    }

    private static int c(Object obj) {
        if (obj instanceof byte[]) {
            return AbstractC2360w.d((byte[]) obj);
        }
        if (obj instanceof AbstractC2360w.a) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    private static void d(Map map) {
        for (Object obj : map.keySet()) {
            AbstractC2360w.a(obj);
            AbstractC2360w.a(map.get(obj));
        }
    }

    public static C e() {
        return b;
    }

    private void f() {
        if (!n()) {
            throw new UnsupportedOperationException();
        }
    }

    private static boolean k(Object obj, Object obj2) {
        return ((obj instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) obj, (byte[]) obj2) : obj.equals(obj2);
    }

    static boolean l(Map map, Map map2) {
        if (map == map2) {
            return true;
        }
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey()) || !k(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        f();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        return (obj instanceof Map) && l(this, (Map) obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return b(this);
    }

    public boolean n() {
        return this.a;
    }

    public void p() {
        this.a = false;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        f();
        AbstractC2360w.a(obj);
        AbstractC2360w.a(obj2);
        return super.put(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map map) {
        f();
        d(map);
        super.putAll(map);
    }

    public void q(C c) {
        f();
        if (c.isEmpty()) {
            return;
        }
        putAll(c);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        f();
        return super.remove(obj);
    }

    public C s() {
        return isEmpty() ? new C() : new C(this);
    }

    private C(Map map) {
        super(map);
        this.a = true;
    }
}
