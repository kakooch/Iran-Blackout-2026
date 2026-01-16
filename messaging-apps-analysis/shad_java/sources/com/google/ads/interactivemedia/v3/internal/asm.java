package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Field;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class asm<T> {
    private final Field a;

    /* synthetic */ asm(Field field) {
        this.a = field;
        field.setAccessible(true);
    }

    final void a(T t, Object obj) throws IllegalAccessException, IllegalArgumentException {
        try {
            this.a.set(t, obj);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    final void b(T t, int i) throws IllegalAccessException, IllegalArgumentException {
        try {
            this.a.set(t, Integer.valueOf(i));
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
