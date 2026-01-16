package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.ui.platform.ComposeView;

/* loaded from: classes4.dex */
public final class GI4 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final ComposeView b;
    public final FrameLayout c;

    private GI4(FrameLayout frameLayout, ComposeView composeView, FrameLayout frameLayout2) {
        this.a = frameLayout;
        this.b = composeView;
        this.c = frameLayout2;
    }

    public static GI4 a(View view) {
        int i = YB5.cView;
        ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
        if (composeView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return new GI4(frameLayout, composeView, frameLayout);
    }

    public static GI4 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC9591aD5.on_board_separator, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
