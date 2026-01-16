package ir.nasim;

import android.view.View;
import android.widget.LinearLayout;
import androidx.compose.ui.platform.ComposeView;
import ir.nasim.components.appbar.view.BaleToolbar;

/* renamed from: ir.nasim.Xx2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8944Xx2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final ComposeView b;
    public final BaleToolbar c;

    private C8944Xx2(LinearLayout linearLayout, ComposeView composeView, BaleToolbar baleToolbar) {
        this.a = linearLayout;
        this.b = composeView;
        this.c = baleToolbar;
    }

    public static C8944Xx2 a(View view) {
        int i = BC5.compose_container;
        ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
        if (composeView != null) {
            i = BC5.money_request_intro_toolbar;
            BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
            if (baleToolbar != null) {
                return new C8944Xx2((LinearLayout) view, composeView, baleToolbar);
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
