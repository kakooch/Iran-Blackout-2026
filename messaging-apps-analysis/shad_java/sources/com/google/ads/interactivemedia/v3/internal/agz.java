package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class agz implements WildcardType, Serializable {
    private static final long serialVersionUID = 0;
    private final Type a;
    private final Type b;

    public agz(Type[] typeArr, Type[] typeArr2) {
        int length = typeArr2.length;
        com.google.ads.interactivemedia.v3.impl.data.ax.e(length <= 1);
        com.google.ads.interactivemedia.v3.impl.data.ax.e(typeArr.length == 1);
        if (length != 1) {
            com.google.ads.interactivemedia.v3.impl.data.ax.f(typeArr[0]);
            aha.k(typeArr[0]);
            this.b = null;
            this.a = aha.b(typeArr[0]);
            return;
        }
        com.google.ads.interactivemedia.v3.impl.data.ax.f(typeArr2[0]);
        aha.k(typeArr2[0]);
        com.google.ads.interactivemedia.v3.impl.data.ax.e(typeArr[0] == Object.class);
        this.b = aha.b(typeArr2[0]);
        this.a = Object.class;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && aha.d(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.b;
        return type != null ? new Type[]{type} : aha.a;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.a};
    }

    public final int hashCode() {
        Type type = this.b;
        return (type != null ? type.hashCode() + 31 : 1) ^ (this.a.hashCode() + 31);
    }

    public final String toString() {
        if (this.b != null) {
            return "? super " + aha.e(this.b);
        }
        if (this.a == Object.class) {
            return "?";
        }
        return "? extends " + aha.e(this.a);
    }
}
