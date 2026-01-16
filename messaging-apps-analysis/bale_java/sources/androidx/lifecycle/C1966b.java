package androidx.lifecycle;

import androidx.lifecycle.j;
import ir.nasim.InterfaceC18633oz3;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.lifecycle.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1966b {
    static C1966b c = new C1966b();
    private final Map a = new HashMap();
    private final Map b = new HashMap();

    /* renamed from: androidx.lifecycle.b$a */
    static class a {
        final Map a = new HashMap();
        final Map b;

        a(Map map) {
            this.b = map;
            for (Map.Entry entry : map.entrySet()) {
                j.a aVar = (j.a) entry.getValue();
                List arrayList = (List) this.a.get(aVar);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.a.put(aVar, arrayList);
                }
                arrayList.add((C0090b) entry.getKey());
            }
        }

        private static void b(List list, InterfaceC18633oz3 interfaceC18633oz3, j.a aVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((C0090b) list.get(size)).a(interfaceC18633oz3, aVar, obj);
                }
            }
        }

        void a(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            b((List) this.a.get(aVar), interfaceC18633oz3, aVar, obj);
            b((List) this.a.get(j.a.ON_ANY), interfaceC18633oz3, aVar, obj);
        }
    }

    /* renamed from: androidx.lifecycle.b$b, reason: collision with other inner class name */
    static final class C0090b {
        final int a;
        final Method b;

        C0090b(int i, Method method) throws SecurityException {
            this.a = i;
            this.b = method;
            method.setAccessible(true);
        }

        void a(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                int i = this.a;
                if (i == 0) {
                    this.b.invoke(obj, null);
                } else if (i == 1) {
                    this.b.invoke(obj, interfaceC18633oz3);
                } else {
                    if (i != 2) {
                        return;
                    }
                    this.b.invoke(obj, interfaceC18633oz3, aVar);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0090b)) {
                return false;
            }
            C0090b c0090b = (C0090b) obj;
            return this.a == c0090b.a && this.b.getName().equals(c0090b.b.getName());
        }

        public int hashCode() {
            return (this.a * 31) + this.b.getName().hashCode();
        }
    }

    C1966b() {
    }

    private a a(Class cls, Method[] methodArr) {
        int i;
        a aVarC;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (aVarC = c(superclass)) != null) {
            map.putAll(aVarC.b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry entry : c(cls2).b.entrySet()) {
                e(map, (C0090b) entry.getKey(), (j.a) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            t tVar = (t) method.getAnnotation(t.class);
            if (tVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!InterfaceC18633oz3.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i = 1;
                }
                j.a aVarValue = tVar.value();
                if (parameterTypes.length > 1) {
                    if (!j.a.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (aVarValue != j.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(map, new C0090b(i, method), aVarValue, cls);
                z = true;
            }
        }
        a aVar = new a(map);
        this.a.put(cls, aVar);
        this.b.put(cls, Boolean.valueOf(z));
        return aVar;
    }

    private Method[] b(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    private void e(Map map, C0090b c0090b, j.a aVar, Class cls) {
        j.a aVar2 = (j.a) map.get(c0090b);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(c0090b, aVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0090b.b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }

    a c(Class cls) {
        a aVar = (a) this.a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    boolean d(Class cls) {
        Boolean bool = (Boolean) this.b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] methodArrB = b(cls);
        for (Method method : methodArrB) {
            if (((t) method.getAnnotation(t.class)) != null) {
                a(cls, methodArrB);
                return true;
            }
        }
        this.b.put(cls, Boolean.FALSE);
        return false;
    }
}
