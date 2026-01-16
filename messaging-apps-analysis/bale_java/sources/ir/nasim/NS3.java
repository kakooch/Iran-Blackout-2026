package ir.nasim;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C13122fh6;
import ir.nasim.C22698vg6;
import java.util.ArrayList;
import org.xbill.DNS.Type;

/* loaded from: classes4.dex */
public final class NS3 extends AbstractC9768aX2 implements C13122fh6.b {
    private boolean h1;
    private String i1;
    private byte[] j1;
    private final InterfaceC10358bW7 k1;
    private final InterfaceC9173Yu3 l1;
    private final C13122fh6 m1;
    private final InterfaceC9173Yu3 n1;
    private boolean o1;
    private int p1;
    private boolean q1;
    static final /* synthetic */ InterfaceC5239Im3[] s1 = {AbstractC10882cM5.i(new C25226zw5(NS3.class, "binding", "getBinding()Lir/nasim/market/databinding/FragmentMarketSearchResultMarketsBinding;", 0))};
    public static final a r1 = new a(null);
    public static final int t1 = 8;

    public static final class a {
        private a() {
        }

        public final NS3 a(String str) {
            AbstractC13042fc3.i(str, "term");
            NS3 ns3 = new NS3(null);
            Bundle bundle = new Bundle();
            bundle.putString("term", str);
            ns3.a8(bundle);
            return ns3;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b extends RecyclerView.t {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            AbstractC13042fc3.i(recyclerView, "recyclerView");
            super.b(recyclerView, i, i2);
            if (recyclerView.canScrollVertically(1) || NS3.this.o1 || NS3.this.p1 <= NS3.this.m1.z().size()) {
                return;
            }
            NS3.this.xa();
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C5354Iz1 d;
        final /* synthetic */ ArrayList e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C5354Iz1 c5354Iz1, ArrayList arrayList, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c5354Iz1;
            this.e = arrayList;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return NS3.this.new c(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(500L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            NS3.this.va();
            if (!this.d.c()) {
                int itemCount = NS3.this.m1.getItemCount();
                NS3.this.m1.z().addAll(this.e);
                NS3.this.m1.notifyItemRangeInserted(itemCount, this.e.size());
            }
            NS3.this.o1 = false;
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d implements QG4, InterfaceC22409vB2 {
        private final /* synthetic */ UA2 a;

        d(UA2 ua2) {
            AbstractC13042fc3.i(ua2, "function");
            this.a = ua2;
        }

        @Override // ir.nasim.QG4
        public final /* synthetic */ void a(Object obj) {
            this.a.invoke(obj);
        }

        @Override // ir.nasim.InterfaceC22409vB2
        public final InterfaceC18751pB2 b() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof QG4) && (obj instanceof InterfaceC22409vB2)) {
                return AbstractC13042fc3.d(b(), ((InterfaceC22409vB2) obj).b());
            }
            return false;
        }

        public final int hashCode() {
            return b().hashCode();
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return NS3.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(500L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            NS3.this.va();
            if (NS3.this.m1.z().size() == 0) {
                NS3.this.ia().d.setVisibility(0);
            }
            NS3.this.o1 = false;
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return NS3.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(500L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            NS3.this.va();
            NS3.this.o1 = false;
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class g extends AbstractC8614Ws3 implements UA2 {
        public g() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C3927Cy2.a(fragment.V7());
        }
    }

    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    public static final class i extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    public static final class j extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    public static final class k extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public static final class l extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public /* synthetic */ NS3(ED1 ed1) {
        this();
    }

    private final void ga() {
        int itemCount = this.m1.getItemCount();
        this.m1.z().add(new C22698vg6.c());
        this.m1.notifyItemInserted(itemCount);
        ia().f.smoothScrollToPosition(itemCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C3927Cy2 ia() {
        Object objA = this.k1.a(this, s1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C3927Cy2) objA;
    }

    private final YV1 ja() {
        return (YV1) this.n1.getValue();
    }

    private final TS3 ka() {
        return (TS3) this.l1.getValue();
    }

    private final NS3 la() {
        this.m1.B(this);
        return this;
    }

    private final NS3 ma() {
        ia().g.setTypeface(C6011Lu2.i());
        ia().c.setTypeface(C6011Lu2.k());
        ia().e.setTypeface(C6011Lu2.i());
        return this;
    }

    private final NS3 na() {
        RecyclerView recyclerView = ia().f;
        recyclerView.setAdapter(this.m1);
        recyclerView.addItemDecoration(ja());
        recyclerView.addOnScrollListener(new b());
        return this;
    }

    private final void oa(final ArrayList arrayList) {
        ka().T0(arrayList).j(p6(), new d(new UA2() { // from class: ir.nasim.IS3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return NS3.pa(this.a, arrayList, (C5354Iz1) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 pa(NS3 ns3, ArrayList arrayList, C5354Iz1 c5354Iz1) {
        AbstractC13042fc3.i(ns3, "this$0");
        AbstractC13042fc3.i(arrayList, "$list");
        AbstractC10533bm0.d(AbstractC16751lo1.a(ns3), null, null, ns3.new c(c5354Iz1, arrayList, null), 3, null);
        return C19938rB7.a;
    }

    private final void qa(int i2, final String str) {
        if (this.q1) {
            return;
        }
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        if (C4100Dr4.a(contextS7)) {
            this.q1 = true;
            Context contextS72 = S7();
            AbstractC13042fc3.h(contextS72, "requireContext(...)");
            final ProgressDialog progressDialogE = C8920Xu5.e(contextS72, true);
            progressDialogE.setCancelable(false);
            AbstractC5969Lp4.b().k(i2).m0(new InterfaceC24449ye1() { // from class: ir.nasim.JS3
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    NS3.ra(this.a, str, progressDialogE, (C14733iO2) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.KS3
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    NS3.ta(str, this, progressDialogE, (Exception) obj);
                }
            });
            return;
        }
        LinearLayout root = ia().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(root, null, 0, 6, null);
        c17468n10.k(ia().getRoot());
        String strH6 = h6(AbstractC12217eE5.card_payment_please_check_your_internet_conenction);
        AbstractC13042fc3.h(strH6, "getString(...)");
        c17468n10.o(strH6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(final NS3 ns3, String str, ProgressDialog progressDialog, C14733iO2 c14733iO2) {
        AbstractC13042fc3.i(ns3, "this$0");
        AbstractC13042fc3.i(str, "$nick");
        AbstractC13042fc3.i(progressDialog, "$progressDialog");
        if (c14733iO2 != null) {
            C11458d25 c11458d25 = new C11458d25(W25.b, c14733iO2.r());
            C5735Kp4.w().o(c11458d25);
            C18987pb3.x1(C18987pb3.a, c11458d25, null, null, false, null, null, false, null, null, false, null, 2046, null);
        } else {
            C5735Kp4.w().J(ns3.S7(), str, "market");
        }
        C8920Xu5.c();
        progressDialog.dismiss();
        AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.MS3
            @Override // java.lang.Runnable
            public final void run() {
                NS3.sa(this.a);
            }
        }, 700L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(NS3 ns3) {
        AbstractC13042fc3.i(ns3, "this$0");
        ns3.q1 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(String str, final NS3 ns3, ProgressDialog progressDialog, Exception exc) {
        AbstractC13042fc3.i(str, "$nick");
        AbstractC13042fc3.i(ns3, "this$0");
        AbstractC13042fc3.i(progressDialog, "$progressDialog");
        if (str.length() > 0) {
            C5735Kp4.w().J(ns3.S7(), str, "market");
        }
        C19406qI3.d("NON_FATAL_EXCEPTION", exc);
        C8920Xu5.c();
        progressDialog.dismiss();
        AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.LS3
            @Override // java.lang.Runnable
            public final void run() {
                NS3.ua(this.a);
            }
        }, 700L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(NS3 ns3) {
        AbstractC13042fc3.i(ns3, "this$0");
        ns3.q1 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void va() {
        int itemCount = this.m1.getItemCount() - 1;
        if (this.m1.z().get(itemCount) instanceof C22698vg6.c) {
            this.m1.z().remove(itemCount);
            this.m1.notifyItemRemoved(itemCount);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YV1 wa(NS3 ns3) {
        AbstractC13042fc3.i(ns3, "this$0");
        Drawable drawableF = AbstractC4043Dl1.f(ns3.S7(), AbstractC19345qB5.shape_search_result_divider);
        AbstractC13042fc3.f(drawableF);
        return new YV1(drawableF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xa() {
        this.o1 = true;
        ga();
        TS3 ts3Ka = ka();
        String str = this.i1;
        if (str == null) {
            AbstractC13042fc3.y("term");
            str = null;
        }
        ts3Ka.U0(str, this.j1).j(p6(), new d(new UA2() { // from class: ir.nasim.GS3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return NS3.ya(this.a, (C5354Iz1) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final ir.nasim.C19938rB7 ya(ir.nasim.NS3 r12, ir.nasim.C5354Iz1 r13) {
        /*
            java.lang.String r0 = "this$0"
            ir.nasim.AbstractC13042fc3.i(r12, r0)
            boolean r0 = r13.c()
            r1 = 0
            if (r0 != 0) goto L8a
            java.lang.Object r0 = r13.a()
            if (r0 == 0) goto L79
            java.lang.Object r0 = r13.a()
            ir.nasim.vg6 r0 = (ir.nasim.C22698vg6) r0
            if (r0 == 0) goto L1f
            java.util.ArrayList r0 = r0.c()
            goto L20
        L1f:
            r0 = r1
        L20:
            if (r0 == 0) goto L79
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L29
            goto L79
        L29:
            java.lang.Object r0 = r13.a()
            ir.nasim.vg6 r0 = (ir.nasim.C22698vg6) r0
            if (r0 == 0) goto L3a
            int r0 = r0.a()
            r12.za(r0)
            r12.p1 = r0
        L3a:
            java.lang.Object r0 = r13.a()
            ir.nasim.vg6 r0 = (ir.nasim.C22698vg6) r0
            if (r0 == 0) goto L46
            byte[] r1 = r0.b()
        L46:
            r12.j1 = r1
            java.lang.Object r0 = r13.a()
            ir.nasim.vg6 r0 = (ir.nasim.C22698vg6) r0
            if (r0 == 0) goto L70
            java.util.ArrayList r0 = r0.c()
            if (r0 == 0) goto L70
            boolean r0 = r0.isEmpty()
            r1 = 1
            r0 = r0 ^ r1
            if (r0 != r1) goto L70
            java.lang.Object r13 = r13.a()
            ir.nasim.vg6 r13 = (ir.nasim.C22698vg6) r13
            if (r13 == 0) goto L9a
            java.util.ArrayList r13 = r13.c()
            if (r13 == 0) goto L9a
            r12.oa(r13)
            goto L9a
        L70:
            ir.nasim.fh6 r13 = r12.m1
            int r13 = r13.getItemCount()
            r12.p1 = r13
            goto L9a
        L79:
            ir.nasim.iz3 r0 = ir.nasim.AbstractC16751lo1.a(r12)
            ir.nasim.NS3$e r3 = new ir.nasim.NS3$e
            r3.<init>(r1)
            r4 = 3
            r5 = 0
            r1 = 0
            r2 = 0
            ir.nasim.AbstractC9323Zl0.d(r0, r1, r2, r3, r4, r5)
            goto L9a
        L8a:
            ir.nasim.iz3 r6 = ir.nasim.AbstractC16751lo1.a(r12)
            ir.nasim.NS3$f r9 = new ir.nasim.NS3$f
            r9.<init>(r1)
            r10 = 3
            r11 = 0
            r7 = 0
            r8 = 0
            ir.nasim.AbstractC9323Zl0.d(r6, r7, r8, r9, r10, r11)
        L9a:
            ir.nasim.rB7 r12 = ir.nasim.C19938rB7.a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.NS3.ya(ir.nasim.NS3, ir.nasim.Iz1):ir.nasim.rB7");
    }

    private final void za(int i2) {
        if (ia().b.getVisibility() == 8) {
            TextView textView = ia().c;
            int i3 = JD5.market_search_result_markets_count;
            C7635So1 c7635So1 = C7635So1.a;
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            textView.setText(i6(i3, c7635So1.a(i2, contextS7)));
            ia().b.setVisibility(0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle bundle) {
        super.M6(bundle);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            if (bundleE5.getString("term") == null) {
                C22042ua0.m9(this, this, false, 2, null);
                return;
            }
            String string = bundleE5.getString("term");
            if (string != null) {
                this.i1 = string;
            }
            this.h1 = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AbstractC13042fc3.i(layoutInflater, "inflater");
        LinearLayout root = C3927Cy2.c(layoutInflater, viewGroup, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    public final void ha(String str) {
        AbstractC13042fc3.i(str, "newTerm");
        if (this.h1) {
            ia().d.setVisibility(8);
            ia().b.setVisibility(8);
            this.m1.A();
            this.i1 = str;
            this.j1 = null;
            xa();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle bundle) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, bundle);
        ma().na().la();
        xa();
    }

    @Override // ir.nasim.C13122fh6.b
    public void z1(C22698vg6.b bVar) {
        AbstractC13042fc3.i(bVar, "peer");
        C23381wp3.f(o6());
        String str = this.i1;
        if (str == null) {
            AbstractC13042fc3.y("term");
            str = null;
        }
        new C15494jg6(str, Integer.valueOf(this.m1.z().indexOf(bVar)), null, null, Integer.valueOf(bVar.d()), null, null, Type.EUI48, null).a();
        qa(bVar.d(), bVar.e());
    }

    private NS3() {
        this.k1 = AbstractC6056Lz2.f(this, new g(), AbstractC20046rN7.c());
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new i(new h(this)));
        this.l1 = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(TS3.class), new j(interfaceC9173Yu3B), new k(null, interfaceC9173Yu3B), new l(this, interfaceC9173Yu3B));
        this.m1 = new C13122fh6();
        this.n1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.HS3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return NS3.wa(this.a);
            }
        });
        this.o1 = true;
        this.p1 = -1;
    }
}
