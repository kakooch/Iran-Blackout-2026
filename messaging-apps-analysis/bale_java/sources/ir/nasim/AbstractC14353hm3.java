package ir.nasim;

/* renamed from: ir.nasim.hm3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC14353hm3 {
    public static final Object a(InterfaceC11299cm3 interfaceC11299cm3, Object obj) {
        AbstractC13042fc3.i(interfaceC11299cm3, "<this>");
        if (interfaceC11299cm3.k(obj)) {
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
            return obj;
        }
        throw new ClassCastException("Value cannot be cast to " + interfaceC11299cm3.n());
    }

    public static final Object b(InterfaceC11299cm3 interfaceC11299cm3, Object obj) {
        AbstractC13042fc3.i(interfaceC11299cm3, "<this>");
        if (!interfaceC11299cm3.k(obj)) {
            return null;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.safeCast");
        return obj;
    }
}
