package ir.nasim;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import ir.nasim.designsystem.ImageViewCrossFade;
import ir.nasim.features.conversation.messages.content.CircleProgressBar;

/* renamed from: ir.nasim.sj2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C20857sj2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final FrameLayout b;
    public final ImageViewCrossFade c;
    public final CircleProgressBar d;
    public final LottieAnimationView e;
    public final FrameLayout f;
    public final ImageView g;

    private C20857sj2(ConstraintLayout constraintLayout, FrameLayout frameLayout, ImageViewCrossFade imageViewCrossFade, CircleProgressBar circleProgressBar, LottieAnimationView lottieAnimationView, FrameLayout frameLayout2, ImageView imageView) {
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = imageViewCrossFade;
        this.d = circleProgressBar;
        this.e = lottieAnimationView;
        this.f = frameLayout2;
        this.g = imageView;
    }

    public static C20857sj2 a(View view) {
        int i = AbstractC12808fC5.feed_like_animation_container_photo;
        FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
        if (frameLayout != null) {
            i = AbstractC12808fC5.feed_photo_iv;
            ImageViewCrossFade imageViewCrossFade = (ImageViewCrossFade) AbstractC11738dW7.a(view, i);
            if (imageViewCrossFade != null) {
                i = AbstractC12808fC5.feed_progress_photo;
                CircleProgressBar circleProgressBar = (CircleProgressBar) AbstractC11738dW7.a(view, i);
                if (circleProgressBar != null) {
                    i = AbstractC12808fC5.feed_reaction_anim;
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) AbstractC11738dW7.a(view, i);
                    if (lottieAnimationView != null) {
                        i = AbstractC12808fC5.feed_state_container_photo;
                        FrameLayout frameLayout2 = (FrameLayout) AbstractC11738dW7.a(view, i);
                        if (frameLayout2 != null) {
                            i = AbstractC12808fC5.feed_state_photo_iv;
                            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                            if (imageView != null) {
                                return new C20857sj2((ConstraintLayout) view, frameLayout, imageViewCrossFade, circleProgressBar, lottieAnimationView, frameLayout2, imageView);
                            }
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
