package ir.nasim;

import ir.nasim.InterfaceC19877r55;
import java.util.Collection;

/* renamed from: ir.nasim.Te2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC7783Te2 {
    public static final InterfaceC19877r55 a() {
        return AbstractC23708xN7.b();
    }

    public static final InterfaceC19877r55 b(Object... objArr) {
        AbstractC13042fc3.i(objArr, "elements");
        return AbstractC23708xN7.b().addAll((Collection) AbstractC9648aK.d(objArr));
    }

    public static final InterfaceC19877r55 c(InterfaceC19877r55 interfaceC19877r55, Iterable iterable) {
        AbstractC13042fc3.i(interfaceC19877r55, "<this>");
        AbstractC13042fc3.i(iterable, "elements");
        if (iterable instanceof Collection) {
            return interfaceC19877r55.addAll((Collection) iterable);
        }
        InterfaceC19877r55.a aVarM = interfaceC19877r55.m();
        AbstractC13610gX0.D(aVarM, iterable);
        return aVarM.a();
    }

    public static final InterfaceC13346g43 d(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        InterfaceC13346g43 interfaceC13346g43 = iterable instanceof InterfaceC13346g43 ? (InterfaceC13346g43) iterable : null;
        return interfaceC13346g43 == null ? e(iterable) : interfaceC13346g43;
    }

    public static final InterfaceC19877r55 e(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "<this>");
        InterfaceC19877r55 interfaceC19877r55 = iterable instanceof InterfaceC19877r55 ? (InterfaceC19877r55) iterable : null;
        if (interfaceC19877r55 != null) {
            return interfaceC19877r55;
        }
        InterfaceC19877r55.a aVar = iterable instanceof InterfaceC19877r55.a ? (InterfaceC19877r55.a) iterable : null;
        InterfaceC19877r55 interfaceC19877r55A = aVar != null ? aVar.a() : null;
        return interfaceC19877r55A == null ? c(a(), iterable) : interfaceC19877r55A;
    }
}
