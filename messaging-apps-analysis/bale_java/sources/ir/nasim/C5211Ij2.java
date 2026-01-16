package ir.nasim;

import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import ir.nasim.features.conversation.messages.content.CircleProgressBar;

/* renamed from: ir.nasim.Ij2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C5211Ij2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final View b;
    public final FrameLayout c;
    public final LinearLayout d;
    public final CircleProgressBar e;
    public final LottieAnimationView f;
    public final FrameLayout g;
    public final ImageView h;
    public final AspectRatioFrameLayout i;
    public final ImageView j;
    public final ImageView k;
    public final TextView l;
    public final TextView m;
    public final TextureView n;

    private C5211Ij2(ConstraintLayout constraintLayout, View view, FrameLayout frameLayout, LinearLayout linearLayout, CircleProgressBar circleProgressBar, LottieAnimationView lottieAnimationView, FrameLayout frameLayout2, ImageView imageView, AspectRatioFrameLayout aspectRatioFrameLayout, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2, TextureView textureView) {
        this.a = constraintLayout;
        this.b = view;
        this.c = frameLayout;
        this.d = linearLayout;
        this.e = circleProgressBar;
        this.f = lottieAnimationView;
        this.g = frameLayout2;
        this.h = imageView;
        this.i = aspectRatioFrameLayout;
        this.j = imageView2;
        this.k = imageView3;
        this.l = textView;
        this.m = textView2;
        this.n = textureView;
    }

    public static C5211Ij2 a(View view) {
        int i = AbstractC12808fC5.feedDim;
        View viewA = AbstractC11738dW7.a(view, i);
        if (viewA != null) {
            i = AbstractC12808fC5.feed_like_animation_container_photo;
            FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
            if (frameLayout != null) {
                i = AbstractC12808fC5.feed_play_again_container_video;
                LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                if (linearLayout != null) {
                    i = AbstractC12808fC5.feed_progress_video;
                    CircleProgressBar circleProgressBar = (CircleProgressBar) AbstractC11738dW7.a(view, i);
                    if (circleProgressBar != null) {
                        i = AbstractC12808fC5.feed_reaction_anim;
                        LottieAnimationView lottieAnimationView = (LottieAnimationView) AbstractC11738dW7.a(view, i);
                        if (lottieAnimationView != null) {
                            i = AbstractC12808fC5.feed_state_container_video;
                            FrameLayout frameLayout2 = (FrameLayout) AbstractC11738dW7.a(view, i);
                            if (frameLayout2 != null) {
                                i = AbstractC12808fC5.feed_state_video_iv;
                                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                                if (imageView != null) {
                                    i = AbstractC12808fC5.feed_video_container;
                                    AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) AbstractC11738dW7.a(view, i);
                                    if (aspectRatioFrameLayout != null) {
                                        i = AbstractC12808fC5.feed_video_thumbnail;
                                        ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                                        if (imageView2 != null) {
                                            i = AbstractC12808fC5.feed_video_volume;
                                            ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                                            if (imageView3 != null) {
                                                i = AbstractC12808fC5.txtSeeMoreContent;
                                                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                                                if (textView != null) {
                                                    i = AbstractC12808fC5.txtShowAgain;
                                                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                                    if (textView2 != null) {
                                                        i = AbstractC12808fC5.video_surface_view;
                                                        TextureView textureView = (TextureView) AbstractC11738dW7.a(view, i);
                                                        if (textureView != null) {
                                                            return new C5211Ij2((ConstraintLayout) view, viewA, frameLayout, linearLayout, circleProgressBar, lottieAnimationView, frameLayout2, imageView, aspectRatioFrameLayout, imageView2, imageView3, textView, textView2, textureView);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
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
