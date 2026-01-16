package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.C24381yX0;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;

/* renamed from: ir.nasim.oe3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC18426oe3 {

    /* renamed from: ir.nasim.oe3$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C19818qz6 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C19818qz6 c19818qz6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c19818qz6;
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
                C19818qz6 c19818qz6 = this.c;
                this.b = 1;
                if (c19818qz6.j(this) == objE) {
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

    /* renamed from: ir.nasim.oe3$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        public final void a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC14603iB2, "innerTextField");
            if ((i & 6) == 0) {
                i |= interfaceC22053ub1.D(interfaceC14603iB2) ? 4 : 2;
            }
            if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            interfaceC22053ub1.W(1668545204);
            if (this.a.length() == 0) {
                AbstractC18426oe3.l(interfaceC22053ub1, 0);
            }
            interfaceC22053ub1.Q();
            interfaceC14603iB2.invoke(interfaceC22053ub1, Integer.valueOf(i & 14));
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC14603iB2) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final void j(final String str, final SA2 sa2, final InterfaceC20315ro1 interfaceC20315ro1, final C19818qz6 c19818qz6, final C5860Ld3 c5860Ld3, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(str, "query");
        AbstractC13042fc3.i(sa2, "closeBottomSheet");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(c19818qz6, "bottomSheetState");
        AbstractC13042fc3.i(c5860Ld3, "viewModel");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-413150116);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC20315ro1) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.V(c19818qz6) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= (32768 & i) == 0 ? interfaceC22053ub1J.V(c5860Ld3) : interfaceC22053ub1J.D(c5860Ld3) ? 16384 : 8192;
        }
        int i3 = i2;
        if ((i3 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            float f = 16;
            float f2 = 8;
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.foundation.b.c(AbstractC6033Lw6.b(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.k(aVar, C17784nZ1.q(f), 0.0f, 2, null), 0.0f, 1, null), C17784nZ1.q(36)), C17784nZ1.q(3), N46.e(C17784nZ1.q(f), C17784nZ1.q(f), C17784nZ1.q(f2), C17784nZ1.q(f2)), false, 0L, 0L, 24, null), WX0.a(TA5.color6_2, interfaceC22053ub1J, 0), N46.d(C17784nZ1.q(f2))), C17784nZ1.q(f), 0.0f, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), InterfaceC12529em.a.i(), interfaceC22053ub1J, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarK);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            M66 m66 = M66.a;
            int i4 = C5860Ld3.m;
            int i5 = (i3 >> 9) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
            q(sa2, c5860Ld3, interfaceC20315ro1, c19818qz6, interfaceC22053ub1J, ((i3 >> 3) & 14) | (i4 << 3) | i5 | (i3 & 896) | (i3 & 7168));
            u(androidx.compose.foundation.layout.q.k(L66.b(m66, aVar, 1.0f, false, 2, null), C17784nZ1.q(12), 0.0f, 2, null), str, c5860Ld3, interfaceC22053ub1J, ((i3 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i4 << 6) | ((i3 >> 6) & 896));
            n(str, c5860Ld3, interfaceC22053ub1J, (i3 & 14) | (i4 << 3) | i5);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.fe3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC18426oe3.k(str, sa2, interfaceC20315ro1, c19818qz6, c5860Ld3, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(String str, SA2 sa2, InterfaceC20315ro1 interfaceC20315ro1, C19818qz6 c19818qz6, C5860Ld3 c5860Ld3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(str, "$query");
        AbstractC13042fc3.i(sa2, "$closeBottomSheet");
        AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
        AbstractC13042fc3.i(c19818qz6, "$bottomSheetState");
        AbstractC13042fc3.i(c5860Ld3, "$viewModel");
        j(str, sa2, interfaceC20315ro1, c19818qz6, c5860Ld3, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void l(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(498990951);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            androidx.compose.ui.e eVarC = androidx.compose.foundation.layout.t.C(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), null, false, 3, null);
            String strC = UY6.c(AbstractC12217eE5.search_hint_chat, interfaceC22053ub1J, 0);
            long jG = AbstractC13784go7.g(16);
            AbstractC9998au2 abstractC9998au2Q = M10.q();
            AbstractC9105Ym7.b(strC, eVarC, WX0.a(TA5.color7, interfaceC22053ub1J, 0), jG, null, null, abstractC9998au2Q, 0L, null, null, 0L, 0, false, 0, 0, null, new C9348Zn7(0L, AbstractC13784go7.g(16), (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, M10.q(), (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (AbstractC18051o02) null, 0, C4049Dl7.b.c(), 0L, (C5477Jm7) null, (C23283wf5) null, (C4888Gz3) null, 0, 0, (C22179un7) null, 16711645, (ED1) null), interfaceC22053ub1J, 3120, 0, 65456);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.ne3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC18426oe3.m(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        l(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void n(final String str, final C5860Ld3 c5860Ld3, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(str, "query");
        AbstractC13042fc3.i(c5860Ld3, "viewModel");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1671238317);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? interfaceC22053ub1J.V(c5860Ld3) : interfaceC22053ub1J.D(c5860Ld3) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            boolean z = true;
            if (str.length() == 0) {
                interfaceC22053ub1J.W(-315491751);
                AbstractC24077y03.b(FV4.c(KB5.ic_search, interfaceC22053ub1J, 0), "", androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, C17784nZ1.q(24)), WX0.a(TA5.color7, interfaceC22053ub1J, 0), interfaceC22053ub1J, 432, 0);
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(-315248773);
                androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, C17784nZ1.q(24));
                interfaceC22053ub1J.W(-1811282114);
                if ((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) != 32 && ((i2 & 64) == 0 || !interfaceC22053ub1J.D(c5860Ld3))) {
                    z = false;
                }
                Object objB = interfaceC22053ub1J.B();
                if (z || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.ie3
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC18426oe3.o(c5860Ld3);
                        }
                    };
                    interfaceC22053ub1J.s(objB);
                }
                interfaceC22053ub1J.Q();
                AbstractC21037t03.a((SA2) objB, eVarT, false, null, C16337l61.a.a(), interfaceC22053ub1J, 24624, 12);
                interfaceC22053ub1J.Q();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.je3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC18426oe3.p(str, c5860Ld3, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(C5860Ld3 c5860Ld3) {
        AbstractC13042fc3.i(c5860Ld3, "$viewModel");
        c5860Ld3.g1("");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(String str, C5860Ld3 c5860Ld3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(str, "$query");
        AbstractC13042fc3.i(c5860Ld3, "$viewModel");
        n(str, c5860Ld3, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void q(final SA2 sa2, final C5860Ld3 c5860Ld3, final InterfaceC20315ro1 interfaceC20315ro1, final C19818qz6 c19818qz6, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(sa2, "closeBottomSheet");
        AbstractC13042fc3.i(c5860Ld3, "viewModel");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(c19818qz6, "bottomSheetState");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2146121790);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? interfaceC22053ub1J.V(c5860Ld3) : interfaceC22053ub1J.D(c5860Ld3) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC20315ro1) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.V(c19818qz6) ? 2048 : 1024;
        }
        if ((i2 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(-1260234159);
            boolean zD = ((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32 || ((i2 & 64) != 0 && interfaceC22053ub1J.D(c5860Ld3))) | interfaceC22053ub1J.D(interfaceC20315ro1) | ((i2 & 7168) == 2048) | ((i2 & 14) == 4);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.ke3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC18426oe3.r(c5860Ld3, interfaceC20315ro1, c19818qz6, sa2);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC21037t03.a((SA2) objB, null, false, null, C16337l61.a.b(), interfaceC22053ub1J, 24576, 14);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.le3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC18426oe3.t(sa2, c5860Ld3, interfaceC20315ro1, c19818qz6, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(C5860Ld3 c5860Ld3, InterfaceC20315ro1 interfaceC20315ro1, final C19818qz6 c19818qz6, final SA2 sa2) {
        AbstractC13042fc3.i(c5860Ld3, "$viewModel");
        AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
        AbstractC13042fc3.i(c19818qz6, "$bottomSheetState");
        AbstractC13042fc3.i(sa2, "$closeBottomSheet");
        c5860Ld3.g1("");
        AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(c19818qz6, null), 3, null).s(new UA2() { // from class: ir.nasim.me3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC18426oe3.s(c19818qz6, sa2, (Throwable) obj);
            }
        });
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s(C19818qz6 c19818qz6, SA2 sa2, Throwable th) {
        AbstractC13042fc3.i(c19818qz6, "$bottomSheetState");
        AbstractC13042fc3.i(sa2, "$closeBottomSheet");
        if (!c19818qz6.k()) {
            sa2.invoke();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(SA2 sa2, C5860Ld3 c5860Ld3, InterfaceC20315ro1 interfaceC20315ro1, C19818qz6 c19818qz6, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$closeBottomSheet");
        AbstractC13042fc3.i(c5860Ld3, "$viewModel");
        AbstractC13042fc3.i(interfaceC20315ro1, "$scope");
        AbstractC13042fc3.i(c19818qz6, "$bottomSheetState");
        q(sa2, c5860Ld3, interfaceC20315ro1, c19818qz6, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void u(final androidx.compose.ui.e eVar, final String str, final C5860Ld3 c5860Ld3, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(eVar, "modifier");
        AbstractC13042fc3.i(str, "query");
        AbstractC13042fc3.i(c5860Ld3, "viewModel");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-368510412);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? interfaceC22053ub1J.V(c5860Ld3) : interfaceC22053ub1J.D(c5860Ld3) ? 256 : 128;
        }
        int i3 = i2;
        if ((i3 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            interfaceC22053ub1J.W(-1147468862);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC23831xb3.a();
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            C8555Wl7 c8555Wl7 = C8555Wl7.a;
            androidx.compose.ui.e eVarI = androidx.compose.ui.e.a.i(eVar);
            boolean z = false;
            long jA = WX0.a(TA5.color6_2, interfaceC22053ub1J, 0);
            long jA2 = WX0.a(TA5.secondary, interfaceC22053ub1J, 0);
            C24381yX0.a aVar2 = C24381yX0.b;
            androidx.compose.ui.e eVarH = c8555Wl7.h(eVarI, true, false, (InterfaceC18507om4) objB, c8555Wl7.m(0L, 0L, jA, jA2, 0L, aVar2.h(), aVar2.h(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, interfaceC22053ub1J, 1769472, 0, 48, 2097043), (48 & 16) != 0 ? C8555Wl7.e : 0.0f, (48 & 32) != 0 ? C8555Wl7.d : 0.0f);
            C9348Zn7 c9348Zn7 = new C9348Zn7(WX0.a(TA5.color9, interfaceC22053ub1J, 0), AbstractC13784go7.g(16), (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, M10.q(), (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (AbstractC18051o02) null, 0, C4049Dl7.b.c(), 0L, (C5477Jm7) null, (C23283wf5) null, (C4888Gz3) null, 0, 0, (C22179un7) null, 16711644, (ED1) null);
            CH6 ch6 = new CH6(WX0.a(TA5.secondary, interfaceC22053ub1J, 0), null);
            interfaceC22053ub1J.W(-1147448558);
            if ((i3 & 896) == 256 || ((i3 & 512) != 0 && interfaceC22053ub1J.D(c5860Ld3))) {
                z = true;
            }
            Object objB2 = interfaceC22053ub1J.B();
            if (z || objB2 == aVar.a()) {
                objB2 = new UA2() { // from class: ir.nasim.ge3
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC18426oe3.v(c5860Ld3, (String) obj);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC21415td0.b(str, (UA2) objB2, eVarH, false, false, c9348Zn7, null, null, true, 0, 0, null, null, null, ch6, AbstractC19242q11.e(1565984279, true, new b(str), interfaceC22053ub1J, 54), interfaceC22053ub12, ((i3 >> 3) & 14) | 100663296, 196608, 16088);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.he3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC18426oe3.w(eVar, str, c5860Ld3, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(C5860Ld3 c5860Ld3, String str) {
        AbstractC13042fc3.i(c5860Ld3, "$viewModel");
        AbstractC13042fc3.i(str, "it");
        c5860Ld3.g1(str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w(androidx.compose.ui.e eVar, String str, C5860Ld3 c5860Ld3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(eVar, "$modifier");
        AbstractC13042fc3.i(str, "$query");
        AbstractC13042fc3.i(c5860Ld3, "$viewModel");
        u(eVar, str, c5860Ld3, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
