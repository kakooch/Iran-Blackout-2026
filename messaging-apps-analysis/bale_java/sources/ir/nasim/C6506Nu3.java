package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.facebook.shimmer.ShimmerFrameLayout;

/* renamed from: ir.nasim.Nu3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6506Nu3 implements InterfaceC9764aW7 {
    private final View a;
    public final ShimmerFrameLayout b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;

    private C6506Nu3(View view, ShimmerFrameLayout shimmerFrameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2) {
        this.a = view;
        this.b = shimmerFrameLayout;
        this.c = appCompatImageView;
        this.d = appCompatImageView2;
    }

    public static C6506Nu3 a(View view) {
        int i = BC5.frShimmer;
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) AbstractC11738dW7.a(view, i);
        if (shimmerFrameLayout != null) {
            i = BC5.ivPlaceholder;
            AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
            if (appCompatImageView != null) {
                i = BC5.ivSticker;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                if (appCompatImageView2 != null) {
                    return new C6506Nu3(view, shimmerFrameLayout, appCompatImageView, appCompatImageView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C6506Nu3 b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(AbstractC12208eD5.layout_sticker_view, viewGroup);
        return a(viewGroup);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    public View getRoot() {
        return this.a;
    }
}
