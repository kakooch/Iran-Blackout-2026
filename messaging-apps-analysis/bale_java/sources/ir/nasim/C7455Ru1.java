package ir.nasim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import ir.nasim.C7455Ru1;
import ir.nasim.components.appbar.view.BaleToolbar;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J!\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lir/nasim/Ru1;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "P9", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lir/nasim/Xx2;", "c1", "Lir/nasim/bW7;", "O9", "()Lir/nasim/Xx2;", "binding", "d1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Ru1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7455Ru1 extends C22042ua0 {

    /* renamed from: c1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new c(), AbstractC20046rN7.c());
    static final /* synthetic */ InterfaceC5239Im3[] e1 = {AbstractC10882cM5.i(new C25226zw5(C7455Ru1.class, "binding", "getBinding()Lir/nasim/databinding/FragmentCrowdFundingIntroBinding;", 0))};

    /* renamed from: d1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int f1 = 8;

    /* renamed from: ir.nasim.Ru1$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C7455Ru1 a() {
            return new C7455Ru1();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Ru1$b */
    static final class b implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.Ru1$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C7455Ru1 a;

            /* renamed from: ir.nasim.Ru1$b$a$a, reason: collision with other inner class name */
            static final class C0603a implements InterfaceC14603iB2 {
                final /* synthetic */ C7455Ru1 a;

                /* renamed from: ir.nasim.Ru1$b$a$a$a, reason: collision with other inner class name */
                static final class C0604a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ C7455Ru1 c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0604a(C7455Ru1 c7455Ru1, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = c7455Ru1;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new C0604a(this.c, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object objE = AbstractC14862ic3.e();
                        int i = this.b;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            this.b = 1;
                            if (HG1.b(1000L, this) == objE) {
                                return objE;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            AbstractC10685c16.b(obj);
                        }
                        C7455Ru1 c7455Ru1 = this.c;
                        c7455Ru1.n9(c7455Ru1, false);
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C0604a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                C0603a(C7455Ru1 c7455Ru1) {
                    this.a = c7455Ru1;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(C7455Ru1 c7455Ru1) {
                    AbstractC13042fc3.i(c7455Ru1, "this$0");
                    C22042ua0.A9(c7455Ru1, C9919am6.INSTANCE.b(EnumC17964nr2.c.ordinal()), false, null, 6, null);
                    try {
                        AbstractC10533bm0.d(AbstractC16751lo1.a(c7455Ru1), null, null, new C0604a(c7455Ru1, null), 3, null);
                    } catch (Exception unused) {
                    }
                    return C19938rB7.a;
                }

                public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    int i2 = KB5.crowdfuning_intro;
                    String strH6 = this.a.h6(AbstractC12217eE5.crowdfunding_title);
                    AbstractC13042fc3.h(strH6, "getString(...)");
                    String strH62 = this.a.h6(AbstractC12217eE5.bank_crowdfunding_intro_description);
                    AbstractC13042fc3.h(strH62, "getString(...)");
                    String strH63 = this.a.h6(AbstractC12217eE5.create_group_button);
                    AbstractC13042fc3.h(strH63, "getString(...)");
                    interfaceC22053ub1.W(-2121235273);
                    boolean zD = interfaceC22053ub1.D(this.a);
                    final C7455Ru1 c7455Ru1 = this.a;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.Su1
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C7455Ru1.b.a.C0603a.c(c7455Ru1);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC13667gd0.c(i2, strH6, strH62, strH63, (SA2) objB, interfaceC22053ub1, 0);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            a(C7455Ru1 c7455Ru1) {
                this.a = c7455Ru1;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    E27.a(androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.d(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), 0.0f, 1, null), WX0.a(IA5.color4, interfaceC22053ub1, 0), null, 2, null), null, 0L, 0L, null, 0.0f, AbstractC19242q11.e(1761299568, true, new C0603a(this.a), interfaceC22053ub1, 54), interfaceC22053ub1, 1572864, 62);
                }
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
                M10.f(false, AbstractC19242q11.e(1469274412, true, new a(C7455Ru1.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ru1$c */
    public static final class c extends AbstractC8614Ws3 implements UA2 {
        public c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C8944Xx2.a(fragment.V7());
        }
    }

    private final void P9() {
        C7183Qq.p().g("should_show_crowdfunding_intro", false);
    }

    public final C8944Xx2 O9() {
        Object objA = this.binding.a(this, e1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C8944Xx2) objA;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        return inflater.inflate(AbstractC12208eD5.fragment_crowd_funding_intro, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        P9();
        BaleToolbar baleToolbar = O9().c;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
        O9().b.setContent(AbstractC19242q11.c(-568029241, true, new b()));
    }
}
