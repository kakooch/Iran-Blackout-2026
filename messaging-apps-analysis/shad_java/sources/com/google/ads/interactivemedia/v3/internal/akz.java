package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class akz<T> {
    final Class<? super T> a;
    final Type b;
    final int c;

    protected akz() {
        Type genericSuperclass = akz.class.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        this.b = aha.b(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        throw null;
    }

    public static akz<?> c(Type type) {
        return new akz<>(type);
    }

    public static <T> akz<T> d(Class<T> cls) {
        return new akz<>(cls);
    }

    public final Class<? super T> a() {
        return this.a;
    }

    public final Type b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof akz) && aha.d(this.b, ((akz) obj).b);
    }

    public final int hashCode() {
        return this.c;
    }

    public final String toString() {
        return aha.e(this.b);
    }

    akz(Type type) {
        com.google.ads.interactivemedia.v3.impl.data.ax.f(type);
        Type typeB = aha.b(type);
        this.b = typeB;
        this.a = (Class<? super T>) aha.c(typeB);
        this.c = typeB.hashCode();
    }
}
