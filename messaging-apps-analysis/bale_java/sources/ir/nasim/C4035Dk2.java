package ir.nasim;

import ir.nasim.InterfaceC8487We2;

/* renamed from: ir.nasim.Dk2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C4035Dk2 implements InterfaceC8487We2 {
    @Override // ir.nasim.InterfaceC8487We2
    public InterfaceC8487We2.b a(InterfaceC14592iA0 interfaceC14592iA0, InterfaceC14592iA0 interfaceC14592iA02, InterfaceC21331tU0 interfaceC21331tU0) {
        AbstractC13042fc3.i(interfaceC14592iA0, "superDescriptor");
        AbstractC13042fc3.i(interfaceC14592iA02, "subDescriptor");
        if (!(interfaceC14592iA02 instanceof InterfaceC20989sw5) || !(interfaceC14592iA0 instanceof InterfaceC20989sw5)) {
            return InterfaceC8487We2.b.UNKNOWN;
        }
        InterfaceC20989sw5 interfaceC20989sw5 = (InterfaceC20989sw5) interfaceC14592iA02;
        InterfaceC20989sw5 interfaceC20989sw52 = (InterfaceC20989sw5) interfaceC14592iA0;
        return !AbstractC13042fc3.d(interfaceC20989sw5.getName(), interfaceC20989sw52.getName()) ? InterfaceC8487We2.b.UNKNOWN : (AbstractC12493ei3.a(interfaceC20989sw5) && AbstractC12493ei3.a(interfaceC20989sw52)) ? InterfaceC8487We2.b.OVERRIDABLE : (AbstractC12493ei3.a(interfaceC20989sw5) || AbstractC12493ei3.a(interfaceC20989sw52)) ? InterfaceC8487We2.b.INCOMPATIBLE : InterfaceC8487We2.b.UNKNOWN;
    }

    @Override // ir.nasim.InterfaceC8487We2
    public InterfaceC8487We2.a b() {
        return InterfaceC8487We2.a.BOTH;
    }
}
