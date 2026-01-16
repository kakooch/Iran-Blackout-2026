package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;

/* renamed from: ir.nasim.Jj0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC5443Jj0 {

    /* renamed from: ir.nasim.Jj0$a */
    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ Avatar a;
        final /* synthetic */ String b;

        a(Avatar avatar, String str) {
            this.a = avatar;
            this.b = str;
        }

        public final void a(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(zy0, "$this$Card");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null);
            InterfaceC12529em.b bVarG = InterfaceC12529em.a.g();
            Avatar avatar = this.a;
            String str = this.b;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), bVarG, interfaceC22053ub1, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarF);
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
            float f = 12;
            androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(androidx.compose.foundation.layout.q.m(aVar, 0.0f, C17784nZ1.q(f), 0.0f, 0.0f, 13, null), C17784nZ1.q(50));
            float f2 = 1;
            float fQ = C17784nZ1.q(f2);
            G10 g10 = G10.a;
            int i2 = G10.b;
            AbstractC11456d23.b(AvatarAsyncImagePainterKt.h(avatar, null, false, 0, interfaceC22053ub1, 0, 14), null, FV0.a(androidx.compose.foundation.layout.q.i(AbstractC9287Zh0.f(eVarT, fQ, g10.a(interfaceC22053ub1, i2).C(), N46.g()), C17784nZ1.q(f2)), N46.g()), null, InterfaceC13157fl1.a.a(), 0.0f, null, interfaceC22053ub1, 24624, 104);
            float f3 = 6;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(aVar, C17784nZ1.q(f3), C17784nZ1.q(f), C17784nZ1.q(f3), 0.0f, 8, null);
            String str2 = str == null ? "" : str;
            C9348Zn7 c9348Zn7O = g10.d(interfaceC22053ub1, i2).o();
            AbstractC9339Zm7.b(str2, eVarM, g10.a(interfaceC22053ub1, i2).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, AbstractC23365wn7.a.b(), false, 2, 0, null, c9348Zn7O.b((16744447 & 1) != 0 ? c9348Zn7O.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7O.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7O.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7O.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7O.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7O.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7O.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7O.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7O.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7O.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7O.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7O.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7O.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7O.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7O.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7O.b.h() : 0, (16744447 & 65536) != 0 ? c9348Zn7O.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7O.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7O.b.j() : new C5477Jm7(AbstractC13784go7.g(2), AbstractC13784go7.g(2), null), (16744447 & 524288) != 0 ? c9348Zn7O.c : null, (16744447 & 1048576) != 0 ? c9348Zn7O.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7O.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7O.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7O.b.k() : null), interfaceC22053ub1, 0, 3120, 54776);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final void f(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-654531610);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            j("شماره شبا", null, null, null, interfaceC22053ub1J, 6, 14);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Fj0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC5443Jj0.g(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        f(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void h(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1356669036);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            float f = 14;
            androidx.compose.ui.e eVarA = FV0.a(androidx.compose.foundation.layout.t.v(androidx.compose.ui.e.a, C17784nZ1.q(104), C17784nZ1.q(126)), N46.d(C17784nZ1.q(f)));
            float fQ = C17784nZ1.q(1);
            G10 g10 = G10.a;
            int i2 = G10.b;
            PG0.a(eVarA, N46.d(C17784nZ1.q(f)), MG0.a.b(g10.a(interfaceC22053ub1J, i2).r(), 0L, 0L, 0L, interfaceC22053ub1J, MG0.b << 12, 14), null, AbstractC11256ci0.a(fQ, g10.a(interfaceC22053ub1J, i2).A()), X21.a.a(), interfaceC22053ub1J, 196608, 8);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Ej0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC5443Jj0.i(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        h(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void j(final java.lang.String r22, androidx.compose.ui.e r23, ir.nasim.core.modules.profile.entity.Avatar r24, ir.nasim.SA2 r25, ir.nasim.InterfaceC22053ub1 r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC5443Jj0.j(java.lang.String, androidx.compose.ui.e, ir.nasim.core.modules.profile.entity.Avatar, ir.nasim.SA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(SA2 sa2) {
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(String str, androidx.compose.ui.e eVar, Avatar avatar, SA2 sa2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        j(str, eVar, avatar, sa2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }
}
