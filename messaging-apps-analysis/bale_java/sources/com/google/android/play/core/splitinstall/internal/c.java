package com.google.android.play.core.splitinstall.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/* loaded from: classes3.dex */
public abstract class c {
    public static a a(Object obj, String str, Class cls) {
        return new a(obj, h(obj, str), cls);
    }

    public static b b(Object obj, String str, Class cls) {
        return new b(obj, h(obj, str), cls);
    }

    public static Object c(Class cls) throws NoSuchMethodException, SecurityException {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(null);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor.newInstance(null);
        } catch (Exception e) {
            throw new zzbl(String.format("Failed to invoke default constructor on class %s", cls.getName()), e);
        }
    }

    public static Object d(Object obj, String str, Class cls, Class cls2, Object obj2) {
        try {
            return cls.cast(i(obj.getClass(), str, cls2).invoke(obj, obj2));
        } catch (Exception e) {
            throw new zzbl(String.format("Failed to invoke method %s on an object of type %s", str, obj.getClass()), e);
        }
    }

    public static Object e(Object obj, String str, Class cls, Class cls2, Object obj2, Class cls3, Object obj3, Class cls4, Object obj4) {
        try {
            return cls.cast(i(obj.getClass(), str, cls2, cls3, cls4).invoke(obj, obj2, obj3, obj4));
        } catch (Exception e) {
            throw new zzbl(String.format("Failed to invoke method %s on an object of type %s", str, obj.getClass()), e);
        }
    }

    public static Object f(Class cls, String str, Class cls2, Class cls3, Object obj) {
        try {
            return cls2.cast(i(cls, "isDexOptNeeded", cls3).invoke(null, obj));
        } catch (Exception e) {
            throw new zzbl(String.format("Failed to invoke static method %s on type %s", "isDexOptNeeded", cls), e);
        }
    }

    public static Object g(Class cls, String str, Class cls2, Class cls3, Object obj, Class cls4, Object obj2) {
        try {
            return cls2.cast(i(cls, "optimizedPathFor", cls3, cls4).invoke(null, obj, obj2));
        } catch (Exception e) {
            throw new zzbl(String.format("Failed to invoke static method %s on type %s", "optimizedPathFor", cls), e);
        }
    }

    private static Field h(Object obj, String str) throws NoSuchFieldException, SecurityException {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new zzbl(String.format("Failed to find a field named %s on an object of instance %s", str, obj.getClass().getName()));
    }

    private static Method i(Class cls, String str, Class... clsArr) throws NoSuchMethodException, SecurityException {
        for (Class superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Method declaredMethod = superclass.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        throw new zzbl(String.format("Could not find a method named %s with parameters %s in type %s", str, Arrays.asList(clsArr), cls));
    }
}
