package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.YM6;
import ir.nasim.features.smiles.panel.sticker.k;
import ir.nasim.features.smiles.widget.StickerRecyclerView;

/* loaded from: classes6.dex */
public final class XM6 extends com.google.android.material.bottomsheet.b {
    public static final a v1 = new a(null);
    public static final int w1 = 8;
    private UA2 n1;
    private int o1;
    private com.google.android.material.bottomsheet.a p1;
    private final InterfaceC9173Yu3 q1;
    private BP1 r1;
    private final InterfaceC9173Yu3 s1;
    private int t1;
    private GridLayoutManager u1;

    public static final class a {
        private a() {
        }

        public final XM6 a(int i, UA2 ua2) {
            AbstractC13042fc3.i(ua2, "onDismiss");
            XM6 xm6 = new XM6(null);
            Bundle bundle = new Bundle();
            bundle.putInt("ARG_PACK_ID", i);
            xm6.a8(bundle);
            xm6.p9(ua2);
            return xm6;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class c implements View.OnLayoutChangeListener {
        final /* synthetic */ BP1 a;

        public c(BP1 bp1) {
            this.a = bp1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            this.a.j.setPadding(0, AbstractC8943Xx1.c(12), 0, this.a.f.getMeasuredHeight());
        }
    }

    public static final class d implements View.OnLayoutChangeListener {
        final /* synthetic */ YM6.a a;
        final /* synthetic */ XM6 b;

        public d(YM6.a aVar, XM6 xm6) {
            this.a = aVar;
            this.b = xm6;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            View view2;
            view.removeOnLayoutChangeListener(this);
            if (this.a.b().size() > this.b.t1 * 3) {
                int height = 0;
                RecyclerView.C cFindViewHolderForAdapterPosition = this.b.e9().j.findViewHolderForAdapterPosition(0);
                if (cFindViewHolderForAdapterPosition != null && (view2 = cFindViewHolderForAdapterPosition.a) != null) {
                    height = view2.getHeight();
                }
                com.google.android.material.bottomsheet.a aVar = this.b.p1;
                if (aVar == null) {
                    AbstractC13042fc3.y("bottomSheetDialog");
                    aVar = null;
                }
                BottomSheetBehavior bottomSheetBehaviorO = aVar.o();
                bottomSheetBehaviorO.F0(bottomSheetBehaviorO.j0() + (height / 2));
            }
        }
    }

    public static final class e implements View.OnLayoutChangeListener {
        public e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            XM6.this.t1 = RF6.a.b(view.getMeasuredWidth() - (view.getPaddingLeft() + view.getPaddingRight()));
            GridLayoutManager gridLayoutManager = XM6.this.u1;
            if (gridLayoutManager != null) {
                gridLayoutManager.j3(XM6.this.t1);
            }
        }
    }

    static final class f implements QG4, InterfaceC22409vB2 {
        private final /* synthetic */ UA2 a;

        f(UA2 ua2) {
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

    public static final class g implements View.OnLayoutChangeListener {
        public g() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            AbstractC13042fc3.g(view, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            RecyclerView recyclerView = (RecyclerView) view;
            XM6.this.t1 = RF6.a.b(recyclerView.getMeasuredWidth() - (recyclerView.getPaddingLeft() + recyclerView.getPaddingRight()));
            XM6 xm6 = XM6.this;
            xm6.u1 = new GridLayoutManager(xm6.G5(), XM6.this.t1);
            recyclerView.setLayoutManager(XM6.this.u1);
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

    public /* synthetic */ XM6(ED1 ed1) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BP1 e9() {
        BP1 bp1 = this.r1;
        AbstractC13042fc3.f(bp1);
        return bp1;
    }

    private final ir.nasim.features.smiles.panel.sticker.j f9() {
        return (ir.nasim.features.smiles.panel.sticker.j) this.s1.getValue();
    }

    private final YM6 g9() {
        return (YM6) this.q1.getValue();
    }

    private final void h9() {
        BP1 bp1E9 = e9();
        bp1E9.k.setTypeface(C6011Lu2.i());
        LinearLayout linearLayout = bp1E9.f;
        AbstractC13042fc3.h(linearLayout, "frBtn");
        if (!linearLayout.isLaidOut() || linearLayout.isLayoutRequested()) {
            linearLayout.addOnLayoutChangeListener(new c(bp1E9));
        } else {
            bp1E9.j.setPadding(0, AbstractC8943Xx1.c(12), 0, bp1E9.f.getMeasuredHeight());
        }
        StickerRecyclerView stickerRecyclerView = bp1E9.j;
        androidx.recyclerview.widget.h hVar = new androidx.recyclerview.widget.h();
        hVar.w(220L);
        hVar.z(220L);
        hVar.x(160L);
        stickerRecyclerView.setItemAnimator(hVar);
        stickerRecyclerView.addOnItemTouchListener(new b(stickerRecyclerView));
        q9();
        stickerRecyclerView.setAdapter(f9());
        bp1E9.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.UM6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XM6.i9(this.a, view);
            }
        });
        bp1E9.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.VM6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XM6.j9(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i9(XM6 xm6, View view) {
        AbstractC13042fc3.i(xm6, "this$0");
        xm6.g9().c1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j9(XM6 xm6, View view) {
        AbstractC13042fc3.i(xm6, "this$0");
        xm6.g9().c1();
    }

    private final void k9() {
        g9().Z0().j(this, new f(new UA2() { // from class: ir.nasim.SM6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return XM6.l9(this.a, (YM6.b) obj);
            }
        }));
        g9().a1().j(this, new f(new UA2() { // from class: ir.nasim.TM6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return XM6.m9(this.a, (YM6.a) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l9(XM6 xm6, YM6.b bVar) {
        AbstractC13042fc3.i(xm6, "this$0");
        UA2 ua2 = xm6.n1;
        if (ua2 != null) {
            String strH6 = xm6.h6(bVar.a());
            AbstractC13042fc3.h(strH6, "getString(...)");
            ua2.invoke(strH6);
        }
        xm6.u8();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m9(XM6 xm6, YM6.a aVar) {
        AbstractC13042fc3.i(xm6, "this$0");
        if (aVar.a()) {
            xm6.e9().b.setVisibility(8);
            xm6.e9().c.setVisibility(0);
        } else {
            xm6.e9().b.setVisibility(0);
            xm6.e9().c.setVisibility(8);
        }
        String strC = aVar.c();
        if (strC.length() <= 0) {
            strC = null;
        }
        if (strC != null) {
            xm6.e9().k.setText(strC);
        }
        StickerRecyclerView stickerRecyclerView = xm6.e9().j;
        AbstractC13042fc3.h(stickerRecyclerView, "rcStickers");
        stickerRecyclerView.addOnLayoutChangeListener(new d(aVar, xm6));
        xm6.f9().C(aVar.b());
        xm6.r9();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n9(XM6 xm6) {
        AbstractC13042fc3.i(xm6, "this$0");
        StickerRecyclerView stickerRecyclerView = xm6.e9().j;
        AbstractC13042fc3.h(stickerRecyclerView, "rcStickers");
        if (!stickerRecyclerView.isLaidOut() || stickerRecyclerView.isLayoutRequested()) {
            stickerRecyclerView.addOnLayoutChangeListener(xm6.new e());
            return;
        }
        xm6.t1 = RF6.a.b(stickerRecyclerView.getMeasuredWidth() - (stickerRecyclerView.getPaddingLeft() + stickerRecyclerView.getPaddingRight()));
        GridLayoutManager gridLayoutManager = xm6.u1;
        if (gridLayoutManager != null) {
            gridLayoutManager.j3(xm6.t1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o9(XM6 xm6, DialogInterface dialogInterface) {
        AbstractC13042fc3.i(xm6, "this$0");
        AbstractC13042fc3.g(dialogInterface, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        Context baseContext = xm6.Q7().getBaseContext();
        AbstractC13042fc3.h(baseContext, "getBaseContext(...)");
        int iH = aVar.h(baseContext, android.R.attr.actionBarSize);
        View viewFindViewById = ((com.google.android.material.bottomsheet.a) dialogInterface).findViewById(WB5.container);
        AbstractC13042fc3.g(viewFindViewById, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) viewFindViewById;
        AbstractC14828iY7.j(frameLayout, null, Float.valueOf(iH), null, null);
        LinearLayout linearLayout = xm6.e9().f;
        ViewParent parent = linearLayout.getParent();
        AbstractC13042fc3.g(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).removeView(linearLayout);
        frameLayout.addView(linearLayout);
    }

    private final void q9() {
        StickerRecyclerView stickerRecyclerView = e9().j;
        AbstractC13042fc3.h(stickerRecyclerView, "rcStickers");
        stickerRecyclerView.addOnLayoutChangeListener(new g());
    }

    private final void r9() {
        BP1 bp1E9 = e9();
        bp1E9.i.setVisibility(8);
        bp1E9.j.setVisibility(0);
        bp1E9.f.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ir.nasim.features.smiles.panel.sticker.j t9() {
        return new ir.nasim.features.smiles.panel.sticker.j(new InterfaceC14603iB2() { // from class: ir.nasim.WM6
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return XM6.u9((C23698xM6) obj, ((Boolean) obj2).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u9(C23698xM6 c23698xM6, boolean z) {
        AbstractC13042fc3.i(c23698xM6, "<unused var>");
        return C19938rB7.a;
    }

    @Override // com.google.android.material.bottomsheet.b, ir.nasim.ZD, androidx.fragment.app.l
    public Dialog B8(Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(S7(), AbstractC23035wE5.PlayListBottomSheetDialogTheme);
        aVar.setCancelable(true);
        aVar.setCanceledOnTouchOutside(true);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() { // from class: ir.nasim.PM6
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                XM6.o9(this.a, dialogInterface);
            }
        });
        BottomSheetBehavior bottomSheetBehaviorO = aVar.o();
        bottomSheetBehaviorO.J0(4);
        bottomSheetBehaviorO.B0(0.5f);
        bottomSheetBehaviorO.F0(C22078ud6.b() / 2);
        bottomSheetBehaviorO.z0(true);
        bottomSheetBehaviorO.I0(false);
        this.p1 = aVar;
        return aVar;
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void M6(Bundle bundle) {
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.o1 = bundleE5.getInt("ARG_PACK_ID");
        }
        super.M6(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AbstractC13042fc3.i(layoutInflater, "inflater");
        super.Q6(layoutInflater, viewGroup, bundle);
        this.r1 = BP1.c(LayoutInflater.from(G5()));
        FrameLayout root = e9().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        this.r1 = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle bundle) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, bundle);
        h9();
        k9();
        g9().Y0(this.o1);
        s9();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        AbstractC13042fc3.i(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        e9().j.postDelayed(new Runnable() { // from class: ir.nasim.QM6
            @Override // java.lang.Runnable
            public final void run() {
                XM6.n9(this.a);
            }
        }, 100L);
    }

    public final void p9(UA2 ua2) {
        this.n1 = ua2;
    }

    public final void s9() {
        BP1 bp1E9 = e9();
        bp1E9.i.setVisibility(0);
        bp1E9.j.setVisibility(8);
        bp1E9.f.setVisibility(8);
    }

    private XM6() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new i(new h(this)));
        this.q1 = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(YM6.class), new j(interfaceC9173Yu3B), new k(null, interfaceC9173Yu3B), new l(this, interfaceC9173Yu3B));
        this.s1 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.RM6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return XM6.t9();
            }
        });
        this.t1 = 5;
    }

    public static final class b implements RecyclerView.s {
        private int a = -1;
        private int b;
        final /* synthetic */ StickerRecyclerView c;

        b(StickerRecyclerView stickerRecyclerView) {
            this.c = stickerRecyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
            AbstractC13042fc3.i(recyclerView, "rv");
            AbstractC13042fc3.i(motionEvent, "e");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
            AbstractC13042fc3.i(recyclerView, "rv");
            AbstractC13042fc3.i(motionEvent, "e");
            View viewFindChildViewUnder = this.c.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (viewFindChildViewUnder == null) {
                return false;
            }
            this.b = this.c.getChildAdapterPosition(viewFindChildViewUnder);
            if (motionEvent.getAction() == 0) {
                recyclerView.stopScroll();
                if (this.b < 0) {
                    this.c.b1();
                } else {
                    RecyclerView.C childViewHolder = this.c.getChildViewHolder(viewFindChildViewUnder);
                    k.b bVar = childViewHolder instanceof k.b ? (k.b) childViewHolder : null;
                    if (bVar == null) {
                        return false;
                    }
                    Dialog stickerDialogPreview = this.c.getStickerDialogPreview();
                    if (stickerDialogPreview == null || !stickerDialogPreview.isShowing() || this.a != this.b) {
                        this.c.f1(new StickerRecyclerView.a(bVar.M0(), bVar.N0()));
                        this.a = this.b;
                    }
                }
            }
            if (this.a != this.b || motionEvent.getAction() == 1 || motionEvent.getAction() == 9 || motionEvent.getAction() == 3 || motionEvent.getAction() == 7 || motionEvent.getAction() == 8) {
                this.c.b1();
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void e(boolean z) {
        }
    }
}
