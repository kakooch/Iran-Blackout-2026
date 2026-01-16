package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.C12700f33;
import ir.nasim.C21669tv7;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.M68;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class M68 {

    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ long b;

        a(SA2 sa2, long j) {
            this.a = sa2;
            this.b = j;
        }

        public final void a(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC22821vt, "$this$AnimatedVisibility");
            M68.y(this.a, this.b, interfaceC22053ub1, 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC9664aL6 a;
        final /* synthetic */ InterfaceC14354hm4 b;
        final /* synthetic */ InterfaceC9664aL6 c;
        final /* synthetic */ InterfaceC9664aL6 d;
        final /* synthetic */ long e;
        final /* synthetic */ InterfaceC9664aL6 f;

        b(InterfaceC9664aL6 interfaceC9664aL6, InterfaceC14354hm4 interfaceC14354hm4, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC9664aL6 interfaceC9664aL63, long j, InterfaceC9664aL6 interfaceC9664aL64) {
            this.a = interfaceC9664aL6;
            this.b = interfaceC14354hm4;
            this.c = interfaceC9664aL62;
            this.d = interfaceC9664aL63;
            this.e = j;
            this.f = interfaceC9664aL64;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(float f, InterfaceC9664aL6 interfaceC9664aL6, androidx.compose.ui.graphics.c cVar) {
            AbstractC13042fc3.i(interfaceC9664aL6, "$rotation$delegate");
            AbstractC13042fc3.i(cVar, "$this$graphicsLayer");
            cVar.l(M68.w(interfaceC9664aL6));
            cVar.g(f);
            cVar.m(f);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(InterfaceC9664aL6 interfaceC9664aL6, androidx.compose.ui.graphics.c cVar) {
            AbstractC13042fc3.i(interfaceC9664aL6, "$backAlpha$delegate");
            AbstractC13042fc3.i(cVar, "$this$graphicsLayer");
            cVar.c(M68.q(interfaceC9664aL6));
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(InterfaceC9664aL6 interfaceC9664aL6, androidx.compose.ui.graphics.c cVar) {
            AbstractC13042fc3.i(interfaceC9664aL6, "$closeAlpha$delegate");
            AbstractC13042fc3.i(cVar, "$this$graphicsLayer");
            cVar.c(M68.r(interfaceC9664aL6));
            return C19938rB7.a;
        }

        public final void d(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (M68.s(this.b) < 1.0f) {
                InterfaceC14354hm4 interfaceC14354hm4 = this.b;
                M68.t(interfaceC14354hm4, (M68.s(interfaceC14354hm4) + 1.0f) / 2.0f);
            }
            final float fX = M68.x(this.c) * M68.s(this.b);
            e.a aVar = androidx.compose.ui.e.a;
            float f = 24;
            androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(f));
            interfaceC22053ub1.W(-299219860);
            boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.c(fX);
            final InterfaceC9664aL6 interfaceC9664aL6 = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.N68
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return M68.b.f(fX, interfaceC9664aL6, (androidx.compose.ui.graphics.c) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarA = androidx.compose.ui.graphics.b.a(eVarT, (UA2) objB);
            InterfaceC12529em interfaceC12529emE = InterfaceC12529em.a.e();
            final InterfaceC9664aL6 interfaceC9664aL62 = this.d;
            long j = this.e;
            final InterfaceC9664aL6 interfaceC9664aL63 = this.f;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(interfaceC12529emE, false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarA);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            androidx.compose.ui.e eVarT2 = androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(f));
            interfaceC22053ub1.W(-1129767052);
            boolean zV2 = interfaceC22053ub1.V(interfaceC9664aL62);
            Object objB2 = interfaceC22053ub1.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.O68
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return M68.b.h(interfaceC9664aL62, (androidx.compose.ui.graphics.c) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarA2 = androidx.compose.ui.graphics.b.a(eVarT2, (UA2) objB2);
            C12700f33.b bVar = C12700f33.k;
            AbstractC24077y03.a(XQ7.b(bVar, AB5.arrow_left, interfaceC22053ub1, 6), UY6.c(WD5.back, interfaceC22053ub1, 0), eVarA2, j, interfaceC22053ub1, 0, 0);
            androidx.compose.ui.e eVarA3 = G46.a(androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(f)), 180.0f);
            interfaceC22053ub1.W(-1129754283);
            boolean zV3 = interfaceC22053ub1.V(interfaceC9664aL63);
            Object objB3 = interfaceC22053ub1.B();
            if (zV3 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new UA2() { // from class: ir.nasim.P68
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return M68.b.i(interfaceC9664aL63, (androidx.compose.ui.graphics.c) obj);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            AbstractC24077y03.a(XQ7.b(bVar, AB5.close, interfaceC22053ub1, 6), UY6.c(WD5.close, interfaceC22053ub1, 0), androidx.compose.ui.graphics.b.a(eVarA3, (UA2) objB3), j, interfaceC22053ub1, 0, 0);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            d((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class c implements InterfaceC15796kB2 {
        public static final c a = new c();

        c() {
        }

        public final InterfaceC4788Go2 a(C21669tv7.b bVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(bVar, "$this$animateFloat");
            interfaceC22053ub1.W(302438766);
            C7479Rw7 c7479Rw7L = AbstractC5999Lt.l(200, 0, T22.d(), 2, null);
            interfaceC22053ub1.Q();
            return c7479Rw7L;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((C21669tv7.b) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    static final class d implements InterfaceC15796kB2 {
        public static final d a = new d();

        d() {
        }

        public final InterfaceC4788Go2 a(C21669tv7.b bVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(bVar, "$this$animateFloat");
            interfaceC22053ub1.W(-897980752);
            C18827pJ6 c18827pJ6J = AbstractC5999Lt.j(0.85f, 300.0f, null, 4, null);
            interfaceC22053ub1.Q();
            return c18827pJ6J;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((C21669tv7.b) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    static final class e implements InterfaceC15796kB2 {
        public static final e a = new e();

        e() {
        }

        public final InterfaceC4788Go2 a(C21669tv7.b bVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(bVar, "$this$animateFloat");
            interfaceC22053ub1.W(-723936945);
            C7479Rw7 c7479Rw7L = AbstractC5999Lt.l(200, 0, T22.d(), 2, null);
            interfaceC22053ub1.Q();
            return c7479Rw7L;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((C21669tv7.b) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    static final class f implements InterfaceC15796kB2 {
        public static final f a = new f();

        f() {
        }

        public final InterfaceC4788Go2 a(C21669tv7.b bVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(bVar, "$this$animateFloat");
            interfaceC22053ub1.W(-122259257);
            C18827pJ6 c18827pJ6J = AbstractC5999Lt.j(0.8f, 400.0f, null, 4, null);
            interfaceC22053ub1.Q();
            return c18827pJ6J;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((C21669tv7.b) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    static final class g implements InterfaceC14603iB2 {
        final /* synthetic */ long a;

        g(long j) {
            this.a = j;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC24077y03.a(XQ7.b(C12700f33.k, AB5.simple_arrow_down, interfaceC22053ub1, 6), UY6.c(WD5.back, interfaceC22053ub1, 0), androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, C17784nZ1.q(24)), this.a, interfaceC22053ub1, 384, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class h implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC9664aL6 a;
        final /* synthetic */ long b;

        h(InterfaceC9664aL6 interfaceC9664aL6, long j) {
            this.a = interfaceC9664aL6;
            this.b = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(InterfaceC9664aL6 interfaceC9664aL6, androidx.compose.ui.graphics.c cVar) {
            AbstractC13042fc3.i(interfaceC9664aL6, "$moreScale$delegate");
            AbstractC13042fc3.i(cVar, "$this$graphicsLayer");
            cVar.g(M68.D(interfaceC9664aL6));
            cVar.m(M68.D(interfaceC9664aL6));
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, C17784nZ1.q(24));
            interfaceC22053ub1.W(-103774169);
            boolean zV = interfaceC22053ub1.V(this.a);
            final InterfaceC9664aL6 interfaceC9664aL6 = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.Q68
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return M68.h.c(interfaceC9664aL6, (androidx.compose.ui.graphics.c) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC24077y03.a(XQ7.b(C12700f33.k, AB5.bubble_action_more, interfaceC22053ub1, 6), null, androidx.compose.ui.graphics.b.a(eVarT, (UA2) objB), this.b, interfaceC22053ub1, 48, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class i implements InterfaceC15796kB2 {
        public static final i a = new i();

        i() {
        }

        public final InterfaceC4788Go2 a(C21669tv7.b bVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(bVar, "$this$animateFloat");
            interfaceC22053ub1.W(1502754633);
            C18827pJ6 c18827pJ6J = AbstractC5999Lt.j(0.9f, 400.0f, null, 4, null);
            interfaceC22053ub1.Q();
            return c18827pJ6J;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((C21669tv7.b) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    static final class j implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e a;
        final /* synthetic */ String b;
        final /* synthetic */ long c;

        j(androidx.compose.ui.e eVar, String str, long j) {
            this.a = eVar;
            this.b = str;
            this.c = j;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVar = this.a;
            G10 g10 = G10.a;
            int i2 = G10.b;
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(eVar, g10.c(interfaceC22053ub1, i2).b().r(), 0.0f, 2, null);
            C23546x62 c23546x62B = AbstractC8970Ya1.b(this.b, 0L, 1, null);
            C9348Zn7 c9348Zn7L = g10.d(interfaceC22053ub1, i2).l();
            C62.d(c23546x62B, eVarK, this.c, 0L, null, null, null, 0L, null, null, 0L, AbstractC23365wn7.a.b(), false, 1, 0, null, c9348Zn7L, 0, null, interfaceC22053ub1, 0, 3120, 448504);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void A(final ir.nasim.R68 r26, final ir.nasim.C3869Cr7 r27, final long r28, final long r30, androidx.compose.ui.e r32, ir.nasim.InterfaceC22053ub1 r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 645
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.M68.A(ir.nasim.R68, ir.nasim.Cr7, long, long, androidx.compose.ui.e, ir.nasim.ub1, int, int):void");
    }

    private static final boolean B(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    private static final void C(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float D(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 E(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isMenuOpen$delegate");
        C(interfaceC9102Ym4, false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isMenuOpen$delegate");
        C(interfaceC9102Ym4, true);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 G(R68 r68, C3869Cr7 c3869Cr7, long j2, long j3, androidx.compose.ui.e eVar, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(r68, "$state");
        AbstractC13042fc3.i(c3869Cr7, "$toolbarCallBack");
        A(r68, c3869Cr7, j2, j3, eVar, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void H(final java.lang.String r11, final long r12, androidx.compose.ui.e r14, ir.nasim.InterfaceC22053ub1 r15, final int r16, final int r17) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.M68.H(java.lang.String, long, androidx.compose.ui.e, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 I(String str, long j2, androidx.compose.ui.e eVar, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(str, "$text");
        H(str, j2, eVar, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void J(androidx.compose.ui.e r25, final ir.nasim.R68 r26, final ir.nasim.C3869Cr7 r27, ir.nasim.InterfaceC22053ub1 r28, final int r29, final int r30) {
        /*
            Method dump skipped, instructions count: 591
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.M68.J(androidx.compose.ui.e, ir.nasim.R68, ir.nasim.Cr7, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 K(androidx.compose.ui.e eVar, R68 r68, C3869Cr7 c3869Cr7, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(r68, "$state");
        AbstractC13042fc3.i(c3869Cr7, "$toolbarCallBack");
        J(eVar, r68, c3869Cr7, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    private static final List T(boolean z, boolean z2, C3869Cr7 c3869Cr7, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        interfaceC22053ub1.W(352674026);
        ArrayList arrayList = new ArrayList();
        interfaceC22053ub1.W(-279262395);
        if (z2) {
            arrayList.add(new C7847Tl1(UY6.c(WD5.setting, interfaceC22053ub1, 0), AB5.settings, 0, c3869Cr7.f(), 4, null));
        }
        interfaceC22053ub1.Q();
        arrayList.add(new C7847Tl1(UY6.c(WD5.reload_page, interfaceC22053ub1, 0), AB5.reload, 0, c3869Cr7.e(), 4, null));
        interfaceC22053ub1.W(-279248913);
        if (z) {
            arrayList.add(new C7847Tl1(UY6.c(WD5.add_to_home_screen, interfaceC22053ub1, 0), AB5.home, 0, c3869Cr7.a(), 4, null));
        }
        interfaceC22053ub1.Q();
        arrayList.add(new C7847Tl1(UY6.c(WD5.terms_of_use, interfaceC22053ub1, 0), AB5.document, 0, c3869Cr7.g(), 4, null));
        interfaceC22053ub1.Q();
        return arrayList;
    }

    private static final long U(int i2) {
        return QY0.d(i2) < 0.5d ? AbstractC5111Hy1.b0() : AbstractC24067xz3.b0();
    }

    private static final void l(final SA2 sa2, final long j2, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-413485021);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.f(j2) ? 32 : 16;
        }
        if ((i3 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(1535539744);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new UA2() { // from class: ir.nasim.J68
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return Integer.valueOf(M68.m(((Integer) obj).intValue()));
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.animation.h hVarC = androidx.compose.animation.f.B(null, (UA2) objB, 1, null).c(androidx.compose.animation.f.o(AbstractC5999Lt.l(200, 0, null, 6, null), 0.0f, 2, null));
            interfaceC22053ub1J.W(1535544032);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                objB2 = new UA2() { // from class: ir.nasim.K68
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return Integer.valueOf(M68.n(((Integer) obj).intValue()));
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            AbstractC22231ut.f(true, null, hVarC, androidx.compose.animation.f.G(null, (UA2) objB2, 1, null).c(androidx.compose.animation.f.q(AbstractC5999Lt.l(150, 0, null, 6, null), 0.0f, 2, null)), null, AbstractC19242q11.e(-1080986037, true, new a(sa2, j2), interfaceC22053ub1J, 54), interfaceC22053ub1J, 200070, 18);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.L68
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return M68.o(sa2, j2, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int m(int i2) {
        return i2 / 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int n(int i2) {
        return i2 / 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(SA2 sa2, long j2, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(sa2, "$onMinimize");
        l(sa2, j2, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    private static final void p(final boolean z, final long j2, final SA2 sa2, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1879890678);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.a(z) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.f(j2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(sa2) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.D(sa22) ? 2048 : 1024;
        }
        if ((i3 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            int i4 = i3 & 14;
            C21669tv7 c21669tv7H = AbstractC4139Dv7.h(Boolean.valueOf(z), "BackCloseTransition", interfaceC22053ub1J, i4 | 48, 0);
            f fVar = f.a;
            C9361Zp2 c9361Zp2 = C9361Zp2.a;
            InterfaceC5342Ix7 interfaceC5342Ix7D = PQ7.d(c9361Zp2);
            boolean zBooleanValue = ((Boolean) c21669tv7H.h()).booleanValue();
            interfaceC22053ub1J.W(-230833790);
            float f2 = zBooleanValue ? 0.0f : 180.0f;
            interfaceC22053ub1J.Q();
            Float fValueOf = Float.valueOf(f2);
            boolean zBooleanValue2 = ((Boolean) c21669tv7H.o()).booleanValue();
            interfaceC22053ub1J.W(-230833790);
            float f3 = zBooleanValue2 ? 0.0f : 180.0f;
            interfaceC22053ub1J.Q();
            boolean z2 = false;
            InterfaceC9664aL6 interfaceC9664aL6E = AbstractC4139Dv7.e(c21669tv7H, fValueOf, Float.valueOf(f3), (InterfaceC4788Go2) fVar.q(c21669tv7H.m(), interfaceC22053ub1J, 0), interfaceC5342Ix7D, "BackCloseRotation", interfaceC22053ub1J, 196608);
            d dVar = d.a;
            InterfaceC5342Ix7 interfaceC5342Ix7D2 = PQ7.d(c9361Zp2);
            boolean zBooleanValue3 = ((Boolean) c21669tv7H.h()).booleanValue();
            interfaceC22053ub1J.W(31176021);
            float f4 = zBooleanValue3 ? 1.0f : 0.95f;
            interfaceC22053ub1J.Q();
            Float fValueOf2 = Float.valueOf(f4);
            boolean zBooleanValue4 = ((Boolean) c21669tv7H.o()).booleanValue();
            interfaceC22053ub1J.W(31176021);
            float f5 = zBooleanValue4 ? 1.0f : 0.95f;
            interfaceC22053ub1J.Q();
            InterfaceC9664aL6 interfaceC9664aL6E2 = AbstractC4139Dv7.e(c21669tv7H, fValueOf2, Float.valueOf(f5), (InterfaceC4788Go2) dVar.q(c21669tv7H.m(), interfaceC22053ub1J, 0), interfaceC5342Ix7D2, "BackCloseScale", interfaceC22053ub1J, 196608);
            c cVar = c.a;
            InterfaceC5342Ix7 interfaceC5342Ix7D3 = PQ7.d(c9361Zp2);
            boolean zBooleanValue5 = ((Boolean) c21669tv7H.h()).booleanValue();
            interfaceC22053ub1J.W(1231595539);
            float f6 = zBooleanValue5 ? 1.0f : 0.0f;
            interfaceC22053ub1J.Q();
            Float fValueOf3 = Float.valueOf(f6);
            boolean zBooleanValue6 = ((Boolean) c21669tv7H.o()).booleanValue();
            interfaceC22053ub1J.W(1231595539);
            float f7 = zBooleanValue6 ? 1.0f : 0.0f;
            interfaceC22053ub1J.Q();
            InterfaceC9664aL6 interfaceC9664aL6E3 = AbstractC4139Dv7.e(c21669tv7H, fValueOf3, Float.valueOf(f7), (InterfaceC4788Go2) cVar.q(c21669tv7H.m(), interfaceC22053ub1J, 0), interfaceC5342Ix7D3, "BackIconAlpha", interfaceC22053ub1J, 196608);
            e eVar = e.a;
            InterfaceC5342Ix7 interfaceC5342Ix7D4 = PQ7.d(c9361Zp2);
            boolean zBooleanValue7 = ((Boolean) c21669tv7H.h()).booleanValue();
            interfaceC22053ub1J.W(-1984848054);
            float f8 = zBooleanValue7 ? 0.0f : 1.0f;
            interfaceC22053ub1J.Q();
            Float fValueOf4 = Float.valueOf(f8);
            boolean zBooleanValue8 = ((Boolean) c21669tv7H.o()).booleanValue();
            interfaceC22053ub1J.W(-1984848054);
            float f9 = zBooleanValue8 ? 0.0f : 1.0f;
            interfaceC22053ub1J.Q();
            InterfaceC9664aL6 interfaceC9664aL6E4 = AbstractC4139Dv7.e(c21669tv7H, fValueOf4, Float.valueOf(f9), (InterfaceC4788Go2) eVar.q(c21669tv7H.m(), interfaceC22053ub1J, 0), interfaceC5342Ix7D4, "CloseIconAlpha", interfaceC22053ub1J, 196608);
            interfaceC22053ub1J.W(1119325445);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC4326Eq5.a(1.0f);
                interfaceC22053ub1J.s(objB);
            }
            final InterfaceC14354hm4 interfaceC14354hm4 = (InterfaceC14354hm4) objB;
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, C17784nZ1.q(36));
            interfaceC22053ub1J.W(1119329585);
            boolean z3 = (i4 == 4) | ((i3 & 896) == 256);
            if ((i3 & 7168) == 2048) {
                z2 = true;
            }
            boolean z4 = z3 | z2;
            Object objB2 = interfaceC22053ub1J.B();
            if (z4 || objB2 == aVar.a()) {
                objB2 = new SA2() { // from class: ir.nasim.G68
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return M68.u(z, sa2, sa22, interfaceC14354hm4);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            AbstractC20434s03.a((SA2) objB2, eVarT, false, null, null, AbstractC19242q11.e(2080216141, true, new b(interfaceC9664aL6E, interfaceC14354hm4, interfaceC9664aL6E2, interfaceC9664aL6E3, j2, interfaceC9664aL6E4), interfaceC22053ub1J, 54), interfaceC22053ub1J, 196656, 28);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.H68
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return M68.v(z, j2, sa2, sa22, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float q(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float r(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float s(InterfaceC14354hm4 interfaceC14354hm4) {
        return interfaceC14354hm4.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(InterfaceC14354hm4 interfaceC14354hm4, float f2) {
        interfaceC14354hm4.s(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(boolean z, SA2 sa2, SA2 sa22, InterfaceC14354hm4 interfaceC14354hm4) {
        AbstractC13042fc3.i(sa2, "$onBackPressed");
        AbstractC13042fc3.i(sa22, "$onClosePressed");
        AbstractC13042fc3.i(interfaceC14354hm4, "$clickScale$delegate");
        t(interfaceC14354hm4, 0.95f);
        if (z) {
            sa2.invoke();
        } else {
            sa22.invoke();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(boolean z, long j2, SA2 sa2, SA2 sa22, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(sa2, "$onBackPressed");
        AbstractC13042fc3.i(sa22, "$onClosePressed");
        p(z, j2, sa2, sa22, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float w(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float x(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(final SA2 sa2, final long j2, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-324501088);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.f(j2) ? 32 : 16;
        }
        if ((i3 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            AbstractC20434s03.a(sa2, androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, C17784nZ1.q(36)), false, null, null, AbstractC19242q11.e(-209201437, true, new g(j2), interfaceC22053ub1J, 54), interfaceC22053ub1J, (i3 & 14) | 196656, 28);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.C68
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return M68.z(sa2, j2, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z(SA2 sa2, long j2, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(sa2, "$onMinimize");
        y(sa2, j2, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }
}
