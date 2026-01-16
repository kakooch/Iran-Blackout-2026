package j$.util;

import j$.wrappers.A0;
import j$.wrappers.C0;
import j$.wrappers.E0;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/* renamed from: j$.util.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
enum EnumC0107f implements Comparator, InterfaceC0106e {
    INSTANCE;

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return ((Comparable) obj).compareTo((Comparable) obj2);
    }

    @Override // java.util.Comparator
    public Comparator reversed() {
        return Comparator$CC.reverseOrder();
    }

    @Override // java.util.Comparator
    public Comparator thenComparing(Comparator comparator) {
        comparator.getClass();
        return new C0104c(this, comparator);
    }

    @Override // java.util.Comparator
    public Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
        j$.util.function.A a2 = A0.a(toDoubleFunction);
        a2.getClass();
        return AbstractC0102a.y(this, new C0105d(a2));
    }

    @Override // java.util.Comparator
    public Comparator thenComparingInt(ToIntFunction toIntFunction) {
        return AbstractC0102a.y(this, Comparator$CC.comparingInt(C0.a(toIntFunction)));
    }

    @Override // java.util.Comparator
    public Comparator thenComparingLong(ToLongFunction toLongFunction) {
        j$.util.function.B bA = E0.a(toLongFunction);
        bA.getClass();
        return AbstractC0102a.y(this, new C0105d(bA));
    }

    @Override // java.util.Comparator
    public Comparator thenComparing(Function function) {
        j$.util.function.Function functionA = j$.wrappers.L.a(function);
        functionA.getClass();
        return AbstractC0102a.y(this, new C0105d(functionA));
    }

    @Override // java.util.Comparator
    public Comparator thenComparing(Function function, Comparator comparator) {
        j$.util.function.Function functionA = j$.wrappers.L.a(function);
        functionA.getClass();
        comparator.getClass();
        return AbstractC0102a.y(this, new C0104c(comparator, functionA));
    }
}
