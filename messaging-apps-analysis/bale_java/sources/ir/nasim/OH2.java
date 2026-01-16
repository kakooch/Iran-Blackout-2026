package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import ir.nasim.features.smiles.widget.GifPreviewImageView;

/* loaded from: classes5.dex */
public final class OH2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final GifPreviewImageView b;
    public final ImageView c;
    public final LinearLayout d;

    private OH2(LinearLayout linearLayout, GifPreviewImageView gifPreviewImageView, ImageView imageView, LinearLayout linearLayout2) {
        this.a = linearLayout;
        this.b = gifPreviewImageView;
        this.c = imageView;
        this.d = linearLayout2;
    }

    public static OH2 a(View view) {
        int i = BC5.img_gif_preview;
        GifPreviewImageView gifPreviewImageView = (GifPreviewImageView) AbstractC11738dW7.a(view, i);
        if (gifPreviewImageView != null) {
            i = BC5.img_swipe_up;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                return new OH2(linearLayout, gifPreviewImageView, imageView, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static OH2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.gif_preview_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
