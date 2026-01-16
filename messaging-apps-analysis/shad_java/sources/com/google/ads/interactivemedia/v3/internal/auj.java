package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class auj {
    private static final ThreadLocal<Set<aup<aun, aun>>> a = new ThreadLocal<>();
    private final List<Class<?>> c;
    private boolean b = true;
    private String[] d = null;

    public auj() {
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        arrayList.add(String.class);
    }

    static Set<aup<aun, aun>> a() {
        return a.get();
    }

    static aup<aun, aun> b(Object obj, Object obj2) {
        return aup.c(new aun(obj), new aun(obj2));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(java.lang.Object r5, java.lang.Object r6, java.lang.String... r7) {
        /*
            r0 = 0
            if (r5 != r6) goto L6
            r0 = 1
            goto L74
        L6:
            if (r6 != 0) goto La
            goto L74
        La:
            com.google.ads.interactivemedia.v3.internal.auj r1 = new com.google.ads.interactivemedia.v3.internal.auj
            r1.<init>()
            r1.d = r7
            boolean r7 = r1.b
            if (r7 != 0) goto L16
            goto L72
        L16:
            if (r5 == r6) goto L72
            java.lang.Class r7 = r5.getClass()
            java.lang.Class r2 = r6.getClass()
            boolean r3 = r7.isInstance(r6)
            if (r3 == 0) goto L2d
            boolean r3 = r2.isInstance(r5)
            if (r3 != 0) goto L39
            goto L3b
        L2d:
            boolean r3 = r2.isInstance(r5)
            if (r3 == 0) goto L70
            boolean r3 = r7.isInstance(r6)
            if (r3 != 0) goto L3b
        L39:
            r3 = r7
            goto L3c
        L3b:
            r3 = r2
        L3c:
            boolean r4 = r3.isArray()     // Catch: java.lang.IllegalArgumentException -> L70
            if (r4 == 0) goto L46
            r1.f(r5, r6)     // Catch: java.lang.IllegalArgumentException -> L70
            goto L72
        L46:
            java.util.List<java.lang.Class<?>> r4 = r1.c     // Catch: java.lang.IllegalArgumentException -> L70
            if (r4 == 0) goto L5f
            boolean r7 = r4.contains(r7)     // Catch: java.lang.IllegalArgumentException -> L70
            if (r7 != 0) goto L58
            java.util.List<java.lang.Class<?>> r7 = r1.c     // Catch: java.lang.IllegalArgumentException -> L70
            boolean r7 = r7.contains(r2)     // Catch: java.lang.IllegalArgumentException -> L70
            if (r7 == 0) goto L5f
        L58:
            boolean r5 = r5.equals(r6)     // Catch: java.lang.IllegalArgumentException -> L70
            r1.b = r5     // Catch: java.lang.IllegalArgumentException -> L70
            goto L72
        L5f:
            r1.i(r5, r6, r3)     // Catch: java.lang.IllegalArgumentException -> L70
        L62:
            java.lang.Class r7 = r3.getSuperclass()     // Catch: java.lang.IllegalArgumentException -> L70
            if (r7 == 0) goto L72
            java.lang.Class r3 = r3.getSuperclass()     // Catch: java.lang.IllegalArgumentException -> L70
            r1.i(r5, r6, r3)     // Catch: java.lang.IllegalArgumentException -> L70
            goto L62
        L70:
            r1.b = r0
        L72:
            boolean r0 = r1.b
        L74:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.auj.c(java.lang.Object, java.lang.Object, java.lang.String[]):boolean");
    }

    private static void h(Object obj, Object obj2) {
        Set<aup<aun, aun>> setA = a();
        if (setA != null) {
            setA.remove(b(obj, obj2));
            if (setA.isEmpty()) {
                a.remove();
            }
        }
    }

    private final void i(Object obj, Object obj2, Class<?> cls) {
        Set<aup<aun, aun>> setA = a();
        aup<aun, aun> aupVarB = b(obj, obj2);
        aup aupVarC = aup.c(aupVarB.b(), aupVarB.a());
        if (setA == null || !(setA.contains(aupVarB) || setA.contains(aupVarC))) {
            try {
                Set<aup<aun, aun>> setA2 = a();
                if (setA2 == null) {
                    setA2 = new HashSet<>();
                    a.set(setA2);
                }
                setA2.add(b(obj, obj2));
                Field[] declaredFields = cls.getDeclaredFields();
                AccessibleObject.setAccessible(declaredFields, true);
                for (int i = 0; i < declaredFields.length && this.b; i++) {
                    Field field = declaredFields[i];
                    if (!asn.d(this.d, field.getName()) && !field.getName().contains("$") && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers()) && !field.isAnnotationPresent(auk.class)) {
                        try {
                            f(field.get(obj), field.get(obj2));
                        } catch (IllegalAccessException unused) {
                            throw new InternalError("Unexpected IllegalAccessException");
                        }
                    }
                }
            } finally {
                h(obj, obj2);
            }
        }
    }

    public final void d(int i, int i2) {
        if (this.b) {
            this.b = i == i2;
        }
    }

    public final void e(long j, long j2) {
        if (this.b) {
            this.b = j == j2;
        }
    }

    protected final void g() {
        this.b = false;
    }

    public final void f(Object obj, Object obj2) {
        if (this.b && obj != obj2) {
            if (obj == null || obj2 == null) {
                g();
                return;
            }
            if (!obj.getClass().isArray()) {
                this.b = obj.equals(obj2);
                return;
            }
            if (obj.getClass() != obj2.getClass()) {
                g();
                return;
            }
            int i = 0;
            if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                long[] jArr2 = (long[]) obj2;
                if (this.b && jArr != jArr2) {
                    if (jArr.length != jArr2.length) {
                        g();
                        return;
                    }
                    while (i < jArr.length && this.b) {
                        e(jArr[i], jArr2[i]);
                        i++;
                    }
                    return;
                }
                return;
            }
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                int[] iArr2 = (int[]) obj2;
                if (!this.b || iArr == iArr2) {
                    return;
                }
                if (iArr.length != iArr2.length) {
                    g();
                    return;
                }
                while (i < iArr.length && this.b) {
                    d(iArr[i], iArr2[i]);
                    i++;
                }
                return;
            }
            if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                short[] sArr2 = (short[]) obj2;
                if (!this.b || sArr == sArr2) {
                    return;
                }
                if (sArr.length != sArr2.length) {
                    g();
                    return;
                }
                for (int i2 = 0; i2 < sArr.length && this.b; i2++) {
                    this.b = sArr[i2] == sArr2[i2];
                }
                return;
            }
            if (obj instanceof char[]) {
                char[] cArr = (char[]) obj;
                char[] cArr2 = (char[]) obj2;
                if (!this.b || cArr == cArr2) {
                    return;
                }
                if (cArr.length != cArr2.length) {
                    g();
                    return;
                }
                for (int i3 = 0; i3 < cArr.length && this.b; i3++) {
                    this.b = cArr[i3] == cArr2[i3];
                }
                return;
            }
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (!this.b || bArr == bArr2) {
                    return;
                }
                if (bArr.length != bArr2.length) {
                    g();
                    return;
                }
                for (int i4 = 0; i4 < bArr.length && this.b; i4++) {
                    this.b = bArr[i4] == bArr2[i4];
                }
                return;
            }
            if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                double[] dArr2 = (double[]) obj2;
                if (!this.b || dArr == dArr2) {
                    return;
                }
                if (dArr.length != dArr2.length) {
                    g();
                    return;
                }
                while (i < dArr.length && this.b) {
                    e(Double.doubleToLongBits(dArr[i]), Double.doubleToLongBits(dArr2[i]));
                    i++;
                }
                return;
            }
            if (obj instanceof float[]) {
                float[] fArr = (float[]) obj;
                float[] fArr2 = (float[]) obj2;
                if (!this.b || fArr == fArr2) {
                    return;
                }
                if (fArr.length != fArr2.length) {
                    g();
                    return;
                }
                while (i < fArr.length && this.b) {
                    d(Float.floatToIntBits(fArr[i]), Float.floatToIntBits(fArr2[i]));
                    i++;
                }
                return;
            }
            if (!(obj instanceof boolean[])) {
                Object[] objArr = (Object[]) obj;
                Object[] objArr2 = (Object[]) obj2;
                if (!this.b || objArr == objArr2) {
                    return;
                }
                if (objArr.length != objArr2.length) {
                    g();
                    return;
                }
                while (i < objArr.length && this.b) {
                    f(objArr[i], objArr2[i]);
                    i++;
                }
                return;
            }
            boolean[] zArr = (boolean[]) obj;
            boolean[] zArr2 = (boolean[]) obj2;
            if (!this.b || zArr == zArr2) {
                return;
            }
            if (zArr.length != zArr2.length) {
                g();
                return;
            }
            for (int i5 = 0; i5 < zArr.length && this.b; i5++) {
                this.b = zArr[i5] == zArr2[i5];
            }
        }
    }
}
