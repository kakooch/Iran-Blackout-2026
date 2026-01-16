package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.ComposeView;
import ir.nasim.AbstractC13790gp3;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC16030kb1;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import org.xbill.DNS.Type;

/* renamed from: ir.nasim.aj0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9883aj0 extends AbstractC21636ts4 {
    private SO5 f;
    private final InterfaceC9336Zm4 g;
    private View h;

    /* renamed from: ir.nasim.aj0$a */
    static final class a implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.aj0$a$a, reason: collision with other inner class name */
        static final class C0849a implements InterfaceC14603iB2 {
            final /* synthetic */ C9883aj0 a;
            final /* synthetic */ InterfaceC9664aL6 b;

            C0849a(C9883aj0 c9883aj0, InterfaceC9664aL6 interfaceC9664aL6) {
                this.a = c9883aj0;
                this.b = interfaceC9664aL6;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    this.a.t(a.c(this.b), interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List c(InterfaceC9664aL6 interfaceC9664aL6) {
            return (List) interfaceC9664aL6.getValue();
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-87721201, true, new C0849a(C9883aj0.this, AbstractC5976Lq2.c(C9883aj0.this.g, null, null, null, interfaceC22053ub1, 0, 7)), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.aj0$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ C23546x62 a;
        final /* synthetic */ int b;

        b(C23546x62 c23546x62, int i) {
            this.a = c23546x62;
            this.b = i;
        }

        public final void a(L66 l66, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(l66, "$this$Button");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(l66) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                C62.d(this.a, l66.c(androidx.compose.ui.e.a, InterfaceC12529em.a.i()), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, this.b, 0, null, G10.a.d(interfaceC22053ub1, G10.b).o(), 0, null, interfaceC22053ub1, 0, 0, 450556);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((L66) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.aj0$c */
    public static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        public c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* renamed from: ir.nasim.aj0$d */
    public static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(UA2 ua2, List list) {
            super(1);
            this.e = ua2;
            this.f = list;
        }

        public final Object a(int i) {
            return this.e.invoke(this.f.get(i));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    /* renamed from: ir.nasim.aj0$e */
    public static final class e extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ List e;
        final /* synthetic */ C9883aj0 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(List list, C9883aj0 c9883aj0) {
            super(4);
            this.e = list;
            this.f = c9883aj0;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            if ((i2 & 6) == 0) {
                i3 = (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if (!interfaceC22053ub1.o((i3 & 147) != 146, i3 & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
            }
            VO5 vo5 = (VO5) this.e.get(i);
            interfaceC22053ub1.W(-1833894056);
            this.f.A(vo5, interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9883aj0(Context context, SO5 so5, InterfaceC11950dp3 interfaceC11950dp3) {
        super(interfaceC11950dp3);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC11950dp3, "keyboardActions");
        this.f = so5;
        this.g = AbstractC12281eL6.a(AbstractC10360bX0.m());
        View viewInflate = LayoutInflater.from(context).inflate(AbstractC12208eD5.bot_menu, (ViewGroup) null);
        AbstractC13042fc3.h(viewInflate, "inflate(...)");
        ((ComposeView) viewInflate.findViewById(BC5.reply_keyboard_compose_view)).setContent(AbstractC19242q11.c(665166484, true, new a()));
        this.h = viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(final VO5 vo5, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1470764542);
        int i2 = (i & 6) == 0 ? (interfaceC22053ub1J.D(vo5) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(this) ? 32 : 16;
        }
        int i3 = i2;
        if ((i3 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null);
            int i4 = 0;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), InterfaceC12529em.a.l(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarH);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            M66 m66 = M66.a;
            interfaceC22053ub1J.W(142576175);
            for (AbstractC13790gp3 abstractC13790gp3 : vo5.a()) {
                e.a aVar2 = androidx.compose.ui.e.a;
                G10 g10 = G10.a;
                int i5 = G10.b;
                ZH6.a(androidx.compose.foundation.layout.t.y(aVar2, g10.c(interfaceC22053ub1J, i5).b().n()), interfaceC22053ub1J, i4);
                v(m66, abstractC13790gp3, vo5, null, interfaceC22053ub1J, ((i3 << 6) & 896) | 6 | ((i3 << 9) & 57344), 4);
                ZH6.a(androidx.compose.foundation.layout.t.y(aVar2, g10.c(interfaceC22053ub1J, i5).b().n()), interfaceC22053ub1J, 0);
                i4 = 0;
                i3 = i3;
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Xi0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C9883aj0.B(this.a, vo5, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B(C9883aj0 c9883aj0, VO5 vo5, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c9883aj0, "$tmp0_rcvr");
        AbstractC13042fc3.i(vo5, "$replyKeyboardMarkupRow");
        c9883aj0.A(vo5, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private final void C(final List list, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(919852258);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(list) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(this) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            int i3 = G10.b;
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(aVar, g10.c(interfaceC22053ub1J, i3).b().n(), 0.0f, 2, null);
            C24254yJ.f fVarO = C24254yJ.a.o(g10.c(interfaceC22053ub1J, i3).b().u());
            interfaceC22053ub1J.W(21273999);
            boolean zD = interfaceC22053ub1J.D(list) | interfaceC22053ub1J.D(this);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.Vi0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C9883aj0.D(list, this, (InterfaceC15069ix3) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC12623ev3.b(eVarK, null, null, false, fVarO, null, null, false, null, (UA2) objB, interfaceC22053ub1J, 0, 494);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Wi0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C9883aj0.E(this.a, list, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 D(List list, C9883aj0 c9883aj0, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(list, "$state");
        AbstractC13042fc3.i(c9883aj0, "this$0");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        S21 s21 = S21.a;
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, s21.a(), 3, null);
        interfaceC15069ix3.a(list.size(), null, new d(c.e, list), AbstractC19242q11.c(-632812321, true, new e(list, c9883aj0)));
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, s21.b(), 3, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 E(C9883aj0 c9883aj0, List list, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c9883aj0, "$tmp1_rcvr");
        AbstractC13042fc3.i(list, "$state");
        c9883aj0.C(list, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private final C23546x62 I(AbstractC13790gp3 abstractC13790gp3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(1338415967);
        interfaceC22053ub1.W(81136115);
        String strA = !(abstractC13790gp3 instanceof AbstractC13790gp3.f) ? abstractC13790gp3.a() : UY6.c(AbstractC12217eE5.restart_bot, interfaceC22053ub1, 0);
        interfaceC22053ub1.Q();
        C23546x62 c23546x62A = AbstractC8970Ya1.a(strA, G10.a.d(interfaceC22053ub1, G10.b).o().l());
        interfaceC22053ub1.Q();
        return c23546x62A;
    }

    private final void J(AbstractC13790gp3 abstractC13790gp3) {
        SO5 so5 = this.f;
        if (so5 != null) {
            if (abstractC13790gp3 instanceof AbstractC13790gp3.e) {
                so5.e().invoke(((AbstractC13790gp3.e) abstractC13790gp3).a());
                return;
            }
            if (abstractC13790gp3 instanceof AbstractC13790gp3.f) {
                so5.e().invoke(((AbstractC13790gp3.f) abstractC13790gp3).a());
                return;
            }
            if (abstractC13790gp3 instanceof AbstractC13790gp3.c) {
                so5.c().invoke(((AbstractC13790gp3.c) abstractC13790gp3).a());
                return;
            }
            if (abstractC13790gp3 instanceof AbstractC13790gp3.d) {
                so5.d().invoke(((AbstractC13790gp3.d) abstractC13790gp3).a());
                return;
            }
            if (abstractC13790gp3 instanceof AbstractC13790gp3.b) {
                AbstractC13790gp3.b bVar = (AbstractC13790gp3.b) abstractC13790gp3;
                so5.b().invoke(bVar.a(), bVar.b());
            } else if (abstractC13790gp3 instanceof AbstractC13790gp3.a) {
                AbstractC13790gp3.a aVar = (AbstractC13790gp3.a) abstractC13790gp3;
                so5.a().invoke(aVar.a(), aVar.b());
            } else {
                if (!(abstractC13790gp3 instanceof AbstractC13790gp3.g)) {
                    throw new NoWhenBranchMatchedException();
                }
                so5.f().invoke(((AbstractC13790gp3.g) abstractC13790gp3).a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(final List list, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(96833728);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(list) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(this) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.animation.e.b(androidx.compose.foundation.layout.t.k(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), 0.0f, C17784nZ1.q(Type.AMTRELAY), 1, null), null, null, 3, null), G10.a.a(interfaceC22053ub1J, G10.b).r(), null, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarD);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            C(list, interfaceC22053ub1J, (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i2 & 14));
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Ui0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C9883aj0.u(this.a, list, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(C9883aj0 c9883aj0, List list, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c9883aj0, "$tmp0_rcvr");
        AbstractC13042fc3.i(list, "$state");
        c9883aj0.t(list, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void v(final ir.nasim.L66 r17, final ir.nasim.AbstractC13790gp3 r18, final ir.nasim.VO5 r19, androidx.compose.ui.e r20, ir.nasim.InterfaceC22053ub1 r21, final int r22, final int r23) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9883aj0.v(ir.nasim.L66, ir.nasim.gp3, ir.nasim.VO5, androidx.compose.ui.e, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w(C9883aj0 c9883aj0, AbstractC13790gp3 abstractC13790gp3) {
        AbstractC13042fc3.i(c9883aj0, "this$0");
        AbstractC13042fc3.i(abstractC13790gp3, "$keyboardButton");
        c9883aj0.J(abstractC13790gp3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x(C9883aj0 c9883aj0, L66 l66, AbstractC13790gp3 abstractC13790gp3, VO5 vo5, androidx.compose.ui.e eVar, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c9883aj0, "$tmp1_rcvr");
        AbstractC13042fc3.i(l66, "$this_KeyboardButton");
        AbstractC13042fc3.i(abstractC13790gp3, "$keyboardButton");
        AbstractC13042fc3.i(vo5, "$replyKeyboardMarkupRow");
        c9883aj0.v(l66, abstractC13790gp3, vo5, eVar, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z(C9883aj0 c9883aj0, SA2 sa2, C23546x62 c23546x62, int i, androidx.compose.ui.e eVar, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(c9883aj0, "$tmp0_rcvr");
        AbstractC13042fc3.i(sa2, "$onClick");
        AbstractC13042fc3.i(c23546x62, "$text");
        c9883aj0.y(sa2, c23546x62, i, eVar, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    public final void K(List list) {
        Object value;
        AbstractC13042fc3.i(list, "replyKeyboardRows");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, list));
    }

    @Override // ir.nasim.AbstractC21636ts4
    public View e() {
        View view = this.h;
        AbstractC13042fc3.f(view);
        return view;
    }

    @Override // ir.nasim.AbstractC21636ts4
    public boolean g() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(final ir.nasim.SA2 r21, final ir.nasim.C23546x62 r22, final int r23, androidx.compose.ui.e r24, ir.nasim.InterfaceC22053ub1 r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9883aj0.y(ir.nasim.SA2, ir.nasim.x62, int, androidx.compose.ui.e, ir.nasim.ub1, int, int):void");
    }
}
