package ir.nasim;

import java.lang.reflect.Method;

/* renamed from: ir.nasim.Yg4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C9048Yg4 {
    public static final C9048Yg4 a = new C9048Yg4();
    private static final a b = new a(null, null, null);
    private static a c;

    /* renamed from: ir.nasim.Yg4$a */
    private static final class a {
        public final Method a;
        public final Method b;
        public final Method c;

        public a(Method method, Method method2, Method method3) {
            this.a = method;
            this.b = method2;
            this.c = method3;
        }
    }

    private C9048Yg4() {
    }

    private final a a(E90 e90) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", null), e90.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), e90.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
            c = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = b;
            c = aVar2;
            return aVar2;
        }
    }

    public final String b(E90 e90) {
        AbstractC13042fc3.i(e90, "continuation");
        a aVarA = c;
        if (aVarA == null) {
            aVarA = a(e90);
        }
        if (aVarA == b) {
            return null;
        }
        Method method = aVarA.a;
        Object objInvoke = method != null ? method.invoke(e90.getClass(), null) : null;
        if (objInvoke == null) {
            return null;
        }
        Method method2 = aVarA.b;
        Object objInvoke2 = method2 != null ? method2.invoke(objInvoke, null) : null;
        if (objInvoke2 == null) {
            return null;
        }
        Method method3 = aVarA.c;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
        if (objInvoke3 instanceof String) {
            return (String) objInvoke3;
        }
        return null;
    }
}
