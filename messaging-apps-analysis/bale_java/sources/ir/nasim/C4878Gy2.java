package ir.nasim;

import android.view.View;
import android.widget.LinearLayout;
import androidx.compose.ui.platform.ComposeView;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.components.appbar.view.BaleToolbar;

/* renamed from: ir.nasim.Gy2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4878Gy2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final ComposeView b;
    public final AppBarLayout c;
    public final BaleToolbar d;

    private C4878Gy2(LinearLayout linearLayout, ComposeView composeView, AppBarLayout appBarLayout, BaleToolbar baleToolbar) {
        this.a = linearLayout;
        this.b = composeView;
        this.c = appBarLayout;
        this.d = baleToolbar;
    }

    public static C4878Gy2 a(View view) {
        int i = BC5.compose_container;
        ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
        if (composeView != null) {
            i = BC5.money_request_intro_appbar;
            AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
            if (appBarLayout != null) {
                i = BC5.money_request_intro_toolbar;
                BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                if (baleToolbar != null) {
                    return new C4878Gy2((LinearLayout) view, composeView, appBarLayout, baleToolbar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
