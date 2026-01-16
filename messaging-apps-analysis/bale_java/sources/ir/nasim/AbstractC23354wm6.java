package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import androidx.compose.ui.e;
import ir.nasim.AbstractC23354wm6;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC8037Ug2;

/* renamed from: ir.nasim.wm6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC23354wm6 {

    /* renamed from: ir.nasim.wm6$a */
    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC9102Ym4 a;
        final /* synthetic */ InterfaceC9102Ym4 b;
        final /* synthetic */ InterfaceC9102Ym4 c;

        /* renamed from: ir.nasim.wm6$a$a, reason: collision with other inner class name */
        static final class C1766a implements InterfaceC15796kB2 {
            final /* synthetic */ InterfaceC9102Ym4 a;

            C1766a(InterfaceC9102Ym4 interfaceC9102Ym4) {
                this.a = interfaceC9102Ym4;
            }

            public final void a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                int i2;
                AbstractC13042fc3.i(interfaceC14603iB2, "it");
                if ((i & 6) == 0) {
                    i2 = i | (interfaceC22053ub1.D(interfaceC14603iB2) ? 4 : 2);
                } else {
                    i2 = i;
                }
                if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                interfaceC22053ub1.W(-7733132);
                if (AbstractC23354wm6.n(this.a).length() == 0) {
                    AbstractC9339Zm7.b(UY6.c(AbstractC12217eE5.feedback_enter_opinion, interfaceC22053ub1, 0), null, DX0.b(C5495Jo7.a.u0()), AbstractC13784go7.g(16), null, null, M10.q(), 0L, null, null, 0L, 0, false, 1, 0, null, null, interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 122802);
                }
                interfaceC22053ub1.Q();
                interfaceC14603iB2.invoke(interfaceC22053ub1, Integer.valueOf(i2 & 14));
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((InterfaceC14603iB2) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        a(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, InterfaceC9102Ym4 interfaceC9102Ym43) {
            this.a = interfaceC9102Ym4;
            this.b = interfaceC9102Ym42;
            this.c = interfaceC9102Ym43;
        }

        private static final int d(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return ((Number) interfaceC9102Ym4.getValue()).intValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC5517Jr2 interfaceC5517Jr2) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$isTextFieldFocused");
            AbstractC13042fc3.i(interfaceC5517Jr2, "it");
            if (((Boolean) interfaceC9102Ym4.getValue()).booleanValue() != interfaceC5517Jr2.a()) {
                interfaceC9102Ym4.setValue(Boolean.valueOf(interfaceC5517Jr2.a()));
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$opinionText$delegate");
            AbstractC13042fc3.i(str, "it");
            AbstractC23354wm6.o(interfaceC9102Ym4, str);
            return C19938rB7.a;
        }

        public final void c(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            final InterfaceC9102Ym4 interfaceC9102Ym4;
            AbstractC13042fc3.i(interfaceC22821vt, "$this$AnimatedVisibility");
            interfaceC22053ub1.W(-1854332051);
            InterfaceC9102Ym4 interfaceC9102Ym42 = this.a;
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                InterfaceC8037Ug2 interfaceC8037Ug2F = AbstractC23354wm6.f(interfaceC9102Ym42);
                AbstractC13042fc3.g(interfaceC8037Ug2F, "null cannot be cast to non-null type ir.nasim.call.data.FeedBackRateState.Selected");
                objB = AbstractC13472gH6.d(Integer.valueOf(((InterfaceC8037Ug2.b) interfaceC8037Ug2F).a().j()), null, 2, null);
                interfaceC22053ub1.s(objB);
            }
            InterfaceC9102Ym4 interfaceC9102Ym43 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1.Q();
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.t.i(aVar2, C17784nZ1.q(122)), 0.0f, 1, null);
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(eVarH, DX0.b(c5495Jo7.s0()), null, 2, null);
            final InterfaceC9102Ym4 interfaceC9102Ym44 = this.b;
            InterfaceC9102Ym4 interfaceC9102Ym45 = this.c;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            float f = 12;
            AbstractC9339Zm7.b(UY6.c(d(interfaceC9102Ym43), interfaceC22053ub1, 0), androidx.compose.foundation.layout.q.m(aVar2, C17784nZ1.q(f), C17784nZ1.q(4), 0.0f, 0.0f, 12, null), WX0.a(IA5.color8, interfaceC22053ub1, 0), AbstractC13784go7.g(13), null, null, M10.p(), 0L, null, null, 0L, 0, false, 1, 0, null, null, interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 122800);
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.f(androidx.compose.foundation.layout.t.h(aVar2, 0.0f, 1, null), 0.0f, 1, null), C17784nZ1.q(f), 0.0f, 0.0f, 0.0f, 14, null);
            interfaceC22053ub1.W(-1567635105);
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == aVar.a()) {
                objB2 = new UA2() { // from class: ir.nasim.um6
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC23354wm6.a.f(interfaceC9102Ym44, (InterfaceC5517Jr2) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarA = androidx.compose.ui.focus.b.a(eVarM, (UA2) objB2);
            String strN = AbstractC23354wm6.n(interfaceC9102Ym45);
            C9348Zn7 c9348Zn7 = new C9348Zn7(DX0.b(c5495Jo7.w0()), AbstractC13784go7.g(16), (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, M10.q(), (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (AbstractC18051o02) null, 0, 0, 0L, (C5477Jm7) null, (C23283wf5) null, (C4888Gz3) null, 0, 0, (C22179un7) null, 16777180, (ED1) null);
            CH6 ch6 = new CH6(DX0.b(c5495Jo7.u2()), null);
            interfaceC22053ub1.W(-1567625042);
            Object objB3 = interfaceC22053ub1.B();
            if (objB3 == aVar.a()) {
                interfaceC9102Ym4 = interfaceC9102Ym45;
                objB3 = new UA2() { // from class: ir.nasim.vm6
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC23354wm6.a.h(interfaceC9102Ym4, (String) obj);
                    }
                };
                interfaceC22053ub1.s(objB3);
            } else {
                interfaceC9102Ym4 = interfaceC9102Ym45;
            }
            interfaceC22053ub1.Q();
            AbstractC21415td0.b(strN, (UA2) objB3, eVarA, false, false, c9348Zn7, null, null, false, 0, 0, null, null, null, ch6, AbstractC19242q11.e(73568396, true, new C1766a(interfaceC9102Ym4), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 196608, 16344);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.wm6$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC9102Ym4 a;

        b(InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = interfaceC9102Ym4;
        }

        public final void a(L66 l66, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(l66, "$this$TextButton");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC9339Zm7.b(UY6.c(AbstractC12217eE5.feedback_submit, interfaceC22053ub1, 0), null, AbstractC13042fc3.d(AbstractC23354wm6.f(this.a), InterfaceC8037Ug2.a.a) ? DX0.b(C5495Jo7.a.p0()) : DX0.b(C5495Jo7.a.u2()), AbstractC13784go7.g(16), null, null, M10.p(), 0L, null, null, 0L, 0, false, 1, 0, null, null, interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 122802);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((L66) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final void e(final InterfaceC14603iB2 interfaceC14603iB2, final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        final InterfaceC9102Ym4 interfaceC9102Ym4;
        AbstractC13042fc3.i(interfaceC14603iB2, "submitFeedback");
        AbstractC13042fc3.i(sa2, "onBackPressed");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1116609926);
        int i2 = (i & 6) == 0 ? (interfaceC22053ub1J.D(interfaceC14603iB2) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        int i3 = i2;
        if ((i3 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(855586295);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC13472gH6.d(InterfaceC8037Ug2.a.a, null, 2, null);
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC9102Ym4 interfaceC9102Ym42 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(855589491);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                objB2 = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                interfaceC22053ub1J.s(objB2);
            }
            InterfaceC9102Ym4 interfaceC9102Ym43 = (InterfaceC9102Ym4) objB2;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(855591350);
            Object objB3 = interfaceC22053ub1J.B();
            if (objB3 == aVar.a()) {
                objB3 = AbstractC13472gH6.d(new String(), null, 2, null);
                interfaceC22053ub1J.s(objB3);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym44 = (InterfaceC9102Ym4) objB3;
            interfaceC22053ub1J.Q();
            InterfaceC8037Ug2 interfaceC8037Ug2F = f(interfaceC9102Ym42);
            interfaceC22053ub1J.W(855593759);
            boolean zV = interfaceC22053ub1J.V(interfaceC8037Ug2F);
            Object objB4 = interfaceC22053ub1J.B();
            if (zV || objB4 == aVar.a()) {
                InterfaceC8037Ug2 interfaceC8037Ug2F2 = f(interfaceC9102Ym42);
                InterfaceC8037Ug2.b bVar = interfaceC8037Ug2F2 instanceof InterfaceC8037Ug2.b ? (InterfaceC8037Ug2.b) interfaceC8037Ug2F2 : null;
                objB4 = AbstractC13472gH6.d(Boolean.valueOf(bVar != null && bVar.a().compareTo(EnumC7123Qj2.i) < 0), null, 2, null);
                interfaceC22053ub1J.s(objB4);
            }
            InterfaceC9102Ym4 interfaceC9102Ym45 = (InterfaceC9102Ym4) objB4;
            interfaceC22053ub1J.Q();
            InterfaceC8037Ug2 interfaceC8037Ug2F3 = f(interfaceC9102Ym42);
            interfaceC22053ub1J.W(855600284);
            boolean zV2 = interfaceC22053ub1J.V(interfaceC8037Ug2F3);
            Object objB5 = interfaceC22053ub1J.B();
            if (zV2 || objB5 == aVar.a()) {
                InterfaceC8037Ug2 interfaceC8037Ug2F4 = f(interfaceC9102Ym42);
                InterfaceC8037Ug2.b bVar2 = interfaceC8037Ug2F4 instanceof InterfaceC8037Ug2.b ? (InterfaceC8037Ug2.b) interfaceC8037Ug2F4 : null;
                objB5 = AbstractC13472gH6.d(Boolean.valueOf(bVar2 != null && bVar2.a().compareTo(EnumC7123Qj2.g) < 0), null, 2, null);
                interfaceC22053ub1J.s(objB5);
            }
            InterfaceC9102Ym4 interfaceC9102Ym46 = (InterfaceC9102Ym4) objB5;
            interfaceC22053ub1J.Q();
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.h(aVar2, 0.0f, 1, null), WX0.a(IA5.color4, interfaceC22053ub1J, 0), null, 2, null), C17784nZ1.q(24));
            InterfaceC12529em.a aVar3 = InterfaceC12529em.a;
            InterfaceC12529em.b bVarG = aVar3.g();
            C24254yJ c24254yJ = C24254yJ.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), bVarG, interfaceC22053ub1J, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarI);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar4.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar4.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar4.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            InterfaceC9102Ym4 interfaceC9102Ym47 = interfaceC9102Ym42;
            AbstractC9339Zm7.b(UY6.c(AbstractC12217eE5.feedback_title, interfaceC22053ub1J, 0), c9784aZ0.c(aVar2, aVar3.g()), WX0.a(IA5.color9, interfaceC22053ub1J, 0), AbstractC13784go7.g(18), null, null, M10.p(), 0L, null, null, 0L, 0, false, 1, 0, null, null, interfaceC22053ub1J, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 122800);
            float f = 12;
            AbstractC9339Zm7.b(UY6.c(AbstractC12217eE5.feedback_question, interfaceC22053ub1J, 0), androidx.compose.foundation.layout.q.m(aVar2, 0.0f, C17784nZ1.q(f), 0.0f, 0.0f, 13, null), WX0.a(IA5.color9, interfaceC22053ub1J, 0), AbstractC13784go7.g(14), null, null, M10.q(), 0L, null, null, 0L, 0, false, 1, 0, null, null, interfaceC22053ub1J, 3120, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 122800);
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.E(aVar2, null, false, 3, null), 0.0f, C17784nZ1.q(f), 0.0f, 0.0f, 13, null);
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.o(C17784nZ1.q(10)), aVar3.l(), interfaceC22053ub1J, 6);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarM);
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
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3B, aVar4.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar4.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar4.f());
            M66 m66 = M66.a;
            interfaceC22053ub1J.W(-1854393404);
            for (EnumC7123Qj2 enumC7123Qj2 : AbstractC14201hX0.U(AbstractC9648aK.d(EnumC7123Qj2.values()))) {
                InterfaceC8037Ug2 interfaceC8037Ug2F5 = f(interfaceC9102Ym47);
                interfaceC22053ub1J.W(-1567725035);
                Object objB6 = interfaceC22053ub1J.B();
                if (objB6 == InterfaceC22053ub1.a.a()) {
                    interfaceC9102Ym4 = interfaceC9102Ym47;
                    objB6 = new UA2() { // from class: ir.nasim.qm6
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC23354wm6.i(interfaceC9102Ym4, (EnumC7123Qj2) obj);
                        }
                    };
                    interfaceC22053ub1J.s(objB6);
                } else {
                    interfaceC9102Ym4 = interfaceC9102Ym47;
                }
                interfaceC22053ub1J.Q();
                BG5.e(enumC7123Qj2, interfaceC8037Ug2F5, (UA2) objB6, interfaceC22053ub1J, 384);
                interfaceC9102Ym47 = interfaceC9102Ym4;
            }
            final InterfaceC9102Ym4 interfaceC9102Ym48 = interfaceC9102Ym47;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.u();
            boolean zH = h(interfaceC9102Ym46);
            C13985h91 c13985h91 = C13985h91.a;
            AbstractC22231ut.d(c9784aZ0, zH, null, null, null, null, c13985h91.a(), interfaceC22053ub1J, 1572870, 30);
            AbstractC22231ut.d(c9784aZ0, h(interfaceC9102Ym46), null, null, null, null, c13985h91.b(), interfaceC22053ub1J, 1572870, 30);
            AbstractC22231ut.d(c9784aZ0, g(interfaceC9102Ym45), null, null, null, null, c13985h91.c(), interfaceC22053ub1J, 1572870, 30);
            boolean zG = g(interfaceC9102Ym45);
            androidx.compose.animation.h hVarM = androidx.compose.animation.f.m(null, null, false, null, 15, null);
            androidx.compose.animation.j jVarY = androidx.compose.animation.f.y(null, null, false, null, 15, null);
            e.a aVar5 = androidx.compose.ui.e.a;
            float f2 = 20;
            float f3 = 8;
            AbstractC22231ut.d(c9784aZ0, zG, AbstractC9287Zh0.f(FV0.a(AbstractC6033Lw6.b(aVar5, C17784nZ1.q(5), N46.e(C17784nZ1.q(f2), C17784nZ1.q(f2), C17784nZ1.q(f3), C17784nZ1.q(f3)), false, 0L, 0L, 24, null), N46.d(C17784nZ1.q(f3))), C17784nZ1.q(2), ((Boolean) interfaceC9102Ym43.getValue()).booleanValue() ? DX0.b(C5495Jo7.a.u2()) : C24381yX0.b.i(), N46.d(C17784nZ1.q(f3))), hVarM, jVarY, null, AbstractC19242q11.e(-1129827681, true, new a(interfaceC9102Ym48, interfaceC9102Ym43, interfaceC9102Ym44), interfaceC22053ub1J, 54), interfaceC22053ub1J, 1600518, 16);
            interfaceC22053ub1J.u();
            float f4 = 1;
            androidx.compose.ui.e eVarF = AbstractC19576qb1.f(androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.h(aVar5, 0.0f, 1, null), WX0.a(IA5.color6_2, interfaceC22053ub1J, 0), null, 2, null), C17784nZ1.q(f4), WX0.a(IA5.color1, interfaceC22053ub1J, 0));
            InterfaceC10970cW3 interfaceC10970cW3B2 = J66.b(C24254yJ.a.d(), InterfaceC12529em.a.l(), interfaceC22053ub1J, 6);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarF);
            InterfaceC16030kb1.a aVar6 = InterfaceC16030kb1.d0;
            SA2 sa2A3 = aVar6.a();
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
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3B2, aVar6.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar6.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar6.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar6.f());
            M66 m662 = M66.a;
            androidx.compose.ui.e eVarB = L66.b(m662, aVar5, 1.0f, false, 2, null);
            InterfaceC10031ax6 interfaceC10031ax6A = MK5.a();
            interfaceC22053ub1J.W(-2064498879);
            boolean z = (i3 & 14) == 4;
            Object objB7 = interfaceC22053ub1J.B();
            if (z || objB7 == InterfaceC22053ub1.a.a()) {
                objB7 = new SA2() { // from class: ir.nasim.rm6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC23354wm6.k(interfaceC9102Ym48, interfaceC14603iB2, interfaceC9102Ym44);
                    }
                };
                interfaceC22053ub1J.s(objB7);
            }
            interfaceC22053ub1J.Q();
            AbstractC16159ko0.b((SA2) objB7, eVarB, false, interfaceC10031ax6A, null, null, null, null, null, AbstractC19242q11.e(1729299205, true, new b(interfaceC9102Ym48), interfaceC22053ub1J, 54), interfaceC22053ub1J, 805309440, SIPTransactionStack.BASE_TIMER_INTERVAL);
            androidx.compose.ui.e eVarD = AbstractC19576qb1.d(L66.b(m662, aVar5, 1.0f, false, 2, null), C17784nZ1.q(f4), WX0.a(IA5.color1, interfaceC22053ub1J, 0));
            interfaceC22053ub1J.W(-2064470689);
            boolean z2 = (i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32;
            Object objB8 = interfaceC22053ub1J.B();
            if (z2 || objB8 == InterfaceC22053ub1.a.a()) {
                objB8 = new SA2() { // from class: ir.nasim.sm6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC23354wm6.l(sa2);
                    }
                };
                interfaceC22053ub1J.s(objB8);
            }
            interfaceC22053ub1J.Q();
            AbstractC16159ko0.b((SA2) objB8, eVarD, false, null, null, null, null, null, null, c13985h91.d(), interfaceC22053ub1J, 805306368, 508);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.tm6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC23354wm6.m(interfaceC14603iB2, sa2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC8037Ug2 f(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (InterfaceC8037Ug2) interfaceC9102Ym4.getValue();
    }

    private static final boolean g(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    private static final boolean h(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(InterfaceC9102Ym4 interfaceC9102Ym4, EnumC7123Qj2 enumC7123Qj2) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$selectedRate$delegate");
        AbstractC13042fc3.i(enumC7123Qj2, "rate");
        j(interfaceC9102Ym4, new InterfaceC8037Ug2.b(enumC7123Qj2));
        return C19938rB7.a;
    }

    private static final void j(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC8037Ug2 interfaceC8037Ug2) {
        interfaceC9102Ym4.setValue(interfaceC8037Ug2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC9102Ym4 interfaceC9102Ym42) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$selectedRate$delegate");
        AbstractC13042fc3.i(interfaceC14603iB2, "$submitFeedback");
        AbstractC13042fc3.i(interfaceC9102Ym42, "$opinionText$delegate");
        InterfaceC8037Ug2 interfaceC8037Ug2F = f(interfaceC9102Ym4);
        InterfaceC8037Ug2.b bVar = interfaceC8037Ug2F instanceof InterfaceC8037Ug2.b ? (InterfaceC8037Ug2.b) interfaceC8037Ug2F : null;
        if (bVar != null) {
            interfaceC14603iB2.invoke(bVar.a(), n(interfaceC9102Ym42));
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onBackPressed");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(InterfaceC14603iB2 interfaceC14603iB2, SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$submitFeedback");
        AbstractC13042fc3.i(sa2, "$onBackPressed");
        e(interfaceC14603iB2, sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String n(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (String) interfaceC9102Ym4.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
        interfaceC9102Ym4.setValue(str);
    }
}
