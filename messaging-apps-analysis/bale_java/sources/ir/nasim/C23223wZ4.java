package ir.nasim;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C23223wZ4;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017²\u0006\f\u0010\u0016\u001a\u00020\u00158\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/wZ4;", "Lir/nasim/ua0;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lir/nasim/SZ4;", "h1", "Lir/nasim/Yu3;", "T9", "()Lir/nasim/SZ4;", "viewModel", "i1", "a", "Lir/nasim/RZ4;", "state", "passport_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.wZ4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C23223wZ4 extends AbstractC20740sX2 {

    /* renamed from: i1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int j1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: ir.nasim.wZ4$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C23223wZ4 a() {
            return new C23223wZ4();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.wZ4$b */
    static final class b implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.wZ4$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC9664aL6 c;
            final /* synthetic */ C23223wZ4 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC9664aL6 interfaceC9664aL6, C23223wZ4 c23223wZ4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC9664aL6;
                this.d = c23223wZ4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                QZ4 qz4I = b.c(this.c).i();
                if (qz4I != null) {
                    C23223wZ4 c23223wZ4 = this.d;
                    c23223wZ4.L2(qz4I.j());
                    c23223wZ4.T9().a1();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.wZ4$b$b, reason: collision with other inner class name */
        static final class C1764b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            int c;
            final /* synthetic */ InterfaceC9664aL6 d;
            final /* synthetic */ C19391qG6 e;
            final /* synthetic */ C23223wZ4 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1764b(InterfaceC9664aL6 interfaceC9664aL6, C19391qG6 c19391qG6, C23223wZ4 c23223wZ4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC9664aL6;
                this.e = c19391qG6;
                this.f = c23223wZ4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1764b(this.d, this.e, this.f, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                C23223wZ4 c23223wZ4;
                Object objE = AbstractC14862ic3.e();
                int i = this.c;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    PZ4 pz4H = b.c(this.d).h();
                    if (pz4H != null) {
                        C19391qG6 c19391qG6 = this.e;
                        C23223wZ4 c23223wZ42 = this.f;
                        String strH6 = c23223wZ42.h6(pz4H.j());
                        AbstractC13042fc3.h(strH6, "getString(...)");
                        this.b = c23223wZ42;
                        this.c = 1;
                        if (C19391qG6.f(c19391qG6, strH6, null, false, null, this, 14, null) == objE) {
                            return objE;
                        }
                        c23223wZ4 = c23223wZ42;
                    }
                    return C19938rB7.a;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c23223wZ4 = (C23223wZ4) this.b;
                AbstractC10685c16.b(obj);
                c23223wZ4.T9().Z0();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1764b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.wZ4$b$c */
        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC9664aL6 c;
            final /* synthetic */ C23223wZ4 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(InterfaceC9664aL6 interfaceC9664aL6, C23223wZ4 c23223wZ4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC9664aL6;
                this.d = c23223wZ4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new c(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                Integer numG = b.c(this.c).g();
                if (numG != null) {
                    C23223wZ4 c23223wZ4 = this.d;
                    C22042ua0.A9(c23223wZ4, XX4.INSTANCE.a(numG.intValue()), false, null, 6, null);
                    c23223wZ4.T9().U0();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.wZ4$b$d */
        static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C23223wZ4 c;
            final /* synthetic */ InterfaceC9664aL6 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(C23223wZ4 c23223wZ4, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c23223wZ4;
                this.d = interfaceC9664aL6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new d(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (b.c(this.d).c()) {
                    this.c.Q7().onBackPressed();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.wZ4$b$e */
        static final class e implements InterfaceC14603iB2 {
            final /* synthetic */ C23223wZ4 a;
            final /* synthetic */ C19391qG6 b;
            final /* synthetic */ InterfaceC9664aL6 c;

            /* renamed from: ir.nasim.wZ4$b$e$a */
            static final class a implements InterfaceC14603iB2 {
                final /* synthetic */ C23223wZ4 a;

                a(C23223wZ4 c23223wZ4) {
                    this.a = c23223wZ4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(C23223wZ4 c23223wZ4) {
                    AbstractC13042fc3.i(c23223wZ4, "this$0");
                    c23223wZ4.Q7().onBackPressed();
                    return C19938rB7.a;
                }

                public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    String strC = UY6.c(LD5.passport_name, interfaceC22053ub1, 0);
                    interfaceC22053ub1.W(-2082938217);
                    boolean zD = interfaceC22053ub1.D(this.a);
                    final C23223wZ4 c23223wZ4 = this.a;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.xZ4
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C23223wZ4.b.e.a.c(c23223wZ4);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC21639ts7.i(strC, null, (SA2) objB, null, null, null, null, interfaceC22053ub1, 0, 122);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.wZ4$b$e$b, reason: collision with other inner class name */
            static final class C1765b implements InterfaceC15796kB2 {
                final /* synthetic */ C19391qG6 a;
                final /* synthetic */ C23223wZ4 b;
                final /* synthetic */ InterfaceC9664aL6 c;

                /* renamed from: ir.nasim.wZ4$b$e$b$a */
                /* synthetic */ class a extends EB2 implements UA2 {
                    a(Object obj) {
                        super(1, obj, SZ4.class, "handleEvent", "handleEvent(Lir/nasim/passport/ui/setting/group/model/PassportSettingEvent;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((InterfaceC22627vZ4) obj);
                        return C19938rB7.a;
                    }

                    public final void y(InterfaceC22627vZ4 interfaceC22627vZ4) {
                        AbstractC13042fc3.i(interfaceC22627vZ4, "p0");
                        ((SZ4) this.receiver).X0(interfaceC22627vZ4);
                    }
                }

                C1765b(C19391qG6 c19391qG6, C23223wZ4 c23223wZ4, InterfaceC9664aL6 interfaceC9664aL6) {
                    this.a = c19391qG6;
                    this.b = c23223wZ4;
                    this.c = interfaceC9664aL6;
                }

                public final void a(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(ts4, "paddingValues");
                    if ((i & 6) == 0) {
                        i |= interfaceC22053ub1.V(ts4) ? 4 : 2;
                    }
                    if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.f(androidx.compose.foundation.layout.q.h(androidx.compose.ui.e.a, ts4), 0.0f, 1, null), G10.a.a(interfaceC22053ub1, G10.b).r(), null, 2, null);
                    C19391qG6 c19391qG6 = this.a;
                    C23223wZ4 c23223wZ4 = this.b;
                    InterfaceC9664aL6 interfaceC9664aL6 = this.c;
                    InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
                    int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                    InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                    androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD);
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
                    DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
                    DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
                    InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
                    if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                        interfaceC22053ub1A.s(Integer.valueOf(iA));
                        interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                    }
                    DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
                    androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                    RZ4 rz4C = b.c(interfaceC9664aL6);
                    SZ4 sz4T9 = c23223wZ4.T9();
                    interfaceC22053ub1.W(1576383435);
                    boolean zD = interfaceC22053ub1.D(sz4T9);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new a(sz4T9);
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    OZ4.E(rz4C, c19391qG6, (UA2) ((InterfaceC16733lm3) objB), interfaceC22053ub1, 48);
                    interfaceC22053ub1.u();
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    a((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            e(C23223wZ4 c23223wZ4, C19391qG6 c19391qG6, InterfaceC9664aL6 interfaceC9664aL6) {
                this.a = c23223wZ4;
                this.b = c19391qG6;
                this.c = interfaceC9664aL6;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                AbstractC11029cc6.a(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), AbstractC19242q11.e(1840185843, true, new a(this.a), interfaceC22053ub1, 54), null, null, null, 0, G10.a.a(interfaceC22053ub1, G10.b).r(), 0L, null, AbstractC19242q11.e(-167852216, true, new C1765b(this.b, this.a, this.c), interfaceC22053ub1, 54), interfaceC22053ub1, 805306422, 444);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final RZ4 c(InterfaceC9664aL6 interfaceC9664aL6) {
            return (RZ4) interfaceC9664aL6.getValue();
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(C23223wZ4.this.T9().T0(), null, null, null, interfaceC22053ub1, 0, 7);
            interfaceC22053ub1.W(-1888309768);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new C19391qG6();
                interfaceC22053ub1.s(objB);
            }
            C19391qG6 c19391qG6 = (C19391qG6) objB;
            interfaceC22053ub1.Q();
            QZ4 qz4I = c(interfaceC9664aL6C).i();
            interfaceC22053ub1.W(-1888307109);
            boolean zV = interfaceC22053ub1.V(interfaceC9664aL6C) | interfaceC22053ub1.D(C23223wZ4.this);
            C23223wZ4 c23223wZ4 = C23223wZ4.this;
            Object objB2 = interfaceC22053ub1.B();
            if (zV || objB2 == aVar.a()) {
                objB2 = new a(interfaceC9664aL6C, c23223wZ4, null);
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(qz4I, (InterfaceC14603iB2) objB2, interfaceC22053ub1, 0);
            PZ4 pz4H = c(interfaceC9664aL6C).h();
            interfaceC22053ub1.W(-1888300259);
            boolean zV2 = interfaceC22053ub1.V(interfaceC9664aL6C) | interfaceC22053ub1.D(C23223wZ4.this);
            C23223wZ4 c23223wZ42 = C23223wZ4.this;
            Object objB3 = interfaceC22053ub1.B();
            if (zV2 || objB3 == aVar.a()) {
                objB3 = new C1764b(interfaceC9664aL6C, c19391qG6, c23223wZ42, null);
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(pz4H, (InterfaceC14603iB2) objB3, interfaceC22053ub1, 0);
            Integer numG = c(interfaceC9664aL6C).g();
            interfaceC22053ub1.W(-1888292407);
            boolean zV3 = interfaceC22053ub1.V(interfaceC9664aL6C) | interfaceC22053ub1.D(C23223wZ4.this);
            C23223wZ4 c23223wZ43 = C23223wZ4.this;
            Object objB4 = interfaceC22053ub1.B();
            if (zV3 || objB4 == aVar.a()) {
                objB4 = new c(interfaceC9664aL6C, c23223wZ43, null);
                interfaceC22053ub1.s(objB4);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(numG, (InterfaceC14603iB2) objB4, interfaceC22053ub1, 0);
            Boolean boolValueOf = Boolean.valueOf(c(interfaceC9664aL6C).c());
            interfaceC22053ub1.W(-1888284238);
            boolean zV4 = interfaceC22053ub1.V(interfaceC9664aL6C) | interfaceC22053ub1.D(C23223wZ4.this);
            C23223wZ4 c23223wZ44 = C23223wZ4.this;
            Object objB5 = interfaceC22053ub1.B();
            if (zV4 || objB5 == aVar.a()) {
                objB5 = new d(c23223wZ44, interfaceC9664aL6C, null);
                interfaceC22053ub1.s(objB5);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(boolValueOf, (InterfaceC14603iB2) objB5, interfaceC22053ub1, 0);
            M10.f(false, AbstractC19242q11.e(-1489343177, true, new e(C23223wZ4.this, c19391qG6, interfaceC9664aL6C), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.wZ4$c */
    public static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.wZ4$d */
    public static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.wZ4$e */
    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.wZ4$f */
    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = sa2;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            return hVar != null ? hVar.p3() : AbstractC20375ru1.a.b;
        }
    }

    /* renamed from: ir.nasim.wZ4$g */
    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = fragment;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3;
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            if (hVar != null && (cVarN3 = hVar.n3()) != null) {
                return cVarN3;
            }
            G.c cVarN32 = this.e.n3();
            AbstractC13042fc3.h(cVarN32, "defaultViewModelProviderFactory");
            return cVarN32;
        }
    }

    public C23223wZ4() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new d(new c(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(SZ4.class), new e(interfaceC9173Yu3B), new f(null, interfaceC9173Yu3B), new g(this, interfaceC9173Yu3B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SZ4 T9() {
        return (SZ4) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextS7, null, 0, 6, null);
        composeView.setBackgroundColor(composeView.getContext().getColor(CA5.background));
        composeView.setContent(AbstractC19242q11.c(-1546907374, true, new b()));
        return composeView;
    }
}
