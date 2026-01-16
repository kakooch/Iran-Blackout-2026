package ir.nasim;

import android.view.View;
import android.widget.FrameLayout;
import androidx.compose.ui.platform.ComposeView;

/* renamed from: ir.nasim.hj2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C14320hj2 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final ComposeView b;

    private C14320hj2(FrameLayout frameLayout, ComposeView composeView) {
        this.a = frameLayout;
        this.b = composeView;
    }

    public static C14320hj2 a(View view) {
        int i = AbstractC12808fC5.cv_loading;
        ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
        if (composeView != null) {
            return new C14320hj2((FrameLayout) view, composeView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
