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
import ir.nasim.C8793Xi6;
import ir.nasim.TR;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010-\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,¨\u00064²\u0006\u000e\u0010/\u001a\u0004\u0018\u00010.8\nX\u008a\u0084\u0002²\u0006\f\u00101\u001a\u0002008\nX\u008a\u0084\u0002²\u0006\f\u00103\u001a\u0002028\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/Xi6;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/lj6;", "na", "()Lir/nasim/lj6;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lir/nasim/Sg3;", "h1", "Lir/nasim/Sg3;", "la", "()Lir/nasim/Sg3;", "setJaryanNavigator", "(Lir/nasim/Sg3;)V", "jaryanNavigator", "Lir/nasim/wR;", "i1", "Lir/nasim/wR;", "ja", "()Lir/nasim/wR;", "setAuthenticatorNavigator", "(Lir/nasim/wR;)V", "authenticatorNavigator", "Lir/nasim/wb0;", "j1", "Lir/nasim/wb0;", "ka", "()Lir/nasim/wb0;", "setBaseSettingsNavigator", "(Lir/nasim/wb0;)V", "baseSettingsNavigator", "Lir/nasim/qk6;", "k1", "Lir/nasim/Yu3;", "ma", "()Lir/nasim/qk6;", "viewModel", "Lir/nasim/ZF6;", "snackBarState", "Lir/nasim/kj6;", "mxpState", "", "isSyncContactEnabled", "settings_productionRelease"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Xi6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C8793Xi6 extends HX2 {

    /* renamed from: h1, reason: from kotlin metadata */
    public InterfaceC7565Sg3 jaryanNavigator;

    /* renamed from: i1, reason: from kotlin metadata */
    public InterfaceC23146wR authenticatorNavigator;

    /* renamed from: j1, reason: from kotlin metadata */
    public InterfaceC23238wb0 baseSettingsNavigator;

    /* renamed from: k1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: ir.nasim.Xi6$a */
    static final class a implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.Xi6$a$a, reason: collision with other inner class name */
        static final class C0760a implements InterfaceC14603iB2 {
            final /* synthetic */ C8793Xi6 a;

            C0760a(C8793Xi6 c8793Xi6) {
                this.a = c8793Xi6;
            }

            private static final ZF6 h(InterfaceC9664aL6 interfaceC9664aL6) {
                return (ZF6) interfaceC9664aL6.getValue();
            }

            private static final C16115kj6 i(InterfaceC9664aL6 interfaceC9664aL6) {
                return (C16115kj6) interfaceC9664aL6.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 k(C8793Xi6 c8793Xi6) {
                AbstractC13042fc3.i(c8793Xi6, "this$0");
                c8793Xi6.ma().e1();
                return C19938rB7.a;
            }

            private static final boolean n(InterfaceC9664aL6 interfaceC9664aL6) {
                return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 o(C8793Xi6 c8793Xi6) {
                AbstractC13042fc3.i(c8793Xi6, "this$0");
                c8793Xi6.Q7().onBackPressed();
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 p(C8793Xi6 c8793Xi6) {
                AbstractC13042fc3.i(c8793Xi6, "this$0");
                c8793Xi6.ma().f1();
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 t(C8793Xi6 c8793Xi6) {
                AbstractC13042fc3.i(c8793Xi6, "this$0");
                c8793Xi6.ma().V0();
                return C19938rB7.a;
            }

            public final void f(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(this.a.ma().Y0(), null, null, null, interfaceC22053ub1, 0, 7);
                InterfaceC9664aL6 interfaceC9664aL6C2 = AbstractC5976Lq2.c(this.a.ma().X0(), null, null, null, interfaceC22053ub1, 0, 7);
                InterfaceC9664aL6 interfaceC9664aL6C3 = AbstractC5976Lq2.c(this.a.ma().Z0(), null, null, null, interfaceC22053ub1, 0, 7);
                ZF6 zf6H = h(interfaceC9664aL6C);
                C16115kj6 c16115kj6I = i(interfaceC9664aL6C2);
                boolean zN = n(interfaceC9664aL6C3);
                C16706lj6 c16706lj6Na = this.a.na();
                interfaceC22053ub1.W(-1953999844);
                boolean zD = interfaceC22053ub1.D(this.a);
                final C8793Xi6 c8793Xi6 = this.a;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.Ti6
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C8793Xi6.a.C0760a.o(c8793Xi6);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                SA2 sa2 = (SA2) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-1953995923);
                boolean zD2 = interfaceC22053ub1.D(this.a);
                final C8793Xi6 c8793Xi62 = this.a;
                Object objB2 = interfaceC22053ub1.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.Ui6
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C8793Xi6.a.C0760a.p(c8793Xi62);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                SA2 sa22 = (SA2) objB2;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-1953993525);
                boolean zD3 = interfaceC22053ub1.D(this.a);
                final C8793Xi6 c8793Xi63 = this.a;
                Object objB3 = interfaceC22053ub1.B();
                if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new SA2() { // from class: ir.nasim.Vi6
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C8793Xi6.a.C0760a.t(c8793Xi63);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                SA2 sa23 = (SA2) objB3;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-1953991288);
                boolean zD4 = interfaceC22053ub1.D(this.a);
                final C8793Xi6 c8793Xi64 = this.a;
                Object objB4 = interfaceC22053ub1.B();
                if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                    objB4 = new SA2() { // from class: ir.nasim.Wi6
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C8793Xi6.a.C0760a.k(c8793Xi64);
                        }
                    };
                    interfaceC22053ub1.s(objB4);
                }
                interfaceC22053ub1.Q();
                AbstractC14944ik6.t(zf6H, c16115kj6I, zN, sa2, c16706lj6Na, sa22, sa23, (SA2) objB4, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                f((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(1729638897, true, new C0760a(C8793Xi6.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xi6$b */
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

    /* renamed from: ir.nasim.Xi6$c */
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

    /* renamed from: ir.nasim.Xi6$d */
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

    /* renamed from: ir.nasim.Xi6$e */
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

    /* renamed from: ir.nasim.Xi6$f */
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

    public C8793Xi6() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new c(new b(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C19671qk6.class), new d(interfaceC9173Yu3B), new e(null, interfaceC9173Yu3B), new f(this, interfaceC9173Yu3B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Aa(C8793Xi6 c8793Xi6) {
        AbstractC13042fc3.i(c8793Xi6, "this$0");
        if (C23073wI7.n) {
            C22042ua0.A9(c8793Xi6, C18951pX4.INSTANCE.a(false), false, null, 6, null);
        } else {
            C22042ua0.A9(c8793Xi6, C22019uX4.INSTANCE.a(), false, null, 6, null);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ba(C8793Xi6 c8793Xi6) {
        AbstractC13042fc3.i(c8793Xi6, "this$0");
        C22042ua0.A9(c8793Xi6, new MK1(), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ca(C8793Xi6 c8793Xi6) {
        AbstractC13042fc3.i(c8793Xi6, "this$0");
        C22042ua0.A9(c8793Xi6, new C22112uh0(), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C19671qk6 ma() {
        return (C19671qk6) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C16706lj6 na() {
        return new C16706lj6(new SA2() { // from class: ir.nasim.Ei6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8793Xi6.oa(this.a);
            }
        }, new SA2() { // from class: ir.nasim.Ni6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8793Xi6.va(this.a);
            }
        }, new SA2() { // from class: ir.nasim.Oi6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8793Xi6.wa(this.a);
            }
        }, new SA2() { // from class: ir.nasim.Pi6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8793Xi6.xa(this.a);
            }
        }, new SA2() { // from class: ir.nasim.Qi6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8793Xi6.ya(this.a);
            }
        }, new SA2() { // from class: ir.nasim.Ri6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8793Xi6.za(this.a);
            }
        }, new SA2() { // from class: ir.nasim.Si6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8793Xi6.Aa(this.a);
            }
        }, new SA2() { // from class: ir.nasim.Fi6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8793Xi6.Ba(this.a);
            }
        }, new SA2() { // from class: ir.nasim.Gi6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8793Xi6.Ca(this.a);
            }
        }, new SA2() { // from class: ir.nasim.Hi6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8793Xi6.pa(this.a);
            }
        }, new SA2() { // from class: ir.nasim.Ki6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8793Xi6.qa(this.a);
            }
        }, new UA2() { // from class: ir.nasim.Li6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C8793Xi6.ra(this.a, ((Boolean) obj).booleanValue());
            }
        }, new SA2() { // from class: ir.nasim.Mi6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8793Xi6.sa(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 oa(C8793Xi6 c8793Xi6) {
        AbstractC13042fc3.i(c8793Xi6, "this$0");
        C22042ua0.A9(c8793Xi6, C20215re3.INSTANCE.a(), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 pa(C8793Xi6 c8793Xi6) {
        AbstractC13042fc3.i(c8793Xi6, "this$0");
        C22042ua0.A9(c8793Xi6, C13467gH1.INSTANCE.a(), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 qa(C8793Xi6 c8793Xi6) {
        AbstractC13042fc3.i(c8793Xi6, "this$0");
        c8793Xi6.ma().d1();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ra(C8793Xi6 c8793Xi6, boolean z) {
        AbstractC13042fc3.i(c8793Xi6, "this$0");
        c8793Xi6.ma().i1(z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 sa(final C8793Xi6 c8793Xi6) {
        AbstractC13042fc3.i(c8793Xi6, "this$0");
        c8793Xi6.ma().W0().s(new UA2() { // from class: ir.nasim.Ii6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C8793Xi6.ta(this.a, (Throwable) obj);
            }
        });
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ta(final C8793Xi6 c8793Xi6, Throwable th) {
        AbstractC13042fc3.i(c8793Xi6, "this$0");
        C22042ua0.A9(c8793Xi6, c8793Xi6.ma().c1() ? C16872m05.INSTANCE.a() : InterfaceC23146wR.a(c8793Xi6.ja(), null, new TR.d(AbstractC17026mG5.a.f()), false, false, new SA2() { // from class: ir.nasim.Ji6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8793Xi6.ua(this.a);
            }
        }, 5, null), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ua(C8793Xi6 c8793Xi6) {
        AbstractC13042fc3.i(c8793Xi6, "this$0");
        c8793Xi6.ma().j1(true);
        c8793Xi6.ma().g1(true);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 va(C8793Xi6 c8793Xi6) {
        AbstractC13042fc3.i(c8793Xi6, "this$0");
        C22042ua0.A9(c8793Xi6, C5068Ht3.INSTANCE.a(), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 wa(C8793Xi6 c8793Xi6) {
        AbstractC13042fc3.i(c8793Xi6, "this$0");
        C22042ua0.A9(c8793Xi6, C21197tH0.INSTANCE.a(), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 xa(C8793Xi6 c8793Xi6) {
        AbstractC13042fc3.i(c8793Xi6, "this$0");
        C22042ua0.A9(c8793Xi6, C20421rz0.INSTANCE.a(), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ya(C8793Xi6 c8793Xi6) {
        AbstractC13042fc3.i(c8793Xi6, "this$0");
        C22042ua0.A9(c8793Xi6, c8793Xi6.la().d(), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 za(C8793Xi6 c8793Xi6) {
        AbstractC13042fc3.i(c8793Xi6, "this$0");
        C22042ua0.A9(c8793Xi6, c8793Xi6.ka().c(), false, null, 6, null);
        return C19938rB7.a;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextS7, null, 0, 6, null);
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(-1942209034, true, new a()));
        return composeView;
    }

    public final InterfaceC23146wR ja() {
        InterfaceC23146wR interfaceC23146wR = this.authenticatorNavigator;
        if (interfaceC23146wR != null) {
            return interfaceC23146wR;
        }
        AbstractC13042fc3.y("authenticatorNavigator");
        return null;
    }

    public final InterfaceC23238wb0 ka() {
        InterfaceC23238wb0 interfaceC23238wb0 = this.baseSettingsNavigator;
        if (interfaceC23238wb0 != null) {
            return interfaceC23238wb0;
        }
        AbstractC13042fc3.y("baseSettingsNavigator");
        return null;
    }

    public final InterfaceC7565Sg3 la() {
        InterfaceC7565Sg3 interfaceC7565Sg3 = this.jaryanNavigator;
        if (interfaceC7565Sg3 != null) {
            return interfaceC7565Sg3;
        }
        AbstractC13042fc3.y("jaryanNavigator");
        return null;
    }
}
