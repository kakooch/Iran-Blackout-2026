package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.FragmentContainerView;

/* renamed from: ir.nasim.wx2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23458wx2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final FragmentContainerView b;
    public final ComposeView c;

    private C23458wx2(LinearLayout linearLayout, FragmentContainerView fragmentContainerView, ComposeView composeView) {
        this.a = linearLayout;
        this.b = fragmentContainerView;
        this.c = composeView;
    }

    public static C23458wx2 a(View view) {
        int i = AbstractC10792cC5.archived_dialog_fragment;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) AbstractC11738dW7.a(view, i);
        if (fragmentContainerView != null) {
            i = AbstractC10792cC5.archived_toolbar;
            ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
            if (composeView != null) {
                return new C23458wx2((LinearLayout) view, fragmentContainerView, composeView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C23458wx2 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C23458wx2 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC11565dD5.fragment_archived_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
