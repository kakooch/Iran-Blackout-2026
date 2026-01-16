package ir.nasim;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.gov.nist.core.Separators;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C12950fS3;
import ir.nasim.C15375jU1;
import ir.nasim.core.modules.market.model.MarketDialog;
import ir.nasim.core.modules.market.model.MarketItem;
import ir.nasim.core.modules.market.model.MarketItemMore;
import ir.nasim.core.modules.market.model.MarketPost;
import ir.nasim.core.modules.market.model.MarketProductItem;
import ir.nasim.core.modules.market.model.MarketSection;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.jaryan.discover.model.PeerItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: ir.nasim.jU1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C15375jU1 extends AbstractC24374yW2 implements InterfaceC13568gS3, InterfaceC14159hS3, InterfaceC14770iS3, C12950fS3.b, InterfaceC24154y80, InterfaceC15426jZ7 {
    public static final a t1 = new a(null);
    public static final int u1 = 8;
    private final InterfaceC8506Wg3 h1;
    private final int i1;
    private final int j1;
    private final int k1;
    private final String l1;
    private final String m1;
    private final String n1;
    private C12059dy2 o1;
    private final InterfaceC9173Yu3 p1;
    private final WT1 q1;
    public InterfaceC24908zP5 r1;
    private boolean s1;

    /* renamed from: ir.nasim.jU1$a */
    public static final class a {
        private a() {
        }

        public final C15375jU1 a(InterfaceC8506Wg3 interfaceC8506Wg3) {
            AbstractC13042fc3.i(interfaceC8506Wg3, "jaryanScrollListener");
            return new C15375jU1(interfaceC8506Wg3);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.jU1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.jU1$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C15375jU1 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C15375jU1 c15375jU1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c15375jU1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
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
                C18330oU1 c18330oU1 = (C18330oU1) this.c;
                LinearLayout linearLayout = this.d.na().e;
                AbstractC13042fc3.h(linearLayout, "progressLayout");
                linearLayout.setVisibility(c18330oU1.c() ^ true ? 0 : 8);
                if (c18330oU1.c()) {
                    this.d.q1.z(c18330oU1.b());
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C18330oU1 c18330oU1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c18330oU1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15375jU1.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6B1 = C15375jU1.this.oa().b1();
                a aVar = new a(C15375jU1.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6B1, aVar, this) == objE) {
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
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.jU1$c */
    public static final class c extends RecyclerView.t {
        private boolean b;
        private boolean a = true;
        private boolean c = true;

        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i) {
            AbstractC13042fc3.i(recyclerView, "recyclerView");
            super.a(recyclerView, i);
            if (i == 0) {
                this.a = true;
                C15375jU1.this.h1.I1();
            }
            if (i == 0 && this.b) {
                this.b = false;
                C15375jU1.this.h1.o2();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            AbstractC13042fc3.i(recyclerView, "recyclerView");
            super.b(recyclerView, i, i2);
            C15375jU1.this.h1.C1(recyclerView.computeVerticalScrollOffset(), this.c);
            boolean z = Math.abs((double) i2) > ((double) 18.0f);
            if (i2 < 0 && z && this.a) {
                this.a = false;
                this.b = true;
                this.c = false;
                C15375jU1.this.h1.C2(true);
            }
            if (i2 > 0) {
                C15375jU1.this.h1.C2(false);
            }
        }
    }

    /* renamed from: ir.nasim.jU1$d */
    static final class d implements InterfaceC15796kB2 {
        final /* synthetic */ MarketSection a;

        /* renamed from: ir.nasim.jU1$d$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ MarketSection a;

            a(MarketSection marketSection) {
                this.a = marketSection;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                MarketDialog dialog = this.a.getDialog();
                String title = dialog != null ? dialog.getTitle() : null;
                if (title == null) {
                    title = "";
                }
                AbstractC19555qZ.v0(title, null, FV4.c(this.a.getDialogDrawableIdResource(), interfaceC22053ub1, 0), null, C24381yX0.b.i(), interfaceC22053ub1, 27648, 2);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.jU1$d$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ MarketSection a;

            b(MarketSection marketSection) {
                this.a = marketSection;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                MarketDialog dialog = this.a.getDialog();
                String description = dialog != null ? dialog.getDescription() : null;
                if (description == null) {
                    description = "";
                }
                AbstractC19555qZ.e0(description, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        d(MarketSection marketSection) {
            this.a = marketSection;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void b(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-1683782484, true, new a(this.a), interfaceC22053ub1, 54);
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(-1740647830, true, new b(this.a), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            interfaceC22053ub1.W(-443461129);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.kU1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C15375jU1.d.c(dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.S(interfaceC18060o11E, c0905b, interfaceC18060o11E2, cVar, null, null, (SA2) objB, AbstractC12217eE5.card_payment_i_confirm, interfaceC22053ub1, (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9), 48);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.jU1$e */
    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.jU1$f */
    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.jU1$g */
    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.jU1$h */
    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.jU1$i */
    public static final class i extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public C15375jU1(InterfaceC8506Wg3 interfaceC8506Wg3) {
        AbstractC13042fc3.i(interfaceC8506Wg3, "jaryanScrollListener");
        this.h1 = interfaceC8506Wg3;
        this.i1 = 1;
        this.j1 = 2;
        this.k1 = 3;
        this.l1 = "banner";
        this.m1 = "market";
        this.n1 = "vitrin";
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new f(new e(this)));
        this.p1 = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C19512qU1.class), new g(interfaceC9173Yu3B), new h(null, interfaceC9173Yu3B), new i(this, interfaceC9173Yu3B));
        this.q1 = new WT1(this, this, this, this, this, this, new UA2() { // from class: ir.nasim.iU1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C15375jU1.ja(this.a, obj);
            }
        }, new UA2() { // from class: ir.nasim.YT1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C15375jU1.ka(this.a, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(C15375jU1 c15375jU1) {
        AbstractC13042fc3.i(c15375jU1, "this$0");
        c15375jU1.s1 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ba(final C15375jU1 c15375jU1, String str, ProgressDialog progressDialog, Exception exc) {
        AbstractC13042fc3.i(c15375jU1, "this$0");
        AbstractC13042fc3.i(str, "$nick");
        AbstractC13042fc3.i(progressDialog, "$progressDialog");
        C5735Kp4.w().J(c15375jU1.S7(), str, "discover");
        C19406qI3.d("NON_FATAL_EXCEPTION", exc);
        C8920Xu5.c();
        progressDialog.dismiss();
        AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.hU1
            @Override // java.lang.Runnable
            public final void run() {
                C15375jU1.Ca(this.a);
            }
        }, 700L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(C15375jU1 c15375jU1) {
        AbstractC13042fc3.i(c15375jU1, "this$0");
        c15375jU1.s1 = false;
    }

    private final void Da() {
        na().c.addOnScrollListener(new c());
    }

    private final void Ea(MarketSection marketSection) {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-1001268709, true, new d(marketSection)), 4, null).show();
    }

    private final void ia() {
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new b(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ja(C15375jU1 c15375jU1, Object obj) {
        AbstractC13042fc3.i(c15375jU1, "this$0");
        AbstractC13042fc3.i(obj, "item");
        c15375jU1.oa().o1(obj);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ka(C15375jU1 c15375jU1, Object obj) {
        AbstractC13042fc3.i(c15375jU1, "this$0");
        AbstractC13042fc3.i(obj, "item");
        c15375jU1.oa().h1(obj);
        return C19938rB7.a;
    }

    private final void la(int i2) {
        long j = i2;
        C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(j);
        final C14733iO2 c14733iO2 = (C14733iO2) AbstractC5969Lp4.b().n(j);
        if (c21231tK7 != null) {
            if (c21231tK7.y()) {
                C11335cq c11335cqD = AbstractC5969Lp4.d();
                W25 w25 = W25.a;
                c11335cqD.D1(new C11458d25(w25, i2), "/start", null);
                C18987pb3.x1(C18987pb3.a, new C11458d25(w25, i2), null, null, false, null, null, false, null, null, false, null, 2046, null);
                return;
            }
            return;
        }
        if (c14733iO2 != null) {
            if (((Boolean) c14733iO2.F().b()).booleanValue()) {
                C18987pb3.a.y1(new C11458d25(W25.b, i2), null, null, false, "discover");
                return;
            }
            C3343Am.i("Group_join_source", AbstractC20051rO3.p(AbstractC4616Fw7.a("user_id", Integer.valueOf(AbstractC5969Lp4.f())), AbstractC4616Fw7.a("date", Long.valueOf(System.currentTimeMillis())), AbstractC4616Fw7.a("peer_id", Integer.valueOf(C11458d25.y(i2).getPeerId())), AbstractC4616Fw7.a("peer_type", Integer.valueOf(W25.b.ordinal() + 1)), AbstractC4616Fw7.a("event_type", "vitrin")));
            C19406qI3.a("Source_Join_Cause", "discover doJoinClick()", new Object[0]);
            C6517Nv5 c6517Nv5E = AbstractC5969Lp4.d().C0(C11458d25.y(i2)).E(new InterfaceC24449ye1() { // from class: ir.nasim.bU1
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C15375jU1.ma(c14733iO2, this, (Exception) obj);
                }
            });
            AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
            S8(c6517Nv5E);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(C14733iO2 c14733iO2, C15375jU1 c15375jU1, Exception exc) {
        AbstractC13042fc3.i(c15375jU1, "this$0");
        ZN2 zn2Q = c14733iO2.q();
        AbstractC13042fc3.h(zn2Q, "getGroupType(...)");
        Toast.makeText(c15375jU1.S7(), UN2.a(exc, zn2Q), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C12059dy2 na() {
        C12059dy2 c12059dy2 = this.o1;
        AbstractC13042fc3.f(c12059dy2);
        return c12059dy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C19512qU1 oa() {
        return (C19512qU1) this.p1.getValue();
    }

    private final void ra() {
        na().c.setAdapter(this.q1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(C15375jU1 c15375jU1, String str, Bundle bundle) {
        AbstractC13042fc3.i(c15375jU1, "this$0");
        AbstractC13042fc3.i(str, "<unused var>");
        AbstractC13042fc3.i(bundle, "bundle");
        String string = bundle.getString("discover_option");
        if (string != null) {
            int iHashCode = string.hashCode();
            if (iHashCode == 819178405) {
                if (string.equals("store_channel")) {
                    c15375jU1.oa().f1(EnumC17739nU1.b);
                }
            } else if (iHashCode == 1177879627) {
                if (string.equals("discover_all")) {
                    c15375jU1.oa().f1(EnumC17739nU1.a);
                }
            } else if (iHashCode == 1495825181 && string.equals("CONTENT_channel")) {
                c15375jU1.oa().f1(EnumC17739nU1.c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(Object obj, final C15375jU1 c15375jU1, String str, Bundle bundle) {
        final OP5 op5;
        Integer groupId;
        MarketPost marketPost;
        Integer groupId2;
        AbstractC13042fc3.i(obj, "$item");
        AbstractC13042fc3.i(c15375jU1, "this$0");
        AbstractC13042fc3.i(str, "<unused var>");
        AbstractC13042fc3.i(bundle, "bundle");
        if (Build.VERSION.SDK_INT >= 33) {
            op5 = (OP5) bundle.getSerializable("report_type_result_key", OP5.class);
        } else {
            Serializable serializable = bundle.getSerializable("report_type_result_key");
            op5 = serializable instanceof OP5 ? (OP5) serializable : null;
        }
        if (op5 == null) {
            return;
        }
        final int iIntValue = 0;
        int i2 = bundle.getInt("market_report_title_result_key", 0);
        if (obj instanceof MarketItem) {
            ArrayList<MarketPost> posts = ((MarketItem) obj).getPosts();
            if (posts != null && (marketPost = (MarketPost) AbstractC15401jX0.s0(posts)) != null && (groupId2 = marketPost.getGroupId()) != null) {
                iIntValue = groupId2.intValue();
            }
        } else if ((obj instanceof MarketProductItem) && (groupId = ((MarketProductItem) obj).getPost().getGroupId()) != null) {
            iIntValue = groupId.intValue();
        }
        Context contextS7 = c15375jU1.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = c15375jU1.p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        C24398yZ.k(contextS7, interfaceC18633oz3P6, i2, false, null, new UA2() { // from class: ir.nasim.gU1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj2) {
                return C15375jU1.ua(this.a, iIntValue, op5, (String) obj2);
            }
        }, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ua(C15375jU1 c15375jU1, int i2, OP5 op5, String str) {
        AbstractC13042fc3.i(c15375jU1, "this$0");
        AbstractC13042fc3.i(op5, "$selectedReportType");
        AbstractC13042fc3.i(str, "reportDescription");
        c15375jU1.oa().m1(str, i2, op5);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(final C15375jU1 c15375jU1, final PeerItem peerItem, String str, Bundle bundle) {
        final OP5 op5;
        AbstractC13042fc3.i(c15375jU1, "this$0");
        AbstractC13042fc3.i(peerItem, "$peerItem");
        AbstractC13042fc3.i(str, "<unused var>");
        AbstractC13042fc3.i(bundle, "bundle");
        if (Build.VERSION.SDK_INT >= 33) {
            op5 = (OP5) bundle.getSerializable("report_type_result_key", OP5.class);
        } else {
            Serializable serializable = bundle.getSerializable("report_type_result_key");
            op5 = serializable instanceof OP5 ? (OP5) serializable : null;
        }
        if (op5 == null) {
            return;
        }
        int i2 = bundle.getInt("market_report_title_result_key", 0);
        Context contextS7 = c15375jU1.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = c15375jU1.p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        C24398yZ.k(contextS7, interfaceC18633oz3P6, i2, false, null, new UA2() { // from class: ir.nasim.aU1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C15375jU1.wa(this.a, peerItem, op5, (String) obj);
            }
        }, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 wa(C15375jU1 c15375jU1, PeerItem peerItem, OP5 op5, String str) {
        AbstractC13042fc3.i(c15375jU1, "this$0");
        AbstractC13042fc3.i(peerItem, "$peerItem");
        AbstractC13042fc3.i(op5, "$selectedReportType");
        AbstractC13042fc3.i(str, "reportDescription");
        c15375jU1.oa().m1(str, peerItem.getExPeer().getPeerId(), op5);
        return C19938rB7.a;
    }

    private final void xa(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        C18987pb3 c18987pb3 = C18987pb3.a;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        c18987pb3.k0(intent, fragmentActivityQ7);
    }

    private final void ya(long j, final String str) {
        if (this.s1) {
            return;
        }
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        if (C4100Dr4.a(contextS7)) {
            this.s1 = true;
            Context contextS72 = S7();
            AbstractC13042fc3.h(contextS72, "requireContext(...)");
            final ProgressDialog progressDialogE = C8920Xu5.e(contextS72, true);
            progressDialogE.setCancelable(false);
            AbstractC5969Lp4.b().k(j).m0(new InterfaceC24449ye1() { // from class: ir.nasim.cU1
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C15375jU1.za(this.a, str, progressDialogE, (C14733iO2) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.dU1
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C15375jU1.Ba(this.a, str, progressDialogE, (Exception) obj);
                }
            });
            return;
        }
        FrameLayout root = na().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(root, null, 0, 6, null);
        c17468n10.k(na().g);
        String strH6 = h6(AbstractC12217eE5.card_payment_please_check_your_internet_conenction);
        AbstractC13042fc3.h(strH6, "getString(...)");
        c17468n10.o(strH6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(final C15375jU1 c15375jU1, String str, ProgressDialog progressDialog, C14733iO2 c14733iO2) {
        AbstractC13042fc3.i(c15375jU1, "this$0");
        AbstractC13042fc3.i(str, "$nick");
        AbstractC13042fc3.i(progressDialog, "$progressDialog");
        if (c14733iO2 != null) {
            C11458d25 c11458d25 = new C11458d25(W25.b, c14733iO2.r());
            C5735Kp4.w().o(c11458d25);
            C18987pb3.a.y1(c11458d25, null, null, false, "discover");
        } else {
            C5735Kp4.w().J(c15375jU1.S7(), str, "discover");
        }
        C8920Xu5.c();
        progressDialog.dismiss();
        AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.fU1
            @Override // java.lang.Runnable
            public final void run() {
                C15375jU1.Aa(this.a);
            }
        }, 700L);
    }

    @Override // ir.nasim.InterfaceC14159hS3
    public void C(MarketItem marketItem, MarketSection marketSection) {
        AbstractC13042fc3.i(marketItem, "item");
        AbstractC13042fc3.i(marketSection, "row");
        ya(marketItem.getId(), marketItem.getUrl());
        HashMap map = new HashMap();
        map.put("title", marketSection.getTitle());
        map.put("peer_id", Long.valueOf(marketItem.getId()));
        String lowerCase = "CHANNEL".toLowerCase(Locale.ROOT);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        map.put("peer_type", lowerCase);
        map.put("action_type", Integer.valueOf(this.j1));
        map.put("event_type", this.m1);
        map.put("url", marketItem.getUrl());
        map.put("block_id", Integer.valueOf(marketSection.getId()));
        C3343Am.i("flow_discover", map);
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle bundle) {
        super.M6(bundle);
        V5().H1("request_key_discover_data_changed", this, new InterfaceC13295fz2() { // from class: ir.nasim.ZT1
            @Override // ir.nasim.InterfaceC13295fz2
            public final void a(String str, Bundle bundle2) {
                C15375jU1.sa(this.a, str, bundle2);
            }
        });
    }

    @Override // ir.nasim.InterfaceC15426jZ7
    public void O4(String str, String str2, int i2) {
        AbstractC13042fc3.i(str, "url");
        AbstractC13042fc3.i(str2, "rowTitle");
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        Uri uri = Uri.parse(str);
        AbstractC13042fc3.h(uri, "parse(...)");
        aVar.A(contextS7, uri);
        HashMap map = new HashMap();
        map.put("title", str2);
        map.put("action_type", Integer.valueOf(this.j1));
        map.put("event_type", this.n1);
        map.put("url", str);
        map.put("block_id", Integer.valueOf(i2));
        C3343Am.i("flow_discover", map);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AbstractC13042fc3.i(layoutInflater, "inflater");
        this.o1 = C12059dy2.c(layoutInflater, viewGroup, false);
        FrameLayout root = na().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.InterfaceC15426jZ7
    public void T3(final PeerItem peerItem) {
        AbstractC13042fc3.i(peerItem, "peerItem");
        if (C8386Vt0.a.U3()) {
            F5().z("vitrine_report_result_key");
            F5().H1("vitrine_report_result_key", this, new InterfaceC13295fz2() { // from class: ir.nasim.XT1
                @Override // ir.nasim.InterfaceC13295fz2
                public final void a(String str, Bundle bundle) {
                    C15375jU1.va(this.a, peerItem, str, bundle);
                }
            });
            InterfaceC24908zP5.b(pa(), "vitrine_report_result_key", "market_report_title_result_key", "report_type_result_key", null, 8, null).K8(F5(), null);
        }
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        na().c.setAdapter(null);
        this.o1 = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void W6(boolean z) {
        super.W6(z);
        if (z) {
            return;
        }
        ia();
    }

    @Override // ir.nasim.InterfaceC15426jZ7
    public void Y1(ExPeer exPeer, Boolean bool, String str, int i2) {
        AbstractC13042fc3.i(exPeer, "actionExPeer");
        AbstractC13042fc3.i(str, "rowTitle");
        HashMap map = new HashMap();
        map.put("title", str);
        map.put("peer_id", Integer.valueOf(exPeer.getPeerId()));
        map.put("event_type", this.n1);
        map.put("action_type", Integer.valueOf(this.j1));
        map.put("block_id", Integer.valueOf(i2));
        if (exPeer.getExPeerType() == ExPeerType.PRIVATE) {
            String lowerCase = "PRIVATE".toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            map.put("peer_type", lowerCase);
            C5735Kp4.q.x(exPeer.getPeerId());
        } else if (exPeer.getExPeerType() == ExPeerType.BOT) {
            String lowerCase2 = "BOT".toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase2, "toLowerCase(...)");
            map.put("peer_type", lowerCase2);
            C18987pb3 c18987pb3 = C18987pb3.a;
            C11458d25 c11458d25E = C11458d25.E(exPeer.getPeerId());
            AbstractC13042fc3.h(c11458d25E, "user(...)");
            C18987pb3.x1(c18987pb3, c11458d25E, null, null, false, null, null, false, null, null, false, null, 2046, null);
        } else if (exPeer.getExPeerType() == ExPeerType.CHANNEL || exPeer.getExPeerType() == ExPeerType.GROUP) {
            String lowerCase3 = exPeer.getExPeerType().name().toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase3, "toLowerCase(...)");
            map.put("peer_type", lowerCase3);
            if (bool != null) {
                if (bool.booleanValue()) {
                    C18987pb3 c18987pb32 = C18987pb3.a;
                    C11458d25 c11458d25Y = C11458d25.y(exPeer.getPeerId());
                    AbstractC13042fc3.h(c11458d25Y, "group(...)");
                    c18987pb32.y1(c11458d25Y, null, null, false, "discover");
                } else {
                    map.put("action_type", Integer.valueOf(this.k1));
                    la(exPeer.getPeerId());
                }
            }
        }
        C3343Am.i("flow_discover", map);
    }

    @Override // ir.nasim.InterfaceC13568gS3
    public void a3(MarketSection marketSection) {
        AbstractC13042fc3.i(marketSection, "row");
        Ea(marketSection);
        C21946uP3 c21946uP3 = new C21946uP3(3, null, null, null, null, Integer.valueOf(marketSection.getId()), null, null, null, null, null, null, null, null, null, 32734, null);
        C3343Am.i("market_page", c21946uP3.a());
        C3343Am.j("market_page", c21946uP3.b());
    }

    @Override // ir.nasim.InterfaceC24154y80
    public void h0(String str, int i2) {
        AbstractC13042fc3.i(str, "action");
        String strM = AbstractC20153rZ6.M(str, "&amp;", Separators.AND, false, 4, null);
        HashMap map = new HashMap();
        map.put("action_type", Integer.valueOf(this.j1));
        map.put("event_type", this.l1);
        map.put("url", strM);
        map.put("block_id", Integer.valueOf(i2));
        C3343Am.i("flow_discover", map);
        if (TextUtils.isEmpty(strM)) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(strM));
        C18987pb3 c18987pb3 = C18987pb3.a;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        if (c18987pb3.k0(intent, fragmentActivityQ7)) {
            return;
        }
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        Uri uri = Uri.parse(strM);
        AbstractC13042fc3.h(uri, "parse(...)");
        aVar.A(contextS7, uri);
    }

    @Override // ir.nasim.InterfaceC14159hS3
    public void k(MarketProductItem marketProductItem, MarketSection marketSection) {
        AbstractC13042fc3.i(marketProductItem, "item");
        AbstractC13042fc3.i(marketSection, "row");
        xa(marketProductItem.getUrl());
        Integer groupId = marketProductItem.getPost().getGroupId();
        if (groupId != null) {
            int iIntValue = groupId.intValue();
            HashMap map = new HashMap();
            map.put("title", marketSection.getTitle());
            map.put("peer_id", Integer.valueOf(iIntValue));
            String lowerCase = "CHANNEL".toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            map.put("peer_type", lowerCase);
            map.put("action_type", Integer.valueOf(this.j1));
            map.put("event_type", this.m1);
            map.put("url", marketProductItem.getUrl());
            map.put("block_id", Integer.valueOf(marketSection.getId()));
            C3343Am.i("flow_discover", map);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle bundle) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, bundle);
        ra();
        Da();
        ia();
    }

    public final InterfaceC24908zP5 pa() {
        InterfaceC24908zP5 interfaceC24908zP5 = this.r1;
        if (interfaceC24908zP5 != null) {
            return interfaceC24908zP5;
        }
        AbstractC13042fc3.y("reportNavigator");
        return null;
    }

    public final void qa() {
        na().c.smoothScrollToPosition(0);
        this.h1.o2();
    }

    @Override // ir.nasim.InterfaceC14770iS3
    public void x(MarketItemMore marketItemMore, MarketSection marketSection) {
        AbstractC13042fc3.i(marketItemMore, "item");
        AbstractC13042fc3.i(marketSection, "row");
        C22042ua0.A9(this, C7359Rj4.y1.a(marketSection), false, null, 6, null);
    }

    @Override // ir.nasim.C12950fS3.b
    public void x2(final Object obj) {
        AbstractC13042fc3.i(obj, "item");
        if (C8386Vt0.a.U3()) {
            F5().z("market_report_result_key");
            F5().H1("market_report_result_key", this, new InterfaceC13295fz2() { // from class: ir.nasim.eU1
                @Override // ir.nasim.InterfaceC13295fz2
                public final void a(String str, Bundle bundle) {
                    C15375jU1.ta(obj, this, str, bundle);
                }
            });
            InterfaceC24908zP5.b(pa(), "market_report_result_key", "market_report_title_result_key", "report_type_result_key", null, 8, null).K8(F5(), null);
        }
    }

    @Override // ir.nasim.InterfaceC15426jZ7
    public void y1(ExPeer exPeer, String str, int i2) {
        AbstractC13042fc3.i(exPeer, "actionExPeer");
        AbstractC13042fc3.i(str, "rowTitle");
        HashMap map = new HashMap();
        map.put("title", str);
        map.put("peer_id", Integer.valueOf(exPeer.getPeerId()));
        map.put("action_type", Integer.valueOf(this.j1));
        map.put("event_type", this.n1);
        map.put("block_id", Integer.valueOf(i2));
        if (exPeer.getExPeerType() == ExPeerType.PRIVATE) {
            String lowerCase = "PRIVATE".toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            map.put("peer_type", lowerCase);
            C5735Kp4.q.x(exPeer.getPeerId());
        } else if (exPeer.getExPeerType() == ExPeerType.BOT) {
            String lowerCase2 = "BOT".toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase2, "toLowerCase(...)");
            map.put("peer_type", lowerCase2);
            C5735Kp4.w().o(C11458d25.E(exPeer.getPeerId()));
            C18987pb3 c18987pb3 = C18987pb3.a;
            C11458d25 c11458d25E = C11458d25.E(exPeer.getPeerId());
            AbstractC13042fc3.h(c11458d25E, "user(...)");
            C18987pb3.x1(c18987pb3, c11458d25E, null, null, false, null, null, false, null, null, false, null, 2046, null);
        } else if (exPeer.getExPeerType() == ExPeerType.CHANNEL || exPeer.getExPeerType() == ExPeerType.GROUP) {
            String lowerCase3 = exPeer.getExPeerType().name().toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase3, "toLowerCase(...)");
            map.put("peer_type", lowerCase3);
            C5735Kp4.w().o(C11458d25.y(exPeer.getPeerId()));
            C18987pb3 c18987pb32 = C18987pb3.a;
            C11458d25 c11458d25Y = C11458d25.y(exPeer.getPeerId());
            AbstractC13042fc3.h(c11458d25Y, "group(...)");
            c18987pb32.y1(c11458d25Y, null, null, false, "discover");
        }
        C3343Am.i("flow_discover", map);
    }
}
