package ir.nasim;

import ir.nasim.PJ6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: ir.nasim.Cf2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C3756Cf2 {
    public static final C3756Cf2 a;
    private static final HashMap b;

    static {
        C3756Cf2 c3756Cf2 = new C3756Cf2();
        a = c3756Cf2;
        b = new HashMap();
        c3756Cf2.c(PJ6.a.Y, c3756Cf2.a("java.util.ArrayList", "java.util.LinkedList"));
        c3756Cf2.c(PJ6.a.a0, c3756Cf2.a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        c3756Cf2.c(PJ6.a.b0, c3756Cf2.a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        c3756Cf2.c(new C9424Zw2("java.util.function.Function"), c3756Cf2.a("java.util.function.UnaryOperator"));
        c3756Cf2.c(new C9424Zw2("java.util.function.BiFunction"), c3756Cf2.a("java.util.function.BinaryOperator"));
    }

    private C3756Cf2() {
    }

    private final List a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(new C9424Zw2(str));
        }
        return arrayList;
    }

    private final void c(C9424Zw2 c9424Zw2, List list) {
        HashMap map = b;
        for (Object obj : list) {
            map.put(obj, c9424Zw2);
        }
    }

    public final C9424Zw2 b(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "classFqName");
        return (C9424Zw2) b.get(c9424Zw2);
    }
}
