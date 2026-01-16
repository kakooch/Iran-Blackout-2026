package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.ui.platform.ComposeView;

/* renamed from: ir.nasim.ox2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C18614ox2 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final ComposeView b;

    private C18614ox2(FrameLayout frameLayout, ComposeView composeView) {
        this.a = frameLayout;
        this.b = composeView;
    }

    public static C18614ox2 a(View view) {
        int i = AbstractC9582aC5.composeView;
        ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
        if (composeView != null) {
            return new C18614ox2((FrameLayout) view, composeView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C18614ox2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC10185bD5.fragment_anonymous_contact_shared_group, viewGroup, false);
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
