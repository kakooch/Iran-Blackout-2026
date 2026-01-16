package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Modifier;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class aij {
    static void b(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
        }
        if (Modifier.isAbstract(modifiers)) {
            throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
        }
    }

    public abstract <T> T a(Class<T> cls) throws Exception;
}
