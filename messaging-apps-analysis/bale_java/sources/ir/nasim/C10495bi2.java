package ir.nasim;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.features.conversation.messages.content.CircleProgressBar;

/* renamed from: ir.nasim.bi2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C10495bi2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final FrameLayout b;
    public final CircleProgressBar c;
    public final FrameLayout d;
    public final ImageView e;
    public final ImageView f;

    private C10495bi2(ConstraintLayout constraintLayout, FrameLayout frameLayout, CircleProgressBar circleProgressBar, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2) {
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = circleProgressBar;
        this.d = frameLayout2;
        this.e = imageView;
        this.f = imageView2;
    }

    public static C10495bi2 a(View view) {
        int i = AbstractC12808fC5.feed_gif_parent;
        FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
        if (frameLayout != null) {
            i = AbstractC12808fC5.feed_progress_gif;
            CircleProgressBar circleProgressBar = (CircleProgressBar) AbstractC11738dW7.a(view, i);
            if (circleProgressBar != null) {
                i = AbstractC12808fC5.feed_state_container_gif;
                FrameLayout frameLayout2 = (FrameLayout) AbstractC11738dW7.a(view, i);
                if (frameLayout2 != null) {
                    i = AbstractC12808fC5.feed_state_gif_iv;
                    ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView != null) {
                        i = AbstractC12808fC5.gif_container;
                        ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                        if (imageView2 != null) {
                            return new C10495bi2((ConstraintLayout) view, frameLayout, circleProgressBar, frameLayout2, imageView, imageView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
