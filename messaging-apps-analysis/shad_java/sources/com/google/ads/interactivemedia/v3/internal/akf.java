package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class akf implements agu {
    akf() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agu
    public final <T> agt<T> a(age ageVar, akz<T> akzVar) {
        Class<? super T> clsA = akzVar.a();
        if (!Enum.class.isAssignableFrom(clsA) || clsA == Enum.class) {
            return null;
        }
        if (!clsA.isEnum()) {
            clsA = clsA.getSuperclass();
        }
        return new akt(clsA);
    }
}
