package ir.nasim;

import android.content.Context;
import android.graphics.Point;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.GM3;
import ir.nasim.GY;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes4.dex */
public final class GY extends AbstractC5462Jl1 {
    public static final b s = new b(null);
    public static final int t = 8;
    private static boolean u;
    private final View d;
    private final ViewGroup e;
    private final List f;
    private final List g;
    private final Point h;
    private final RS4 i;
    private final RJ4 j;
    private final boolean k;
    private final boolean l;
    private final Runnable m;
    private final Context n;
    private final GM3 o;
    private C6662Ol1 p;
    private final C6662Ol1 q;
    private final C9324Zl1 r;

    public static final class a {
        private final View a;
        private final ViewGroup b;
        private final RJ4 c;
        private Runnable d;
        private Point e;
        private RS4 f;
        private boolean g;
        private List h;
        private GM3 i;
        private boolean j;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(View view, ViewGroup viewGroup) {
            this(view, viewGroup, null, 4, null);
            AbstractC13042fc3.i(view, "anchor");
            AbstractC13042fc3.i(viewGroup, "container");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(a aVar) {
            AbstractC13042fc3.i(aVar, "this$0");
            Runnable runnable = aVar.d;
            if (runnable != null) {
                runnable.run();
            }
            GY.u = false;
        }

        public final GY b(AbstractC8081Ul1 abstractC8081Ul1) {
            AbstractC13042fc3.i(abstractC8081Ul1, "itemBuilder");
            View view = this.a;
            ViewGroup viewGroup = this.b;
            List listA = abstractC8081Ul1.a();
            List list = this.h;
            Point point = this.e;
            RS4 rs4 = this.f;
            boolean z = this.g;
            Runnable runnable = new Runnable() { // from class: ir.nasim.FY
                @Override // java.lang.Runnable
                public final void run() {
                    GY.a.c(this.a);
                }
            };
            return new GY(view, viewGroup, listA, list, point, rs4, this.c, z, this.j, runnable, null, this.i, 1024, null);
        }

        public final a d(boolean z) {
            this.g = z;
            return this;
        }

        public final a e(Runnable runnable) {
            AbstractC13042fc3.i(runnable, "onDismiss");
            this.d = runnable;
            return this;
        }

        public final a f(boolean z) {
            this.j = z;
            return this;
        }

        public final a g(RS4 rs4) {
            AbstractC13042fc3.i(rs4, "padding");
            this.f = rs4;
            return this;
        }

        public final a h(Point point) {
            AbstractC13042fc3.i(point, "point");
            this.e = point;
            return this;
        }

        public final a i(List list) {
            AbstractC13042fc3.i(list, "reactions");
            this.h = list;
            return this;
        }

        public final a j(GM3 gm3) {
            AbstractC13042fc3.i(gm3, "magazineSuggestItem");
            this.i = gm3;
            return this;
        }

        public a(View view, ViewGroup viewGroup, RJ4 rj4) {
            AbstractC13042fc3.i(view, "anchor");
            AbstractC13042fc3.i(viewGroup, "container");
            this.a = view;
            this.b = viewGroup;
            this.c = rj4;
            this.e = new Point(0, 0);
            this.f = new RS4(0.0f, 0.0f, 0.0f, 0.0f);
            this.h = AbstractC10360bX0.m();
            this.i = GM3.a.b;
            this.j = true;
        }

        public /* synthetic */ a(View view, ViewGroup viewGroup, RJ4 rj4, int i, ED1 ed1) {
            this(view, viewGroup, (i & 4) != 0 ? null : rj4);
        }
    }

    public static final class b {
        private b() {
        }

        public final boolean a() {
            return GY.u;
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* synthetic */ GY(View view, ViewGroup viewGroup, List list, List list2, Point point, RS4 rs4, RJ4 rj4, boolean z, boolean z2, Runnable runnable, Context context, GM3 gm3, int i, ED1 ed1) {
        this(view, viewGroup, list, list2, (i & 16) != 0 ? new Point(0, 0) : point, (i & 32) != 0 ? new RS4(0.0f, 0.0f, 0.0f, 0.0f) : rs4, rj4, (i & 128) != 0 ? false : z, (i & 256) != 0 ? true : z2, (i & 512) != 0 ? null : runnable, (i & 1024) != 0 ? new ContextThemeWrapper(viewGroup.getContext(), AbstractC17008mE5.Theme_Bale_Base) : context, gm3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(GY gy) {
        AbstractC13042fc3.i(gy, "this$0");
        Runnable runnable = gy.m;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q(GY gy) {
        AbstractC13042fc3.i(gy, "this$0");
        if (gy.l) {
            gy.dismiss();
        }
        return C19938rB7.a;
    }

    private final void r() {
        RecyclerView recyclerView = this.q.f;
        if (!this.g.isEmpty()) {
            recyclerView.setAdapter(new IG5(this.g, new RJ4() { // from class: ir.nasim.EY
                @Override // ir.nasim.RJ4
                public final void a(String str, boolean z) {
                    GY.s(this.a, str, z);
                }
            }));
            Iterator it = this.g.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (((C13471gH5) it.next()).d()) {
                    break;
                } else {
                    i++;
                }
            }
            int iMax = Math.max(i, 0);
            RecyclerView.p layoutManager = recyclerView.getLayoutManager();
            LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
            if (linearLayoutManager != null) {
                linearLayoutManager.E2(iMax, 0);
            }
        } else {
            AbstractC13042fc3.f(recyclerView);
            recyclerView.setVisibility(8);
        }
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(GY gy, String str, boolean z) {
        AbstractC13042fc3.i(gy, "this$0");
        AbstractC13042fc3.i(str, "emojiCode");
        RJ4 rj4 = gy.j;
        if (rj4 != null) {
            rj4.a(str, z);
        }
        gy.dismiss();
    }

    private final void t() {
        this.q.e.setTypeface(C6011Lu2.k());
        GM3 gm3 = this.o;
        if (AbstractC13042fc3.d(gm3, GM3.a.b)) {
            LinearLayout linearLayout = this.q.c;
            AbstractC13042fc3.h(linearLayout, "magazineSuggest");
            linearLayout.setVisibility(8);
            return;
        }
        if (gm3 instanceof GM3.b) {
            LinearLayout linearLayout2 = this.q.c;
            AbstractC13042fc3.h(linearLayout2, "magazineSuggest");
            linearLayout2.setVisibility(0);
            this.q.e.setText(this.n.getText(UD5.context_menu_vote));
            this.q.d.setImageResource(AbstractC24188yB5.ic_up_vote);
            this.q.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.BY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GY.u(this.a, view);
                }
            });
            return;
        }
        if (!(gm3 instanceof GM3.c)) {
            throw new NoWhenBranchMatchedException();
        }
        LinearLayout linearLayout3 = this.q.c;
        AbstractC13042fc3.h(linearLayout3, "magazineSuggest");
        linearLayout3.setVisibility(0);
        this.q.e.setText(this.n.getText(UD5.context_menu_voted));
        this.q.d.setImageResource(AbstractC24188yB5.ic_up_voted);
        this.q.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.CY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GY.v(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(GY gy, View view) {
        AbstractC13042fc3.i(gy, "this$0");
        ((GM3.b) gy.o).a().invoke();
        gy.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(GY gy, View view) {
        AbstractC13042fc3.i(gy, "this$0");
        ((GM3.c) gy.o).a().invoke();
        gy.dismiss();
    }

    private final void w() {
        RecyclerView recyclerView;
        ViewGroup.LayoutParams layoutParams;
        RecyclerView recyclerView2;
        ViewGroup.LayoutParams layoutParams2;
        RecyclerView recyclerView3;
        RecyclerView recyclerView4;
        LinearLayoutCompat root;
        C6662Ol1 c6662Ol1 = this.p;
        int measuredWidth = 0;
        if (c6662Ol1 != null && (root = c6662Ol1.getRoot()) != null) {
            root.measure(0, 0);
        }
        C6662Ol1 c6662Ol12 = this.p;
        int measuredWidth2 = (c6662Ol12 == null || (recyclerView4 = c6662Ol12.b) == null) ? 0 : recyclerView4.getMeasuredWidth();
        C6662Ol1 c6662Ol13 = this.p;
        if (c6662Ol13 != null && (recyclerView3 = c6662Ol13.f) != null) {
            measuredWidth = recyclerView3.getMeasuredWidth();
        }
        if (measuredWidth2 > measuredWidth) {
            C6662Ol1 c6662Ol14 = this.p;
            if (c6662Ol14 == null || (recyclerView2 = c6662Ol14.f) == null || (layoutParams2 = recyclerView2.getLayoutParams()) == null) {
                return;
            }
            layoutParams2.width = measuredWidth;
            return;
        }
        C6662Ol1 c6662Ol15 = this.p;
        if (c6662Ol15 == null || (recyclerView = c6662Ol15.f) == null || (layoutParams = recyclerView.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = measuredWidth2;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        this.q.f.setAdapter(null);
        this.p = null;
        super.dismiss();
    }

    @Override // ir.nasim.AbstractC5462Jl1
    public void e(int i) {
        if (u) {
            return;
        }
        super.e(i);
        u = true;
    }

    @Override // ir.nasim.AbstractC5462Jl1
    public void h() {
        if (u) {
            return;
        }
        super.h();
        u = true;
    }

    public final void x() {
        if (u) {
            return;
        }
        if (this.d.getWidth() == 0 || this.d.getHeight() == 0) {
            this.d.post(new Runnable() { // from class: ir.nasim.DY
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.h();
                }
            });
            return;
        }
        u = true;
        showAtLocation(this.d, 0, (AbstractC3742Cd6.d() - getContentView().getMeasuredWidth()) - ((int) ((12.0f * AbstractC3742Cd6.c()) + 0.5d)), (int) ((40.0f * AbstractC3742Cd6.c()) + 0.5d));
        if (this.k) {
            d();
        }
    }

    private GY(View view, ViewGroup viewGroup, List list, List list2, Point point, RS4 rs4, RJ4 rj4, boolean z, boolean z2, Runnable runnable, Context context, GM3 gm3) {
        super(new C7140Ql1(view, viewGroup, point, rs4, z, (int) ((76 * AbstractC3742Cd6.c()) + 0.5d), (int) ((24 * AbstractC3742Cd6.c()) + 0.5d), (int) ((16 * AbstractC3742Cd6.c()) + 0.5d), false, 256, null), LayoutInflater.from(context).inflate(TC5.context_menu, (ViewGroup) null), -2, -2);
        this.d = view;
        this.e = viewGroup;
        this.f = list;
        this.g = list2;
        this.h = point;
        this.i = rs4;
        this.j = rj4;
        this.k = z;
        this.l = z2;
        this.m = runnable;
        this.n = context;
        this.o = gm3;
        C6662Ol1 c6662Ol1A = C6662Ol1.a(getContentView());
        this.p = c6662Ol1A;
        AbstractC13042fc3.f(c6662Ol1A);
        this.q = c6662Ol1A;
        View viewFindViewById = getContentView().findViewById(AbstractC19354qC5.actionItemsRecyclerView);
        AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
        C9324Zl1 c9324Zl1 = new C9324Zl1((RecyclerView) viewFindViewById, new SA2() { // from class: ir.nasim.zY
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return GY.q(this.a);
            }
        });
        this.r = c9324Zl1;
        r();
        t();
        setInputMethodMode(2);
        setAnimationStyle(AbstractC17008mE5.Bale_ContextMenu_Animation);
        c9324Zl1.a(list);
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: ir.nasim.AY
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                GY.n(this.a);
            }
        });
    }
}
