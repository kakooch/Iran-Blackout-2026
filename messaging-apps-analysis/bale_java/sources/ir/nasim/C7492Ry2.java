package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;

/* renamed from: ir.nasim.Ry2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7492Ry2 implements InterfaceC9764aW7 {
    private final ComposeView a;

    private C7492Ry2(ComposeView composeView) {
        this.a = composeView;
    }

    public static C7492Ry2 a(View view) {
        if (view != null) {
            return new C7492Ry2((ComposeView) view);
        }
        throw new NullPointerException("rootView");
    }

    public static C7492Ry2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(KC5.fragment_onboarding, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ComposeView getRoot() {
        return this.a;
    }
}
