package ir.nasim;

import java.util.Comparator;

/* loaded from: classes3.dex */
public abstract class UL4 implements Comparator {
    protected UL4() {
    }

    public static UL4 a(Comparator comparator) {
        return comparator instanceof UL4 ? (UL4) comparator : new C15095j01(comparator);
    }

    public static UL4 b() {
        return C6701Op4.a;
    }

    public UL4 c(InterfaceC15205jB2 interfaceC15205jB2) {
        return new C22182uo0(interfaceC15205jB2, this);
    }

    @Override // java.util.Comparator
    public abstract int compare(Object obj, Object obj2);

    public UL4 d() {
        return new C16(this);
    }
}
