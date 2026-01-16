package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.NK3;

/* renamed from: ir.nasim.dI5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC11610dI5 {

    /* renamed from: ir.nasim.dI5$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC10040ay6 d;

        /* renamed from: ir.nasim.dI5$a$a, reason: collision with other inner class name */
        static final class C1005a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC14415hs5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1005a(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC14415hs5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C1005a c1005a = new C1005a(this.d, interfaceC20295rm1);
                c1005a.c = obj;
                return c1005a;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x0053 A[RETURN] */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r7.b
                    r2 = 0
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L1f
                    if (r1 == r4) goto L1b
                    if (r1 != r3) goto L13
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L54
                L13:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L1b:
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L40
                L1f:
                    ir.nasim.AbstractC10685c16.b(r8)
                    java.lang.Object r8 = r7.c
                    ir.nasim.cJ7 r8 = (ir.nasim.C10857cJ7) r8
                    boolean r8 = r8.b()
                    if (r8 == 0) goto L54
                    ir.nasim.hs5 r8 = r7.d
                    java.lang.Boolean r1 = ir.nasim.AbstractC6392Nk0.a(r2)
                    r8.setValue(r1)
                    r7.b = r4
                    r5 = 100
                    java.lang.Object r8 = ir.nasim.HG1.b(r5, r7)
                    if (r8 != r0) goto L40
                    return r0
                L40:
                    ir.nasim.hs5 r8 = r7.d
                    java.lang.Boolean r1 = ir.nasim.AbstractC6392Nk0.a(r4)
                    r8.setValue(r1)
                    r7.b = r3
                    r3 = 3000(0xbb8, double:1.482E-320)
                    java.lang.Object r8 = ir.nasim.HG1.b(r3, r7)
                    if (r8 != r0) goto L54
                    return r0
                L54:
                    ir.nasim.hs5 r8 = r7.d
                    java.lang.Boolean r0 = ir.nasim.AbstractC6392Nk0.a(r2)
                    r8.setValue(r0)
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC11610dI5.a.C1005a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C10857cJ7 c10857cJ7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1005a) create(c10857cJ7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC10040ay6 interfaceC10040ay6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC10040ay6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, interfaceC20295rm1);
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
                InterfaceC10040ay6 interfaceC10040ay6 = this.d;
                C1005a c1005a = new C1005a(interfaceC14415hs5, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10040ay6, c1005a, this) == objE) {
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

    /* renamed from: ir.nasim.dI5$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC10040ay6 d;
        final /* synthetic */ UA2 e;

        /* renamed from: ir.nasim.dI5$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ UA2 d;
            final /* synthetic */ InterfaceC14415hs5 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(UA2 ua2, InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = ua2;
                this.e = interfaceC14415hs5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:23:0x0071 A[RETURN] */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r7.b
                    r2 = 0
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L1f
                    if (r1 == r4) goto L1b
                    if (r1 != r3) goto L13
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L72
                L13:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L1b:
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L5e
                L1f:
                    ir.nasim.AbstractC10685c16.b(r8)
                    java.lang.Object r8 = r7.c
                    ir.nasim.cJ7 r8 = (ir.nasim.C10857cJ7) r8
                    boolean r1 = r8.b()
                    if (r1 == 0) goto L72
                    ir.nasim.UA2 r1 = r7.d
                    ir.nasim.d25 r8 = r8.a()
                    if (r8 == 0) goto L3d
                    int r8 = r8.getPeerId()
                    java.lang.Integer r8 = ir.nasim.AbstractC6392Nk0.d(r8)
                    goto L3e
                L3d:
                    r8 = 0
                L3e:
                    java.lang.Object r8 = r1.invoke(r8)
                    java.lang.Boolean r8 = (java.lang.Boolean) r8
                    boolean r8 = r8.booleanValue()
                    if (r8 == 0) goto L72
                    ir.nasim.hs5 r8 = r7.e
                    java.lang.Boolean r1 = ir.nasim.AbstractC6392Nk0.a(r2)
                    r8.setValue(r1)
                    r7.b = r4
                    r5 = 100
                    java.lang.Object r8 = ir.nasim.HG1.b(r5, r7)
                    if (r8 != r0) goto L5e
                    return r0
                L5e:
                    ir.nasim.hs5 r8 = r7.e
                    java.lang.Boolean r1 = ir.nasim.AbstractC6392Nk0.a(r4)
                    r8.setValue(r1)
                    r7.b = r3
                    r3 = 1500(0x5dc, double:7.41E-321)
                    java.lang.Object r8 = ir.nasim.HG1.b(r3, r7)
                    if (r8 != r0) goto L72
                    return r0
                L72:
                    ir.nasim.hs5 r8 = r7.e
                    java.lang.Boolean r0 = ir.nasim.AbstractC6392Nk0.a(r2)
                    r8.setValue(r0)
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC11610dI5.b.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C10857cJ7 c10857cJ7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c10857cJ7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC10040ay6 interfaceC10040ay6, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC10040ay6;
            this.e = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.d, this.e, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC14415hs5 interfaceC14415hs5 = (InterfaceC14415hs5) this.c;
                InterfaceC10040ay6 interfaceC10040ay6 = this.d;
                a aVar = new a(this.e, interfaceC14415hs5, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10040ay6, aVar, this) == objE) {
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
            return ((b) create(interfaceC14415hs5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final void c(final InterfaceC10040ay6 interfaceC10040ay6, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(interfaceC10040ay6, "sharedFlow");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1037565761);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(interfaceC10040ay6) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            Boolean bool = Boolean.FALSE;
            interfaceC22053ub1J.W(674942268);
            boolean zD = interfaceC22053ub1J.D(interfaceC10040ay6);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(interfaceC10040ay6, null);
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            if (d(AbstractC10222bH6.k(bool, (InterfaceC14603iB2) objB, interfaceC22053ub1J, 6))) {
                e.a aVar = androidx.compose.ui.e.a;
                androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null), C24381yX0.b.i(), null, 2, null);
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarD);
                InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar2.a();
                if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1J.G();
                if (interfaceC22053ub1J.h()) {
                    interfaceC22053ub1J.g(sa2A);
                } else {
                    interfaceC22053ub1J.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar2.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
                androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                AbstractC15878kK3.a(e(WM5.r(NK3.b.a(NK3.b.b(AbstractC19954rD5.lottie_call_like_reaction)), null, null, null, null, null, interfaceC22053ub1J, 0, 62)), androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null), false, false, null, 2.5f, 0, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, interfaceC22053ub1J, 196656, 0, 0, 4194268);
                interfaceC22053ub1J.u();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.cI5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC11610dI5.f(interfaceC10040ay6, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean d(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    private static final C23677xK3 e(LK3 lk3) {
        return (C23677xK3) lk3.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(InterfaceC10040ay6 interfaceC10040ay6, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(interfaceC10040ay6, "$sharedFlow");
        c(interfaceC10040ay6, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void g(final InterfaceC10040ay6 interfaceC10040ay6, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(interfaceC10040ay6, "sharedFlow");
        AbstractC13042fc3.i(ua2, "canDisplayReaction");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1861419683);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(interfaceC10040ay6) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            Boolean bool = Boolean.FALSE;
            interfaceC22053ub1J.W(75909950);
            boolean zD = ((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32) | interfaceC22053ub1J.D(interfaceC10040ay6);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new b(interfaceC10040ay6, ua2, null);
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC22231ut.f(h(AbstractC10222bH6.k(bool, (InterfaceC14603iB2) objB, interfaceC22053ub1J, 6)), androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), androidx.compose.animation.f.o(null, 0.0f, 3, null), androidx.compose.animation.f.q(null, 0.0f, 3, null), null, S81.a.a(), interfaceC22053ub1J, 200112, 16);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.bI5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC11610dI5.i(interfaceC10040ay6, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean h(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(InterfaceC10040ay6 interfaceC10040ay6, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(interfaceC10040ay6, "$sharedFlow");
        AbstractC13042fc3.i(ua2, "$canDisplayReaction");
        g(interfaceC10040ay6, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
