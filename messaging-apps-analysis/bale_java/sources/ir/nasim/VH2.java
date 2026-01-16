package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.shimmer.ShimmerFrameLayout;
import ir.nasim.designsystem.GifViewCrossFade;

/* loaded from: classes5.dex */
public final class VH2 implements InterfaceC9764aW7 {
    private final View a;
    public final ShimmerFrameLayout b;
    public final GifViewCrossFade c;

    private VH2(View view, ShimmerFrameLayout shimmerFrameLayout, GifViewCrossFade gifViewCrossFade) {
        this.a = view;
        this.b = shimmerFrameLayout;
        this.c = gifViewCrossFade;
    }

    public static VH2 a(View view) {
        int i = BC5.frame_shimmer;
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) AbstractC11738dW7.a(view, i);
        if (shimmerFrameLayout != null) {
            i = BC5.img_gif;
            GifViewCrossFade gifViewCrossFade = (GifViewCrossFade) AbstractC11738dW7.a(view, i);
            if (gifViewCrossFade != null) {
                return new VH2(view, shimmerFrameLayout, gifViewCrossFade);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static VH2 b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(AbstractC12208eD5.gif_recycler_item_view, viewGroup);
        return a(viewGroup);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    public View getRoot() {
        return this.a;
    }
}
