package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.appbar.AppBarLayout;

/* renamed from: ir.nasim.Ny2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6541Ny2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final AppBarLayout b;
    public final ComposeView c;
    public final ComposeView d;

    private C6541Ny2(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, ComposeView composeView, ComposeView composeView2) {
        this.a = constraintLayout;
        this.b = appBarLayout;
        this.c = composeView;
        this.d = composeView2;
    }

    public static C6541Ny2 a(View view) {
        int i = BC5.appBarLayout2;
        AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
        if (appBarLayout != null) {
            i = BC5.composeToolbar;
            ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
            if (composeView != null) {
                i = BC5.composeView;
                ComposeView composeView2 = (ComposeView) AbstractC11738dW7.a(view, i);
                if (composeView2 != null) {
                    return new C6541Ny2((ConstraintLayout) view, appBarLayout, composeView, composeView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C6541Ny2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_new_search, viewGroup, false);
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
