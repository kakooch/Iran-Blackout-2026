package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.components.appbar.view.BaleToolbar;

/* renamed from: ir.nasim.Lx2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C6038Lx2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final AppBarLayout b;
    public final ComposeView c;
    public final ComposeView d;
    public final ComposeView e;
    public final BaleToolbar f;

    private C6038Lx2(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, ComposeView composeView, ComposeView composeView2, ComposeView composeView3, BaleToolbar baleToolbar) {
        this.a = constraintLayout;
        this.b = appBarLayout;
        this.c = composeView;
        this.d = composeView2;
        this.e = composeView3;
        this.f = baleToolbar;
    }

    public static C6038Lx2 a(View view) {
        int i = AbstractC10176bC5.appBarLayout2;
        AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
        if (appBarLayout != null) {
            i = AbstractC10176bC5.composeToolbar;
            ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
            if (composeView != null) {
                i = AbstractC10176bC5.composeView;
                ComposeView composeView2 = (ComposeView) AbstractC11738dW7.a(view, i);
                if (composeView2 != null) {
                    i = AbstractC10176bC5.ok_button_selection;
                    ComposeView composeView3 = (ComposeView) AbstractC11738dW7.a(view, i);
                    if (composeView3 != null) {
                        i = AbstractC10176bC5.toolbar;
                        BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                        if (baleToolbar != null) {
                            return new C6038Lx2((ConstraintLayout) view, appBarLayout, composeView, composeView2, composeView3, baleToolbar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C6038Lx2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC10801cD5.fragment_contact_list_selection, viewGroup, false);
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
