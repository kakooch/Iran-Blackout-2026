package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.lifecycle.j;

/* renamed from: ir.nasim.Lq2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC5976Lq2 {

    /* renamed from: ir.nasim.Lq2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ androidx.lifecycle.j d;
        final /* synthetic */ j.b e;
        final /* synthetic */ InterfaceC11938do1 f;
        final /* synthetic */ InterfaceC4557Fq2 g;

        /* renamed from: ir.nasim.Lq2$a$a, reason: collision with other inner class name */
        static final class C0489a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC11938do1 c;
            final /* synthetic */ InterfaceC4557Fq2 d;
            final /* synthetic */ InterfaceC14415hs5 e;

            /* renamed from: ir.nasim.Lq2$a$a$a, reason: collision with other inner class name */
            static final class C0490a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC14415hs5 a;

                C0490a(InterfaceC14415hs5 interfaceC14415hs5) {
                    this.a = interfaceC14415hs5;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                public final Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    this.a.setValue(obj);
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.Lq2$a$a$b */
            static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC4557Fq2 c;
                final /* synthetic */ InterfaceC14415hs5 d;

                /* renamed from: ir.nasim.Lq2$a$a$b$a, reason: collision with other inner class name */
                static final class C0491a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC14415hs5 a;

                    C0491a(InterfaceC14415hs5 interfaceC14415hs5) {
                        this.a = interfaceC14415hs5;
                    }

                    @Override // ir.nasim.InterfaceC4806Gq2
                    public final Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        this.a.setValue(obj);
                        return C19938rB7.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC4557Fq2;
                    this.d = interfaceC14415hs5;
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
                        InterfaceC4557Fq2 interfaceC4557Fq2 = this.c;
                        C0491a c0491a = new C0491a(this.d);
                        this.b = 1;
                        if (interfaceC4557Fq2.b(c0491a, this) == objE) {
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
                    return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0489a(InterfaceC11938do1 interfaceC11938do1, InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC11938do1;
                this.d = interfaceC4557Fq2;
                this.e = interfaceC14415hs5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0489a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    if (AbstractC13042fc3.d(this.c, C18712p72.a)) {
                        InterfaceC4557Fq2 interfaceC4557Fq2 = this.d;
                        C0490a c0490a = new C0490a(this.e);
                        this.b = 1;
                        if (interfaceC4557Fq2.b(c0490a, this) == objE) {
                            return objE;
                        }
                    } else {
                        InterfaceC11938do1 interfaceC11938do1 = this.c;
                        b bVar = new b(this.d, this.e, null);
                        this.b = 2;
                        if (AbstractC9323Zl0.g(interfaceC11938do1, bVar, this) == objE) {
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
                return ((C0489a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(androidx.lifecycle.j jVar, j.b bVar, InterfaceC11938do1 interfaceC11938do1, InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = jVar;
            this.e = bVar;
            this.f = interfaceC11938do1;
            this.g = interfaceC4557Fq2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, this.e, this.f, this.g, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC14415hs5 interfaceC14415hs5 = (InterfaceC14415hs5) this.c;
                androidx.lifecycle.j jVar = this.d;
                j.b bVar = this.e;
                C0489a c0489a = new C0489a(this.f, this.g, interfaceC14415hs5, null);
                this.b = 1;
                if (androidx.lifecycle.w.a(jVar, bVar, c0489a, this) == objE) {
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
        public final Object invoke(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC14415hs5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final InterfaceC9664aL6 a(InterfaceC4557Fq2 interfaceC4557Fq2, Object obj, androidx.lifecycle.j jVar, j.b bVar, InterfaceC11938do1 interfaceC11938do1, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        if ((i2 & 4) != 0) {
            bVar = j.b.STARTED;
        }
        j.b bVar2 = bVar;
        if ((i2 & 8) != 0) {
            interfaceC11938do1 = C18712p72.a;
        }
        InterfaceC11938do1 interfaceC11938do12 = interfaceC11938do1;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1977777920, i, -1, "androidx.lifecycle.compose.collectAsStateWithLifecycle (FlowExt.kt:169)");
        }
        Object[] objArr = {interfaceC4557Fq2, jVar, bVar2, interfaceC11938do12};
        boolean zD = interfaceC22053ub1.D(jVar) | ((((i & 7168) ^ SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) > 2048 && interfaceC22053ub1.V(bVar2)) || (i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 2048) | interfaceC22053ub1.D(interfaceC11938do12) | interfaceC22053ub1.D(interfaceC4557Fq2);
        Object objB = interfaceC22053ub1.B();
        if (zD || objB == InterfaceC22053ub1.a.a()) {
            objB = new a(jVar, bVar2, interfaceC11938do12, interfaceC4557Fq2, null);
            interfaceC22053ub1.s(objB);
        }
        int i3 = i >> 3;
        InterfaceC9664aL6 interfaceC9664aL6O = AbstractC10222bH6.o(obj, objArr, (InterfaceC14603iB2) objB, interfaceC22053ub1, (i3 & 14) | (i3 & 8));
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC9664aL6O;
    }

    public static final InterfaceC9664aL6 b(InterfaceC4557Fq2 interfaceC4557Fq2, Object obj, InterfaceC18633oz3 interfaceC18633oz3, j.b bVar, InterfaceC11938do1 interfaceC11938do1, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        if ((i2 & 2) != 0) {
            interfaceC18633oz3 = (InterfaceC18633oz3) interfaceC22053ub1.H(UG3.a());
        }
        if ((i2 & 4) != 0) {
            bVar = j.b.STARTED;
        }
        j.b bVar2 = bVar;
        if ((i2 & 8) != 0) {
            interfaceC11938do1 = C18712p72.a;
        }
        InterfaceC11938do1 interfaceC11938do12 = interfaceC11938do1;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1485997211, i, -1, "androidx.lifecycle.compose.collectAsStateWithLifecycle (FlowExt.kt:133)");
        }
        InterfaceC9664aL6 interfaceC9664aL6A = a(interfaceC4557Fq2, obj, interfaceC18633oz3.getLifecycle(), bVar2, interfaceC11938do12, interfaceC22053ub1, (i & 14) | (((i >> 3) & 8) << 3) | (i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i & 7168) | (57344 & i), 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC9664aL6A;
    }

    public static final InterfaceC9664aL6 c(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC18633oz3 interfaceC18633oz3, j.b bVar, InterfaceC11938do1 interfaceC11938do1, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        if ((i2 & 1) != 0) {
            interfaceC18633oz3 = (InterfaceC18633oz3) interfaceC22053ub1.H(UG3.a());
        }
        if ((i2 & 2) != 0) {
            bVar = j.b.STARTED;
        }
        j.b bVar2 = bVar;
        if ((i2 & 4) != 0) {
            interfaceC11938do1 = C18712p72.a;
        }
        InterfaceC11938do1 interfaceC11938do12 = interfaceC11938do1;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(743249048, i, -1, "androidx.lifecycle.compose.collectAsStateWithLifecycle (FlowExt.kt:60)");
        }
        Object value = interfaceC10258bL6.getValue();
        androidx.lifecycle.j lifecycle = interfaceC18633oz3.getLifecycle();
        int i3 = i << 3;
        InterfaceC9664aL6 interfaceC9664aL6A = a(interfaceC10258bL6, value, lifecycle, bVar2, interfaceC11938do12, interfaceC22053ub1, (i & 14) | (i3 & 7168) | (i3 & 57344), 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC9664aL6A;
    }
}
