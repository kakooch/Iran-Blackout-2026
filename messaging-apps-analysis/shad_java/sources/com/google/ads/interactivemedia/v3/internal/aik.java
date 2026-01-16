package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aik implements agu {
    aik() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agu
    public final <T> agt<T> a(age ageVar, akz<T> akzVar) {
        Type typeB = akzVar.b();
        boolean z = typeB instanceof GenericArrayType;
        if (!z && (!(typeB instanceof Class) || !((Class) typeB).isArray())) {
            return null;
        }
        Type genericComponentType = z ? ((GenericArrayType) typeB).getGenericComponentType() : ((Class) typeB).getComponentType();
        return new ail(ageVar, ageVar.b(akz.c(genericComponentType)), aha.c(genericComponentType));
    }
}
