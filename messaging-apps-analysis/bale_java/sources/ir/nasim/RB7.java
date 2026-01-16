package ir.nasim;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public abstract class RB7 {
    public static final RB7 a = c();

    class a extends RB7 {
        final /* synthetic */ Method b;
        final /* synthetic */ Object c;

        a(Method method, Object obj) {
            this.b = method;
            this.c = obj;
        }

        @Override // ir.nasim.RB7
        public Object d(Class cls) {
            RB7.b(cls);
            return this.b.invoke(this.c, cls);
        }
    }

    class b extends RB7 {
        final /* synthetic */ Method b;
        final /* synthetic */ int c;

        b(Method method, int i) {
            this.b = method;
            this.c = i;
        }

        @Override // ir.nasim.RB7
        public Object d(Class cls) {
            RB7.b(cls);
            return this.b.invoke(null, cls, Integer.valueOf(this.c));
        }
    }

    class c extends RB7 {
        final /* synthetic */ Method b;

        c(Method method) {
            this.b = method;
        }

        @Override // ir.nasim.RB7
        public Object d(Class cls) {
            RB7.b(cls);
            return this.b.invoke(null, cls, Object.class);
        }
    }

    class d extends RB7 {
        d() {
        }

        @Override // ir.nasim.RB7
        public Object d(Class cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Class cls) {
        String strA = C20806se1.a(cls);
        if (strA == null) {
            return;
        }
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + strA);
    }

    private static RB7 c() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException {
        try {
            try {
                try {
                    Class<?> cls = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
                } catch (Exception unused) {
                    return new d();
                }
            } catch (Exception unused2) {
                Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod.setAccessible(true);
                return new c(declaredMethod);
            }
        } catch (Exception unused3) {
            Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
            declaredMethod2.setAccessible(true);
            int iIntValue = ((Integer) declaredMethod2.invoke(null, Object.class)).intValue();
            Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
            declaredMethod3.setAccessible(true);
            return new b(declaredMethod3, iIntValue);
        }
    }

    public abstract Object d(Class cls);
}
