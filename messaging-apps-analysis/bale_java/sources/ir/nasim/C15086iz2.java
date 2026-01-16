package ir.nasim;

import android.view.View;
import android.widget.LinearLayout;
import androidx.compose.ui.platform.ComposeView;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.components.appbar.view.BaleToolbar;

/* renamed from: ir.nasim.iz2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15086iz2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final ComposeView b;
    public final AppBarLayout c;
    public final BaleToolbar d;

    private C15086iz2(LinearLayout linearLayout, ComposeView composeView, AppBarLayout appBarLayout, BaleToolbar baleToolbar) {
        this.a = linearLayout;
        this.b = composeView;
        this.c = appBarLayout;
        this.d = baleToolbar;
    }

    public static C15086iz2 a(View view) {
        int i = BC5.composeView;
        ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
        if (composeView != null) {
            i = BC5.select_chat_appbar;
            AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
            if (appBarLayout != null) {
                i = BC5.select_chat_toolbar;
                BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                if (baleToolbar != null) {
                    return new C15086iz2((LinearLayout) view, composeView, appBarLayout, baleToolbar);
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
