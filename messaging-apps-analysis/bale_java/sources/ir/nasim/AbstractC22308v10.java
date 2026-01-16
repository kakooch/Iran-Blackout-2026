package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC22308v10;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;

/* renamed from: ir.nasim.v10, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC22308v10 {

    /* renamed from: ir.nasim.v10$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ boolean d;
        final /* synthetic */ int e;
        final /* synthetic */ int f;
        final /* synthetic */ InterfaceC17916nm4 g;
        final /* synthetic */ InterfaceC17916nm4 h;
        final /* synthetic */ InterfaceC9102Ym4 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z, boolean z2, int i, int i2, InterfaceC17916nm4 interfaceC17916nm4, InterfaceC17916nm4 interfaceC17916nm42, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = z;
            this.d = z2;
            this.e = i;
            this.f = i2;
            this.g = interfaceC17916nm4;
            this.h = interfaceC17916nm42;
            this.i = interfaceC9102Ym4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, this.f, this.g, this.h, this.i, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0063  */
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
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                ir.nasim.AbstractC10685c16.b(r6)
                goto L50
            Lf:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L17:
                ir.nasim.AbstractC10685c16.b(r6)
                boolean r6 = r5.c
                if (r6 == 0) goto L55
                boolean r6 = r5.d
                if (r6 == 0) goto L55
                int r6 = r5.e
                ir.nasim.nm4 r1 = r5.g
                int r1 = ir.nasim.AbstractC22308v10.z(r1)
                if (r6 <= r1) goto L55
                int r6 = r5.f
                int r1 = r5.e
                if (r6 > r1) goto L55
                ir.nasim.nm4 r1 = r5.h
                int r1 = ir.nasim.AbstractC22308v10.B(r1)
                if (r6 <= r1) goto L55
                int r6 = r5.f
                ir.nasim.nm4 r1 = r5.h
                int r1 = ir.nasim.AbstractC22308v10.B(r1)
                int r6 = r6 - r1
                int r6 = r6 - r2
                int r6 = r6 * 100
                long r3 = (long) r6
                r5.b = r2
                java.lang.Object r6 = ir.nasim.HG1.b(r3, r5)
                if (r6 != r0) goto L50
                return r0
            L50:
                ir.nasim.Ym4 r6 = r5.i
                ir.nasim.AbstractC22308v10.y(r6, r2)
            L55:
                int r6 = r5.e
                ir.nasim.nm4 r0 = r5.g
                int r0 = ir.nasim.AbstractC22308v10.z(r0)
                if (r6 < r0) goto L63
                int r6 = r5.e
                if (r6 != 0) goto L72
            L63:
                ir.nasim.nm4 r6 = r5.h
                int r0 = ir.nasim.AbstractC22308v10.B(r6)
                int r1 = r5.e
                int r0 = java.lang.Math.min(r0, r1)
                ir.nasim.AbstractC22308v10.C(r6, r0)
            L72:
                ir.nasim.nm4 r6 = r5.g
                int r0 = r5.e
                ir.nasim.AbstractC22308v10.A(r6, r0)
                ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC22308v10.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.v10$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ float d;
        final /* synthetic */ long e;
        final /* synthetic */ long f;
        final /* synthetic */ boolean g;
        final /* synthetic */ UA2 h;

        b(androidx.compose.ui.e eVar, int i, int i2, float f, long j, long j2, boolean z, UA2 ua2) {
            this.a = eVar;
            this.b = i;
            this.c = i2;
            this.d = f;
            this.e = j;
            this.f = j2;
            this.g = z;
            this.h = ua2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Context context, int i, int i2, InterfaceC11943do6 interfaceC11943do6) {
            AbstractC13042fc3.i(context, "$context");
            AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
            AbstractC9939ao6.e0(interfaceC11943do6, context.getString(UD5.rate_stars_rating_content_description, Integer.valueOf(i), Integer.valueOf(i2)));
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(UA2 ua2, int i) {
            AbstractC13042fc3.i(ua2, "$onRatingChange");
            ua2.invoke(Integer.valueOf(i));
            return C19938rB7.a;
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            InterfaceC22053ub1 interfaceC22053ub12 = interfaceC22053ub1;
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            final Context context = (Context) interfaceC22053ub12.H(AndroidCompositionLocals_androidKt.g());
            androidx.compose.ui.e eVar = this.a;
            interfaceC22053ub12.W(-599627429);
            boolean zD = interfaceC22053ub12.D(context) | interfaceC22053ub12.e(this.b) | interfaceC22053ub12.e(this.c);
            final int i2 = this.b;
            final int i3 = this.c;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.w10
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC22308v10.b.d(context, i2, i3, (InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub12.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarD = AbstractC6919Pn6.d(eVar, false, (UA2) objB, 1, null);
            C24254yJ c24254yJ = C24254yJ.a;
            float fJ = G10.a.c(interfaceC22053ub12, 6).b().j();
            InterfaceC12529em.a aVar = InterfaceC12529em.a;
            C24254yJ.e eVarP = c24254yJ.p(fJ, aVar.g());
            InterfaceC12529em.c cVarI = aVar.i();
            int i4 = this.c;
            int i5 = this.b;
            float f = this.d;
            long j = this.e;
            long j2 = this.f;
            boolean z = this.g;
            final UA2 ua2 = this.h;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(eVarP, cVarI, interfaceC22053ub12, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub12, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub12, eVarD);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub12.g(sa2A);
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
            interfaceC22053ub12.W(-1461465080);
            final int i6 = 0;
            while (i6 < i4) {
                i6++;
                boolean z2 = i6 <= i5;
                C24254yJ c24254yJ2 = C24254yJ.a;
                G10 g10 = G10.a;
                C24254yJ.f fVarO = c24254yJ2.o(g10.c(interfaceC22053ub12, 6).b().u());
                InterfaceC12529em.b bVarG = InterfaceC12529em.a.g();
                e.a aVar3 = androidx.compose.ui.e.a;
                int i7 = i4;
                InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(fVarO, bVarG, interfaceC22053ub12, 48);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub12, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub12, aVar3);
                InterfaceC16030kb1.a aVar4 = InterfaceC16030kb1.d0;
                SA2 sa2A2 = aVar4.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub12.g(sa2A2);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A, aVar4.e());
                DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar4.g());
                InterfaceC14603iB2 interfaceC14603iB2B2 = aVar4.b();
                if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                    interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                    interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
                }
                DG7.c(interfaceC22053ub1A2, eVarE2, aVar4.f());
                C9784aZ0 c9784aZ0 = C9784aZ0.a;
                interfaceC22053ub12.W(-1750179107);
                boolean zV = interfaceC22053ub12.V(ua2) | interfaceC22053ub12.e(i6);
                Object objB2 = interfaceC22053ub1.B();
                if (zV || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.x10
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC22308v10.b.f(ua2, i6);
                        }
                    };
                    interfaceC22053ub12.s(objB2);
                }
                interfaceC22053ub1.Q();
                boolean z3 = z;
                long j3 = j2;
                long j4 = j;
                float f2 = f;
                int i8 = i5;
                UA2 ua22 = ua2;
                boolean z4 = z2;
                AbstractC22308v10.f(z2, i6, i5, f, j, j3, z3, (SA2) objB2, interfaceC22053ub1, 0);
                AbstractC9339Zm7.b(AbstractC12152e76.d(String.valueOf(i6), interfaceC22053ub12, 0), null, z4 ? j4 : j3, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub12, 6).k(), interfaceC22053ub1, 0, 0, 65530);
                interfaceC22053ub1.u();
                interfaceC22053ub12 = interfaceC22053ub1;
                z = z3;
                j2 = j3;
                j = j4;
                f = f2;
                i5 = i8;
                i4 = i7;
                ua2 = ua22;
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final boolean z, final int i, final int i2, final float f, final long j, final long j2, final boolean z2, final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i3) {
        int i4;
        final InterfaceC17916nm4 interfaceC17916nm4;
        int i5;
        int i6;
        int i7;
        Integer num;
        InterfaceC9664aL6 interfaceC9664aL6;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1661695483);
        if ((i3 & 6) == 0) {
            i4 = (interfaceC22053ub1J.a(z) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= interfaceC22053ub1J.e(i) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= interfaceC22053ub1J.e(i2) ? 256 : 128;
        }
        if ((i3 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i4 |= interfaceC22053ub1J.c(f) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= interfaceC22053ub1J.f(j) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i4 |= interfaceC22053ub1J.f(j2) ? 131072 : 65536;
        }
        if ((i3 & 1572864) == 0) {
            i4 |= interfaceC22053ub1J.a(z2) ? 1048576 : 524288;
        }
        if ((i3 & 12582912) == 0) {
            i4 |= interfaceC22053ub1J.D(sa2) ? 8388608 : 4194304;
        }
        if ((i4 & 4793491) == 4793490 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(1596667262);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = UG6.a(0);
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC17916nm4 interfaceC17916nm42 = (InterfaceC17916nm4) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1596669310);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                objB2 = UG6.a(0);
                interfaceC22053ub1J.s(objB2);
            }
            InterfaceC17916nm4 interfaceC17916nm43 = (InterfaceC17916nm4) objB2;
            interfaceC22053ub1J.Q();
            float f2 = (z && z2) ? 1.15f : 1.0f;
            InterfaceC9664aL6 interfaceC9664aL6D = AbstractC4572Fs.d(f2, AbstractC5999Lt.j(0.5f, 200.0f, null, 4, null), 0.0f, "star_scale_" + i, null, interfaceC22053ub1J, 48, 20);
            long j3 = z ? j : j2;
            InterfaceC9664aL6 interfaceC9664aL6A = BD6.a(j3, AbstractC5999Lt.l(300, 0, T22.d(), 2, null), "star_color_" + i, null, interfaceC22053ub1J, 0, 8);
            interfaceC22053ub1J.W(1596690271);
            Object objB3 = interfaceC22053ub1J.B();
            if (objB3 == aVar.a()) {
                objB3 = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                interfaceC22053ub1J.s(objB3);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB3;
            interfaceC22053ub1J.Q();
            float f3 = (g(interfaceC9102Ym4) && z2) ? 360.0f : 0.0f;
            C7479Rw7 c7479Rw7L = AbstractC5999Lt.l(SIPTransactionStack.BASE_TIMER_INTERVAL, 0, T22.d(), 2, null);
            String str = "star_rotation_" + i;
            interfaceC22053ub1J.W(1596699917);
            int i8 = i4 & 896;
            boolean z3 = i8 == 256;
            Object objB4 = interfaceC22053ub1J.B();
            if (z3 || objB4 == aVar.a()) {
                interfaceC17916nm4 = interfaceC17916nm43;
                objB4 = new UA2() { // from class: ir.nasim.s10
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC22308v10.i(i2, interfaceC9102Ym4, interfaceC17916nm4, ((Float) obj).floatValue());
                    }
                };
                interfaceC22053ub1J.s(objB4);
            } else {
                interfaceC17916nm4 = interfaceC17916nm43;
            }
            interfaceC22053ub1J.Q();
            InterfaceC17916nm4 interfaceC17916nm44 = interfaceC17916nm4;
            InterfaceC9664aL6 interfaceC9664aL6D2 = AbstractC4572Fs.d(f3, c7479Rw7L, 0.0f, str, (UA2) objB4, interfaceC22053ub1J, 0, 4);
            Integer numValueOf = Integer.valueOf(i2);
            interfaceC22053ub1J.W(1596707464);
            int i9 = i4 & 3670016;
            int i10 = i4 & 14;
            boolean z4 = (i9 == 1048576) | (i10 == 4) | (i8 == 256) | ((i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32);
            Object objB5 = interfaceC22053ub1J.B();
            if (z4 || objB5 == aVar.a()) {
                i5 = i4;
                i6 = i10;
                i7 = i9;
                num = numValueOf;
                interfaceC9664aL6 = interfaceC9664aL6D2;
                a aVar2 = new a(z2, z, i2, i, interfaceC17916nm42, interfaceC17916nm44, interfaceC9102Ym4, null);
                interfaceC22053ub1J.s(aVar2);
                objB5 = aVar2;
            } else {
                i5 = i4;
                i6 = i10;
                i7 = i9;
                num = numValueOf;
                interfaceC9664aL6 = interfaceC9664aL6D2;
            }
            interfaceC22053ub1J.Q();
            AbstractC10721c52.e(num, (InterfaceC14603iB2) objB5, interfaceC22053ub1J, (i5 >> 6) & 14);
            C21097t63 c21097t63C = AbstractC22957w63.c("star_pulse_" + i, interfaceC22053ub1J, 0, 0);
            float f4 = (z && z2) ? 1.05f : 1.0f;
            final InterfaceC9664aL6 interfaceC9664aL6A2 = AbstractC22957w63.a(c21097t63C, 1.0f, f4, AbstractC5999Lt.e(AbstractC5999Lt.l(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, 0, T22.e(), 2, null), EO5.b, 0L, 4, null), "star_pulse_animation_" + i, interfaceC22053ub1J, C21097t63.f | 48 | (C20494s63.d << 9), 0);
            EV4 ev4C = FV4.c(AbstractC24188yB5.bold_star_fil, interfaceC22053ub1J, 0);
            String str2 = "Star " + i;
            long jS = s(interfaceC9664aL6A);
            androidx.compose.ui.e eVarA = AbstractC18409oc6.a(androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, f), r(interfaceC9664aL6D));
            interfaceC22053ub1J.W(1596746993);
            final InterfaceC9664aL6 interfaceC9664aL62 = interfaceC9664aL6;
            boolean zV = interfaceC22053ub1J.V(interfaceC9664aL62) | (i6 == 4) | (i7 == 1048576) | interfaceC22053ub1J.V(interfaceC9664aL6A2);
            Object objB6 = interfaceC22053ub1J.B();
            if (zV || objB6 == aVar.a()) {
                objB6 = new UA2() { // from class: ir.nasim.t10
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC22308v10.l(z, z2, interfaceC9664aL62, interfaceC9664aL6A2, (androidx.compose.ui.graphics.c) obj);
                    }
                };
                interfaceC22053ub1J.s(objB6);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarA2 = androidx.compose.ui.graphics.b.a(eVarA, (UA2) objB6);
            interfaceC22053ub1J.W(1596757796);
            Object objB7 = interfaceC22053ub1J.B();
            if (objB7 == aVar.a()) {
                objB7 = AbstractC23831xb3.a();
                interfaceC22053ub1J.s(objB7);
            }
            interfaceC22053ub1J.Q();
            AbstractC24077y03.b(ev4C, str2, androidx.compose.foundation.layout.q.i(androidx.compose.foundation.e.d(eVarA2, (InterfaceC18507om4) objB7, null, false, null, null, sa2, 28, null), G10.a.c(interfaceC22053ub1J, 6).b().n()), jS, interfaceC22053ub1J, 0, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.u10
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC22308v10.n(z, i, i2, f, j, j2, z2, sa2, i3, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean g(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(int i, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC17916nm4 interfaceC17916nm4, float f) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$triggerRotation$delegate");
        AbstractC13042fc3.i(interfaceC17916nm4, "$lastAnimatedRating$delegate");
        if (g(interfaceC9102Ym4)) {
            h(interfaceC9102Ym4, false);
            q(interfaceC17916nm4, i);
        }
        return C19938rB7.a;
    }

    private static final float j(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    private static final float k(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(boolean z, boolean z2, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, androidx.compose.ui.graphics.c cVar) {
        AbstractC13042fc3.i(interfaceC9664aL6, "$rotation$delegate");
        AbstractC13042fc3.i(interfaceC9664aL62, "$pulseScale$delegate");
        AbstractC13042fc3.i(cVar, "$this$graphicsLayer");
        cVar.l(j(interfaceC9664aL6));
        float fK = 1.0f;
        cVar.g((z && z2) ? k(interfaceC9664aL62) : 1.0f);
        if (z && z2) {
            fK = k(interfaceC9664aL62);
        }
        cVar.m(fK);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int m(InterfaceC17916nm4 interfaceC17916nm4) {
        return interfaceC17916nm4.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(boolean z, int i, int i2, float f, long j, long j2, boolean z2, SA2 sa2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(sa2, "$onClick");
        f(z, i, i2, f, j, j2, z2, sa2, interfaceC22053ub1, QJ5.a(i3 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(InterfaceC17916nm4 interfaceC17916nm4, int i) {
        interfaceC17916nm4.h(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p(InterfaceC17916nm4 interfaceC17916nm4) {
        return interfaceC17916nm4.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(InterfaceC17916nm4 interfaceC17916nm4, int i) {
        interfaceC17916nm4.h(i);
    }

    private static final float r(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    private static final long s(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((C24381yX0) interfaceC9664aL6.getValue()).y();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void t(final int r25, final ir.nasim.UA2 r26, androidx.compose.ui.e r27, int r28, float r29, long r30, long r32, boolean r34, ir.nasim.InterfaceC22053ub1 r35, final int r36, final int r37) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC22308v10.t(int, ir.nasim.UA2, androidx.compose.ui.e, int, float, long, long, boolean, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(int i, UA2 ua2, androidx.compose.ui.e eVar, int i2, float f, long j, long j2, boolean z, int i3, int i4, InterfaceC22053ub1 interfaceC22053ub1, int i5) {
        AbstractC13042fc3.i(ua2, "$onRatingChange");
        t(i, ua2, eVar, i2, f, j, j2, z, interfaceC22053ub1, QJ5.a(i3 | 1), i4);
        return C19938rB7.a;
    }

    public static final void v(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1871898413);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, C23505x21.a.a(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.q10
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC22308v10.w(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        v(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
