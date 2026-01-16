package ir.nasim;

import ir.nasim.AbstractC13460gG3;

/* renamed from: ir.nasim.tx3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC21683tx3 {
    private static final AbstractC13460gG3.c a;
    private static final C14653iG3 b;

    /* renamed from: ir.nasim.tx3$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC11938do1 c;
        final /* synthetic */ C20996sx3 d;

        /* renamed from: ir.nasim.tx3$a$a, reason: collision with other inner class name */
        static final class C1620a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C20996sx3 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1620a(C20996sx3 c20996sx3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c20996sx3;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1620a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C20996sx3 c20996sx3 = this.c;
                    this.b = 1;
                    if (c20996sx3.e(this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1620a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC11938do1 interfaceC11938do1, C20996sx3 c20996sx3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC11938do1;
            this.d = c20996sx3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (AbstractC13042fc3.d(this.c, C18712p72.a)) {
                    C20996sx3 c20996sx3 = this.d;
                    this.b = 1;
                    if (c20996sx3.e(this) == objE) {
                        return objE;
                    }
                } else {
                    InterfaceC11938do1 interfaceC11938do1 = this.c;
                    C1620a c1620a = new C1620a(this.d, null);
                    this.b = 2;
                    if (AbstractC9323Zl0.g(interfaceC11938do1, c1620a, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tx3$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC11938do1 c;
        final /* synthetic */ C20996sx3 d;

        /* renamed from: ir.nasim.tx3$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C20996sx3 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C20996sx3 c20996sx3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c20996sx3;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C20996sx3 c20996sx3 = this.c;
                    this.b = 1;
                    if (c20996sx3.d(this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC11938do1 interfaceC11938do1, C20996sx3 c20996sx3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC11938do1;
            this.d = c20996sx3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (AbstractC13042fc3.d(this.c, C18712p72.a)) {
                    C20996sx3 c20996sx3 = this.d;
                    this.b = 1;
                    if (c20996sx3.d(this) == objE) {
                        return objE;
                    }
                } else {
                    InterfaceC11938do1 interfaceC11938do1 = this.c;
                    a aVar = new a(this.d, null);
                    this.b = 2;
                    if (AbstractC9323Zl0.g(interfaceC11938do1, aVar, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static {
        AbstractC13460gG3.c cVar = new AbstractC13460gG3.c(false);
        a = cVar;
        b = new C14653iG3(AbstractC13460gG3.b.b, cVar, cVar);
    }

    public static final C20996sx3 b(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC11938do1 interfaceC11938do1, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        AbstractC13042fc3.i(interfaceC4557Fq2, "<this>");
        interfaceC22053ub1.A(388053246);
        if ((i2 & 1) != 0) {
            interfaceC11938do1 = C18712p72.a;
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(388053246, i, -1, "androidx.paging.compose.collectAsLazyPagingItems (LazyPagingItems.kt:203)");
        }
        interfaceC22053ub1.A(1046463091);
        boolean zV = interfaceC22053ub1.V(interfaceC4557Fq2);
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            objB = new C20996sx3(interfaceC4557Fq2);
            interfaceC22053ub1.s(objB);
        }
        C20996sx3 c20996sx3 = (C20996sx3) objB;
        interfaceC22053ub1.U();
        interfaceC22053ub1.A(1046463169);
        boolean zD = interfaceC22053ub1.D(interfaceC11938do1) | interfaceC22053ub1.D(c20996sx3);
        Object objB2 = interfaceC22053ub1.B();
        if (zD || objB2 == InterfaceC22053ub1.a.a()) {
            objB2 = new a(interfaceC11938do1, c20996sx3, null);
            interfaceC22053ub1.s(objB2);
        }
        interfaceC22053ub1.U();
        AbstractC10721c52.e(c20996sx3, (InterfaceC14603iB2) objB2, interfaceC22053ub1, 0);
        interfaceC22053ub1.A(1046463438);
        boolean zD2 = interfaceC22053ub1.D(interfaceC11938do1) | interfaceC22053ub1.D(c20996sx3);
        Object objB3 = interfaceC22053ub1.B();
        if (zD2 || objB3 == InterfaceC22053ub1.a.a()) {
            objB3 = new b(interfaceC11938do1, c20996sx3, null);
            interfaceC22053ub1.s(objB3);
        }
        interfaceC22053ub1.U();
        AbstractC10721c52.e(c20996sx3, (InterfaceC14603iB2) objB3, interfaceC22053ub1, 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.U();
        return c20996sx3;
    }
}
