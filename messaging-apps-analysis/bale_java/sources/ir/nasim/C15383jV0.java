package ir.nasim;

import ir.nasim.InterfaceC22011uW5;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* renamed from: ir.nasim.jV0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C15383jV0 extends AbstractC3985De6 {
    public static final C15383jV0 a = new C15383jV0();

    private C15383jV0() {
    }

    private static final void b(InterfaceC21331tU0 interfaceC21331tU0, LinkedHashSet linkedHashSet, W24 w24, boolean z) {
        for (InterfaceC12795fB1 interfaceC12795fB1 : InterfaceC22011uW5.a.a(w24, C24841zI1.t, null, 2, null)) {
            if (interfaceC12795fB1 instanceof InterfaceC21331tU0) {
                InterfaceC21331tU0 interfaceC21331tU02 = (InterfaceC21331tU0) interfaceC12795fB1;
                if (OI1.z(interfaceC21331tU02, interfaceC21331tU0)) {
                    linkedHashSet.add(interfaceC12795fB1);
                }
                if (z) {
                    W24 w24U = interfaceC21331tU02.U();
                    AbstractC13042fc3.h(w24U, "descriptor.unsubstitutedInnerClassesScope");
                    b(interfaceC21331tU0, linkedHashSet, w24U, z);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    public Collection a(InterfaceC21331tU0 interfaceC21331tU0, boolean z) {
        InterfaceC12795fB1 next;
        InterfaceC12795fB1 interfaceC12795fB1B;
        AbstractC13042fc3.i(interfaceC21331tU0, "sealedClass");
        if (interfaceC21331tU0.r() != EnumC11067cg4.SEALED) {
            return AbstractC10360bX0.m();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z) {
            Iterator it = PI1.m(interfaceC21331tU0).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = 0;
                    break;
                }
                next = it.next();
                if (((InterfaceC12795fB1) next) instanceof InterfaceC24340yS4) {
                    break;
                }
            }
            interfaceC12795fB1B = next;
        } else {
            interfaceC12795fB1B = interfaceC21331tU0.b();
        }
        if (interfaceC12795fB1B instanceof InterfaceC24340yS4) {
            b(interfaceC21331tU0, linkedHashSet, ((InterfaceC24340yS4) interfaceC12795fB1B).o(), z);
        }
        W24 w24U = interfaceC21331tU0.U();
        AbstractC13042fc3.h(w24U, "sealedClass.unsubstitutedInnerClassesScope");
        b(interfaceC21331tU0, linkedHashSet, w24U, true);
        return linkedHashSet;
    }
}
