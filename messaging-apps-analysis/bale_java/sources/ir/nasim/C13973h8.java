package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC13463gG6;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C13973h8;
import ir.nasim.G8;
import ir.nasim.H8;
import ir.nasim.InterfaceC19114po0;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006&²\u0006\f\u0010%\u001a\u00020$8\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/h8;", "Lir/nasim/ua0;", "<init>", "()V", "", "userId", "Lir/nasim/rB7;", "Y9", "(I)V", "", "phoneNumber", "X9", "(Ljava/lang/String;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lir/nasim/K8;", "h1", "Lir/nasim/Yu3;", "W9", "()Lir/nasim/K8;", "viewModel", "Lir/nasim/TP;", "i1", "Lir/nasim/TP;", "V9", "()Lir/nasim/TP;", "setAuthNavigator", "(Lir/nasim/TP;)V", "authNavigator", "Lir/nasim/I8;", "addContactUiState", "contact_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.h8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C13973h8 extends JV2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: i1, reason: from kotlin metadata */
    public TP authNavigator;

    /* renamed from: ir.nasim.h8$a */
    static final class a implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.h8$a$a, reason: collision with other inner class name */
        static final class C1263a implements InterfaceC14603iB2 {
            final /* synthetic */ C13973h8 a;
            final /* synthetic */ InterfaceC9664aL6 b;

            C1263a(C13973h8 c13973h8, InterfaceC9664aL6 interfaceC9664aL6) {
                this.a = c13973h8;
                this.b = interfaceC9664aL6;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(C13973h8 c13973h8, G8 g8) {
                AbstractC13042fc3.i(c13973h8, "this$0");
                AbstractC13042fc3.i(g8, "uiAction");
                if (g8 instanceof G8.b) {
                    c13973h8.Q7().onBackPressed();
                } else {
                    c13973h8.W9().e1(g8);
                }
                return C19938rB7.a;
            }

            public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) throws Resources.NotFoundException {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                I8 i8C = a.c(this.b);
                interfaceC22053ub1.W(-308403529);
                boolean zD = interfaceC22053ub1.D(this.a);
                final C13973h8 c13973h8 = this.a;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.g8
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C13973h8.a.C1263a.c(c13973h8, (G8) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC18719p8.c(null, null, i8C, (UA2) objB, this.a.V9().d(), interfaceC22053ub1, 0, 3);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
                b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final I8 c(InterfaceC9664aL6 interfaceC9664aL6) {
            return (I8) interfaceC9664aL6.getValue();
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(1451661933, true, new C1263a(C13973h8.this, AbstractC5976Lq2.c(C13973h8.this.W9().W0(), null, null, null, interfaceC22053ub1, 0, 7)), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.h8$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ ComposeView d;

        /* renamed from: ir.nasim.h8$b$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ ComposeView a;
            final /* synthetic */ C13973h8 b;

            /* renamed from: ir.nasim.h8$b$a$a, reason: collision with other inner class name */
            static final class C1264a implements InterfaceC15796kB2 {
                final /* synthetic */ H8 a;
                final /* synthetic */ C13973h8 b;
                final /* synthetic */ ComposeView c;

                /* renamed from: ir.nasim.h8$b$a$a$a, reason: collision with other inner class name */
                static final class C1265a implements InterfaceC14603iB2 {
                    final /* synthetic */ H8 a;
                    final /* synthetic */ ComposeView b;

                    C1265a(H8 h8, ComposeView composeView) {
                        this.a = h8;
                        this.b = composeView;
                    }

                    public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        H8.c cVar = (H8.c) this.a;
                        Resources resources = this.b.getResources();
                        AbstractC13042fc3.h(resources, "getResources(...)");
                        AbstractC19555qZ.e0(AbstractC12152e76.d(cVar.b(resources), interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.h8$b$a$a$b, reason: collision with other inner class name */
                static final class C1266b implements InterfaceC14603iB2 {
                    final /* synthetic */ H8 a;
                    final /* synthetic */ ComposeView b;

                    C1266b(H8 h8, ComposeView composeView) {
                        this.a = h8;
                        this.b = composeView;
                    }

                    public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        H8.a aVar = (H8.a) this.a;
                        Resources resources = this.b.getResources();
                        AbstractC13042fc3.h(resources, "getResources(...)");
                        AbstractC19555qZ.e0(aVar.a(resources), interfaceC22053ub1, 0);
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                C1264a(H8 h8, C13973h8 c13973h8, ComposeView composeView) {
                    this.a = h8;
                    this.b = c13973h8;
                    this.c = composeView;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 f(C13973h8 c13973h8, H8 h8, Dialog dialog) {
                    AbstractC13042fc3.i(c13973h8, "this$0");
                    AbstractC13042fc3.i(h8, "$uiEvent");
                    AbstractC13042fc3.i(dialog, "$it");
                    c13973h8.X9(((H8.c) h8).a());
                    dialog.dismiss();
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 h(Dialog dialog) {
                    AbstractC13042fc3.i(dialog, "$it");
                    dialog.dismiss();
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 i(Dialog dialog) {
                    AbstractC13042fc3.i(dialog, "$it");
                    dialog.dismiss();
                    return C19938rB7.a;
                }

                public final void d(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(dialog, "it");
                    H8 h8 = this.a;
                    if (!(h8 instanceof H8.c)) {
                        if (!(h8 instanceof H8.a)) {
                            interfaceC22053ub1.W(-1242128689);
                            interfaceC22053ub1.Q();
                            return;
                        }
                        interfaceC22053ub1.W(-1243042879);
                        AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
                        AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
                        int i2 = ED5.dialog_negative_button_cancel;
                        InterfaceC19114po0.c.a aVar = InterfaceC19114po0.c.a.a;
                        InterfaceC14603iB2 interfaceC14603iB2B = C23495x11.a.b();
                        InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(429151241, true, new C1266b(this.a, this.c), interfaceC22053ub1, 54);
                        interfaceC22053ub1.W(-1702640447);
                        boolean zD = interfaceC22053ub1.D(dialog);
                        Object objB = interfaceC22053ub1.B();
                        if (zD || objB == InterfaceC22053ub1.a.a()) {
                            objB = new SA2() { // from class: ir.nasim.k8
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return C13973h8.b.a.C1264a.i(dialog);
                                }
                            };
                            interfaceC22053ub1.s(objB);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC19555qZ.S(interfaceC14603iB2B, cVar, interfaceC18060o11E, cVar2, null, aVar, (SA2) objB, i2, interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.c.a.b << 15), 16);
                        interfaceC22053ub1.Q();
                        return;
                    }
                    interfaceC22053ub1.W(-1244631133);
                    AbstractC10289bP1.b.c cVar3 = AbstractC10289bP1.b.c.b;
                    AbstractC10289bP1.a.c cVar4 = AbstractC10289bP1.a.c.a;
                    int i3 = ED5.invite;
                    InterfaceC19114po0.b.a aVar2 = InterfaceC19114po0.b.a.a;
                    int i4 = ED5.dialog_negative_button_cancel;
                    InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
                    InterfaceC14603iB2 interfaceC14603iB2A = C23495x11.a.a();
                    InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(1358966437, true, new C1265a(this.a, this.c), interfaceC22053ub1, 54);
                    interfaceC22053ub1.W(-1702684834);
                    boolean zD2 = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.D(this.a) | interfaceC22053ub1.D(dialog);
                    final C13973h8 c13973h8 = this.b;
                    final H8 h82 = this.a;
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new SA2() { // from class: ir.nasim.i8
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C13973h8.b.a.C1264a.f(c13973h8, h82, dialog);
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    SA2 sa2 = (SA2) objB2;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(-1702671903);
                    boolean zD3 = interfaceC22053ub1.D(dialog);
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                        objB3 = new SA2() { // from class: ir.nasim.j8
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C13973h8.b.a.C1264a.h(dialog);
                            }
                        };
                        interfaceC22053ub1.s(objB3);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC19555qZ.E(interfaceC14603iB2A, cVar3, interfaceC18060o11E2, cVar4, aVar2, sa2, i3, c1454b, (SA2) objB3, i4, null, interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12) | (InterfaceC19114po0.b.C1454b.b << 21), 0, 1024);
                    interfaceC22053ub1.Q();
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    d((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            a(ComposeView composeView, C13973h8 c13973h8) {
                this.a = composeView;
                this.b = c13973h8;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(H8 h8, InterfaceC20295rm1 interfaceC20295rm1) {
                if (h8 instanceof H8.b) {
                    C17468n10 c17468n10 = new C17468n10(this.a, null, 0, 6, null);
                    H8.b bVar = (H8.b) h8;
                    Resources resources = this.a.getResources();
                    AbstractC13042fc3.h(resources, "getResources(...)");
                    C17468n10.p(c17468n10, bVar.a(resources), new AbstractC13463gG6.b(AbstractC15799kB5.shield_done), null, 4, null);
                    this.b.Y9(bVar.b());
                } else {
                    Context contextS7 = this.b.S7();
                    AbstractC13042fc3.h(contextS7, "requireContext(...)");
                    InterfaceC18633oz3 interfaceC18633oz3P6 = this.b.p6();
                    AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
                    AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-358508485, true, new C1264a(h8, this.b, this.a)), 4, null).show();
                }
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ComposeView composeView, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = composeView;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13973h8.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10040ay6 interfaceC10040ay6V0 = C13973h8.this.W9().V0();
                a aVar = new a(this.d, C13973h8.this);
                this.b = 1;
                if (interfaceC10040ay6V0.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.h8$c */
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

    /* renamed from: ir.nasim.h8$d */
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

    /* renamed from: ir.nasim.h8$e */
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

    /* renamed from: ir.nasim.h8$f */
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

    /* renamed from: ir.nasim.h8$g */
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

    public C13973h8() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new d(new c(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(K8.class), new e(interfaceC9173Yu3B), new f(null, interfaceC9173Yu3B), new g(this, interfaceC9173Yu3B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final K8 W9() {
        return (K8) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X9(String phoneNumber) {
        String strH6 = h6(ED5.invite_message);
        AbstractC13042fc3.h(strH6, "getString(...)");
        String strM = AbstractC20153rZ6.M(strH6, "{inviteUrl}", W9().X0(), false, 4, null);
        String strF = C5735Kp4.w().f();
        AbstractC13042fc3.h(strF, "getAppName(...)");
        String strM2 = AbstractC20153rZ6.M(strM, "{appName}", strF, false, 4, null);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:" + phoneNumber));
        intent.putExtra("sms_body", strM2);
        n8(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y9(int userId) {
        C22042ua0.m9(this, this, false, 2, null);
        C11458d25 c11458d25E = C11458d25.E(userId);
        AbstractC13042fc3.h(c11458d25E, "user(...)");
        C18987pb3.x1(C18987pb3.a, c11458d25E, null, null, false, null, null, false, null, null, false, null, 2046, null);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextS7, null, 0, 6, null);
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(1255662514, true, new a()));
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new b(composeView, null), 3, null);
        return composeView;
    }

    public final TP V9() {
        TP tp = this.authNavigator;
        if (tp != null) {
            return tp;
        }
        AbstractC13042fc3.y("authNavigator");
        return null;
    }
}
