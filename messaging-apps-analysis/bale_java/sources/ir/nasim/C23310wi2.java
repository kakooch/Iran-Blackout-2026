package ir.nasim;

import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import ir.nasim.features.conversation.messages.content.CircleProgressBar;

/* renamed from: ir.nasim.wi2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C23310wi2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final AspectRatioFrameLayout b;
    public final ImageView c;
    public final TextureView d;
    public final CircleProgressBar e;
    public final FrameLayout f;
    public final ImageView g;
    public final FrameLayout h;
    public final ImageView i;

    private C23310wi2(ConstraintLayout constraintLayout, AspectRatioFrameLayout aspectRatioFrameLayout, ImageView imageView, TextureView textureView, CircleProgressBar circleProgressBar, FrameLayout frameLayout, ImageView imageView2, FrameLayout frameLayout2, ImageView imageView3) {
        this.a = constraintLayout;
        this.b = aspectRatioFrameLayout;
        this.c = imageView;
        this.d = textureView;
        this.e = circleProgressBar;
        this.f = frameLayout;
        this.g = imageView2;
        this.h = frameLayout2;
        this.i = imageView3;
    }

    public static C23310wi2 a(View view) {
        int i = AbstractC12808fC5.aspectRatioFrameLayout;
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) AbstractC11738dW7.a(view, i);
        if (aspectRatioFrameLayout != null) {
            i = AbstractC12808fC5.feed_play_pause;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = AbstractC12808fC5.feed_player_view;
                TextureView textureView = (TextureView) AbstractC11738dW7.a(view, i);
                if (textureView != null) {
                    i = AbstractC12808fC5.feed_progress_video;
                    CircleProgressBar circleProgressBar = (CircleProgressBar) AbstractC11738dW7.a(view, i);
                    if (circleProgressBar != null) {
                        i = AbstractC12808fC5.feed_state_container_video;
                        FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
                        if (frameLayout != null) {
                            i = AbstractC12808fC5.feed_state_video_iv;
                            ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                            if (imageView2 != null) {
                                i = AbstractC12808fC5.feed_video_container;
                                FrameLayout frameLayout2 = (FrameLayout) AbstractC11738dW7.a(view, i);
                                if (frameLayout2 != null) {
                                    i = AbstractC12808fC5.feed_video_thumbnail;
                                    ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                                    if (imageView3 != null) {
                                        return new C23310wi2((ConstraintLayout) view, aspectRatioFrameLayout, imageView, textureView, circleProgressBar, frameLayout, imageView2, frameLayout2, imageView3);
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
