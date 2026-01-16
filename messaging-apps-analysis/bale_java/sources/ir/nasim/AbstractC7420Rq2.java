package ir.nasim;

import ir.nasim.LB2;

/* renamed from: ir.nasim.Rq2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
abstract /* synthetic */ class AbstractC7420Rq2 {
    public static final InterfaceC4557Fq2 a(InterfaceC4557Fq2 interfaceC4557Fq2, int i, EnumC6162Ml0 enumC6162Ml0) {
        if (i < 0 && i != -2 && i != -1) {
            throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i).toString());
        }
        if (i == -1 && enumC6162Ml0 != EnumC6162Ml0.SUSPEND) {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        if (i == -1) {
            enumC6162Ml0 = EnumC6162Ml0.DROP_OLDEST;
            i = 0;
        }
        int i2 = i;
        EnumC6162Ml0 enumC6162Ml02 = enumC6162Ml0;
        if (interfaceC4557Fq2 instanceof LB2) {
            return LB2.a.a((LB2) interfaceC4557Fq2, null, i2, enumC6162Ml02, 1, null);
        }
        return new C23665xJ0(interfaceC4557Fq2, null, i2, enumC6162Ml02, 2, null);
    }

    public static /* synthetic */ InterfaceC4557Fq2 b(InterfaceC4557Fq2 interfaceC4557Fq2, int i, EnumC6162Ml0 enumC6162Ml0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -2;
        }
        if ((i2 & 2) != 0) {
            enumC6162Ml0 = EnumC6162Ml0.SUSPEND;
        }
        return AbstractC6459Nq2.d(interfaceC4557Fq2, i, enumC6162Ml0);
    }

    public static final InterfaceC4557Fq2 c(InterfaceC4557Fq2 interfaceC4557Fq2) {
        return interfaceC4557Fq2 instanceof LE0 ? interfaceC4557Fq2 : new ME0(interfaceC4557Fq2);
    }

    private static final void d(InterfaceC11938do1 interfaceC11938do1) {
        if (interfaceC11938do1.a(InterfaceC13730gj3.n0) == null) {
            return;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + interfaceC11938do1).toString());
    }

    public static final InterfaceC4557Fq2 e(InterfaceC4557Fq2 interfaceC4557Fq2) {
        return b(interfaceC4557Fq2, -1, null, 2, null);
    }

    public static final InterfaceC4557Fq2 f(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC11938do1 interfaceC11938do1) {
        d(interfaceC11938do1);
        if (AbstractC13042fc3.d(interfaceC11938do1, C18712p72.a)) {
            return interfaceC4557Fq2;
        }
        if (interfaceC4557Fq2 instanceof LB2) {
            return LB2.a.a((LB2) interfaceC4557Fq2, interfaceC11938do1, 0, null, 6, null);
        }
        return new C23665xJ0(interfaceC4557Fq2, interfaceC11938do1, 0, null, 12, null);
    }
}
