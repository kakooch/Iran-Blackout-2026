package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.components.appbar.view.BaleToolbar;

/* renamed from: ir.nasim.Hy2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5112Hy2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final AppBarLayout b;
    public final RecyclerView c;
    public final SwipeRefreshLayout d;
    public final BaleToolbar e;

    private C5112Hy2(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, BaleToolbar baleToolbar) {
        this.a = constraintLayout;
        this.b = appBarLayout;
        this.c = recyclerView;
        this.d = swipeRefreshLayout;
        this.e = baleToolbar;
    }

    public static C5112Hy2 a(View view) {
        int i = BC5.market_more_appbar;
        AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
        if (appBarLayout != null) {
            i = BC5.markets;
            RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
            if (recyclerView != null) {
                i = BC5.refreshLayout;
                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) AbstractC11738dW7.a(view, i);
                if (swipeRefreshLayout != null) {
                    i = BC5.toolbar;
                    BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                    if (baleToolbar != null) {
                        return new C5112Hy2((ConstraintLayout) view, appBarLayout, recyclerView, swipeRefreshLayout, baleToolbar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C5112Hy2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_more_market_items, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
