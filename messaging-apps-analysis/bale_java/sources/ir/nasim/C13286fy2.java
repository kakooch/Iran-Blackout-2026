package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.components.appbar.view.BaleToolbar;

/* renamed from: ir.nasim.fy2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13286fy2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final RecyclerView b;
    public final AppBarLayout c;
    public final BaleToolbar d;
    public final ProgressBar e;

    private C13286fy2(ConstraintLayout constraintLayout, RecyclerView recyclerView, AppBarLayout appBarLayout, BaleToolbar baleToolbar, ProgressBar progressBar) {
        this.a = constraintLayout;
        this.b = recyclerView;
        this.c = appBarLayout;
        this.d = baleToolbar;
        this.e = progressBar;
    }

    public static C13286fy2 a(View view) {
        int i = BC5.collection;
        RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
        if (recyclerView != null) {
            i = BC5.exception_selector_appbar;
            AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
            if (appBarLayout != null) {
                i = BC5.exception_selector_toolbar;
                BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                if (baleToolbar != null) {
                    i = BC5.loadingProgress;
                    ProgressBar progressBar = (ProgressBar) AbstractC11738dW7.a(view, i);
                    if (progressBar != null) {
                        return new C13286fy2((ConstraintLayout) view, recyclerView, appBarLayout, baleToolbar, progressBar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C13286fy2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_exception_selector, viewGroup, false);
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
