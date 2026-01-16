package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: classes4.dex */
public final class NU2 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final FrameLayout b;

    private NU2(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.a = frameLayout;
        this.b = frameLayout2;
    }

    public static NU2 a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return new NU2(frameLayout, frameLayout);
    }

    public static NU2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC9591aD5.header_ongoing_separator_item, viewGroup, false);
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
