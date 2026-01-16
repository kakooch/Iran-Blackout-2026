package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.shimmer.ShimmerFrameLayout;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.gallery.widget.GalleryCheckBox;

/* renamed from: ir.nasim.bD2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C10182bD2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final BubbleTextView b;
    public final ImageView c;
    public final GalleryCheckBox d;
    public final ShimmerFrameLayout e;

    private C10182bD2(ConstraintLayout constraintLayout, BubbleTextView bubbleTextView, ImageView imageView, GalleryCheckBox galleryCheckBox, ShimmerFrameLayout shimmerFrameLayout) {
        this.a = constraintLayout;
        this.b = bubbleTextView;
        this.c = imageView;
        this.d = galleryCheckBox;
        this.e = shimmerFrameLayout;
    }

    public static C10182bD2 a(View view) {
        int i = AbstractC11556dC5.durationTextView;
        BubbleTextView bubbleTextView = (BubbleTextView) AbstractC11738dW7.a(view, i);
        if (bubbleTextView != null) {
            i = AbstractC11556dC5.imageview;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = AbstractC11556dC5.selectionCheckBox;
                GalleryCheckBox galleryCheckBox = (GalleryCheckBox) AbstractC11738dW7.a(view, i);
                if (galleryCheckBox != null) {
                    i = AbstractC11556dC5.shimmerFrameLayout;
                    ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) AbstractC11738dW7.a(view, i);
                    if (shimmerFrameLayout != null) {
                        return new C10182bD2((ConstraintLayout) view, bubbleTextView, imageView, galleryCheckBox, shimmerFrameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C10182bD2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(FC5.gallery_item, viewGroup, false);
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
