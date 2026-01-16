package ir.nasim;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.B42;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015²\u0006\f\u0010\u0014\u001a\u00020\u00138\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/B42;", "Lir/nasim/ua0;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lir/nasim/H42;", "h1", "Lir/nasim/Yu3;", "T9", "()Lir/nasim/H42;", "viewModel", "Lir/nasim/C32;", "state", "settings_productionRelease"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public final class B42 extends CW2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    static final class a implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.B42$a$a, reason: collision with other inner class name */
        static final class C0272a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ B42 c;
            final /* synthetic */ InterfaceC9664aL6 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0272a(B42 b42, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = b42;
                this.d = interfaceC9664aL6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0272a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (a.c(this.d).d()) {
                    this.c.Q7().onBackPressed();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0272a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ B42 a;
            final /* synthetic */ InterfaceC9664aL6 b;

            b(B42 b42, InterfaceC9664aL6 interfaceC9664aL6) {
                this.a = b42;
                this.b = interfaceC9664aL6;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 h(B42 b42) {
                AbstractC13042fc3.i(b42, "this$0");
                b42.Q7().onBackPressed();
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 i(B42 b42, String str) {
                AbstractC13042fc3.i(b42, "this$0");
                AbstractC13042fc3.i(str, "it");
                b42.T9().X0(str);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 k(B42 b42, String str) {
                AbstractC13042fc3.i(b42, "this$0");
                AbstractC13042fc3.i(str, "it");
                b42.T9().c1(str);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 n(B42 b42) {
                AbstractC13042fc3.i(b42, "this$0");
                b42.T9().b1();
                return C19938rB7.a;
            }

            public final void f(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                B32 b32 = B32.c;
                C32 c32C = a.c(this.b);
                interfaceC22053ub1.W(573735894);
                boolean zD = interfaceC22053ub1.D(this.a);
                final B42 b42 = this.a;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.C42
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return B42.a.b.h(b42);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                SA2 sa2 = (SA2) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(573739533);
                boolean zD2 = interfaceC22053ub1.D(this.a);
                final B42 b422 = this.a;
                Object objB2 = interfaceC22053ub1.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.D42
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return B42.a.b.i(b422, (String) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                UA2 ua2 = (UA2) objB2;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(573742893);
                boolean zD3 = interfaceC22053ub1.D(this.a);
                final B42 b423 = this.a;
                Object objB3 = interfaceC22053ub1.B();
                if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new UA2() { // from class: ir.nasim.E42
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return B42.a.b.k(b423, (String) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                UA2 ua22 = (UA2) objB3;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(573746579);
                boolean zD4 = interfaceC22053ub1.D(this.a);
                final B42 b424 = this.a;
                Object objB4 = interfaceC22053ub1.B();
                if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                    objB4 = new SA2() { // from class: ir.nasim.F42
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return B42.a.b.n(b424);
                        }
                    };
                    interfaceC22053ub1.s(objB4);
                }
                interfaceC22053ub1.Q();
                AbstractC22926w32.e(b32, c32C, sa2, ua2, ua22, (SA2) objB4, interfaceC22053ub1, 6);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                f((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C32 c(InterfaceC9664aL6 interfaceC9664aL6) {
            return (C32) interfaceC9664aL6.getValue();
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(B42.this.T9().Z0(), null, null, null, interfaceC22053ub1, 0, 7);
            Boolean boolValueOf = Boolean.valueOf(c(interfaceC9664aL6C).d());
            interfaceC22053ub1.W(-832374686);
            boolean zV = interfaceC22053ub1.V(interfaceC9664aL6C) | interfaceC22053ub1.D(B42.this);
            B42 b42 = B42.this;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new C0272a(b42, interfaceC9664aL6C, null);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(boolValueOf, (InterfaceC14603iB2) objB, interfaceC22053ub1, 0);
            M10.f(false, AbstractC19242q11.e(1179021363, true, new b(B42.this, interfaceC9664aL6C), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    public static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    public static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public B42() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new c(new b(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(H42.class), new d(interfaceC9173Yu3B), new e(null, interfaceC9173Yu3B), new f(this, interfaceC9173Yu3B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final H42 T9() {
        return (H42) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextS7, null, 0, 6, null);
        composeView.setBackgroundColor(AbstractC4043Dl1.c(composeView.getContext(), EA5.background));
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(-220055154, true, new a()));
        return composeView;
    }
}
