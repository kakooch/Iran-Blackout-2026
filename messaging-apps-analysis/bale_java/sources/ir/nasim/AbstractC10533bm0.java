package ir.nasim;

import ir.nasim.InterfaceC22753vm1;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.bm0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract /* synthetic */ class AbstractC10533bm0 {
    public static final InterfaceC24823zG1 a(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC11938do1 interfaceC11938do1, EnumC23959xo1 enumC23959xo1, InterfaceC14603iB2 interfaceC14603iB2) {
        InterfaceC11938do1 interfaceC11938do1E = AbstractC12551eo1.e(interfaceC20315ro1, interfaceC11938do1);
        AG1 c12032dv3 = enumC23959xo1.p() ? new C12032dv3(interfaceC11938do1E, interfaceC14603iB2) : new AG1(interfaceC11938do1E, true);
        c12032dv3.g1(enumC23959xo1, c12032dv3, interfaceC14603iB2);
        return c12032dv3;
    }

    public static /* synthetic */ InterfaceC24823zG1 b(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC11938do1 interfaceC11938do1, EnumC23959xo1 enumC23959xo1, InterfaceC14603iB2 interfaceC14603iB2, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC11938do1 = C18712p72.a;
        }
        if ((i & 2) != 0) {
            enumC23959xo1 = EnumC23959xo1.DEFAULT;
        }
        return AbstractC9323Zl0.a(interfaceC20315ro1, interfaceC11938do1, enumC23959xo1, interfaceC14603iB2);
    }

    public static final InterfaceC13730gj3 c(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC11938do1 interfaceC11938do1, EnumC23959xo1 enumC23959xo1, InterfaceC14603iB2 interfaceC14603iB2) {
        InterfaceC11938do1 interfaceC11938do1E = AbstractC12551eo1.e(interfaceC20315ro1, interfaceC11938do1);
        JJ6 c25233zx3 = enumC23959xo1.p() ? new C25233zx3(interfaceC11938do1E, interfaceC14603iB2) : new JJ6(interfaceC11938do1E, true);
        c25233zx3.g1(enumC23959xo1, c25233zx3, interfaceC14603iB2);
        return c25233zx3;
    }

    public static /* synthetic */ InterfaceC13730gj3 d(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC11938do1 interfaceC11938do1, EnumC23959xo1 enumC23959xo1, InterfaceC14603iB2 interfaceC14603iB2, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC11938do1 = C18712p72.a;
        }
        if ((i & 2) != 0) {
            enumC23959xo1 = EnumC23959xo1.DEFAULT;
        }
        return AbstractC9323Zl0.c(interfaceC20315ro1, interfaceC11938do1, enumC23959xo1, interfaceC14603iB2);
    }

    public static final Object e(InterfaceC11938do1 interfaceC11938do1, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) throws Throwable {
        Object objH1;
        InterfaceC11938do1 context = interfaceC20295rm1.getContext();
        InterfaceC11938do1 interfaceC11938do1D = AbstractC12551eo1.d(context, interfaceC11938do1);
        AbstractC19067pj3.n(interfaceC11938do1D);
        if (interfaceC11938do1D == context) {
            C18419od6 c18419od6 = new C18419od6(interfaceC11938do1D, interfaceC20295rm1);
            objH1 = AbstractC13419gB7.b(c18419od6, c18419od6, interfaceC14603iB2);
        } else {
            InterfaceC22753vm1.b bVar = InterfaceC22753vm1.g0;
            if (AbstractC13042fc3.d(interfaceC11938do1D.a(bVar), context.a(bVar))) {
                C12801fB7 c12801fB7 = new C12801fB7(interfaceC11938do1D, interfaceC20295rm1);
                InterfaceC11938do1 context2 = c12801fB7.getContext();
                Object objC = AbstractC7173Qo7.c(context2, null);
                try {
                    Object objB = AbstractC13419gB7.b(c12801fB7, c12801fB7, interfaceC14603iB2);
                    AbstractC7173Qo7.a(context2, objC);
                    objH1 = objB;
                } catch (Throwable th) {
                    AbstractC7173Qo7.a(context2, objC);
                    throw th;
                }
            } else {
                VU1 vu1 = new VU1(interfaceC11938do1D, interfaceC20295rm1);
                NE0.d(interfaceC14603iB2, vu1, vu1, null, 4, null);
                objH1 = vu1.h1();
            }
        }
        if (objH1 == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objH1;
    }
}
