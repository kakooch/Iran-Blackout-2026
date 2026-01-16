package ir.nasim;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.shimmer.ShimmerFrameLayout;
import ir.nasim.components.appbar.view.BaleToolbar;

/* renamed from: ir.nasim.ni2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C17874ni2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ShimmerFrameLayout b;
    public final ShimmerFrameLayout c;
    public final ImageView d;
    public final ShimmerFrameLayout e;
    public final ShimmerFrameLayout f;
    public final ShimmerFrameLayout g;
    public final ShimmerFrameLayout h;
    public final BaleToolbar i;

    private C17874ni2(ConstraintLayout constraintLayout, ShimmerFrameLayout shimmerFrameLayout, ShimmerFrameLayout shimmerFrameLayout2, ImageView imageView, ShimmerFrameLayout shimmerFrameLayout3, ShimmerFrameLayout shimmerFrameLayout4, ShimmerFrameLayout shimmerFrameLayout5, ShimmerFrameLayout shimmerFrameLayout6, BaleToolbar baleToolbar) {
        this.a = constraintLayout;
        this.b = shimmerFrameLayout;
        this.c = shimmerFrameLayout2;
        this.d = imageView;
        this.e = shimmerFrameLayout3;
        this.f = shimmerFrameLayout4;
        this.g = shimmerFrameLayout5;
        this.h = shimmerFrameLayout6;
        this.i = baleToolbar;
    }

    public static C17874ni2 a(View view) {
        int i = AbstractC12808fC5.caption_placeholder;
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) AbstractC11738dW7.a(view, i);
        if (shimmerFrameLayout != null) {
            i = AbstractC12808fC5.feed_join_button;
            ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) AbstractC11738dW7.a(view, i);
            if (shimmerFrameLayout2 != null) {
                i = AbstractC12808fC5.feed_option_menu;
                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView != null) {
                    i = AbstractC12808fC5.subcount_placeholder;
                    ShimmerFrameLayout shimmerFrameLayout3 = (ShimmerFrameLayout) AbstractC11738dW7.a(view, i);
                    if (shimmerFrameLayout3 != null) {
                        i = AbstractC12808fC5.suggester_placeholder;
                        ShimmerFrameLayout shimmerFrameLayout4 = (ShimmerFrameLayout) AbstractC11738dW7.a(view, i);
                        if (shimmerFrameLayout4 != null) {
                            i = AbstractC12808fC5.tag_placeholder;
                            ShimmerFrameLayout shimmerFrameLayout5 = (ShimmerFrameLayout) AbstractC11738dW7.a(view, i);
                            if (shimmerFrameLayout5 != null) {
                                i = AbstractC12808fC5.title_highlight;
                                ShimmerFrameLayout shimmerFrameLayout6 = (ShimmerFrameLayout) AbstractC11738dW7.a(view, i);
                                if (shimmerFrameLayout6 != null) {
                                    i = AbstractC12808fC5.toolbar_placeholder;
                                    BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                                    if (baleToolbar != null) {
                                        return new C17874ni2((ConstraintLayout) view, shimmerFrameLayout, shimmerFrameLayout2, imageView, shimmerFrameLayout3, shimmerFrameLayout4, shimmerFrameLayout5, shimmerFrameLayout6, baleToolbar);
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
