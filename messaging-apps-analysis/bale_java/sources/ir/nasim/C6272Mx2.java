package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.components.appbar.view.DrawerToolbar;

/* renamed from: ir.nasim.Mx2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C6272Mx2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ConstraintLayout b;
    public final AppBarLayout c;
    public final RecyclerView d;
    public final C4475Fh1 e;
    public final TextView f;
    public final C14929ij1 g;
    public final ProgressBar h;
    public final C9063Yi1 i;
    public final FrameLayout j;
    public final View k;
    public final DrawerToolbar l;
    public final C7356Rj1 m;

    private C6272Mx2(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppBarLayout appBarLayout, RecyclerView recyclerView, C4475Fh1 c4475Fh1, TextView textView, C14929ij1 c14929ij1, ProgressBar progressBar, C9063Yi1 c9063Yi1, FrameLayout frameLayout, View view, DrawerToolbar drawerToolbar, C7356Rj1 c7356Rj1) {
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = appBarLayout;
        this.d = recyclerView;
        this.e = c4475Fh1;
        this.f = textView;
        this.g = c14929ij1;
        this.h = progressBar;
        this.i = c9063Yi1;
        this.j = frameLayout;
        this.k = view;
        this.l = drawerToolbar;
        this.m = c7356Rj1;
    }

    public static C6272Mx2 a(View view) {
        View viewA;
        View viewA2;
        View viewA3;
        View viewA4;
        View viewA5;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = AbstractC10176bC5.contacts_appbar;
        AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
        if (appBarLayout != null) {
            i = AbstractC10176bC5.container;
            RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
            if (recyclerView != null && (viewA = AbstractC11738dW7.a(view, (i = AbstractC10176bC5.empty_list_place_holder))) != null) {
                C4475Fh1 c4475Fh1A = C4475Fh1.a(viewA);
                i = AbstractC10176bC5.loading_text;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null && (viewA2 = AbstractC11738dW7.a(view, (i = AbstractC10176bC5.permission_needed_place_holder))) != null) {
                    C14929ij1 c14929ij1A = C14929ij1.a(viewA2);
                    i = AbstractC10176bC5.progress_bar;
                    ProgressBar progressBar = (ProgressBar) AbstractC11738dW7.a(view, i);
                    if (progressBar != null && (viewA3 = AbstractC11738dW7.a(view, (i = AbstractC10176bC5.refresh_layout))) != null) {
                        C9063Yi1 c9063Yi1A = C9063Yi1.a(viewA3);
                        i = AbstractC10176bC5.refresh_sync_loading;
                        FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
                        if (frameLayout != null && (viewA4 = AbstractC11738dW7.a(view, (i = AbstractC10176bC5.snack_bar_anchor_view))) != null) {
                            i = AbstractC10176bC5.toolbar;
                            DrawerToolbar drawerToolbar = (DrawerToolbar) AbstractC11738dW7.a(view, i);
                            if (drawerToolbar != null && (viewA5 = AbstractC11738dW7.a(view, (i = AbstractC10176bC5.top_options))) != null) {
                                return new C6272Mx2(constraintLayout, constraintLayout, appBarLayout, recyclerView, c4475Fh1A, textView, c14929ij1A, progressBar, c9063Yi1A, frameLayout, viewA4, drawerToolbar, C7356Rj1.a(viewA5));
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C6272Mx2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC10801cD5.fragment_contacts, viewGroup, false);
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
