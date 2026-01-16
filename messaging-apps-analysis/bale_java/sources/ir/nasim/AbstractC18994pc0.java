package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.content.res.Configuration;
import android.gov.nist.core.Separators;
import android.os.Build;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC18994pc0;
import ir.nasim.C24254yJ;
import ir.nasim.D20;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.Z20;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.pc0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC18994pc0 {

    /* renamed from: ir.nasim.pc0$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ C3727Cc0 c;
        final /* synthetic */ UA2 d;
        final /* synthetic */ SA2 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ SA2 g;
        final /* synthetic */ UA2 h;

        a(androidx.compose.ui.e eVar, SA2 sa2, C3727Cc0 c3727Cc0, UA2 ua2, SA2 sa22, boolean z, SA2 sa23, UA2 ua22) {
            this.a = eVar;
            this.b = sa2;
            this.c = c3727Cc0;
            this.d = ua2;
            this.e = sa22;
            this.f = z;
            this.g = sa23;
            this.h = ua22;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            UA2 ua2;
            e.a aVar;
            C3727Cc0 c3727Cc0;
            int i2;
            G10 g10;
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(this.a, 0.0f, 1, null);
            G10 g102 = G10.a;
            int i3 = G10.b;
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.foundation.b.d(eVarH, g102.a(interfaceC22053ub1, i3).q(), null, 2, null), g102.c(interfaceC22053ub1, i3).b().j(), g102.c(interfaceC22053ub1, i3).b().c());
            C24254yJ c24254yJ = C24254yJ.a;
            C24254yJ.f fVarB = c24254yJ.b();
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC12529em.b bVarG = aVar2.g();
            SA2 sa2 = this.b;
            C3727Cc0 c3727Cc02 = this.c;
            UA2 ua22 = this.d;
            androidx.compose.ui.e eVar = this.a;
            SA2 sa22 = this.e;
            boolean z = this.f;
            SA2 sa23 = this.g;
            UA2 ua23 = this.h;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(fVarB, bVarG, interfaceC22053ub1, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarJ);
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
            int i4 = ((Configuration) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.f())).screenWidthDp;
            e.a aVar4 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarA = androidx.compose.foundation.layout.t.A(aVar4, C17784nZ1.q(i4 / 2), 0.0f, 2, null);
            interfaceC22053ub1.W(-1125560294);
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = AbstractC23831xb3.a();
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarD = androidx.compose.foundation.e.d(eVarA, (InterfaceC18507om4) objB, null, false, null, null, sa2, 28, null);
            InterfaceC10970cW3 interfaceC10970cW3A2 = XY0.a(c24254yJ.b(), aVar2.g(), interfaceC22053ub1, 54);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD);
            SA2 sa2A2 = aVar3.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A2);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A2, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            AbstractC18994pc0.N0(c3727Cc02.c(), c3727Cc02.e(), c3727Cc02.d(), sa2, null, interfaceC22053ub1, 0, 16);
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar4, g102.c(interfaceC22053ub1, i3).b().r()), interfaceC22053ub1, 0);
            if (C8386Vt0.U7()) {
                interfaceC22053ub1.W(596704333);
                AbstractC18994pc0.Q0(eVar, c3727Cc02.e(), c3727Cc02.g(), sa22, z, sa23, ua23, interfaceC22053ub1, 0, 0);
                interfaceC22053ub1.Q();
                c3727Cc0 = c3727Cc02;
                i2 = i3;
                aVar = aVar4;
                g10 = g102;
                ua2 = ua22;
            } else {
                interfaceC22053ub1.W(597245531);
                ua2 = ua22;
                aVar = aVar4;
                c3727Cc0 = c3727Cc02;
                i2 = i3;
                g10 = g102;
                AbstractC9339Zm7.b(c3727Cc02.e(), null, g102.a(interfaceC22053ub1, i3).G(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, g102.d(interfaceC22053ub1, i3).n(), interfaceC22053ub1, 0, 0, 65018);
                interfaceC22053ub1.Q();
            }
            interfaceC22053ub1.u();
            int i5 = i2;
            G10 g103 = g10;
            e.a aVar5 = aVar;
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar5, g103.c(interfaceC22053ub1, i5).b().u()), interfaceC22053ub1, 0);
            AbstractC18994pc0.X0(c3727Cc0.h(), c3727Cc0.f(), ua2, null, interfaceC22053ub1, 0, 8);
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar5, g103.c(interfaceC22053ub1, i5).b().r()), interfaceC22053ub1, 0);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.pc0$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C19391qG6 c;
        final /* synthetic */ String d;
        final /* synthetic */ InterfaceC9664aL6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C19391qG6 c19391qG6, String str, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c19391qG6;
            this.d = str;
            this.e = interfaceC9664aL6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C19391qG6 c19391qG6 = this.c;
                String str = this.d;
                this.b = 1;
                if (C19391qG6.f(c19391qG6, str, null, false, null, this, 14, null) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            AbstractC18994pc0.U(this.e).invoke();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.pc0$c */
    static final class c implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ InterfaceC9664aL6 b;
        final /* synthetic */ UA2 c;

        /* renamed from: ir.nasim.pc0$c$a */
        static final class a implements InterfaceC15796kB2 {
            final /* synthetic */ InterfaceC9664aL6 a;
            final /* synthetic */ UA2 b;

            a(InterfaceC9664aL6 interfaceC9664aL6, UA2 ua2) {
                this.a = interfaceC9664aL6;
                this.b = ua2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(InterfaceC11943do6 interfaceC11943do6) {
                AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
                AbstractC9939ao6.F0(interfaceC11943do6, 2.0f);
                return C19938rB7.a;
            }

            public final void b(L66 l66, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(l66, "$this$BaleTopAppbar");
                if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                e.a aVar = androidx.compose.ui.e.a;
                interfaceC22053ub1.W(1861351348);
                Object objB = interfaceC22053ub1.B();
                if (objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.qc0
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC18994pc0.c.a.c((InterfaceC11943do6) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC18994pc0.k0(((C3254Ac0) this.a.getValue()).k(), this.b, !((C3254Ac0) this.a.getValue()).o(), androidx.compose.foundation.layout.q.m(AbstractC6919Pn6.d(aVar, false, (UA2) objB, 1, null), 0.0f, 0.0f, G10.a.c(interfaceC22053ub1, G10.b).b().n(), 0.0f, 11, null), interfaceC22053ub1, 0, 0);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                b((L66) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        c(SA2 sa2, InterfaceC9664aL6 interfaceC9664aL6, UA2 ua2) {
            this.a = sa2;
            this.b = interfaceC9664aL6;
            this.c = ua2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC21639ts7.i(UY6.c(QD5.base_settings_title, interfaceC22053ub1, 0), null, this.a, AbstractC19242q11.e(907752961, true, new a(this.b, this.c), interfaceC22053ub1, 54), null, null, null, interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 114);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.pc0$d */
    static final class d implements InterfaceC14603iB2 {
        final /* synthetic */ C19391qG6 a;

        d(C19391qG6 c19391qG6) {
            this.a = c19391qG6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC18209oG6.b(this.a, null, L21.a.a(), interfaceC22053ub1, 390, 2);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.pc0$e */
    static final class e implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC9664aL6 a;
        final /* synthetic */ C22642vb0 b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ UA2 e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ InterfaceC9102Ym4 g;

        e(InterfaceC9664aL6 interfaceC9664aL6, C22642vb0 c22642vb0, UA2 ua2, SA2 sa2, UA2 ua22, SA2 sa22, InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = interfaceC9664aL6;
            this.b = c22642vb0;
            this.c = ua2;
            this.d = sa2;
            this.e = ua22;
            this.f = sa22;
            this.g = interfaceC9102Ym4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$showSwitchAccountBottomSheet$delegate");
            AbstractC18994pc0.Z(interfaceC9102Ym4, true);
            return C19938rB7.a;
        }

        public final void b(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(ts4, "paddingValues");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(ts4) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null), 0.0f, ts4.c(), 0.0f, 0.0f, 13, null);
            InterfaceC9664aL6 interfaceC9664aL6 = this.a;
            C22642vb0 c22642vb0 = this.b;
            UA2 ua2 = this.c;
            SA2 sa2 = this.d;
            UA2 ua22 = this.e;
            SA2 sa22 = this.f;
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.g;
            C24254yJ c24254yJ = C24254yJ.a;
            C24254yJ.m mVarH = c24254yJ.h();
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarH, aVar2.k(), interfaceC22053ub1, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarM);
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
            androidx.compose.ui.e eVarG = AbstractC8014Ud6.g(ZY0.b(C9784aZ0.a, androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null), 1.0f, false, 2, null), AbstractC8014Ud6.c(0, interfaceC22053ub1, 0, 1), false, null, false, 14, null);
            InterfaceC10970cW3 interfaceC10970cW3A2 = XY0.a(c24254yJ.h(), aVar2.k(), interfaceC22053ub1, 0);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarG);
            SA2 sa2A2 = aVar3.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A2);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A2, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            C3727Cc0 c3727Cc0L = ((C3254Ac0) interfaceC9664aL6.getValue()).l();
            SA2 sa2C = c22642vb0.c();
            interfaceC22053ub1.W(-1159824477);
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.rc0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC18994pc0.e.c(interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa23 = (SA2) objB;
            interfaceC22053ub1.Q();
            AbstractC18994pc0.R(c3727Cc0L, sa2C, sa23, null, ua2, C13923h3.a.o().size() == 1, sa2, ua22, interfaceC22053ub1, 384, 8);
            boolean zI = ((C3254Ac0) interfaceC9664aL6.getValue()).i();
            String strM = ((C3254Ac0) interfaceC9664aL6.getValue()).m();
            boolean zH = ((C3254Ac0) interfaceC9664aL6.getValue()).h();
            PI0 pi0E = ((C3254Ac0) interfaceC9664aL6.getValue()).e();
            String strC = ((C3254Ac0) interfaceC9664aL6.getValue()).c();
            String strD = ((C3254Ac0) interfaceC9664aL6.getValue()).d();
            AbstractC12129e53 abstractC12129e53F = ((C3254Ac0) interfaceC9664aL6.getValue()).f();
            boolean zN = ((C3254Ac0) interfaceC9664aL6.getValue()).n();
            long jG = ((C3254Ac0) interfaceC9664aL6.getValue()).g();
            int i3 = AbstractC12129e53.a;
            AbstractC18994pc0.H0(c22642vb0, strM, zH, zI, pi0E, abstractC12129e53F, zN, jG, strD, strC, ua2, sa22, null, interfaceC22053ub1, i3 << 15, 0, 4096);
            interfaceC22053ub1.u();
            S43.w(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), ((C3254Ac0) interfaceC9664aL6.getValue()).f(), c22642vb0.b(), interfaceC22053ub1, (i3 << 3) | 6, 0);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.pc0$f */
    static final class f implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC9102Ym4 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ PI0 c;

        /* renamed from: ir.nasim.pc0$f$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ PI0 a;

            a(PI0 pi0) {
                this.a = pi0;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                String str;
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                C24254yJ c24254yJ = C24254yJ.a;
                G10 g10 = G10.a;
                int i2 = G10.b;
                C24254yJ.f fVarO = c24254yJ.o(g10.c(interfaceC22053ub1, i2).b().e());
                InterfaceC12529em.b bVarG = InterfaceC12529em.a.g();
                PI0 pi0 = this.a;
                e.a aVar = androidx.compose.ui.e.a;
                InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(fVarO, bVarG, interfaceC22053ub1, 48);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
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
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
                C9784aZ0 c9784aZ0 = C9784aZ0.a;
                AbstractC11456d23.b(FV4.c(AbstractC21822uB5.change_log, interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.t.i(aVar, C17784nZ1.q(72)), null, null, 0.0f, null, interfaceC22053ub1, 432, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
                String strC = UY6.c(QD5.new_version_changes, interfaceC22053ub1, 0);
                String strB = pi0.b();
                if (strB == null || AbstractC20762sZ6.n0(strB)) {
                    str = "";
                } else {
                    str = " (" + pi0.b() + Separators.RPAREN;
                }
                AbstractC9339Zm7.b(strC + str, null, g10.a(interfaceC22053ub1, i2).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).l(), interfaceC22053ub1, 0, 0, 65018);
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.pc0$f$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ PI0 a;

            /* renamed from: ir.nasim.pc0$f$b$a */
            public static final class a extends AbstractC8614Ws3 implements UA2 {
                public static final a e = new a();

                public a() {
                    super(1);
                }

                @Override // ir.nasim.UA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Void invoke(Object obj) {
                    return null;
                }
            }

            /* renamed from: ir.nasim.pc0$f$b$b, reason: collision with other inner class name */
            public static final class C1450b extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ UA2 e;
                final /* synthetic */ List f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C1450b(UA2 ua2, List list) {
                    super(1);
                    this.e = ua2;
                    this.f = list;
                }

                public final Object a(int i) {
                    return this.e.invoke(this.f.get(i));
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return a(((Number) obj).intValue());
                }
            }

            /* renamed from: ir.nasim.pc0$f$b$c */
            public static final class c extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
                final /* synthetic */ List e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public c(List list) {
                    super(4);
                    this.e = list;
                }

                public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                    int i3;
                    if ((i2 & 6) == 0) {
                        i3 = i2 | (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2);
                    } else {
                        i3 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
                    }
                    if (!interfaceC22053ub1.o((i3 & 147) != 146, 1 & i3)) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    if (AbstractC5138Ib1.I()) {
                        AbstractC5138Ib1.Q(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                    }
                    String str = (String) this.e.get(i);
                    interfaceC22053ub1.W(242393184);
                    C24254yJ c24254yJ = C24254yJ.a;
                    G10 g10 = G10.a;
                    int i4 = G10.b;
                    C24254yJ.f fVarO = c24254yJ.o(g10.c(interfaceC22053ub1, i4).b().u());
                    InterfaceC12529em.c cVarL = InterfaceC12529em.a.l();
                    e.a aVar = androidx.compose.ui.e.a;
                    InterfaceC10970cW3 interfaceC10970cW3B = J66.b(fVarO, cVarL, interfaceC22053ub1, 48);
                    int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                    InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                    androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
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
                    AbstractC9339Zm7.b("•", null, g10.a(interfaceC22053ub1, i4).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i4).b(), interfaceC22053ub1, 6, 0, 65530);
                    AbstractC9339Zm7.b(str, null, g10.a(interfaceC22053ub1, i4).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i4).b(), interfaceC22053ub1, 0, 0, 65530);
                    interfaceC22053ub1.u();
                    interfaceC22053ub1.Q();
                    if (AbstractC5138Ib1.I()) {
                        AbstractC5138Ib1.P();
                    }
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            b(PI0 pi0) {
                this.a = pi0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(List list, InterfaceC15069ix3 interfaceC15069ix3) {
                AbstractC13042fc3.i(list, "$changes");
                AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
                interfaceC15069ix3.a(list.size(), null, new C1450b(a.e, list), AbstractC19242q11.c(-632812321, true, new c(list)));
                return C19938rB7.a;
            }

            public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                int i2 = ((Configuration) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.f())).screenHeightDp;
                final List listA = this.a.a();
                if (listA == null) {
                    return;
                }
                androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.t.k(androidx.compose.ui.e.a, 0.0f, C17784nZ1.q((float) (i2 / 2.5d)), 1, null);
                C24254yJ.f fVarO = C24254yJ.a.o(G10.a.c(interfaceC22053ub1, G10.b).b().u());
                interfaceC22053ub1.W(-1287841561);
                boolean zD = interfaceC22053ub1.D(listA);
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.uc0
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC18994pc0.f.b.c(listA, (InterfaceC15069ix3) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC12623ev3.b(eVarK, null, null, false, fVarO, null, null, false, null, (UA2) objB, interfaceC22053ub1, 0, 494);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        f(InterfaceC9102Ym4 interfaceC9102Ym4, SA2 sa2, PI0 pi0) {
            this.a = interfaceC9102Ym4;
            this.b = sa2;
            this.c = pi0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(InterfaceC9102Ym4 interfaceC9102Ym4, SA2 sa2) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$isDialogVisible");
            AbstractC13042fc3.i(sa2, "$openDownloadWebPage");
            interfaceC9102Ym4.setValue(Boolean.FALSE);
            sa2.invoke();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$isDialogVisible");
            interfaceC9102Ym4.setValue(Boolean.FALSE);
            return C19938rB7.a;
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            AbstractC10289bP1.a.b bVar = AbstractC10289bP1.a.b.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            int i2 = QD5.update;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            int i3 = QD5.Cancel;
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(1819139533, true, new a(this.c), interfaceC22053ub1, 54);
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(-176163189, true, new b(this.c), interfaceC22053ub1, 54);
            interfaceC22053ub1.W(-584359873);
            boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.V(this.b);
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.a;
            final SA2 sa2 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.sc0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC18994pc0.f.d(interfaceC9102Ym4, sa2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa22 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-584355651);
            boolean zV2 = interfaceC22053ub1.V(this.a);
            final InterfaceC9102Ym4 interfaceC9102Ym42 = this.a;
            Object objB2 = interfaceC22053ub1.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.tc0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC18994pc0.f.f(interfaceC9102Ym42);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC18060o11E, cVar, interfaceC18060o11E2, bVar, aVar, sa22, i2, c1454b, (SA2) objB2, i3, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.b.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.pc0$g */
    static final class g implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ InterfaceC9102Ym4 b;

        g(SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = sa2;
            this.b = interfaceC9102Ym4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(sa2, "$logout");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$dialogVisible$delegate");
            AbstractC18994pc0.z0(interfaceC9102Ym4, false);
            sa2.invoke();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$dialogVisible$delegate");
            AbstractC18994pc0.z0(interfaceC9102Ym4, false);
            return C19938rB7.a;
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.c.a aVar = InterfaceC19114po0.c.a.a;
            int i2 = QD5.base_settings_logout_dialog_accept_button;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            int i3 = QD5.Cancel;
            L21 l21 = L21.a;
            InterfaceC14603iB2 interfaceC14603iB2C = l21.c();
            InterfaceC14603iB2 interfaceC14603iB2D = l21.d();
            interfaceC22053ub1.W(-1289891435);
            boolean zV = interfaceC22053ub1.V(this.a);
            final SA2 sa2 = this.a;
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.vc0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC18994pc0.g.d(sa2, interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa22 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1289887372);
            final InterfaceC9102Ym4 interfaceC9102Ym42 = this.b;
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.wc0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC18994pc0.g.f(interfaceC9102Ym42);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC14603iB2C, c0905b, interfaceC14603iB2D, cVar, aVar, sa22, i2, c1454b, (SA2) objB2, i3, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.C0905b.c << 3) | 100663686 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.c.a.b << 12), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.pc0$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC9102Ym4 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC9102Ym4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new h(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(300L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Z20 z20S0 = AbstractC18994pc0.S0(this.c);
            if (z20S0 != null) {
                Z20.a.a(z20S0, -290, 0, 2, null);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.pc0$i */
    static final class i implements InterfaceC15796kB2 {
        final /* synthetic */ boolean a;
        final /* synthetic */ androidx.compose.ui.e b;
        final /* synthetic */ InterfaceC18507om4 c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;

        i(boolean z, androidx.compose.ui.e eVar, InterfaceC18507om4 interfaceC18507om4, SA2 sa2, String str, String str2) {
            this.a = z;
            this.b = eVar;
            this.c = interfaceC18507om4;
            this.d = sa2;
            this.e = str;
            this.f = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final RLottieImageView d(Context context) {
            AbstractC13042fc3.i(context, "context");
            return new RLottieImageView(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(String str, RLottieImageView rLottieImageView) {
            AbstractC13042fc3.i(rLottieImageView, "it");
            rLottieImageView.setAnimationWithName(str, AbstractC22039uZ6.A1(str, 10));
            rLottieImageView.f();
            return C19938rB7.a;
        }

        public final void c(Z20 z20, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(z20, "it");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            interfaceC22053ub1.W(199522047);
            boolean zA = interfaceC22053ub1.a(this.a);
            boolean z = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zA || objB == InterfaceC22053ub1.a.a()) {
                objB = z ? AbstractC4616Fw7.a(Integer.valueOf(AbstractC24188yB5.plus), Integer.valueOf(QD5.base_settings_add_account_icon_content_des)) : AbstractC4616Fw7.a(Integer.valueOf(AbstractC24188yB5.simple_arrow_down), Integer.valueOf(QD5.base_settings_change_account_icon_content_des));
                interfaceC22053ub1.s(objB);
            }
            XV4 xv4 = (XV4) objB;
            interfaceC22053ub1.Q();
            int iIntValue = ((Number) xv4.a()).intValue();
            int iIntValue2 = ((Number) xv4.b()).intValue();
            C24254yJ.f fVarB = C24254yJ.a.b();
            InterfaceC12529em.c cVarI = InterfaceC12529em.a.i();
            androidx.compose.ui.e eVarD = androidx.compose.foundation.e.d(androidx.compose.foundation.layout.t.h(this.b, 0.0f, 1, null), this.c, null, false, null, null, this.d, 28, null);
            androidx.compose.ui.e eVar = this.b;
            String str = this.e;
            final String str2 = this.f;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(fVarB, cVarI, interfaceC22053ub1, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            M66 m66 = M66.a;
            androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(eVar, C17784nZ1.q(32));
            G10 g10 = G10.a;
            int i2 = G10.b;
            AbstractC24077y03.b(FV4.c(iIntValue, interfaceC22053ub1, 0), UY6.c(iIntValue2, interfaceC22053ub1, 0), androidx.compose.foundation.layout.q.i(eVarT, g10.c(interfaceC22053ub1, i2).b().r()), WX0.a(EA5.white, interfaceC22053ub1, 0), interfaceC22053ub1, 0, 0);
            AbstractC9339Zm7.b(str, null, g10.a(interfaceC22053ub1, i2).G(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).n(), interfaceC22053ub1, 0, 0, 65018);
            interfaceC22053ub1.W(-292849601);
            if (C8386Vt0.a.n9() && str2 != null) {
                e.a aVar2 = androidx.compose.ui.e.a;
                ZH6.a(androidx.compose.foundation.layout.t.t(aVar2, g10.c(interfaceC22053ub1, i2).b().n()), interfaceC22053ub1, 0);
                androidx.compose.ui.e eVarT2 = androidx.compose.foundation.layout.t.t(aVar2, g10.c(interfaceC22053ub1, i2).b().h());
                interfaceC22053ub1.W(-292840511);
                Object objB2 = interfaceC22053ub1.B();
                InterfaceC22053ub1.a aVar3 = InterfaceC22053ub1.a;
                if (objB2 == aVar3.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.xc0
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC18994pc0.i.d((Context) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                UA2 ua2 = (UA2) objB2;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-292836754);
                boolean zV = interfaceC22053ub1.V(str2);
                Object objB3 = interfaceC22053ub1.B();
                if (zV || objB3 == aVar3.a()) {
                    objB3 = new UA2() { // from class: ir.nasim.yc0
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC18994pc0.i.f(str2, (RLottieImageView) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                AbstractC11355cs.a(ua2, eVarT2, (UA2) objB3, interfaceC22053ub1, 6, 0);
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Z20) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.pc0$j */
    static final class j implements InterfaceC15796kB2 {
        final /* synthetic */ PI0 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ InterfaceC9102Ym4 c;

        j(PI0 pi0, SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = pi0;
            this.b = sa2;
            this.c = interfaceC9102Ym4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(PI0 pi0, SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(pi0, "$changeLogUiData");
            AbstractC13042fc3.i(sa2, "$openDownloadWebPage");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$isDialogVisible");
            List listA = pi0.a();
            if (listA == null || listA.isEmpty()) {
                sa2.invoke();
            } else {
                interfaceC9102Ym4.setValue(Boolean.TRUE);
            }
            return C19938rB7.a;
        }

        public final void b(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(eVar, "trailingModifier");
            if ((i & 6) == 0) {
                i |= interfaceC22053ub1.V(eVar) ? 4 : 2;
            }
            if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(eVar, C17784nZ1.q(4), 0.0f, 2, null);
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            String strC = UY6.c(QD5.update, interfaceC22053ub1, 0);
            interfaceC22053ub1.W(1355698074);
            boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.V(this.b);
            final PI0 pi0 = this.a;
            final SA2 sa2 = this.b;
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.c;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.zc0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC18994pc0.j.c(pi0, sa2, interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC17932no0.O((SA2) objB, aVar, strC, eVarK, null, interfaceC22053ub1, InterfaceC19114po0.b.a.b << 3, 16);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A0(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$dialogVisible$delegate");
        z0(interfaceC9102Ym4, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B0(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$dialogVisible$delegate");
        z0(interfaceC9102Ym4, true);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 C0(SA2 sa2, androidx.compose.ui.e eVar, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(sa2, "$logout");
        x0(sa2, eVar, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    public static final void D0(final androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, final int i2, final int i3) {
        int i4;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(635914812);
        int i5 = i3 & 1;
        if (i5 != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i4 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (i5 != 0) {
                eVar = androidx.compose.ui.e.a;
            }
            interfaceC22053ub1J.W(-995807617);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new SA2() { // from class: ir.nasim.yb0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC18994pc0.E0();
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-995806298);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                objB2 = new SA2() { // from class: ir.nasim.Jb0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return Boolean.valueOf(AbstractC18994pc0.F0());
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            Q0(eVar, "محمد", null, sa2, false, (SA2) objB2, null, interfaceC22053ub1J, (i4 & 14) | 199728, 84);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Ub0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC18994pc0.G0(eVar, i2, i3, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 E0() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean F0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 G0(androidx.compose.ui.e eVar, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        D0(eVar, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0475  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x04cf  */
    /* JADX WARN: Removed duplicated region for block: B:195:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void H0(final ir.nasim.C22642vb0 r32, final java.lang.String r33, final boolean r34, final boolean r35, final ir.nasim.PI0 r36, final ir.nasim.AbstractC12129e53 r37, final boolean r38, final long r39, final java.lang.String r41, final java.lang.String r42, final ir.nasim.UA2 r43, final ir.nasim.SA2 r44, androidx.compose.ui.e r45, ir.nasim.InterfaceC22053ub1 r46, final int r47, final int r48, final int r49) {
        /*
            Method dump skipped, instructions count: 1281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC18994pc0.H0(ir.nasim.vb0, java.lang.String, boolean, boolean, ir.nasim.PI0, ir.nasim.e53, boolean, long, java.lang.String, java.lang.String, ir.nasim.UA2, ir.nasim.SA2, androidx.compose.ui.e, ir.nasim.ub1, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 I0(InterfaceC9638aI7 interfaceC9638aI7, String str) {
        AbstractC13042fc3.i(interfaceC9638aI7, "$uriHandler");
        AbstractC13042fc3.i(str, "$baleFaqUrl");
        interfaceC9638aI7.a(str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 J0(C22642vb0 c22642vb0, String str, boolean z, boolean z2, PI0 pi0, AbstractC12129e53 abstractC12129e53, boolean z3, long j2, String str2, String str3, UA2 ua2, SA2 sa2, androidx.compose.ui.e eVar, int i2, int i3, int i4, InterfaceC22053ub1 interfaceC22053ub1, int i5) {
        AbstractC13042fc3.i(c22642vb0, "$navigationCallbacks");
        AbstractC13042fc3.i(str, "$versionNumber");
        AbstractC13042fc3.i(pi0, "$changeLogUiData");
        AbstractC13042fc3.i(abstractC12129e53, "$inAppUpdateState");
        AbstractC13042fc3.i(str2, "$baleFaqUrl");
        AbstractC13042fc3.i(str3, "$baleDownloadAppUrl");
        AbstractC13042fc3.i(ua2, "$showSnackBar");
        AbstractC13042fc3.i(sa2, "$logout");
        H0(c22642vb0, str, z, z2, pi0, abstractC12129e53, z3, j2, str2, str3, ua2, sa2, eVar, interfaceC22053ub1, QJ5.a(i2 | 1), QJ5.a(i3), i4);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void K0(final java.lang.String r30, final ir.nasim.UA2 r31, androidx.compose.ui.e r32, ir.nasim.InterfaceC22053ub1 r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC18994pc0.K0(java.lang.String, ir.nasim.UA2, androidx.compose.ui.e, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 L0(Context context, String str, UA2 ua2) {
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(str, "$version");
        AbstractC13042fc3.i(ua2, "$showSnackBar");
        KV0.a(context, str);
        if (KV0.b()) {
            ua2.invoke(Integer.valueOf(QD5.toast_version_copied));
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 M0(String str, UA2 ua2, androidx.compose.ui.e eVar, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(str, "$versionNumber");
        AbstractC13042fc3.i(ua2, "$showSnackBar");
        K0(str, ua2, eVar, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void N0(final ir.nasim.core.modules.profile.entity.Avatar r29, final java.lang.String r30, final int r31, final ir.nasim.SA2 r32, androidx.compose.ui.e r33, ir.nasim.InterfaceC22053ub1 r34, final int r35, final int r36) {
        /*
            Method dump skipped, instructions count: 725
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC18994pc0.N0(ir.nasim.core.modules.profile.entity.Avatar, java.lang.String, int, ir.nasim.SA2, androidx.compose.ui.e, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 O0(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$clearAndSetSemantics");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 P0(Avatar avatar, String str, int i2, SA2 sa2, androidx.compose.ui.e eVar, int i3, int i4, InterfaceC22053ub1 interfaceC22053ub1, int i5) {
        AbstractC13042fc3.i(str, "$name");
        AbstractC13042fc3.i(sa2, "$navigateToAccount");
        N0(avatar, str, i2, sa2, eVar, interfaceC22053ub1, QJ5.a(i3 | 1), i4);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0141  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Q0(androidx.compose.ui.e r30, final java.lang.String r31, java.lang.String r32, final ir.nasim.SA2 r33, boolean r34, final ir.nasim.SA2 r35, ir.nasim.UA2 r36, ir.nasim.InterfaceC22053ub1 r37, final int r38, final int r39) {
        /*
            Method dump skipped, instructions count: 639
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC18994pc0.Q0(androidx.compose.ui.e, java.lang.String, java.lang.String, ir.nasim.SA2, boolean, ir.nasim.SA2, ir.nasim.UA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void R(final ir.nasim.C3727Cc0 r20, final ir.nasim.SA2 r21, final ir.nasim.SA2 r22, androidx.compose.ui.e r23, final ir.nasim.UA2 r24, boolean r25, final ir.nasim.SA2 r26, final ir.nasim.UA2 r27, ir.nasim.InterfaceC22053ub1 r28, final int r29, final int r30) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC18994pc0.R(ir.nasim.Cc0, ir.nasim.SA2, ir.nasim.SA2, androidx.compose.ui.e, ir.nasim.UA2, boolean, ir.nasim.SA2, ir.nasim.UA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 R0(boolean z) {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 S(C3727Cc0 c3727Cc0, SA2 sa2, SA2 sa22, androidx.compose.ui.e eVar, UA2 ua2, boolean z, SA2 sa23, UA2 ua22, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(c3727Cc0, "$userData");
        AbstractC13042fc3.i(sa2, "$navigateToAccount");
        AbstractC13042fc3.i(sa22, "$showSwitchAccountBottomSheet");
        AbstractC13042fc3.i(ua2, "$showSnackBar");
        AbstractC13042fc3.i(sa23, "$canShowMultiAccountTooltip");
        AbstractC13042fc3.i(ua22, "$changeTooltipConfig");
        R(c3727Cc0, sa2, sa22, eVar, ua2, z, sa23, ua22, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Z20 S0(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (Z20) interfaceC9102Ym4.getValue();
    }

    public static final void T(final InterfaceC9664aL6 interfaceC9664aL6, final C22642vb0 c22642vb0, final UA2 ua2, final UA2 ua22, final SA2 sa2, final SA2 sa22, final SA2 sa23, final UA2 ua23, final SA2 sa24, final UA2 ua24, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        C19391qG6 c19391qG6;
        InterfaceC9102Ym4 interfaceC9102Ym4;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(interfaceC9664aL6, "uiState");
        AbstractC13042fc3.i(c22642vb0, "navigationCallbacks");
        AbstractC13042fc3.i(ua2, "onChangeTheme");
        AbstractC13042fc3.i(ua22, "showSnackBar");
        AbstractC13042fc3.i(sa2, "snackbarMessageShown");
        AbstractC13042fc3.i(sa22, "logout");
        AbstractC13042fc3.i(sa23, "onBackPressed");
        AbstractC13042fc3.i(ua23, "getUser");
        AbstractC13042fc3.i(sa24, "canShowMultiAccountTooltip");
        AbstractC13042fc3.i(ua24, "changeTooltipConfig");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-905868834);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(interfaceC9664aL6) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(c22642vb0) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.D(ua22) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= interfaceC22053ub1J.D(sa2) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i3 |= interfaceC22053ub1J.D(sa22) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            i3 |= interfaceC22053ub1J.D(sa23) ? 1048576 : 524288;
        }
        if ((12582912 & i2) == 0) {
            i3 |= interfaceC22053ub1J.D(ua23) ? 8388608 : 4194304;
        }
        if ((100663296 & i2) == 0) {
            i3 |= interfaceC22053ub1J.D(sa24) ? 67108864 : 33554432;
        }
        if ((805306368 & i2) == 0) {
            i3 |= interfaceC22053ub1J.D(ua24) ? 536870912 : 268435456;
        }
        if ((306783379 & i3) == 306783378 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            interfaceC22053ub1J.W(-494152467);
            if (((C3254Ac0) interfaceC9664aL6.getValue()).o()) {
                v0(interfaceC22053ub1J, 0);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-494149057);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new C19391qG6();
                interfaceC22053ub1J.s(objB);
            }
            C19391qG6 c19391qG62 = (C19391qG6) objB;
            interfaceC22053ub1J.Q();
            InterfaceC9664aL6 interfaceC9664aL6Q = AbstractC10222bH6.q(sa2, interfaceC22053ub1J, (i3 >> 12) & 14);
            Integer numJ = ((C3254Ac0) interfaceC9664aL6.getValue()).j();
            interfaceC22053ub1J.W(-494144009);
            if (numJ != null) {
                int iIntValue = numJ.intValue();
                String strC = UY6.c(iIntValue, interfaceC22053ub1J, 0);
                Integer numValueOf = Integer.valueOf(iIntValue);
                interfaceC22053ub1J.W(152220167);
                boolean zV = interfaceC22053ub1J.V(strC) | interfaceC22053ub1J.V(interfaceC9664aL6Q);
                Object objB2 = interfaceC22053ub1J.B();
                if (zV || objB2 == aVar.a()) {
                    objB2 = new b(c19391qG62, strC, interfaceC9664aL6Q, null);
                    interfaceC22053ub1J.s(objB2);
                }
                interfaceC22053ub1J.Q();
                AbstractC10721c52.g(c19391qG62, numValueOf, strC, (InterfaceC14603iB2) objB2, interfaceC22053ub1J, 6);
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            interfaceC22053ub1J.Q();
            C19818qz6 c19818qz6L = AbstractC9273Zf4.l(true, null, interfaceC22053ub1J, 6, 2);
            interfaceC22053ub1J.W(-494131999);
            Object objB3 = interfaceC22053ub1J.B();
            if (objB3 == aVar.a()) {
                objB3 = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                interfaceC22053ub1J.s(objB3);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym42 = (InterfaceC9102Ym4) objB3;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-494129714);
            if (Y(interfaceC9102Ym42)) {
                C13923h3 c13923h3 = C13923h3.a;
                int iM = c13923h3.m();
                Set setO = c13923h3.o();
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(setO, 10));
                Iterator it = setO.iterator();
                while (it.hasNext()) {
                    C17637nI7 c17637nI7 = (C17637nI7) ua23.invoke(Integer.valueOf(Integer.parseInt((String) it.next())));
                    if (c17637nI7 == null) {
                        interfaceC22053ub1J.Q();
                        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
                        if (interfaceC20208rd6M != null) {
                            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.mc0
                                @Override // ir.nasim.InterfaceC14603iB2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AbstractC18994pc0.a0(interfaceC9664aL6, c22642vb0, ua2, ua22, sa2, sa22, sa23, ua23, sa24, ua24, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    int iN0 = c17637nI7.n0();
                    Iterator it2 = it;
                    String strL0 = c17637nI7.l0();
                    AbstractC13042fc3.h(strL0, "getServerName(...)");
                    String strD0 = c17637nI7.d0();
                    if (strD0 == null) {
                        strD0 = "";
                    }
                    String str = strD0;
                    Avatar avatarS = c17637nI7.S();
                    if (avatarS == null) {
                        avatarS = new Avatar();
                    }
                    arrayList.add(new C5924Lk4(iN0, strL0, str, avatarS, c17637nI7.n0() == iM));
                    it = it2;
                }
                SA2 sa2A = c22642vb0.a();
                interfaceC22053ub1J.W(-494099242);
                boolean z = (i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32;
                Object objB4 = interfaceC22053ub1J.B();
                if (z || objB4 == InterfaceC22053ub1.a.a()) {
                    objB4 = new UA2() { // from class: ir.nasim.nc0
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC18994pc0.V(c22642vb0, ((Integer) obj).intValue());
                        }
                    };
                    interfaceC22053ub1J.s(objB4);
                }
                interfaceC22053ub1J.Q();
                C14344hl4 c14344hl4 = new C14344hl4(arrayList, sa2A, (UA2) objB4);
                interfaceC22053ub1J.W(-494107417);
                Object objB5 = interfaceC22053ub1J.B();
                if (objB5 == InterfaceC22053ub1.a.a()) {
                    objB5 = new SA2() { // from class: ir.nasim.oc0
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC18994pc0.W(interfaceC9102Ym42);
                        }
                    };
                    interfaceC22053ub1J.s(objB5);
                }
                interfaceC22053ub1J.Q();
                c19391qG6 = c19391qG62;
                interfaceC9102Ym4 = interfaceC9102Ym42;
                AbstractC8309Vk4.j(null, c19818qz6L, c14344hl4, (SA2) objB5, interfaceC22053ub1J, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 1);
            } else {
                c19391qG6 = c19391qG62;
                interfaceC9102Ym4 = interfaceC9102Ym42;
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC11029cc6.a(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), AbstractC19242q11.e(-632000102, true, new c(sa23, interfaceC9664aL6, ua2), interfaceC22053ub1J, 54), null, AbstractC19242q11.e(554977240, true, new d(c19391qG6), interfaceC22053ub1J, 54), null, 0, G10.a.a(interfaceC22053ub1J, G10.b).r(), 0L, null, AbstractC19242q11.e(-1867981009, true, new e(interfaceC9664aL6, c22642vb0, ua22, sa24, ua24, sa22, interfaceC9102Ym4), interfaceC22053ub12, 54), interfaceC22053ub12, 805309494, 436);
        }
        InterfaceC20208rd6 interfaceC20208rd6M2 = interfaceC22053ub12.m();
        if (interfaceC20208rd6M2 != null) {
            interfaceC20208rd6M2.a(new InterfaceC14603iB2() { // from class: ir.nasim.zb0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC18994pc0.X(interfaceC9664aL6, c22642vb0, ua2, ua22, sa2, sa22, sa23, ua23, sa24, ua24, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void T0(InterfaceC9102Ym4 interfaceC9102Ym4, Z20 z20) {
        interfaceC9102Ym4.setValue(z20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SA2 U(InterfaceC9664aL6 interfaceC9664aL6) {
        return (SA2) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 U0(C9348Zn7 c9348Zn7, long j2, long j3, D20.a aVar) {
        AbstractC13042fc3.i(c9348Zn7, "$balloonTextStyle");
        AbstractC13042fc3.i(aVar, "$this$rememberBalloonBuilder");
        aVar.d1(9);
        aVar.b2(17);
        aVar.d2(QD5.multi_account_onboarding);
        C3418Au2 c3418Au2M = c9348Zn7.m();
        if (c3418Au2M != null) {
            aVar.g2(c3418Au2M.i());
        }
        aVar.e2(C13193fo7.h(c9348Zn7.l()));
        H20.b(aVar, j2);
        H20.a(aVar, j3);
        aVar.l1(8.0f);
        aVar.P1(12);
        aVar.V1(8);
        aVar.H1(SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
        aVar.f1(3000L);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 V(C22642vb0 c22642vb0, int i2) {
        AbstractC13042fc3.i(c22642vb0, "$navigationCallbacks");
        c22642vb0.k().invoke(Integer.valueOf(i2));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 V0(SA2 sa2, UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4, Z20 z20) {
        AbstractC13042fc3.i(sa2, "$canShowMultiAccountTooltip");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$balloonWindow$delegate");
        AbstractC13042fc3.i(z20, "it");
        if (((Boolean) sa2.invoke()).booleanValue()) {
            T0(interfaceC9102Ym4, z20);
            ua2.invoke(Boolean.TRUE);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 W(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$showSwitchAccountBottomSheet$delegate");
        Z(interfaceC9102Ym4, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 W0(androidx.compose.ui.e eVar, String str, String str2, SA2 sa2, boolean z, SA2 sa22, UA2 ua2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(str, "$userName");
        AbstractC13042fc3.i(sa2, "$showSwitchAccountBottomSheet");
        AbstractC13042fc3.i(sa22, "$canShowMultiAccountTooltip");
        Q0(eVar, str, str2, sa2, z, sa22, ua2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 X(InterfaceC9664aL6 interfaceC9664aL6, C22642vb0 c22642vb0, UA2 ua2, UA2 ua22, SA2 sa2, SA2 sa22, SA2 sa23, UA2 ua23, SA2 sa24, UA2 ua24, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(interfaceC9664aL6, "$uiState");
        AbstractC13042fc3.i(c22642vb0, "$navigationCallbacks");
        AbstractC13042fc3.i(ua2, "$onChangeTheme");
        AbstractC13042fc3.i(ua22, "$showSnackBar");
        AbstractC13042fc3.i(sa2, "$snackbarMessageShown");
        AbstractC13042fc3.i(sa22, "$logout");
        AbstractC13042fc3.i(sa23, "$onBackPressed");
        AbstractC13042fc3.i(ua23, "$getUser");
        AbstractC13042fc3.i(sa24, "$canShowMultiAccountTooltip");
        AbstractC13042fc3.i(ua24, "$changeTooltipConfig");
        T(interfaceC9664aL6, c22642vb0, ua2, ua22, sa2, sa22, sa23, ua23, sa24, ua24, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:103:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0316  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void X0(final java.lang.String r36, final java.lang.String r37, final ir.nasim.UA2 r38, androidx.compose.ui.e r39, ir.nasim.InterfaceC22053ub1 r40, final int r41, final int r42) {
        /*
            Method dump skipped, instructions count: 863
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC18994pc0.X0(java.lang.String, java.lang.String, ir.nasim.UA2, androidx.compose.ui.e, ir.nasim.ub1, int, int):void");
    }

    private static final boolean Y(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Y0(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isCopyMenuVisible");
        interfaceC9102Ym4.setValue(Boolean.TRUE);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Z0(String str, String str2, UA2 ua2, androidx.compose.ui.e eVar, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(ua2, "$showSnackBar");
        X0(str, str2, ua2, eVar, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 a0(InterfaceC9664aL6 interfaceC9664aL6, C22642vb0 c22642vb0, UA2 ua2, UA2 ua22, SA2 sa2, SA2 sa22, SA2 sa23, UA2 ua23, SA2 sa24, UA2 ua24, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(interfaceC9664aL6, "$uiState");
        AbstractC13042fc3.i(c22642vb0, "$navigationCallbacks");
        AbstractC13042fc3.i(ua2, "$onChangeTheme");
        AbstractC13042fc3.i(ua22, "$showSnackBar");
        AbstractC13042fc3.i(sa2, "$snackbarMessageShown");
        AbstractC13042fc3.i(sa22, "$logout");
        AbstractC13042fc3.i(sa23, "$onBackPressed");
        AbstractC13042fc3.i(ua23, "$getUser");
        AbstractC13042fc3.i(sa24, "$canShowMultiAccountTooltip");
        AbstractC13042fc3.i(ua24, "$changeTooltipConfig");
        T(interfaceC9664aL6, c22642vb0, ua2, ua22, sa2, sa22, sa23, ua23, sa24, ua24, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void a1(final java.lang.String r33, final boolean r34, final ir.nasim.PI0 r35, final ir.nasim.UA2 r36, final java.lang.String r37, androidx.compose.ui.e r38, ir.nasim.InterfaceC22053ub1 r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 645
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC18994pc0.a1(java.lang.String, boolean, ir.nasim.PI0, ir.nasim.UA2, java.lang.String, androidx.compose.ui.e, ir.nasim.ub1, int, int):void");
    }

    private static final void b0(final InterfaceC9102Ym4 interfaceC9102Ym4, final PI0 pi0, final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1531045088);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(interfaceC9102Ym4) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(pi0) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(sa2) ? 256 : 128;
        }
        if ((i3 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(-1219715810);
            boolean z = (i3 & 14) == 4;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.ac0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC18994pc0.c0(interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC6687Oo.a((SA2) objB, null, AbstractC19242q11.e(-808549847, true, new f(interfaceC9102Ym4, sa2, pi0), interfaceC22053ub1J, 54), interfaceC22053ub1J, 384, 2);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.bc0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC18994pc0.d0(interfaceC9102Ym4, pi0, sa2, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 b1(InterfaceC9638aI7 interfaceC9638aI7, String str) {
        AbstractC13042fc3.i(interfaceC9638aI7, "$uriHandler");
        AbstractC13042fc3.i(str, "$baleDownloadAppUrl");
        interfaceC9638aI7.a(str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c0(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isDialogVisible");
        interfaceC9102Ym4.setValue(Boolean.FALSE);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c1(Context context, String str, UA2 ua2) {
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(str, "$version");
        AbstractC13042fc3.i(ua2, "$showSnackBar");
        KV0.a(context, str);
        if (KV0.b()) {
            ua2.invoke(Integer.valueOf(QD5.toast_version_copied));
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d0(InterfaceC9102Ym4 interfaceC9102Ym4, PI0 pi0, SA2 sa2, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isDialogVisible");
        AbstractC13042fc3.i(pi0, "$changeLogUiData");
        AbstractC13042fc3.i(sa2, "$openDownloadWebPage");
        b0(interfaceC9102Ym4, pi0, sa2, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d1(String str, boolean z, PI0 pi0, UA2 ua2, String str2, androidx.compose.ui.e eVar, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(str, "$versionNumber");
        AbstractC13042fc3.i(pi0, "$changeLogUiData");
        AbstractC13042fc3.i(ua2, "$showSnackBar");
        AbstractC13042fc3.i(str2, "$baleDownloadAppUrl");
        a1(str, z, pi0, ua2, str2, eVar, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    private static final void e0(final EnumC6196Mo7 enumC6196Mo7, final InterfaceC9102Ym4 interfaceC9102Ym4, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(472549158);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(enumC6196Mo7) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(interfaceC9102Ym4) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 256 : 128;
        }
        if ((i3 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            XV4 xv4A = enumC6196Mo7.q() ? AbstractC4616Fw7.a(Integer.valueOf(QD5.base_settings_theme_menu_light_mode), Integer.valueOf(KB5.sun)) : AbstractC4616Fw7.a(Integer.valueOf(QD5.base_settings_theme_menu_dark_mode), Integer.valueOf(KB5.moon));
            int iIntValue = ((Number) xv4A.a()).intValue();
            int iIntValue2 = ((Number) xv4A.b()).intValue();
            String strC = UY6.c(iIntValue, interfaceC22053ub1J, 0);
            interfaceC22053ub1J.W(1692765669);
            int i4 = i3 & 896;
            boolean z = ((i3 & 14) == 4) | (i4 == 256);
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Sb0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC18994pc0.f0(ua2, enumC6196Mo7);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            C7847Tl1 c7847Tl1 = new C7847Tl1(strC, iIntValue2, 0, (SA2) objB, 4, null);
            String strC2 = UY6.c(QD5.base_settings_theme_menu_auto_dark_mode_based_time, interfaceC22053ub1J, 0);
            int i5 = AbstractC21822uB5.timer;
            interfaceC22053ub1J.W(1692775672);
            boolean z2 = i4 == 256;
            Object objB2 = interfaceC22053ub1J.B();
            if (z2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.Tb0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC18994pc0.g0(ua2);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            List listS = AbstractC10360bX0.s(c7847Tl1, new C7847Tl1(strC2, i5, 0, (SA2) objB2, 4, null));
            interfaceC22053ub1J.W(1692778950);
            if (Build.VERSION.SDK_INT >= 29) {
                String strC3 = UY6.c(QD5.base_settings_theme_menu_auto_dark_mode_based_device, interfaceC22053ub1J, 0);
                int i6 = AbstractC21822uB5.pallete;
                interfaceC22053ub1J.W(1692787970);
                boolean z3 = i4 == 256;
                Object objB3 = interfaceC22053ub1J.B();
                if (z3 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new SA2() { // from class: ir.nasim.Vb0
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC18994pc0.h0(ua2);
                        }
                    };
                    interfaceC22053ub1J.s(objB3);
                }
                interfaceC22053ub1J.Q();
                listS.add(new C7847Tl1(strC3, i6, 0, (SA2) objB3, 4, null));
            }
            interfaceC22053ub1J.Q();
            boolean zBooleanValue = ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
            interfaceC22053ub1J.W(1692795087);
            boolean z4 = (i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32;
            Object objB4 = interfaceC22053ub1J.B();
            if (z4 || objB4 == InterfaceC22053ub1.a.a()) {
                objB4 = new SA2() { // from class: ir.nasim.Wb0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC18994pc0.i0(interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1J.s(objB4);
            }
            interfaceC22053ub1J.Q();
            AbstractC9090Yl1.b(0L, listS, zBooleanValue, (SA2) objB4, 0L, 0L, 0L, interfaceC22053ub1J, 0, 113);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Xb0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC18994pc0.j0(enumC6196Mo7, interfaceC9102Ym4, ua2, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f0(UA2 ua2, EnumC6196Mo7 enumC6196Mo7) {
        AbstractC13042fc3.i(ua2, "$onChangeTheme");
        AbstractC13042fc3.i(enumC6196Mo7, "$themeMode");
        ua2.invoke(enumC6196Mo7.q() ? EnumC6196Mo7.d : EnumC6196Mo7.e);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g0(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "$onChangeTheme");
        ua2.invoke(EnumC6196Mo7.g);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h0(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "$onChangeTheme");
        ua2.invoke(EnumC6196Mo7.f);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i0(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isVisible");
        interfaceC9102Ym4.setValue(Boolean.FALSE);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j0(EnumC6196Mo7 enumC6196Mo7, InterfaceC9102Ym4 interfaceC9102Ym4, UA2 ua2, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(enumC6196Mo7, "$themeMode");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isVisible");
        AbstractC13042fc3.i(ua2, "$onChangeTheme");
        e0(enumC6196Mo7, interfaceC9102Ym4, ua2, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void k0(final ir.nasim.EnumC6196Mo7 r28, final ir.nasim.UA2 r29, final boolean r30, androidx.compose.ui.e r31, ir.nasim.InterfaceC22053ub1 r32, final int r33, final int r34) {
        /*
            Method dump skipped, instructions count: 613
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC18994pc0.k0(ir.nasim.Mo7, ir.nasim.UA2, boolean, androidx.compose.ui.e, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l0(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isThemeMenuVisible");
        interfaceC9102Ym4.setValue(Boolean.TRUE);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m0(EnumC6196Mo7 enumC6196Mo7, UA2 ua2) {
        AbstractC13042fc3.i(enumC6196Mo7, "$themeMode");
        AbstractC13042fc3.i(ua2, "$onChangeTheme");
        ua2.invoke(enumC6196Mo7.q() ? EnumC6196Mo7.d : EnumC6196Mo7.e);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n0(EnumC6196Mo7 enumC6196Mo7, UA2 ua2, boolean z, androidx.compose.ui.e eVar, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(enumC6196Mo7, "$themeMode");
        AbstractC13042fc3.i(ua2, "$onChangeTheme");
        k0(enumC6196Mo7, ua2, z, eVar, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    private static final void o0(final String str, final String str2, final UA2 ua2, final InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1971970621);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(str2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.V(interfaceC9102Ym4) ? 2048 : 1024;
        }
        if ((i3 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            final Context context = (Context) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.g());
            ArrayList arrayList = new ArrayList();
            interfaceC22053ub1J.W(1941352833);
            if (str2 != null) {
                if (str2.length() == 0) {
                    interfaceC22053ub1J.Q();
                    InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
                    if (interfaceC20208rd6M != null) {
                        interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.cc0
                            @Override // ir.nasim.InterfaceC14603iB2
                            public final Object invoke(Object obj, Object obj2) {
                                return AbstractC18994pc0.p0(str, str2, ua2, interfaceC9102Ym4, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                String strC = UY6.c(QD5.copy_phone_number, interfaceC22053ub1J, 0);
                int i4 = AbstractC21822uB5.copy;
                interfaceC22053ub1J.W(-120110097);
                boolean zD = interfaceC22053ub1J.D(context) | interfaceC22053ub1J.V(str2) | ((i3 & 896) == 256);
                Object objB = interfaceC22053ub1J.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.dc0
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC18994pc0.q0(context, str2, ua2);
                        }
                    };
                    interfaceC22053ub1J.s(objB);
                }
                interfaceC22053ub1J.Q();
                arrayList.add(new C7847Tl1(strC, i4, 0, (SA2) objB, 4, null));
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1941370902);
            if (str != null) {
                if (str.length() == 0) {
                    interfaceC22053ub1J.Q();
                    InterfaceC20208rd6 interfaceC20208rd6M2 = interfaceC22053ub1J.m();
                    if (interfaceC20208rd6M2 != null) {
                        interfaceC20208rd6M2.a(new InterfaceC14603iB2() { // from class: ir.nasim.ec0
                            @Override // ir.nasim.InterfaceC14603iB2
                            public final Object invoke(Object obj, Object obj2) {
                                return AbstractC18994pc0.r0(str, str2, ua2, interfaceC9102Ym4, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                String strC2 = UY6.c(QD5.copy_username, interfaceC22053ub1J, 0);
                int i5 = AbstractC21822uB5.copy;
                interfaceC22053ub1J.W(-120092245);
                boolean zD2 = ((i3 & 896) == 256) | interfaceC22053ub1J.D(context) | interfaceC22053ub1J.V(str);
                Object objB2 = interfaceC22053ub1J.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.gc0
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC18994pc0.s0(context, str, ua2);
                        }
                    };
                    interfaceC22053ub1J.s(objB2);
                }
                interfaceC22053ub1J.Q();
                arrayList.add(new C7847Tl1(strC2, i5, 0, (SA2) objB2, 4, null));
            }
            interfaceC22053ub1J.Q();
            boolean zBooleanValue = ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
            interfaceC22053ub1J.W(1941391286);
            boolean z = (i3 & 7168) == 2048;
            Object objB3 = interfaceC22053ub1J.B();
            if (z || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new SA2() { // from class: ir.nasim.hc0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC18994pc0.t0(interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            AbstractC9090Yl1.b(0L, arrayList, zBooleanValue, (SA2) objB3, 0L, 0L, 0L, interfaceC22053ub1J, 0, 113);
        }
        InterfaceC20208rd6 interfaceC20208rd6M3 = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M3 != null) {
            interfaceC20208rd6M3.a(new InterfaceC14603iB2() { // from class: ir.nasim.ic0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC18994pc0.u0(str, str2, ua2, interfaceC9102Ym4, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p0(String str, String str2, UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(ua2, "$showSnackBar");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isVisible");
        o0(str, str2, ua2, interfaceC9102Ym4, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q0(Context context, String str, UA2 ua2) {
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(str, "$it");
        AbstractC13042fc3.i(ua2, "$showSnackBar");
        KV0.a(context, str);
        if (KV0.b()) {
            ua2.invoke(Integer.valueOf(QD5.toast_copy_phone_number));
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r0(String str, String str2, UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(ua2, "$showSnackBar");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isVisible");
        o0(str, str2, ua2, interfaceC9102Ym4, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s0(Context context, String str, UA2 ua2) {
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(str, "$it");
        AbstractC13042fc3.i(ua2, "$showSnackBar");
        KV0.a(context, str);
        if (KV0.b()) {
            ua2.invoke(Integer.valueOf(QD5.toast_copy_username));
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t0(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isVisible");
        interfaceC9102Ym4.setValue(Boolean.FALSE);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u0(String str, String str2, UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(ua2, "$showSnackBar");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isVisible");
        o0(str, str2, ua2, interfaceC9102Ym4, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    private static final void v0(InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-337213155);
        if (i2 == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            AbstractC6456Nq.c(null, 0L, null, new C7117Qi5(true, false, false, null, true, false, 40, null), L21.a.b(), interfaceC22053ub1J, 27648, 7);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Ab0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC18994pc0.w0(i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w0(int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        v0(interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void x0(final ir.nasim.SA2 r18, androidx.compose.ui.e r19, ir.nasim.InterfaceC22053ub1 r20, final int r21, final int r22) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC18994pc0.x0(ir.nasim.SA2, androidx.compose.ui.e, ir.nasim.ub1, int, int):void");
    }

    private static final boolean y0(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }
}
