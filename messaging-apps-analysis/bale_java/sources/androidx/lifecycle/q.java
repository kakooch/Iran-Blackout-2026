package androidx.lifecycle;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC9766aX0;
import ir.nasim.InterfaceC18042nz3;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class q {
    public static final q a = new q();
    private static final Map b = new HashMap();
    private static final Map c = new HashMap();

    private q() {
    }

    private final InterfaceC1971g a(Constructor constructor, Object obj) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objNewInstance = constructor.newInstance(obj);
            AbstractC13042fc3.h(objNewInstance, "{\n            constructo…tance(`object`)\n        }");
            AbstractC18350oW3.a(objNewInstance);
            return null;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    private final Constructor b(Class cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        try {
            Package r0 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r0 != null ? r0.getName() : "";
            AbstractC13042fc3.h(name, "fullPackage");
            if (name.length() != 0) {
                AbstractC13042fc3.h(canonicalName, "name");
                canonicalName = canonicalName.substring(name.length() + 1);
                AbstractC13042fc3.h(canonicalName, "this as java.lang.String).substring(startIndex)");
            }
            AbstractC13042fc3.h(canonicalName, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
            String strC = c(canonicalName);
            if (name.length() != 0) {
                strC = name + '.' + strC;
            }
            Class<?> cls2 = Class.forName(strC);
            AbstractC13042fc3.g(cls2, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
            Constructor<?> declaredConstructor = cls2.getDeclaredConstructor(cls);
            if (declaredConstructor.isAccessible()) {
                return declaredConstructor;
            }
            declaredConstructor.setAccessible(true);
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String c(String str) {
        AbstractC13042fc3.i(str, "className");
        return AbstractC20153rZ6.M(str, Separators.DOT, "_", false, 4, null) + "_LifecycleAdapter";
    }

    private final int d(Class cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Map map = b;
        Integer num = (Integer) map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int iG = g(cls);
        map.put(cls, Integer.valueOf(iG));
        return iG;
    }

    private final boolean e(Class cls) {
        return cls != null && InterfaceC18042nz3.class.isAssignableFrom(cls);
    }

    public static final n f(Object obj) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        AbstractC13042fc3.i(obj, "object");
        boolean z = obj instanceof n;
        boolean z2 = obj instanceof DefaultLifecycleObserver;
        if (z && z2) {
            return new C1968d((DefaultLifecycleObserver) obj, (n) obj);
        }
        if (z2) {
            return new C1968d((DefaultLifecycleObserver) obj, null);
        }
        if (z) {
            return (n) obj;
        }
        Class<?> cls = obj.getClass();
        q qVar = a;
        if (qVar.d(cls) != 2) {
            return new v(obj);
        }
        Object obj2 = c.get(cls);
        AbstractC13042fc3.f(obj2);
        List list = (List) obj2;
        if (list.size() == 1) {
            qVar.a((Constructor) list.get(0), obj);
            return new E(null);
        }
        int size = list.size();
        InterfaceC1971g[] interfaceC1971gArr = new InterfaceC1971g[size];
        for (int i = 0; i < size; i++) {
            a.a((Constructor) list.get(i), obj);
            interfaceC1971gArr[i] = null;
        }
        return new C1967c(interfaceC1971gArr);
    }

    private final int g(Class cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor constructorB = b(cls);
        if (constructorB != null) {
            c.put(cls, AbstractC9766aX0.e(constructorB));
            return 2;
        }
        if (C1966b.c.d(cls)) {
            return 1;
        }
        Class superclass = cls.getSuperclass();
        if (e(superclass)) {
            AbstractC13042fc3.h(superclass, "superclass");
            if (d(superclass) == 1) {
                return 1;
            }
            Object obj = c.get(superclass);
            AbstractC13042fc3.f(obj);
            arrayList = new ArrayList((Collection) obj);
        } else {
            arrayList = null;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        AbstractC13042fc3.h(interfaces, "klass.interfaces");
        for (Class<?> cls2 : interfaces) {
            if (e(cls2)) {
                AbstractC13042fc3.h(cls2, "intrface");
                if (d(cls2) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                Object obj2 = c.get(cls2);
                AbstractC13042fc3.f(obj2);
                arrayList.addAll((Collection) obj2);
            }
        }
        if (arrayList == null) {
            return 1;
        }
        c.put(cls, arrayList);
        return 2;
    }
}
