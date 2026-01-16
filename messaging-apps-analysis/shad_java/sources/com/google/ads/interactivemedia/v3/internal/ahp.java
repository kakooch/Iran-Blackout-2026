package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ahp {
    private final Map<Type, agg<?>> a;
    private final akx b = akx.b();

    public ahp(Map<Type, agg<?>> map) {
        this.a = map;
    }

    public final <T> aid<T> a(akz<T> akzVar) throws NoSuchMethodException, SecurityException {
        ahi ahiVar;
        Type typeB = akzVar.b();
        Class<? super T> clsA = akzVar.a();
        agg<?> aggVar = this.a.get(typeB);
        if (aggVar != null) {
            return new ahg(aggVar, typeB);
        }
        agg<?> aggVar2 = this.a.get(clsA);
        if (aggVar2 != null) {
            return new ahh(aggVar2, typeB);
        }
        aid<T> ahoVar = null;
        try {
            Constructor<? super T> declaredConstructor = clsA.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.b.a(declaredConstructor);
            }
            ahiVar = new ahi(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            ahiVar = null;
        }
        if (ahiVar != null) {
            return ahiVar;
        }
        if (Collection.class.isAssignableFrom(clsA)) {
            ahoVar = SortedSet.class.isAssignableFrom(clsA) ? new ahj() : EnumSet.class.isAssignableFrom(clsA) ? new ahk(typeB) : Set.class.isAssignableFrom(clsA) ? new ahl() : Queue.class.isAssignableFrom(clsA) ? new ahm() : new ahn();
        } else if (Map.class.isAssignableFrom(clsA)) {
            ahoVar = ConcurrentNavigableMap.class.isAssignableFrom(clsA) ? new aho() : ConcurrentMap.class.isAssignableFrom(clsA) ? new ahb() : SortedMap.class.isAssignableFrom(clsA) ? new ahc() : (!(typeB instanceof ParameterizedType) || String.class.isAssignableFrom(akz.c(((ParameterizedType) typeB).getActualTypeArguments()[0]).a())) ? new ahe() : new ahd();
        }
        return ahoVar != null ? ahoVar : new ahf(clsA, typeB);
    }

    public final String toString() {
        return this.a.toString();
    }
}
