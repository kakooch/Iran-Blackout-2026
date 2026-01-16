package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Type;
import java.util.Collection;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ain implements agu {
    private final ahp a;

    public ain(ahp ahpVar) {
        this.a = ahpVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agu
    public final <T> agt<T> a(age ageVar, akz<T> akzVar) {
        Type typeB = akzVar.b();
        Class<? super T> clsA = akzVar.a();
        if (!Collection.class.isAssignableFrom(clsA)) {
            return null;
        }
        Type typeH = aha.h(typeB, clsA);
        return new aim(ageVar, typeH, ageVar.b(akz.c(typeH)), this.a.a(akzVar));
    }
}
