package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Method;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aih extends aij {
    final /* synthetic */ Method a;

    aih(Method method) {
        this.a = method;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aij
    public final <T> T a(Class<T> cls) throws Exception {
        aij.b(cls);
        return (T) this.a.invoke(null, cls, Object.class);
    }
}
