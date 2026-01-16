package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.components.appbar.view.DrawerToolbar;

/* renamed from: ir.nasim.Ky2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C5814Ky2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ComposeView b;
    public final ComposeView c;
    public final AppBarLayout d;
    public final DrawerToolbar e;

    private C5814Ky2(ConstraintLayout constraintLayout, ComposeView composeView, ComposeView composeView2, AppBarLayout appBarLayout, DrawerToolbar drawerToolbar) {
        this.a = constraintLayout;
        this.b = composeView;
        this.c = composeView2;
        this.d = appBarLayout;
        this.e = drawerToolbar;
    }

    public static C5814Ky2 a(View view) {
        int i = AbstractC10176bC5.composeToolbar;
        ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
        if (composeView != null) {
            i = AbstractC10176bC5.composeView;
            ComposeView composeView2 = (ComposeView) AbstractC11738dW7.a(view, i);
            if (composeView2 != null) {
                i = AbstractC10176bC5.contacts_appbar;
                AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
                if (appBarLayout != null) {
                    i = AbstractC10176bC5.toolbar;
                    DrawerToolbar drawerToolbar = (DrawerToolbar) AbstractC11738dW7.a(view, i);
                    if (drawerToolbar != null) {
                        return new C5814Ky2((ConstraintLayout) view, composeView, composeView2, appBarLayout, drawerToolbar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C5814Ky2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC10801cD5.fragment_new_contacts, viewGroup, false);
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
