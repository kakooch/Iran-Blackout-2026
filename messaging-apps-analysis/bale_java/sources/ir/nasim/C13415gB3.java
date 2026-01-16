package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.util.Patterns;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC23365wn7;
import ir.nasim.C13415gB3;
import ir.nasim.C24254yJ;
import ir.nasim.C6399Nk7;
import ir.nasim.C9475a16;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.LX;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.gB3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C13415gB3 extends RecyclerView.C {
    private C9562aA3 A;
    private final ComposeView u;
    private final InterfaceC10258bL6 v;
    private final InterfaceC10258bL6 w;
    private final InterfaceC14603iB2 x;
    private final UA2 y;
    private final C11458d25 z;

    /* renamed from: ir.nasim.gB3$a */
    public static final class a {
        private final String a;
        private final int b;
        private final int c;

        public a(String str, int i, int i2) {
            AbstractC13042fc3.i(str, "url");
            this.a = str;
            this.b = i;
            this.c = i2;
        }

        public final String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && this.b == aVar.b && this.c == aVar.c;
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c);
        }

        public String toString() {
            return "LinkInfos(url=" + this.a + ", start=" + this.b + ", end=" + this.c + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.gB3$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ C9562aA3 a;
        final /* synthetic */ C13415gB3 b;
        final /* synthetic */ AbstractC17457n0 c;

        /* renamed from: ir.nasim.gB3$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C9562aA3 a;
            final /* synthetic */ C13415gB3 b;
            final /* synthetic */ AbstractC17457n0 c;

            /* renamed from: ir.nasim.gB3$b$a$a, reason: collision with other inner class name */
            static final class C1250a implements InterfaceC15796kB2 {
                final /* synthetic */ C9562aA3 a;
                final /* synthetic */ C13415gB3 b;
                final /* synthetic */ InterfaceC9664aL6 c;
                final /* synthetic */ InterfaceC9664aL6 d;

                C1250a(C9562aA3 c9562aA3, C13415gB3 c13415gB3, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62) {
                    this.a = c9562aA3;
                    this.b = c13415gB3;
                    this.c = interfaceC9664aL6;
                    this.d = interfaceC9664aL62;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(C13415gB3 c13415gB3, boolean z) {
                    AbstractC13042fc3.i(c13415gB3, "this$0");
                    c13415gB3.y.invoke(Integer.valueOf(c13415gB3.I()));
                    return C19938rB7.a;
                }

                public final void b(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC22821vt, "$this$AnimatedVisibility");
                    C9562aA3 c9562aA3 = this.a;
                    final C13415gB3 c13415gB3 = this.b;
                    InterfaceC9664aL6 interfaceC9664aL6 = this.c;
                    InterfaceC9664aL6 interfaceC9664aL62 = this.d;
                    e.a aVar = androidx.compose.ui.e.a;
                    InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), InterfaceC12529em.a.l(), interfaceC22053ub1, 0);
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
                    interfaceC22053ub1.W(1351074422);
                    if (a.i(interfaceC9664aL6)) {
                        boolean zContains = a.t(interfaceC9664aL62).contains(c9562aA3);
                        interfaceC22053ub1.W(1351085779);
                        boolean zD = interfaceC22053ub1.D(c13415gB3);
                        Object objB = interfaceC22053ub1.B();
                        if (zD || objB == InterfaceC22053ub1.a.a()) {
                            objB = new UA2() { // from class: ir.nasim.kB3
                                @Override // ir.nasim.UA2
                                public final Object invoke(Object obj) {
                                    return C13415gB3.b.a.C1250a.c(c13415gB3, ((Boolean) obj).booleanValue());
                                }
                            };
                            interfaceC22053ub1.s(objB);
                        }
                        interfaceC22053ub1.Q();
                        KX.f(null, new LX.a(zContains, (UA2) objB, true), interfaceC22053ub1, LX.a.d << 3, 1);
                        ZH6.a(androidx.compose.foundation.layout.t.t(aVar, G10.a.c(interfaceC22053ub1, G10.b).b().c()), interfaceC22053ub1, 0);
                    }
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.u();
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    b((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            a(C9562aA3 c9562aA3, C13415gB3 c13415gB3, AbstractC17457n0 abstractC17457n0) {
                this.a = c9562aA3;
                this.b = c13415gB3;
                this.c = abstractC17457n0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean i(InterfaceC9664aL6 interfaceC9664aL6) {
                return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
            }

            private static final String k(InterfaceC9102Ym4 interfaceC9102Ym4) {
                return (String) interfaceC9102Ym4.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final int n(int i) {
                return -i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 o(C13415gB3 c13415gB3, InterfaceC9664aL6 interfaceC9664aL6) {
                AbstractC13042fc3.i(c13415gB3, "this$0");
                AbstractC13042fc3.i(interfaceC9664aL6, "$isSelectedMode$delegate");
                if (i(interfaceC9664aL6)) {
                    return C19938rB7.a;
                }
                c13415gB3.x.invoke(Integer.valueOf(c13415gB3.I()), Boolean.TRUE);
                c13415gB3.y.invoke(Integer.valueOf(c13415gB3.I()));
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 p(C13415gB3 c13415gB3, ZY0 zy0, InterfaceC9664aL6 interfaceC9664aL6, C12889fL5 c12889fL5, InterfaceC9638aI7 interfaceC9638aI7) {
                Object objB;
                AbstractC13042fc3.i(c13415gB3, "this$0");
                AbstractC13042fc3.i(zy0, "$this_Column");
                AbstractC13042fc3.i(interfaceC9664aL6, "$isSelectedMode$delegate");
                AbstractC13042fc3.i(c12889fL5, "$finalLink");
                AbstractC13042fc3.i(interfaceC9638aI7, "$uriHandler");
                if (i(interfaceC9664aL6)) {
                    c13415gB3.y.invoke(Integer.valueOf(c13415gB3.I()));
                } else {
                    try {
                        C9475a16.a aVar = C9475a16.b;
                        String str = (String) c12889fL5.a;
                        if (!AbstractC20153rZ6.S(str, "http://", false, 2, null) && !AbstractC20153rZ6.S(str, "https://", false, 2, null)) {
                            c12889fL5.a = "https://" + str;
                        }
                        interfaceC9638aI7.a((String) c12889fL5.a);
                        objB = C9475a16.b(C19938rB7.a);
                    } catch (Throwable th) {
                        C9475a16.a aVar2 = C9475a16.b;
                        objB = C9475a16.b(AbstractC10685c16.a(th));
                    }
                    C9475a16.a(objB);
                }
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final List t(InterfaceC9664aL6 interfaceC9664aL6) {
                return (List) interfaceC9664aL6.getValue();
            }

            public final void h(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                String strA;
                String strC0;
                String strC02;
                String strE0;
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                int iG = this.a.g();
                ExPeerType exPeerTypeD = this.a.d();
                ExPeerType exPeerType = ExPeerType.GROUP;
                String string = AbstractC20762sZ6.n1(AbstractC15401jX0.A0(AbstractC20762sZ6.u0(AbstractC14904ig6.H(iG, exPeerTypeD == exPeerType, (Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g()), this.b.z, this.c, false, false)), Separators.SP, null, null, 0, null, null, 62, null)).toString();
                final InterfaceC9638aI7 interfaceC9638aI7 = (InterfaceC9638aI7) interfaceC22053ub1.H(AbstractC13040fc1.t());
                List listP0 = this.b.P0(string);
                List listS0 = this.b.S0(string);
                List listQ0 = this.b.Q0(string);
                final C12889fL5 c12889fL5 = new C12889fL5();
                a aVar = (a) AbstractC15401jX0.s0(listP0);
                if (aVar == null || (strA = aVar.a()) == null) {
                    a aVar2 = (a) AbstractC15401jX0.s0(listS0);
                    if (aVar2 != null) {
                        strA = aVar2.a();
                    } else {
                        a aVar3 = (a) AbstractC15401jX0.s0(listQ0);
                        strA = aVar3 != null ? aVar3.a() : null;
                    }
                }
                String strE02 = (strA == null || (strC0 = AbstractC20762sZ6.C0(strA, Separators.LPAREN)) == null || (strC02 = AbstractC20762sZ6.C0(strC0, Separators.STAR)) == null || (strE0 = AbstractC20762sZ6.E0(strC02, Separators.RPAREN)) == null) ? null : AbstractC20762sZ6.E0(strE0, Separators.STAR);
                if (strE02 == null) {
                    strE02 = "";
                }
                c12889fL5.a = strE02;
                final InterfaceC9664aL6 interfaceC9664aL6B = AbstractC10222bH6.b(this.b.w, null, interfaceC22053ub1, 0, 1);
                InterfaceC9664aL6 interfaceC9664aL6B2 = AbstractC10222bH6.b(this.b.v, null, interfaceC22053ub1, 0, 1);
                e.a aVar4 = androidx.compose.ui.e.a;
                G10 g10 = G10.a;
                int i2 = G10.b;
                androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.b.d(aVar4, g10.a(interfaceC22053ub1, i2).r(), null, 2, null), 0.0f, 1, null);
                final C13415gB3 c13415gB3 = this.b;
                C9562aA3 c9562aA3 = this.a;
                AbstractC17457n0 abstractC17457n0 = this.c;
                C24254yJ c24254yJ = C24254yJ.a;
                C24254yJ.m mVarH = c24254yJ.h();
                InterfaceC12529em.a aVar5 = InterfaceC12529em.a;
                InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarH, aVar5.k(), interfaceC22053ub1, 0);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarH);
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
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar6.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar6.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar6.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar6.f());
                final C9784aZ0 c9784aZ0 = C9784aZ0.a;
                androidx.compose.ui.e eVarH2 = androidx.compose.foundation.layout.t.h(aVar4, 0.0f, 1, null);
                interfaceC22053ub1.W(1964005072);
                boolean zV = interfaceC22053ub1.V(interfaceC9664aL6B) | interfaceC22053ub1.D(c13415gB3);
                Object objB = interfaceC22053ub1.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.hB3
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C13415gB3.b.a.o(c13415gB3, interfaceC9664aL6B);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.foundation.e.i(eVarH2, (WKSRecord.Service.SUNRPC & 1) != 0, (WKSRecord.Service.SUNRPC & 2) != 0 ? null : null, (WKSRecord.Service.SUNRPC & 4) != 0 ? null : null, (WKSRecord.Service.SUNRPC & 8) != 0 ? null : null, (WKSRecord.Service.SUNRPC & 16) != 0 ? null : (SA2) objB, (WKSRecord.Service.SUNRPC & 32) != 0 ? null : null, (WKSRecord.Service.SUNRPC & 64) != 0, new SA2() { // from class: ir.nasim.iB3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C13415gB3.b.a.p(c13415gB3, c9784aZ0, interfaceC9664aL6B, c12889fL5, interfaceC9638aI7);
                    }
                }), g10.c(interfaceC22053ub1, i2).b().c(), g10.c(interfaceC22053ub1, i2).b().d());
                InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.g(), aVar5.i(), interfaceC22053ub1, 48);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarJ);
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
                DG7.c(interfaceC22053ub1A2, interfaceC10970cW3B, aVar6.e());
                DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar6.g());
                InterfaceC14603iB2 interfaceC14603iB2B2 = aVar6.b();
                if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                    interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                    interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
                }
                DG7.c(interfaceC22053ub1A2, eVarE2, aVar6.f());
                M66 m66 = M66.a;
                boolean zI = i(interfaceC9664aL6B);
                androidx.compose.animation.h hVarC = androidx.compose.animation.f.i(AbstractC5999Lt.l(150, 0, null, 6, null), aVar5.k(), false, null, 12, null).c(androidx.compose.animation.f.s(AbstractC5999Lt.l(150, 0, null, 6, null), 0.0f, 0L, 6, null));
                C7479Rw7 c7479Rw7L = AbstractC5999Lt.l(150, 0, null, 6, null);
                interfaceC22053ub1.W(-249348286);
                Object objB2 = interfaceC22053ub1.B();
                InterfaceC22053ub1.a aVar7 = InterfaceC22053ub1.a;
                if (objB2 == aVar7.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.jB3
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return Integer.valueOf(C13415gB3.b.a.n(((Integer) obj).intValue()));
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                AbstractC22231ut.e(m66, zI, null, hVarC, androidx.compose.animation.f.F(c7479Rw7L, (UA2) objB2).c(androidx.compose.animation.f.q(AbstractC5999Lt.l(150, 0, null, 6, null), 0.0f, 2, null)), null, AbstractC19242q11.e(1726001144, true, new C1250a(c9562aA3, c13415gB3, interfaceC9664aL6B, interfaceC9664aL6B2), interfaceC22053ub1, 54), interfaceC22053ub1, 1572870, 18);
                InterfaceC12529em interfaceC12529emE = aVar5.e();
                androidx.compose.ui.e eVarC = androidx.compose.foundation.b.c(androidx.compose.foundation.layout.t.t(aVar4, C17784nZ1.q(50)), g10.a(interfaceC22053ub1, i2).y(), N46.g());
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(interfaceC12529emE, false);
                int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarC);
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
                DG7.c(interfaceC22053ub1A3, interfaceC10970cW3G, aVar6.e());
                DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar6.g());
                InterfaceC14603iB2 interfaceC14603iB2B3 = aVar6.b();
                if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                    interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                    interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
                }
                DG7.c(interfaceC22053ub1A3, eVarE3, aVar6.f());
                androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                AbstractC24077y03.b(FV4.c(AbstractC22412vB5.link, interfaceC22053ub1, 0), null, null, g10.a(interfaceC22053ub1, i2).F(), interfaceC22053ub1, 48, 4);
                interfaceC22053ub1.u();
                ZH6.a(androidx.compose.foundation.layout.t.t(aVar4, g10.c(interfaceC22053ub1, i2).b().e()), interfaceC22053ub1, 0);
                interfaceC22053ub1.W(-249286542);
                Object objB3 = interfaceC22053ub1.B();
                if (objB3 == aVar7.a()) {
                    int iG2 = c9562aA3.g();
                    boolean z = c9562aA3.d() == exPeerType;
                    Context context = c13415gB3.u.getContext();
                    AbstractC13042fc3.h(context, "getContext(...)");
                    objB3 = AbstractC13472gH6.d(AbstractC20762sZ6.n1(AbstractC15401jX0.A0(AbstractC20762sZ6.u0(AbstractC14904ig6.H(iG2, z, context, c13415gB3.z, abstractC17457n0, false, true)), Separators.SP, null, null, 0, null, null, 62, null)).toString(), null, 2, null);
                    interfaceC22053ub1.s(objB3);
                }
                InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB3;
                interfaceC22053ub1.Q();
                InterfaceC10970cW3 interfaceC10970cW3A2 = XY0.a(c24254yJ.h(), aVar5.k(), interfaceC22053ub1, 0);
                int iA4 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q4 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE4 = androidx.compose.ui.c.e(interfaceC22053ub1, aVar4);
                SA2 sa2A4 = aVar6.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A4);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A4 = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A4, interfaceC10970cW3A2, aVar6.e());
                DG7.c(interfaceC22053ub1A4, interfaceC11819dc1Q4, aVar6.g());
                InterfaceC14603iB2 interfaceC14603iB2B4 = aVar6.b();
                if (interfaceC22053ub1A4.h() || !AbstractC13042fc3.d(interfaceC22053ub1A4.B(), Integer.valueOf(iA4))) {
                    interfaceC22053ub1A4.s(Integer.valueOf(iA4));
                    interfaceC22053ub1A4.v(Integer.valueOf(iA4), interfaceC14603iB2B4);
                }
                DG7.c(interfaceC22053ub1A4, eVarE4, aVar6.f());
                String strK = k(interfaceC9102Ym4);
                C9348Zn7 c9348Zn7A = g10.d(interfaceC22053ub1, i2).a();
                C6399Nk7.a aVar8 = C6399Nk7.b;
                C9348Zn7 c9348Zn7B = c9348Zn7A.b((16744447 & 1) != 0 ? c9348Zn7A.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7A.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7A.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7A.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7A.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7A.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7A.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7A.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7A.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7A.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7A.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7A.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7A.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7A.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7A.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7A.b.h() : aVar8.f(), (16744447 & 65536) != 0 ? c9348Zn7A.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7A.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7A.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7A.c : null, (16744447 & 1048576) != 0 ? c9348Zn7A.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7A.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7A.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7A.b.k() : null);
                long jF = g10.a(interfaceC22053ub1, i2).F();
                AbstractC23365wn7.a aVar9 = AbstractC23365wn7.a;
                AbstractC9339Zm7.b(strK, null, jF, 0L, null, null, null, 0L, null, null, 0L, aVar9.b(), false, 1, 0, null, c9348Zn7B, interfaceC22053ub1, 0, 3120, 55290);
                ZH6.a(androidx.compose.foundation.layout.t.t(aVar4, g10.c(interfaceC22053ub1, i2).b().n()), interfaceC22053ub1, 0);
                String str = (String) c12889fL5.a;
                C9348Zn7 c9348Zn7C = g10.d(interfaceC22053ub1, i2).c();
                AbstractC9339Zm7.b(str, null, g10.a(interfaceC22053ub1, i2).v(), 0L, null, null, null, 0L, null, null, 0L, aVar9.b(), false, 1, 0, null, c9348Zn7C.b((16744447 & 1) != 0 ? c9348Zn7C.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7C.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7C.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7C.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7C.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7C.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7C.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7C.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7C.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7C.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7C.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7C.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7C.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7C.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7C.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7C.b.h() : aVar8.f(), (16744447 & 65536) != 0 ? c9348Zn7C.b.i() : C4049Dl7.b.d(), (16744447 & 131072) != 0 ? c9348Zn7C.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7C.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7C.c : null, (16744447 & 1048576) != 0 ? c9348Zn7C.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7C.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7C.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7C.b.k() : null), interfaceC22053ub1, 0, 3120, 55290);
                interfaceC22053ub1.u();
                interfaceC22053ub1.u();
                ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar4, 0.0f, 1, null), C17784nZ1.q(1)), 0.0f, g10.a(interfaceC22053ub1, i2).A(), interfaceC22053ub1, 6, 2);
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                h((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b(C9562aA3 c9562aA3, C13415gB3 c13415gB3, AbstractC17457n0 abstractC17457n0) {
            this.a = c9562aA3;
            this.b = c13415gB3;
            this.c = abstractC17457n0;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(385004906, true, new a(this.a, this.b, this.c), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13415gB3(ComposeView composeView, InterfaceC10258bL6 interfaceC10258bL6, InterfaceC10258bL6 interfaceC10258bL62, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2, C11458d25 c11458d25) {
        super(composeView);
        AbstractC13042fc3.i(composeView, "composeView");
        AbstractC13042fc3.i(interfaceC10258bL6, "selected");
        AbstractC13042fc3.i(interfaceC10258bL62, "isSelectedMode");
        AbstractC13042fc3.i(interfaceC14603iB2, "onLongClickListener");
        AbstractC13042fc3.i(ua2, "onItemSelectChange");
        AbstractC13042fc3.i(c11458d25, "peer");
        this.u = composeView;
        this.v = interfaceC10258bL6;
        this.w = interfaceC10258bL62;
        this.x = interfaceC14603iB2;
        this.y = ua2;
        this.z = c11458d25;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List P0(String str) {
        ArrayList arrayList = new ArrayList();
        Pattern patternCompile = Pattern.compile("\\(?\\b(https?://|www[.]|ftp://)[-A-Za-z0-9+&@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&@#/%=~_()|]", 0);
        AbstractC13042fc3.h(patternCompile, "compile(...)");
        Matcher matcher = patternCompile.matcher(str);
        while (matcher.find()) {
            int iStart = matcher.start(1);
            int iEnd = matcher.end();
            String strSubstring = str.substring(iStart, iEnd);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            arrayList.add(new a(strSubstring, iStart, iEnd));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List Q0(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Patterns.EMAIL_ADDRESS.matcher(str);
        while (matcher.find()) {
            String strGroup = matcher.group();
            String strSubstring = str.substring(matcher.start(), matcher.start() + strGroup.length());
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            arrayList.add(new a(strSubstring, matcher.start(), matcher.start() + strGroup.length()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List S0(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Patterns.WEB_URL.matcher(str);
        while (matcher.find()) {
            int iStart = matcher.start(1);
            int iEnd = matcher.end();
            String strSubstring = str.substring(iStart, iEnd);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            arrayList.add(new a(strSubstring, iStart, iEnd));
        }
        return arrayList;
    }

    public final void O0(C9562aA3 c9562aA3) {
        this.A = c9562aA3;
        if (c9562aA3 != null) {
            AbstractC17457n0 abstractC17457n0F = c9562aA3.e().F();
            if (!(!(abstractC17457n0F instanceof C18121o72))) {
                abstractC17457n0F = null;
            }
            if (abstractC17457n0F == null) {
                return;
            }
            this.u.setContent(AbstractC19242q11.c(-1636543867, true, new b(c9562aA3, this, abstractC17457n0F)));
        }
    }

    public final void a() {
        this.u.h();
    }
}
