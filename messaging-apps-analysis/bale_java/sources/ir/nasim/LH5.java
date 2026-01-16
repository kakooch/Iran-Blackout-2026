package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.components.appbar.view.BaleToolbar;

/* loaded from: classes.dex */
public final class LH5 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final AppBarLayout b;
    public final BaleToolbar c;
    public final RecyclerView d;

    private LH5(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, BaleToolbar baleToolbar, RecyclerView recyclerView) {
        this.a = constraintLayout;
        this.b = appBarLayout;
        this.c = baleToolbar;
        this.d = recyclerView;
    }

    public static LH5 a(View view) {
        int i = AbstractC15217jC5.reaction_settings_appbar;
        AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
        if (appBarLayout != null) {
            i = AbstractC15217jC5.reaction_settings_toolbar;
            BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
            if (baleToolbar != null) {
                i = AbstractC15217jC5.recyclerView;
                RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                if (recyclerView != null) {
                    return new LH5((ConstraintLayout) view, appBarLayout, baleToolbar, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static LH5 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(MC5.reaction_settings_fragment, viewGroup, false);
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
