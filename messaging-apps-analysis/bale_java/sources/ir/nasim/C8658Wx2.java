package ir.nasim;

import android.view.View;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.Wx2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C8658Wx2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ComposeView b;

    private C8658Wx2(ConstraintLayout constraintLayout, ComposeView composeView) {
        this.a = constraintLayout;
        this.b = composeView;
    }

    public static C8658Wx2 a(View view) {
        int i = AbstractC9582aC5.pollComposeView;
        ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
        if (composeView != null) {
            return new C8658Wx2((ConstraintLayout) view, composeView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
