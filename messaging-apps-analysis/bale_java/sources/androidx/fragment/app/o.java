package androidx.fragment.app;

import androidx.fragment.app.Fragment;
import ir.nasim.C24792zC6;

/* loaded from: classes2.dex */
public abstract class o {
    private static final C24792zC6 a = new C24792zC6();

    static boolean b(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static Class c(ClassLoader classLoader, String str) throws ClassNotFoundException {
        C24792zC6 c24792zC6 = a;
        C24792zC6 c24792zC62 = (C24792zC6) c24792zC6.get(classLoader);
        if (c24792zC62 == null) {
            c24792zC62 = new C24792zC6();
            c24792zC6.put(classLoader, c24792zC62);
        }
        Class cls = (Class) c24792zC62.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        c24792zC62.put(str, cls2);
        return cls2;
    }

    public static Class d(ClassLoader classLoader, String str) {
        try {
            return c(classLoader, str);
        } catch (ClassCastException e) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e);
        } catch (ClassNotFoundException e2) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists", e2);
        }
    }

    public abstract Fragment a(ClassLoader classLoader, String str);
}
