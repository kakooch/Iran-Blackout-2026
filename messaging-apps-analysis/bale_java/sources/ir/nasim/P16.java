package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.AbstractC14472hy4;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.P16;

/* loaded from: classes4.dex */
public abstract class P16 {

    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ String a;
        final /* synthetic */ int b;
        final /* synthetic */ UA2 c;

        a(String str, int i, UA2 ua2) {
            this.a = str;
            this.b = i;
            this.c = ua2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AbstractC14472hy4 d(String str, int i, Context context) {
            AbstractC13042fc3.i(str, "$comment");
            AbstractC13042fc3.i(context, "$context");
            return str.length() <= i ? new AbstractC14472hy4.c(null, "", Integer.valueOf(i)) : new AbstractC14472hy4.a(Integer.valueOf(AbstractC24188yB5.danger), context.getString(UD5.review_comment_max_len_error), Integer.valueOf(i));
        }

        private static final AbstractC14472hy4 f(InterfaceC9664aL6 interfaceC9664aL6) {
            return (AbstractC14472hy4) interfaceC9664aL6.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(int i, UA2 ua2, String str) {
            AbstractC13042fc3.i(ua2, "$onCommentChange");
            AbstractC13042fc3.i(str, "it");
            if (str.length() <= i) {
                ua2.invoke(str);
            }
            return C19938rB7.a;
        }

        public final void c(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC22821vt, "$this$AnimatedVisibility");
            final Context context = (Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g());
            interfaceC22053ub1.W(-646310047);
            boolean zV = interfaceC22053ub1.V(this.a);
            final String str = this.a;
            final int i2 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = AbstractC10222bH6.d(new SA2() { // from class: ir.nasim.N16
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return P16.a.d(str, i2, context);
                    }
                });
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null);
            String strC = UY6.c(UD5.review_comment_label, interfaceC22053ub1, 0);
            String strC2 = UY6.c(UD5.review_comment_placeholder, interfaceC22053ub1, 0);
            AbstractC14472hy4 abstractC14472hy4F = f((InterfaceC9664aL6) objB);
            InterfaceC7614Sl7 interfaceC7614Sl7A = AbstractC19798qx4.a(G10.a.a(interfaceC22053ub1, 6).M(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, interfaceC22053ub1, 0, 0, 4094);
            String str2 = this.a;
            interfaceC22053ub1.W(-646283750);
            boolean zE = interfaceC22053ub1.e(this.b) | interfaceC22053ub1.V(this.c);
            final int i3 = this.b;
            final UA2 ua2 = this.c;
            Object objB2 = interfaceC22053ub1.B();
            if (zE || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.O16
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return P16.a.h(i3, ua2, (String) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC8426Vx4.e0(str2, (UA2) objB2, strC, strC2, eVarH, null, false, false, null, null, abstractC14472hy4F, null, null, false, 3, 3, null, interfaceC7614Sl7A, false, false, null, false, interfaceC22053ub1, 24576, 224256, 0, 4004832);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ InterfaceC9664aL6 c;

        b(SA2 sa2, SA2 sa22, InterfaceC9664aL6 interfaceC9664aL6) {
            this.a = sa2;
            this.b = sa22;
            this.c = interfaceC9664aL6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(aVar, g10.c(interfaceC22053ub1, 6).b().e(), g10.c(interfaceC22053ub1, 6).b().e());
            C24254yJ.f fVarO = C24254yJ.a.o(g10.c(interfaceC22053ub1, 6).b().e());
            InterfaceC12529em.c cVarI = InterfaceC12529em.a.i();
            SA2 sa2 = this.a;
            SA2 sa22 = this.b;
            InterfaceC9664aL6 interfaceC9664aL6 = this.c;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(fVarO, cVarI, interfaceC22053ub1, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarJ);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            M66 m66 = M66.a;
            AbstractC17932no0.A(sa2, InterfaceC19114po0.b.C1454b.a, UY6.c(UD5.review_cancel_button, interfaceC22053ub1, 0), L66.b(m66, aVar, 1.0f, false, 2, null), null, null, interfaceC22053ub1, 48, 48);
            AbstractC17932no0.A(sa22, P16.j(interfaceC9664aL6) ? InterfaceC19114po0.b.a.a : InterfaceC19114po0.a.C1453a.a, UY6.c(UD5.review_submit_button, interfaceC22053ub1, 0), L66.b(m66, aVar, 1.0f, false, 2, null), null, null, interfaceC22053ub1, 0, 48);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class c implements InterfaceC15796kB2 {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ int c;
        final /* synthetic */ InterfaceC17916nm4 d;
        final /* synthetic */ InterfaceC9102Ym4 e;
        final /* synthetic */ InterfaceC14603iB2 f;
        final /* synthetic */ InterfaceC14603iB2 g;

        c(String str, String str2, int i, InterfaceC17916nm4 interfaceC17916nm4, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22) {
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = interfaceC17916nm4;
            this.e = interfaceC9102Ym4;
            this.f = interfaceC14603iB2;
            this.g = interfaceC14603iB22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(InterfaceC17916nm4 interfaceC17916nm4, int i) {
            AbstractC13042fc3.i(interfaceC17916nm4, "$rating$delegate");
            P16.q(interfaceC17916nm4, i);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$comment$delegate");
            AbstractC13042fc3.i(str, "it");
            P16.t(interfaceC9102Ym4, str);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 k(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC17916nm4 interfaceC17916nm4, InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(interfaceC14603iB2, "$onSubmitReview");
            AbstractC13042fc3.i(interfaceC17916nm4, "$rating$delegate");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$comment$delegate");
            if (P16.p(interfaceC17916nm4) > 0) {
                interfaceC14603iB2.invoke(Integer.valueOf(P16.p(interfaceC17916nm4)), P16.s(interfaceC9102Ym4));
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 n(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC17916nm4 interfaceC17916nm4, InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(interfaceC14603iB2, "$onDismiss");
            AbstractC13042fc3.i(interfaceC17916nm4, "$rating$delegate");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$comment$delegate");
            interfaceC14603iB2.invoke(Integer.valueOf(P16.p(interfaceC17916nm4)), P16.s(interfaceC9102Ym4));
            return C19938rB7.a;
        }

        public final void f(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(zy0, "$this$ModalBottomSheet");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            int iP = P16.p(this.d);
            String strS = P16.s(this.e);
            String str = this.a;
            String str2 = this.b;
            int i2 = this.c;
            interfaceC22053ub1.W(80873762);
            boolean zV = interfaceC22053ub1.V(this.d);
            final InterfaceC17916nm4 interfaceC17916nm4 = this.d;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.Q16
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return P16.c.h(interfaceC17916nm4, ((Integer) obj).intValue());
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            UA2 ua2 = (UA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(80875267);
            boolean zV2 = interfaceC22053ub1.V(this.e);
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.e;
            Object objB2 = interfaceC22053ub1.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.R16
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return P16.c.i(interfaceC9102Ym4, (String) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            UA2 ua22 = (UA2) objB2;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(80876642);
            boolean zV3 = interfaceC22053ub1.V(this.d) | interfaceC22053ub1.V(this.f) | interfaceC22053ub1.V(this.e);
            final InterfaceC14603iB2 interfaceC14603iB2 = this.f;
            final InterfaceC17916nm4 interfaceC17916nm42 = this.d;
            final InterfaceC9102Ym4 interfaceC9102Ym42 = this.e;
            Object objB3 = interfaceC22053ub1.B();
            if (zV3 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new SA2() { // from class: ir.nasim.S16
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return P16.c.k(interfaceC14603iB2, interfaceC17916nm42, interfaceC9102Ym42);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            SA2 sa2 = (SA2) objB3;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(80879953);
            boolean zV4 = interfaceC22053ub1.V(this.g) | interfaceC22053ub1.V(this.d) | interfaceC22053ub1.V(this.e);
            final InterfaceC14603iB2 interfaceC14603iB22 = this.g;
            final InterfaceC17916nm4 interfaceC17916nm43 = this.d;
            final InterfaceC9102Ym4 interfaceC9102Ym43 = this.e;
            Object objB4 = interfaceC22053ub1.B();
            if (zV4 || objB4 == InterfaceC22053ub1.a.a()) {
                objB4 = new SA2() { // from class: ir.nasim.T16
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return P16.c.n(interfaceC14603iB22, interfaceC17916nm43, interfaceC9102Ym43);
                    }
                };
                interfaceC22053ub1.s(objB4);
            }
            interfaceC22053ub1.Q();
            P16.h(str, iP, str2, strS, i2, ua2, ua22, sa2, (SA2) objB4, null, interfaceC22053ub1, 0, 512);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            f((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(final String str, final int i, final String str2, final String str3, final int i2, final UA2 ua2, final UA2 ua22, final SA2 sa2, final SA2 sa22, androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, final int i3, final int i4) {
        int i5;
        androidx.compose.ui.e eVar2;
        InterfaceC22053ub1 interfaceC22053ub12;
        final androidx.compose.ui.e eVar3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-472734365);
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= interfaceC22053ub1J.e(i) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else if ((i3 & 384) == 0) {
            i5 |= interfaceC22053ub1J.V(str2) ? 256 : 128;
        }
        if ((i4 & 8) != 0) {
            i5 |= SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
        } else if ((i3 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i5 |= interfaceC22053ub1J.V(str3) ? 2048 : 1024;
        }
        if ((i4 & 16) != 0) {
            i5 |= 24576;
        } else if ((i3 & 24576) == 0) {
            i5 |= interfaceC22053ub1J.e(i2) ? 16384 : 8192;
        }
        if ((i4 & 32) != 0) {
            i5 |= 196608;
        } else if ((i3 & 196608) == 0) {
            i5 |= interfaceC22053ub1J.D(ua2) ? 131072 : 65536;
        }
        if ((i4 & 64) != 0) {
            i5 |= 1572864;
        } else if ((i3 & 1572864) == 0) {
            i5 |= interfaceC22053ub1J.D(ua22) ? 1048576 : 524288;
        }
        if ((i4 & 128) != 0) {
            i5 |= 12582912;
        } else if ((i3 & 12582912) == 0) {
            i5 |= interfaceC22053ub1J.D(sa2) ? 8388608 : 4194304;
        }
        if ((i4 & 256) != 0) {
            i5 |= 100663296;
        } else if ((i3 & 100663296) == 0) {
            i5 |= interfaceC22053ub1J.D(sa22) ? 67108864 : 33554432;
        }
        int i6 = i4 & 512;
        if (i6 != 0) {
            i5 |= 805306368;
            eVar2 = eVar;
        } else {
            eVar2 = eVar;
            if ((i3 & 805306368) == 0) {
                i5 |= interfaceC22053ub1J.V(eVar2) ? 536870912 : 268435456;
            }
        }
        if ((i5 & 306783379) == 306783378 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
            eVar3 = eVar2;
        } else {
            if (i6 != 0) {
                eVar2 = androidx.compose.ui.e.a;
            }
            interfaceC22053ub1J.W(-937599805);
            boolean z = (i5 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = AbstractC10222bH6.d(new SA2() { // from class: ir.nasim.K16
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return Boolean.valueOf(P16.i(i));
                    }
                });
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC9664aL6 interfaceC9664aL6 = (InterfaceC9664aL6) objB;
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarG = AbstractC8014Ud6.g(androidx.compose.foundation.layout.t.h(eVar2, 0.0f, 1, null), AbstractC8014Ud6.c(0, interfaceC22053ub1J, 0, 1), false, null, false, 14, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.g(), interfaceC22053ub1J, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarG);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            e.a aVar2 = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            androidx.compose.ui.e eVar4 = eVar2;
            AbstractC9339Zm7.b(str, androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.q.k(aVar2, g10.c(interfaceC22053ub1J, 6).b().e(), 0.0f, 2, null), 0.0f, g10.c(interfaceC22053ub1J, 6).b().b(), 0.0f, g10.c(interfaceC22053ub1J, 6).b().e(), 5, null), 0.0f, 1, null), g10.a(interfaceC22053ub1J, 6).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, 6).l(), interfaceC22053ub1J, i5 & 14, 0, 65016);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            AbstractC9339Zm7.b(str2, androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.j(aVar2, g10.c(interfaceC22053ub1J, 6).b().e(), g10.c(interfaceC22053ub1J, 6).b().c()), 0.0f, 1, null), g10.a(interfaceC22053ub1J, 6).D(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, 6).b(), interfaceC22053ub1J, (i5 >> 6) & 14, 0, 65528);
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.q.k(aVar2, g10.c(interfaceC22053ub1J, 6).b().c(), 0.0f, 2, null), 0.0f, g10.c(interfaceC22053ub1J, 6).b().c(), 0.0f, g10.c(interfaceC22053ub1J, 6).b().j(), 5, null), 0.0f, 1, null);
            interfaceC22053ub1J.W(-291774234);
            boolean z2 = (458752 & i5) == 131072;
            Object objB2 = interfaceC22053ub1J.B();
            if (z2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.L16
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return P16.k(ua2, ((Integer) obj).intValue());
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            AbstractC22308v10.t(i, (UA2) objB2, eVarH, 0, 0.0f, 0L, 0L, false, interfaceC22053ub1J, (i5 >> 3) & 14, 248);
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC22231ut.d(c9784aZ0, j(interfaceC9664aL6), androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.q.k(aVar2, g10.c(interfaceC22053ub12, 6).b().e(), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, g10.c(interfaceC22053ub12, 6).b().c(), 7, null), androidx.compose.animation.f.m(null, null, false, null, 15, null).c(androidx.compose.animation.f.o(null, 0.0f, 3, null)), androidx.compose.animation.f.y(null, null, false, null, 15, null).c(androidx.compose.animation.f.q(null, 0.0f, 3, null)), null, AbstractC19242q11.e(-249455823, true, new a(str3, i2, ua22), interfaceC22053ub12, 54), interfaceC22053ub12, 1600518, 16);
            MY2.b(null, null, 0L, interfaceC22053ub12, 0, 7);
            AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(-2054379239, true, new b(sa22, sa2, interfaceC9664aL6), interfaceC22053ub12, 54), interfaceC22053ub12, C7252Qx5.i | 48);
            interfaceC22053ub12.u();
            eVar3 = eVar4;
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.M16
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return P16.l(str, i, str2, str3, i2, ua2, ua22, sa2, sa22, eVar3, i3, i4, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(int i) {
        return i > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(UA2 ua2, int i) {
        AbstractC13042fc3.i(ua2, "$onRatingChange");
        ua2.invoke(Integer.valueOf(i));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(String str, int i, String str2, String str3, int i2, UA2 ua2, UA2 ua22, SA2 sa2, SA2 sa22, androidx.compose.ui.e eVar, int i3, int i4, InterfaceC22053ub1 interfaceC22053ub1, int i5) {
        AbstractC13042fc3.i(str, "$title");
        AbstractC13042fc3.i(str2, "$description");
        AbstractC13042fc3.i(str3, "$comment");
        AbstractC13042fc3.i(ua2, "$onRatingChange");
        AbstractC13042fc3.i(ua22, "$onCommentChange");
        AbstractC13042fc3.i(sa2, "$onSubmit");
        AbstractC13042fc3.i(sa22, "$onDismiss");
        h(str, i, str2, str3, i2, ua2, ua22, sa2, sa22, eVar, interfaceC22053ub1, QJ5.a(i3 | 1), i4);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m(final java.lang.String r39, final java.lang.String r40, final ir.nasim.InterfaceC14603iB2 r41, final ir.nasim.InterfaceC14603iB2 r42, androidx.compose.ui.e r43, ir.nasim.C19818qz6 r44, int r45, java.lang.String r46, int r47, ir.nasim.InterfaceC22053ub1 r48, final int r49, final int r50) {
        /*
            Method dump skipped, instructions count: 755
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.P16.m(java.lang.String, java.lang.String, ir.nasim.iB2, ir.nasim.iB2, androidx.compose.ui.e, ir.nasim.qz6, int, java.lang.String, int, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC17916nm4 n(int i) {
        return UG6.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(String str, String str2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, androidx.compose.ui.e eVar, C19818qz6 c19818qz6, int i, String str3, int i2, int i3, int i4, InterfaceC22053ub1 interfaceC22053ub1, int i5) {
        AbstractC13042fc3.i(str, "$title");
        AbstractC13042fc3.i(str2, "$description");
        AbstractC13042fc3.i(interfaceC14603iB2, "$onDismiss");
        AbstractC13042fc3.i(interfaceC14603iB22, "$onSubmitReview");
        m(str, str2, interfaceC14603iB2, interfaceC14603iB22, eVar, c19818qz6, i, str3, i2, interfaceC22053ub1, QJ5.a(i3 | 1), i4);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p(InterfaceC17916nm4 interfaceC17916nm4) {
        return interfaceC17916nm4.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(InterfaceC17916nm4 interfaceC17916nm4, int i) {
        interfaceC17916nm4.h(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC9102Ym4 r(String str) {
        return AbstractC13472gH6.d(str, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String s(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (String) interfaceC9102Ym4.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
        interfaceC9102Ym4.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC17916nm4 interfaceC17916nm4, InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$onDismiss");
        AbstractC13042fc3.i(interfaceC17916nm4, "$rating$delegate");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$comment$delegate");
        interfaceC14603iB2.invoke(Integer.valueOf(p(interfaceC17916nm4)), s(interfaceC9102Ym4));
        return C19938rB7.a;
    }
}
