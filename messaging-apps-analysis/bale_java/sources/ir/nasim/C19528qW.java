package ir.nasim;

import android.content.Context;
import android.graphics.Point;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.shimmer.a;
import ir.nasim.AbstractC5909Li7;
import ir.nasim.HW;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.LW;
import ir.nasim.RW;
import ir.nasim.premium.ui.badge.BadgeRecyclerView;
import ir.nasim.premium.ui.badge.tab.TabLayoutRecycler;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.qW, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C19528qW extends AbstractC5462Jl1 {
    public static final b p = new b(null);
    public static final int q = 8;
    private static final int r = AbstractC8943Xx1.b(30.0f);
    private static final int s = AbstractC8943Xx1.a(4.5d);
    private static final int t;
    private static final int u;
    private final InterfaceC18633oz3 d;
    private final SA2 e;
    private C20119rW f;
    private final C20119rW g;
    private C8209Uz3 h;
    private GridLayoutManager i;
    private final InterfaceC9173Yu3 j;
    private final InterfaceC9173Yu3 k;
    private final InterfaceC9173Yu3 l;
    private final InterfaceC9173Yu3 m;
    private InterfaceC13730gj3 n;
    private long o;

    /* renamed from: ir.nasim.qW$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.qW$a$a, reason: collision with other inner class name */
        static final class C1481a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C19528qW c;

            /* renamed from: ir.nasim.qW$a$a$a, reason: collision with other inner class name */
            static final class C1482a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ C19528qW d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1482a(C19528qW c19528qW, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = c19528qW;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1482a c1482a = new C1482a(this.d, interfaceC20295rm1);
                    c1482a.c = obj;
                    return c1482a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    LW lw = (LW) this.c;
                    if (lw instanceof LW.a) {
                        this.d.G().o(((LW.a) lw).a());
                        this.d.dismiss();
                    } else if (lw instanceof LW.c) {
                        LW.c cVar = (LW.c) lw;
                        this.d.E().C(cVar.a());
                        this.d.F().C(cVar.b());
                    } else if (lw instanceof LW.d) {
                        LW.d dVar = (LW.d) lw;
                        this.d.E().C(dVar.a());
                        this.d.F().C(dVar.b());
                    } else if (!AbstractC13042fc3.d(lw, LW.b.a)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(LW lw, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1482a) create(lw, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1481a(C19528qW c19528qW, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c19528qW;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1481a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC10258bL6 interfaceC10258bL6Z0 = this.c.H().Z0();
                    C1482a c1482a = new C1482a(this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC10258bL6Z0, c1482a, this) == objE) {
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
                return ((C1481a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = C19528qW.this.new a(interfaceC20295rm1);
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
            AbstractC10533bm0.d((InterfaceC20315ro1) this.c, null, null, new C1481a(C19528qW.this, null), 3, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.qW$b */
    public static final class b {
        private b() {
        }

        public final int a() {
            return C19528qW.s;
        }

        public final int b() {
            return C19528qW.r;
        }

        public final int c() {
            return C19528qW.t;
        }

        public final int d() {
            return C19528qW.u;
        }

        public final com.facebook.shimmer.a e(Context context) {
            AbstractC13042fc3.i(context, "<this>");
            com.facebook.shimmer.a aVarA = ((a.c) ((a.c) new a.c().x(OY0.b(context, AbstractC21139tA5.n500)).y(OY0.b(context, AbstractC21139tA5.n100)).j(1000L)).h(0)).a();
            AbstractC13042fc3.h(aVarA, "build(...)");
            return aVarA;
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.qW$c */
    public static final class c extends GridLayoutManager.b {

        /* renamed from: ir.nasim.qW$c$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[OW.values().length];
                try {
                    iArr[OW.c.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[OW.f.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        c() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int f(int i) {
            int i2 = a.a[OW.b.a(C19528qW.this.E().getItemViewType(i)).ordinal()];
            return (i2 == 1 || i2 == 2) ? 6 : 1;
        }
    }

    /* renamed from: ir.nasim.qW$d */
    public static final class d extends RecyclerView.t {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i) {
            AbstractC13042fc3.i(recyclerView, "recyclerView");
            super.a(recyclerView, i);
            if (i != 0) {
                C19528qW.this.P(recyclerView);
            } else {
                C19528qW.R(C19528qW.this, 0, 1, null);
                C19528qW.this.O(recyclerView);
            }
        }
    }

    static {
        int iC = AbstractC8943Xx1.c(4);
        t = iC;
        u = AbstractC8943Xx1.c(25) + (iC * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C19528qW(View view, final ViewGroup viewGroup, InterfaceC18633oz3 interfaceC18633oz3, SA2 sa2) {
        super(new C7140Ql1(view, viewGroup, new Point(AbstractC8943Xx1.c(30), AbstractC8943Xx1.c(-30)), new RS4(0.0f, 0.0f, 0.0f, 0.0f), true, AbstractC8943Xx1.c(50), AbstractC8943Xx1.c(50), AbstractC8943Xx1.c(16), false, 256, null), LayoutInflater.from(new ContextThemeWrapper(viewGroup.getContext(), AbstractC23035wE5.Theme_Bale_Base)).inflate(LC5.badge_context_menu, (ViewGroup) null), AbstractC8943Xx1.c(286), AbstractC8943Xx1.c(291));
        AbstractC13042fc3.i(view, "anchor");
        AbstractC13042fc3.i(viewGroup, "container");
        AbstractC13042fc3.i(interfaceC18633oz3, "lifecycleOwner");
        AbstractC13042fc3.i(sa2, "onDismiss");
        this.d = interfaceC18633oz3;
        this.e = sa2;
        C20119rW c20119rWA = C20119rW.a(getContentView());
        this.f = c20119rWA;
        AbstractC13042fc3.f(c20119rWA);
        this.g = c20119rWA;
        this.j = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.jW
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C19528qW.C(this.a);
            }
        });
        this.k = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.kW
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C19528qW.S(this.a);
            }
        });
        this.l = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.lW
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C19528qW.N(viewGroup);
            }
        });
        this.m = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.mW
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C19528qW.A(this.a);
            }
        });
        setInputMethodMode(2);
        setAnimationStyle(AbstractC23035wE5.Bale_BadgeMenu_Animation);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: ir.nasim.nW
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                C19528qW.p(this.a);
            }
        });
        M();
        this.n = AbstractC10533bm0.d(AbstractC19224pz3.a(interfaceC18633oz3), null, null, new a(null), 3, null);
        H().Y0();
        this.o = Long.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C14802iW A(final C19528qW c19528qW) {
        AbstractC13042fc3.i(c19528qW, "this$0");
        return new C14802iW(c19528qW.d, new UA2() { // from class: ir.nasim.pW
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C19528qW.B(this.a, (HW.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B(C19528qW c19528qW, HW.a aVar) {
        AbstractC13042fc3.i(c19528qW, "this$0");
        AbstractC13042fc3.i(aVar, "badge");
        c19528qW.H().d1(aVar.c(), aVar.h());
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6641Oi7 C(final C19528qW c19528qW) {
        AbstractC13042fc3.i(c19528qW, "this$0");
        return new C6641Oi7(c19528qW.d, new InterfaceC14603iB2() { // from class: ir.nasim.oW
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return C19528qW.D(this.a, (AbstractC5909Li7.a) obj, ((Integer) obj2).intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 D(C19528qW c19528qW, AbstractC5909Li7.a aVar, int i) {
        AbstractC13042fc3.i(c19528qW, "this$0");
        AbstractC13042fc3.i(aVar, "tab");
        TabLayoutRecycler.u0(c19528qW.g.e, i, false, 2, null);
        c19528qW.g.d.stopScroll();
        c19528qW.I(c19528qW.H().a1(aVar.d()), AbstractC8943Xx1.b(-1.0f));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C14802iW E() {
        return (C14802iW) this.m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C6641Oi7 F() {
        return (C6641Oi7) this.j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C17468n10 G() {
        return (C17468n10) this.l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MW H() {
        return (MW) this.k.getValue();
    }

    private final C19938rB7 I(int i, int i2) {
        C8209Uz3 c8209Uz3;
        GridLayoutManager gridLayoutManager = this.i;
        if (gridLayoutManager == null || (c8209Uz3 = this.h) == null) {
            return null;
        }
        c8209Uz3.p(i);
        c8209Uz3.x(i2);
        gridLayoutManager.M1(c8209Uz3);
        return C19938rB7.a;
    }

    private final BadgeRecyclerView J() {
        C20119rW c20119rW = this.g;
        BadgeRecyclerView badgeRecyclerView = c20119rW.d;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(c20119rW.getRoot().getContext(), 6);
        gridLayoutManager.k3(new c());
        badgeRecyclerView.setLayoutManager(gridLayoutManager);
        this.h = new C8209Uz3(badgeRecyclerView.getContext(), 2);
        this.i = gridLayoutManager;
        AbstractC13042fc3.h(badgeRecyclerView, "apply(...)");
        return badgeRecyclerView;
    }

    private final BadgeRecyclerView K() {
        BadgeRecyclerView badgeRecyclerView = this.g.d;
        badgeRecyclerView.setAdapter(E());
        badgeRecyclerView.setItemAnimator(null);
        badgeRecyclerView.addOnScrollListener(new d());
        J();
        AbstractC13042fc3.h(badgeRecyclerView, "apply(...)");
        return badgeRecyclerView;
    }

    private final void L() {
        TabLayoutRecycler tabLayoutRecycler = this.g.e;
        tabLayoutRecycler.setIndicatorWidth(u);
        tabLayoutRecycler.setAdapter(F());
    }

    private final void M() {
        L();
        K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17468n10 N(ViewGroup viewGroup) {
        AbstractC13042fc3.i(viewGroup, "$container");
        return new C17468n10(viewGroup, null, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(RecyclerView recyclerView) {
        int iD2;
        int iG2;
        RecyclerView.p layoutManager = recyclerView.getLayoutManager();
        GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
        if (gridLayoutManager == null || (iD2 = gridLayoutManager.d2()) > (iG2 = gridLayoutManager.g2())) {
            return;
        }
        while (true) {
            RecyclerView.C cFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(iD2);
            if (cFindViewHolderForAdapterPosition instanceof RW.a) {
                ((RW.a) cFindViewHolderForAdapterPosition).H0();
            }
            if (iD2 == iG2) {
                return;
            } else {
                iD2++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(RecyclerView recyclerView) {
        int iD2;
        int iG2;
        RecyclerView.p layoutManager = recyclerView.getLayoutManager();
        GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
        if (gridLayoutManager == null || (iD2 = gridLayoutManager.d2()) > (iG2 = gridLayoutManager.g2())) {
            return;
        }
        while (true) {
            RecyclerView.C cFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(iD2);
            if (cFindViewHolderForAdapterPosition instanceof RW.a) {
                ((RW.a) cFindViewHolderForAdapterPosition).J0();
            }
            if (iD2 == iG2) {
                return;
            } else {
                iD2++;
            }
        }
    }

    private final void Q(int i) {
        HW hw;
        if (i == -1 || (hw = (HW) E().z().get(i)) == null || this.o == hw.a()) {
            return;
        }
        this.o = hw.a();
        this.g.e.t0(AbstractC23053wG5.e(H().b1(hw.a()), 0), false);
    }

    static /* synthetic */ void R(C19528qW c19528qW, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            GridLayoutManager gridLayoutManager = c19528qW.i;
            i = gridLayoutManager != null ? gridLayoutManager.d2() : 0;
        }
        c19528qW.Q(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MW S(C19528qW c19528qW) {
        AbstractC13042fc3.i(c19528qW, "this$0");
        InterfaceC18633oz3 interfaceC18633oz3 = c19528qW.d;
        AbstractC13042fc3.g(interfaceC18633oz3, "null cannot be cast to non-null type androidx.lifecycle.ViewModelStoreOwner");
        return (MW) new androidx.lifecycle.G((InterfaceC15408jX7) interfaceC18633oz3).b(MW.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(C19528qW c19528qW) {
        AbstractC13042fc3.i(c19528qW, "this$0");
        c19528qW.e.invoke();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        H().c1();
        InterfaceC13730gj3 interfaceC13730gj3 = this.n;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.n = null;
        this.g.d.stopScroll();
        this.g.d.clearOnScrollListeners();
        this.g.d.setAdapter(null);
        this.g.e.setAdapter(null);
        this.h = null;
        this.i = null;
        this.f = null;
        super.dismiss();
    }

    @Override // ir.nasim.AbstractC5462Jl1
    public void e(int i) {
        if (isShowing()) {
            return;
        }
        super.e(i);
    }

    @Override // ir.nasim.AbstractC5462Jl1
    public void h() {
        if (isShowing()) {
            return;
        }
        super.h();
    }
}
