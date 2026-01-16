package com.google.ads.interactivemedia.v3.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ahf implements aid {
    final /* synthetic */ Class a;
    final /* synthetic */ Type b;
    private final aij c;

    ahf(Class cls, Type type) throws NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException {
        aij aiiVar;
        this.a = cls;
        this.b = type;
        try {
            Class<?> cls2 = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls2.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            aiiVar = new aif(cls2.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int iIntValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    aiiVar = new aig(declaredMethod2, iIntValue);
                } catch (Exception unused2) {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    aiiVar = new aih(declaredMethod3);
                }
            } catch (Exception unused3) {
                aiiVar = new aii();
            }
        }
        this.c = aiiVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aid
    public final Object a() {
        try {
            return this.c.a(this.a);
        } catch (Exception e) {
            throw new RuntimeException("Unable to invoke no-args constructor for " + this.b + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e);
        }
    }
}
