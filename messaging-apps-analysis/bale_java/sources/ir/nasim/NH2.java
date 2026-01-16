package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.facebook.shimmer.ShimmerFrameLayout;
import ir.nasim.designsystem.ImageViewCrossFade;

/* loaded from: classes5.dex */
public final class NH2 implements InterfaceC9764aW7 {
    private final View a;
    public final ShimmerFrameLayout b;
    public final ImageViewCrossFade c;
    public final AppCompatImageView d;

    private NH2(View view, ShimmerFrameLayout shimmerFrameLayout, ImageViewCrossFade imageViewCrossFade, AppCompatImageView appCompatImageView) {
        this.a = view;
        this.b = shimmerFrameLayout;
        this.c = imageViewCrossFade;
        this.d = appCompatImageView;
    }

    public static NH2 a(View view) {
        int i = BC5.frame_shimmer;
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) AbstractC11738dW7.a(view, i);
        if (shimmerFrameLayout != null) {
            i = BC5.img_gif;
            ImageViewCrossFade imageViewCrossFade = (ImageViewCrossFade) AbstractC11738dW7.a(view, i);
            if (imageViewCrossFade != null) {
                i = BC5.img_place_holder;
                AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                if (appCompatImageView != null) {
                    return new NH2(view, shimmerFrameLayout, imageViewCrossFade, appCompatImageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static NH2 b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(AbstractC12208eD5.gif_preview_image_view, viewGroup);
        return a(viewGroup);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    public View getRoot() {
        return this.a;
    }
}
