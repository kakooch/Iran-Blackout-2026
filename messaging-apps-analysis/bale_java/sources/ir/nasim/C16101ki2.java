package ir.nasim;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.github.chrisbanes.photoview.PhotoView;
import ir.nasim.features.conversation.messages.content.CircleProgressBar;

/* renamed from: ir.nasim.ki2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C16101ki2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final FrameLayout b;
    public final CircleProgressBar c;
    public final FrameLayout d;
    public final ImageView e;
    public final PhotoView f;

    private C16101ki2(ConstraintLayout constraintLayout, FrameLayout frameLayout, CircleProgressBar circleProgressBar, FrameLayout frameLayout2, ImageView imageView, PhotoView photoView) {
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = circleProgressBar;
        this.d = frameLayout2;
        this.e = imageView;
        this.f = photoView;
    }

    public static C16101ki2 a(View view) {
        int i = AbstractC12808fC5.feed_image_parent;
        FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
        if (frameLayout != null) {
            i = AbstractC12808fC5.feed_progress_photo;
            CircleProgressBar circleProgressBar = (CircleProgressBar) AbstractC11738dW7.a(view, i);
            if (circleProgressBar != null) {
                i = AbstractC12808fC5.feed_state_container_photo;
                FrameLayout frameLayout2 = (FrameLayout) AbstractC11738dW7.a(view, i);
                if (frameLayout2 != null) {
                    i = AbstractC12808fC5.feed_state_photo_iv;
                    ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView != null) {
                        i = AbstractC12808fC5.image_container;
                        PhotoView photoView = (PhotoView) AbstractC11738dW7.a(view, i);
                        if (photoView != null) {
                            return new C16101ki2((ConstraintLayout) view, frameLayout, circleProgressBar, frameLayout2, imageView, photoView);
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
