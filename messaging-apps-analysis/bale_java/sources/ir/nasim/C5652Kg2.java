package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import ir.nasim.core.network.sslpinning.SecureWebView;

/* renamed from: ir.nasim.Kg2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C5652Kg2 implements InterfaceC9764aW7 {
    private final CoordinatorLayout a;
    public final ComposeView b;
    public final SecureWebView c;

    private C5652Kg2(CoordinatorLayout coordinatorLayout, ComposeView composeView, SecureWebView secureWebView) {
        this.a = coordinatorLayout;
        this.b = composeView;
        this.c = secureWebView;
    }

    public static C5652Kg2 a(View view) {
        int i = AbstractC13426gC5.compose_view;
        ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
        if (composeView != null) {
            i = AbstractC13426gC5.live_web_view;
            SecureWebView secureWebView = (SecureWebView) AbstractC11738dW7.a(view, i);
            if (secureWebView != null) {
                return new C5652Kg2((CoordinatorLayout) view, composeView, secureWebView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C5652Kg2 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C5652Kg2 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(IC5.features_live_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CoordinatorLayout getRoot() {
        return this.a;
    }
}
