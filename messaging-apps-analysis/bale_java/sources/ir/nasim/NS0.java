package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenTypes;
import ir.nasim.PS0;

/* loaded from: classes4.dex */
public abstract class NS0 {

    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ boolean a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ androidx.compose.ui.e c;
        final /* synthetic */ boolean d;
        final /* synthetic */ PS0 e;
        final /* synthetic */ long f;
        final /* synthetic */ String g;

        /* renamed from: ir.nasim.NS0$a$a, reason: collision with other inner class name */
        static final class C0532a implements InterfaceC14603iB2 {
            final /* synthetic */ androidx.compose.ui.e a;
            final /* synthetic */ String b;

            C0532a(androidx.compose.ui.e eVar, String str) {
                this.a = eVar;
                this.b = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                androidx.compose.ui.e eVar = this.a;
                G10 g10 = G10.a;
                AbstractC9339Zm7.b(this.b, androidx.compose.foundation.layout.q.k(eVar, 0.0f, g10.c(interfaceC22053ub1, 6).b().u(), 1, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, 6).o(), interfaceC22053ub1, 0, 0, 65532);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(boolean z, SA2 sa2, androidx.compose.ui.e eVar, boolean z2, PS0 ps0, long j, String str) {
            this.a = z;
            this.b = sa2;
            this.c = eVar;
            this.d = z2;
            this.e = ps0;
            this.f = j;
            this.g = str;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            long jA;
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            boolean z = this.a;
            SA2 sa2 = this.b;
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(1384251736, true, new C0532a(this.c, this.g), interfaceC22053ub1, 54);
            androidx.compose.ui.e eVar = this.c;
            boolean z2 = this.d;
            InterfaceC14603iB2 interfaceC14603iB2A = ((PS0.a) this.e).a();
            M46 m46D = N46.d(C17784nZ1.q(18));
            C3350Am6 c3350Am6B = C9935ao2.a.b(interfaceC22053ub1, C9935ao2.d);
            G10 g10 = G10.a;
            C3350Am6 c3350Am6B2 = c3350Am6B.b((6908 & 1) != 0 ? c3350Am6B.a : this.f, (6908 & 2) != 0 ? c3350Am6B.b : g10.a(interfaceC22053ub1, 6).F(), (6908 & 4) != 0 ? c3350Am6B.c : 0L, (6908 & 8) != 0 ? c3350Am6B.d : 0L, (6908 & 16) != 0 ? c3350Am6B.e : 0L, (6908 & 32) != 0 ? c3350Am6B.f : 0L, (6908 & 64) != 0 ? c3350Am6B.g : 0L, (6908 & 128) != 0 ? c3350Am6B.h : 0L, (6908 & 256) != 0 ? c3350Am6B.i : g10.a(interfaceC22053ub1, 6).r(), (6908 & 512) != 0 ? c3350Am6B.j : 0L, (6908 & 1024) != 0 ? c3350Am6B.k : g10.a(interfaceC22053ub1, 6).F(), (6908 & 2048) != 0 ? c3350Am6B.l : 0L, (6908 & 4096) != 0 ? c3350Am6B.m : 0L);
            interfaceC22053ub1.W(-1233380963);
            float fG = this.a ? g10.c(interfaceC22053ub1, 6).b().g() : C17784nZ1.q(1);
            interfaceC22053ub1.Q();
            if (this.a) {
                interfaceC22053ub1.W(-1233377141);
                jA = g10.a(interfaceC22053ub1, 6).I();
            } else {
                interfaceC22053ub1.W(-1233375961);
                jA = g10.a(interfaceC22053ub1, 6).A();
            }
            interfaceC22053ub1.Q();
            OS0.b(z, sa2, interfaceC18060o11E, eVar, z2, interfaceC14603iB2A, null, m46D, c3350Am6B2, null, AbstractC11256ci0.a(fG, jA), null, interfaceC22053ub1, 805306752, 0, TokenTypes.AUTHENTICATION_INFO);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:178:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f(androidx.compose.ui.e r38, boolean r39, ir.nasim.SA2 r40, boolean r41, java.lang.String r42, ir.nasim.PS0 r43, long r44, ir.nasim.InterfaceC22053ub1 r46, final int r47, final int r48) {
        /*
            Method dump skipped, instructions count: 1104
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.NS0.f(androidx.compose.ui.e, boolean, ir.nasim.SA2, boolean, java.lang.String, ir.nasim.PS0, long, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(SA2 sa2) {
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(String str, InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.e0(interfaceC11943do6, str + " chips");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(androidx.compose.ui.e eVar, boolean z, SA2 sa2, boolean z2, String str, PS0 ps0, long j, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        f(eVar, z, sa2, z2, str, ps0, j, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void k(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-40139953);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), C15716k31.a.a(), interfaceC22053ub1J, C7252Qx5.i | 48);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.IS0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return NS0.l(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        k(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
