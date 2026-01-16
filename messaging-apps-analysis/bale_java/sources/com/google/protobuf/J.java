package com.google.protobuf;

import com.google.protobuf.B;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public final class J extends LinkedHashMap {
    private static final J b;
    private boolean a;

    static {
        J j = new J();
        b = j;
        j.p();
    }

    private J() {
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
            return B.d((byte[]) obj);
        }
        if (obj instanceof B.c) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    private static void d(Map map) {
        for (Object obj : map.keySet()) {
            B.a(obj);
            B.a(map.get(obj));
        }
    }

    public static J e() {
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
        B.a(obj);
        B.a(obj2);
        return super.put(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map map) {
        f();
        d(map);
        super.putAll(map);
    }

    public void q(J j) {
        f();
        if (j.isEmpty()) {
            return;
        }
        putAll(j);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        f();
        return super.remove(obj);
    }

    public J s() {
        return isEmpty() ? new J() : new J(this);
    }

    private J(Map map) {
        super(map);
        this.a = true;
    }
}
