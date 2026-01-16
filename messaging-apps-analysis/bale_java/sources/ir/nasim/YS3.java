package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C10489bh6;
import ir.nasim.C13122fh6;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class YS3 extends AbstractC10362bX2 implements C13122fh6.c {
    private String h1;
    private boolean i1;
    private byte[] j1;
    private final InterfaceC10358bW7 k1;
    private final InterfaceC9173Yu3 l1;
    private final int m1;
    private final C13122fh6 n1;
    private EnumC25253zz5 o1;
    private final C11634dL2 p1;
    private boolean q1;
    private int r1;
    static final /* synthetic */ InterfaceC5239Im3[] t1 = {AbstractC10882cM5.i(new C25226zw5(YS3.class, "binding", "getBinding()Lir/nasim/market/databinding/FragmentMarketSearchResultProductsBinding;", 0))};
    public static final a s1 = new a(null);
    public static final int u1 = 8;

    public static final class a {
        private a() {
        }

        public static /* synthetic */ YS3 b(a aVar, String str, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = true;
            }
            return aVar.a(str, z);
        }

        public final YS3 a(String str, boolean z) {
            AbstractC13042fc3.i(str, "term");
            YS3 ys3 = new YS3(null);
            Bundle bundle = new Bundle();
            bundle.putString("term", str);
            bundle.putBoolean("start_search", z);
            ys3.a8(bundle);
            return ys3;
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
            if (recyclerView.canScrollVertically(1) || YS3.this.q1 || YS3.this.r1 <= YS3.this.n1.z().size()) {
                return;
            }
            YS3.this.pa();
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
            return YS3.this.new c(this.d, this.e, interfaceC20295rm1);
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
            YS3.this.oa();
            if (!this.d.c()) {
                int itemCount = YS3.this.n1.getItemCount();
                YS3.this.ea().d.setVisibility(8);
                YS3.this.ea().f.setVisibility(0);
                YS3.this.n1.z().addAll(this.e);
                YS3.this.ea().b.setVisibility(8);
                YS3.this.n1.notifyItemRangeInserted(itemCount, this.e.size());
            }
            YS3.this.q1 = false;
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
            return YS3.this.new e(interfaceC20295rm1);
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
            YS3.this.oa();
            if (YS3.this.n1.z().size() == 0) {
                YS3.this.ea().d.setVisibility(0);
                YS3.this.ea().f.setVisibility(8);
                YS3.this.ea().b.setVisibility(8);
            }
            YS3.this.q1 = false;
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
            return YS3.this.new f(interfaceC20295rm1);
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
            YS3.this.oa();
            YS3.this.q1 = false;
            YS3.this.ea().d.setVisibility(0);
            YS3.this.ea().f.setVisibility(8);
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
            return C4161Dy2.a(fragment.V7());
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

    public /* synthetic */ YS3(ED1 ed1) {
        this();
    }

    private final void ca() {
        int itemCount = this.n1.getItemCount();
        int i2 = this.m1;
        int i3 = i2 - (itemCount % i2);
        for (int i4 = 0; i4 < i3; i4++) {
            this.n1.z().add(new C10489bh6.c());
        }
        this.n1.notifyItemRangeInserted(itemCount, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C4161Dy2 ea() {
        Object objA = this.k1.a(this, t1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C4161Dy2) objA;
    }

    private final XV4 fa(int i2) {
        int i3 = this.m1;
        if (i2 <= i3 - 1) {
            return new XV4(0, Integer.valueOf(i2));
        }
        int i4 = i2 + 1;
        if (i4 % i3 != 0) {
            return new XV4(Integer.valueOf(i4 / i3), Integer.valueOf((i4 % i3) - 1));
        }
        return new XV4(Integer.valueOf(i2 / i3), Integer.valueOf(i2 % i3));
    }

    private final C12350eT3 ga() {
        return (C12350eT3) this.l1.getValue();
    }

    private final YS3 ha() {
        this.n1.C(this);
        return this;
    }

    private final YS3 ia() {
        ea().g.setTypeface(C6011Lu2.i());
        ea().c.setTypeface(C6011Lu2.k());
        ea().e.setTypeface(C6011Lu2.k());
        return this;
    }

    private final YS3 ja() {
        RecyclerView recyclerView = ea().f;
        recyclerView.setAdapter(this.n1);
        recyclerView.addItemDecoration(this.p1);
        recyclerView.addOnScrollListener(new b());
        return this;
    }

    private final void ka(final ArrayList arrayList) {
        ga().T0(arrayList).j(p6(), new d(new UA2() { // from class: ir.nasim.XS3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return YS3.la(this.a, arrayList, (C5354Iz1) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 la(YS3 ys3, ArrayList arrayList, C5354Iz1 c5354Iz1) {
        AbstractC13042fc3.i(ys3, "this$0");
        AbstractC13042fc3.i(arrayList, "$list");
        AbstractC10533bm0.d(AbstractC16751lo1.a(ys3), null, null, ys3.new c(c5354Iz1, arrayList, null), 3, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(YS3 ys3, String str, Bundle bundle) {
        EnumC25253zz5 enumC25253zz5;
        AbstractC13042fc3.i(ys3, "this$0");
        AbstractC13042fc3.i(str, "<unused var>");
        AbstractC13042fc3.i(bundle, "bundle");
        try {
            Serializable serializable = bundle.getSerializable("query_type");
            AbstractC13042fc3.g(serializable, "null cannot be cast to non-null type ir.nasim.core.modules.market.model.QueryType");
            enumC25253zz5 = (EnumC25253zz5) serializable;
        } catch (Exception unused) {
            enumC25253zz5 = EnumC25253zz5.b;
        }
        ys3.o1 = enumC25253zz5;
        String string = bundle.getString("result_search_term", null);
        if (string != null) {
            ys3.da(string);
        }
    }

    private final void na(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        C18987pb3 c18987pb3 = C18987pb3.a;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        c18987pb3.k0(intent, fragmentActivityQ7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void oa() {
        int itemCount = this.n1.getItemCount();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : this.n1.z()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                AbstractC10360bX0.w();
            }
            if (obj instanceof C10489bh6.c) {
                arrayList.add(obj);
            }
            i2 = i3;
        }
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.n1.z().remove((C10489bh6.c) it.next());
            }
            this.n1.notifyItemRangeRemoved(itemCount - arrayList.size(), arrayList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pa() {
        this.q1 = true;
        ca();
        ea().b.setVisibility(8);
        C12350eT3 c12350eT3Ga = ga();
        String str = this.h1;
        if (str == null) {
            AbstractC13042fc3.y("term");
            str = null;
        }
        c12350eT3Ga.U0(str, this.j1).j(p6(), new d(new UA2() { // from class: ir.nasim.VS3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return YS3.qa(this.a, (C5354Iz1) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final ir.nasim.C19938rB7 qa(ir.nasim.YS3 r12, ir.nasim.C5354Iz1 r13) {
        /*
            java.lang.String r0 = "this$0"
            ir.nasim.AbstractC13042fc3.i(r12, r0)
            boolean r0 = r13.c()
            r1 = 0
            if (r0 != 0) goto L8a
            java.lang.Object r0 = r13.a()
            if (r0 == 0) goto L79
            java.lang.Object r0 = r13.a()
            ir.nasim.bh6 r0 = (ir.nasim.C10489bh6) r0
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
            ir.nasim.bh6 r0 = (ir.nasim.C10489bh6) r0
            if (r0 == 0) goto L3a
            int r0 = r0.a()
            r12.ra(r0)
            r12.r1 = r0
        L3a:
            java.lang.Object r0 = r13.a()
            ir.nasim.bh6 r0 = (ir.nasim.C10489bh6) r0
            if (r0 == 0) goto L46
            byte[] r1 = r0.b()
        L46:
            r12.j1 = r1
            java.lang.Object r0 = r13.a()
            ir.nasim.bh6 r0 = (ir.nasim.C10489bh6) r0
            if (r0 == 0) goto L70
            java.util.ArrayList r0 = r0.c()
            if (r0 == 0) goto L70
            boolean r0 = r0.isEmpty()
            r1 = 1
            r0 = r0 ^ r1
            if (r0 != r1) goto L70
            java.lang.Object r13 = r13.a()
            ir.nasim.bh6 r13 = (ir.nasim.C10489bh6) r13
            if (r13 == 0) goto L9a
            java.util.ArrayList r13 = r13.c()
            if (r13 == 0) goto L9a
            r12.ka(r13)
            goto L9a
        L70:
            ir.nasim.fh6 r13 = r12.n1
            int r13 = r13.getItemCount()
            r12.r1 = r13
            goto L9a
        L79:
            ir.nasim.iz3 r0 = ir.nasim.AbstractC16751lo1.a(r12)
            ir.nasim.YS3$e r3 = new ir.nasim.YS3$e
            r3.<init>(r1)
            r4 = 3
            r5 = 0
            r1 = 0
            r2 = 0
            ir.nasim.AbstractC9323Zl0.d(r0, r1, r2, r3, r4, r5)
            goto L9a
        L8a:
            ir.nasim.iz3 r6 = ir.nasim.AbstractC16751lo1.a(r12)
            ir.nasim.YS3$f r9 = new ir.nasim.YS3$f
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
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.YS3.qa(ir.nasim.YS3, ir.nasim.Iz1):ir.nasim.rB7");
    }

    private final void ra(int i2) {
        TextView textView = ea().c;
        int i3 = JD5.market_search_result_products_count;
        C7635So1 c7635So1 = C7635So1.a;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        textView.setText(i6(i3, c7635So1.a(i2, contextS7)));
        ea().b.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle bundle) {
        super.M6(bundle);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.i1 = bundleE5.getBoolean("start_search", true);
            String string = bundleE5.getString("term", "");
            this.h1 = string;
            if (this.i1) {
                if (string == null) {
                    AbstractC13042fc3.y("term");
                    string = null;
                }
                if (string.length() == 0) {
                    C22042ua0.m9(this, this, false, 2, null);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AbstractC13042fc3.i(layoutInflater, "inflater");
        LinearLayout root = C4161Dy2.c(layoutInflater.cloneInContext(new C16731lm1(G5(), AbstractC17008mE5.Theme_Bale_Base)), viewGroup, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    public final void da(String str) {
        AbstractC13042fc3.i(str, "newTerm");
        ea().d.setVisibility(8);
        this.n1.A();
        this.h1 = str;
        this.j1 = null;
        pa();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle bundle) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, bundle);
        ia().ja().ha();
        if (this.i1) {
            pa();
        }
        Q7().B0().H1("do_search_in_products", this, new InterfaceC13295fz2() { // from class: ir.nasim.WS3
            @Override // ir.nasim.InterfaceC13295fz2
            public final void a(String str, Bundle bundle2) {
                YS3.ma(this.a, str, bundle2);
            }
        });
    }

    @Override // ir.nasim.C13122fh6.c
    public void r4(C10489bh6.b bVar) {
        AbstractC13042fc3.i(bVar, "post");
        C23381wp3.f(o6());
        XV4 xv4Fa = fa(this.n1.z().indexOf(bVar));
        String str = this.h1;
        if (str == null) {
            AbstractC13042fc3.y("term");
            str = null;
        }
        String str2 = str;
        int iB = bVar.b();
        long jC = bVar.c();
        new C15494jg6(str2, Integer.valueOf(((Number) xv4Fa.e()).intValue()), Integer.valueOf(((Number) xv4Fa.f()).intValue()), Long.valueOf(jC), Integer.valueOf(iB), null, null, 96, null).a();
        na(bVar.d());
    }

    private YS3() {
        this.i1 = true;
        this.k1 = AbstractC6056Lz2.f(this, new g(), AbstractC20046rN7.c());
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new i(new h(this)));
        this.l1 = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C12350eT3.class), new j(interfaceC9173Yu3B), new k(null, interfaceC9173Yu3B), new l(this, interfaceC9173Yu3B));
        this.m1 = 3;
        this.n1 = new C13122fh6();
        this.o1 = EnumC25253zz5.b;
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        this.p1 = new C11634dL2(3, 0, 0, aVar.f(2.0f), aVar.f(3.0f), aVar.f(3.0f), aVar.f(2.0f), 6, null);
        this.q1 = true;
        this.r1 = -1;
    }
}
