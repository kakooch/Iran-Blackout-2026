package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC14472hy4;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.OA2;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.qk, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC19664qk {

    /* renamed from: ir.nasim.qk$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ androidx.compose.ui.focus.m c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(androidx.compose.ui.focus.m mVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = mVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            androidx.compose.ui.focus.m.g(this.c, 0, 1, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.qk$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;

        b(SA2 sa2) {
            this.a = sa2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC21639ts7.i(UY6.c(SD5.story_text_story_fragment_title, interfaceC22053ub1, 0), null, this.a, null, null, null, null, interfaceC22053ub1, 0, 122);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A(SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$textFieldValue$delegate");
        x(interfaceC9102Ym4, "");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B(androidx.compose.ui.e eVar, UA2 ua2, UA2 ua22, String str, SA2 sa2, SA2 sa22, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        v(eVar, ua2, ua22, str, sa2, sa22, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 C(String str) {
        AbstractC13042fc3.i(str, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 D(String str) {
        AbstractC13042fc3.i(str, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 E() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F() {
        return C19938rB7.a;
    }

    public static final void G(final androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-185414661);
        if ((i & 1) == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if ((i2 & 1) != 0) {
                eVar = androidx.compose.ui.e.a;
            }
            v(null, null, null, null, null, null, interfaceC22053ub1J, 0, 63);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Yj
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19664qk.H(eVar, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 H(androidx.compose.ui.e eVar, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        G(eVar, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void I(androidx.compose.ui.e eVar, final String str, final UA2 ua2, final UA2 ua22, final boolean z, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        androidx.compose.ui.e eVar2;
        int i3;
        InterfaceC22053ub1 interfaceC22053ub12;
        androidx.compose.ui.focus.m mVar;
        AbstractC13042fc3.i(str, "textFieldValue");
        AbstractC13042fc3.i(ua2, "onValueChanged");
        AbstractC13042fc3.i(ua22, "onDraft");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1559600566);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            eVar2 = eVar;
        } else if ((i & 6) == 0) {
            eVar2 = eVar;
            i3 = (interfaceC22053ub1J.V(eVar2) ? 4 : 2) | i;
        } else {
            eVar2 = eVar;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(str) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
        } else if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.D(ua22) ? 2048 : 1024;
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            i3 |= interfaceC22053ub1J.a(z) ? 16384 : 8192;
        }
        if ((i3 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            androidx.compose.ui.e eVar3 = i4 != 0 ? androidx.compose.ui.e.a : eVar2;
            final JV0 jv0 = (JV0) interfaceC22053ub1J.H(AbstractC13040fc1.e());
            interfaceC22053ub1J.W(127742750);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new androidx.compose.ui.focus.m();
                interfaceC22053ub1J.s(objB);
            }
            androidx.compose.ui.focus.m mVar2 = (androidx.compose.ui.focus.m) objB;
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(eVar3, C17784nZ1.q(16));
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarI);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            String strC = UY6.c(SD5.story_text_story_fragment_description, interfaceC22053ub1J, 0);
            C9348Zn7 c9348Zn7B = G10.a.d(interfaceC22053ub1J, G10.b).b();
            AbstractC9339Zm7.b(strC, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7B.b((16744447 & 1) != 0 ? c9348Zn7B.a.g() : WX0.a(GA5.n300, interfaceC22053ub1J, 0), (16744447 & 2) != 0 ? c9348Zn7B.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7B.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7B.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7B.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7B.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7B.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7B.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7B.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7B.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7B.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7B.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7B.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7B.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7B.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7B.b.h() : 0, (16744447 & 65536) != 0 ? c9348Zn7B.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7B.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7B.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7B.c : null, (16744447 & 1048576) != 0 ? c9348Zn7B.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7B.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7B.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7B.b.k() : null), interfaceC22053ub1J, 0, 0, 65534);
            ZH6.a(androidx.compose.foundation.layout.t.i(eVar3, C17784nZ1.q(12)), interfaceC22053ub1J, 0);
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(eVar3, 0.0f, 1, null);
            interfaceC22053ub1J.W(349690488);
            boolean zD = interfaceC22053ub1J.D(jv0);
            Object objB2 = interfaceC22053ub1J.B();
            if (zD || objB2 == aVar.a()) {
                objB2 = new SA2() { // from class: ir.nasim.dk
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC19664qk.J(jv0);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            SA2 sa2 = (SA2) objB2;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(349689079);
            Object objB3 = interfaceC22053ub1J.B();
            if (objB3 == aVar.a()) {
                objB3 = new SA2() { // from class: ir.nasim.ek
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC19664qk.K();
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarA = androidx.compose.ui.focus.n.a(androidx.compose.foundation.e.i(eVarH, (WKSRecord.Service.SUNRPC & 1) != 0, (WKSRecord.Service.SUNRPC & 2) != 0 ? null : null, (WKSRecord.Service.SUNRPC & 4) != 0 ? null : null, (WKSRecord.Service.SUNRPC & 8) != 0 ? null : null, (WKSRecord.Service.SUNRPC & 16) != 0 ? null : sa2, (WKSRecord.Service.SUNRPC & 32) != 0 ? null : null, (WKSRecord.Service.SUNRPC & 64) != 0, (SA2) objB3), mVar2);
            String strC2 = UY6.c(SD5.story_text_story, interfaceC22053ub1J, 0);
            String strC3 = UY6.c(SD5.story_text_story_hint, interfaceC22053ub1J, 0);
            interfaceC22053ub1J.W(349711636);
            AbstractC14472hy4 aVar3 = z ? new AbstractC14472hy4.a(Integer.valueOf(AbstractC23008wB5.danger), UY6.c(SD5.story_text_story_error_message, interfaceC22053ub1J, 0), 280) : new AbstractC14472hy4.d(null, "", 280, 1, null);
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(349700047);
            boolean z2 = ((i3 & 896) == 256) | ((i3 & 7168) == 2048);
            Object objB4 = interfaceC22053ub1J.B();
            if (z2 || objB4 == aVar.a()) {
                objB4 = new UA2() { // from class: ir.nasim.fk
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC19664qk.L(ua2, ua22, (String) obj);
                    }
                };
                interfaceC22053ub1J.s(objB4);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVar4 = eVar3;
            AbstractC8426Vx4.e0(str, (UA2) objB4, strC2, strC3, eVarA, null, false, false, null, null, aVar3, null, null, false, 6, 0, null, null, false, false, "AFKAR_TEXT_FIELD_TAG", false, interfaceC22053ub1J, (i3 >> 3) & 14, AbstractC14472hy4.a | 24576, 6, 3128288);
            interfaceC22053ub12 = interfaceC22053ub1J;
            interfaceC22053ub12.W(349727017);
            Object objB5 = interfaceC22053ub12.B();
            if (objB5 == aVar.a()) {
                mVar = mVar2;
                objB5 = new a(mVar, null);
                interfaceC22053ub12.s(objB5);
            } else {
                mVar = mVar2;
            }
            interfaceC22053ub12.Q();
            AbstractC10721c52.e(mVar, (InterfaceC14603iB2) objB5, interfaceC22053ub12, 6);
            interfaceC22053ub12.u();
            eVar2 = eVar4;
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            final androidx.compose.ui.e eVar5 = eVar2;
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.gk
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19664qk.M(eVar5, str, ua2, ua22, z, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 J(JV0 jv0) {
        AbstractC13042fc3.i(jv0, "$clipboardManager");
        C13245fu c13245fuA = jv0.a();
        if (c13245fuA != null) {
            jv0.b(c13245fuA);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 K() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 L(UA2 ua2, UA2 ua22, String str) {
        AbstractC13042fc3.i(ua2, "$onValueChanged");
        AbstractC13042fc3.i(ua22, "$onDraft");
        AbstractC13042fc3.i(str, "newValue");
        if (str.length() <= 280) {
            ua2.invoke(str);
            ua22.invoke(str);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 M(androidx.compose.ui.e eVar, String str, UA2 ua2, UA2 ua22, boolean z, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(str, "$textFieldValue");
        AbstractC13042fc3.i(ua2, "$onValueChanged");
        AbstractC13042fc3.i(ua22, "$onDraft");
        I(eVar, str, ua2, ua22, z, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void N(androidx.compose.ui.e r18, final ir.nasim.SA2 r19, final ir.nasim.UA2 r20, final java.lang.String r21, final boolean r22, final ir.nasim.UA2 r23, ir.nasim.InterfaceC22053ub1 r24, final int r25, final int r26) {
        /*
            Method dump skipped, instructions count: 497
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC19664qk.N(androidx.compose.ui.e, ir.nasim.SA2, ir.nasim.UA2, java.lang.String, boolean, ir.nasim.UA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 O(UA2 ua2, String str) {
        AbstractC13042fc3.i(ua2, "$onValueChanged");
        AbstractC13042fc3.i(str, "newValue");
        ua2.invoke(str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 P(UA2 ua2, String str) {
        AbstractC13042fc3.i(ua2, "$onDraft");
        AbstractC13042fc3.i(str, "draftText");
        ua2.invoke(str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Q(androidx.compose.ui.e eVar, SA2 sa2, UA2 ua2, String str, boolean z, UA2 ua22, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(sa2, "$onBackPressed");
        AbstractC13042fc3.i(ua2, "$onDraft");
        AbstractC13042fc3.i(str, "$textFieldValue");
        AbstractC13042fc3.i(ua22, "$onValueChanged");
        N(eVar, sa2, ua2, str, z, ua22, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void s(androidx.compose.ui.e eVar, final UA2 ua2, final String str, final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        androidx.compose.ui.e eVar2;
        int i3;
        final androidx.compose.ui.e eVar3;
        AbstractC13042fc3.i(ua2, "onConfirmClick");
        AbstractC13042fc3.i(str, "textFieldValue");
        AbstractC13042fc3.i(sa2, "clearStoryText");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-878144767);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            eVar2 = eVar;
        } else if ((i & 6) == 0) {
            eVar2 = eVar;
            i3 = (interfaceC22053ub1J.V(eVar2) ? 4 : 2) | i;
        } else {
            eVar2 = eVar;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.V(str) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
        } else if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.D(sa2) ? 2048 : 1024;
        }
        int i5 = i3;
        if ((i5 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar3 = eVar2;
        } else {
            androidx.compose.ui.e eVar4 = i4 != 0 ? androidx.compose.ui.e.a : eVar2;
            e.a aVar = androidx.compose.ui.e.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            androidx.compose.ui.e eVar5 = eVar4;
            AbstractC9758aW1.a(null, 0L, 0.0f, 0.0f, interfaceC22053ub1J, 0, 15);
            ZH6.a(androidx.compose.foundation.layout.t.i(eVar5, C17784nZ1.q(16)), interfaceC22053ub1J, 0);
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(eVar5, 0.0f, 1, null), C17784nZ1.q(54));
            String strC = UY6.c(SD5.story_text_story_fragment_send, interfaceC22053ub1J, 0);
            InterfaceC19114po0 interfaceC19114po0 = str.length() > 0 ? OA2.b.C0545b.c : OA2.b.a.c;
            interfaceC22053ub1J.W(-1938365549);
            boolean z = ((i5 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32) | ((i5 & 896) == 256) | ((i5 & 7168) == 2048);
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.bk
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC19664qk.t(ua2, str, sa2);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            eVar3 = eVar5;
            AbstractC17932no0.A((SA2) objB, interfaceC19114po0, strC, eVarI, null, "AFKAR_DONE_BTN_TAG", interfaceC22053ub1J, (OA2.b.b << 3) | 221184, 0);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.ck
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19664qk.u(eVar3, ua2, str, sa2, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(UA2 ua2, String str, SA2 sa2) {
        AbstractC13042fc3.i(ua2, "$onConfirmClick");
        AbstractC13042fc3.i(str, "$textFieldValue");
        AbstractC13042fc3.i(sa2, "$clearStoryText");
        ua2.invoke(str);
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(androidx.compose.ui.e eVar, UA2 ua2, String str, SA2 sa2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(ua2, "$onConfirmClick");
        AbstractC13042fc3.i(str, "$textFieldValue");
        AbstractC13042fc3.i(sa2, "$clearStoryText");
        s(eVar, ua2, str, sa2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void v(androidx.compose.ui.e r25, ir.nasim.UA2 r26, ir.nasim.UA2 r27, java.lang.String r28, ir.nasim.SA2 r29, ir.nasim.SA2 r30, ir.nasim.InterfaceC22053ub1 r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 787
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC19664qk.v(androidx.compose.ui.e, ir.nasim.UA2, ir.nasim.UA2, java.lang.String, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.ub1, int, int):void");
    }

    private static final String w(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (String) interfaceC9102Ym4.getValue();
    }

    private static final void x(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
        interfaceC9102Ym4.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y(UA2 ua2, String str) {
        AbstractC13042fc3.i(str, "it");
        ua2.invoke(str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$textFieldValue$delegate");
        AbstractC13042fc3.i(str, "newValue");
        x(interfaceC9102Ym4, str);
        return C19938rB7.a;
    }
}
