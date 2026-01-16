package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.C24381yX0;
import ir.nasim.C4049Dl7;
import ir.nasim.C6399Nk7;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;

/* loaded from: classes4.dex */
public abstract class B65 {

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC9102Ym4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC9102Ym4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:17:0x0048). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r5.b
                r2 = 1
                if (r1 == 0) goto L1b
                if (r1 != r2) goto L13
                java.lang.Object r1 = r5.c
                ir.nasim.hs5 r1 = (ir.nasim.InterfaceC14415hs5) r1
                ir.nasim.AbstractC10685c16.b(r6)
                goto L48
            L13:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1b:
                ir.nasim.AbstractC10685c16.b(r6)
                java.lang.Object r6 = r5.c
                ir.nasim.hs5 r6 = (ir.nasim.InterfaceC14415hs5) r6
                ir.nasim.Ym4 r1 = r5.d
                boolean r1 = ir.nasim.B65.t(r1)
                if (r1 == 0) goto L32
                r1 = 0
                java.lang.Float r1 = ir.nasim.AbstractC6392Nk0.c(r1)
                r6.setValue(r1)
            L32:
                r1 = r6
            L33:
                ir.nasim.Ym4 r6 = r5.d
                boolean r6 = ir.nasim.B65.t(r6)
                if (r6 != 0) goto L62
                r5.c = r1
                r5.b = r2
                r3 = 200(0xc8, double:9.9E-322)
                java.lang.Object r6 = ir.nasim.HG1.b(r3, r5)
                if (r6 != r0) goto L48
                return r0
            L48:
                java.lang.Object r6 = r1.getValue()
                java.lang.Number r6 = (java.lang.Number) r6
                float r6 = r6.floatValue()
                r3 = 20
                float r3 = (float) r3
                float r6 = r6 + r3
                r3 = 150(0x96, float:2.1E-43)
                float r3 = (float) r3
                float r6 = r6 % r3
                java.lang.Float r6 = ir.nasim.AbstractC6392Nk0.c(r6)
                r1.setValue(r6)
                goto L33
            L62:
                ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.B65.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC14415hs5 interfaceC14415hs5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC14415hs5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final void i(final C8942Xx0 c8942Xx0, final C12767fA0 c12767fA0, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        final InterfaceC9102Ym4 interfaceC9102Ym4;
        AbstractC13042fc3.i(c8942Xx0, "callPeer");
        AbstractC13042fc3.i(c12767fA0, "callViewModel");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1485879706);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? interfaceC22053ub1J.V(c8942Xx0) : interfaceC22053ub1J.D(c8942Xx0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? interfaceC22053ub1J.V(c12767fA0) : interfaceC22053ub1J.D(c12767fA0) ? 32 : 16;
        }
        int i3 = i2;
        if ((i3 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(1595539772);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC9102Ym4 interfaceC9102Ym42 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1J.Q();
            Float fValueOf = Float.valueOf(0.0f);
            Boolean boolValueOf = Boolean.valueOf(j(interfaceC9102Ym42));
            interfaceC22053ub1J.W(1595544045);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                objB2 = new a(interfaceC9102Ym42, null);
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            InterfaceC9664aL6 interfaceC9664aL6L = AbstractC10222bH6.l(fValueOf, boolValueOf, (InterfaceC14603iB2) objB2, interfaceC22053ub1J, 6);
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(aVar2, 0.0f, 1, null);
            G10 g10 = G10.a;
            int i4 = G10.b;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(eVarF, g10.b(interfaceC22053ub1J, i4).a(), null, 2, null);
            InterfaceC12529em.a aVar3 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar3.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarD);
            InterfaceC16030kb1.a aVar4 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar4.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar4.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar4.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar4.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            EV4 ev4H = AvatarAsyncImagePainterKt.h(c8942Xx0.a(), null, false, 640, interfaceC22053ub1J, 3120, 4);
            EV4 ev4H2 = AvatarAsyncImagePainterKt.h(c8942Xx0.a(), FV4.c(KB5.ic_voice_call_profile, interfaceC22053ub1J, 0), false, 0, interfaceC22053ub1J, 0, 12);
            androidx.compose.ui.e eVarF2 = androidx.compose.foundation.layout.t.f(aVar2, 0.0f, 1, null);
            C24381yX0.a aVar5 = C24381yX0.b;
            AbstractC11456d23.b(ev4H, null, androidx.compose.foundation.b.d(eVarF2, aVar5.i(), null, 2, null), null, InterfaceC13157fl1.a.a(), 0.0f, AbstractC24975zX0.b.a(C24381yX0.o(AbstractC24067xz3.X(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), AbstractC7094Qg0.a.r()), interfaceC22053ub1J, 25008, 40);
            final String strD = UY6.d(AbstractC12217eE5.accessibility_incoming_name, new Object[]{c8942Xx0.c()}, interfaceC22053ub1J, 0);
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(hVar.h(aVar2, aVar3.m()), 0.0f, C17784nZ1.q(100), 0.0f, 0.0f, 13, null);
            interfaceC22053ub1J.W(-174577788);
            boolean zV = interfaceC22053ub1J.V(strD);
            Object objB3 = interfaceC22053ub1J.B();
            if (zV || objB3 == aVar.a()) {
                objB3 = new UA2() { // from class: ir.nasim.t65
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return B65.r(strD, (InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarC = AbstractC6919Pn6.c(eVarM, true, (UA2) objB3);
            InterfaceC12529em.b bVarG = aVar3.g();
            C24254yJ c24254yJ = C24254yJ.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), bVarG, interfaceC22053ub1J, 48);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarC);
            SA2 sa2A2 = aVar4.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A2);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A, aVar4.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar4.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar4.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            AbstractC11456d23.b(ev4H2, null, AbstractC9287Zh0.f(androidx.compose.foundation.b.d(Ac8.a(FV0.a(androidx.compose.foundation.layout.t.t(aVar2, C17784nZ1.q(90)), N46.g()), 2.0f), aVar5.i(), null, 2, null), C17784nZ1.q(2), AbstractC24067xz3.T(), N46.g()), null, null, 0.0f, null, interfaceC22053ub1J, 48, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
            androidx.compose.ui.e eVarC2 = c9784aZ0.c(aVar2, aVar3.g());
            float f = 6;
            androidx.compose.ui.e eVarM2 = androidx.compose.foundation.layout.q.m(eVarC2, 0.0f, C17784nZ1.q(f), 0.0f, 0.0f, 13, null);
            interfaceC22053ub1J.W(1668245761);
            Object objB4 = interfaceC22053ub1J.B();
            if (objB4 == aVar.a()) {
                objB4 = new UA2() { // from class: ir.nasim.u65
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return B65.l((InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1J.s(objB4);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarD2 = AbstractC6919Pn6.d(eVarM2, false, (UA2) objB4, 1, null);
            String strC = c8942Xx0.c();
            long j = aVar5.j();
            C4049Dl7.a aVar6 = C4049Dl7.b;
            int iE = aVar6.e();
            C6399Nk7.a aVar7 = C6399Nk7.b;
            AbstractC9105Ym7.b(strC, eVarD2, j, AbstractC13784go7.g(16), null, null, M10.p(), 0L, null, null, 0L, AbstractC23365wn7.a.b(), false, 1, 0, null, new C9348Zn7(0L, 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (AbstractC18051o02) null, aVar7.a(), iE, 0L, (C5477Jm7) null, (C23283wf5) null, (C4888Gz3) null, 0, 0, (C22179un7) null, 16678911, (ED1) null), interfaceC22053ub1J, 3456, 3120, 55216);
            androidx.compose.ui.e eVarM3 = androidx.compose.foundation.layout.q.m(c9784aZ0.c(aVar2, aVar3.g()), 0.0f, C17784nZ1.q(f), 0.0f, 0.0f, 13, null);
            interfaceC22053ub1J.W(1668265537);
            Object objB5 = interfaceC22053ub1J.B();
            if (objB5 == aVar.a()) {
                objB5 = new UA2() { // from class: ir.nasim.v65
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return B65.m((InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1J.s(objB5);
            }
            interfaceC22053ub1J.Q();
            AbstractC9105Ym7.b(UY6.c(BD5.bale_voice_call, interfaceC22053ub1J, 0), AbstractC6919Pn6.d(eVarM3, false, (UA2) objB5, 1, null), aVar5.j(), AbstractC13784go7.g(12), null, null, M10.q(), 0L, null, C6399Nk7.h(aVar7.a()), 0L, 0, false, 0, 0, null, new C9348Zn7(0L, 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (AbstractC18051o02) null, 0, aVar6.c(), 0L, (C5477Jm7) null, (C23283wf5) null, (C4888Gz3) null, 0, 0, (C22179un7) null, 16711679, (ED1) null), interfaceC22053ub1J, 3456, 0, 64944);
            interfaceC22053ub1J.u();
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(hVar.h(androidx.compose.foundation.layout.t.h(aVar2, 0.0f, 1, null), aVar3.b()), C17784nZ1.q(40));
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.e(), aVar3.l(), interfaceC22053ub1J, 6);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarI);
            SA2 sa2A3 = aVar4.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A3);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A3 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3B, aVar4.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar4.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar4.f());
            M66 m66 = M66.a;
            long jL = g10.b(interfaceC22053ub1J, i4).l();
            int i5 = KB5.ic_call_accept_new;
            String strC2 = UY6.c(AbstractC12217eE5.voice_call_new_answer, interfaceC22053ub1J, 0);
            interfaceC22053ub1J.W(1668294509);
            int i6 = i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
            boolean z = i6 == 32 || ((i3 & 64) != 0 && interfaceC22053ub1J.D(c12767fA0));
            Object objB6 = interfaceC22053ub1J.B();
            if (z || objB6 == aVar.a()) {
                objB6 = new SA2() { // from class: ir.nasim.w65
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return B65.n(c12767fA0);
                    }
                };
                interfaceC22053ub1J.s(objB6);
            }
            SA2 sa2 = (SA2) objB6;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1668301410);
            Object objB7 = interfaceC22053ub1J.B();
            if (objB7 == aVar.a()) {
                interfaceC9102Ym4 = interfaceC9102Ym42;
                objB7 = new UA2() { // from class: ir.nasim.x65
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return B65.o(interfaceC9102Ym4, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1J.s(objB7);
            } else {
                interfaceC9102Ym4 = interfaceC9102Ym42;
            }
            interfaceC22053ub1J.Q();
            final InterfaceC9102Ym4 interfaceC9102Ym43 = interfaceC9102Ym4;
            boolean z2 = true;
            AbstractC24717z53.e(jL, i5, strC2, sa2, interfaceC9664aL6L, (UA2) objB7, 2.0f, interfaceC22053ub1J, 1769472, 0);
            long jB = g10.b(interfaceC22053ub1J, i4).b();
            int i7 = KB5.ic_call_end_new;
            String strC3 = UY6.c(AbstractC12217eE5.voice_call_new_reject, interfaceC22053ub1J, 0);
            interfaceC22053ub1J.W(1668313650);
            if (i6 != 32 && ((i3 & 64) == 0 || !interfaceC22053ub1J.D(c12767fA0))) {
                z2 = false;
            }
            Object objB8 = interfaceC22053ub1J.B();
            if (z2 || objB8 == aVar.a()) {
                objB8 = new SA2() { // from class: ir.nasim.y65
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return B65.p(c12767fA0);
                    }
                };
                interfaceC22053ub1J.s(objB8);
            }
            SA2 sa22 = (SA2) objB8;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1668320706);
            Object objB9 = interfaceC22053ub1J.B();
            if (objB9 == aVar.a()) {
                objB9 = new UA2() { // from class: ir.nasim.z65
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return B65.q(interfaceC9102Ym43, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1J.s(objB9);
            }
            interfaceC22053ub1J.Q();
            AbstractC24717z53.e(jB, i7, strC3, sa22, interfaceC9664aL6L, (UA2) objB9, 1.0f, interfaceC22053ub1J, 1769472, 0);
            interfaceC22053ub1J.u();
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.A65
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return B65.s(c8942Xx0, c12767fA0, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    private static final void k(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.x(interfaceC11943do6);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.x(interfaceC11943do6);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(C12767fA0 c12767fA0) {
        AbstractC13042fc3.i(c12767fA0, "$callViewModel");
        C19406qI3.a("PersonalIncomingCall", "accept incoming call", new Object[0]);
        c12767fA0.U0();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isTouched$delegate");
        k(interfaceC9102Ym4, z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(C12767fA0 c12767fA0) {
        AbstractC13042fc3.i(c12767fA0, "$callViewModel");
        C19406qI3.a("PersonalIncomingCall", "reject incoming call", new Object[0]);
        c12767fA0.E1();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isTouched$delegate");
        k(interfaceC9102Ym4, z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(String str, InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(str, "$accessibilityUserName");
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.e0(interfaceC11943do6, str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s(C8942Xx0 c8942Xx0, C12767fA0 c12767fA0, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c8942Xx0, "$callPeer");
        AbstractC13042fc3.i(c12767fA0, "$callViewModel");
        i(c8942Xx0, c12767fA0, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
