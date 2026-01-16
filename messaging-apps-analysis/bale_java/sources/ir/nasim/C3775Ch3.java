package ir.nasim;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Ch3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C3775Ch3 {
    public static final C3775Ch3 a = new C3775Ch3();
    private static a b;

    /* renamed from: ir.nasim.Ch3$a */
    public static final class a {
        private final Method a;
        private final Method b;

        public a(Method method, Method method2) {
            this.a = method;
            this.b = method2;
        }

        public final Method a() {
            return this.b;
        }

        public final Method b() {
            return this.a;
        }
    }

    private C3775Ch3() {
    }

    public final a a(Member member) throws NoSuchMethodException, SecurityException {
        AbstractC13042fc3.i(member, "member");
        Class<?> cls = member.getClass();
        try {
            return new a(cls.getMethod("getParameters", null), AbstractC21912uL5.g(cls).loadClass("java.lang.reflect.Parameter").getMethod("getName", null));
        } catch (NoSuchMethodException unused) {
            return new a(null, null);
        }
    }

    public final List b(Member member) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method methodA;
        AbstractC13042fc3.i(member, "member");
        a aVarA = b;
        if (aVarA == null) {
            aVarA = a(member);
            b = aVarA;
        }
        Method methodB = aVarA.b();
        if (methodB == null || (methodA = aVarA.a()) == null) {
            return null;
        }
        Object objInvoke = methodB.invoke(member, null);
        if (objInvoke == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<*>");
        }
        Object[] objArr = (Object[]) objInvoke;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Object objInvoke2 = methodA.invoke(obj, null);
            if (objInvoke2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            arrayList.add((String) objInvoke2);
        }
        return arrayList;
    }
}
