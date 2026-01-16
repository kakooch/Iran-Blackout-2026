package ir.nasim;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class F0 extends AbstractC12686f2 implements InterfaceC13882gy7 {
    private int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F0(ON6 on6) {
        super(on6);
        if (on6 == null) {
            r(0);
        }
        this.c = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void r(int r9) {
        /*
            r0 = 4
            r1 = 3
            r2 = 1
            if (r9 == r2) goto Lc
            if (r9 == r1) goto Lc
            if (r9 == r0) goto Lc
            java.lang.String r3 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto Le
        Lc:
            java.lang.String r3 = "@NotNull method %s.%s must not return null"
        Le:
            r4 = 2
            if (r9 == r2) goto L17
            if (r9 == r1) goto L17
            if (r9 == r0) goto L17
            r5 = r1
            goto L18
        L17:
            r5 = r4
        L18:
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor"
            r7 = 0
            if (r9 == r2) goto L2f
            if (r9 == r4) goto L2a
            if (r9 == r1) goto L2f
            if (r9 == r0) goto L2f
            java.lang.String r8 = "storageManager"
            r5[r7] = r8
            goto L31
        L2a:
            java.lang.String r8 = "descriptor"
            r5[r7] = r8
            goto L31
        L2f:
            r5[r7] = r6
        L31:
            if (r9 == r2) goto L3f
            if (r9 == r1) goto L3a
            if (r9 == r0) goto L3a
            r5[r2] = r6
            goto L43
        L3a:
            java.lang.String r6 = "getAdditionalNeighboursInSupertypeGraph"
            r5[r2] = r6
            goto L43
        L3f:
            java.lang.String r6 = "getBuiltIns"
            r5[r2] = r6
        L43:
            if (r9 == r2) goto L54
            if (r9 == r4) goto L50
            if (r9 == r1) goto L54
            if (r9 == r0) goto L54
            java.lang.String r6 = "<init>"
            r5[r4] = r6
            goto L54
        L50:
            java.lang.String r6 = "hasMeaningfulFqName"
            r5[r4] = r6
        L54:
            java.lang.String r3 = java.lang.String.format(r3, r5)
            if (r9 == r2) goto L64
            if (r9 == r1) goto L64
            if (r9 == r0) goto L64
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r3)
            goto L69
        L64:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>(r3)
        L69:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.F0.r(int):void");
    }

    private static boolean s(InterfaceC21331tU0 interfaceC21331tU0, InterfaceC21331tU0 interfaceC21331tU02) {
        if (!interfaceC21331tU0.getName().equals(interfaceC21331tU02.getName())) {
            return false;
        }
        InterfaceC12795fB1 interfaceC12795fB1B = interfaceC21331tU0.b();
        for (InterfaceC12795fB1 interfaceC12795fB1B2 = interfaceC21331tU02.b(); interfaceC12795fB1B != null && interfaceC12795fB1B2 != null; interfaceC12795fB1B2 = interfaceC12795fB1B2.b()) {
            if (interfaceC12795fB1B instanceof InterfaceC8507Wg4) {
                return interfaceC12795fB1B2 instanceof InterfaceC8507Wg4;
            }
            if (interfaceC12795fB1B2 instanceof InterfaceC8507Wg4) {
                return false;
            }
            if (interfaceC12795fB1B instanceof InterfaceC24340yS4) {
                return (interfaceC12795fB1B2 instanceof InterfaceC24340yS4) && ((InterfaceC24340yS4) interfaceC12795fB1B).e().equals(((InterfaceC24340yS4) interfaceC12795fB1B2).e());
            }
            if ((interfaceC12795fB1B2 instanceof InterfaceC24340yS4) || !interfaceC12795fB1B.getName().equals(interfaceC12795fB1B2.getName())) {
                return false;
            }
            interfaceC12795fB1B = interfaceC12795fB1B.b();
        }
        return true;
    }

    private static boolean u(MU0 mu0) {
        if (mu0 == null) {
            r(2);
        }
        return (AbstractC14230ha2.r(mu0) || OI1.E(mu0)) ? false : true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InterfaceC13882gy7) || obj.hashCode() != hashCode()) {
            return false;
        }
        InterfaceC13882gy7 interfaceC13882gy7 = (InterfaceC13882gy7) obj;
        if (interfaceC13882gy7.getParameters().size() != getParameters().size()) {
            return false;
        }
        InterfaceC21331tU0 interfaceC21331tU0T = t();
        MU0 mu0T = interfaceC13882gy7.t();
        if (u(interfaceC21331tU0T) && ((mu0T == null || u(mu0T)) && (mu0T instanceof InterfaceC21331tU0))) {
            return s(interfaceC21331tU0T, (InterfaceC21331tU0) mu0T);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        InterfaceC21331tU0 interfaceC21331tU0T = t();
        int iHashCode = u(interfaceC21331tU0T) ? OI1.m(interfaceC21331tU0T).hashCode() : System.identityHashCode(this);
        this.c = iHashCode;
        return iHashCode;
    }

    @Override // ir.nasim.AbstractC12686f2
    protected AbstractC4099Dr3 i() {
        if (AbstractC19738qr3.B0(t())) {
            return null;
        }
        return n().i();
    }

    @Override // ir.nasim.AbstractC12686f2
    protected Collection j(boolean z) {
        InterfaceC12795fB1 interfaceC12795fB1B = t().b();
        if (!(interfaceC12795fB1B instanceof InterfaceC21331tU0)) {
            List listEmptyList = Collections.emptyList();
            if (listEmptyList == null) {
                r(3);
            }
            return listEmptyList;
        }
        CE6 ce6 = new CE6();
        InterfaceC21331tU0 interfaceC21331tU0 = (InterfaceC21331tU0) interfaceC12795fB1B;
        ce6.add(interfaceC21331tU0.p());
        InterfaceC21331tU0 interfaceC21331tU0N0 = interfaceC21331tU0.n0();
        if (z && interfaceC21331tU0N0 != null) {
            ce6.add(interfaceC21331tU0N0.p());
        }
        return ce6;
    }

    @Override // ir.nasim.InterfaceC13882gy7
    public AbstractC19738qr3 n() {
        AbstractC19738qr3 abstractC19738qr3G = PI1.g(t());
        if (abstractC19738qr3G == null) {
            r(1);
        }
        return abstractC19738qr3G;
    }

    public abstract InterfaceC21331tU0 t();
}
