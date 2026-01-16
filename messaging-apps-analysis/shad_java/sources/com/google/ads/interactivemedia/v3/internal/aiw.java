package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Type;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aiw implements agu {
    final boolean a = false;
    private final ahp b;

    public aiw(ahp ahpVar) {
        this.b = ahpVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agu
    public final <T> agt<T> a(age ageVar, akz<T> akzVar) throws NoSuchMethodException, SecurityException {
        Type typeB = akzVar.b();
        if (!Map.class.isAssignableFrom(akzVar.a())) {
            return null;
        }
        Type[] typeArrI = aha.i(typeB, aha.c(typeB));
        Type type = typeArrI[0];
        return new aiv(this, ageVar, typeArrI[0], (type == Boolean.TYPE || type == Boolean.class) ? aku.f : ageVar.b(akz.c(type)), typeArrI[1], ageVar.b(akz.c(typeArrI[1])), this.b.a(akzVar));
    }
}
