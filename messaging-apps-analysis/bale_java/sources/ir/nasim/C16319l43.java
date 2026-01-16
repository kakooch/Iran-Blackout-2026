package ir.nasim;

/* renamed from: ir.nasim.l43, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C16319l43 implements InterfaceC10239bJ5, InterfaceC6446No7 {
    private final InterfaceC21331tU0 a;
    private final C16319l43 b;
    private final InterfaceC21331tU0 c;

    public C16319l43(InterfaceC21331tU0 interfaceC21331tU0, C16319l43 c16319l43) {
        AbstractC13042fc3.i(interfaceC21331tU0, "classDescriptor");
        this.a = interfaceC21331tU0;
        this.b = c16319l43 == null ? this : c16319l43;
        this.c = interfaceC21331tU0;
    }

    @Override // ir.nasim.InterfaceC10239bJ5
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public XC6 getType() {
        XC6 xc6P = this.a.p();
        AbstractC13042fc3.h(xc6P, "classDescriptor.defaultType");
        return xc6P;
    }

    public boolean equals(Object obj) {
        InterfaceC21331tU0 interfaceC21331tU0 = this.a;
        C16319l43 c16319l43 = obj instanceof C16319l43 ? (C16319l43) obj : null;
        return AbstractC13042fc3.d(interfaceC21331tU0, c16319l43 != null ? c16319l43.a : null);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // ir.nasim.InterfaceC6446No7
    public final InterfaceC21331tU0 s() {
        return this.a;
    }

    public String toString() {
        return "Class{" + getType() + '}';
    }
}
