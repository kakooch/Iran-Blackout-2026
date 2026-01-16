package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.skydoves.balloon.radius.RadiusLayout;
import com.skydoves.balloon.vectortext.VectorTextView;

/* loaded from: classes3.dex */
public final class P20 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final FrameLayout b;
    public final ImageView c;
    public final RadiusLayout d;
    public final FrameLayout e;
    public final VectorTextView f;
    public final FrameLayout g;

    private P20(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, RadiusLayout radiusLayout, FrameLayout frameLayout3, VectorTextView vectorTextView, FrameLayout frameLayout4) {
        this.a = frameLayout;
        this.b = frameLayout2;
        this.c = imageView;
        this.d = radiusLayout;
        this.e = frameLayout3;
        this.f = vectorTextView;
        this.g = frameLayout4;
    }

    public static P20 a(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i = XB5.balloon_arrow;
        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
        if (imageView != null) {
            i = XB5.balloon_card;
            RadiusLayout radiusLayout = (RadiusLayout) AbstractC11738dW7.a(view, i);
            if (radiusLayout != null) {
                i = XB5.balloon_content;
                FrameLayout frameLayout2 = (FrameLayout) AbstractC11738dW7.a(view, i);
                if (frameLayout2 != null) {
                    i = XB5.balloon_text;
                    VectorTextView vectorTextView = (VectorTextView) AbstractC11738dW7.a(view, i);
                    if (vectorTextView != null) {
                        i = XB5.balloon_wrapper;
                        FrameLayout frameLayout3 = (FrameLayout) AbstractC11738dW7.a(view, i);
                        if (frameLayout3 != null) {
                            return new P20(frameLayout, frameLayout, imageView, radiusLayout, frameLayout2, vectorTextView, frameLayout3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static P20 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(ZC5.balloon_layout_body, viewGroup, false);
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
