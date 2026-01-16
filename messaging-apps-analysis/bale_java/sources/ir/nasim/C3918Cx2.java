package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;

/* renamed from: ir.nasim.Cx2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3918Cx2 implements InterfaceC9764aW7 {
    private final ComposeView a;
    public final ComposeView b;

    private C3918Cx2(ComposeView composeView, ComposeView composeView2) {
        this.a = composeView;
        this.b = composeView2;
    }

    public static C3918Cx2 a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        ComposeView composeView = (ComposeView) view;
        return new C3918Cx2(composeView, composeView);
    }

    public static C3918Cx2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_call_preview, viewGroup, false);
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
