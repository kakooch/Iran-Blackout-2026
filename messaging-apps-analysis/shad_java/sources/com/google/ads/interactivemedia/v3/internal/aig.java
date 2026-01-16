package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Method;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aig extends aij {
    final /* synthetic */ Method a;
    final /* synthetic */ int b;

    aig(Method method, int i) {
        this.a = method;
        this.b = i;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aij
    public final <T> T a(Class<T> cls) throws Exception {
        aij.b(cls);
        return (T) this.a.invoke(null, cls, Integer.valueOf(this.b));
    }
}
