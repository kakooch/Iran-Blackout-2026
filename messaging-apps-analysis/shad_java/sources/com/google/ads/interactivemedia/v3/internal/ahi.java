package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ahi implements aid {
    final /* synthetic */ Constructor a;

    ahi(Constructor constructor) {
        this.a = constructor;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aid
    public final Object a() {
        try {
            return this.a.newInstance(null);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Failed to invoke " + this.a + " with no args", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("Failed to invoke " + this.a + " with no args", e3.getTargetException());
        }
    }
}
