package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.compose.ui.e;
import ir.nasim.AbstractC23365wn7;
import ir.nasim.AbstractC24975zX0;
import ir.nasim.GC3;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22053ub1;

/* loaded from: classes4.dex */
public abstract class GC3 {

    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ PD3 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ SA2 c;

        /* renamed from: ir.nasim.GC3$a$a, reason: collision with other inner class name */
        static final class C0385a implements InterfaceC14603iB2 {
            final /* synthetic */ PD3 a;
            final /* synthetic */ SA2 b;
            final /* synthetic */ SA2 c;

            /* renamed from: ir.nasim.GC3$a$a$a, reason: collision with other inner class name */
            static final class C0386a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ PD3 c;
                final /* synthetic */ InterfaceC9102Ym4 d;

                /* renamed from: ir.nasim.GC3$a$a$a$a, reason: collision with other inner class name */
                static final class C0387a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    private /* synthetic */ Object c;
                    final /* synthetic */ PD3 d;
                    final /* synthetic */ InterfaceC9102Ym4 e;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0387a(PD3 pd3, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.d = pd3;
                        this.e = interfaceC9102Ym4;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        C0387a c0387a = new C0387a(this.d, this.e, interfaceC20295rm1);
                        c0387a.c = obj;
                        return c0387a;
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        AbstractC14862ic3.e();
                        if (this.b != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                        byte[] bArrE = this.d.e();
                        if (bArrE == null) {
                            return C19938rB7.a;
                        }
                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrE, 0, bArrE.length);
                        if (AbstractC20906so1.g(interfaceC20315ro1)) {
                            C0385a.k(this.e, bitmapDecodeByteArray != null ? AbstractC19123pp.c(bitmapDecodeByteArray) : null);
                        }
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C0387a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0386a(PD3 pd3, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = pd3;
                    this.d = interfaceC9102Ym4;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0386a(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        AbstractC13778go1 abstractC13778go1A = C12366eV1.a();
                        C0387a c0387a = new C0387a(this.c, this.d, null);
                        this.b = 1;
                        if (AbstractC9323Zl0.g(abstractC13778go1A, c0387a, this) == objE) {
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
                    return ((C0386a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            C0385a(PD3 pd3, SA2 sa2, SA2 sa22) {
                this.a = pd3;
                this.b = sa2;
                this.c = sa22;
            }

            private static final Y03 h(InterfaceC9102Ym4 interfaceC9102Ym4) {
                return (Y03) interfaceC9102Ym4.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 i(long j, InterfaceC17460n02 interfaceC17460n02) {
                AbstractC13042fc3.i(interfaceC17460n02, "$this$drawBehind");
                int iB = AbstractC24405yZ6.a.b();
                float fW1 = interfaceC17460n02.w1(C17784nZ1.q(3));
                float f = 4;
                float fW12 = interfaceC17460n02.w1(C17784nZ1.q(f));
                long jE = ZG4.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(fW12) & 4294967295L));
                float fIntBitsToFloat = Float.intBitsToFloat((int) (interfaceC17460n02.d() >> 32));
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L)) - interfaceC17460n02.w1(C17784nZ1.q(f));
                InterfaceC17460n02.V0(interfaceC17460n02, j, jE, ZG4.e((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L)), fW1, iB, null, 0.0f, null, 0, 480, null);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void k(InterfaceC9102Ym4 interfaceC9102Ym4, Y03 y03) {
                interfaceC9102Ym4.setValue(y03);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 n(long j, InterfaceC17460n02 interfaceC17460n02) {
                AbstractC13042fc3.i(interfaceC17460n02, "$this$drawBehind");
                float fW1 = interfaceC17460n02.w1(C17784nZ1.q(1));
                float fIntBitsToFloat = Float.intBitsToFloat((int) (interfaceC17460n02.d() >> 32));
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L));
                long jE = ZG4.e((Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
                float fIntBitsToFloat3 = Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L)) - fW1;
                InterfaceC17460n02.V0(interfaceC17460n02, j, ZG4.e((Float.floatToRawIntBits(fIntBitsToFloat3) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32)), jE, fW1, 0, null, 0.0f, null, 0, 496, null);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 o(SA2 sa2) {
                AbstractC13042fc3.i(sa2, "$onGoToMessageClicked");
                sa2.invoke();
                return C19938rB7.a;
            }

            public final void f(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                PD3 pd3;
                SA2 sa2;
                int i2;
                e.a aVar;
                C19938rB7 c19938rB7;
                e.a aVar2;
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                G10 g10 = G10.a;
                int i3 = G10.b;
                final long jT = g10.a(interfaceC22053ub1, i3).t();
                final long jC = g10.a(interfaceC22053ub1, i3).C();
                interfaceC22053ub1.W(495969767);
                Object objB = interfaceC22053ub1.B();
                InterfaceC22053ub1.a aVar3 = InterfaceC22053ub1.a;
                if (objB == aVar3.a()) {
                    objB = AbstractC13472gH6.d(null, null, 2, null);
                    interfaceC22053ub1.s(objB);
                }
                InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
                interfaceC22053ub1.Q();
                Long lValueOf = Long.valueOf(this.a.c());
                interfaceC22053ub1.W(495973504);
                boolean zD = interfaceC22053ub1.D(this.a);
                PD3 pd32 = this.a;
                Object objB2 = interfaceC22053ub1.B();
                if (zD || objB2 == aVar3.a()) {
                    objB2 = new C0386a(pd32, interfaceC9102Ym4, null);
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                AbstractC10721c52.e(lValueOf, (InterfaceC14603iB2) objB2, interfaceC22053ub1, 0);
                e.a aVar4 = androidx.compose.ui.e.a;
                androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(aVar4, 0.0f, 1, null), C17784nZ1.q(48)), g10.a(interfaceC22053ub1, i3).w(), null, 2, null);
                interfaceC22053ub1.W(495992496);
                boolean zF = interfaceC22053ub1.f(jC);
                Object objB3 = interfaceC22053ub1.B();
                if (zF || objB3 == aVar3.a()) {
                    objB3 = new UA2() { // from class: ir.nasim.DC3
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return GC3.a.C0385a.n(jC, (InterfaceC17460n02) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                androidx.compose.ui.e eVarB = androidx.compose.ui.draw.b.b(eVarD, (UA2) objB3);
                interfaceC22053ub1.W(496005680);
                boolean zV = interfaceC22053ub1.V(this.b);
                final SA2 sa22 = this.b;
                Object objB4 = interfaceC22053ub1.B();
                if (zV || objB4 == aVar3.a()) {
                    objB4 = new SA2() { // from class: ir.nasim.EC3
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return GC3.a.C0385a.o(sa22);
                        }
                    };
                    interfaceC22053ub1.s(objB4);
                }
                interfaceC22053ub1.Q();
                androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.foundation.e.f(eVarB, false, null, null, (SA2) objB4, 7, null), g10.c(interfaceC22053ub1, i3).b().d(), 0.0f, 2, null);
                InterfaceC12529em.a aVar5 = InterfaceC12529em.a;
                InterfaceC12529em.c cVarI = aVar5.i();
                SA2 sa23 = this.c;
                PD3 pd33 = this.a;
                C24254yJ c24254yJ = C24254yJ.a;
                InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.g(), cVarI, interfaceC22053ub1, 48);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarK);
                InterfaceC16030kb1.a aVar6 = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar6.a();
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
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar6.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar6.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar6.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar6.f());
                M66 m66 = M66.a;
                androidx.compose.ui.e eVarD2 = androidx.compose.foundation.layout.t.d(aVar4, 0.0f, 1, null);
                interfaceC22053ub1.W(-1547303708);
                boolean zF2 = interfaceC22053ub1.f(jT);
                Object objB5 = interfaceC22053ub1.B();
                if (zF2 || objB5 == aVar3.a()) {
                    objB5 = new UA2() { // from class: ir.nasim.FC3
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return GC3.a.C0385a.i(jT, (InterfaceC17460n02) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB5);
                }
                interfaceC22053ub1.Q();
                ZH6.a(androidx.compose.ui.draw.b.b(eVarD2, (UA2) objB5), interfaceC22053ub1, 0);
                ZH6.a(androidx.compose.foundation.layout.t.y(aVar4, g10.c(interfaceC22053ub1, i3).b().u()), interfaceC22053ub1, 0);
                Y03 y03H = h(interfaceC9102Ym4);
                interfaceC22053ub1.W(-1547286418);
                if (y03H == null) {
                    i2 = 0;
                    pd3 = pd33;
                    sa2 = sa23;
                    aVar = aVar4;
                    c19938rB7 = null;
                } else {
                    pd3 = pd33;
                    sa2 = sa23;
                    i2 = 0;
                    aVar = aVar4;
                    AbstractC11456d23.c(y03H, null, FV0.a(androidx.compose.foundation.layout.t.t(aVar4, C17784nZ1.q(32)), N46.d(g10.c(interfaceC22053ub1, i3).a().c())), null, InterfaceC13157fl1.a.a(), 0.0f, null, 0, interfaceC22053ub1, 24624, 232);
                    c19938rB7 = C19938rB7.a;
                }
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-1547286289);
                if (c19938rB7 == null) {
                    aVar2 = aVar;
                    AbstractC11456d23.b(FV4.c(AbstractC15208jB5.live, interfaceC22053ub1, i2), null, androidx.compose.foundation.layout.t.t(aVar2, C17784nZ1.q(32)), null, null, 0.0f, AbstractC24975zX0.a.b(AbstractC24975zX0.b, g10.a(interfaceC22053ub1, i3).I(), 0, 2, null), interfaceC22053ub1, 432, 56);
                    C19938rB7 c19938rB72 = C19938rB7.a;
                } else {
                    aVar2 = aVar;
                }
                interfaceC22053ub1.Q();
                ZH6.a(androidx.compose.foundation.layout.t.y(aVar2, g10.c(interfaceC22053ub1, i3).b().u()), interfaceC22053ub1, i2);
                androidx.compose.ui.e eVarB2 = L66.b(m66, androidx.compose.foundation.layout.t.d(aVar2, 0.0f, 1, null), 1.0f, false, 2, null);
                InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.b(), aVar5.k(), interfaceC22053ub1, 6);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, i2);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarB2);
                SA2 sa2A2 = aVar6.a();
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
                DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A, aVar6.e());
                DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar6.g());
                InterfaceC14603iB2 interfaceC14603iB2B2 = aVar6.b();
                if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                    interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                    interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
                }
                DG7.c(interfaceC22053ub1A2, eVarE2, aVar6.f());
                C9784aZ0 c9784aZ0 = C9784aZ0.a;
                String strF = pd3.f();
                interfaceC22053ub1.W(1065137946);
                if (strF == null) {
                    strF = UY6.c(DD5.media_live, interfaceC22053ub1, i2);
                }
                String str = strF;
                interfaceC22053ub1.Q();
                AbstractC23365wn7.a aVar7 = AbstractC23365wn7.a;
                e.a aVar8 = aVar2;
                AbstractC9105Ym7.b(str, null, g10.a(interfaceC22053ub1, i3).F(), 0L, null, null, null, 0L, null, null, 0L, aVar7.b(), false, 1, 1, null, g10.d(interfaceC22053ub1, i3).o(), interfaceC22053ub1, 0, 27696, 38906);
                InterfaceC10970cW3 interfaceC10970cW3B2 = J66.b(c24254yJ.g(), aVar5.l(), interfaceC22053ub1, 0);
                int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1, aVar8);
                SA2 sa2A3 = aVar6.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A3);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A3 = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A3, interfaceC10970cW3B2, aVar6.e());
                DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar6.g());
                InterfaceC14603iB2 interfaceC14603iB2B3 = aVar6.b();
                if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                    interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                    interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
                }
                DG7.c(interfaceC22053ub1A3, eVarE3, aVar6.f());
                AbstractC9105Ym7.b(XY6.v(pd3.g()), null, g10.a(interfaceC22053ub1, i3).z(), 0L, null, null, null, 0L, null, null, 0L, aVar7.b(), false, 0, 0, null, g10.d(interfaceC22053ub1, i3).e(), interfaceC22053ub1, 0, 48, SetRpcStruct$ComposedRpc.RESPONSE_GET_WEBVIEW_TRACKING_NUMBER_FIELD_NUMBER);
                ZH6.a(androidx.compose.foundation.layout.t.y(aVar8, g10.c(interfaceC22053ub1, i3).b().n()), interfaceC22053ub1, 0);
                AbstractC9105Ym7.b(UY6.c(DD5.live_bar_viewers, interfaceC22053ub1, 0), null, g10.a(interfaceC22053ub1, i3).z(), 0L, null, null, null, 0L, null, null, 0L, aVar7.b(), false, 0, 0, null, g10.d(interfaceC22053ub1, i3).e(), interfaceC22053ub1, 0, 48, SetRpcStruct$ComposedRpc.RESPONSE_GET_WEBVIEW_TRACKING_NUMBER_FIELD_NUMBER);
                interfaceC22053ub1.u();
                interfaceC22053ub1.u();
                ZH6.a(androidx.compose.foundation.layout.t.y(aVar8, g10.c(interfaceC22053ub1, i3).b().r()), interfaceC22053ub1, 0);
                AbstractC17932no0.Q(sa2, InterfaceC19114po0.c.b.a, UY6.c(DD5.live_bar_watch_button, interfaceC22053ub1, 0), null, null, interfaceC22053ub1, InterfaceC19114po0.c.b.b << 3, 24);
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                f((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(PD3 pd3, SA2 sa2, SA2 sa22) {
            this.a = pd3;
            this.b = sa2;
            this.c = sa22;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), AbstractC19242q11.e(-1653596281, true, new C0385a(this.a, this.b, this.c), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void c(final PD3 pd3, final SA2 sa2, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(pd3, "state");
        AbstractC13042fc3.i(sa2, "onWatchLiveClicked");
        AbstractC13042fc3.i(sa22, "onGoToMessageClicked");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-2070513950);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(pd3) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, AbstractC19242q11.e(-1380336569, true, new a(pd3, sa22, sa2), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.CC3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return GC3.d(pd3, sa2, sa22, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(PD3 pd3, SA2 sa2, SA2 sa22, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(pd3, "$state");
        AbstractC13042fc3.i(sa2, "$onWatchLiveClicked");
        AbstractC13042fc3.i(sa22, "$onGoToMessageClicked");
        c(pd3, sa2, sa22, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void e(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1728582877);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.BC3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return GC3.f(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        e(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
