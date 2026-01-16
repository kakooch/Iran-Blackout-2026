package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.components.appbar.view.BaleToolbar;

/* renamed from: ir.nasim.Ex2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C4386Ex2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final AppBarLayout b;
    public final ComposeView c;
    public final ComposeView d;
    public final BaleToolbar e;

    private C4386Ex2(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, ComposeView composeView, ComposeView composeView2, BaleToolbar baleToolbar) {
        this.a = constraintLayout;
        this.b = appBarLayout;
        this.c = composeView;
        this.d = composeView2;
        this.e = baleToolbar;
    }

    public static C4386Ex2 a(View view) {
        int i = AbstractC17581nC5.appBarLayout2;
        AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
        if (appBarLayout != null) {
            i = AbstractC17581nC5.composeView;
            ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
            if (composeView != null) {
                i = AbstractC17581nC5.ok_button;
                ComposeView composeView2 = (ComposeView) AbstractC11738dW7.a(view, i);
                if (composeView2 != null) {
                    i = AbstractC17581nC5.toolbar;
                    BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                    if (baleToolbar != null) {
                        return new C4386Ex2((ConstraintLayout) view, appBarLayout, composeView, composeView2, baleToolbar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C4386Ex2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(QC5.fragment_change_group_restriction, viewGroup, false);
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
