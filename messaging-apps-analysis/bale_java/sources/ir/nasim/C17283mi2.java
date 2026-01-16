package ir.nasim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.facebook.shimmer.a;
import ir.nasim.AbstractC15520jj2;
import ir.nasim.O98;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.Iterator;

/* renamed from: ir.nasim.mi2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C17283mi2 extends JA2 {
    public static final a Q0 = new a(null);
    public static final int R0 = 8;
    private static final com.facebook.shimmer.a S0 = ((a.c) ((a.c) ((a.c) ((a.c) ((a.c) new a.c().h(0)).f(0.3f)).n(0.6f)).r(-1)).e(true)).a();
    private final C11258ci2 M0;
    private final O98 N0;
    private final boolean O0;
    private C17874ni2 P0;

    /* renamed from: ir.nasim.mi2$a */
    public static final class a {
        private a() {
        }

        public final C17283mi2 a(ViewGroup viewGroup, InterfaceC13138fj2 interfaceC13138fj2, O98 o98) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(interfaceC13138fj2, "feedListener");
            C11258ci2 c11258ci2C = C11258ci2.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c11258ci2C, "inflate(...)");
            return new C17283mi2(c11258ci2C, interfaceC13138fj2, o98, false);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.mi2$b */
    public static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        public b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Object obj) {
            return Boolean.valueOf(obj instanceof ShimmerFrameLayout);
        }
    }

    /* renamed from: ir.nasim.mi2$c */
    public static final class c extends AbstractC17457n0 {
        c() {
        }

        @Override // ir.nasim.InterfaceC25103zk1
        public String b(Context context, int i, String str, boolean z) {
            AbstractC13042fc3.i(context, "context");
            C19406qI3.g("BaseFeedHolder", "formatForDialog", new Object[0]);
            return "";
        }

        @Override // ir.nasim.AbstractC17457n0
        public C23345wl7 l() {
            C19406qI3.g("BaseFeedHolder", "getTextContent", new Object[0]);
            return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C17283mi2(C11258ci2 c11258ci2, InterfaceC13138fj2 interfaceC13138fj2, O98 o98, boolean z) {
        super(o98, c11258ci2, interfaceC13138fj2);
        AbstractC13042fc3.i(c11258ci2, "binding");
        AbstractC13042fc3.i(interfaceC13138fj2, "feedListener");
        this.M0 = c11258ci2;
        this.N0 = o98;
        this.O0 = z;
        this.P0 = C17874ni2.a(N3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 M3(C17283mi2 c17283mi2, View view) {
        AbstractC13042fc3.i(c17283mi2, "this$0");
        AbstractC13042fc3.i(view, "it");
        c17283mi2.s1().a();
        return C19938rB7.a;
    }

    private final View N3() {
        l1().y.setLayoutResource(HC5.feed_full_screen_shimmer_holder);
        View viewInflate = l1().y.inflate();
        AbstractC13042fc3.f(viewInflate);
        return viewInflate;
    }

    public void K3(C5886Lg2 c5886Lg2, AbstractC15520jj2.g gVar) {
        L93 l93F;
        AbstractC13042fc3.i(c5886Lg2, "feed");
        AbstractC13042fc3.i(gVar, DialogEntity.COLUMN_MESSAGE);
        C17874ni2 c17874ni2 = this.P0;
        C17874ni2 c17874ni22 = null;
        if (c17874ni2 == null) {
            AbstractC13042fc3.y("shimmerBinding");
            c17874ni2 = null;
        }
        ConstraintLayout root = c17874ni2.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        InterfaceC23384wp6 interfaceC23384wp6R = AbstractC11342cq6.r(NW7.a(root), b.e);
        AbstractC13042fc3.g(interfaceC23384wp6R, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        Iterator it = interfaceC23384wp6R.iterator();
        while (it.hasNext()) {
            ((ShimmerFrameLayout) it.next()).c(S0);
        }
        View rootView = l1().y.getRootView();
        AbstractC13042fc3.h(rootView, "getRootView(...)");
        int i = 0;
        rootView.setVisibility(0);
        C17874ni2 c17874ni23 = this.P0;
        if (c17874ni23 == null) {
            AbstractC13042fc3.y("shimmerBinding");
            c17874ni23 = null;
        }
        BaleToolbar baleToolbar = c17874ni23.i;
        AbstractC13042fc3.h(baleToolbar, "toolbarPlaceholder");
        ViewGroup.LayoutParams layoutParams = baleToolbar.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        O98 o98 = this.N0;
        if (o98 != null && (l93F = o98.f(O98.m.h())) != null) {
            i = l93F.b;
        }
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, i, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        baleToolbar.setLayoutParams(marginLayoutParams);
        C17874ni2 c17874ni24 = this.P0;
        if (c17874ni24 == null) {
            AbstractC13042fc3.y("shimmerBinding");
        } else {
            c17874ni22 = c17874ni24;
        }
        BaleToolbar.setHasBackButtonClickListener$default(c17874ni22.i, true, false, new UA2() { // from class: ir.nasim.li2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C17283mi2.M3(this.a, (View) obj);
            }
        }, 2, null);
    }

    @Override // ir.nasim.AbstractC13019fa0
    public AbstractC17457n0 T0() {
        return new c();
    }

    @Override // ir.nasim.AbstractC13019fa0
    /* renamed from: l3 */
    public C11258ci2 l1() {
        return this.M0;
    }

    @Override // ir.nasim.AbstractC13019fa0
    public boolean n1() {
        return this.O0;
    }
}
