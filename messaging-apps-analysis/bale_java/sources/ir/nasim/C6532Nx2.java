package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.components.appbar.view.BaleToolbar;

/* renamed from: ir.nasim.Nx2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C6532Nx2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final AppBarLayout b;
    public final RecyclerView c;
    public final C17292mj1 d;
    public final BaleToolbar e;

    private C6532Nx2(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, RecyclerView recyclerView, C17292mj1 c17292mj1, BaleToolbar baleToolbar) {
        this.a = constraintLayout;
        this.b = appBarLayout;
        this.c = recyclerView;
        this.d = c17292mj1;
        this.e = baleToolbar;
    }

    public static C6532Nx2 a(View view) {
        View viewA;
        int i = AbstractC10176bC5.contact_search_appbar;
        AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
        if (appBarLayout != null) {
            i = AbstractC10176bC5.container;
            RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
            if (recyclerView != null && (viewA = AbstractC11738dW7.a(view, (i = AbstractC10176bC5.search_empty_list_place_holder))) != null) {
                C17292mj1 c17292mj1A = C17292mj1.a(viewA);
                i = AbstractC10176bC5.toolbar;
                BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                if (baleToolbar != null) {
                    return new C6532Nx2((ConstraintLayout) view, appBarLayout, recyclerView, c17292mj1A, baleToolbar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C6532Nx2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC10801cD5.fragment_contacts_search, viewGroup, false);
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
