package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.designsystem.ImageViewCrossFade;
import ir.nasim.features.conversation.messages.content.CircleProgressBar;

/* renamed from: ir.nasim.Cl, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3807Cl implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ImageViewCrossFade b;
    public final CircleProgressBar c;
    public final FrameLayout d;
    public final ImageView e;

    private C3807Cl(ConstraintLayout constraintLayout, ImageViewCrossFade imageViewCrossFade, CircleProgressBar circleProgressBar, FrameLayout frameLayout, ImageView imageView) {
        this.a = constraintLayout;
        this.b = imageViewCrossFade;
        this.c = circleProgressBar;
        this.d = frameLayout;
        this.e = imageView;
    }

    public static C3807Cl a(View view) {
        int i = AbstractC12808fC5.album_item_cross_fade_iv;
        ImageViewCrossFade imageViewCrossFade = (ImageViewCrossFade) AbstractC11738dW7.a(view, i);
        if (imageViewCrossFade != null) {
            i = AbstractC12808fC5.feed_progress_photo;
            CircleProgressBar circleProgressBar = (CircleProgressBar) AbstractC11738dW7.a(view, i);
            if (circleProgressBar != null) {
                i = AbstractC12808fC5.feed_state_container_photo;
                FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
                if (frameLayout != null) {
                    i = AbstractC12808fC5.feed_state_photo_iv;
                    ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView != null) {
                        return new C3807Cl((ConstraintLayout) view, imageViewCrossFade, circleProgressBar, frameLayout, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C3807Cl c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(HC5.album_photo_item_holder, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
