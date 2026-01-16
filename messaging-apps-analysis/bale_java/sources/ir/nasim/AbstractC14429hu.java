package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.AbstractC21430te5;
import ir.nasim.C13245fu;
import ir.nasim.InterfaceC16030kb1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.hu, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC14429hu {
    private static final XV4 a = new XV4(AbstractC10360bX0.m(), AbstractC10360bX0.m());

    /* renamed from: ir.nasim.hu$a */
    static final class a implements InterfaceC10970cW3 {
        public static final a a = new a();

        /* renamed from: ir.nasim.hu$a$a, reason: collision with other inner class name */
        static final class C1286a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ List e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1286a(List list) {
                super(1);
                this.e = list;
            }

            public final void a(AbstractC21430te5.a aVar) {
                List list = this.e;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    AbstractC21430te5.a.l(aVar, (AbstractC21430te5) list.get(i), 0, 0, 0.0f, 4, null);
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
            for (int i = 0; i < size; i++) {
                arrayList.add(((ZV3) list.get(i)).l0(j));
            }
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, C17833ne1.l(j), C17833ne1.k(j), null, new C1286a(arrayList), 4, null);
        }
    }

    /* renamed from: ir.nasim.hu$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C13245fu e;
        final /* synthetic */ List f;
        final /* synthetic */ int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C13245fu c13245fu, List list, int i) {
            super(2);
            this.e = c13245fu;
            this.f = list;
            this.g = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC14429hu.a(this.e, this.f, interfaceC22053ub1, QJ5.a(this.g | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(C13245fu c13245fu, List list, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1794596951);
        int i2 = (i & 6) == 0 ? (interfaceC22053ub1J.V(c13245fu) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(list) ? 32 : 16;
        }
        int i3 = 0;
        if (interfaceC22053ub1J.o((i2 & 19) != 18, i2 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1794596951, i2, -1, "androidx.compose.foundation.text.InlineChildren (AnnotatedStringResolveInlineContent.kt:67)");
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                C13245fu.d dVar = (C13245fu.d) list.get(i4);
                InterfaceC15796kB2 interfaceC15796kB2 = (InterfaceC15796kB2) dVar.a();
                int iB = dVar.b();
                int iC = dVar.c();
                a aVar = a.a;
                e.a aVar2 = androidx.compose.ui.e.a;
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, i3);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar2);
                InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar3.a();
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
                DG7.c(interfaceC22053ub1A, aVar, aVar3.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
                i3 = 0;
                interfaceC15796kB2.q(c13245fu.subSequence(iB, iC).k(), interfaceC22053ub1J, 0);
                interfaceC22053ub1J.u();
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new b(c13245fu, list, i));
        }
    }

    public static final boolean b(C13245fu c13245fu) {
        return c13245fu.p("androidx.compose.foundation.text.inlineContent", 0, c13245fu.k().length());
    }

    public static final XV4 c(C13245fu c13245fu, Map map) {
        if (map == null || map.isEmpty()) {
            return a;
        }
        List listJ = c13245fu.j("androidx.compose.foundation.text.inlineContent", 0, c13245fu.k().length());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = listJ.size();
        for (int i = 0; i < size; i++) {
            C13245fu.d dVar = (C13245fu.d) listJ.get(i);
            C13386g83 c13386g83 = (C13386g83) map.get(dVar.g());
            if (c13386g83 != null) {
                arrayList.add(new C13245fu.d(c13386g83.b(), dVar.h(), dVar.f()));
                arrayList2.add(new C13245fu.d(c13386g83.a(), dVar.h(), dVar.f()));
            }
        }
        return new XV4(arrayList, arrayList2);
    }
}
