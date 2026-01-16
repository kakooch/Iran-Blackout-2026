package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aul {
    private static final ThreadLocal<Set<aun>> a = new ThreadLocal<>();
    private int b = 17;

    public aul() {
    }

    public aul(byte[] bArr) {
    }

    static Set<aun> a() {
        return a.get();
    }

    public static int b(Object obj, String... strArr) {
        aul aulVar = new aul(null);
        Class<?> superclass = obj.getClass();
        f(obj, superclass, aulVar, strArr);
        while (superclass.getSuperclass() != null) {
            superclass = superclass.getSuperclass();
            f(obj, superclass, aulVar, strArr);
        }
        return aulVar.b;
    }

    private static void e(Object obj) {
        Set<aun> setA = a();
        if (setA != null) {
            setA.remove(new aun(obj));
            if (setA.isEmpty()) {
                a.remove();
            }
        }
    }

    private static void f(Object obj, Class<?> cls, aul aulVar, String[] strArr) {
        Set<aun> setA = a();
        if (setA == null || !setA.contains(new aun(obj))) {
            try {
                Set<aun> setA2 = a();
                if (setA2 == null) {
                    setA2 = new HashSet<>();
                    a.set(setA2);
                }
                setA2.add(new aun(obj));
                Field[] declaredFields = cls.getDeclaredFields();
                AccessibleObject.setAccessible(declaredFields, true);
                for (Field field : declaredFields) {
                    if (!asn.d(strArr, field.getName()) && !field.getName().contains("$") && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers()) && !field.isAnnotationPresent(aum.class)) {
                        try {
                            aulVar.d(field.get(obj));
                        } catch (IllegalAccessException unused) {
                            throw new InternalError("Unexpected IllegalAccessException");
                        }
                    }
                }
            } finally {
                e(obj);
            }
        }
    }

    public final void c(long j) {
        this.b = (this.b * 37) + ((int) (j ^ (j >> 32)));
    }

    public final void d(Object obj) {
        if (obj == null) {
            this.b *= 37;
            return;
        }
        if (!obj.getClass().isArray()) {
            this.b = (this.b * 37) + obj.hashCode();
            return;
        }
        int i = 0;
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length = jArr.length;
            while (i < length) {
                c(jArr[i]);
                i++;
            }
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length2 = iArr.length;
            while (i < length2) {
                this.b = (this.b * 37) + iArr[i];
                i++;
            }
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length3 = sArr.length;
            while (i < length3) {
                this.b = (this.b * 37) + sArr[i];
                i++;
            }
            return;
        }
        if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            int length4 = cArr.length;
            while (i < length4) {
                this.b = (this.b * 37) + cArr[i];
                i++;
            }
            return;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length5 = bArr.length;
            while (i < length5) {
                this.b = (this.b * 37) + bArr[i];
                i++;
            }
            return;
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length6 = dArr.length;
            while (i < length6) {
                c(Double.doubleToLongBits(dArr[i]));
                i++;
            }
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            int length7 = fArr.length;
            while (i < length7) {
                this.b = (this.b * 37) + Float.floatToIntBits(fArr[i]);
                i++;
            }
            return;
        }
        if (!(obj instanceof boolean[])) {
            Object[] objArr = (Object[]) obj;
            int length8 = objArr.length;
            while (i < length8) {
                d(objArr[i]);
                i++;
            }
            return;
        }
        boolean[] zArr = (boolean[]) obj;
        int length9 = zArr.length;
        while (i < length9) {
            this.b = (this.b * 37) + (!zArr[i] ? 1 : 0);
            i++;
        }
    }

    public final int hashCode() {
        return this.b;
    }
}
