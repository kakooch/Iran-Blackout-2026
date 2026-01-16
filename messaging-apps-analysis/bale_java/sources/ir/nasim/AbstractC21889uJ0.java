package ir.nasim;

/* renamed from: ir.nasim.uJ0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC21889uJ0 {
    public static final AbstractC20003rJ0 b(InterfaceC4557Fq2 interfaceC4557Fq2) {
        AbstractC20003rJ0 abstractC20003rJ0 = interfaceC4557Fq2 instanceof AbstractC20003rJ0 ? (AbstractC20003rJ0) interfaceC4557Fq2 : null;
        if (abstractC20003rJ0 == null) {
            return new C23665xJ0(interfaceC4557Fq2, null, 0, null, 14, null);
        }
        return abstractC20003rJ0;
    }

    public static final Object c(InterfaceC11938do1 interfaceC11938do1, Object obj, Object obj2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = AbstractC7173Qo7.c(interfaceC11938do1, obj2);
        try {
            Object objInvoke = ((InterfaceC14603iB2) AbstractC19810qy7.g(interfaceC14603iB2, 2)).invoke(obj, new EJ6(interfaceC20295rm1, interfaceC11938do1));
            AbstractC7173Qo7.a(interfaceC11938do1, objC);
            if (objInvoke == AbstractC14862ic3.e()) {
                WA1.c(interfaceC20295rm1);
            }
            return objInvoke;
        } catch (Throwable th) {
            AbstractC7173Qo7.a(interfaceC11938do1, objC);
            throw th;
        }
    }

    public static /* synthetic */ Object d(InterfaceC11938do1 interfaceC11938do1, Object obj, Object obj2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj3) {
        if ((i & 4) != 0) {
            obj2 = AbstractC7173Qo7.b(interfaceC11938do1);
        }
        return c(interfaceC11938do1, obj, obj2, interfaceC14603iB2, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC4806Gq2 e(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC11938do1 interfaceC11938do1) {
        return interfaceC4806Gq2 instanceof C7640So6 ? true : interfaceC4806Gq2 instanceof C19944rC4 ? interfaceC4806Gq2 : new C12192eB7(interfaceC4806Gq2, interfaceC11938do1);
    }
}
