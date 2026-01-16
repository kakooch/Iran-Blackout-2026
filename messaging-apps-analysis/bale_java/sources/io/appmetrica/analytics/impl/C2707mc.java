package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.Map;

/* renamed from: io.appmetrica.analytics.impl.mc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2707mc {
    public final Map a;
    public final Object b;

    public C2707mc(Object obj) {
        this(new HashMap(), obj);
    }

    public final void a(Object obj, Object obj2) {
        this.a.put(obj, obj2);
    }

    public C2707mc(HashMap map, Object obj) {
        this.a = map;
        this.b = obj;
    }

    public final Object a(Object obj) {
        Object obj2 = this.a.get(obj);
        return obj2 == null ? this.b : obj2;
    }
}
