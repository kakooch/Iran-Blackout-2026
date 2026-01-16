package ir.nasim;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.compose.ui.e;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import ir.nasim.C17753nV6;
import ir.nasim.InterfaceC10891cN5;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.designsystem.button.BaleButton;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 <2\u00020\u0001:\u0001=B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00192\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010*\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R+\u00103\u001a\u00020+2\u0006\u0010,\u001a\u00020+8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R+\u00107\u001a\u00020+2\u0006\u0010,\u001a\u00020+8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010.\u001a\u0004\b5\u00100\"\u0004\b6\u00102R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lir/nasim/nV6;", "Lcom/google/android/material/bottomsheet/b;", "<init>", "()V", "Lir/nasim/rB7;", "k9", "f9", "()Lir/nasim/rB7;", "j9", "Lir/nasim/tV6;", "storyTag", "h9", "(Lir/nasim/tV6;)V", "d9", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "B8", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lir/nasim/nk0;", "n1", "Lir/nasim/bW7;", "b9", "()Lir/nasim/nk0;", "binding", "Lir/nasim/bX6;", "o1", "Lir/nasim/Yu3;", "c9", "()Lir/nasim/bX6;", "viewModel", "", "<set-?>", "p1", "Lir/nasim/Ym4;", "m9", "()Z", "o9", "(Z)V", "isMainEnabled", "q1", "n9", "p9", "isSpecialEnabled", "Lir/nasim/rV6;", "r1", "Lir/nasim/rV6;", "storyTagEnum", "s1", "a", "story_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.nV6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C17753nV6 extends com.google.android.material.bottomsheet.b {

    /* renamed from: n1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new e(), AbstractC20046rN7.c());

    /* renamed from: o1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.jV6
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C17753nV6.q9(this.a);
        }
    });

    /* renamed from: p1, reason: from kotlin metadata */
    private final InterfaceC9102Ym4 isMainEnabled;

    /* renamed from: q1, reason: from kotlin metadata */
    private final InterfaceC9102Ym4 isSpecialEnabled;

    /* renamed from: r1, reason: from kotlin metadata */
    private EnumC20117rV6 storyTagEnum;
    static final /* synthetic */ InterfaceC5239Im3[] t1 = {AbstractC10882cM5.i(new C25226zw5(C17753nV6.class, "binding", "getBinding()Lir/nasim/story/databinding/BottomSheetStoryTagBinding;", 0))};

    /* renamed from: s1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int u1 = 8;

    /* renamed from: ir.nasim.nV6$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C17753nV6 a(int i, boolean z, boolean z2) {
            C17753nV6 c17753nV6 = new C17753nV6();
            Bundle bundle = new Bundle();
            bundle.putInt("BUNDLE_TAG_ID", i);
            bundle.putBoolean("BUNDLE_TAG_IS_ENABLED", z);
            bundle.putBoolean("BUNDLE_TAG_IS_SPECIAL", z2);
            c17753nV6.a8(bundle);
            return c17753nV6;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.nV6$b */
    static final class b implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.nV6$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C17753nV6 a;

            /* renamed from: ir.nasim.nV6$b$a$a, reason: collision with other inner class name */
            static final class C1411a implements InterfaceC14603iB2 {
                final /* synthetic */ C17753nV6 a;

                C1411a(C17753nV6 c17753nV6) {
                    this.a = c17753nV6;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(C17753nV6 c17753nV6, boolean z) {
                    AbstractC13042fc3.i(c17753nV6, "this$0");
                    c17753nV6.o9(z);
                    if (!z) {
                        c17753nV6.p9(false);
                    }
                    return C19938rB7.a;
                }

                public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    boolean zM9 = this.a.m9();
                    interfaceC22053ub1.W(666648294);
                    boolean zD = interfaceC22053ub1.D(this.a);
                    final C17753nV6 c17753nV6 = this.a;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new UA2() { // from class: ir.nasim.oV6
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C17753nV6.b.a.C1411a.c(c17753nV6, ((Boolean) obj).booleanValue());
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    B10.e(zM9, (UA2) objB, null, false, false, interfaceC22053ub1, 0, 28);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            a(C17753nV6 c17753nV6) {
                this.a = c17753nV6;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                e.a aVar = androidx.compose.ui.e.a;
                androidx.compose.ui.e eVarG = androidx.compose.foundation.layout.t.G(androidx.compose.foundation.layout.t.C(aVar, null, false, 3, null), null, false, 3, null);
                InterfaceC12529em.c cVarI = InterfaceC12529em.a.i();
                C17753nV6 c17753nV6 = this.a;
                InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), cVarI, interfaceC22053ub1, 48);
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
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
                M66 m66 = M66.a;
                ZV1.c(androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.i(aVar, C17784nZ1.q(24)), C17784nZ1.q(8), 0.0f, 2, null), C17784nZ1.q(2), G10.a.a(interfaceC22053ub1, G10.b).A(), interfaceC22053ub1, 54, 0);
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(-964381628, true, new C1411a(c17753nV6), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-1456496864, true, new a(C17753nV6.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.nV6$c */
    static final class c implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.nV6$c$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C17753nV6 a;

            /* renamed from: ir.nasim.nV6$c$a$a, reason: collision with other inner class name */
            static final class C1412a implements InterfaceC14603iB2 {
                final /* synthetic */ C17753nV6 a;

                C1412a(C17753nV6 c17753nV6) {
                    this.a = c17753nV6;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(C17753nV6 c17753nV6, boolean z) {
                    AbstractC13042fc3.i(c17753nV6, "this$0");
                    c17753nV6.p9(z);
                    if (z) {
                        c17753nV6.o9(true);
                    }
                    return C19938rB7.a;
                }

                public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    boolean zN9 = this.a.n9();
                    interfaceC22053ub1.W(-369256933);
                    boolean zD = interfaceC22053ub1.D(this.a);
                    final C17753nV6 c17753nV6 = this.a;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new UA2() { // from class: ir.nasim.pV6
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C17753nV6.c.a.C1412a.c(c17753nV6, ((Boolean) obj).booleanValue());
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    B10.e(zN9, (UA2) objB, null, false, false, interfaceC22053ub1, 0, 28);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            a(C17753nV6 c17753nV6) {
                this.a = c17753nV6;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                e.a aVar = androidx.compose.ui.e.a;
                androidx.compose.ui.e eVarG = androidx.compose.foundation.layout.t.G(androidx.compose.foundation.layout.t.C(aVar, null, false, 3, null), null, false, 3, null);
                InterfaceC12529em.c cVarI = InterfaceC12529em.a.i();
                C17753nV6 c17753nV6 = this.a;
                InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), cVarI, interfaceC22053ub1, 48);
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
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
                M66 m66 = M66.a;
                ZV1.c(androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.i(aVar, C17784nZ1.q(24)), C17784nZ1.q(8), 0.0f, 2, null), C17784nZ1.q(2), G10.a.a(interfaceC22053ub1, G10.b).A(), interfaceC22053ub1, 54, 0);
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(667671871, true, new C1412a(c17753nV6), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        c() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-726347549, true, new a(C17753nV6.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.nV6$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.nV6$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C17753nV6 d;
            final /* synthetic */ InterfaceC20315ro1 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C17753nV6 c17753nV6, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c17753nV6;
                this.e = interfaceC20315ro1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                InterfaceC10891cN5 interfaceC10891cN5 = (InterfaceC10891cN5) this.c;
                if (interfaceC10891cN5 instanceof InterfaceC10891cN5.c) {
                    this.d.h9((C21346tV6) ((InterfaceC10891cN5.c) interfaceC10891cN5).a());
                    AbstractC20906so1.d(this.e, null, 1, null);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC10891cN5 interfaceC10891cN5, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC10891cN5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = C17753nV6.this.new d(interfaceC20295rm1);
            dVar.c = obj;
            return dVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                if (C8386Vt0.vb() && C17753nV6.this.c9().i4().getType() == EnumC10088b35.ExPeerType_PRIVATE) {
                    InterfaceC4557Fq2 interfaceC4557Fq2T6 = C17753nV6.this.c9().t6();
                    a aVar = new a(C17753nV6.this, interfaceC20315ro1, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2T6, aVar, this) == objE) {
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.nV6$e */
    public static final class e extends AbstractC8614Ws3 implements UA2 {
        public e() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C17892nk0.a(fragment.V7());
        }
    }

    public C17753nV6() {
        Boolean bool = Boolean.FALSE;
        this.isMainEnabled = AbstractC13472gH6.d(bool, null, 2, null);
        this.isSpecialEnabled = AbstractC13472gH6.d(bool, null, 2, null);
    }

    private final C17892nk0 b9() {
        Object objA = this.binding.a(this, t1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C17892nk0) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C10366bX6 c9() {
        return (C10366bX6) this.viewModel.getValue();
    }

    private final void d9() {
        BaleButton baleButton = b9().b;
        baleButton.setText(h6(SD5.tag_bottom_sheet_save));
        baleButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.lV6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C17753nV6.e9(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e9(C17753nV6 c17753nV6, View view) {
        AbstractC13042fc3.i(c17753nV6, "this$0");
        Bundle bundle = new Bundle();
        bundle.putBoolean("KEY_IS_ENABLED", c17753nV6.m9());
        bundle.putBoolean("KEY_IS_SPECIAL_ENABLED", c17753nV6.n9());
        EnumC20117rV6 enumC20117rV6 = c17753nV6.storyTagEnum;
        bundle.putInt("KEY_TAG_ID", enumC20117rV6 != null ? enumC20117rV6.s() : -1);
        AbstractC18623oy2.c(c17753nV6, "REQUEST_CODE_TAG_BOTTOM_SHEET", bundle);
        AbstractC16494lN1.a(c17753nV6);
    }

    private final C19938rB7 f9() {
        C17892nk0 c17892nk0B9 = b9();
        c17892nk0B9.r.setContent(AbstractC19242q11.c(-512851931, true, new b()));
        c17892nk0B9.j.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.mV6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C17753nV6.g9(this.a, view);
            }
        });
        EnumC20117rV6 enumC20117rV6 = this.storyTagEnum;
        if (enumC20117rV6 == null) {
            return null;
        }
        c17892nk0B9.p.setImageResource(enumC20117rV6.j());
        c17892nk0B9.q.setImageDrawable(AbstractC4043Dl1.f(S7(), enumC20117rV6.u()));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g9(C17753nV6 c17753nV6, View view) {
        AbstractC13042fc3.i(c17753nV6, "this$0");
        c17753nV6.o9(!c17753nV6.m9());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h9(C21346tV6 storyTag) {
        C17892nk0 c17892nk0B9 = b9();
        c17892nk0B9.s.setContent(AbstractC19242q11.c(-225998146, true, new c()));
        c17892nk0B9.k.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.kV6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C17753nV6.i9(this.a, view);
            }
        });
        EnumC20117rV6 enumC20117rV6 = this.storyTagEnum;
        if (enumC20117rV6 != null) {
            c17892nk0B9.h.setImageResource(enumC20117rV6.j());
            c17892nk0B9.i.setImageResource(enumC20117rV6.u());
        }
        c17892nk0B9.v.setText(i6(SD5.tag_bottom_sheet_checkbox_special_title, storyTag.c()));
        c17892nk0B9.u.setText(i6(SD5.tag_bottom_sheet_checkbox_special_desc, storyTag.c()));
        c17892nk0B9.s.setClickable(false);
        LinearLayout linearLayout = c17892nk0B9.k;
        AbstractC13042fc3.h(linearLayout, "laySpecial");
        linearLayout.setVisibility(0);
        View view = c17892nk0B9.f;
        AbstractC13042fc3.h(view, "divider3");
        view.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i9(C17753nV6 c17753nV6, View view) {
        AbstractC13042fc3.i(c17753nV6, "this$0");
        c17753nV6.p9(!c17753nV6.n9());
    }

    private final void j9() {
        C17892nk0 c17892nk0B9 = b9();
        EnumC20117rV6 enumC20117rV6 = this.storyTagEnum;
        if (enumC20117rV6 == null) {
            return;
        }
        c17892nk0B9.t.setText(h6(enumC20117rV6.w()));
        Bundle bundleE5 = E5();
        o9(bundleE5 != null ? bundleE5.getBoolean("BUNDLE_TAG_IS_ENABLED") : false);
        Bundle bundleE52 = E5();
        p9(bundleE52 != null ? bundleE52.getBoolean("BUNDLE_TAG_IS_SPECIAL") : false);
        c17892nk0B9.g.setImageResource(enumC20117rV6.q());
    }

    private final void k9() {
        f9();
        j9();
        AbstractC19455qN7.g(this, null, new d(null), 1, null);
        d9();
        b9().c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.iV6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C17753nV6.l9(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l9(C17753nV6 c17753nV6, View view) {
        AbstractC13042fc3.i(c17753nV6, "this$0");
        c17753nV6.x8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m9() {
        return ((Boolean) this.isMainEnabled.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n9() {
        return ((Boolean) this.isSpecialEnabled.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o9(boolean z) {
        this.isMainEnabled.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p9(boolean z) {
        this.isSpecialEnabled.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C10366bX6 q9(C17753nV6 c17753nV6) {
        AbstractC13042fc3.i(c17753nV6, "this$0");
        FragmentActivity fragmentActivityQ7 = c17753nV6.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return (C10366bX6) new androidx.lifecycle.G(fragmentActivityQ7).b(C10366bX6.class);
    }

    @Override // com.google.android.material.bottomsheet.b, ir.nasim.ZD, androidx.fragment.app.l
    public Dialog B8(Bundle savedInstanceState) {
        com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(S7(), AbstractC15826kE5.Theme_StoryLinkDialogStyle);
        aVar.o().J0(3);
        return aVar;
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.storyTagEnum = EnumC20117rV6.h.a(bundleE5.getInt("BUNDLE_TAG_ID"));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ConstraintLayout root = C17892nk0.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        k9();
    }
}
