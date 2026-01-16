package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC21430te5;
import ir.nasim.InterfaceC16030kb1;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class LC6 {

    static final class a implements InterfaceC10970cW3 {
        public static final a a = new a();

        /* renamed from: ir.nasim.LC6$a$a, reason: collision with other inner class name */
        static final class C0476a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ List e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0476a(List list) {
                super(1);
                this.e = list;
            }

            public final void a(AbstractC21430te5.a aVar) {
                List list = this.e;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    AbstractC21430te5.a.h(aVar, (AbstractC21430te5) list.get(i), 0, 0, 0.0f, 4, null);
                }
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((AbstractC21430te5.a) obj);
                return C19938rB7.a;
            }
        }

        a() {
        }

        @Override // ir.nasim.InterfaceC10970cW3
        public final InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            int iMax = 0;
            int iMax2 = 0;
            for (int i = 0; i < size; i++) {
                AbstractC21430te5 abstractC21430te5L0 = ((ZV3) list.get(i)).l0(j);
                iMax = Math.max(iMax, abstractC21430te5L0.P0());
                iMax2 = Math.max(iMax2, abstractC21430te5L0.A0());
                arrayList.add(abstractC21430te5L0);
            }
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, iMax, iMax2, null, new C0476a(arrayList), 4, null);
        }
    }

    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ InterfaceC14603iB2 f;
        final /* synthetic */ int g;
        final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(androidx.compose.ui.e eVar, InterfaceC14603iB2 interfaceC14603iB2, int i, int i2) {
            super(2);
            this.e = eVar;
            this.f = interfaceC14603iB2;
            this.g = i;
            this.h = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            LC6.a(this.e, this.f, interfaceC22053ub1, QJ5.a(this.g | 1), this.h);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(androidx.compose.ui.e eVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-2105228848);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 32 : 16;
        }
        if (interfaceC22053ub1J.o((i3 & 19) != 18, i3 & 1)) {
            if (i4 != 0) {
                eVar = androidx.compose.ui.e.a;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-2105228848, i3, -1, "androidx.compose.foundation.text.selection.SimpleLayout (SimpleLayout.kt:30)");
            }
            a aVar = a.a;
            int i5 = ((i3 >> 3) & 14) | 384 | ((i3 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVar);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            int i6 = ((i5 << 6) & 896) | 6;
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
            DG7.c(interfaceC22053ub1A, aVar, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            interfaceC14603iB2.invoke(interfaceC22053ub1J, Integer.valueOf((i6 >> 6) & 14));
            interfaceC22053ub1J.u();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new b(eVar, interfaceC14603iB2, i, i2));
        }
    }
}
