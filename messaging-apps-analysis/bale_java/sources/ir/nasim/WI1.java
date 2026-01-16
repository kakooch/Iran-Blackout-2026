package ir.nasim;

import java.util.List;

/* loaded from: classes8.dex */
public final class WI1 {
    private final TI1 a;
    private final InterfaceC6692Oo4 b;
    private final InterfaceC12795fB1 c;
    private final C7029Py7 d;
    private final C10938cS7 e;
    private final AbstractC7310Re0 f;
    private final InterfaceC12258eJ1 g;
    private final C16264ky7 h;
    private final C21732u24 i;

    public WI1(TI1 ti1, InterfaceC6692Oo4 interfaceC6692Oo4, InterfaceC12795fB1 interfaceC12795fB1, C7029Py7 c7029Py7, C10938cS7 c10938cS7, AbstractC7310Re0 abstractC7310Re0, InterfaceC12258eJ1 interfaceC12258eJ1, C16264ky7 c16264ky7, List list) {
        String strA;
        AbstractC13042fc3.i(ti1, "components");
        AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
        AbstractC13042fc3.i(interfaceC12795fB1, "containingDeclaration");
        AbstractC13042fc3.i(c7029Py7, "typeTable");
        AbstractC13042fc3.i(c10938cS7, "versionRequirementTable");
        AbstractC13042fc3.i(abstractC7310Re0, "metadataVersion");
        AbstractC13042fc3.i(list, "typeParameters");
        this.a = ti1;
        this.b = interfaceC6692Oo4;
        this.c = interfaceC12795fB1;
        this.d = c7029Py7;
        this.e = c10938cS7;
        this.f = abstractC7310Re0;
        this.g = interfaceC12258eJ1;
        this.h = new C16264ky7(this, c16264ky7, list, "Deserializer for \"" + interfaceC12795fB1.getName() + '\"', (interfaceC12258eJ1 == null || (strA = interfaceC12258eJ1.a()) == null) ? "[container not found]" : strA, false, 32, null);
        this.i = new C21732u24(this);
    }

    public static /* synthetic */ WI1 b(WI1 wi1, InterfaceC12795fB1 interfaceC12795fB1, List list, InterfaceC6692Oo4 interfaceC6692Oo4, C7029Py7 c7029Py7, C10938cS7 c10938cS7, AbstractC7310Re0 abstractC7310Re0, int i, Object obj) {
        if ((i & 4) != 0) {
            interfaceC6692Oo4 = wi1.b;
        }
        InterfaceC6692Oo4 interfaceC6692Oo42 = interfaceC6692Oo4;
        if ((i & 8) != 0) {
            c7029Py7 = wi1.d;
        }
        C7029Py7 c7029Py72 = c7029Py7;
        if ((i & 16) != 0) {
            c10938cS7 = wi1.e;
        }
        C10938cS7 c10938cS72 = c10938cS7;
        if ((i & 32) != 0) {
            abstractC7310Re0 = wi1.f;
        }
        return wi1.a(interfaceC12795fB1, list, interfaceC6692Oo42, c7029Py72, c10938cS72, abstractC7310Re0);
    }

    public final WI1 a(InterfaceC12795fB1 interfaceC12795fB1, List list, InterfaceC6692Oo4 interfaceC6692Oo4, C7029Py7 c7029Py7, C10938cS7 c10938cS7, AbstractC7310Re0 abstractC7310Re0) {
        AbstractC13042fc3.i(interfaceC12795fB1, "descriptor");
        AbstractC13042fc3.i(list, "typeParameterProtos");
        AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
        AbstractC13042fc3.i(c7029Py7, "typeTable");
        C10938cS7 c10938cS72 = c10938cS7;
        AbstractC13042fc3.i(c10938cS72, "versionRequirementTable");
        AbstractC13042fc3.i(abstractC7310Re0, "metadataVersion");
        TI1 ti1 = this.a;
        if (!AbstractC11702dS7.b(abstractC7310Re0)) {
            c10938cS72 = this.e;
        }
        return new WI1(ti1, interfaceC6692Oo4, interfaceC12795fB1, c7029Py7, c10938cS72, abstractC7310Re0, this.g, this.h, list);
    }

    public final TI1 c() {
        return this.a;
    }

    public final InterfaceC12258eJ1 d() {
        return this.g;
    }

    public final InterfaceC12795fB1 e() {
        return this.c;
    }

    public final C21732u24 f() {
        return this.i;
    }

    public final InterfaceC6692Oo4 g() {
        return this.b;
    }

    public final ON6 h() {
        return this.a.u();
    }

    public final C16264ky7 i() {
        return this.h;
    }

    public final C7029Py7 j() {
        return this.d;
    }

    public final C10938cS7 k() {
        return this.e;
    }
}
