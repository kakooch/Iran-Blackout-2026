package ir.nasim;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.ui.window.PopupLayout;
import ir.nasim.AbstractC21430te5;
import ir.nasim.InterfaceC16030kb1;
import java.util.List;
import java.util.UUID;

/* renamed from: ir.nasim.Nq, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC6456Nq {
    private static final AbstractC6535Nx5 a = AbstractC11024cc1.d(null, a.e, 1, null);

    /* renamed from: ir.nasim.Nq$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "DEFAULT_TEST_TAG";
        }
    }

    /* renamed from: ir.nasim.Nq$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC12529em e;
        final /* synthetic */ long f;
        final /* synthetic */ SA2 g;
        final /* synthetic */ C7117Qi5 h;
        final /* synthetic */ InterfaceC14603iB2 i;
        final /* synthetic */ int j;
        final /* synthetic */ int k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC12529em interfaceC12529em, long j, SA2 sa2, C7117Qi5 c7117Qi5, InterfaceC14603iB2 interfaceC14603iB2, int i, int i2) {
            super(2);
            this.e = interfaceC12529em;
            this.f = j;
            this.g = sa2;
            this.h = c7117Qi5;
            this.i = interfaceC14603iB2;
            this.j = i;
            this.k = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC6456Nq.c(this.e, this.f, this.g, this.h, this.i, interfaceC22053ub1, QJ5.a(this.j | 1), this.k);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Nq$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ PopupLayout e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ C7117Qi5 g;
        final /* synthetic */ String h;
        final /* synthetic */ EnumC12613eu3 i;

        /* renamed from: ir.nasim.Nq$c$a */
        public static final class a implements KV1 {
            final /* synthetic */ PopupLayout a;

            public a(PopupLayout popupLayout) {
                this.a = popupLayout;
            }

            @Override // ir.nasim.KV1
            public void dispose() {
                this.a.h();
                this.a.p();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(PopupLayout popupLayout, SA2 sa2, C7117Qi5 c7117Qi5, String str, EnumC12613eu3 enumC12613eu3) {
            super(1);
            this.e = popupLayout;
            this.f = sa2;
            this.g = c7117Qi5;
            this.h = str;
            this.i = enumC12613eu3;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            this.e.t();
            this.e.v(this.f, this.g, this.h, this.i);
            return new a(this.e);
        }
    }

    /* renamed from: ir.nasim.Nq$d */
    static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ PopupLayout e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ C7117Qi5 g;
        final /* synthetic */ String h;
        final /* synthetic */ EnumC12613eu3 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(PopupLayout popupLayout, SA2 sa2, C7117Qi5 c7117Qi5, String str, EnumC12613eu3 enumC12613eu3) {
            super(0);
            this.e = popupLayout;
            this.f = sa2;
            this.g = c7117Qi5;
            this.h = str;
            this.i = enumC12613eu3;
        }

        public final void a() {
            this.e.v(this.f, this.g, this.h, this.i);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Nq$g */
    static final class g extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ PopupLayout e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(PopupLayout popupLayout) {
            super(1);
            this.e = popupLayout;
        }

        public final void a(InterfaceC11379cu3 interfaceC11379cu3) {
            InterfaceC11379cu3 interfaceC11379cu3O0 = interfaceC11379cu3.o0();
            AbstractC13042fc3.f(interfaceC11379cu3O0);
            this.e.x(interfaceC11379cu3O0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11379cu3) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Nq$i */
    static final class i extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC6873Pi5 e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ C7117Qi5 g;
        final /* synthetic */ InterfaceC14603iB2 h;
        final /* synthetic */ int i;
        final /* synthetic */ int j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(InterfaceC6873Pi5 interfaceC6873Pi5, SA2 sa2, C7117Qi5 c7117Qi5, InterfaceC14603iB2 interfaceC14603iB2, int i, int i2) {
            super(2);
            this.e = interfaceC6873Pi5;
            this.f = sa2;
            this.g = c7117Qi5;
            this.h = interfaceC14603iB2;
            this.i = i;
            this.j = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC6456Nq.a(this.e, this.f, this.g, this.h, interfaceC22053ub1, QJ5.a(this.i | 1), this.j);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Nq$j */
    static final class j extends AbstractC8614Ws3 implements SA2 {
        public static final j e = new j();

        j() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UUID invoke() {
            return UUID.randomUUID();
        }
    }

    /* renamed from: ir.nasim.Nq$k */
    static final class k extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ PopupLayout e;
        final /* synthetic */ InterfaceC9664aL6 f;

        /* renamed from: ir.nasim.Nq$k$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            public static final a e = new a();

            a() {
                super(1);
            }

            public final void a(InterfaceC11943do6 interfaceC11943do6) {
                AbstractC9939ao6.R(interfaceC11943do6);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((InterfaceC11943do6) obj);
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.Nq$k$b */
        static final class b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ PopupLayout e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(PopupLayout popupLayout) {
                super(1);
                this.e = popupLayout;
            }

            public final void a(long j) {
                this.e.m4setPopupContentSizefhxjrPA(C4414Fa3.b(j));
                this.e.z();
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(((C4414Fa3) obj).j());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(PopupLayout popupLayout, InterfaceC9664aL6 interfaceC9664aL6) {
            super(2);
            this.e = popupLayout;
            this.f = interfaceC9664aL6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1302892335, i, -1, "androidx.compose.ui.window.Popup.<anonymous>.<anonymous>.<anonymous> (AndroidPopup.android.kt:317)");
            }
            androidx.compose.ui.e eVarD = AbstractC6919Pn6.d(androidx.compose.ui.e.a, false, a.e, 1, null);
            boolean zD = interfaceC22053ub1.D(this.e);
            PopupLayout popupLayout = this.e;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new b(popupLayout);
                interfaceC22053ub1.s(objB);
            }
            androidx.compose.ui.e eVarA = AbstractC21571tm.a(androidx.compose.ui.layout.e.a(eVarD, (UA2) objB), this.e.getCanCalculatePosition() ? 1.0f : 0.0f);
            InterfaceC14603iB2 interfaceC14603iB2B = AbstractC6456Nq.b(this.f);
            C6705Oq c6705Oq = C6705Oq.a;
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarA);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
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
            DG7.c(interfaceC22053ub1A, c6705Oq, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            interfaceC14603iB2B.invoke(interfaceC22053ub1, 0);
            interfaceC22053ub1.u();
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

    /* JADX WARN: Removed duplicated region for block: B:132:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(ir.nasim.InterfaceC6873Pi5 r35, ir.nasim.SA2 r36, ir.nasim.C7117Qi5 r37, ir.nasim.InterfaceC14603iB2 r38, ir.nasim.InterfaceC22053ub1 r39, int r40, int r41) {
        /*
            Method dump skipped, instructions count: 774
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC6456Nq.a(ir.nasim.Pi5, ir.nasim.SA2, ir.nasim.Qi5, ir.nasim.iB2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC14603iB2 b(InterfaceC9664aL6 interfaceC9664aL6) {
        return (InterfaceC14603iB2) interfaceC9664aL6.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(ir.nasim.InterfaceC12529em r25, long r26, ir.nasim.SA2 r28, ir.nasim.C7117Qi5 r29, ir.nasim.InterfaceC14603iB2 r30, ir.nasim.InterfaceC22053ub1 r31, int r32, int r33) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC6456Nq.c(ir.nasim.em, long, ir.nasim.SA2, ir.nasim.Qi5, ir.nasim.iB2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int h(boolean z, EnumC20851si6 enumC20851si6, boolean z2) {
        int i2 = !z ? 262152 : 262144;
        if (enumC20851si6 == EnumC20851si6.b) {
            i2 |= 8192;
        }
        return !z2 ? i2 | 512 : i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int i(C7117Qi5 c7117Qi5, boolean z) {
        return (c7117Qi5.e() && z) ? c7117Qi5.d() | 8192 : (!c7117Qi5.e() || z) ? c7117Qi5.d() : c7117Qi5.d() & (-8193);
    }

    public static final boolean j(View view) {
        ViewGroup.LayoutParams layoutParams = view.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        return (layoutParams2 == null || (layoutParams2.flags & 8192) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C25005za3 k(Rect rect) {
        return new C25005za3(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* renamed from: ir.nasim.Nq$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ PopupLayout e;
        final /* synthetic */ InterfaceC6873Pi5 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(PopupLayout popupLayout, InterfaceC6873Pi5 interfaceC6873Pi5) {
            super(1);
            this.e = popupLayout;
            this.f = interfaceC6873Pi5;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            this.e.setPositionProvider(this.f);
            this.e.z();
            return new a();
        }

        /* renamed from: ir.nasim.Nq$e$a */
        public static final class a implements KV1 {
            @Override // ir.nasim.KV1
            public void dispose() {
            }
        }
    }

    /* renamed from: ir.nasim.Nq$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ PopupLayout d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(PopupLayout popupLayout, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = popupLayout;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = new f(this.d, interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0033 -> B:14:0x0036). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r3.b
                r2 = 1
                if (r1 == 0) goto L1b
                if (r1 != r2) goto L13
                java.lang.Object r1 = r3.c
                ir.nasim.ro1 r1 = (ir.nasim.InterfaceC20315ro1) r1
                ir.nasim.AbstractC10685c16.b(r4)
                goto L36
            L13:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
            L1b:
                ir.nasim.AbstractC10685c16.b(r4)
                java.lang.Object r4 = r3.c
                ir.nasim.ro1 r4 = (ir.nasim.InterfaceC20315ro1) r4
                r1 = r4
            L23:
                boolean r4 = ir.nasim.AbstractC20906so1.g(r1)
                if (r4 == 0) goto L3c
                ir.nasim.Nq$f$a r4 = ir.nasim.AbstractC6456Nq.f.a.e
                r3.c = r1
                r3.b = r2
                java.lang.Object r4 = ir.nasim.AbstractC19294q63.a(r4, r3)
                if (r4 != r0) goto L36
                return r0
            L36:
                androidx.compose.ui.window.PopupLayout r4 = r3.d
                r4.s()
                goto L23
            L3c:
                ir.nasim.rB7 r4 = ir.nasim.C19938rB7.a
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC6456Nq.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }

        /* renamed from: ir.nasim.Nq$f$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            public static final a e = new a();

            a() {
                super(1);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(((Number) obj).longValue());
                return C19938rB7.a;
            }

            public final void a(long j) {
            }
        }
    }

    /* renamed from: ir.nasim.Nq$h */
    static final class h implements InterfaceC10970cW3 {
        final /* synthetic */ PopupLayout a;
        final /* synthetic */ EnumC12613eu3 b;

        h(PopupLayout popupLayout, EnumC12613eu3 enumC12613eu3) {
            this.a = popupLayout;
            this.b = enumC12613eu3;
        }

        @Override // ir.nasim.InterfaceC10970cW3
        public final InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
            this.a.setParentLayoutDirection(this.b);
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, 0, 0, null, a.e, 4, null);
        }

        /* renamed from: ir.nasim.Nq$h$a */
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
