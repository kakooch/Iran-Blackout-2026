package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ajj<T> extends agt<T> {
    private final age a;
    private final agt<T> b;
    private final Type c;

    ajj(age ageVar, agt<T> agtVar, Type type) {
        this.a = ageVar;
        this.b = agtVar;
        this.c = type;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final T read(alb albVar) throws IOException {
        return this.b.read(albVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.reflect.Type] */
    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final void write(ald aldVar, T t) throws IOException {
        agt<T> agtVarB = this.b;
        ?? r1 = this.c;
        Class<?> cls = (t == null || !(r1 == Object.class || (r1 instanceof TypeVariable) || (r1 instanceof Class))) ? r1 : t.getClass();
        if (cls != r1) {
            agtVarB = this.a.b(akz.c(cls));
            if (agtVarB instanceof aiz) {
                agt<T> agtVar = this.b;
                if (!(agtVar instanceof aiz)) {
                    agtVarB = agtVar;
                }
            }
        }
        agtVarB.write(aldVar, t);
    }
}
