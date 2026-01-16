package ir.nasim;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import ir.nasim.AbstractC20417ry5;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C3579Bl5;
import ir.nasim.InterfaceC22053ub1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0003J+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\"²\u0006\f\u0010\u001d\u001a\u00020\u001c8\nX\u008a\u0084\u0002²\u0006\f\u0010\u001f\u001a\u00020\u001e8\nX\u008a\u0084\u0002²\u0006\f\u0010!\u001a\u00020 8\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/Bl5;", "Lir/nasim/ua0;", "<init>", "()V", "Landroid/widget/FrameLayout;", "Lir/nasim/rB7;", "W9", "(Landroid/widget/FrameLayout;)V", "U9", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lir/nasim/n10;", "h1", "Lir/nasim/n10;", "baleSnackBar", "Lir/nasim/Nn5;", "i1", "Lir/nasim/Yu3;", "V9", "()Lir/nasim/Nn5;", "viewModel", "Lir/nasim/fl5;", "state", "Lir/nasim/ry5;", "purchaseState", "Lir/nasim/VT1;", "discountState", "settings_productionRelease"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Bl5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3579Bl5 extends AbstractC24977zX2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private C17468n10 baleSnackBar;

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C6424Nn5.class), new c(this), new d(null, this), new e(this));

    /* renamed from: ir.nasim.Bl5$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Bl5$a$a, reason: collision with other inner class name */
        static final class C0296a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C3579Bl5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0296a(C3579Bl5 c3579Bl5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c3579Bl5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0296a c0296a = new C0296a(this.d, interfaceC20295rm1);
                c0296a.c = obj;
                return c0296a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                AbstractC20417ry5 abstractC20417ry5 = (AbstractC20417ry5) this.c;
                if (abstractC20417ry5 instanceof AbstractC20417ry5.a) {
                    C17468n10 c17468n10 = this.d.baleSnackBar;
                    if (c17468n10 != null) {
                        String strH6 = this.d.h6(QD5.premium_snack_bar_error);
                        AbstractC13042fc3.h(strH6, "getString(...)");
                        c17468n10.o(strH6);
                    }
                    this.d.V9().i1();
                } else if (abstractC20417ry5 instanceof AbstractC20417ry5.d) {
                    AbstractC20417ry5.d dVar = (AbstractC20417ry5.d) abstractC20417ry5;
                    String strA = dVar.a();
                    if (strA == null || strA.length() == 0) {
                        this.d.V9().e1(new C17019mF7(true, false, false));
                    } else {
                        C22055ub3 c22055ub3 = C22055ub3.a;
                        String str = "https://sadad.shaparak.ir/VPG/Purchase?Token=" + dVar.a();
                        FragmentActivity fragmentActivityQ7 = this.d.Q7();
                        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
                        c22055ub3.o(str, fragmentActivityQ7);
                    }
                    this.d.V9().i1();
                    C3579Bl5 c3579Bl5 = this.d;
                    FragmentActivity fragmentActivityQ72 = c3579Bl5.Q7();
                    AbstractC13042fc3.h(fragmentActivityQ72, "requireActivity(...)");
                    c3579Bl5.k9(fragmentActivityQ72);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(AbstractC20417ry5 abstractC20417ry5, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0296a) create(abstractC20417ry5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C3579Bl5.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6A1 = C3579Bl5.this.V9().a1();
                C0296a c0296a = new C0296a(C3579Bl5.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6A1, c0296a, this) == objE) {
                    return objE;
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

    /* renamed from: ir.nasim.Bl5$b */
    static final class b implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.Bl5$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C3579Bl5 a;

            /* renamed from: ir.nasim.Bl5$b$a$a, reason: collision with other inner class name */
            /* synthetic */ class C0297a extends C23553x7 implements InterfaceC14603iB2 {
                C0297a(Object obj) {
                    super(2, obj, C6424Nn5.class, "purchasePackage", "purchasePackage(JLjava/lang/String;)Lkotlinx/coroutines/Job;", 8);
                }

                public final void a(long j, String str) {
                    ((C6424Nn5) this.a).h1(j, str);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    a(((Number) obj).longValue(), (String) obj2);
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.Bl5$b$a$b, reason: collision with other inner class name */
            /* synthetic */ class C0298b extends C23553x7 implements InterfaceC14603iB2 {
                C0298b(Object obj) {
                    super(2, obj, C6424Nn5.class, "calculateDiscountedPrice", "calculateDiscountedPrice(Ljava/lang/String;J)Lkotlinx/coroutines/Job;", 8);
                }

                public final void a(String str, long j) {
                    AbstractC13042fc3.i(str, "p0");
                    ((C6424Nn5) this.a).W0(str, j);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    a((String) obj, ((Number) obj2).longValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.Bl5$b$a$c */
            /* synthetic */ class c extends EB2 implements SA2 {
                c(Object obj) {
                    super(0, obj, C6424Nn5.class, "rollbackDiscountedPrice", "rollbackDiscountedPrice()V", 0);
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    y();
                    return C19938rB7.a;
                }

                public final void y() {
                    ((C6424Nn5) this.receiver).j1();
                }
            }

            a(C3579Bl5 c3579Bl5) {
                this.a = c3579Bl5;
            }

            private static final C13161fl5 f(InterfaceC9664aL6 interfaceC9664aL6) {
                return (C13161fl5) interfaceC9664aL6.getValue();
            }

            private static final AbstractC20417ry5 h(InterfaceC9664aL6 interfaceC9664aL6) {
                return (AbstractC20417ry5) interfaceC9664aL6.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 i(C3579Bl5 c3579Bl5) {
                AbstractC13042fc3.i(c3579Bl5, "this$0");
                AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
                Context contextS7 = c3579Bl5.S7();
                AbstractC13042fc3.h(contextS7, "requireContext(...)");
                aVar.A(contextS7, c3579Bl5.V9().Z0());
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 k(C3579Bl5 c3579Bl5) {
                AbstractC13042fc3.i(c3579Bl5, "this$0");
                C22042ua0.A9(c3579Bl5, new C14345hl5(), false, null, 6, null);
                return C19938rB7.a;
            }

            private static final VT1 n(InterfaceC9664aL6 interfaceC9664aL6) {
                return (VT1) interfaceC9664aL6.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 o(C3579Bl5 c3579Bl5) {
                AbstractC13042fc3.i(c3579Bl5, "this$0");
                c3579Bl5.Q7().z2().l();
                return C19938rB7.a;
            }

            public final void d(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(this.a.V9().b1(), null, null, null, interfaceC22053ub1, 0, 7);
                InterfaceC9664aL6 interfaceC9664aL6C2 = AbstractC5976Lq2.c(this.a.V9().a1(), null, null, null, interfaceC22053ub1, 0, 7);
                InterfaceC9664aL6 interfaceC9664aL6C3 = AbstractC5976Lq2.c(this.a.V9().X0(), null, null, null, interfaceC22053ub1, 0, 7);
                interfaceC22053ub1.W(-578101720);
                C3579Bl5 c3579Bl5 = this.a;
                Object objB = interfaceC22053ub1.B();
                InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
                if (objB == aVar.a()) {
                    objB = AbstractC10222bH6.t(c3579Bl5.V9().Y0());
                    interfaceC22053ub1.s(objB);
                }
                C14063hH6 c14063hH6 = (C14063hH6) objB;
                interfaceC22053ub1.Q();
                C13161fl5 c13161fl5F = f(interfaceC9664aL6C);
                boolean z = h(interfaceC9664aL6C2) instanceof AbstractC20417ry5.c;
                C6424Nn5 c6424Nn5V9 = this.a.V9();
                interfaceC22053ub1.W(-578076920);
                boolean zD = interfaceC22053ub1.D(c6424Nn5V9);
                Object objB2 = interfaceC22053ub1.B();
                if (zD || objB2 == aVar.a()) {
                    objB2 = new C0297a(c6424Nn5V9);
                    interfaceC22053ub1.s(objB2);
                }
                InterfaceC14603iB2 interfaceC14603iB2 = (InterfaceC14603iB2) objB2;
                interfaceC22053ub1.Q();
                C6424Nn5 c6424Nn5V92 = this.a.V9();
                interfaceC22053ub1.W(-578074255);
                boolean zD2 = interfaceC22053ub1.D(c6424Nn5V92);
                Object objB3 = interfaceC22053ub1.B();
                if (zD2 || objB3 == aVar.a()) {
                    objB3 = new C0298b(c6424Nn5V92);
                    interfaceC22053ub1.s(objB3);
                }
                InterfaceC14603iB2 interfaceC14603iB22 = (InterfaceC14603iB2) objB3;
                interfaceC22053ub1.Q();
                C6424Nn5 c6424Nn5V93 = this.a.V9();
                interfaceC22053ub1.W(-578071344);
                boolean zD3 = interfaceC22053ub1.D(c6424Nn5V93);
                Object objB4 = interfaceC22053ub1.B();
                if (zD3 || objB4 == aVar.a()) {
                    objB4 = new c(c6424Nn5V93);
                    interfaceC22053ub1.s(objB4);
                }
                InterfaceC16733lm3 interfaceC16733lm3 = (InterfaceC16733lm3) objB4;
                interfaceC22053ub1.Q();
                VT1 vt1N = n(interfaceC9664aL6C3);
                interfaceC22053ub1.W(-578091477);
                boolean zD4 = interfaceC22053ub1.D(this.a);
                final C3579Bl5 c3579Bl52 = this.a;
                Object objB5 = interfaceC22053ub1.B();
                if (zD4 || objB5 == aVar.a()) {
                    objB5 = new SA2() { // from class: ir.nasim.Cl5
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C3579Bl5.b.a.o(c3579Bl52);
                        }
                    };
                    interfaceC22053ub1.s(objB5);
                }
                SA2 sa2 = (SA2) objB5;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-578087920);
                boolean zD5 = interfaceC22053ub1.D(this.a);
                final C3579Bl5 c3579Bl53 = this.a;
                Object objB6 = interfaceC22053ub1.B();
                if (zD5 || objB6 == aVar.a()) {
                    objB6 = new SA2() { // from class: ir.nasim.Dl5
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C3579Bl5.b.a.i(c3579Bl53);
                        }
                    };
                    interfaceC22053ub1.s(objB6);
                }
                SA2 sa22 = (SA2) objB6;
                interfaceC22053ub1.Q();
                SA2 sa23 = (SA2) interfaceC16733lm3;
                interfaceC22053ub1.W(-578082388);
                boolean zD6 = interfaceC22053ub1.D(this.a);
                final C3579Bl5 c3579Bl54 = this.a;
                Object objB7 = interfaceC22053ub1.B();
                if (zD6 || objB7 == aVar.a()) {
                    objB7 = new SA2() { // from class: ir.nasim.El5
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C3579Bl5.b.a.k(c3579Bl54);
                        }
                    };
                    interfaceC22053ub1.s(objB7);
                }
                interfaceC22053ub1.Q();
                AbstractC12545en5.K(c13161fl5F, sa2, sa22, interfaceC14603iB2, interfaceC14603iB22, sa23, vt1N, (SA2) objB7, c14063hH6, z, interfaceC22053ub1, 100663296);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                d((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-601618874, true, new a(C3579Bl5.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Bl5$c */
    public static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            C14819iX7 c14819iX7D1 = this.e.Q7().d1();
            AbstractC13042fc3.h(c14819iX7D1, "requireActivity().viewModelStore");
            return c14819iX7D1;
        }
    }

    /* renamed from: ir.nasim.Bl5$d */
    public static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ Fragment f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SA2 sa2, Fragment fragment) {
            super(0);
            this.e = sa2;
            this.f = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            AbstractC20375ru1 abstractC20375ru1P3 = this.f.Q7().p3();
            AbstractC13042fc3.h(abstractC20375ru1P3, "requireActivity().defaultViewModelCreationExtras");
            return abstractC20375ru1P3;
        }
    }

    /* renamed from: ir.nasim.Bl5$e */
    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3 = this.e.Q7().n3();
            AbstractC13042fc3.h(cVarN3, "requireActivity().defaultViewModelProviderFactory");
            return cVarN3;
        }
    }

    private final void U9() {
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new a(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C6424Nn5 V9() {
        return (C6424Nn5) this.viewModel.getValue();
    }

    private final void W9(FrameLayout frameLayout) {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextS7, null, 0, 6, null);
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(361889889, true, new b()));
        frameLayout.addView(composeView);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        FrameLayout frameLayout = new FrameLayout(S7());
        V9().c1();
        V9().d1();
        U9();
        this.baleSnackBar = new C17468n10(frameLayout, null, 0, 6, null);
        W9(frameLayout);
        return frameLayout;
    }
}
