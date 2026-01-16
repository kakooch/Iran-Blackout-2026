package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.Iz2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C5355Iz2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ComposeView b;

    private C5355Iz2(ConstraintLayout constraintLayout, ComposeView composeView) {
        this.a = constraintLayout;
        this.b = composeView;
    }

    public static C5355Iz2 a(View view) {
        int i = AbstractC16990mC5.composeView;
        ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
        if (composeView != null) {
            return new C5355Iz2((ConstraintLayout) view, composeView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C5355Iz2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(OC5.fragment_two_step_verification, viewGroup, false);
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
