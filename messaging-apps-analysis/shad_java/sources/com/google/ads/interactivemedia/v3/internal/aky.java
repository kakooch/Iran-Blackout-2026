package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aky extends akx {
    private static Class a;
    private final Object b;
    private final Field c;

    aky() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException {
        Object obj = null;
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            a = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            obj = declaredField.get(null);
        } catch (Exception unused) {
        }
        this.b = obj;
        this.c = c();
    }

    private static Field c() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.akx
    public final void a(AccessibleObject accessibleObject) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.b != null && this.c != null) {
            try {
                a.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.b, accessibleObject, Long.valueOf(((Long) a.getMethod("objectFieldOffset", Field.class).invoke(this.b, this.c)).longValue()), Boolean.TRUE);
                return;
            } catch (Exception unused) {
            }
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e) {
            throw new agk("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e);
        }
    }
}
