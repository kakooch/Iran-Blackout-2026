package ir.nasim;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C18189oE4;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 ²\u0006\f\u0010\u001f\u001a\u00020\u001e8\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/oE4;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "ua", "ga", "ta", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lir/nasim/vE4;", "h1", "Lir/nasim/Yu3;", "fa", "()Lir/nasim/vE4;", "viewModel", "Lir/nasim/v6;", "Landroid/content/Intent;", "i1", "Lir/nasim/v6;", "soundPickerLauncher", "Lir/nasim/uE4;", "uiState", "settings_productionRelease"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.oE4, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C18189oE4 extends AbstractC16585lX2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: i1, reason: from kotlin metadata */
    private AbstractC22357v6 soundPickerLauncher;

    /* renamed from: ir.nasim.oE4$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ C16183kq4 b;

        /* renamed from: ir.nasim.oE4$a$a, reason: collision with other inner class name */
        static final class C1421a implements InterfaceC14603iB2 {
            final /* synthetic */ C16183kq4 a;
            final /* synthetic */ C18189oE4 b;
            final /* synthetic */ InterfaceC9664aL6 c;

            C1421a(C16183kq4 c16183kq4, C18189oE4 c18189oE4, InterfaceC9664aL6 interfaceC9664aL6) {
                this.a = c16183kq4;
                this.b = c18189oE4;
                this.c = interfaceC9664aL6;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(C18189oE4 c18189oE4) {
                AbstractC13042fc3.i(c18189oE4, "this$0");
                c18189oE4.Q7().onBackPressed();
                return C19938rB7.a;
            }

            public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                C21848uE4 c21848uE4C = a.c(this.c);
                C16183kq4 c16183kq4 = this.a;
                interfaceC22053ub1.W(328115168);
                boolean zD = interfaceC22053ub1.D(this.b);
                final C18189oE4 c18189oE4 = this.b;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.nE4
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C18189oE4.a.C1421a.c(c18189oE4);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC21174tE4.g(c21848uE4C, c16183kq4, (SA2) objB, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(C16183kq4 c16183kq4) {
            this.b = c16183kq4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C21848uE4 c(InterfaceC9664aL6 interfaceC9664aL6) {
            return (C21848uE4) interfaceC9664aL6.getValue();
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(653319484, true, new C1421a(this.b, C18189oE4.this, AbstractC5976Lq2.c(C18189oE4.this.fa().X0(), null, null, null, interfaceC22053ub1, 0, 7)), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.oE4$b */
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

    /* renamed from: ir.nasim.oE4$c */
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

    /* renamed from: ir.nasim.oE4$d */
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

    /* renamed from: ir.nasim.oE4$e */
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

    /* renamed from: ir.nasim.oE4$f */
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

    public C18189oE4() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new c(new b(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C22438vE4.class), new d(interfaceC9173Yu3B), new e(null, interfaceC9173Yu3B), new f(this, interfaceC9173Yu3B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C22438vE4 fa() {
        return (C22438vE4) this.viewModel.getValue();
    }

    private final void ga() {
        Object systemService = S7().getSystemService("notification");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (Build.VERSION.SDK_INT < 34 || notificationManager.canUseFullScreenIntent()) {
            ta();
            return;
        }
        C24398yZ c24398yZ = C24398yZ.a;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        c24398yZ.i(contextS7, interfaceC18633oz3P6, new SA2() { // from class: ir.nasim.cE4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C18189oE4.ha(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ha(C18189oE4 c18189oE4) {
        AbstractC13042fc3.i(c18189oE4, "this$0");
        c18189oE4.ta();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(final C18189oE4 c18189oE4, ActivityResult activityResult) {
        AbstractC13042fc3.i(c18189oE4, "this$0");
        AbstractC13042fc3.i(activityResult, "result");
        IH6.a.b(activityResult.getResultCode(), activityResult.getData(), new UA2() { // from class: ir.nasim.dE4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C18189oE4.ja(this.a, (Uri) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ja(C18189oE4 c18189oE4, Uri uri) {
        AbstractC13042fc3.i(c18189oE4, "this$0");
        c18189oE4.fa().i1(uri);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ka(C18189oE4 c18189oE4, boolean z) {
        AbstractC13042fc3.i(c18189oE4, "this$0");
        c18189oE4.fa().b1(z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 la(C18189oE4 c18189oE4) {
        AbstractC13042fc3.i(c18189oE4, "this$0");
        c18189oE4.ga();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ma(C18189oE4 c18189oE4, boolean z) {
        AbstractC13042fc3.i(c18189oE4, "this$0");
        c18189oE4.fa().h1(z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 na(C18189oE4 c18189oE4, boolean z) {
        AbstractC13042fc3.i(c18189oE4, "this$0");
        c18189oE4.fa().e1(z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 oa(C18189oE4 c18189oE4, boolean z) {
        AbstractC13042fc3.i(c18189oE4, "this$0");
        c18189oE4.fa().f1(z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 pa(C18189oE4 c18189oE4, boolean z) {
        AbstractC13042fc3.i(c18189oE4, "this$0");
        c18189oE4.fa().g1(z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 qa(C18189oE4 c18189oE4) {
        AbstractC13042fc3.i(c18189oE4, "this$0");
        c18189oE4.ua();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ra(C18189oE4 c18189oE4, boolean z) {
        AbstractC13042fc3.i(c18189oE4, "this$0");
        c18189oE4.fa().d1(z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 sa(C18189oE4 c18189oE4, boolean z) {
        AbstractC13042fc3.i(c18189oE4, "this$0");
        c18189oE4.fa().c1(z);
        return C19938rB7.a;
    }

    private final void ta() {
        n8(new Intent("android.settings.MANAGE_APP_USE_FULL_SCREEN_INTENT", Uri.parse("package:" + Q7().getPackageName())).addFlags(268435456));
    }

    private final void ua() {
        AbstractC22357v6 abstractC22357v6 = this.soundPickerLauncher;
        if (abstractC22357v6 == null) {
            AbstractC13042fc3.y("soundPickerLauncher");
            abstractC22357v6 = null;
        }
        IH6 ih6 = IH6.a;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        abstractC22357v6.a(ih6.a(contextS7));
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        this.soundPickerLauncher = N7(new C20490s6(), new InterfaceC17517n6() { // from class: ir.nasim.mE4
            @Override // ir.nasim.InterfaceC17517n6
            public final void a(Object obj) {
                C18189oE4.ia(this.a, (ActivityResult) obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextS7, null, 0, 6, null);
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(1383283969, true, new a(new C16183kq4(new UA2() { // from class: ir.nasim.bE4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C18189oE4.ma(this.a, ((Boolean) obj).booleanValue());
            }
        }, new UA2() { // from class: ir.nasim.eE4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C18189oE4.na(this.a, ((Boolean) obj).booleanValue());
            }
        }, new UA2() { // from class: ir.nasim.fE4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C18189oE4.oa(this.a, ((Boolean) obj).booleanValue());
            }
        }, new UA2() { // from class: ir.nasim.gE4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C18189oE4.pa(this.a, ((Boolean) obj).booleanValue());
            }
        }, new SA2() { // from class: ir.nasim.hE4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C18189oE4.qa(this.a);
            }
        }, new UA2() { // from class: ir.nasim.iE4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C18189oE4.ra(this.a, ((Boolean) obj).booleanValue());
            }
        }, new UA2() { // from class: ir.nasim.jE4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C18189oE4.sa(this.a, ((Boolean) obj).booleanValue());
            }
        }, new UA2() { // from class: ir.nasim.kE4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C18189oE4.ka(this.a, ((Boolean) obj).booleanValue());
            }
        }, new SA2() { // from class: ir.nasim.lE4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C18189oE4.la(this.a);
            }
        }))));
        return composeView;
    }
}
