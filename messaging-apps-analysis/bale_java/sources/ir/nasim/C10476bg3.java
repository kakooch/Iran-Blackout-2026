package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.ui.platform.ComposeView;

/* renamed from: ir.nasim.bg3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10476bg3 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final ComposeView b;

    private C10476bg3(FrameLayout frameLayout, ComposeView composeView) {
        this.a = frameLayout;
        this.b = composeView;
    }

    public static C10476bg3 a(View view) {
        int i = BC5.compose;
        ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
        if (composeView != null) {
            return new C10476bg3((FrameLayout) view, composeView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C10476bg3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_selected_contact, viewGroup, false);
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
