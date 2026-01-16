package ir.nasim;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import ir.nasim.AA3;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC4600Fv0;
import ir.nasim.C16848ly0;
import ir.nasim.C23438wv0;
import ir.nasim.InterfaceC6775Ox6;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000 %2\u00020\u0001:\u0001&B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0003R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lir/nasim/wv0;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "ba", "", "fromJoinButton", "Z9", "(Z)V", "W9", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroidx/compose/ui/platform/ComposeView;", "aa", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroidx/compose/ui/platform/ComposeView;", "Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "c7", "Lir/nasim/Ig2;", "h1", "Lir/nasim/bW7;", "X9", "()Lir/nasim/Ig2;", "binding", "Lir/nasim/aw0;", "i1", "Lir/nasim/Yu3;", "Y9", "()Lir/nasim/aw0;", "viewModel", "j1", "a", "call_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.wv0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C23438wv0 extends UV2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new c(), AbstractC20046rN7.c());

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;
    static final /* synthetic */ InterfaceC5239Im3[] k1 = {AbstractC10882cM5.i(new C25226zw5(C23438wv0.class, "binding", "getBinding()Lir/nasim/call/databinding/FeaturesCallFragmentLinkBinding;", 0))};

    /* renamed from: j1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int l1 = 8;

    /* renamed from: ir.nasim.wv0$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C23438wv0 a() {
            return new C23438wv0();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.wv0$b */
    static final class b implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.wv0$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C23438wv0 a;

            /* renamed from: ir.nasim.wv0$b$a$a, reason: collision with other inner class name */
            /* synthetic */ class C1768a extends EB2 implements SA2 {
                C1768a(Object obj) {
                    super(0, obj, C23438wv0.class, "shareLinkWithOtherApps", "shareLinkWithOtherApps()V", 0);
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    y();
                    return C19938rB7.a;
                }

                public final void y() {
                    ((C23438wv0) this.receiver).ba();
                }
            }

            /* renamed from: ir.nasim.wv0$b$a$b, reason: collision with other inner class name */
            /* synthetic */ class C1769b extends EB2 implements UA2 {
                C1769b(Object obj) {
                    super(1, obj, C23438wv0.class, "joinCall", "joinCall(Z)V", 0);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    y(((Boolean) obj).booleanValue());
                    return C19938rB7.a;
                }

                public final void y(boolean z) {
                    ((C23438wv0) this.receiver).Z9(z);
                }
            }

            /* renamed from: ir.nasim.wv0$b$a$c */
            /* synthetic */ class c extends C23553x7 implements SA2 {
                c(Object obj) {
                    super(0, obj, C10016aw0.class, "generateCallLink", "generateCallLink(ZLjava/lang/String;)Lkotlinx/coroutines/Job;", 8);
                }

                public final void a() {
                    C10016aw0.f1((C10016aw0) this.a, false, null, 3, null);
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.wv0$b$a$d */
            /* synthetic */ class d extends EB2 implements SA2 {
                d(Object obj) {
                    super(0, obj, C23438wv0.class, "copyLinkToClipboard", "copyLinkToClipboard()V", 0);
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    y();
                    return C19938rB7.a;
                }

                public final void y() {
                    ((C23438wv0) this.receiver).W9();
                }
            }

            /* renamed from: ir.nasim.wv0$b$a$e */
            /* synthetic */ class e extends EB2 implements SA2 {
                e(Object obj) {
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

            /* renamed from: ir.nasim.wv0$b$a$f */
            /* synthetic */ class f extends C23553x7 implements UA2 {
                f(Object obj) {
                    super(1, obj, C10016aw0.class, "onLinkTitleValueChanged", "onLinkTitleValueChanged(Ljava/lang/String;)Lkotlinx/coroutines/Job;", 8);
                }

                public final void a(String str) {
                    AbstractC13042fc3.i(str, "p0");
                    ((C10016aw0) this.a).o1(str);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((String) obj);
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.wv0$b$a$g */
            /* synthetic */ class g extends EB2 implements UA2 {
                g(Object obj) {
                    super(1, obj, C10016aw0.class, "onContactsSelected", "onContactsSelected(Ljava/util/List;)V", 0);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    y((List) obj);
                    return C19938rB7.a;
                }

                public final void y(List list) {
                    AbstractC13042fc3.i(list, "p0");
                    ((C10016aw0) this.receiver).m1(list);
                }
            }

            a(C23438wv0 c23438wv0) {
                this.a = c23438wv0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 d(C23438wv0 c23438wv0) {
                AbstractC13042fc3.i(c23438wv0, "this$0");
                c23438wv0.Y9().l1(AA3.a.a);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 f(C23438wv0 c23438wv0) {
                AbstractC13042fc3.i(c23438wv0, "this$0");
                c23438wv0.Y9().l1(AA3.c.a);
                c23438wv0.Y9().t1(new InterfaceC6775Ox6.c(0, 1, null));
                return C19938rB7.a;
            }

            public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                InterfaceC10258bL6 interfaceC10258bL6J1 = this.a.Y9().j1();
                C23438wv0 c23438wv0 = this.a;
                interfaceC22053ub1.W(-563912719);
                boolean zD = interfaceC22053ub1.D(c23438wv0);
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new C1768a(c23438wv0);
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                SA2 sa2 = (SA2) ((InterfaceC16733lm3) objB);
                C23438wv0 c23438wv02 = this.a;
                interfaceC22053ub1.W(-563910621);
                boolean zD2 = interfaceC22053ub1.D(c23438wv02);
                Object objB2 = interfaceC22053ub1.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new C1769b(c23438wv02);
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                UA2 ua2 = (UA2) ((InterfaceC16733lm3) objB2);
                C10016aw0 c10016aw0Y9 = this.a.Y9();
                interfaceC22053ub1.W(-563908748);
                boolean zD3 = interfaceC22053ub1.D(c10016aw0Y9);
                Object objB3 = interfaceC22053ub1.B();
                if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new c(c10016aw0Y9);
                    interfaceC22053ub1.s(objB3);
                }
                SA2 sa22 = (SA2) objB3;
                interfaceC22053ub1.Q();
                C23438wv0 c23438wv03 = this.a;
                interfaceC22053ub1.W(-563906546);
                boolean zD4 = interfaceC22053ub1.D(c23438wv03);
                Object objB4 = interfaceC22053ub1.B();
                if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                    objB4 = new d(c23438wv03);
                    interfaceC22053ub1.s(objB4);
                }
                interfaceC22053ub1.Q();
                SA2 sa23 = (SA2) ((InterfaceC16733lm3) objB4);
                FragmentActivity fragmentActivityQ7 = this.a.Q7();
                interfaceC22053ub1.W(-563904647);
                boolean zD5 = interfaceC22053ub1.D(fragmentActivityQ7);
                Object objB5 = interfaceC22053ub1.B();
                if (zD5 || objB5 == InterfaceC22053ub1.a.a()) {
                    objB5 = new e(fragmentActivityQ7);
                    interfaceC22053ub1.s(objB5);
                }
                interfaceC22053ub1.Q();
                SA2 sa24 = (SA2) ((InterfaceC16733lm3) objB5);
                C10016aw0 c10016aw0Y92 = this.a.Y9();
                interfaceC22053ub1.W(-563902085);
                boolean zD6 = interfaceC22053ub1.D(c10016aw0Y92);
                Object objB6 = interfaceC22053ub1.B();
                if (zD6 || objB6 == InterfaceC22053ub1.a.a()) {
                    objB6 = new f(c10016aw0Y92);
                    interfaceC22053ub1.s(objB6);
                }
                UA2 ua22 = (UA2) objB6;
                interfaceC22053ub1.Q();
                C10016aw0 c10016aw0Y93 = this.a.Y9();
                interfaceC22053ub1.W(-563899626);
                boolean zD7 = interfaceC22053ub1.D(c10016aw0Y93);
                Object objB7 = interfaceC22053ub1.B();
                if (zD7 || objB7 == InterfaceC22053ub1.a.a()) {
                    objB7 = new g(c10016aw0Y93);
                    interfaceC22053ub1.s(objB7);
                }
                interfaceC22053ub1.Q();
                UA2 ua23 = (UA2) ((InterfaceC16733lm3) objB7);
                interfaceC22053ub1.W(-563896488);
                boolean zD8 = interfaceC22053ub1.D(this.a);
                final C23438wv0 c23438wv04 = this.a;
                Object objB8 = interfaceC22053ub1.B();
                if (zD8 || objB8 == InterfaceC22053ub1.a.a()) {
                    objB8 = new SA2() { // from class: ir.nasim.xv0
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C23438wv0.b.a.f(c23438wv04);
                        }
                    };
                    interfaceC22053ub1.s(objB8);
                }
                SA2 sa25 = (SA2) objB8;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-563888896);
                boolean zD9 = interfaceC22053ub1.D(this.a);
                final C23438wv0 c23438wv05 = this.a;
                Object objB9 = interfaceC22053ub1.B();
                if (zD9 || objB9 == InterfaceC22053ub1.a.a()) {
                    objB9 = new SA2() { // from class: ir.nasim.yv0
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C23438wv0.b.a.d(c23438wv05);
                        }
                    };
                    interfaceC22053ub1.s(objB9);
                }
                interfaceC22053ub1.Q();
                String strD = UY6.d(BD5.features_call_link_expiration_toast, new Object[]{XY6.v(this.a.Y9().h1().toString())}, interfaceC22053ub1, 0);
                String strH6 = this.a.h6(BD5.features_call_generation_failed_toast);
                AbstractC13042fc3.h(strH6, "getString(...)");
                String strH62 = this.a.h6(BD5.features_call_link_copied_toast);
                AbstractC13042fc3.h(strH62, "getString(...)");
                AbstractC6985Pv0.c(interfaceC10258bL6J1, sa2, ua2, sa22, sa23, sa24, ua22, ua23, sa25, (SA2) objB9, strD, strH6, strH62, "meet.bale.ai/i/p373-e9ryv-i58m", 30, interfaceC22053ub1, 0, 27648);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(722141677, true, new a(C23438wv0.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.wv0$c */
    public static final class c extends AbstractC8614Ws3 implements UA2 {
        public c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C5184Ig2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.wv0$d */
    public static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.wv0$e */
    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.wv0$f */
    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.wv0$g */
    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.wv0$h */
    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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
            return (hVar == null || (cVarN3 = hVar.n3()) == null) ? this.e.n3() : cVarN3;
        }
    }

    public C23438wv0() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new e(new d(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C10016aw0.class), new f(interfaceC9173Yu3B), new g(null, interfaceC9173Yu3B), new h(this, interfaceC9173Yu3B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W9() {
        Y9().t1(new InterfaceC6775Ox6.a(0, 1, null));
        Object systemService = Q7().getSystemService("clipboard");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Call Link", Y9().i1()));
        Y9().v1();
    }

    private final C5184Ig2 X9() {
        Object objA = this.binding.a(this, k1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C5184Ig2) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C10016aw0 Y9() {
        return (C10016aw0) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z9(boolean fromJoinButton) {
        Y9().p1(fromJoinButton);
        if (!C8386Vt0.a.b5()) {
            Y9().k1();
            C22042ua0.m9(this, this, false, 2, null);
            return;
        }
        Object value = Y9().j1().getValue();
        AbstractC4600Fv0.c cVar = value instanceof AbstractC4600Fv0.c ? (AbstractC4600Fv0.c) value : null;
        if (cVar != null) {
            C16848ly0.Companion companion = C16848ly0.INSTANCE;
            long jF = cVar.f();
            String strA = cVar.a();
            String strG = cVar.g();
            Long lI = cVar.i();
            C22042ua0.w9(this, companion.a((32 & 1) != 0 ? 0L : jF, strA, strG, (32 & 8) != 0 ? 0 : lI != null ? (int) lI.longValue() : 0, (32 & 16) != 0 ? 0L : cVar.h(), (32 & 32) != 0 ? false : false), false, null, 6, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ba() {
        Y9().t1(new InterfaceC6775Ox6.d(0, 1, null));
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", Y9().i1());
        n8(Intent.createChooser(intent, h6(BD5.f1features_call_share_linkchoser_title)));
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: aa, reason: merged with bridge method [inline-methods] */
    public ComposeView Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ComposeView root = C5184Ig2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void c7() {
        Y9().d1();
        super.c7();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        X9().b.setContent(AbstractC19242q11.c(-1816328142, true, new b()));
    }
}
