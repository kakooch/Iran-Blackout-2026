package ir.nasim;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class I73 {
    public static final Object a(Object obj, InterfaceC15194jA0 interfaceC15194jA0) {
        AbstractC4099Dr3 abstractC4099Dr3E;
        Class clsI;
        Method methodF;
        AbstractC13042fc3.i(interfaceC15194jA0, "descriptor");
        return (((interfaceC15194jA0 instanceof InterfaceC20989sw5) && R73.d((FQ7) interfaceC15194jA0)) || (abstractC4099Dr3E = e(interfaceC15194jA0)) == null || (clsI = i(abstractC4099Dr3E)) == null || (methodF = f(clsI, interfaceC15194jA0)) == null) ? obj : methodF.invoke(obj, null);
    }

    public static final InterfaceC18740pA0 b(InterfaceC18740pA0 interfaceC18740pA0, InterfaceC15194jA0 interfaceC15194jA0, boolean z) {
        AbstractC4099Dr3 returnType;
        AbstractC13042fc3.i(interfaceC18740pA0, "$this$createInlineClassAwareCallerIfNeeded");
        AbstractC13042fc3.i(interfaceC15194jA0, "descriptor");
        if (!R73.a(interfaceC15194jA0)) {
            List listH = interfaceC15194jA0.h();
            AbstractC13042fc3.h(listH, "descriptor.valueParameters");
            List<InterfaceC24919zQ7> list = listH;
            if ((list instanceof Collection) && list.isEmpty()) {
                returnType = interfaceC15194jA0.getReturnType();
                return returnType != null ? interfaceC18740pA0 : interfaceC18740pA0;
            }
            for (InterfaceC24919zQ7 interfaceC24919zQ7 : list) {
                AbstractC13042fc3.h(interfaceC24919zQ7, "it");
                AbstractC4099Dr3 type = interfaceC24919zQ7.getType();
                AbstractC13042fc3.h(type, "it.type");
                if (R73.c(type)) {
                    break;
                }
            }
            returnType = interfaceC15194jA0.getReturnType();
            if ((returnType != null || !R73.c(returnType)) && ((interfaceC18740pA0 instanceof InterfaceC22142uk0) || !g(interfaceC15194jA0))) {
                return interfaceC18740pA0;
            }
        }
        return new H73(interfaceC15194jA0, interfaceC18740pA0, z);
    }

    public static /* synthetic */ InterfaceC18740pA0 c(InterfaceC18740pA0 interfaceC18740pA0, InterfaceC15194jA0 interfaceC15194jA0, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return b(interfaceC18740pA0, interfaceC15194jA0, z);
    }

    public static final Method d(Class cls, InterfaceC15194jA0 interfaceC15194jA0) throws NoSuchMethodException, SecurityException {
        AbstractC13042fc3.i(cls, "$this$getBoxMethod");
        AbstractC13042fc3.i(interfaceC15194jA0, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("box-impl", f(cls, interfaceC15194jA0).getReturnType());
            AbstractC13042fc3.h(declaredMethod, "getDeclaredMethod(\"box\" …d(descriptor).returnType)");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new C25175zr3("No box method found in inline class: " + cls + " (calling " + interfaceC15194jA0 + ')');
        }
    }

    private static final AbstractC4099Dr3 e(InterfaceC15194jA0 interfaceC15194jA0) {
        ZI5 zi5Q = interfaceC15194jA0.Q();
        ZI5 zi5N = interfaceC15194jA0.N();
        if (zi5Q != null) {
            return zi5Q.getType();
        }
        if (zi5N != null) {
            if (interfaceC15194jA0 instanceof InterfaceC21426te1) {
                return zi5N.getType();
            }
            InterfaceC12795fB1 interfaceC12795fB1B = interfaceC15194jA0.b();
            if (!(interfaceC12795fB1B instanceof InterfaceC21331tU0)) {
                interfaceC12795fB1B = null;
            }
            InterfaceC21331tU0 interfaceC21331tU0 = (InterfaceC21331tU0) interfaceC12795fB1B;
            if (interfaceC21331tU0 != null) {
                return interfaceC21331tU0.p();
            }
        }
        return null;
    }

    public static final Method f(Class cls, InterfaceC15194jA0 interfaceC15194jA0) throws NoSuchMethodException, SecurityException {
        AbstractC13042fc3.i(cls, "$this$getUnboxMethod");
        AbstractC13042fc3.i(interfaceC15194jA0, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", null);
            AbstractC13042fc3.h(declaredMethod, "getDeclaredMethod(\"unbox…FOR_INLINE_CLASS_MEMBERS)");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new C25175zr3("No unbox method found in inline class: " + cls + " (calling " + interfaceC15194jA0 + ')');
        }
    }

    private static final boolean g(InterfaceC15194jA0 interfaceC15194jA0) {
        AbstractC4099Dr3 abstractC4099Dr3E = e(interfaceC15194jA0);
        return abstractC4099Dr3E != null && R73.c(abstractC4099Dr3E);
    }

    public static final Class h(InterfaceC12795fB1 interfaceC12795fB1) {
        if (!(interfaceC12795fB1 instanceof InterfaceC21331tU0) || !R73.b(interfaceC12795fB1)) {
            return null;
        }
        InterfaceC21331tU0 interfaceC21331tU0 = (InterfaceC21331tU0) interfaceC12795fB1;
        Class clsM = AbstractC14729iN7.m(interfaceC21331tU0);
        if (clsM != null) {
            return clsM;
        }
        throw new C25175zr3("Class object for the class " + interfaceC21331tU0.getName() + " cannot be found (classId=" + PI1.h((MU0) interfaceC12795fB1) + ')');
    }

    public static final Class i(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "$this$toInlineClass");
        return h(abstractC4099Dr3.K0().t());
    }
}
