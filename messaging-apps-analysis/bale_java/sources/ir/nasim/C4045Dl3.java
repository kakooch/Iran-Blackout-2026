package ir.nasim;

import ir.nasim.InterfaceC12269eK3;
import ir.nasim.InterfaceC6450Np2;
import ir.nasim.LG3;
import java.io.InputStream;

/* renamed from: ir.nasim.Dl3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C4045Dl3 extends O0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C4045Dl3(ON6 on6, InterfaceC20347rr3 interfaceC20347rr3, InterfaceC8507Wg4 interfaceC8507Wg4, C21830uC4 c21830uC4, InterfaceC15427ja interfaceC15427ja, InterfaceC8256Ve5 interfaceC8256Ve5, VI1 vi1, InterfaceC14434hu4 interfaceC14434hu4, InterfaceC10419ba6 interfaceC10419ba6) {
        super(on6, interfaceC20347rr3, interfaceC8507Wg4);
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(interfaceC20347rr3, "finder");
        AbstractC13042fc3.i(interfaceC8507Wg4, "moduleDescriptor");
        AbstractC13042fc3.i(c21830uC4, "notFoundClasses");
        AbstractC13042fc3.i(interfaceC15427ja, "additionalClassPartsProvider");
        AbstractC13042fc3.i(interfaceC8256Ve5, "platformDependentDeclarationFilter");
        AbstractC13042fc3.i(vi1, "deserializationConfiguration");
        AbstractC13042fc3.i(interfaceC14434hu4, "kotlinTypeChecker");
        AbstractC13042fc3.i(interfaceC10419ba6, "samConversionResolver");
        C10235bJ1 c10235bJ1 = new C10235bJ1(this);
        C12530em0 c12530em0 = C12530em0.n;
        C18582ou c18582ou = new C18582ou(interfaceC8507Wg4, c21830uC4, c12530em0);
        LG3.a aVar = LG3.a.a;
        InterfaceC11005ca2 interfaceC11005ca2 = InterfaceC11005ca2.a;
        AbstractC13042fc3.h(interfaceC11005ca2, "DO_NOTHING");
        h(new TI1(on6, interfaceC8507Wg4, vi1, c10235bJ1, c18582ou, this, aVar, interfaceC11005ca2, InterfaceC12269eK3.a.a, InterfaceC6450Np2.a.a, AbstractC10360bX0.p(new C11918dm0(on6, interfaceC8507Wg4), new C3338Al3(on6, interfaceC8507Wg4, null, 4, null)), c21830uC4, InterfaceC24529ym1.a.a(), interfaceC15427ja, interfaceC8256Ve5, c12530em0.e(), interfaceC14434hu4, interfaceC10419ba6, null, 262144, 0 == true ? 1 : 0));
    }

    @Override // ir.nasim.O0
    protected AbstractC14678iJ1 c(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        InputStream inputStreamC = e().c(c9424Zw2);
        if (inputStreamC == null) {
            return null;
        }
        return C15548jm0.n.a(c9424Zw2, g(), f(), inputStreamC, false);
    }
}
