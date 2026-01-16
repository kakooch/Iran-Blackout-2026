package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.AbstractC14472hy4;
import ir.nasim.AbstractC15289jK5;
import ir.nasim.C13245fu;
import ir.nasim.C6399Nk7;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.OA2;

/* renamed from: ir.nasim.jK5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC15289jK5 {

    /* renamed from: ir.nasim.jK5$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;

        a(SA2 sa2) {
            this.a = sa2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC21639ts7.i(UY6.c(QD5.two_f_a_setting, interfaceC22053ub1, 0), null, this.a, null, null, null, null, interfaceC22053ub1, 0, 122);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.jK5$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ UA2 d;
        final /* synthetic */ int e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ SA2 g;
        final /* synthetic */ boolean h;
        final /* synthetic */ UA2 i;
        final /* synthetic */ UA2 j;

        /* renamed from: ir.nasim.jK5$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ SA2 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = sa2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            /* JADX WARN: Removed duplicated region for block: B:11:0x002a A[RETURN] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:12:0x002b). Please report as a decompilation issue!!! */
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
                    goto L2b
                Lf:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r0)
                    throw r6
                L17:
                    ir.nasim.AbstractC10685c16.b(r6)
                L1a:
                    ir.nasim.Q12$a r6 = ir.nasim.Q12.b
                    ir.nasim.W12 r6 = ir.nasim.W12.e
                    long r3 = ir.nasim.T12.s(r2, r6)
                    r5.b = r2
                    java.lang.Object r6 = ir.nasim.HG1.c(r3, r5)
                    if (r6 != r0) goto L2b
                    return r0
                L2b:
                    ir.nasim.SA2 r6 = r5.c
                    r6.invoke()
                    goto L1a
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC15289jK5.b.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(String str, String str2, String str3, UA2 ua2, int i, SA2 sa2, SA2 sa22, boolean z, UA2 ua22, UA2 ua23) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = ua2;
            this.e = i;
            this.f = sa2;
            this.g = sa22;
            this.h = z;
            this.i = ua22;
            this.j = ua23;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(boolean z, String str, UA2 ua2, Context context, UA2 ua22) {
            AbstractC13042fc3.i(str, "$code");
            AbstractC13042fc3.i(ua2, "$onError");
            AbstractC13042fc3.i(context, "$context");
            if (z) {
                return C19938rB7.a;
            }
            if (str.length() == 0) {
                String string = context.getString(QD5.req_email_code_for_two_f_a);
                AbstractC13042fc3.h(string, "getString(...)");
                ua2.invoke(string);
            } else {
                ua22.invoke(str);
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(InterfaceC20600sH6 interfaceC20600sH6, InterfaceC10566bp3 interfaceC10566bp3) {
            AbstractC13042fc3.i(interfaceC10566bp3, "$this$KeyboardActions");
            if (interfaceC20600sH6 != null) {
                interfaceC20600sH6.b();
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onResendCode");
            sa2.invoke();
            return C19938rB7.a;
        }

        public final void d(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            e.a aVar;
            int i3;
            AbstractC13042fc3.i(ts4, "it");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(ts4) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.f(aVar2, 0.0f, 1, null), 0.0f, ts4.c(), 0.0f, 0.0f, 13, null);
            G10 g10 = G10.a;
            int i4 = G10.b;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(eVarM, g10.a(interfaceC22053ub1, i4).r(), null, 2, null);
            String str = this.a;
            String str2 = this.b;
            final String str3 = this.c;
            UA2 ua2 = this.d;
            int i5 = this.e;
            SA2 sa2 = this.f;
            final SA2 sa22 = this.g;
            final boolean z = this.h;
            final UA2 ua22 = this.i;
            final UA2 ua23 = this.j;
            InterfaceC12529em.a aVar3 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar3.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD);
            InterfaceC16030kb1.a aVar4 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar4.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar4.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar4.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar4.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(hVar.h(aVar2, aVar3.m()), g10.c(interfaceC22053ub1, i4).b().c(), 0.0f, 2, null);
            C24254yJ c24254yJ = C24254yJ.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), aVar3.k(), interfaceC22053ub1, 0);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarK);
            SA2 sa2A2 = aVar4.a();
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
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A, aVar4.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar4.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar4.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar2, C17784nZ1.q(48)), interfaceC22053ub1, 6);
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar2, 0.0f, 1, null);
            String strC = UY6.c(QD5.change_phone_code_base, interfaceC22053ub1, 0);
            long jF = g10.a(interfaceC22053ub1, i4).F();
            C9348Zn7 c9348Zn7L = g10.d(interfaceC22053ub1, i4).l();
            C6399Nk7.a aVar5 = C6399Nk7.b;
            AbstractC9339Zm7.b(strC, eVarH, jF, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7L.b((16744447 & 1) != 0 ? c9348Zn7L.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7L.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7L.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7L.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7L.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7L.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7L.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7L.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7L.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7L.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7L.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7L.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7L.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7L.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7L.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7L.b.h() : aVar5.a(), (16744447 & 65536) != 0 ? c9348Zn7L.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7L.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7L.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7L.c : null, (16744447 & 1048576) != 0 ? c9348Zn7L.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7L.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7L.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7L.b.k() : null), interfaceC22053ub1, 48, 0, 65528);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar2, g10.c(interfaceC22053ub1, i4).b().c()), interfaceC22053ub1, 0);
            androidx.compose.ui.e eVarH2 = androidx.compose.foundation.layout.t.h(aVar2, 0.0f, 1, null);
            String strD = UY6.d(QD5.email_two_f_a_set_desc_validation, new Object[]{str}, interfaceC22053ub1, 0);
            long jZ = g10.a(interfaceC22053ub1, i4).z();
            C9348Zn7 c9348Zn7A = g10.d(interfaceC22053ub1, i4).a();
            AbstractC9339Zm7.b(strD, eVarH2, jZ, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7A.b((16744447 & 1) != 0 ? c9348Zn7A.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7A.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7A.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7A.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7A.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7A.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7A.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7A.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7A.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7A.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7A.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7A.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7A.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7A.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7A.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7A.b.h() : aVar5.a(), (16744447 & 65536) != 0 ? c9348Zn7A.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7A.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7A.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7A.c : null, (16744447 & 1048576) != 0 ? c9348Zn7A.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7A.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7A.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7A.b.k() : null), interfaceC22053ub1, 48, 0, 65528);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar2, g10.c(interfaceC22053ub1, i4).b().e()), interfaceC22053ub1, 0);
            final InterfaceC20600sH6 interfaceC20600sH6 = (InterfaceC20600sH6) interfaceC22053ub1.H(AbstractC13040fc1.r());
            androidx.compose.ui.e eVarH3 = androidx.compose.foundation.layout.t.h(aVar2, 0.0f, 1, null);
            String strC2 = UY6.c(QD5.change_phone_code_base, interfaceC22053ub1, 0);
            String strB = AbstractC12152e76.b("123456");
            AbstractC14472hy4 dVar = (str2 == null || str2.length() == 0) ? new AbstractC14472hy4.d(null, null, null, 7, null) : new AbstractC14472hy4.a(Integer.valueOf(AbstractC21822uB5.danger), str2, null, 4, null);
            C21605tp3 c21605tp3 = new C21605tp3(0, null, C22785vp3.b.d(), S33.b.b(), null, null, null, 115, null);
            interfaceC22053ub1.W(-1549116082);
            boolean zV = interfaceC22053ub1.V(interfaceC20600sH6);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.kK5
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC15289jK5.b.h(interfaceC20600sH6, (InterfaceC10566bp3) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC8426Vx4.e0(str3, ua2, strC2, strB, eVarH3, null, false, false, null, null, dVar, c21605tp3, new C11329cp3((UA2) objB, null, null, null, null, null, 62, null), true, 0, 0, null, null, true, false, null, true, interfaceC22053ub1, 24576, AbstractC14472hy4.a | 100666416, 48, 1819616);
            if (i5 > 0) {
                interfaceC22053ub1.W(-777713260);
                interfaceC22053ub1.W(-1549107376);
                C13245fu.b bVar = new C13245fu.b(0, 1, null);
                interfaceC22053ub1.W(-1549106145);
                int iN = bVar.n(new C12863fI6(g10.a(interfaceC22053ub1, i4).I(), 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, 65534, (ED1) null));
                try {
                    bVar.h(AbstractC12152e76.b(UY6.d(QD5.time_duration_seconds, new Object[]{Integer.valueOf(i5)}, interfaceC22053ub1, 0)) + Separators.SP);
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    bVar.l(iN);
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(-1549093169);
                    iN = bVar.n(new C12863fI6(g10.a(interfaceC22053ub1, i4).B(), 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, 65534, (ED1) null));
                    try {
                        bVar.h(UY6.c(QD5.until_req_new_code, interfaceC22053ub1, 0));
                        bVar.l(iN);
                        interfaceC22053ub1.Q();
                        C13245fu c13245fuO = bVar.o();
                        interfaceC22053ub1.Q();
                        androidx.compose.ui.e eVarH4 = androidx.compose.foundation.layout.t.h(aVar2, 0.0f, 1, null);
                        C9348Zn7 c9348Zn7O = g10.d(interfaceC22053ub1, i4).o();
                        aVar = aVar2;
                        AbstractC9339Zm7.c(c13245fuO, eVarH4, g10.a(interfaceC22053ub1, i4).B(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, c9348Zn7O.b((16744447 & 1) != 0 ? c9348Zn7O.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7O.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7O.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7O.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7O.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7O.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7O.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7O.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7O.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7O.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7O.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7O.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7O.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7O.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7O.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7O.b.h() : aVar5.a(), (16744447 & 65536) != 0 ? c9348Zn7O.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7O.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7O.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7O.c : null, (16744447 & 1048576) != 0 ? c9348Zn7O.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7O.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7O.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7O.b.k() : null), interfaceC22053ub1, 48, 0, 131064);
                        C19938rB7 c19938rB72 = C19938rB7.a;
                        interfaceC22053ub1.W(-1549074933);
                        boolean zV2 = interfaceC22053ub1.V(sa2);
                        Object objB2 = interfaceC22053ub1.B();
                        if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                            objB2 = new a(sa2, null);
                            interfaceC22053ub1.s(objB2);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC10721c52.e(c19938rB72, (InterfaceC14603iB2) objB2, interfaceC22053ub1, 6);
                        interfaceC22053ub1.Q();
                        i3 = i4;
                    } finally {
                    }
                } finally {
                }
            } else {
                aVar = aVar2;
                interfaceC22053ub1.W(-776468920);
                interfaceC22053ub1.W(-1549061821);
                Object objB3 = interfaceC22053ub1.B();
                InterfaceC22053ub1.a aVar6 = InterfaceC22053ub1.a;
                if (objB3 == aVar6.a()) {
                    objB3 = AbstractC23831xb3.a();
                    interfaceC22053ub1.s(objB3);
                }
                InterfaceC18507om4 interfaceC18507om4 = (InterfaceC18507om4) objB3;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-1549059510);
                boolean zV3 = interfaceC22053ub1.V(sa22);
                Object objB4 = interfaceC22053ub1.B();
                if (zV3 || objB4 == aVar6.a()) {
                    objB4 = new SA2() { // from class: ir.nasim.lK5
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC15289jK5.b.i(sa22);
                        }
                    };
                    interfaceC22053ub1.s(objB4);
                }
                interfaceC22053ub1.Q();
                androidx.compose.ui.e eVarH5 = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.e.d(aVar, interfaceC18507om4, null, false, null, null, (SA2) objB4, 28, null), 0.0f, 1, null);
                String strC3 = UY6.c(QD5.send_email_code_again, interfaceC22053ub1, 0);
                long jI = g10.a(interfaceC22053ub1, i4).I();
                C9348Zn7 c9348Zn7O2 = g10.d(interfaceC22053ub1, i4).o();
                i3 = i4;
                AbstractC9339Zm7.b(strC3, eVarH5, jI, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7O2.b((16744447 & 1) != 0 ? c9348Zn7O2.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7O2.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7O2.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7O2.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7O2.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7O2.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7O2.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7O2.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7O2.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7O2.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7O2.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7O2.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7O2.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7O2.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7O2.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7O2.b.h() : aVar5.a(), (16744447 & 65536) != 0 ? c9348Zn7O2.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7O2.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7O2.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7O2.c : null, (16744447 & 1048576) != 0 ? c9348Zn7O2.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7O2.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7O2.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7O2.b.k() : null), interfaceC22053ub1, 0, 0, 65528);
                interfaceC22053ub1.Q();
            }
            interfaceC22053ub1.u();
            e.a aVar7 = aVar;
            androidx.compose.ui.e eVarH6 = androidx.compose.foundation.layout.t.h(hVar.h(aVar7, aVar3.b()), 0.0f, 1, null);
            InterfaceC10970cW3 interfaceC10970cW3A2 = XY0.a(c24254yJ.a(), aVar3.g(), interfaceC22053ub1, 54);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarH6);
            SA2 sa2A3 = aVar4.a();
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
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3A2, aVar4.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar4.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar4.f());
            int i6 = i3;
            ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar7, 0.0f, 1, null), C17784nZ1.q(1)), 0.0f, g10.a(interfaceC22053ub1, i6).A(), interfaceC22053ub1, 6, 2);
            final Context context = (Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g());
            androidx.compose.ui.e eVarH7 = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.i(aVar7, g10.c(interfaceC22053ub1, i6).b().c()), 0.0f, 1, null);
            interfaceC22053ub1.W(-1549020956);
            boolean zA = interfaceC22053ub1.a(z) | interfaceC22053ub1.V(str3) | interfaceC22053ub1.V(ua22) | interfaceC22053ub1.D(context) | interfaceC22053ub1.V(ua23);
            Object objB5 = interfaceC22053ub1.B();
            if (zA || objB5 == InterfaceC22053ub1.a.a()) {
                objB5 = new SA2() { // from class: ir.nasim.mK5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC15289jK5.b.f(z, str3, ua22, context, ua23);
                    }
                };
                interfaceC22053ub1.s(objB5);
            }
            SA2 sa23 = (SA2) objB5;
            interfaceC22053ub1.Q();
            AbstractC17932no0.y(eVarH7, sa23, z ? OA2.a.b : str3.length() == 0 ? OA2.b.a.c : OA2.b.C0545b.c, null, UY6.c(QD5.Done, interfaceC22053ub1, 0), null, interfaceC22053ub1, OA2.a << 6, 40);
            interfaceC22053ub1.u();
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            d((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void d(ir.nasim.SA2 r36, ir.nasim.UA2 r37, final java.lang.String r38, final java.lang.String r39, final ir.nasim.UA2 r40, java.lang.String r41, final ir.nasim.UA2 r42, final ir.nasim.SA2 r43, final int r44, final ir.nasim.SA2 r45, boolean r46, ir.nasim.InterfaceC22053ub1 r47, final int r48, final int r49, final int r50) {
        /*
            Method dump skipped, instructions count: 619
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC15289jK5.d(ir.nasim.SA2, ir.nasim.UA2, java.lang.String, java.lang.String, ir.nasim.UA2, java.lang.String, ir.nasim.UA2, ir.nasim.SA2, int, ir.nasim.SA2, boolean, ir.nasim.ub1, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(String str) {
        AbstractC13042fc3.i(str, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(SA2 sa2, UA2 ua2, String str, String str2, UA2 ua22, String str3, UA2 ua23, SA2 sa22, int i, SA2 sa23, boolean z, int i2, int i3, int i4, InterfaceC22053ub1 interfaceC22053ub1, int i5) {
        AbstractC13042fc3.i(str, "$email");
        AbstractC13042fc3.i(str2, "$code");
        AbstractC13042fc3.i(ua22, "$onCodeChange");
        AbstractC13042fc3.i(ua23, "$onError");
        AbstractC13042fc3.i(sa22, "$onResendCode");
        AbstractC13042fc3.i(sa23, "$onCountDown");
        d(sa2, ua2, str, str2, ua22, str3, ua23, sa22, i, sa23, z, interfaceC22053ub1, QJ5.a(i2 | 1), QJ5.a(i3), i4);
        return C19938rB7.a;
    }
}
