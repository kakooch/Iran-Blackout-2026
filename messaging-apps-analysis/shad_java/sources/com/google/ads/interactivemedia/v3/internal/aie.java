package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aie {
    private static final Map<Class<?>, Class<?>> a;

    static {
        HashMap map = new HashMap(16);
        HashMap map2 = new HashMap(16);
        c(map, map2, Boolean.TYPE, Boolean.class);
        c(map, map2, Byte.TYPE, Byte.class);
        c(map, map2, Character.TYPE, Character.class);
        c(map, map2, Double.TYPE, Double.class);
        c(map, map2, Float.TYPE, Float.class);
        c(map, map2, Integer.TYPE, Integer.class);
        c(map, map2, Long.TYPE, Long.class);
        c(map, map2, Short.TYPE, Short.class);
        c(map, map2, Void.TYPE, Void.class);
        a = Collections.unmodifiableMap(map);
        Collections.unmodifiableMap(map2);
    }

    public static boolean a(Type type) {
        return a.containsKey(type);
    }

    public static <T> Class<T> b(Class<T> cls) {
        Class<T> cls2 = (Class) a.get(cls);
        return cls2 == null ? cls : cls2;
    }

    private static void c(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }
}
