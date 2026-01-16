package ir.nasim;

import ir.nasim.InterfaceC20297rm3;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.qy7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC19810qy7 {
    public static Collection a(Object obj) {
        if ((obj instanceof InterfaceC17915nm3) && !(obj instanceof InterfaceC18506om3)) {
            t(obj, "kotlin.collections.MutableCollection");
        }
        return h(obj);
    }

    public static Iterable b(Object obj) {
        if ((obj instanceof InterfaceC17915nm3) && !(obj instanceof InterfaceC19097pm3)) {
            t(obj, "kotlin.collections.MutableIterable");
        }
        return i(obj);
    }

    public static List c(Object obj) {
        if ((obj instanceof InterfaceC17915nm3) && !(obj instanceof InterfaceC19688qm3)) {
            t(obj, "kotlin.collections.MutableList");
        }
        return j(obj);
    }

    public static Map d(Object obj) {
        if ((obj instanceof InterfaceC17915nm3) && !(obj instanceof InterfaceC20297rm3)) {
            t(obj, "kotlin.collections.MutableMap");
        }
        return k(obj);
    }

    public static Map.Entry e(Object obj) {
        if ((obj instanceof InterfaceC17915nm3) && !(obj instanceof InterfaceC20297rm3.a)) {
            t(obj, "kotlin.collections.MutableMap.MutableEntry");
        }
        return l(obj);
    }

    public static Set f(Object obj) {
        if ((obj instanceof InterfaceC17915nm3) && !(obj instanceof InterfaceC24531ym3)) {
            t(obj, "kotlin.collections.MutableSet");
        }
        return m(obj);
    }

    public static Object g(Object obj, int i) {
        if (obj != null && !o(obj, i)) {
            t(obj, "kotlin.jvm.functions.Function" + i);
        }
        return obj;
    }

    public static Collection h(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e) {
            throw s(e);
        }
    }

    public static Iterable i(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e) {
            throw s(e);
        }
    }

    public static List j(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e) {
            throw s(e);
        }
    }

    public static Map k(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e) {
            throw s(e);
        }
    }

    public static Map.Entry l(Object obj) {
        try {
            return (Map.Entry) obj;
        } catch (ClassCastException e) {
            throw s(e);
        }
    }

    public static Set m(Object obj) {
        try {
            return (Set) obj;
        } catch (ClassCastException e) {
            throw s(e);
        }
    }

    public static int n(Object obj) {
        if (obj instanceof InterfaceC23005wB2) {
            return ((InterfaceC23005wB2) obj).getArity();
        }
        if (obj instanceof SA2) {
            return 0;
        }
        if (obj instanceof UA2) {
            return 1;
        }
        if (obj instanceof InterfaceC14603iB2) {
            return 2;
        }
        if (obj instanceof InterfaceC15796kB2) {
            return 3;
        }
        if (obj instanceof InterfaceC16978mB2) {
            return 4;
        }
        if (obj instanceof InterfaceC18160oB2) {
            return 5;
        }
        if (obj instanceof InterfaceC19342qB2) {
            return 6;
        }
        if (obj instanceof InterfaceC19933rB2) {
            return 7;
        }
        if (obj instanceof InterfaceC20542sB2) {
            return 8;
        }
        if (obj instanceof InterfaceC21145tB2) {
            return 9;
        }
        if (obj instanceof TA2) {
            return 10;
        }
        if (obj instanceof VA2) {
            return 11;
        }
        if (obj instanceof WA2) {
            return 12;
        }
        if (obj instanceof XA2) {
            return 13;
        }
        if (obj instanceof YA2) {
            return 14;
        }
        if (obj instanceof ZA2) {
            return 15;
        }
        if (obj instanceof InterfaceC9570aB2) {
            return 16;
        }
        if (obj instanceof InterfaceC10164bB2) {
            return 17;
        }
        if (obj instanceof InterfaceC10780cB2) {
            return 18;
        }
        if (obj instanceof InterfaceC11544dB2) {
            return 19;
        }
        if (obj instanceof InterfaceC12796fB2) {
            return 20;
        }
        if (obj instanceof InterfaceC13414gB2) {
            return 21;
        }
        return obj instanceof InterfaceC14005hB2 ? 22 : -1;
    }

    public static boolean o(Object obj, int i) {
        return (obj instanceof InterfaceC18751pB2) && n(obj) == i;
    }

    public static boolean p(Object obj) {
        return (obj instanceof List) && (!(obj instanceof InterfaceC17915nm3) || (obj instanceof InterfaceC19688qm3));
    }

    public static boolean q(Object obj) {
        return (obj instanceof Set) && (!(obj instanceof InterfaceC17915nm3) || (obj instanceof InterfaceC24531ym3));
    }

    private static Throwable r(Throwable th) {
        return AbstractC13042fc3.p(th, AbstractC19810qy7.class.getName());
    }

    public static ClassCastException s(ClassCastException classCastException) {
        throw ((ClassCastException) r(classCastException));
    }

    public static void t(Object obj, String str) {
        u((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void u(String str) {
        throw s(new ClassCastException(str));
    }
}
