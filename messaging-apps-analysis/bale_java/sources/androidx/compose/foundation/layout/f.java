package androidx.compose.foundation.layout;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.AbstractC6797Pa1;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C17833ne1;
import ir.nasim.C19938rB7;
import ir.nasim.C4414Fa3;
import ir.nasim.C7386Rm4;
import ir.nasim.DG7;
import ir.nasim.EnumC12613eu3;
import ir.nasim.InterfaceC10970cW3;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC11819dc1;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15247jG;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC20208rd6;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.QJ5;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.ZV3;
import java.util.List;

/* loaded from: classes.dex */
public abstract class f {
    private static final C7386Rm4 a = d(true);
    private static final C7386Rm4 b = d(false);
    private static final InterfaceC10970cW3 c = new g(InterfaceC12529em.a.o(), false);
    private static final InterfaceC10970cW3 d = b.a;

    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(androidx.compose.ui.e eVar, int i) {
            super(2);
            this.e = eVar;
            this.f = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            f.a(this.e, interfaceC22053ub1, QJ5.a(this.f | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-211209833);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (interfaceC22053ub1J.o((i2 & 3) != 2, i2 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-211209833, i2, -1, "androidx.compose.foundation.layout.Box (Box.kt:232)");
            }
            InterfaceC10970cW3 interfaceC10970cW3 = d;
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVar);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            interfaceC22053ub1J.u();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new a(eVar, i));
        }
    }

    private static final C7386Rm4 d(boolean z) {
        C7386Rm4 c7386Rm4 = new C7386Rm4(9);
        InterfaceC12529em.a aVar = InterfaceC12529em.a;
        c7386Rm4.x(aVar.o(), new g(aVar.o(), z));
        c7386Rm4.x(aVar.m(), new g(aVar.m(), z));
        c7386Rm4.x(aVar.n(), new g(aVar.n(), z));
        c7386Rm4.x(aVar.h(), new g(aVar.h(), z));
        c7386Rm4.x(aVar.e(), new g(aVar.e(), z));
        c7386Rm4.x(aVar.f(), new g(aVar.f(), z));
        c7386Rm4.x(aVar.d(), new g(aVar.d(), z));
        c7386Rm4.x(aVar.b(), new g(aVar.b(), z));
        c7386Rm4.x(aVar.c(), new g(aVar.c(), z));
        return c7386Rm4;
    }

    private static final e e(ZV3 zv3) {
        Object objH = zv3.h();
        if (objH instanceof e) {
            return (e) objH;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(ZV3 zv3) {
        e eVarE = e(zv3);
        if (eVarE != null) {
            return eVarE.w2();
        }
        return false;
    }

    public static final InterfaceC10970cW3 g(InterfaceC12529em interfaceC12529em, boolean z) {
        InterfaceC10970cW3 interfaceC10970cW3 = (InterfaceC10970cW3) (z ? a : b).e(interfaceC12529em);
        return interfaceC10970cW3 == null ? new g(interfaceC12529em, z) : interfaceC10970cW3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(AbstractC21430te5.a aVar, AbstractC21430te5 abstractC21430te5, ZV3 zv3, EnumC12613eu3 enumC12613eu3, int i, int i2, InterfaceC12529em interfaceC12529em) {
        InterfaceC12529em interfaceC12529emV2;
        e eVarE = e(zv3);
        AbstractC21430te5.a.j(aVar, abstractC21430te5, ((eVarE == null || (interfaceC12529emV2 = eVarE.v2()) == null) ? interfaceC12529em : interfaceC12529emV2).a(C4414Fa3.c((abstractC21430te5.P0() << 32) | (abstractC21430te5.A0() & 4294967295L)), C4414Fa3.c((i << 32) | (i2 & 4294967295L)), enumC12613eu3), 0.0f, 2, null);
    }

    public static final InterfaceC10970cW3 i(InterfaceC12529em interfaceC12529em, boolean z, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        InterfaceC10970cW3 interfaceC10970cW3;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(56522820, i, -1, "androidx.compose.foundation.layout.rememberBoxMeasurePolicy (Box.kt:109)");
        }
        if (!AbstractC13042fc3.d(interfaceC12529em, InterfaceC12529em.a.o()) || z) {
            interfaceC22053ub1.W(-1709737635);
            boolean z2 = ((((i & 14) ^ 6) > 4 && interfaceC22053ub1.V(interfaceC12529em)) || (i & 6) == 4) | ((((i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.a(z)) || (i & 48) == 32);
            Object objB = interfaceC22053ub1.B();
            if (z2 || objB == InterfaceC22053ub1.a.a()) {
                objB = new g(interfaceC12529em, z);
                interfaceC22053ub1.s(objB);
            }
            interfaceC10970cW3 = (g) objB;
            interfaceC22053ub1.Q();
        } else {
            interfaceC22053ub1.W(-1709785313);
            interfaceC22053ub1.Q();
            interfaceC10970cW3 = c;
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC10970cW3;
    }

    static final class b implements InterfaceC10970cW3 {
        public static final b a = new b();

        b() {
        }

        @Override // ir.nasim.InterfaceC10970cW3
        public final InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, C17833ne1.n(j), C17833ne1.m(j), null, a.e, 4, null);
        }

        static final class a extends AbstractC8614Ws3 implements UA2 {
            public static final a e = new a();

            a() {
                super(1);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((AbstractC21430te5.a) obj);
                return C19938rB7.a;
            }

            public final void a(AbstractC21430te5.a aVar) {
            }
        }
    }
}
