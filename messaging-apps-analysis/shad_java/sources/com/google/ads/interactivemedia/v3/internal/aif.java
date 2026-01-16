package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Method;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aif extends aij {
    final /* synthetic */ Method a;
    final /* synthetic */ Object b;

    aif(Method method, Object obj) {
        this.a = method;
        this.b = obj;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aij
    public final <T> T a(Class<T> cls) throws Exception {
        aij.b(cls);
        return (T) this.a.invoke(this.b, cls);
    }
}
