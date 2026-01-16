package ir.nasim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.ap8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC9951ap8 {
    public static double a(double d) {
        if (Double.isNaN(d)) {
            return 0.0d;
        }
        if (Double.isInfinite(d) || d == 0.0d || d == 0.0d) {
            return d;
        }
        return (d > 0.0d ? 1 : -1) * Math.floor(Math.abs(d));
    }

    public static int b(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d) || d == 0.0d) {
            return 0;
        }
        return (int) (((d > 0.0d ? 1 : -1) * Math.floor(Math.abs(d))) % 4.294967296E9d);
    }

    public static int c(C20322ro8 c20322ro8) {
        int iB = b(c20322ro8.d("runtime.counter").k().doubleValue() + 1.0d);
        if (iB > 1000000) {
            throw new IllegalStateException("Instructions allowed exceeded");
        }
        c20322ro8.g("runtime.counter", new Ph8(Double.valueOf(iB)));
        return iB;
    }

    public static long d(double d) {
        return b(d) & 4294967295L;
    }

    public static EnumC9901ak8 e(String str) {
        EnumC9901ak8 enumC9901ak8A = null;
        if (str != null && !str.isEmpty()) {
            enumC9901ak8A = EnumC9901ak8.a(Integer.parseInt(str));
        }
        if (enumC9901ak8A != null) {
            return enumC9901ak8A;
        }
        throw new IllegalArgumentException(String.format("Unsupported commandId %s", str));
    }

    public static Object f(InterfaceC22720vi8 interfaceC22720vi8) {
        if (InterfaceC22720vi8.s0.equals(interfaceC22720vi8)) {
            return null;
        }
        if (InterfaceC22720vi8.r0.equals(interfaceC22720vi8)) {
            return "";
        }
        if (interfaceC22720vi8 instanceof C17289mi8) {
            return g((C17289mi8) interfaceC22720vi8);
        }
        if (!(interfaceC22720vi8 instanceof Ch8)) {
            return !interfaceC22720vi8.k().isNaN() ? interfaceC22720vi8.k() : interfaceC22720vi8.j();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = ((Ch8) interfaceC22720vi8).iterator();
        while (it.hasNext()) {
            Object objF = f((InterfaceC22720vi8) it.next());
            if (objF != null) {
                arrayList.add(objF);
            }
        }
        return arrayList;
    }

    public static Map g(C17289mi8 c17289mi8) {
        HashMap map = new HashMap();
        for (String str : c17289mi8.a()) {
            Object objF = f(c17289mi8.h(str));
            if (objF != null) {
                map.put(str, objF);
            }
        }
        return map;
    }

    public static void h(String str, int i, List list) {
        if (list.size() != i) {
            throw new IllegalArgumentException(String.format("%s operation requires %s parameters found %s", str, Integer.valueOf(i), Integer.valueOf(list.size())));
        }
    }

    public static void i(String str, int i, List list) {
        if (list.size() < i) {
            throw new IllegalArgumentException(String.format("%s operation requires at least %s parameters found %s", str, Integer.valueOf(i), Integer.valueOf(list.size())));
        }
    }

    public static void j(String str, int i, List list) {
        if (list.size() > i) {
            throw new IllegalArgumentException(String.format("%s operation requires at most %s parameters found %s", str, Integer.valueOf(i), Integer.valueOf(list.size())));
        }
    }

    public static boolean k(InterfaceC22720vi8 interfaceC22720vi8) {
        if (interfaceC22720vi8 == null) {
            return false;
        }
        Double dK = interfaceC22720vi8.k();
        return !dK.isNaN() && dK.doubleValue() >= 0.0d && dK.equals(Double.valueOf(Math.floor(dK.doubleValue())));
    }

    public static boolean l(InterfaceC22720vi8 interfaceC22720vi8, InterfaceC22720vi8 interfaceC22720vi82) {
        if (!interfaceC22720vi8.getClass().equals(interfaceC22720vi82.getClass())) {
            return false;
        }
        if ((interfaceC22720vi8 instanceof Ii8) || (interfaceC22720vi8 instanceof C19062pi8)) {
            return true;
        }
        if (!(interfaceC22720vi8 instanceof Ph8)) {
            return interfaceC22720vi8 instanceof Ei8 ? interfaceC22720vi8.j().equals(interfaceC22720vi82.j()) : interfaceC22720vi8 instanceof Ih8 ? interfaceC22720vi8.o().equals(interfaceC22720vi82.o()) : interfaceC22720vi8 == interfaceC22720vi82;
        }
        if (Double.isNaN(interfaceC22720vi8.k().doubleValue()) || Double.isNaN(interfaceC22720vi82.k().doubleValue())) {
            return false;
        }
        return interfaceC22720vi8.k().equals(interfaceC22720vi82.k());
    }
}
