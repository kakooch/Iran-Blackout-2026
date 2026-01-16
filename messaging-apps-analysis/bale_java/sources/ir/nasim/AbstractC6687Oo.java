package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC21430te5;
import ir.nasim.InterfaceC16030kb1;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* renamed from: ir.nasim.Oo, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC6687Oo {

    /* renamed from: ir.nasim.Oo$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ XP1 e;

        /* renamed from: ir.nasim.Oo$a$a, reason: collision with other inner class name */
        public static final class C0561a implements KV1 {
            final /* synthetic */ XP1 a;

            public C0561a(XP1 xp1) {
                this.a = xp1;
            }

            @Override // ir.nasim.KV1
            public void dispose() {
                this.a.dismiss();
                this.a.h();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(XP1 xp1) {
            super(1);
            this.e = xp1;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            this.e.show();
            return new C0561a(this.e);
        }
    }

    /* renamed from: ir.nasim.Oo$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ XP1 e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ C18876pP1 g;
        final /* synthetic */ EnumC12613eu3 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(XP1 xp1, SA2 sa2, C18876pP1 c18876pP1, EnumC12613eu3 enumC12613eu3) {
            super(0);
            this.e = xp1;
            this.f = sa2;
            this.g = c18876pP1;
            this.h = enumC12613eu3;
        }

        public final void a() {
            this.e.l(this.f, this.g, this.h);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Oo$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ C18876pP1 f;
        final /* synthetic */ InterfaceC14603iB2 g;
        final /* synthetic */ int h;
        final /* synthetic */ int i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(SA2 sa2, C18876pP1 c18876pP1, InterfaceC14603iB2 interfaceC14603iB2, int i, int i2) {
            super(2);
            this.e = sa2;
            this.f = c18876pP1;
            this.g = interfaceC14603iB2;
            this.h = i;
            this.i = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC6687Oo.a(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1), this.i);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Oo$d */
    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC9664aL6 e;

        /* renamed from: ir.nasim.Oo$d$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            public static final a e = new a();

            a() {
                super(1);
            }

            public final void a(InterfaceC11943do6 interfaceC11943do6) {
                AbstractC9939ao6.j(interfaceC11943do6);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((InterfaceC11943do6) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC9664aL6 interfaceC9664aL6) {
            super(2);
            this.e = interfaceC9664aL6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(488261145, i, -1, "androidx.compose.ui.window.Dialog.<anonymous>.<anonymous>.<anonymous> (AndroidDialog.android.kt:192)");
            }
            AbstractC6687Oo.c(AbstractC6919Pn6.d(androidx.compose.ui.e.a, false, a.e, 1, null), AbstractC6687Oo.b(this.e), interfaceC22053ub1, 0, 0);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Oo$e */
    static final class e extends AbstractC8614Ws3 implements SA2 {
        public static final e e = new e();

        e() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UUID invoke() {
            return UUID.randomUUID();
        }
    }

    /* renamed from: ir.nasim.Oo$f */
    static final class f implements InterfaceC10970cW3 {
        public static final f a = new f();

        /* renamed from: ir.nasim.Oo$f$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ List e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(List list) {
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

        f() {
        }

        @Override // ir.nasim.InterfaceC10970cW3
        public final InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            int iN = 0;
            int iM = 0;
            for (int i = 0; i < size; i++) {
                AbstractC21430te5 abstractC21430te5L0 = ((ZV3) list.get(i)).l0(j);
                iN = Math.max(iN, abstractC21430te5L0.P0());
                iM = Math.max(iM, abstractC21430te5L0.A0());
                arrayList.add(abstractC21430te5L0);
            }
            if (list.isEmpty()) {
                iN = C17833ne1.n(j);
                iM = C17833ne1.m(j);
            }
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, iN, iM, null, new a(arrayList), 4, null);
        }
    }

    /* renamed from: ir.nasim.Oo$g */
    static final class g extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ InterfaceC14603iB2 f;
        final /* synthetic */ int g;
        final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(androidx.compose.ui.e eVar, InterfaceC14603iB2 interfaceC14603iB2, int i, int i2) {
            super(2);
            this.e = eVar;
            this.f = interfaceC14603iB2;
            this.g = i;
            this.h = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC6687Oo.c(this.e, this.f, interfaceC22053ub1, QJ5.a(this.g | 1), this.h);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(ir.nasim.SA2 r24, ir.nasim.C18876pP1 r25, ir.nasim.InterfaceC14603iB2 r26, ir.nasim.InterfaceC22053ub1 r27, int r28, int r29) {
        /*
            Method dump skipped, instructions count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC6687Oo.a(ir.nasim.SA2, ir.nasim.pP1, ir.nasim.iB2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC14603iB2 b(InterfaceC9664aL6 interfaceC9664aL6) {
        return (InterfaceC14603iB2) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(androidx.compose.ui.e eVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1177876616);
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
                AbstractC5138Ib1.Q(-1177876616, i3, -1, "androidx.compose.ui.window.DialogLayout (AndroidDialog.android.kt:608)");
            }
            f fVar = f.a;
            int i5 = ((i3 >> 3) & 14) | 384 | ((i3 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVar);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
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
            DG7.c(interfaceC22053ub1A, fVar, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
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
            interfaceC20208rd6M.a(new g(eVar, interfaceC14603iB2, i, i2));
        }
    }
}
