package com.google.android.gms.internal.vision;

import ir.nasim.Mq8;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.vision.y0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2207y0 extends LinkedHashMap {
    private static final C2207y0 b;
    private boolean a;

    static {
        C2207y0 c2207y0 = new C2207y0();
        b = c2207y0;
        c2207y0.a = false;
    }

    private C2207y0() {
        this.a = true;
    }

    private static int b(Object obj) {
        if (obj instanceof byte[]) {
            return AbstractC2184m0.j((byte[]) obj);
        }
        if (obj instanceof Mq8) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    public static C2207y0 c() {
        return b;
    }

    private final void l() {
        if (!this.a) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        l();
        super.clear();
    }

    public final void d(C2207y0 c2207y0) {
        l();
        if (c2207y0.isEmpty()) {
            return;
        }
        putAll(c2207y0);
    }

    public final C2207y0 e() {
        return isEmpty() ? new C2207y0() : new C2207y0(this);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005c A[RETURN] */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof java.util.Map
            r1 = 0
            if (r0 == 0) goto L5d
            java.util.Map r7 = (java.util.Map) r7
            r0 = 1
            if (r6 == r7) goto L59
            int r2 = r6.size()
            int r3 = r7.size()
            if (r2 == r3) goto L16
        L14:
            r7 = r1
            goto L5a
        L16:
            java.util.Set r2 = r6.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L1e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L59
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            boolean r4 = r7.containsKey(r4)
            if (r4 != 0) goto L35
            goto L14
        L35:
            java.lang.Object r4 = r3.getValue()
            java.lang.Object r3 = r3.getKey()
            java.lang.Object r3 = r7.get(r3)
            boolean r5 = r4 instanceof byte[]
            if (r5 == 0) goto L52
            boolean r5 = r3 instanceof byte[]
            if (r5 == 0) goto L52
            byte[] r4 = (byte[]) r4
            byte[] r3 = (byte[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            goto L56
        L52:
            boolean r3 = r4.equals(r3)
        L56:
            if (r3 != 0) goto L1e
            goto L14
        L59:
            r7 = r0
        L5a:
            if (r7 == 0) goto L5d
            return r0
        L5d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.C2207y0.equals(java.lang.Object):boolean");
    }

    public final void f() {
        this.a = false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        Iterator it = entrySet().iterator();
        int iB = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            iB += b(entry.getValue()) ^ b(entry.getKey());
        }
        return iB;
    }

    public final boolean k() {
        return this.a;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        l();
        AbstractC2184m0.d(obj);
        AbstractC2184m0.d(obj2);
        return super.put(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        l();
        for (Object obj : map.keySet()) {
            AbstractC2184m0.d(obj);
            AbstractC2184m0.d(map.get(obj));
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        l();
        return super.remove(obj);
    }

    private C2207y0(Map map) {
        super(map);
        this.a = true;
    }
}
