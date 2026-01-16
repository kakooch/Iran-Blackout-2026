package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class apt implements agu {
    @Override // com.google.ads.interactivemedia.v3.internal.agu
    public final <T> agt<T> a(age ageVar, akz<T> akzVar) {
        Class clsA = akzVar.a();
        aps apsVar = (aps) clsA.getAnnotation(aps.class);
        if (apsVar == null || clsA == apsVar.a()) {
            return null;
        }
        return ageVar.d(apsVar.a());
    }
}
