package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class agx implements GenericArrayType, Serializable {
    private static final long serialVersionUID = 0;
    private final Type a;

    public agx(Type type) {
        this.a = aha.b(type);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && aha.d(this, (GenericArrayType) obj);
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.a;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return aha.e(this.a) + "[]";
    }
}
