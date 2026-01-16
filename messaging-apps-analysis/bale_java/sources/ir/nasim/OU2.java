package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* loaded from: classes4.dex */
public final class OU2 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final ImageView b;
    public final FrameLayout c;

    private OU2(FrameLayout frameLayout, ImageView imageView, FrameLayout frameLayout2) {
        this.a = frameLayout;
        this.b = imageView;
        this.c = frameLayout2;
    }

    public static OU2 a(View view) {
        int i = YB5.call_log_refresh;
        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
        if (imageView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return new OU2(frameLayout, imageView, frameLayout);
    }

    public static OU2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC9591aD5.header_separator_item, viewGroup, false);
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
