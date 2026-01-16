package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import androidx.compose.ui.e;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC14472hy4;
import ir.nasim.AbstractC22169um7;
import ir.nasim.AbstractC22926w32;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22053ub1;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.w32, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC22926w32 {

    /* renamed from: ir.nasim.w32$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C32 c;
        final /* synthetic */ Context d;
        final /* synthetic */ C19391qG6 e;
        final /* synthetic */ SA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C32 c32, Context context, C19391qG6 c19391qG6, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c32;
            this.d = context;
            this.e = c19391qG6;
            this.f = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (this.c.g() != null) {
                    Context context = this.d;
                    C19391qG6 c19391qG6 = this.e;
                    C32 c32 = this.c;
                    SA2 sa2 = this.f;
                    YF6 yf6G = c32.g();
                    this.b = 1;
                    if (AbstractC22926w32.v(context, c19391qG6, yf6G, sa2, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.w32$b */
    static final class b implements PointerInputEventHandler {
        final /* synthetic */ InterfaceC3630Br2 a;

        b(InterfaceC3630Br2 interfaceC3630Br2) {
            this.a = interfaceC3630Br2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 b(InterfaceC3630Br2 interfaceC3630Br2, ZG4 zg4) {
            AbstractC13042fc3.i(interfaceC3630Br2, "$localFocusManager");
            InterfaceC3630Br2.m(interfaceC3630Br2, false, 1, null);
            return C19938rB7.a;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            final InterfaceC3630Br2 interfaceC3630Br2 = this.a;
            Object objK = AbstractC20271rj7.k(interfaceC9049Yg5, null, null, null, new UA2() { // from class: ir.nasim.x32
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return AbstractC22926w32.b.b(interfaceC3630Br2, (ZG4) obj);
                }
            }, interfaceC20295rm1, 7, null);
            return objK == AbstractC14862ic3.e() ? objK : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.w32$c */
    static final class c implements InterfaceC14603iB2 {
        final /* synthetic */ B32 a;
        final /* synthetic */ SA2 b;

        /* renamed from: ir.nasim.w32$c$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ B32 a;
            final /* synthetic */ SA2 b;

            a(B32 b32, SA2 sa2) {
                this.a = b32;
                this.b = sa2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC21639ts7.i(AbstractC22926w32.q(this.a, interfaceC22053ub1, 0), androidx.compose.ui.e.a, this.b, null, null, null, null, interfaceC22053ub1, 48, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        c(B32 b32, SA2 sa2) {
            this.a = b32;
            this.b = sa2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(1043643061, true, new a(this.a, this.b), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.w32$d */
    static final class d implements InterfaceC14603iB2 {
        final /* synthetic */ C19391qG6 a;

        d(C19391qG6 c19391qG6) {
            this.a = c19391qG6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC18209oG6.b(this.a, null, C21085t51.a.a(), interfaceC22053ub1, 390, 2);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.w32$e */
    static final class e implements InterfaceC15796kB2 {
        final /* synthetic */ B32 a;
        final /* synthetic */ UA2 b;
        final /* synthetic */ SA2 c;
        final /* synthetic */ C32 d;
        final /* synthetic */ UA2 e;

        e(B32 b32, UA2 ua2, SA2 sa2, C32 c32, UA2 ua22) {
            this.a = b32;
            this.b = ua2;
            this.c = sa2;
            this.d = c32;
            this.e = ua22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(InterfaceC11943do6 interfaceC11943do6) {
            AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
            AbstractC9939ao6.F0(interfaceC11943do6, 2.0f);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(UA2 ua2, C32 c32) {
            AbstractC13042fc3.i(ua2, "$saveInfo");
            AbstractC13042fc3.i(c32, "$state");
            ua2.invoke(c32.i());
            return C19938rB7.a;
        }

        public final void c(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(ts4, "paddingValues");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(ts4) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null), 0.0f, ts4.c(), 0.0f, 0.0f, 13, null);
            B32 b32 = this.a;
            UA2 ua2 = this.b;
            SA2 sa2 = this.c;
            final C32 c32 = this.d;
            final UA2 ua22 = this.e;
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarM);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            androidx.compose.ui.e eVarG = AbstractC8014Ud6.g(aVar, AbstractC8014Ud6.c(0, interfaceC22053ub1, 0, 1), false, null, false, 14, null);
            G10 g10 = G10.a;
            int i3 = G10.b;
            androidx.compose.ui.e eVarM2 = androidx.compose.foundation.layout.q.m(eVarG, 0.0f, g10.c(interfaceC22053ub1, i3).b().j(), 0.0f, 0.0f, 13, null);
            C24254yJ c24254yJ = C24254yJ.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), aVar2.k(), interfaceC22053ub1, 0);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarM2);
            SA2 sa2A2 = aVar3.a();
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
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            AbstractC22926w32.g(b32, ua2, sa2, c32, interfaceC22053ub1, 0);
            interfaceC22053ub1.u();
            androidx.compose.ui.e eVarH = hVar.h(androidx.compose.foundation.b.d(aVar, g10.a(interfaceC22053ub1, i3).w(), null, 2, null), aVar2.b());
            InterfaceC10970cW3 interfaceC10970cW3A2 = XY0.a(c24254yJ.h(), aVar2.k(), interfaceC22053ub1, 0);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarH);
            SA2 sa2A3 = aVar3.a();
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
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3A2, aVar3.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar3.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar3.f());
            MY2.b(null, null, 0L, interfaceC22053ub1, 0, 7);
            androidx.compose.ui.e eVarH2 = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.i(aVar, g10.c(interfaceC22053ub1, i3).b().c()), 0.0f, 1, null);
            interfaceC22053ub1.W(-14240910);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar4 = InterfaceC22053ub1.a;
            if (objB == aVar4.a()) {
                objB = new UA2() { // from class: ir.nasim.y32
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC22926w32.e.d((InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarD = AbstractC6919Pn6.d(eVarH2, false, (UA2) objB, 1, null);
            String strC = UY6.c(QD5.story_save, interfaceC22053ub1, 0);
            InterfaceC19114po0 interfaceC19114po0 = c32.e() ? InterfaceC19114po0.b.a.a : InterfaceC19114po0.a.C1453a.a;
            interfaceC22053ub1.W(-14229035);
            boolean zV = interfaceC22053ub1.V(ua22) | interfaceC22053ub1.V(c32);
            Object objB2 = interfaceC22053ub1.B();
            if (zV || objB2 == aVar4.a()) {
                objB2 = new SA2() { // from class: ir.nasim.z32
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC22926w32.e.f(ua22, c32);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC17932no0.y(eVarD, (SA2) objB2, interfaceC19114po0, null, strC, null, interfaceC22053ub1, 0, 40);
            interfaceC22053ub1.u();
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.w32$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ androidx.compose.ui.focus.m c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(androidx.compose.ui.focus.m mVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = mVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            androidx.compose.ui.focus.m.g(this.c, 0, 1, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.w32$g */
    public /* synthetic */ class g {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[B32.values().length];
            try {
                iArr[B32.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[B32.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[B32.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC9920am7.values().length];
            try {
                iArr2[EnumC9920am7.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[EnumC9920am7.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[EnumC9920am7.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[EnumC9920am7.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[EnumC9920am7.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[EnumC9920am7.f.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            b = iArr2;
            int[] iArr3 = new int[YF6.values().length];
            try {
                iArr3[YF6.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[YF6.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[YF6.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[YF6.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            c = iArr3;
        }
    }

    /* renamed from: ir.nasim.w32$h */
    static final class h implements InterfaceC15796kB2 {
        public static final h a = new h();

        /* renamed from: ir.nasim.w32$h$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ boolean c;
            final /* synthetic */ InterfaceC3630Br2 d;
            final /* synthetic */ InterfaceC9102Ym4 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(boolean z, InterfaceC3630Br2 interfaceC3630Br2, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = z;
                this.d = interfaceC3630Br2;
                this.e = interfaceC9102Ym4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (this.c) {
                    h.k(this.e, true);
                } else if (h.i(this.e)) {
                    InterfaceC3630Br2.m(this.d, false, 1, null);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        h() {
        }

        private static final boolean f(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
        }

        private static final void h(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
            interfaceC9102Ym4.setValue(Boolean.valueOf(z));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean i(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
            interfaceC9102Ym4.setValue(Boolean.valueOf(z));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 n(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, InterfaceC5517Jr2 interfaceC5517Jr2) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$isFocused$delegate");
            AbstractC13042fc3.i(interfaceC9102Ym42, "$keyboardAppearedSinceLastFocused$delegate");
            AbstractC13042fc3.i(interfaceC5517Jr2, "it");
            if (f(interfaceC9102Ym4) != interfaceC5517Jr2.a()) {
                h(interfaceC9102Ym4, interfaceC5517Jr2.a());
                if (f(interfaceC9102Ym4)) {
                    k(interfaceC9102Ym42, false);
                }
            }
            return C19938rB7.a;
        }

        public final androidx.compose.ui.e d(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(eVar, "$this$composed");
            interfaceC22053ub1.W(1112751259);
            interfaceC22053ub1.W(-1757424350);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                interfaceC22053ub1.s(objB);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1757421822);
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == aVar.a()) {
                objB2 = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                interfaceC22053ub1.s(objB2);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym42 = (InterfaceC9102Ym4) objB2;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1757420228);
            if (f(interfaceC9102Ym4)) {
                boolean zH = AbstractC24416ya8.h(A98.a, interfaceC22053ub1, 6);
                InterfaceC3630Br2 interfaceC3630Br2 = (InterfaceC3630Br2) interfaceC22053ub1.H(AbstractC13040fc1.h());
                Boolean boolValueOf = Boolean.valueOf(zH);
                interfaceC22053ub1.W(-1757415274);
                boolean zA = interfaceC22053ub1.a(zH) | interfaceC22053ub1.D(interfaceC3630Br2);
                Object objB3 = interfaceC22053ub1.B();
                if (zA || objB3 == aVar.a()) {
                    objB3 = new a(zH, interfaceC3630Br2, interfaceC9102Ym42, null);
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                AbstractC10721c52.e(boolValueOf, (InterfaceC14603iB2) objB3, interfaceC22053ub1, 0);
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1757407677);
            Object objB4 = interfaceC22053ub1.B();
            if (objB4 == aVar.a()) {
                objB4 = new UA2() { // from class: ir.nasim.A32
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC22926w32.h.n(interfaceC9102Ym4, interfaceC9102Ym42, (InterfaceC5517Jr2) obj);
                    }
                };
                interfaceC22053ub1.s(objB4);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarA = androidx.compose.ui.focus.e.a(eVar, (UA2) objB4);
            interfaceC22053ub1.Q();
            return eVarA;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return d((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    /* renamed from: ir.nasim.w32$i */
    static final class i extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int c;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC22926w32.v(null, null, null, null, this);
        }
    }

    public static final void e(final B32 b32, final C32 c32, final SA2 sa2, final UA2 ua2, final UA2 ua22, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        Context context;
        C19391qG6 c19391qG6;
        InterfaceC3630Br2 interfaceC3630Br2;
        InterfaceC22053ub1 interfaceC22053ub12;
        InterfaceC22053ub1 interfaceC22053ub13;
        AbstractC13042fc3.i(b32, "editInfoType");
        AbstractC13042fc3.i(c32, "state");
        AbstractC13042fc3.i(sa2, "onBackPress");
        AbstractC13042fc3.i(ua2, "editInfo");
        AbstractC13042fc3.i(ua22, "saveInfo");
        AbstractC13042fc3.i(sa22, "resetSnackBarState");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1584395471);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(b32) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(c32) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(sa2) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= interfaceC22053ub1J.D(ua22) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i3 |= interfaceC22053ub1J.D(sa22) ? 131072 : 65536;
        }
        if ((74899 & i3) == 74898 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub13 = interfaceC22053ub1J;
        } else {
            InterfaceC3630Br2 interfaceC3630Br22 = (InterfaceC3630Br2) interfaceC22053ub1J.H(AbstractC13040fc1.h());
            interfaceC22053ub1J.W(330836540);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new C19391qG6();
                interfaceC22053ub1J.s(objB);
            }
            C19391qG6 c19391qG62 = (C19391qG6) objB;
            interfaceC22053ub1J.Q();
            Context context2 = (Context) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.g());
            interfaceC22053ub1J.W(330839014);
            if (c32.f()) {
                context = context2;
                CG3.g(null, null, null, interfaceC22053ub1J, 0, 7);
            } else {
                context = context2;
            }
            interfaceC22053ub1J.Q();
            YF6 yf6G = c32.g();
            interfaceC22053ub1J.W(330841931);
            boolean zD = ((i3 & 458752) == 131072) | ((i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32) | interfaceC22053ub1J.D(context);
            Object objB2 = interfaceC22053ub1J.B();
            if (zD || objB2 == aVar.a()) {
                c19391qG6 = c19391qG62;
                interfaceC3630Br2 = interfaceC3630Br22;
                interfaceC22053ub12 = interfaceC22053ub1J;
                a aVar2 = new a(c32, context, c19391qG6, sa22, null);
                interfaceC22053ub12.s(aVar2);
                objB2 = aVar2;
            } else {
                c19391qG6 = c19391qG62;
                interfaceC3630Br2 = interfaceC3630Br22;
                interfaceC22053ub12 = interfaceC22053ub1J;
            }
            interfaceC22053ub12.Q();
            AbstractC10721c52.e(yf6G, (InterfaceC14603iB2) objB2, interfaceC22053ub12, 0);
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null);
            G10 g10 = G10.a;
            int i4 = G10.b;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(eVarF, g10.a(interfaceC22053ub12, i4).r(), null, 2, null);
            C19938rB7 c19938rB7 = C19938rB7.a;
            interfaceC22053ub12.W(330855645);
            InterfaceC3630Br2 interfaceC3630Br23 = interfaceC3630Br2;
            boolean zD2 = interfaceC22053ub12.D(interfaceC3630Br23);
            Object objB3 = interfaceC22053ub12.B();
            if (zD2 || objB3 == aVar.a()) {
                objB3 = new b(interfaceC3630Br23);
                interfaceC22053ub12.s(objB3);
            }
            interfaceC22053ub12.Q();
            interfaceC22053ub13 = interfaceC22053ub12;
            AbstractC11029cc6.a(AbstractC21071t37.c(eVarD, c19938rB7, (PointerInputEventHandler) objB3), AbstractC19242q11.e(1029985781, true, new c(b32, sa2), interfaceC22053ub12, 54), null, AbstractC19242q11.e(-893264649, true, new d(c19391qG6), interfaceC22053ub12, 54), null, 0, g10.a(interfaceC22053ub12, i4).r(), 0L, null, AbstractC19242q11.e(991879488, true, new e(b32, ua2, sa2, c32, ua22), interfaceC22053ub12, 54), interfaceC22053ub13, 805309488, 436);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub13.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.s32
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC22926w32.f(b32, c32, sa2, ua2, ua22, sa22, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(B32 b32, C32 c32, SA2 sa2, UA2 ua2, UA2 ua22, SA2 sa22, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(b32, "$editInfoType");
        AbstractC13042fc3.i(c32, "$state");
        AbstractC13042fc3.i(sa2, "$onBackPress");
        AbstractC13042fc3.i(ua2, "$editInfo");
        AbstractC13042fc3.i(ua22, "$saveInfo");
        AbstractC13042fc3.i(sa22, "$resetSnackBarState");
        e(b32, c32, sa2, ua2, ua22, sa22, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final B32 b32, final UA2 ua2, final SA2 sa2, final C32 c32, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1639108803);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(b32) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.V(c32) ? 2048 : 1024;
        }
        if ((i3 & 1043) == 1042 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(1386511200);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new androidx.compose.ui.focus.m();
                interfaceC22053ub1J.s(objB);
            }
            androidx.compose.ui.focus.m mVar = (androidx.compose.ui.focus.m) objB;
            interfaceC22053ub1J.Q();
            C19938rB7 c19938rB7 = C19938rB7.a;
            interfaceC22053ub1J.W(1386512964);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                objB2 = new f(mVar, null);
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB2, interfaceC22053ub1J, 6);
            boolean z = c32.i().length() > 0;
            interfaceC22053ub1J.W(1386515177);
            boolean zA = interfaceC22053ub1J.a(z);
            Object objB3 = interfaceC22053ub1J.B();
            if (zA || objB3 == aVar.a()) {
                objB3 = AbstractC13472gH6.d(new C23945xm7(c32.i(), AbstractC4535Fn7.a(c32.i().length()), (C4301En7) null, 4, (ED1) null), null, 2, null);
                interfaceC22053ub1J.s(objB3);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB3;
            interfaceC22053ub1J.Q();
            if (b32 != B32.c) {
                interfaceC22053ub1J.W(32495309);
                androidx.compose.ui.e eVarP = p(androidx.compose.ui.focus.n.a(androidx.compose.foundation.layout.q.k(androidx.compose.foundation.j.b(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), false, null, 3, null), G10.a.c(interfaceC22053ub1J, G10.b).b().c(), 0.0f, 2, null), mVar));
                C23945xm7 c23945xm7K = k(interfaceC9102Ym4);
                boolean z2 = b32 == B32.b;
                AbstractC14472hy4 abstractC14472hy4U = u(c32, b32, interfaceC22053ub1J, ((i3 >> 9) & 14) | ((i3 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER));
                int i4 = i3 & 14;
                String strQ = q(b32, interfaceC22053ub1J, i4);
                String strR = r(b32, interfaceC22053ub1J, i4);
                interfaceC22053ub1J.W(1386534397);
                boolean zV = interfaceC22053ub1J.V(interfaceC9102Ym4) | ((i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32);
                Object objB4 = interfaceC22053ub1J.B();
                if (zV || objB4 == aVar.a()) {
                    objB4 = new UA2() { // from class: ir.nasim.t32
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC22926w32.h(ua2, interfaceC9102Ym4, (C23945xm7) obj);
                        }
                    };
                    interfaceC22053ub1J.s(objB4);
                }
                interfaceC22053ub1J.Q();
                AbstractC8426Vx4.d0(c23945xm7K, (UA2) objB4, strQ, strR, eVarP, null, false, false, null, null, abstractC14472hy4U, null, null, z2, 0, 0, null, null, false, interfaceC22053ub1J, 0, AbstractC14472hy4.a, 515040);
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(33186051);
                androidx.compose.ui.e eVarP2 = p(androidx.compose.ui.focus.n.a(androidx.compose.foundation.layout.q.k(androidx.compose.foundation.j.b(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), false, null, 3, null), G10.a.c(interfaceC22053ub1J, G10.b).b().c(), 0.0f, 2, null), mVar));
                C23945xm7 c23945xm7K2 = k(interfaceC9102Ym4);
                AbstractC14472hy4 abstractC14472hy4U2 = u(c32, b32, interfaceC22053ub1J, ((i3 >> 9) & 14) | ((i3 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER));
                int i5 = i3 & 14;
                String strQ2 = q(b32, interfaceC22053ub1J, i5);
                String strR2 = r(b32, interfaceC22053ub1J, i5);
                interfaceC22053ub1J.W(1386555869);
                boolean zV2 = interfaceC22053ub1J.V(interfaceC9102Ym4) | ((i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32);
                Object objB5 = interfaceC22053ub1J.B();
                if (zV2 || objB5 == aVar.a()) {
                    objB5 = new UA2() { // from class: ir.nasim.u32
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC22926w32.i(ua2, interfaceC9102Ym4, (C23945xm7) obj);
                        }
                    };
                    interfaceC22053ub1J.s(objB5);
                }
                interfaceC22053ub1J.Q();
                AbstractC8426Vx4.G(c23945xm7K2, (UA2) objB5, strQ2, strR2, eVarP2, false, abstractC14472hy4U2, true, 0, 0, null, interfaceC22053ub1J, (AbstractC14472hy4.a << 18) | 12582912, 6, 800);
                interfaceC22053ub1J.Q();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.v32
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC22926w32.j(b32, ua2, sa2, c32, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4, C23945xm7 c23945xm7) {
        AbstractC13042fc3.i(ua2, "$editInfo");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$textFieldValueState$delegate");
        AbstractC13042fc3.i(c23945xm7, "it");
        l(interfaceC9102Ym4, c23945xm7);
        ua2.invoke(c23945xm7.h());
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4, C23945xm7 c23945xm7) {
        AbstractC13042fc3.i(ua2, "$editInfo");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$textFieldValueState$delegate");
        AbstractC13042fc3.i(c23945xm7, "it");
        l(interfaceC9102Ym4, c23945xm7);
        ua2.invoke(c23945xm7.h());
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(B32 b32, UA2 ua2, SA2 sa2, C32 c32, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(b32, "$editInfoType");
        AbstractC13042fc3.i(ua2, "$editInfo");
        AbstractC13042fc3.i(sa2, "$onBackPress");
        AbstractC13042fc3.i(c32, "$state");
        g(b32, ua2, sa2, c32, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    private static final C23945xm7 k(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (C23945xm7) interfaceC9102Ym4.getValue();
    }

    private static final void l(InterfaceC9102Ym4 interfaceC9102Ym4, C23945xm7 c23945xm7) {
        interfaceC9102Ym4.setValue(c23945xm7);
    }

    public static final androidx.compose.ui.e p(androidx.compose.ui.e eVar) {
        AbstractC13042fc3.i(eVar, "<this>");
        return androidx.compose.ui.c.c(eVar, null, h.a, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String q(B32 b32, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        String strC;
        interfaceC22053ub1.W(65067805);
        int i3 = g.a[b32.ordinal()];
        if (i3 == 1) {
            interfaceC22053ub1.W(1219686150);
            strC = UY6.c(QD5.name, interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
        } else if (i3 == 2) {
            interfaceC22053ub1.W(1219688182);
            strC = UY6.c(QD5.account_info_user_id, interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
        } else {
            if (i3 != 3) {
                interfaceC22053ub1.W(1219684855);
                interfaceC22053ub1.Q();
                throw new NoWhenBranchMatchedException();
            }
            interfaceC22053ub1.W(1219690743);
            strC = UY6.c(QD5.account_info_about_me, interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
        }
        interfaceC22053ub1.Q();
        return strC;
    }

    private static final String r(B32 b32, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        String strC;
        interfaceC22053ub1.W(-1273805696);
        int i3 = g.a[b32.ordinal()];
        if (i3 == 1) {
            interfaceC22053ub1.W(1560738230);
            strC = UY6.c(QD5.account_info_edit_name_place_holder, interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
        } else if (i3 == 2) {
            interfaceC22053ub1.W(1560741241);
            strC = UY6.c(QD5.account_info_edit_user_id_place_holder, interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
        } else {
            if (i3 != 3) {
                interfaceC22053ub1.W(1560736968);
                interfaceC22053ub1.Q();
                throw new NoWhenBranchMatchedException();
            }
            interfaceC22053ub1.W(1560744375);
            strC = UY6.c(QD5.account_info_edit_about_place_holder, interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
        }
        interfaceC22053ub1.Q();
        return strC;
    }

    private static final int s(B32 b32) {
        int i2 = g.a[b32.ordinal()];
        if (i2 == 1) {
            return QD5.account_info_edit_name_description;
        }
        if (i2 == 2) {
            return QD5.account_info_edit_user_id_description;
        }
        if (i2 == 3) {
            return QD5.account_info_edit_about_description;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final int t(AbstractC22169um7.b bVar) {
        switch (g.b[bVar.a().ordinal()]) {
            case 1:
                return QD5.account_info_limit_error_edit_info;
            case 2:
                return QD5.account_info_error_edit_user_id_minimum_limit;
            case 3:
                return QD5.account_info_error_edit_user_id_is_not_valid;
            case 4:
                return QD5.account_info_error_edit_user_id_under_line_first;
            case 5:
                return QD5.account_info_error_edit_user_id_use_number_first;
            case 6:
                return QD5.auth_error_exist;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final AbstractC14472hy4 u(C32 c32, B32 b32, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC14472hy4 bVar;
        interfaceC22053ub1.W(573298223);
        AbstractC22169um7 abstractC22169um7H = c32.h();
        if (abstractC22169um7H instanceof AbstractC22169um7.a) {
            interfaceC22053ub1.W(-48714868);
            bVar = new AbstractC14472hy4.c(Integer.valueOf(AbstractC21822uB5.icon_danger_circle), UY6.c(s(b32), interfaceC22053ub1, 0), Integer.valueOf(b32.j()));
            interfaceC22053ub1.Q();
        } else if (abstractC22169um7H instanceof AbstractC22169um7.b) {
            interfaceC22053ub1.W(-48707741);
            AbstractC14472hy4.a aVar = new AbstractC14472hy4.a(Integer.valueOf(AbstractC21822uB5.danger), UY6.c(t((AbstractC22169um7.b) c32.h()), interfaceC22053ub1, 0), Integer.valueOf(b32.j()));
            interfaceC22053ub1.Q();
            bVar = aVar;
        } else {
            if (!(abstractC22169um7H instanceof AbstractC22169um7.c)) {
                interfaceC22053ub1.W(-48717029);
                interfaceC22053ub1.Q();
                throw new NoWhenBranchMatchedException();
            }
            interfaceC22053ub1.W(-48700849);
            bVar = new AbstractC14472hy4.b(Integer.valueOf(AbstractC21822uB5.loading_search), UY6.c(QD5.account_info_checking, interfaceC22053ub1, 0), Integer.valueOf(b32.j()));
            interfaceC22053ub1.Q();
        }
        interfaceC22053ub1.Q();
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object v(android.content.Context r9, ir.nasim.C19391qG6 r10, ir.nasim.YF6 r11, ir.nasim.SA2 r12, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            boolean r0 = r13 instanceof ir.nasim.AbstractC22926w32.i
            if (r0 == 0) goto L14
            r0 = r13
            ir.nasim.w32$i r0 = (ir.nasim.AbstractC22926w32.i) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.w32$i r0 = new ir.nasim.w32$i
            r0.<init>(r13)
            goto L12
        L1a:
            java.lang.Object r13 = r6.b
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L38
            if (r1 != r2) goto L30
            java.lang.Object r9 = r6.a
            r12 = r9
            ir.nasim.SA2 r12 = (ir.nasim.SA2) r12
            ir.nasim.AbstractC10685c16.b(r13)
            goto L85
        L30:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L38:
            ir.nasim.AbstractC10685c16.b(r13)
            int[] r13 = ir.nasim.AbstractC22926w32.g.c
            int r11 = r11.ordinal()
            r11 = r13[r11]
            if (r11 == r2) goto L69
            r13 = 2
            if (r11 == r13) goto L62
            r13 = 3
            if (r11 == r13) goto L5b
            r13 = 4
            if (r11 != r13) goto L55
            int r11 = ir.nasim.QD5.toast_invalid_nickname
            java.lang.String r9 = r9.getString(r11)
            goto L6f
        L55:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        L5b:
            int r11 = ir.nasim.QD5.toast_invalid_nickname
            java.lang.String r9 = r9.getString(r11)
            goto L6f
        L62:
            int r11 = ir.nasim.QD5.toast_nickname_already_taken
            java.lang.String r9 = r9.getString(r11)
            goto L6f
        L69:
            int r11 = ir.nasim.QD5.toast_unable_change
            java.lang.String r9 = r9.getString(r11)
        L6f:
            ir.nasim.AbstractC13042fc3.f(r9)
            r6.a = r12
            r6.c = r2
            r3 = 0
            r4 = 0
            r5 = 0
            r7 = 14
            r8 = 0
            r1 = r10
            r2 = r9
            java.lang.Object r9 = ir.nasim.C19391qG6.f(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r9 != r0) goto L85
            return r0
        L85:
            r12.invoke()
            ir.nasim.rB7 r9 = ir.nasim.C19938rB7.a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC22926w32.v(android.content.Context, ir.nasim.qG6, ir.nasim.YF6, ir.nasim.SA2, ir.nasim.rm1):java.lang.Object");
    }
}
