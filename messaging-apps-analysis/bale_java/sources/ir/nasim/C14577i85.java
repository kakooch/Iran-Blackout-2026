package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.card.MaterialCardView;

/* renamed from: ir.nasim.i85, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C14577i85 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final MaterialCardView b;
    public final ImageView c;
    public final ShimmerFrameLayout d;
    public final AppCompatImageView e;
    public final TextView f;
    public final LinearLayout g;

    private C14577i85(ConstraintLayout constraintLayout, MaterialCardView materialCardView, ImageView imageView, ShimmerFrameLayout shimmerFrameLayout, AppCompatImageView appCompatImageView, TextView textView, LinearLayout linearLayout) {
        this.a = constraintLayout;
        this.b = materialCardView;
        this.c = imageView;
        this.d = shimmerFrameLayout;
        this.e = appCompatImageView;
        this.f = textView;
        this.g = linearLayout;
    }

    public static C14577i85 a(View view) {
        int i = AbstractC12808fC5.card;
        MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
        if (materialCardView != null) {
            i = AbstractC12808fC5.image_view;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = AbstractC12808fC5.image_view_shimmer;
                ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) AbstractC11738dW7.a(view, i);
                if (shimmerFrameLayout != null) {
                    i = AbstractC12808fC5.img_video;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                    if (appCompatImageView != null) {
                        i = AbstractC12808fC5.txt_duration;
                        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView != null) {
                            i = AbstractC12808fC5.video_detail_container;
                            LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                            if (linearLayout != null) {
                                return new C14577i85((ConstraintLayout) view, materialCardView, imageView, shimmerFrameLayout, appCompatImageView, textView, linearLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C14577i85 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(HC5.photo_content_item, viewGroup, false);
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
