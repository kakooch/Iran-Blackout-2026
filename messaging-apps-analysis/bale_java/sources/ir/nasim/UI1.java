package ir.nasim;

import ir.nasim.InterfaceC15427ja;
import ir.nasim.InterfaceC8256Ve5;
import ir.nasim.LG3;
import java.util.List;

/* loaded from: classes8.dex */
public final class UI1 {
    private final TI1 a;

    public UI1(ON6 on6, InterfaceC8507Wg4 interfaceC8507Wg4, VI1 vi1, C7574Sh3 c7574Sh3, C6593Oe0 c6593Oe0, C8641Wv3 c8641Wv3, C21830uC4 c21830uC4, InterfaceC11005ca2 interfaceC11005ca2, InterfaceC12269eK3 interfaceC12269eK3, InterfaceC24529ym1 interfaceC24529ym1, InterfaceC14434hu4 interfaceC14434hu4) {
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(interfaceC8507Wg4, "moduleDescriptor");
        AbstractC13042fc3.i(vi1, "configuration");
        AbstractC13042fc3.i(c7574Sh3, "classDataFinder");
        AbstractC13042fc3.i(c6593Oe0, "annotationAndConstantLoader");
        AbstractC13042fc3.i(c8641Wv3, "packageFragmentProvider");
        AbstractC13042fc3.i(c21830uC4, "notFoundClasses");
        AbstractC13042fc3.i(interfaceC11005ca2, "errorReporter");
        AbstractC13042fc3.i(interfaceC12269eK3, "lookupTracker");
        AbstractC13042fc3.i(interfaceC24529ym1, "contractDeserializer");
        AbstractC13042fc3.i(interfaceC14434hu4, "kotlinTypeChecker");
        AbstractC19738qr3 abstractC19738qr3N = interfaceC8507Wg4.n();
        C3577Bl3 c3577Bl3 = abstractC19738qr3N instanceof C3577Bl3 ? (C3577Bl3) abstractC19738qr3N : null;
        LG3.a aVar = LG3.a.a;
        C15511ji3 c15511ji3 = C15511ji3.a;
        List listM = AbstractC10360bX0.m();
        InterfaceC15427ja interfaceC15427jaP0 = c3577Bl3 == null ? null : c3577Bl3.P0();
        InterfaceC15427ja interfaceC15427ja = interfaceC15427jaP0 == null ? InterfaceC15427ja.a.a : interfaceC15427jaP0;
        InterfaceC8256Ve5 interfaceC8256Ve5P0 = c3577Bl3 != null ? c3577Bl3.P0() : null;
        this.a = new TI1(on6, interfaceC8507Wg4, vi1, c7574Sh3, c6593Oe0, c8641Wv3, aVar, interfaceC11005ca2, interfaceC12269eK3, c15511ji3, listM, c21830uC4, interfaceC24529ym1, interfaceC15427ja, interfaceC8256Ve5P0 == null ? InterfaceC8256Ve5.b.a : interfaceC8256Ve5P0, C8083Ul3.a.a(), interfaceC14434hu4, new C11009ca6(on6, AbstractC10360bX0.m()), null, 262144, null);
    }

    public final TI1 a() {
        return this.a;
    }
}
