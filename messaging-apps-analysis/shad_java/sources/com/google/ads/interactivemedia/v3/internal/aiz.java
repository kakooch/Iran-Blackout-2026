package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aiz<T> extends agt<T> {
    private final aid<T> a;
    private final Map<String, aja> b;

    aiz(aid<T> aidVar, Map<String, aja> map) {
        this.a = aidVar;
        this.b = map;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final T read(alb albVar) throws IOException, IllegalArgumentException {
        if (albVar.p() == 9) {
            albVar.i();
            return null;
        }
        T tA = this.a.a();
        try {
            albVar.c();
            while (albVar.e()) {
                aja ajaVar = this.b.get(albVar.f());
                if (ajaVar == null || !ajaVar.c) {
                    albVar.m();
                } else {
                    ajaVar.b(albVar, tA);
                }
            }
            albVar.d();
            return tA;
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (IllegalStateException e2) {
            throw new agq(e2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final void write(ald aldVar, T t) throws IOException, IllegalArgumentException {
        if (t == null) {
            aldVar.g();
            return;
        }
        aldVar.c();
        try {
            for (aja ajaVar : this.b.values()) {
                if (ajaVar.c(t)) {
                    aldVar.f(ajaVar.a);
                    ajaVar.a(aldVar, t);
                }
            }
            aldVar.e();
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
