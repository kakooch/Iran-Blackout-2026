package ir.nasim;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.InterfaceC16030kb1;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0006J\u000f\u0010\u0011\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0006J\u000f\u0010\u0012\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0012\u0010\u0006J\u000f\u0010\u0013\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0013\u0010\u0006R\u001b\u0010\u0019\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lir/nasim/rs4;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "ta", "(Lir/nasim/ub1;I)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "pa", "wa", "ia", "ra", "Lir/nasim/GS;", "h1", "Lir/nasim/Yu3;", "Ea", "()Lir/nasim/GS;", "viewmodel", "i1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.rs4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C20358rs4 extends AbstractC12994fX2 {

    /* renamed from: i1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int j1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewmodel;

    /* renamed from: ir.nasim.rs4$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C20358rs4 a() {
            return new C20358rs4();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.rs4$b */
    static final class b implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.rs4$b$a */
        /* synthetic */ class a extends EB2 implements SA2 {
            a(Object obj) {
                super(0, obj, FragmentActivity.class, "onBackPressed", "onBackPressed()V", 0);
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                y();
                return C19938rB7.a;
            }

            public final void y() {
                ((FragmentActivity) this.receiver).onBackPressed();
            }
        }

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            String strH6 = C20358rs4.this.h6(AbstractC12217eE5.auto_download_title);
            AbstractC13042fc3.h(strH6, "getString(...)");
            FragmentActivity fragmentActivityQ7 = C20358rs4.this.Q7();
            interfaceC22053ub1.W(619615053);
            boolean zD = interfaceC22053ub1.D(fragmentActivityQ7);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(fragmentActivityQ7);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC21639ts7.i(strH6, null, (SA2) ((InterfaceC16733lm3) objB), null, null, null, null, interfaceC22053ub1, 0, 122);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.rs4$c */
    static final class c implements InterfaceC15796kB2 {
        c() {
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
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarG = AbstractC8014Ud6.g(androidx.compose.foundation.layout.t.f(androidx.compose.foundation.layout.q.m(aVar, 0.0f, ts4.c(), 0.0f, 0.0f, 13, null), 0.0f, 1, null), AbstractC8014Ud6.c(0, interfaceC22053ub1, 0, 1), false, null, false, 14, null);
            C20358rs4 c20358rs4 = C20358rs4.this;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarG);
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
            c20358rs4.wa(interfaceC22053ub1, 0);
            c20358rs4.ia(interfaceC22053ub1, 0);
            interfaceC22053ub1.W(761976260);
            if (c20358rs4.Ea().y1()) {
                AbstractC18436of3.c(AbstractC12217eE5.auto_download_limit_title, interfaceC22053ub1, 0);
                c20358rs4.ta(interfaceC22053ub1, 0);
            }
            interfaceC22053ub1.Q();
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar, G10.a.c(interfaceC22053ub1, G10.b).b().u()), interfaceC22053ub1, 0);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.rs4$d */
    static final class d implements InterfaceC14603iB2 {
        d() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                C20358rs4.this.wa(interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.rs4$e */
    static final class e implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.rs4$e$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C20358rs4 a;

            a(C20358rs4 c20358rs4) {
                this.a = c20358rs4;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    this.a.pa(interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        e() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-149490925, true, new a(C20358rs4.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.rs4$f */
    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.rs4$g */
    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.rs4$h */
    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.rs4$i */
    public static final class i extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.rs4$j */
    public static final class j extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public C20358rs4() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new g(new f(this)));
        this.viewmodel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(GS.class), new h(interfaceC9173Yu3B), new i(null, interfaceC9173Yu3B), new j(this, interfaceC9173Yu3B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Aa(C20358rs4 c20358rs4, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c20358rs4, "$tmp5_rcvr");
        c20358rs4.wa(interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ba(C20358rs4 c20358rs4, boolean z) {
        AbstractC13042fc3.i(c20358rs4, "this$0");
        c20358rs4.Ea().V0(z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ca(C20358rs4 c20358rs4, boolean z) {
        AbstractC13042fc3.i(c20358rs4, "this$0");
        c20358rs4.Ea().X0(z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ja(C20358rs4 c20358rs4, boolean z) {
        AbstractC13042fc3.i(c20358rs4, "this$0");
        c20358rs4.Ea().U0(z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ka(C20358rs4 c20358rs4, boolean z) {
        AbstractC13042fc3.i(c20358rs4, "this$0");
        c20358rs4.Ea().W0(z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 la(C20358rs4 c20358rs4, boolean z) {
        AbstractC13042fc3.i(c20358rs4, "this$0");
        c20358rs4.Ea().P0(z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ma(C20358rs4 c20358rs4, boolean z) {
        AbstractC13042fc3.i(c20358rs4, "this$0");
        c20358rs4.Ea().S0(z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 na(C20358rs4 c20358rs4, boolean z) {
        AbstractC13042fc3.i(c20358rs4, "this$0");
        c20358rs4.Ea().Y0(z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 oa(C20358rs4 c20358rs4, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c20358rs4, "$tmp5_rcvr");
        c20358rs4.ia(interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 qa(C20358rs4 c20358rs4, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c20358rs4, "$tmp0_rcvr");
        c20358rs4.pa(interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 sa(C20358rs4 c20358rs4, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c20358rs4, "$tmp0_rcvr");
        c20358rs4.ra(interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ta(InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-405273298);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(this) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            List listP = AbstractC10360bX0.p(5, 15, 25, 35, 45);
            int iG1 = Ea().g1();
            interfaceC22053ub1J.W(2013995837);
            boolean zD = interfaceC22053ub1J.D(this);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.js4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C20358rs4.ua(this.a, ((Integer) obj).intValue());
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            defpackage.h.f(listP, iG1, (UA2) objB, interfaceC22053ub1J, 6);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.ks4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C20358rs4.va(this.a, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ua(C20358rs4 c20358rs4, int i2) {
        AbstractC13042fc3.i(c20358rs4, "this$0");
        c20358rs4.Ea().l1(i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 va(C20358rs4 c20358rs4, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c20358rs4, "$tmp1_rcvr");
        c20358rs4.ta(interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 xa(C20358rs4 c20358rs4, boolean z) {
        AbstractC13042fc3.i(c20358rs4, "this$0");
        c20358rs4.Ea().R0(z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ya(C20358rs4 c20358rs4, boolean z) {
        AbstractC13042fc3.i(c20358rs4, "this$0");
        c20358rs4.Ea().T0(z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 za(C20358rs4 c20358rs4, boolean z) {
        AbstractC13042fc3.i(c20358rs4, "this$0");
        c20358rs4.Ea().Z0(z);
        return C19938rB7.a;
    }

    public final GS Ea() {
        return (GS) this.viewmodel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextS7, null, 0, 6, null);
        composeView.setContent(AbstractC19242q11.c(1767888408, true, new e()));
        return composeView;
    }

    public final void ia(InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-565175877);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(this) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            AbstractC18436of3.c(AbstractC12217eE5.internet, interfaceC22053ub1J, 0);
            int i4 = AbstractC12217eE5.media_picture;
            boolean zE1 = Ea().e1();
            interfaceC22053ub1J.W(-1426491060);
            boolean zD = interfaceC22053ub1J.D(this);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.ls4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C20358rs4.ja(this.a, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            C17720nS0 c17720nS0 = new C17720nS0(i4, zE1, false, null, (UA2) objB, 12, null);
            int i5 = C17720nS0.f;
            QX.e(c17720nS0, null, interfaceC22053ub1J, i5, 2);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            int i6 = AbstractC12217eE5.media_video;
            boolean zH1 = Ea().h1();
            interfaceC22053ub1J.W(-1426484598);
            boolean zD2 = interfaceC22053ub1J.D(this);
            Object objB2 = interfaceC22053ub1J.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.ms4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C20358rs4.ka(this.a, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            QX.e(new C17720nS0(i6, zH1, false, null, (UA2) objB2, 12, null), null, interfaceC22053ub1J, i5, 2);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            int i7 = AbstractC12217eE5.media_Document;
            boolean zA1 = Ea().a1();
            interfaceC22053ub1J.W(-1426478135);
            boolean zD3 = interfaceC22053ub1J.D(this);
            Object objB3 = interfaceC22053ub1J.B();
            if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new UA2() { // from class: ir.nasim.ns4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C20358rs4.la(this.a, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            QX.e(new C17720nS0(i7, zA1, false, null, (UA2) objB3, 12, null), null, interfaceC22053ub1J, i5, 2);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            int i8 = AbstractC12217eE5.gif;
            boolean zC1 = Ea().c1();
            interfaceC22053ub1J.W(-1426472088);
            boolean zD4 = interfaceC22053ub1J.D(this);
            Object objB4 = interfaceC22053ub1J.B();
            if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                objB4 = new UA2() { // from class: ir.nasim.os4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C20358rs4.ma(this.a, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1J.s(objB4);
            }
            interfaceC22053ub1J.Q();
            QX.e(new C17720nS0(i8, zC1, false, null, (UA2) objB4, 12, null), null, interfaceC22053ub1J, i5, 2);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            int i9 = AbstractC12217eE5.voice_messages;
            boolean zJ1 = Ea().j1();
            interfaceC22053ub1J.W(-1426465654);
            boolean zD5 = interfaceC22053ub1J.D(this);
            Object objB5 = interfaceC22053ub1J.B();
            if (zD5 || objB5 == InterfaceC22053ub1.a.a()) {
                objB5 = new UA2() { // from class: ir.nasim.ps4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C20358rs4.na(this.a, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1J.s(objB5);
            }
            interfaceC22053ub1J.Q();
            QX.e(new C17720nS0(i9, zJ1, false, null, (UA2) objB5, 12, null), null, interfaceC22053ub1J, i5, 2);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.qs4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C20358rs4.oa(this.a, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void pa(InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-2120685124);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(this) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null);
            G10 g10 = G10.a;
            int i4 = G10.b;
            AbstractC11029cc6.a(androidx.compose.foundation.j.b(androidx.compose.foundation.b.d(eVarF, g10.a(interfaceC22053ub1J, i4).r(), null, 2, null), false, null, 3, null), AbstractC19242q11.e(2048759680, true, new b(), interfaceC22053ub1J, 54), null, null, null, 0, g10.a(interfaceC22053ub1J, i4).r(), 0L, null, AbstractC19242q11.e(1279866635, true, new c(), interfaceC22053ub1J, 54), interfaceC22053ub1J, 805306416, 444);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.is4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C20358rs4.qa(this.a, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void ra(InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(332683803);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(this) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), AbstractC19242q11.e(275803483, true, new d(), interfaceC22053ub1J, 54), interfaceC22053ub1J, C7252Qx5.i | 48);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.bs4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C20358rs4.sa(this.a, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void wa(InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1534463847);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(this) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            AbstractC18436of3.c(AbstractC12217eE5.wifi_title, interfaceC22053ub1J, 0);
            int i4 = AbstractC12217eE5.media_picture;
            boolean zF1 = Ea().f1();
            interfaceC22053ub1J.W(1971862040);
            boolean zD = interfaceC22053ub1J.D(this);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.cs4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C20358rs4.Ba(this.a, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            C17720nS0 c17720nS0 = new C17720nS0(i4, zF1, false, null, (UA2) objB, 12, null);
            int i5 = C17720nS0.f;
            QX.e(c17720nS0, null, interfaceC22053ub1J, i5, 2);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            int i6 = AbstractC12217eE5.media_video;
            boolean zI1 = Ea().i1();
            interfaceC22053ub1J.W(1971868534);
            boolean zD2 = interfaceC22053ub1J.D(this);
            Object objB2 = interfaceC22053ub1J.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.ds4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C20358rs4.Ca(this.a, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            QX.e(new C17720nS0(i6, zI1, false, null, (UA2) objB2, 12, null), null, interfaceC22053ub1J, i5, 2);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            int i7 = AbstractC12217eE5.media_Document;
            boolean zB1 = Ea().b1();
            interfaceC22053ub1J.W(1971874997);
            boolean zD3 = interfaceC22053ub1J.D(this);
            Object objB3 = interfaceC22053ub1J.B();
            if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new UA2() { // from class: ir.nasim.es4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C20358rs4.xa(this.a, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            QX.e(new C17720nS0(i7, zB1, false, null, (UA2) objB3, 12, null), null, interfaceC22053ub1J, i5, 2);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            int i8 = AbstractC12217eE5.gif;
            boolean zD1 = Ea().d1();
            interfaceC22053ub1J.W(1971881076);
            boolean zD4 = interfaceC22053ub1J.D(this);
            Object objB4 = interfaceC22053ub1J.B();
            if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                objB4 = new UA2() { // from class: ir.nasim.fs4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C20358rs4.ya(this.a, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1J.s(objB4);
            }
            interfaceC22053ub1J.Q();
            QX.e(new C17720nS0(i8, zD1, false, null, (UA2) objB4, 12, null), null, interfaceC22053ub1J, i5, 2);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            int i9 = AbstractC12217eE5.voice_messages;
            boolean zK1 = Ea().k1();
            interfaceC22053ub1J.W(1971887510);
            boolean zD5 = interfaceC22053ub1J.D(this);
            Object objB5 = interfaceC22053ub1J.B();
            if (zD5 || objB5 == InterfaceC22053ub1.a.a()) {
                objB5 = new UA2() { // from class: ir.nasim.gs4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C20358rs4.za(this.a, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1J.s(objB5);
            }
            interfaceC22053ub1J.Q();
            QX.e(new C17720nS0(i9, zK1, false, null, (UA2) objB5, 12, null), null, interfaceC22053ub1J, i5, 2);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.hs4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C20358rs4.Aa(this.a, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
